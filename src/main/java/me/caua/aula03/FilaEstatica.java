package me.caua.aula03;

public class FilaEstatica {

    private int posicaoFila;
    private int filaArray[];

    public FilaEstatica(int tamanho) {
        filaArray = new int[tamanho];
        posicaoFila = 0;
    }

    public void inserir(int conteudo) {
        filaArray[posicaoFila] = conteudo;
        posicaoFila++;
    }

    public void remover() {
        filaArray[0] = 0;
    }

    public static void main(String[] args) {
        FilaEstatica f = new FilaEstatica(3);

        f.inserir(10);
        f.inserir(20);
        f.inserir(30);
    }
}
