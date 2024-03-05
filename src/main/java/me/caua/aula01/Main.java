package me.caua.aula01;

public class Main {

    public static int somarAntecessores(int valor) {
        if (valor <= 0) {
            return 0;
        }
        return valor + somarAntecessores(--valor);
    }

    public static void main(String[] args) {
        System.out.println(somarAntecessores(5));
    }

}
