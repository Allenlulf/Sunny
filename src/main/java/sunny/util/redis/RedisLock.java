package sunny.util.redis;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * 分布式锁
 * 
 * @author lulf
 */
public class RedisLock {

	/**
	 *获取锁【不含过期时间】
	 * @param key
	 * @return
	 */
	public String getLock(String key) {
		return getLock(key, -1);
	}

	/**
	 * 获取锁【含过期时间】
	 * 
	 * @param key
	 *            键
	 * @param timeout
	 *            毫秒級
	 * @return
	 */
	public String getLock(String key, int timeout) {
		try {
			Jedis jedis = RedisManager.getJedis();
			String value = UUID.randomUUID().toString();
			// 超时时间
			long end = System.currentTimeMillis() + timeout;
			while (System.currentTimeMillis() < end) {// 阻塞
				if (jedis.setnx(key, value) == 1) {
					if (timeout != -1) {
						jedis.expire(key, timeout);// 过期时间
					}
					// 锁设置成功
					return value;
				}
				if (jedis.ttl(key) == -1) {// 检测过期时间
					jedis.expire(key, timeout);
				}
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 释放锁
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @return
	 */
	public boolean releaseLock(String key, String value) {
		try {
			Jedis jedis = RedisManager.getJedis();
			while (true) {
				jedis.watch(key);
				// 判断获取锁的线程和当前redis中的锁是同一个
				if (value.equals(jedis.get(key))) {
					// 获取事务
					Transaction transaction = jedis.multi();
					transaction.del(key);
					List<Object> list = transaction.exec();
					if (list == null) {
						continue;
					}
					return true;
				}
				jedis.unwatch();
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
