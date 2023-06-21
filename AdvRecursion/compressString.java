package AdvRecursion;

// Given an string S , we have to compress it by dissolving/or removing the
// consecutive char from this string.

// HINT/OBSERVATION - Here the frequency of the consecutive char does not matter but the order of dissovlign the char
// does matter

public class compressString {

    static  String compressString(String s){

        String bestOutput = s;
        // base case
        for(int i =0; i<s.length(); ){
            int j=i;
            while (j<s.length() && s.charAt(j)==s.charAt(i)){
               j++;
            }
            // found a segment that can be compressed
            if(j-i>1){
                String s_ = s.substring(0,i) + s.substring(j);
                String output = compressString(s_);
                if(output.length() < bestOutput.length()){
                    bestOutput = output;
                }
            }
            // does not does i updation but directly give the i == j ;
            i=j;

//            if(bestOutput == s){
//                return s;
//            }


        }
        return bestOutput;


    }
    public static void main(String[] args) {
        String input = "kaaabbccbaxd";
        System.out.println(compressString(input));
    }
}
