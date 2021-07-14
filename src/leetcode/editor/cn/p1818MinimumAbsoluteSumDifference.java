//给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。 
//
// 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始
//）。 
//
// 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。 
//
// 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。 
//
// |x| 定义为： 
//
// 
// 如果 x >= 0 ，值为 x ，或者 
// 如果 x <= 0 ，值为 -x 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,7,5], nums2 = [2,3,5]
//输出：3
//解释：有两种可能的最优方案：
//- 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
//- 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
//两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
//输出：0
//解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
//输出：20
//解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
//绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// 1 <= n <= 105 
// 1 <= nums1[i], nums2[i] <= 105 
// 
// Related Topics 贪心 数组 二分查找 有序集合 
// 👍 87 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：绝对差值和
public class p1818MinimumAbsoluteSumDifference {
	public static void main(String[] args) {
		Solution solution = new p1818MinimumAbsoluteSumDifference().new Solution();
		//Test
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
			final int mod = 1000000007;
			int sum = 0;
			int[] sorted = nums1.clone();
			Arrays.sort(sorted);       //备份一个排过序的num1数组
			int max = 0;           //max表示替换后与替换前导致的最小化差值的最大值
			for (int i = 0; i < nums2.length; i++) {
				int divide = Math.abs(nums1[i] - nums2[i]);    //num1与num2第i个位置的差的绝对值
				sum = (sum + divide) % mod;                    //把绝对差值和先求出来 记得取模
				int changedDivide = binarySearch(sorted, nums2[i]);
				//对于每个num2[i] 用二分搜索得到替换num1中的数后得到的最小差的绝对值
				int cha = divide - changedDivide;    //相减得到替换导致的差值的减小(最坏的可能就是找不到,cha就是0)
				if (cha > max)                    //cha与max比较 更新对于每个num2[i] 替换num1后差值减小的最大值
					max = cha;
			}
			return (sum - max + mod) % mod;
			//因为res是%过mod的 所以如果不加 res-max可能是负数了
			//就存在一种可能性 res刚好去了模变得很小 但替换完减了的max很大 导致res-max变成负值 所以要加一下mod保证是正值
		}

		//二分搜索最接近 a的值 并返回差的绝对值
		public int binarySearch(int[] num, int a) {
			int left = 0;
			int right = num.length - 1;
			if (num[right] < a)
				return a - num[right];  //如果a>最大值 直接返回
			if (num[0] > a)
				return num[0] - a;      //a<最小值 也直接返回

			while (left < right) {
				int mid = left + (right - left) / 2;
				if (a == num[mid]) {
					return 0;           //如果相等 返回0
				}
				if (a > num[mid]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			return Math.min(Math.abs(a - num[left]), Math.abs(a - num[left - 1]));
			//对于最后得到的left  a一定小于left 所以要在 num[left-1] a 和 num[left] a之间找最小值再返回
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*
 *@jackpoit
 *@date 2021-07-14 22:47:53
 */