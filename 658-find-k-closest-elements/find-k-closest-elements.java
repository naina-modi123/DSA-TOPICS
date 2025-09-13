class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num:arr){
            list.add(num);
        }
        Collections.sort(list , (a,b) -> {
            int diffA = Math.abs(a-x);
            int diffB = Math.abs(b-x);
            if(diffA == diffB){
                return Integer.compare(a,b);
            }
            return Integer.compare(diffA , diffB);
        });
        List<Integer> res = list.subList(0 , k);
        Collections.sort(res);
        return res;
    }
}