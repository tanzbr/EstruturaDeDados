package me.caua.aula05;

public class Main {

    public static void main(String[] args) {

        FilaDinamica fila = new FilaDinamica();

        fila.push(20);
        fila.push(30);
        fila.push(40);

        fila.push(50);
        fila.push(60);
        fila.imprimir();
        System.out.println("---");

        fila.pop();
        fila.pop();
        fila.imprimir();

        fila.pop();
        fila.pop();
        System.out.println("---");
        fila.imprimir();
        fila.pop();

        System.out.println("---");
        fila.pop();
//        PilhaDinamica pilha = new PilhaDinamica();
//
//        pilha.push(20);
//        pilha.push(30);
//        pilha.push(40);
//        pilha.push(40);
//        pilha.imprimir();
//
//        pilha.pop();
//        pilha.pop();
//        pilha.pop();
//        pilha.imprimir();
//
//        pilha.pop();
//        pilha.pop();
//        pilha.pop();
//        pilha.pop();
//        pilha.imprimir();
    }

    public static void testarPilha() {

        PilhaDinamica<String> p = new PilhaDinamica<>();

    }

}
