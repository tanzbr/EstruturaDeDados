package me.caua.aula06;

public class Main {

    public static void main(String[] args) {
        ListaDinamicaOrdenada l = new ListaDinamicaOrdenada();

        System.out.println("Adicionando valores");
        l.add(10);
        l.add(20);
        l.add(1);
        l.add(0);
        l.add(100);
        l.add(50);
        l.imprimir();
        l.remove(100);
        l.remove(20);
        l.remove(0);

        l.imprimir();
    }

}
