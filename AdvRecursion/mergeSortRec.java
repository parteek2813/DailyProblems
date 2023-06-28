package AdvRecursion;

public class mergeSortRec {

    static void Merge(int[] arr, int s , int m , int e){
        int n = arr.length;

        //creating a new temp array
        int[] temp = new int[n];

        int i =s;
        int j = m+1;
        int k=s;

        while(i<=m && j<=e){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }else{
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        // copy rem element left
        while(j<=e){
            temp[k] = arr[j];
            j++;
            k++;
        }

        // copy rem element right
        while(i<=m){
            temp[k] = arr[i];
            i++;
            k++;
        }

        //copy whole array back
        for( int index=s; index<=e; index++){
            arr[index] = temp[index];
        }


    }

    static void MergeSort(int[] arr,int s , int e){
        // Base case
        if(s>=e){
            return;
        }

        // rec case
        int m = (s+e)/2;
        MergeSort(arr, s, m);
        MergeSort(arr, m+1,e);
        Merge(arr,s,m,e);

    }
    public static void main(String[] args) {

        int[] arr = {1,7,4,8,7,9,3};
        int n = arr.length;
        int s = 0;
        int e = n-1;
        MergeSort(arr,s,e);

        // printing the sorted array

    }
}
