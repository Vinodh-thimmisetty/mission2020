package basics.recursion;

/**
 * @author Vinodh Kumar Thimmisetty
 */
public class RecursionSamples {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(fibonacci(10));
    }

    // n * n-1 * n-2
    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }


    // 0,1,1,2,3,5,8,13.....
    static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // use memoization to avoid repeated recursions.
    static int[] fib = new int[100];

    static {
        fib[0] = 0;
        fib[1] = 1;
    }

    static int fibonacci_dp(int n) {
        if (n == 0) return fib[0];
        if (n == 1) return fib[1];
        fib[n] = fibonacci_dp(n - 1) + fibonacci_dp(n - 2);
        return fib[n];
    }


}
