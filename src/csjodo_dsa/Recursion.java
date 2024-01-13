package csjodo_dsa;

public class Recursion {
    public static int factorial(int n){
        //if (n == 0) return 1;
        //return (n >= 1) ? n * factorial(n-1) : n;
        if(n >= 1) return n * factorial(n-1);
        else return 1;
    }

    public static int fibonacci(int n){
        if(n > 2) return fibonacci(n - 1) + fibonacci(n - 2);
        else return 1;
    }

    public static int frogJumpWays(int n){
        if(n>3) return frogJumpWays(n-1) + frogJumpWays(n-2);
        else return n;
    }
}
