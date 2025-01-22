class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int m=n/2;
        int count=0;
        for(int i=0;i<n;i++)
        {
            count =0;
           for(int j=0;j<n;j++)
          {
            if(nums[i]==nums[j])
            {
                count++;
            }
          }
          if(count>m)
          {return nums[i];}
          
        }
        return -1;
    }
}