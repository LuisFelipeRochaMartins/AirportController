package Estrutura;

public class Node {
    private Node prox;
    private int valor;

    public Node(int valor, Node prox) {
        this.prox = prox;
        this.valor = valor;
    }

    /**
     * Retorna o valor do próximo
     * @return
     */
    public Node getProx() {
        return prox;
    }

    public void setProx(Node prox) {
        this.prox = prox;
    }

    public int getValor() {
        return valor;
    }

    public void getValor(int valor) {
        this.valor = valor;
    }
}
