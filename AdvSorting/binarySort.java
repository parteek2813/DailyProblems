package AdvSorting;

public class binarySort {

    static int binSort(int[] arr, int target){
        int s =0;
        int e = arr.length -1;


        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] <target) s=mid+1;
            else e = mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {


        int[] arr = {10,3,5,23,5,34,64,32};
        int target = 64;

        int res = binSort(arr, target);
        System.out.println(res);
    }
}
