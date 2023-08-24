package AdvArray;
// Question:

// Given a array of elements .... find the nearest next greater number
// The elements can be found on either side of element. If there are two nearest greater element
// then take out bigger of two. If there are no greater element, return -1 on that place
public class NearestGreater {

    static int[] findNearestGreaterNumbers(int[] arr){
        int n = arr.length;
        int[] result = new int[n];

        for(int i =0; i<n; i++){
            int lgreater = -1;
            int rgreater = -1;

            // find on the left side
            for(int  j=i-1; j>=0; j--){ // j>=0 ... so that it won't run for the first element
                if(arr[j] > arr[i]){
                    lgreater = arr[j];
                    break;
                }
            }

            // Find the nearest greater number on the right side
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    rgreater = arr[j];
                    break;
                }
            }

            // set the result for the curr element
            if(lgreater != -1 && rgreater != -1){
                result[i] = Math.min(lgreater, rgreater);
            }else if(lgreater != -1){
                result[i] = lgreater;
            } else if (rgreater != -1) {
                result[i] = rgreater;
            }else {
                result[i] = -1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,2,25};

        int[] result = findNearestGreaterNumbers(arr);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
