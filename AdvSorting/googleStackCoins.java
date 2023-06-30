package AdvSorting;


// question

// There are N stacks of coins , each stack has certain value of coins.
// The stacks are lying on a straight line, you have K friends with you can
// divide the stacks in K+1 consecutive partitions. Your friends are greedy and they will
// pick the best K parts and you will give the left out one.Maximize the value
// of coins you can get.


// Here the outer while loop runs for Log(e) times
// and the ineer loop will run for O(N) times
// hence complexity becomes O(N.log(arraysum/e))
public class googleStackCoins {

    static boolean CanDoPartition(int[] coins, int mid, int fr){
        int n = coins.length;
        int cnt=0;
        int currentSum =0;

        for (int i =0; i<n; i++){
            if(currentSum + coins[i] >= mid){
                currentSum =0;
                cnt++;
            }else{
                currentSum += coins[i];
                if(cnt == fr){
                    return true;
                }
            }

        }
        return false;
    }

    static int getMin(int[] coins, int n , int fr){
        int s = 0;
        int e =0;
        for (int i =0; i<coins.length; i++){
            e += coins[i];
        }

        // loop
        int ans =0;
        while (s<=e){
            int mid = (s+e)/2;
            if(CanDoPartition(coins, mid, fr)){
                ans = mid;
                s=mid+1;
            }else {
                e = mid-1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
//        int[] coins = {10,20,15,5,8};
        int[] coins = {20,40,30,10,16};
        int fr = 3;
        int n = coins.length;
        int res = getMin(coins, n , fr );
        System.out.println(res);

    }
}
