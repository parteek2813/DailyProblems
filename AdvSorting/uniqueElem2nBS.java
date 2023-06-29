package AdvSorting;

// question

// given a sorted array having 2N+1 elements , find the unique number present
// in the array using the binary search Approach

public class uniqueElem2nBS {

     static int binarySearchUnique(int[] arr){
         int s =0;
         int e = arr.length -1;

         while (s<=e){
             int mid = (s+e)/2;
             if(mid==0 || mid== arr.length-1 || arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1] ) return arr[mid];
             else if ((mid%2 != 0 && arr[mid] == arr[mid-1]) || (mid%2 ==0 && arr[mid] == arr[mid+1])){
                 s = mid+1;
             }
             else {
                 e = mid -1;
             }

         }
         return -1;
     }
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,4,4,5,6,6,9,9};
        int res = binarySearchUnique(arr);
        System.out.println(res);
    }
}
