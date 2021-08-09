//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 529 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：两个数组的交集 II
public class p350IntersectionOfTwoArraysIi {
	public static void main(String[] args) {
		//Test
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	static class Solution {
		public interface Map<K, V> {
			void add(K key, V value);

			V remove(K key);

			boolean contains(K key);

			V get(K key);

			void set(K key, V newValue);

			int getSize();

			boolean isEmpty();
		}

		public class AVLTree<K extends Comparable<K>, V> {
			private class Node {
				public K key;
				public V value;
				public Node left, right;
				public int height;

				public Node(K key, V value) {
					this.key = key;
					this.value = value;
					height = 1;
				}
			}

			private Node root;
			private int size;

			public AVLTree() {
				root = null;
				size = 0;
			}

			public int getSize() {
				return size;
			}

			public boolean isEmpty() {
				return size == 0;
			}

			//判断该二叉树是否仍是二分搜索树
			public boolean isBST() {
				ArrayList<K> list = new ArrayList<>();
				inOrder(root, list);
				for (int i = 0; i < list.size() - 1; i++) {
					if (list.get(i).compareTo(list.get(i + 1)) > 0)
						return false;
				}
				return true;
			}

			//中序遍历添加每个元素至list
			private void inOrder(Node node, List<K> list) {
				if (node == null)
					return;
				inOrder(node.left, list);
				list.add(node.key);
				inOrder(node.right, list);
			}

			public boolean isBalanced() {
				return isBalanced(root);
			}

			private boolean isBalanced(Node node) {
				if (node == null)
					return true;

				int balanceFactor = getBalanceFactor(node);
				if (Math.abs(balanceFactor) > 1)
					return false;
				//判断完当前节点还要看左右子节点(只有自己以及左右子树都满足才返回true)
				return isBalanced(node.left) && isBalanced(node.right);
			}

			//获得当前节点的树高度
			private int getHeight(Node node) {
				if (node == null)
					return 0;
				return node.height;
			}

			//获得当前节点的平衡因子
			private int getBalanceFactor(Node node) {
				if (node == null)
					return 0;
				return getHeight(node.left) - getHeight(node.right);

			}

			// 对节点y进行向右旋转操作，返回旋转后新的根节点x
			//    //        y                              x
			//    //       / \                           /   \
			//    //      x   T4     向右旋转 (y)        z     y
			//    //     / \       - - - - - - - ->    / \   / \
			//    //    z   T3                       T1  T2 T3 T4
			//    //   / \
			//    // T1   T2
			private Node rightRotate(Node y) {
				Node x = y.left;
				Node t3 = x.right;
				y.left = t3;
//		y.left=x.right;
				x.right = y;

				//维护height
				y.height = Math.max(getHeight(y.right), getHeight(y.left)) + 1;
				x.height = Math.max(getHeight(x.right), getHeight(x.left)) + 1;

				return x;
			}

			// 对节点y进行向左旋转操作，返回旋转后新的根节点x
			//    y                             x
			//  /  \                          /   \
			// T1   x      向左旋转 (y)       y     z
			//     / \   - - - - - - - ->   / \   / \
			//   T2  z                     T1 T2 T3 T4
			//      / \
			//     T3 T4
			private Node leftRotate(Node y) {
				Node x = y.right;
				Node t2 = x.left;
				y.right = t2;
				x.left = y;

				//维护height
				y.height = Math.max(getHeight(y.right), getHeight(y.left)) + 1;
				x.height = Math.max(getHeight(x.right), getHeight(x.left)) + 1;

				return x;
			}

			public void add(K key, V value) {
				root = add(root, key, value);
			}

			//在以node为根的树中添加K,V,返回添加完之后的根节点
			private Node add(Node node, K key, V value) {
				if (node == null) {
					size++;
					return new Node(key, value);
				}
				if (node.key.compareTo(key) > 0) {
					node.left = add(node.left, key, value);
				} else if (node.key.compareTo(key) < 0) {
					node.right = add(node.right, key, value);
				} else {    //相等
					node.value = value;
				}
				//更新height
				node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
				int balanceFactor = getBalanceFactor(node);
//		if (Math.abs((balanceFactor))>1)
//			System.out.println("unbalanced:"+balanceFactor);

				//LL 左子树高度大于右子树且(导致这个问题的新节点在当前节点左子树的左子树上)
				if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
					return rightRotate(node);

				//RR 右子树高度大于左子树且(导致这个问题的新节点在当前节点右子树的右子树上)
				if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
					return leftRotate(node);

				//LR
				if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
					node.left = leftRotate(node.left);
					return rightRotate(node);
				}
				//RL
				if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
					node.right = rightRotate(node.right);
					return leftRotate(node);
				}

				return node;
			}


			private Node getNode(Node node, K key) {
				if (node == null) {
					return null;
				}
				if (key.compareTo(node.key) < 0) {
					return getNode(node.left, key);
				} else if (key.compareTo(node.key) > 0) {
					return getNode(node.right, key);
				} else {
					return node;
				}
			}


			public boolean contains(K key) {
				return getNode(root, key) != null;
			}


			public V get(K key) {
				Node res = getNode(root, key);
				return res == null ? null : res.value;
			}


			public void set(K key, V newValue) {
				Node node = getNode(root, key);
				if (node == null) {
					throw new IllegalArgumentException(key + "does not exist!");
				}
				node.value = newValue;
			}

			//在以node为根的树中找到最小值的节点并返回
			//注意传入的node 要不为空 不然会空指针异常
			private Node minimum(Node node) {
				if (node.left == null) {
					return node;
				}
				return minimum(node.left);
			}

			//在以node为根的树中删除最小值节点
			//并返回删除后的树
			private Node removeMin(Node node) {
				if (node.left == null) {
					size--;
					return node.right;
				}
				node.left = removeMin(node.left);
				return node;
			}


			public V remove(K key) {
				Node node = getNode(root, key);
				if (node != null) {
					root = remove(root, key);
					return node.value;
				}
				return null;
			}

			// 在以node为根的树中 删除值为key的节点 并返回删除后的树
			private Node remove(Node node, K key) {
				if (node == null) {
					return null;
				}
				Node retNode = null;
				if (node.key.compareTo(key) > 0) {
					node.left = remove(node.left, key);
					retNode = node;
				} else if (node.key.compareTo(key) < 0) {
					node.right = remove(node.right, key);
					retNode = node;
				} else {
					if (node.right == null) {    // 注意维护size;!!!!
						size--;
						retNode = node.left;
					} else if (node.left == null) {
						size--;
						retNode = node.right;
					} else {
						Node successor = minimum(node.right);

//				successor.left = node.left;
						//这句话要写在下面 因为如果 node.right的最小值就是他自己
						//即successor就是node.right
						//那么上面这局也会导致node.right.left指向node.right
						//就导致下面remove操作实际操作的不是原node.right
						//而是增加了node.right.left之后的操作
						//会出问题
//				System.out.println(successor.left);
//				System.out.println(node.right.left);
						//上面2句结果一样 这是肯定的
						//因为left是属性,这种浅拷贝(successor)修改了属性,原来的(node.right)肯定也会被修改

						//successor.right = removeMin(node.right);
						//消除了removeMin 导致的无法更新节点高度和平衡的问题
						//这样删除最小值也是通过调用这个remove得到的
						//保证了整个过程一直维护了AVL树的平衡
						successor.right = remove(node.right, successor.key);

						successor.left = node.left;


						node.left = node.right = null;

						retNode = successor;
					}
				}
				//若删除完retNode为空 直接return 避免下面.height空指针异常
				if (retNode == null)
					return null;

				//每次remove完更新节点高度
				retNode.height = Math.max(getHeight(retNode.left), getHeight(retNode.right)) + 1;

				int balanceFactor = getBalanceFactor(retNode);

				//LL
				if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
					return rightRotate(retNode);
				//RR
				if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
					return leftRotate(retNode);
				//LR
				if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
					retNode.left = leftRotate(retNode.left);
					return rightRotate(retNode);
				}

				//RL
				if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
					retNode.right = rightRotate(retNode.right);
					return leftRotate(retNode);
				}

