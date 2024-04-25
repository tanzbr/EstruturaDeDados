package me.caua;

public class Teste {

    public static void metodoRecursivo(int n) {
        int v1 = n/2;
        int v2 = n%2;

        if (v1 < 2) {
            System.out.print(v1);
        } else {
            metodoRecursivo(v1);
            System.out.print(v2);
        }
    }

    public static void main(String[] args) {
        metodoRecursivo(36);
    }
}
