package gcdAdv;


// Question
//
// GIven  Q Queries of the form [a,b] find out the count of oprimes in range [a,b] a,b<=10^6


import java.util.Arrays;

public class primeNum {

    static boolean isPrime(int n){
        boolean isPrime = false;

        for(int i =2; i<=Math.sqrt(n);i++ ){
            if(n%i==0){
                isPrime= true;
                break;
            }
        }
//        if(isPrime){
//            System.out.println("It is not a prime num");
//        }else{
//            System.out.println("It is a prime num");
//        }
        return isPrime;
    }

    static void allPrimes(){
        for (int i=1; i<=100; i++){
            if(!isPrime(i)){
                System.out.print(i +" ");
            }
        }
    }

    static void allPrimeWithSieve() {
        int n = 100;
        boolean[] primes = new boolean[n +1]; // Array to store prime flags

        // Initialize all elements as true initially
        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        // Printing prime numbers
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }

    static int[] countPrimesInRange(int[] a, int[] b){
        int maxRange = (int) Math.pow(10, 6);
        boolean[] primes = new boolean[maxRange+1];

        // Initialize all elements as true initially
        for (int i = 2; i <= maxRange; i++) {
            primes[i] = true;
        }

        // Sieve of Eratosthenes to mark non-prime numbers
        for (int i = 2; i * i <= maxRange; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= maxRange; j += i) {
                    primes[j] = false;
                }
            }
        }

        // calculate prefix sum array

        int[] prefixSum = new int[maxRange + 1];
        for (int i=2; i<=maxRange; i++){
            prefixSum[i] = prefixSum[i-1] + (primes[i] ? 1 :0);
        }

        int[] counts = new int[a.length]; // Array to store the counts
        for (int i = 0; i < a.length; i++) {
            int start = a[i];
            int end = b[i];

            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }

            counts[i] = prefixSum[end] - prefixSum[start - 1];
        }
        return counts;
    }

    public static void main(String[] args) {
//        isPrime(29);

        //Generate all prime from 1 to 100
//        allPrimes();
//        allPrimeWithSieve();

        int[] arrA = {2,5,30,200};
        int[] arrB = {50,100,500,10000};

        int[] countArray = countPrimesInRange(arrA, arrB);
        System.out.println(Arrays.toString(countArray));

    }
}
