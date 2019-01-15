package sunny.util.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * RedisManager
 * 
 * @author lulf
 */
public class RedisManager {
	private static JedisPool jedisPool;

	private static Jedis jedis;

	// 默认是本地
	private static String DEFAULTIP = "localhost";

	// 默认端口是6379
	private static int port = 6379;

	/**
	 * 初始化Jedis
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Jedis getJedis() throws Exception {
		return getJedis(DEFAULTIP, port);
	}

	/**
	 * 初始化Jedis
	 * 
	 * @param DEFAULTIP
	 * @param port
	 * @return
	 * @throws Exception
	 */
	public static Jedis getJedis(String DEFAULTIP, int port) throws Exception {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 最大连接数
		jedisPoolConfig.setMaxTotal(20);
		// 最小连接数
		jedisPoolConfig.setMaxIdle(10);
		jedisPool = new JedisPool(jedisPoolConfig, DEFAULTIP, port);
		if (jedisPool != null) {
			jedis = jedisPool.getResource();
			return jedis;
		}
		throw new Exception("Jedis is null");
	}
}
