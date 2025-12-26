class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int penalty = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'N') penalty++;
        }
        
        int minPenalty = penalty;
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y')
                penalty--;   
            else
                penalty++;  
            
            if (penalty < minPenalty) {
                minPenalty = penalty;
                ans = i + 1;
            }
        }
        
        return ans;
    }
}
