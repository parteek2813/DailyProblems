package AdvStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


// Ek dum simple logic
// Hume har element ka next greater element nikalna hein
// Then uske lie hum stack use krte hein
// Stack me Har element har element pr iterate kro aur use stack me dalo and agar next greater mil raha
// then map me fix kardo ... other wise iterate krte raho

// Finally nums1 array par iterate karke us element ke corresponding value ko Map me se nikal lo!!

public class NextGreaterEle {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;


        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();


        // The simple logic is that add last element with thier next greater element in Map
        // if the last element is left then add or any elements at end whose there is no greater element then set its value to -1

        for(int num: nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Add the last element too which is yet to be added
        // Put the last element with value -1

        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        // For each element in nums1 array, get the value from the map
        int[] result = new int[n1];
        for(int i=0; i<n1; i++){
            result[i] = map.get(nums1[i]);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1= {2,4};
        int[] nums2 = {1,2,3,4};

        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));

    };
}
