package binarysearch;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] nums={1,2,3,3,3,3,3,3,3,3,3,3,4,5,6,7,8,9,10,12};
        System.out.println(binarySearch(nums,3));
        //test
    }
    public static int binarySearch(int[] nums,int target){
        int left=0;
        int right=nums.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;
            if (target>nums[mid]){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }
     //如果target在数组中重复如例中的3
    //上述 条件为target>nums[mid]，会返回第一个数的索引值，
    // 因为 mid肯定会在某一刻移到3上，那么就满足了target<=nus[mid]的条件即right=mid-1;
    //right 和mid会一直左移至第一个 3上，left最终也会到3上，最后就返回第一个3的索引

    //反过来 如果条件为target>=nums[mid]，就会返回最后一个3的索引值

    //2分法 如果一直执行下去，肯定会有一个瞬间，left=right=mid
}
