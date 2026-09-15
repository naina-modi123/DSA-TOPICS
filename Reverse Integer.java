// Write your solution here
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int revNum = 0;
        while(n != 0){
          int digit = n%10;
          if (revNum > Integer.MAX_VALUE / 10 ||
                (revNum == Integer.MAX_VALUE / 10 && digit > 7)) {
                System.out.println(0);
                return;
            }

            if (revNum < Integer.MIN_VALUE / 10 ||
                (revNum == Integer.MIN_VALUE / 10 && digit < -8)) {
                System.out.println(0);
                return;
            }

          revNum = revNum*10+digit;
          n /= 10;
        }
        System.out.println(revNum);
    }
}
