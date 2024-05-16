package me.caua.aula14;

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

    public Integer getAltura(No raiz) {
        int esquerdo = 0;
        int direito = 0;

        if (hasNoEsquerdo(raiz)) {
            esquerdo+= getAltura(raiz.getEsquerdo())+1;
        }
        if (hasNoDireito(raiz)) {
            direito+= getAltura(raiz.getDireito())+1;
        }

        if (esquerdo > direito) {
            return esquerdo;
        } else if (direito > esquerdo) {
            return direito;
        } else {
            return direito;
        }
    }

    public boolean isArvoreEstrita(No raiz) {
        if (raiz == null)
            return true;

        if (raiz.getEsquerdo() == null && raiz.getDireito() == null)
            return true;

        if (raiz.getEsquerdo() != null && raiz.getDireito() != null)
            return isArvoreEstrita(raiz.getEsquerdo()) && isArvoreEstrita(raiz.getDireito());

        return false;
    }

    public boolean isArvoreCompleta(No raiz, int index, int controle) {
        if (raiz == null)
            return true;

        if (index >= controle)
            return false;

        return (isArvoreCompleta(raiz.getEsquerdo(), 2 * index + 1, controle) &&
                isArvoreCompleta(raiz.getDireito(), 2 * index + 2, controle));
    }

    public boolean isArvoreCheia(No raiz) {
        if (raiz == null)
            return true;

        if (raiz.getEsquerdo() == null && raiz.getDireito() == null)
            return true;

        if (raiz.getEsquerdo() != null && raiz.getDireito() != null)
            return (isArvoreCheia(raiz.getEsquerdo()) && isArvoreCheia(raiz.getDireito()));

        return false;
    }

    public int contarNos(No raiz) {
        if (raiz == null)
            return 0;
        return 1 + contarNos(raiz.getEsquerdo()) + contarNos(raiz.getDireito());
    }

    private boolean hasNoEsquerdo(No atual) {
        return atual.getEsquerdo() != null;
    }

    private boolean hasNoDireito(No atual) {
        return atual.getDireito() != null;
    }

    public No getRaiz() {
        return noRaiz;
    }

}
