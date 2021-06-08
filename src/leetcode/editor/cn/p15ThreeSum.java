//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3401 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class p15ThreeSum{
    public static void main(String[] args) {
        Solution solution = new p15ThreeSum().new Solution();
        // TO TEST
        int[] nums=new int[]{-2,1,1,4};
        System.out.println(solution.threeSum(nums));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int n=nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<List<Integer>>();

            for (int first=0;first<n;first++){
                if (first>0&&nums[first]==nums[first-1]){
                    continue;
                }

                int third=n-1;
                int target=-nums[first];
                for (int second=first+1;second<n;second++){
                    if (second>first+1&&nums[second]==nums[second-1]){
                        continue;
                    }
                    while (second<third&&nums[second]+nums[third]>target){
                        third--;
                    }
                    //second<third判定条件保证不重复
                    if (second==third){
                        break;
                    }
                    if (nums[second] + nums[third] == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
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
 *@date 2021-06-07 16:07:35
 */