package me.caua.aula03;

import java.util.Arrays;

public class PilhaEstatica {
    private int topo;
    private final int[] pilhaArray;

    public PilhaEstatica(int tamanho) {
        topo = -1;
        pilhaArray = new int[tamanho];
    }

    public void push(int conteudo) {
        topo++;
        pilhaArray[topo] = conteudo;
    }

    public void pop() {
        pilhaArray[topo] = 0;
        topo--;
    }

    public void imprimir() {
        for (int j : pilhaArray) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        PilhaEstatica pilhaEstatica = new PilhaEstatica(3);
        pilhaEstatica.push(20);
        pilhaEstatica.push(30);
        pilhaEstatica.push(40);

        pilhaEstatica.pop();


        pilhaEstatica.imprimir();
    }

}
