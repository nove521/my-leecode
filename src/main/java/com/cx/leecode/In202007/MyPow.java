package com.cx.leecode.In202007;

public class MyPow {
    public double myPow(double x, long n) {
        if (x == 1.0){
            return x;
        }
        if (n == 0){
            return 1.0;
        }

        if (n < 0){
            return 1 / compute(x,-n);
        }else {
            return compute(x,n);
        }
    }

    public double compute(double x, long n){
        if (n == 1){
            return x;
        }
        if (n % 2 == 1){
            double res = compute(x, (n - 1) / 2);
            return res * res * x;
        }else {
            double res = compute(x, n / 2);
            return res * res;
        }
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2.00000,-2147483648));
    }
}
