package Aeroporto;
import Estrutura.Fila;
public class Aeroporto {

    private final int capacidade = 15;


    /* Class Fila */
    private Fila Avioes;

    /**
     * Retorna a Capacidade de avioes que o aeroporto possui.
     * @return int
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Retorna a Quantidade de Avioes.
     * @return Fila
     */
    public Fila getAvioes() {
        return Avioes;
    }

    /**
     * Retorna a quantidade de Aviões.
     * @param avioes Fila
     */
    public void setAvioes(Fila avioes) {
        Avioes = avioes;
    }

}
