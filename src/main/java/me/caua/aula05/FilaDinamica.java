package me.caua.aula05;

public class FilaDinamica<T> {

    private No<T> primeiro;
    private No<T> ultimo;

    public FilaDinamica() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean isEmpty() {
        return primeiro == null;
    }

    public void push(T valor) {
        No<T> noAux = new No<>(valor);

        if (isEmpty()) {
            this.primeiro = noAux;
            this.ultimo = noAux;
        } else {
            ultimo.setProximo(noAux);
            ultimo = noAux;
        }
    }

    public int size() {
        int count = 0;

        No<T> atual = primeiro;

        while (atual != null) {
            count++;
            atual = atual.getProximo();
        }

        return count;
    }

    public T pop() {

        if (isEmpty()) {
            System.out.println("A fila já está vazia.");
            return null;
        }

        T valor = primeiro.getElemento();
        primeiro = primeiro.getProximo();

        if (primeiro == null) {
            ultimo = null;
        }

        return valor;
    }

    public void imprimir() {
        No<T> atual = primeiro;

        while (atual != null) {
            System.out.println(atual.getElemento());
            atual = atual.getProximo();
        }
    }

}
