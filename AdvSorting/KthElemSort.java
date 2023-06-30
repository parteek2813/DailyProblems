package AdvSorting;

// question

// given N distinct elements, of unsorted array
// we need to find the kth element if the array was sorted
// try to do this using binary search or use less time than simple
// merge sort time complexity

public class KthElemSort {

    // This will return the count;
    static int countLess(int[] arr, int mid){

        int cnt=0;
        for(int i =0; i<arr.length; i++){
            if(arr[i]<mid){
                cnt++;
            }
        }
        return cnt;
    }


    static int findKth(int[] arr , int k){
        int n = arr.length;
       int s =Integer.MAX_VALUE;;
       int e =Integer.MIN_VALUE;

       for(int i =0; i<n ; i++){
           if(arr[i] < s){
               s=arr[i];
           }
       }
       for(int i =0; i<n; i++){
           if(arr[i] > e ){
               e = arr[i];
           }
       }

        int ans =-1;
       while(s<=e){
           int mid = (s+e)/2;

           int cnt = countLess(arr,mid); //linear search O(N);
           if(cnt<k){
               s = mid+1;
           } else if (cnt==k) {
               ans = mid;
               e=mid-1;
           }else {
               e=mid-1;
           }
       }
       return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,12,1,2,1,23,2,322,12};
        int n = arr.length;
        int k = 3;

        int res = findKth(arr,k);
        System.out.println(res);

    }
}
