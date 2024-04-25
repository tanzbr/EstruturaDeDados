package me.caua.aula13;

public class Main {

    public static void main(String[] args) {
        ArvoreBinaria ab = new ArvoreBinaria();

        ab.inserirNo(null, 5);
        ab.inserirNo(null, 3);
        ab.inserirNo(null, 4);
        ab.inserirNo(null, 1);
        ab.inserirNo(null, 2);
        ab.inserirNo(null, 8);
        ab.inserirNo(null, 9);
        ab.inserirNo(null, 7);
        ab.inserirNo(null, 6);

        System.out.println("----- pré ordem -------");
        ab.buscaPreOrdem(ab.getRaiz(), 10);
        System.out.println("----- pós ordem -------");
        ab.buscaPosOrdem(ab.getRaiz(), 9);

        System.out.println("-----------");
        System.out.println("Resultado do elemento buscado: " + ab.buscar(ab.getRaiz(),10));

        System.out.println("----- antes remover -------");
        ab.buscaEmOrdem(ab.getRaiz(), 10);
        ab.remover(ab.getRaiz(), 2);
        ab.remover(ab.getRaiz(), 3);
        ab.remover(ab.getRaiz(), 7);
        System.out.println("----- após remover -------");
        ab.buscaEmOrdem(ab.getRaiz(), 10);

    }

}
