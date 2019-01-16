package sunny.util.datastructure;
/**
 * 定义基础的增删改查
 * @author lulf
 *
 * @param <K>
 * @param <V>
 */
public interface Node <K,V>{
	
	public void add(K k,V v,TreeNode<K, V> parentNode,TreeNode<K, V>[] childNodes);
	
	public void del(K k);
	
	public void update(K k,V v,TreeNode<K, V> parentNode,TreeNode<K, V>[] childNodes);
	
	public void get(K k);
}
