package AdvSorting;

public class AthMagicalNumber {
    static int count(int mid, int b , int c , int lcm){

        return (mid/b) + (mid/c) + (mid/(b*c));

    }

    private static int gcd(int b, int c) {
        while (c != 0) {
            int temp = c;
            c = b % c;
            b = temp;
        }
        return b;
    }

    static int findMagical(int a , int b ,int c){
        int s = Math.min(b,c);
        int e = a * Math.min(b,c);
        int lcm = b*c/gcd(b,c);

        int ans =Math.min(b,c);
        while (s<=e){
            int mid = (s+e)/2;

          int cnt = count(mid,b,c,lcm);
          if(cnt == a){
              ans = mid;
              e=mid-1;
          } else if (cnt<a) {
              s = mid+1;
          }else{
              e =mid-1;
          }
        }
        return ans;
    }
    public static void main(String[] args) {
        int b =2;
        int c = 3;
        int a = 8;
        int res = findMagical(a, b, c );
        System.out.println(res);
    }
}