				return retNode;
			}

		}

		public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {
			private AVLTree<K, V> avlTree;

			public AVLMap() {
				avlTree = new AVLTree<>();
			}

			@Override
			public void add(K key, V value) {
				avlTree.add(key, value);
			}

			@Override
			public V remove(K key) {
				return avlTree.remove(key);
			}

			@Override
			public boolean contains(K key) {
				return avlTree.contains(key);
			}

			@Override
			public V get(K key) {
				return avlTree.get(key);
			}

			@Override
			public void set(K key, V newValue) {
				avlTree.set(key, newValue);
			}

			@Override
			public int getSize() {
				return avlTree.getSize();
			}

			@Override
			public boolean isEmpty() {
				return avlTree.isEmpty();
			}
		}

		public int[] intersect(int[] nums1, int[] nums2) {
			AVLMap<Integer,Integer> map = new AVLMap();
			for (int i : nums1) {
				if (map.contains(i)) {
					map.set(i, map.get(i) + 1);
				}else {
					map.add(i,1);
				}
			}

			ArrayList<Integer> list = new ArrayList<>();
			for (int i : nums2) {
				if (map.contains(i)) {
					list.add(i);
					if (map.get(i)>0){
						map.set(i,map.get(i)-1);
					}
					if (map.get(i)==0)
						map.remove(i);
				}
			}
			int[] res = new int[list.size()];
			int index = 0;
			for (Integer i : list) {
				res[index++] = i;
			}
			return res;

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*
 *@jackpoit
 *@date 2021-08-09 12:02:55
 */