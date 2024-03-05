package me.caua.aula05;

public class FilaDinamica {

    private No primeiro;
    private No ultimo;

    public FilaDinamica() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean isEmpty() {
        return primeiro == null;
    }

    public void push(int valor) {
        No noAux = new No(valor);

        if (isEmpty()) {
            this.primeiro = noAux;
            this.ultimo = noAux;
            return;
        } else {
            ultimo.setProximo(noAux);
            ultimo = noAux;
        }
    }

    public Integer pop() {

        if (isEmpty()) {
            System.out.println("A fila já está vazia.");
            return null;
        }

        int valor = primeiro.getElemento();
        primeiro = primeiro.getProximo();

        if (primeiro == null) {
            ultimo = null;
        }

        return valor;
    }

    public void imprimir() {
        No atual = primeiro;

        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual = atual.getProximo();
        }

        System.out.println();
    }

}
