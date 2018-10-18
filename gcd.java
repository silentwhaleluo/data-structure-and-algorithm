public class gcd {
    public static int gcdEuclid(int a, int b){ //log n
        if( a<b){ //a should > b
            int temp = b;
            b = a;
            a = temp;
        }
        if(b == 0){return a; }
        else{
            return gcdEuclid(b,a%b);
        }
    }

    public static int lcm(int a,int b){ //1 + log n
        return (a*b/gcdEuclid(a,b));

    }
    public static void main(String[] args){
        System.out.println(gcdEuclid(123456,7890));
        System.out.println(lcm(12,18));
    }
}
