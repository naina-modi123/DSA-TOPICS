class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()){
            return s;
        }
        int idx = 0, dir = 1;
        List<Character>[] rows = new ArrayList[numRows];
        for(int i=0;i<numRows;i++){
            rows[i] = new ArrayList<>();
        }
        for(char ch : s.toCharArray()){
            rows[idx].add(ch);
            if(idx == 0){
                dir = 1;
            }else if(idx == numRows - 1){
                dir = -1;
            }
            idx += dir;
        }
        StringBuilder ans = new StringBuilder();
        for(List<Character> row : rows){
            for(char c : row){
                ans.append(c);
            }
        }
        return ans.toString();
        
    }
}