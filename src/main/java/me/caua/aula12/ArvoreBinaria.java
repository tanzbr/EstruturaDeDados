package me.caua.aula12;

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

    public Integer buscaPreOrdem(No noAtual, int elementoBuscado) {
        if (noAtual == null) return null;

        // sysout para testar
        System.out.println(noAtual);

        if (noAtual.getElemento() == elementoBuscado) {
            return noAtual.getElemento(); // retornar o elementro encontrado
        }

        Integer noEsquerdo = buscaPreOrdem(noAtual.getEsquerdo(), elementoBuscado);
        if (noEsquerdo != null) {
            return noEsquerdo;
        }

        Integer noDireito = buscaPreOrdem(noAtual.getDireito(), elementoBuscado);
        if (noDireito != null) {
            return noDireito;
        }

        return null; // elemento não encontrado, fim da lista
    }


    public Integer buscaEmOrdem(No noAtual, int elementoBuscado) {
        if (noAtual == null) return null;

        Integer noEsquerdo = buscaEmOrdem(noAtual.getEsquerdo(), elementoBuscado);
        if (noEsquerdo != null) {
            return noEsquerdo;
        }

        System.out.println(noAtual);

        if (noAtual.getElemento() == elementoBuscado) {
            return noAtual.getElemento();
        }

        Integer noDireito = buscaEmOrdem(noAtual.getDireito(), elementoBuscado);
        if (noDireito != null) {
            return noDireito;
        }

        return null; // elemento não encontrado, fim da lista
    }

    public Integer buscaPosOrdem(No noAtual, int elementoBuscado) {
        if (noAtual == null) return null;

        Integer noEsquerdo = buscaPosOrdem(noAtual.getEsquerdo(), elementoBuscado);
        Integer noDireito = buscaPosOrdem(noAtual.getDireito(), elementoBuscado);

        System.out.println(noAtual.getElemento());

        if (noAtual.getElemento() == elementoBuscado) {
            return noAtual.getElemento();
        }

        if (noEsquerdo != null) {
            return noEsquerdo;
        }

        if (noDireito != null) {
            return noDireito;
        }

        return null; // elemento não encontrado, fim da lista
    }


    public No getRaiz() {
        return noRaiz;
    }


}
