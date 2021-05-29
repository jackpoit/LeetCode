//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 922 👎 0

package leetcode.editor.cn;
//搜索插入位置
class p35SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new p35SearchInsertPosition().new Solution();
        // TO TEST
        int[] nums={1,3,5,6};
        System.out.println(solution.searchInsert(nums,2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            if (target<=nums[i]){
                return i;
            }
        }
        if (nums.length!=0){
            return nums.length;
        }else {
            return 0;
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/*
 *@jackpoit
 *@date 2021-05-28 22:29:19	
 */