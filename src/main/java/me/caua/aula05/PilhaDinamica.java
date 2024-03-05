package me.caua.aula05;

public class PilhaDinamica<T> {

    private No<T> topo;

    public PilhaDinamica() {
        this.topo = null;
    }

    public void push(T valor) {
        No<T> noAux = new No<>(valor);
        noAux.setProximo(this.topo);
        this.topo = noAux;
    }

    public T pop() {

        if (topo == null) {
            System.out.println("A pilha já está vazia.");
            return null;
        }
        T valor = this.topo.getElemento();

        No<T> noAux = this.topo;
        this.topo = noAux.getProximo();
        noAux.setProximo(null);

        return valor;
    }

    public int size() {
        int count = 0;

        No atual = topo;

        while (topo != null) {
            count++;
            topo = topo.getProximo();
        }

        return count;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void imprimir() {
        imprimir(topo);
    }

    private void imprimir(No<T> proximo) {
        if (proximo == null) {
            return;
        }
        System.out.println(proximo.getElemento());
        imprimir(proximo.getProximo());
    }
}
