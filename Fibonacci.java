public class Fibonacci {
    public static int fiboloop(int n){
        if(n <= 2){
            return 1;
        }
        int a = 1;
        int b =1;
        int c =1;
        for(int i =1; i<n-1; i++){
            c = a+b;
            a =b;
            b=c;
        }
        return c;
    }

    public static int fiboRecursive(int n){
        if (n <= 2){return 1;}
        return fiboRecursive(n-1)+fiboRecursive(n-2);
    }
    private int[] memo = new int[1000];
    private int count = 0;

    public int fiboMemo(int n){
        if(n <= 2){return 1;}
        if(memo[n] != 0){
            count++;
            return memo[n];}
        return memo[n] = fiboMemo(n-1)+fiboMemo(n-2);
    }

    public static void main(String[] args){

        int n =8;
        //System.out.println(fiboloop(n));
        //System.out.println(fiboRecursive(n));
        Fibonacci fibo = new Fibonacci();
        System.out.println(fibo.fiboMemo(n));
        System.out.println(fibo.count);
    }
}
