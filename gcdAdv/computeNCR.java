package gcdAdv;

public class computeNCR {

    static int computeNcr(int N, int R, int P) {
        // Base case: Invalid combination
        if (R > N) {
            return 0;
        }

        // Base case: Combination of choosing 0 or all items
        if (N == 0 || R == 0) {
            return 1;
        }

        // Recursive case
        int t1 = computeNcr(N - 1, R - 1, P);
        int t2 = computeNcr(N - 1, R, P);

        int result = t1 + t2;
        if (result < 0) {
            result += P;
        }

        return result % P;
    }

    public static void main(String[] args) {
        int N = 50;
        int R = 17;
        int P = 11;

//        int res = computeNcr(N, R, P);
//        System.out.println(res);


    }

}
