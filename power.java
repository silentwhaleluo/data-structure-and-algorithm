import java.util.Arrays;
import java.util.Random;

public class power {
    public static int powver(int x, int n){ //log n
        int prod = 1;
        while(n>0){
            if( n % 2 != 0){
                prod = prod *x;
            }
            x = x*x;
            n = n/2;
        }
        return prod;
    }

    public static int powermod(int x, int n, int m){ // 1+ log n = log n
        int prodmod =1;
        while(n > 0){
            if( n % 2 != 0){
                prodmod = prodmod * x % m;
                n /=2;
            }
        }

        return prodmod;
    }
    public static boolean fermat(int p, int k){ // k log n
        Random r = new Random();
        for (int i = 1; i < k; i++){
            int a = r.nextInt(p+1)-2;
            if (powermod(a,p-1,p) == 1){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static boolean eratoshesnes(int n){
        if(n%2==0 && n!= 2){return Boolean.FALSE;}

        boolean[] isPrime = new boolean[n+1] ;
        for(int i=0; i<= n; i++){
            if(i%2 != 0){
                isPrime[i] = Boolean.TRUE;
            }
        }
        isPrime[2] = Boolean.TRUE;

        double sqrtN = Math.sqrt(n);
        for(int i = 3; i <= sqrtN; i+=2 ){ //sqrt(n)/2
            if(isPrime[i]){
                for(int j = i*i; j < n; j += 2*i){ //log n
                    isPrime[j] = Boolean.FALSE;
                }
            }

        }
        return isPrime[n];
    }
    public static void main(String[] args){
        System.out.println(powver(3,5));
        System.out.println(powver(3,5));
        System.out.println(eratoshesnes(995));

    }
}
