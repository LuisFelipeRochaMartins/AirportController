package Estrutura;

public class Fila {
    /* Class Aviao */
    private Aviao inicio = null;
    private final int limite;
    private int tamanho = 0;

    public Fila(int limite) {
        this.limite = limite;
    }

    /**
     * Retorna o primeiro indíce da Fila.
     * @return int
     */
    public Aviao getinicio() {
        return inicio;
    }

    /**
     * Remove o primeiro indice da Fila.
     */
    public void remover(){
        inicio = inicio.getProx();
        this.tamanho -= 1;
    }

    /**
     * Retorna o Tamanho da Fila.
     * @return int
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Retorna o Aviao do inicio da Fila.
     * @return Aviao
     */
    public Aviao getInicio() {
        return inicio;
    }

    /**
     * Define o Inicio da Fila.
     * @param inicio Aviao
     */
    public void setInicio(Aviao inicio) {
        this.inicio = inicio;
    }

    /**
     * Define o limite da Fila.
     * @return int
     */
    public int getLimite() {
        return limite;
    }

    /**
     * Define o tamanho da Fila.
     * @param tamanho int
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Retorna se a fila pode incrementada.
     * @return boolean.
     */

    public boolean temEspaco(){
        return limite > tamanho;
    }

    /**
     * Retorna a fila por completo. Não necessário utilizar um loop para percorrê-lo.
     * @return String.
     */
    public String show_fila(){
        Aviao atual = this.inicio;
        StringBuilder texto = new StringBuilder();
        while (atual != null){
            texto.append(texto.append(atual).append("\n"));
            atual = atual.getProx();
        }
        return texto.toString();
    }

    /**
     * Inseri o Próximo Avião a Fila.
     * @param valor int
     */
    public void inserir(int valor){
        if (temEspaco()) {
            Aviao novoAviao = new Aviao(10, null);
            if (this.inicio == null){
                this.inicio = novoAviao;
            } else {
                Aviao atual = this.inicio;
                while (atual.getProx() != null){
                    atual = atual.getProx();
                }
                atual.setProx(novoAviao);
            }
            this.tamanho += 1;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Tamanho = ").append(getTamanho());
        return sb.toString();
    }
}