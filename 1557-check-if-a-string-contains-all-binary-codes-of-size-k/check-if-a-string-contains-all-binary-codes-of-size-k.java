class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if(n-k+1 < (1 << k)){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        int num = 0;
        for(int i=0;i<k;i++){
            num = (num << 1)+ (s.charAt(i) - '0');
        }
        set.add(num);
        int mask = (1 << k) - 1;
        for(int i=k;i<n;i++){
            num = ((num << 1) & mask) + (s.charAt(i) - '0');
            set.add(num);
        }
        return set.size() == (1 << k);
    }
}