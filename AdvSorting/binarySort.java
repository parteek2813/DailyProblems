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

    static int binSortWithDuuplicates(int[] arr, int target){

        int s =0;
        int e = arr.length -1;


        int ans =-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid] == target) {
                ans = mid;
                e = mid-1;
            }else if(arr[mid] <target) s=mid+1;
            else e = mid-1;
        }
        return ans;
    }

    static int binSortWithRec(int[] arr, int target, int s, int e){

        // base case
        if(s>e){
            return -1;
        }

        // rec case
        int mid = (s+e) /2;
        if(arr[mid] > target){
            return binSortWithRec(arr, target, s , mid-1);
        }else if (arr[mid] == target){
            return mid;
        }else{
            return binSortWithRec(arr, target, mid+1, e);
        }

    }

    public static void main(String[] args) {


        int[] arr = {10,3,5,23,5,34,64,32};
        int target = 64;
        int s =0;
        int e = arr.length -1;
        int resRec = binSortWithRec(arr, target, s, e);
        System.out.println(resRec);


        int res = binSort(arr, target);
        System.out.println(res);

        int[] newArr = {1,1,2,3,3,3,3,4,4,5,8,10};
        int newtarget = 3;
        int resDup = binSortWithDuuplicates(newArr, newtarget);
        System.out.println(resDup);

    }
}
