package AdvQueue;


import java.util.LinkedList;
import java.util.Queue;

public class WinnerOfGame {

    public static int helper(int n , int k){
        if(n==1){
            return 0;
        }else{
            int res =  (helper(n-1,k) + k) % n;
            return res;
        }
    }

    public static int findTheWinner(int n , int k ){
        int res =  helper(n, k) + 1;
        return res;
    }

   public static int findTheWinnerUsingQueue(int n , int k){
       Queue<Integer> q = new LinkedList<>();

       // store all elem in queue
       for(int i =1; i<=n; i++){
           q.add(i);
       }

       while(q.size() > 1){
           int deleteCount = k-1;
           while(deleteCount >0){
               q.add(q.poll()); // rotate elements
               deleteCount--;
           }

           q.poll();

       }
       return q.poll();
   }


    public static void main(String[] args) {
        int n =5;
        int k = 2;

        int res = findTheWinnerUsingQueue(n, k);
        System.out.println(res);
    }
}
