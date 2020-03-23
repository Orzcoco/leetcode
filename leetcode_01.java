class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        //利用hashMap，把数值当成key，索引当成value。遍历一遍按顺序添加到map中
        //如果nums[i]==nums[j],后面的会覆盖前面的key，索引只有后面的索引，没关系
        //nums[i]遍历的时候会拿到，如果第二个数是nums[j]也可以拿到，只有一个答案，其他不用考虑
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++)
        {
            //第二个条件你要排除掉nums[i]和nums[j]中i==j
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i)
            {
                return new int[]{i,map.get(target-nums[i])} ; 
            }
        }
        throw new IllegalArgumentException("no result");
    }
}