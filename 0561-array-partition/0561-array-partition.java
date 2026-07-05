class Solution {
    public int arrayPairSum(int[] nums) {
        int n= nums.length;
        int pairs=n/2;

        int maxSum=0;

        Arrays.sort(nums);

        for(int i=n-1;i>0;i=i-2){
            if(i==0){
                break;
            }
            maxSum += Math.min(nums[i],nums[i-1]);
        }
        return maxSum;
    }
}