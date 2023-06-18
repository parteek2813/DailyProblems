package gcdAdv;

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

    public static void main(String[] args) {
//        isPrime(29);

        //Generate all prime from 1 to 100
//        allPrimes();
        allPrimeWithSieve();
    }
}
