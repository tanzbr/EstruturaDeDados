package me.caua.aula13;

public class No {

    private Integer elemento;
    private No esquerdo;
    private No direito;

    public No(Integer elemento) {
        this.elemento = elemento;
        this.esquerdo = null;
        this.direito = null;
    }

    public Integer getElemento() {
        return elemento;
    }

    public void setElemento(Integer elemento) {
        this.elemento = elemento;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public No getDireito() {
        return direito;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento=" + elemento +
                ", esquerdo=" + esquerdo +
                ", direito=" + direito +
                '}';
    }
}
