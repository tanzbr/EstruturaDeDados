package me.caua.aula05;

public class Main {

    public static void main(String[] args) {
        testarPilha();
        testarFila();
    }

    public static void testarFila() {
        System.out.println("---- Testando fila");
        FilaDinamica<Float> f = new FilaDinamica<>();

        f.push(1F);
        f.push(2F);
        f.push(3F);
        f.imprimir();
        System.out.println("Tamanho: " + f.size());
        System.out.println("-------");
        System.out.println("Removendo item " + f.pop());
        System.out.println("Removendo item " + f.pop());
        f.imprimir();

        f.pop();
        f.pop();
        f.imprimir();

        f.push(10F);
        f.imprimir();
    }

    public static void testarPilha() {
        System.out.println("---- Testando pilha");
        PilhaDinamica<String> p = new PilhaDinamica<>();

        p.push("Teste 1");
        p.push("Teste 2");
        p.push("Teste 3");
        System.out.println("Tamanho: " + p.size());
        System.out.println("-------");
        p.imprimir();
        p.push("Teste 4");
        p.pop();
        p.pop();
        p.pop();
        System.out.println("-------");
        p.imprimir();
        p.pop();

        p.pop();

    }

}
