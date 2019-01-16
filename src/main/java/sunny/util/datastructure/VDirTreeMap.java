package sunny.util.datastructure;

import java.io.Serializable;

import javax.naming.InitialContext;

/**
 * 通过Vtree来操作控制目录结构
 * 
 * @author lulf
 * @param <K>
 * @param <V>
 */
public class VDirTreeMap<K, V> implements Node<K, V> {
	
	//最初的根节点
	private TreeNode<K, V> root=null;
	
	private VDirTreeMap(){};
	
	/**
	 * 初始化树操作
	 * @param version
	 */
	public VDirTreeMap(int version){
		init();
	}

	private void init() {
		//1)从数据库中,把字节流获取出来
		
		//2)反序列化为VDirTreeMap对象
		
		//3)根据VDirTreeMap生成对应的目录
		
	}

	@Override
	public void add(K k, V v, TreeNode<K, V> parentNode, TreeNode<K, V>[] childNodes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(K k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(K k, V v, TreeNode<K, V> parentNode, TreeNode<K, V>[] childNodes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void get(K k) {
		// TODO Auto-generated method stub

	}

}
