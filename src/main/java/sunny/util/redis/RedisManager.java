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

	// 默认是本地
	private static String DEFAULTIP = "localhost";

	// 默认端口是6379
	private static int port = 6379;

	public static Jedis getJedis() throws Exception {
		return getJedis(DEFAULTIP, port);
	}

	public static Jedis getJedis(String DEFAULTIP, int port) throws Exception {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(20);
		jedisPoolConfig.setMaxIdle(10);
		jedisPool = new JedisPool(jedisPoolConfig, DEFAULTIP, port);
		if (jedisPool != null) {
			return jedisPool.getResource();
		}
		throw new Exception("Jedis is null");
	}
}
