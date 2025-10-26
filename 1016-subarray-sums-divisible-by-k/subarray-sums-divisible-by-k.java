class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer , Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        int sum = 0, divi = 0, count = 0;
        for(int num : nums){
            sum += num;
            divi = sum%k;
            if(divi < 0) divi += k;
            if(mpp.containsKey(divi)){
                count += mpp.get(divi);
            }
            mpp.put(divi , mpp.getOrDefault(divi , 0)+1);
        }
        return count;
    }
}