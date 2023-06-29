package AdvSorting;

// question

// Given a sorted array which is K rotated...... Means the last K elements are
// brought up to the front of the array. We have to find out the Pivot element
// from where the rotated array.
// Pivot element here can be described as the place where the distortions between
// element behaviour is very large or the where the graph of this array is
// drastically changed

// Here if there is case that array is rotated N times then we can return -1 in that case

public class SortedKRotatedArray {

    static int findPivot(int[] arr, int s , int e ){



        // here mid<e and mid>s are done to check the outOfBounds Cases only
        while(s<=e){
            int mid = (s+e)/2;

            if((mid < e)   && arr[mid] > arr[mid+1]){
                return mid+1;
            } else if ((mid>s) && arr[mid]< arr[mid-1]) {

                return mid;
            } else if (arr[mid] > arr[s]) {
                s = mid+1;
            }else{
                e=mid-1;
            }
        }

        return  -1;

    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,1,2,3};
        int s =0;
        int e = arr.length -1;
        int res = findPivot(arr, s , e);
        System.out.println(res);
    }
}
