package me.caua.aula02;

public class Main {
    static int c = 1;

    public static void metodo1(int []x, int y) {
        if (y>1) metodo1(x, y-1);
        System.out.println(x[y-1]);
    }

    public static int metodo2(int x, int[]y) {
        if (x == y.length -1) {
            System.out.println("---------");
            System.out.println("Bloco " + c);
            c++;
            System.out.println("Retornando " + y[x]);
            return y[x];
        }
        int r = y[x] + (metodo2(x+1, y) + metodo2(x+1,y));
        System.out.println("---------");
        System.out.println("Bloco " + c);
        c++;
        System.out.println("Retornando " + r);
        return r;
    }

    public static int metodo3(int x) {
        if (x <= 1) {
            System.out.println("---------");
            System.out.println("Bloco " + c);
            c++;
            System.out.println("Retornando " + x);
            return x;
        }
        int r = metodo3(x-1) + metodo3(x-2);
        System.out.println("---------");
        System.out.println("Bloco " + c);
        c++;
        System.out.println("Retornando " + r);
        return r;
    }

    public static void main(String[] args) {
        int [] v1 = new int[5];
        int[] v2 = new int[3];

        for (int i = 0; i < v1.length; i++) {
            v1[i] = i * 3;
        }

        for (int i = 0; i < v2.length; i++) {
            v2[i] = i * 3;
        }

        //metodo1(v1, v1.length);
//        System.out.println(metodo2(0, v2));
//        for (int i = 0; i <= 5; i++) {
//            System.out.println(metodo3(i));
//





































        
        System.out.println(metodo3(5









        ));
    }

}







