//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 156 👎 0

package leetcode.editor.cn;
//反转字符串中的元音字母
class p345ReverseVowelsOfAString{
    public static void main(String[] args) {
        Solution solution = new p345ReverseVowelsOfAString().new Solution();
        // TO TEST
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        int left=0;
        int right=s.length()-1;
        char[] arr=s.toCharArray();
        String str="aeiouAEIOU";
        while (left<right){
            if (str.indexOf(arr[left])==-1){
                left++;
                continue;
            }
            if (str.indexOf(arr[right])==-1){
                right++;
                continue;
            }
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

        }
        return new String(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/*
 *@jackpoit
 *@date 2021-06-02 23:41:57	
 */