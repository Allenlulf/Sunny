package sunny.util.datastructure;

/**
 * 文件系统的数据结构【多叉树】
 * 
 * @author lulf
 * @param <K>
 * @param <V>
 */
public class TreeNode<K, V> {
	K k;//文件名
	V v;//文件的具体io流
	TreeNode<K, V> parentNode; //父节点
	TreeNode<K, V>[] childNodes; //子节点集合

	public TreeNode(K k, V v, TreeNode<K, V> parentNode, TreeNode<K, V>[] childNodes) {
		this.k = k;
		this.v = v;
		this.parentNode = parentNode;
		this.childNodes = childNodes;
	}
	
	public K getkey(){
		return k;
	}

	public V getValue() {
		return v;
	}

	public TreeNode<K, V> getParentNode() {
		return parentNode;
	}

	public TreeNode<K, V>[] getChildNodes() {
		return childNodes;
	}
}
