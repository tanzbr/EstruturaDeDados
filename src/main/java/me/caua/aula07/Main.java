package me.caua.aula07;

public class Main {

    public static void main(String[] args) {
        ListaDuplamenteEncadeada l = new ListaDuplamenteEncadeada();

        System.out.println("Adicionando valores");
        l.add(10);
        l.add(20);
        l.add(1);
        l.add(0);
        l.add(100);
        l.add(50);
        l.imprimir();
        System.out.println("--------");
        l.remove(20);
        l.imprimir();
        System.out.println("-------");
        l.add(2);
        l.add(200);
        l.imprimir();
    }

}
