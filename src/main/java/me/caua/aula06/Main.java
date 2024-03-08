package me.caua.aula06;

public class Main {

    public static void main(String[] args) {
        ListaOrdenada l = new ListaOrdenada();

        System.out.println("Adicionando valores");
        l.add(10);
        l.add(20);
        l.add(1);
        l.add(0);
        l.add(100);
        l.add(50);
        l.imprimir();
        System.out.println("--------");
        System.out.println("Removendo valor: " + l.remove(0));
        System.out.println("Removendo valor: " + l.remove(100));
        System.out.println("Removendo valor: " + l.remove(20));
        System.out.println("Tamanho: " + l.size());
        l.imprimir();
        System.out.println("--------");

        l.remove(1);
        l.remove(10);
        l.remove(50);
        l.imprimir();

        l.remove(10);
        l.add(1);
        l.imprimir();
    }

}
