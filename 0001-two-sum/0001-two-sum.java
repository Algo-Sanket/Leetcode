class Solution {
    public int[] twoSum(int[] nums, int target)
    {
int res[] = new int[2];
ArrayList list = new ArrayList();

    for(int i=0;i<nums.length;i++){
        if(list.contains(target-nums[i])){
            res[1]=i;
            res[0]=list.indexOf(target-nums[i]);
            return res;
        }
        list.add(nums[i]);
    }
    
    return res;
    
}
        
}