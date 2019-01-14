package sunny.util.zookeeper;

/**
 * 定义最初的zk的dao接口
 * 
 * @author lulf
 */
public interface CommonDao {
	public void create(String path, String value);

	public String getNodeData(String path);

	public void deleteNode(String path);

	public void updateNode(String path, String value);
}
