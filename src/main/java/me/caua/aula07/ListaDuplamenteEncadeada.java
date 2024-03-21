package me.caua.aula07;

public class ListaDuplamenteEncadeada {

    private No<Integer> primeiro;
    private No<Integer> ultimo;
    private int size;

    public ListaDuplamenteEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        size = 0;
    }

    public boolean isEmpty() {
        // Verifica se a lista está vazia
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
        return size;
    }

    private void addToStart(Integer valor) {
        // Criando novo nó
        No<Integer> noAux = new No<>(valor);

        if (isEmpty()) {
            // Se for fazia, primeiro e ultimo são os mesmos nós
            this.primeiro = noAux;
            this.ultimo = noAux;
        } else {
            // se não for vazia, o anterior do primeiro será o novo elemento
            primeiro.setAnterior(noAux);
            // o próximo do novo elemento será o antigo primeiro
            noAux.setProximo(primeiro);
            // definir o primeiro como o novo elemento
            primeiro = noAux;
        }

        size++;
    }

    private void addToEnd(Integer valor) {
        // Criando novo nó
        No<Integer> noAux = new No<>(valor);

        if (isEmpty()) {
            // Se for fazia, primeiro e ultimo são os mesmos nós
            this.primeiro = noAux;
            this.ultimo = noAux;
        } else {
            // Caso não vazia, o último irá referenciar o novo elemento
            ultimo.setProximo(noAux);
            // o anterior do novo elemento irá referenciar o antigo ultimo
            noAux.setAnterior(ultimo);
            // definir o ultimo como o novo elemento
            ultimo = noAux;
        }

        size++;
    }

    private void addToMiddle(int valor) {
        No<Integer> noAux = new No<>(valor);

        No<Integer> atual = primeiro;
        // Percorre a lista até encontrar o local para inserir o novo valor
        while (atual != null && atual.getElemento() <= valor) {
            atual = atual.getProximo();
        }

        // se o atual for nulo, chegamos ao final da lista, por tanto vamos inserir no final
        if (atual == null) {
            addToEnd(valor);
            return;
        }

        // definir o nó anterior, se existir
        No<Integer> anterior;
        anterior = atual.getAnterior();
        atual.setAnterior(noAux);


        // Atualizar referencias do novo elemento
        noAux.setProximo(atual);
        noAux.setAnterior(anterior);

        // se o anterior não for nulo, ele irá referenciar o novo elemento
        if (anterior != null) anterior.setProximo(noAux);;

        size++;
    }

    public Integer remove(int valor) {

        if (isEmpty()) {
            System.out.println("A fila já está vazia.");
            return null;
        }

        if (valor == primeiro.getElemento()) {
            // Se o valor for igual ao primeiro, remover o primeiro
            return removeFirst();
        } else if (valor == ultimo.getElemento()) {
            // se o valor igual ao ultimo, remover o ultimo
            return removeLast();
        } else {
            // se não, procurar o valor para remover
            return removeMiddle(valor);
        }
    }


    private Integer removeFirst() {

        // verificar se está vazia
        if (isEmpty()) {
            System.out.println("A fila já está vazia.");
            return null;
        }

        // salvar valor para retornar
        Integer valor = primeiro.getElemento();

        // se o primeiro for o último elemento, defini-lo como nulo
        if (primeiro.getProximo() == null) {
            primeiro = null;
            ultimo = null;
        } else {
            // caso o primeiro não seja o ultimo elemento
            // definir o primeiro como o próximo elemento
            primeiro = primeiro.getProximo();

            // definir o anterior do atual primeiro como nulo
            if (primeiro.getAnterior() != null) {
                primeiro.setAnterior(null);
            }
        }

        size--;
        return valor;
    }

    private Integer removeLast() {

        if (isEmpty()) {
            System.out.println("A fila já está vazia.");
            return null;
        }

        Integer valorRemovido;

        // Se há apenas um elemento na lista, vamos remove-lo
        if (primeiro == ultimo) {
            valorRemovido = primeiro.getElemento();
            primeiro = null;
            ultimo = null;
        } else {
            // Se há mais de um elemento na lista

            // variaveis do ultimo elemento e o anterior
            No<Integer> atual = ultimo;
            No<Integer> anterior = ultimo.getAnterior();

            // salvar para retornar
            valorRemovido = atual.getElemento();

            assert anterior != null;
            // o penultimo elemento irá referenciar null
            anterior.setProximo(null);
            // o ultimo elemento irá virar o antigo penultimo
            ultimo = anterior;
        }

        size--;
        return valorRemovido;
    }

    private Integer removeMiddle(int valor) {

        if (isEmpty()) {
            System.out.println("A fila já está vazia.");
            return null;
        }

        Integer valorRemovido = null;
        boolean stop = false;

        // Referências dos nós
        No<Integer> atual = primeiro;
        while (!stop) {
            // se chegarmos ao valor desejado, atualizar as referencias removendo o nó
            if (valor == atual.getElemento()) {
                valorRemovido = atual.getElemento();
                if (atual.getAnterior() != null) {
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                } else {
                    primeiro = atual.getProximo();
                }
                stop = true;
            }

            // Se tiver chegado ao final da lista, retornar
            if (atual.getProximo() == null) return null;

            atual = atual.getProximo();
        }

        size--;
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
