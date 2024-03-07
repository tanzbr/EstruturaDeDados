package me.caua.aula06;

public class ListaDinamica<T> {

    private No<T> primeiro;
    private No<T> ultimo;

    public ListaDinamica() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean isEmpty() {
        // Retorna se a lista está vazia
        return primeiro == null;
    }

    public void addToEnd(T valor) {
        // Criando novo nó
        No<T> noAux = new No<>(valor);

        if (isEmpty()) {
            // Se for fazia, primeiro e ultimo são os mesmos nós
            this.primeiro = noAux;
            this.ultimo = noAux;
        } else {
            // Caso não vazia, atualizar as referencias
            ultimo.setProximo(noAux);
            ultimo = noAux;
        }
    }

    public void addToStart(T valor) {
        // Criando novo nó
        No<T> noAux = new No<>(valor);

        if (isEmpty()) {
            // Se for fazia, primeiro e ultimo são os mesmos nós
            this.primeiro = noAux;
            this.ultimo = noAux;
        } else {
            // Caso não vazia, atualizar as referencias
            noAux.setProximo(primeiro);
            primeiro = noAux;
        }
    }

    public void addToIndex(int i, T valor) {

        if (i > size()-1) {
            System.out.println("Este index não existe na fila.");
            return;
        }

        // Criando novo nó
        No<T> noAux = new No<>(valor);

        // variáveis de controle do while
        boolean stop = false;
        int count = 0;

        // Referências dos nós
        No<T> atual = primeiro;
        No<T> anterior = null;
        while (!stop) {
            // se chegarmos ao index desejado, atualizar as referencias inserindo o novo nó
            if (count == i) {
                noAux.setProximo(atual);
                if (anterior != null) {
                    anterior.setProximo(noAux);
                } else {
                    primeiro = noAux;
                }
                stop = true;
            }
            // se não, continuar percorrendo
            anterior = atual;
            atual = atual.getProximo();
            count++;
        }
    }

    public void addToMiddle(T valor) {
        // descobrir o index do meio da lista
        int middle = Math.toIntExact(size()/2);
        // adicionar elemento no index
        addToIndex(middle-1, valor);
    }

    public int size() {
        // retorna o tamanho da lista
        int count = 0;

        No<T> atual = primeiro;

        // percorrer a lista contando os elementos
        while (atual != null) {
            count++;
            atual = atual.getProximo();
        }

        return count;
    }

    public T removeFirst() {

        // verificar se está vazia
        if (isEmpty()) {
            System.out.println("A fila já está vazia.");
            return null;
        }

        // salvar valor para retornar
        T valor = primeiro.getElemento();
        // remover o primeiro elemento
        if (primeiro.getProximo() == null) {
            // se o primeiro for último elemento, defini-lo como nulo
            primeiro = null;
        } else {
            // se não, o primeiro passa a ser o próximo elemento
            primeiro = primeiro.getProximo();
        }

        return valor;
    }

    public T removeLast() {

        if (isEmpty()) {
            System.out.println("A fila já está vazia.");
            return null;
        }

        T valorRemovido;

        if (primeiro == ultimo) {
            // Se há apenas um elemento na lista
            valorRemovido = primeiro.getElemento();
            primeiro = null;
            ultimo = null;
        } else {
            // Se há mais de um elemento na lista
            No<T> atual = primeiro;
            No<T> anterior = null;

            // Percorre a lista até chegar ao último nó
            while (atual.getProximo() != null) {
                anterior = atual;
                atual = atual.getProximo();
            }

            valorRemovido = atual.getElemento();
            assert anterior != null;
            anterior.setProximo(null); // Remove a referência para o último nó
            ultimo = anterior; // Atualiza o último nó
        }

        return valorRemovido;
    }

    public T removeIndex(int i) {

        if (i > size()-1) {
            System.out.println("Este index não existe na fila.");
            return null;
        }

        if (isEmpty()) {
            System.out.println("A fila já está vazia.");
            return null;
        }

        T valorRemovido = null;
        boolean stop = false;
        int count = 0;

        // Referências dos nós
        No<T> atual = primeiro;
        No<T> anterior = null;
        while (!stop) {
            // se chegarmos ao index desejado, atualizar as referencias removendo o nó
            if (count == i) {
                valorRemovido = atual.getElemento();
                if (anterior != null) {
                    anterior.setProximo(atual.getProximo());
                } else {
                    primeiro = atual.getProximo();
                }
                stop = true;
            }
            // se não, continuar percorrendo
            anterior = atual;
            atual = atual.getProximo();
            count++;
        }

        return valorRemovido;
    }

    public void imprimir() {
        // Imprimir os valores
        No<T> atual = primeiro;

        while (atual != null) {
            System.out.println(atual.getElemento());
            atual = atual.getProximo();
        }
    }

}
