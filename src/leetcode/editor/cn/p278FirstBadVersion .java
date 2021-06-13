
//你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有
//版本都是错的。 
//
// 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。 
//
// 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误
//的版本。你应该尽量减少对调用 API 的次数。 
//
// 示例: 
//
// 给定 n = 5，并且 version = 4 是第一个错误的版本。
//
//调用 isBadVersion(3) -> false
//调用 isBadVersion(5) -> true
//调用 isBadVersion(4) -> true
//
//所以，4 是第一个错误的版本。  
// Related Topics 二分查找 
// 👍 332 👎 0

package leetcode.editor.cn;
//第一个错误的版本
class p278FirstBadVersion{
    public static void main(String[] args) {
        Solution solution = new p278FirstBadVersion().new Solution();
        // TO TEST
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left=0;
        int right=n-1;
        while (left<=right) { //left<right
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)){
                left=mid+1;
            }else {
                right=mid-1;//right =mid  这个配合上面的可以减少一次判断 但全是好的零件就会判断出错！
            }
        }

        //最后left=right时 left之前肯定是好的所以left才能移动到这
        //同样 right后面都是坏的，它在能移动到这
        //最后一次判断 这个如果是好的 left移动到下一个 也是第一个坏的 也就是答案
        //           如果这个是坏的，前面都是好的所以这个点也就是left是答案，right前移一个正好打破循环
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/*
 *@jackpoit
 *@date 2021-06-13 23:39:47	
 */