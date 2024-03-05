package me.caua.aula03;

public class Main {

    public static void main(String[] args) {
        Array<String> arr = new Array<>();

        arr.add("Teste");
        arr.add("Teste2");

        for (String s : arr.getArray()) {
            System.out.println(s);
        }
    }

}
