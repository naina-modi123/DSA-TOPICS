class Solution {
    public int commonFactors(int a, int b) {
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i=1;i<=Math.min(a, b);i++){
            if(a % i == 0 && b % i == 0){
                list1.add(i);
            }
        }
        return list1.size(); 
    }
}