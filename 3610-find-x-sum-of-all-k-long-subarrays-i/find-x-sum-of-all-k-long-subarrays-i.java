class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int res[] = new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=i;j<i+k;j++){
                map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            }
            if(map.size() <= x){
                int sum = 0;
                for(int j=i;j<i+k;j++){
                    sum += nums[j];
                }
                res[i] = sum;
            }
            else{
                List<Map.Entry<Integer, Integer>> pairs = new ArrayList<>(map.entrySet());
                Collections.sort(pairs, new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                        if (!a.getValue().equals(b.getValue())) {
                            return b.getValue() - a.getValue();
                        }
                        return b.getKey() - a.getKey();
                    }
                });
                int curSum = 0;
                for (int j = 0; j < x; j++) {
                    int num = pairs.get(j).getKey();
                    int freq = pairs.get(j).getValue();
                    curSum += num * freq;
                }
                res[i] = curSum;
            }
        }
        return res;

       
    }
}