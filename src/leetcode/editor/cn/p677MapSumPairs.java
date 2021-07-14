//实现一个 MapSum 类，支持两个方法，insert 和 sum： 
//
// 
// MapSum() 初始化 MapSum 对象 
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 ke
//y 已经存在，那么原来的键值对将被替代成新的键值对。 
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key 和 prefix 仅由小写英文字母组成 
// 1 <= val <= 1000 
// 最多调用 50 次 insert 和 sum 
// 
// Related Topics 设计 字典树 哈希表 字符串 
// 👍 91 👎 0


package leetcode.editor.cn;

import java.util.TreeMap;

//Java：键值映射
public class p677MapSumPairs {
	public static void main(String[] args) {
		Solution solution = new p677MapSumPairs().new Solution();
		//Test
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class MapSum {
		private class Node {
			public int val;
			public TreeMap<Character, Node> next;

			public Node(int val) {
				this.val = val;
				next = new TreeMap<>();
			}

			public Node() {
				this(0);
			}
		}

		private Node root;

		/**
		 * Initialize your data structure here.
		 */
		public MapSum() {
			root = new Node();
		}

		public void insert(String key, int val) {
			Node cur = root;
			for (int i = 0; i < key.length(); i++) {
				char c = key.charAt(i);
				if (cur.next.get(c) == null)
					cur.next.put(c, new Node());
				cur = cur.next.get(c);
			}
			cur.val = val;
		}

		public int sum(String prefix) {
			Node cur = root;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				if (cur.next.get(c) == null)
					return 0;
				cur = cur.next.get(c);
			}
			return sum(cur);
		}

		private int sum(Node node) {
			if (node.next.isEmpty())
				return node.val;
			//可以不写上面的判断  因为如果node.next是空 下面的循环不会进行 之间就return node.val了

			int res = node.val;
			for (char c : node.next.keySet())
				res += sum(node.next.get(c));

			return res;
		}
	}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
/*
 *@jackpoit
 *@date 2021-07-15 00:07:05
 */