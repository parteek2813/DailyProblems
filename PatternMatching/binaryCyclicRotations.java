package PatternMatching;


// question

// given a binary string S, find number of cyclic rotations which are same as
// original string

//  Example-
// lets say binary string be 1010
// we need to rotate it cyclic and cal number of times the rotated string becomes
// equal to original string

// ex- 1010
// r1 = 0101 , r2= 1010 , r3 = 0101, r4= 1010 ..... here we can see that two times
// our rotated string became equla to original string'


public class binaryCyclicRotations {

    static  int countCyclicRotations(String binaryString){
        int n = binaryString.length();
        int count = 0;

        // Convert the binary string to a character array for easier manipulation
        char[] chars = binaryString.toCharArray();

        for (int i = 0; i < n; i++) {
            // Perform the cyclic rotation
            char temp = chars[n - 1];
            for (int j = n - 1; j > 0; j--) {
                chars[j] = chars[j - 1];
            }
            chars[0] = temp;

            // Compare the rotated string with the original string
            boolean isEqual = true;
            for (int j = 0; j < n; j++) {
                if (chars[j] != binaryString.charAt(j)) {
                    isEqual = false;
                    break;
                }
            }

            // If the rotated string is equal to the original string, increment the count
            if (isEqual) {
                count++;
            }
        }

        return count;

    }
    public static void main(String[] args) {
        String binaryString = "1010";
        int count = countCyclicRotations(binaryString);
        System.out.println("Number of cyclic rotations that are the same as the original string: " + count);
    }
}
