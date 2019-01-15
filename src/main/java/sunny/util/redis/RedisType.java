package sunny.util.redis;

public enum RedisType {

	STRING("字符"), HASHSET("散列"), LIST("列表"), SET("无序集合"), ZSET("有序集合");

	private String name;

	RedisType(String name) {
		this.name = name();
	}

	public String getName() {
		return name;
	}
}
