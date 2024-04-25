package me.caua.aula13;

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

        System.out.println(noAtual.getElemento());

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

        System.out.println(noAtual.getElemento());

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


    public Integer buscar(No noAtual, int elemento) {
        if (noAtual == null) return null;

        if (elemento < noAtual.getElemento()) {
            return buscar(noAtual.getEsquerdo(), elemento);
        } else if (noAtual.getElemento() == elemento) {
            return noAtual.getElemento(); // elemento encontrado
        } else {
            return buscar(noAtual.getDireito(), elemento);
        }
    }

    public No remover(No raiz, int elemento) {
        if (raiz == null) {
            return null; // elemento não encontrado
        }

        // busca recursiva para encontrar o nó a ser removido
        if (elemento < raiz.getElemento()) {
            raiz.setEsquerdo(remover(raiz.getEsquerdo(), elemento));
        } else if (elemento > raiz.getElemento()) {
            raiz.setDireito(remover(raiz.getDireito(), elemento));
        } else {
            // Nó a ser removido encontrado

            // Nó folha (sem filhos)
            if (raiz.getEsquerdo() == null && raiz.getDireito() == null) {
                return null; // Simplesmente remove o nó folha
            }

            if (raiz.getEsquerdo() != null) {
                raiz.setElemento(raiz.getEsquerdo().getElemento()); // Substitui o elemento pelo do filho esquerdo
                raiz.setEsquerdo(remover(raiz.getEsquerdo(), raiz.getElemento())); // Remove o filho esquerdo recursivamente
            } else {
                raiz.setElemento(raiz.getDireito().getElemento()); // Substitui o elemento pelo do filho direito
                raiz.setDireito(remover(raiz.getDireito(), raiz.getElemento())); // Remove o filho direito recursivamente
            }
        }

        return raiz; // Retorna a raiz atualizada
    }

    public No getRaiz() {
        return noRaiz;
    }

}
