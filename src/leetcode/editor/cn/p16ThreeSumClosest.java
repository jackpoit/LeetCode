//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 794 👎 0


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

//Java：最接近的三数之和
public class p16ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new p16ThreeSumClosest().new Solution();
        // TO TEST
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=100000;
        Arrays.sort(nums);
        int n=nums.length;
        for (int first=0;first<n;first++){
            if (first>0&&nums[first]==nums[first-1]){
                continue;
            }
            int third=n-1;
            int second=first+1;
            while (second<third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum==target){
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(ans-target)) {
                    ans=sum;
                }
                if (sum>target){
                    int t=third-1;
                    while (t>second&&nums[t]==nums[t+1]){
                            t--;
                    }
                    third=t;
                }
                if (sum<target){
                    int s=second+1;
                    while (s<third&&nums[s]==nums[s-1]){
                        s++;
                    }
                    second=s;
                }

            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/*
 *@jackpoit
 *@date 2021-06-08 09:18:06
 */