package me.caua.arvorebinaria;

public class ArvoreBinaria {

    private No noRaiz;

    public ArvoreBinaria() {
        this.noRaiz = null;
    }

    public void inserirNo(No noAtual, int elemento) {
        if (noAtual == null) noAtual = noRaiz;
        if (noRaiz == null) {
            this.noRaiz = new No(elemento);
        } else if (elemento < noAtual.getElemento()) {

            if (noAtual.getEsquerdo() == null) {
                noAtual.setEsquerdo(new No(elemento));
            } else {
                noAtual = noAtual.getEsquerdo();
                inserirNo(noAtual, elemento);
            }

        } else {

            if (noAtual.getDireito() == null) {
                noAtual.setDireito(new No(elemento));
            } else {
                noAtual = noAtual.getDireito();
                inserirNo(noAtual, elemento);
            }

        }
    }

}
