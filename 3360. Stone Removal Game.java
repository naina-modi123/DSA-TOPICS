class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean flag = true;
        while(n >= remove){
            n -= remove;
            remove--;
            flag = !flag;
        }
        return !flag;
    }
}
