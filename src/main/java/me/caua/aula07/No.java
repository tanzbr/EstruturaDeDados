package me.caua.aula07;

public class No<T> {

    private T elemento;
    private No<T> proximo = null;
    private No<T> anterior = null;

    public No(T elemento, No<T> proximo, No<T> anterior) {
        this.elemento = elemento;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public No(T elemento) {
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }
}
