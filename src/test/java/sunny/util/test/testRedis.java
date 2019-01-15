package sunny.util.test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import sunny.util.redis.RedisManager;

public class testRedis {
	
	@Test
	public void test() throws Exception{
		//初始化jedis连接
		Jedis jedis=new RedisManager().getJedis("192.168.157.128", 6379);
		//字符类型的存储删
		jedis.set("username", "allen");
		jedis.get("allen");
		jedis.del("allen");
	    //散列类型的存储删
		jedis.hset("Allen", "id", "A001");
		jedis.hset("Allen", "age", "18");
		jedis.hdel("Allen", "age");
		jedis.hget("Allen", "id");
		//列表类型的存储删
		jedis.lpush("Allen", "1","2","3","4");
		List<String> lrange=jedis.lrange("Allen", 0, -1);//-1代表右边的第一个元素
		jedis.lset("Allen", 0, "01");
		jedis.lpop("Allen");//左边弹出
		jedis.rpop("Allen");//右边弹出
		jedis.llen("Allen");//返回类表的长度
		//无序集合的存储删
		jedis.sadd("test", "1","2","3","4");
		Set<String> smembers = jedis.smembers("test");
		jedis.scard("test");//长度
		jedis.srem("test", "1");//删除指定
		jedis.sismember("test", "2");//boolean型，判断是否存在2这个元素
		//有序集合的存储删
		HashMap<String, Double>hashMap=new HashMap<String, Double>();
		hashMap.put("a1", (double)1);
		hashMap.put("a2", (double)2);
		hashMap.put("a3", (double)3);
		jedis.zadd("map", hashMap);
		jedis.zscore("map", "a1"); //获取
		jedis.zcard("map");//获取数量
		jedis.zrem("map", "a1");//删除	
	}
}
