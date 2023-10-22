import java.util.Scanner;

public class codeForces904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        while (t-- > 0){
            int x = sc.nextInt();
            int k = sc.nextInt();

            int sum =0;

            for(int i =x; ; i++){
                int num = i;
                int digitSum = 0;

                while (num>0){
                    digitSum += num%10;
                    num /= 10;

                }

                if(digitSum % k == 0){
                    System.out.println(i);
                    break;
                }
            }
        }
        sc.close();

    }
}
