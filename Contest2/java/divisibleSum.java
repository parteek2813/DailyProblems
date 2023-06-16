package Contest2.java;

// We are given an array of Strings A of size N representing N large Numbers and an integer B
// We have to return count of pairs from array A whose concatenation is divisible by B. Concatenation of String A
// and B is string A+B /
// Eg: "12" + "35" = "1235";
// Note - We can't make pair(i,i);
// And pair(i,j) is different from the pair (j,i);


public class divisibleSum {

    static boolean Divisible(String s, int B){
        int temp =0;
        char sArr[] = s.toCharArray();
        for(char x : sArr){
                temp = (10*temp) + (x-'0'); //char to int conversion
                temp = (temp % B);

        }
        return (temp==0);
    }

    static int giveCount(String[] StringArr, int B){
        int count =0;
        int N = StringArr.length;
        for(int i =0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i!= j){
                    String x = StringArr[i] + StringArr[j];
                    if(Divisible(x,B)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String[] StringArr = new String[]{"12", "15", "16"};
        int B = 2;


        int res = giveCount(StringArr,B);
        System.out.println(res);
    }
}
