package me.caua.aula14;

public class Main {

    public static void main(String[] args) {
        ArvoreBinaria ab = new ArvoreBinaria();

        //      10
        //    5    12
        //   2 6  11  13
        //               18
        //              17

        ab.inserirNo(null, 10);
        ab.inserirNo(null, 5);
        ab.inserirNo(null, 2);
        ab.inserirNo(null, 6);
        ab.inserirNo(null, 12);
        ab.inserirNo(null, 11);
        ab.inserirNo(null, 13);
        ab.inserirNo(null, 18);
        ab.inserirNo(null, 17);

        System.out.println(ab.getAltura(ab.getRaiz())); // resultado esperado: 4

//        ab.inserirNo(null, 5);
//        ab.inserirNo(null, 3);
//        ab.inserirNo(null, 4);
//        ab.inserirNo(null, 1);
//        ab.inserirNo(null, 2);
//        ab.inserirNo(null, 8);
//        ab.inserirNo(null, 9);
//        ab.inserirNo(null, 7);
//        ab.inserirNo(null, 6);
//
//        System.out.println("----- pré ordem -------");
//        ab.buscaPreOrdem(ab.getRaiz(), 10);
//        System.out.println("----- pós ordem -------");
//        ab.buscaPosOrdem(ab.getRaiz(), 9);
//
//        System.out.println("-----------");
//        System.out.println("Resultado do elemento buscado: " + ab.buscar(ab.getRaiz(),10));
//
//        System.out.println("----- antes remover -------");
//        ab.buscaEmOrdem(ab.getRaiz(), 10);
//        ab.remover(ab.getRaiz(), 2);
//        ab.remover(ab.getRaiz(), 3);
//        ab.remover(ab.getRaiz(), 7);
//        System.out.println("----- após remover -------");
//        ab.buscaEmOrdem(ab.getRaiz(), 10);

    }

}
