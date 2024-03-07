package me.caua.aula06;

public class ListaDinamicaOrdenada {

    private No<Integer> primeiro;
    private No<Integer> ultimo;

    public ListaDinamicaOrdenada() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean isEmpty() {
        // Retorna se a lista está vazia
        return primeiro == null;
    }
    
    public void add(Integer valor) {

        if (isEmpty() || valor < primeiro.getElemento()) {
            // Se a lista estiver vazia ou o novo valor for menor que o primeiro, adicionar no inicio
            addToStart(valor);
        } else if (valor > ultimo.getElemento()) {
            // se o valor for maior que o ultimo, adicionar ao fim
            addToEnd(valor);
        } else {
            addToMiddle(valor);
        }
    }

    public int size() {
        // retorna o tamanho da lista
        int count = 0;

        No<Integer> atual = primeiro;

        // percorrer a lista contando os elementos
        while (atual != null) {
            count++;
            atual = atual.getProximo();
        }

        return count;
    }

    private void addToEnd(Integer valor) {
        // Criando novo nó
        No<Integer> noAux = new No<>(valor);

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

    private void addToStart(Integer valor) {
        // Criando novo nó
        No<Integer> noAux = new No<>(valor);

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

    private void addToMiddle(int valor) {
        No<Integer> noAux = new No<>(valor);
        No<Integer> atual = primeiro;
        No<Integer> anterior = null;

        // Percorre a lista até encontrar o local para inserir o novo valor
        while (atual != null && atual.getElemento() <= valor) {
            anterior = atual;
            atual = atual.getProximo();
        }

        // Insere o novo nó entre o nó anterior e o nó atual
        noAux.setProximo(atual);
        assert anterior != null;
        anterior.setProximo(noAux);

        if (atual == null) {
            // Se o novo valor for maior que todos os valores na lista, atualiza o último
            ultimo = noAux;
        }
    }

    public Integer remove(int valor) {

        if (isEmpty()) {
            System.out.println("A fila já está vazia.");
            return null;
        }

        Integer valorRemovido = null;
        boolean stop = false;

        // Referências dos nós
        No<Integer> atual = primeiro;
        No<Integer> anterior = null;
        while (!stop && atual != null) {
            // se chegarmos ao index desejado, atualizar as referencias removendo o nó
            if (valor == atual.getElemento()) {
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
        }

        return valorRemovido;
    }

    public void imprimir() {
        // Imprimir os valores
        No<Integer> atual = primeiro;

        while (atual != null) {
            System.out.println(atual.getElemento());
            atual = atual.getProximo();
        }
    }

}
