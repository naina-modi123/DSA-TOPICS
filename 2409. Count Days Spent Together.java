class Solution {
    public int convertToDay(String date) {
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = Integer.parseInt(date.substring(0,2));
        int day = Integer.parseInt(date.substring(3));

        month-=1;

        while(month > 0) {
            day += days[month-1];
            month-=1;
        }

        return day;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int x = convertToDay(arriveAlice);
        int y = convertToDay(arriveBob);

        int z = convertToDay(leaveAlice);
        int p = convertToDay(leaveBob);

        int X = Math.max(x,y);
        int Y = Math.min(z,p);

        return (Y-X < 0) ? 0 : Y-X+1;
        
    }
}
