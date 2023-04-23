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

    public boolean verificaFilaVazia(){
        return this.inicio != null;
    }

    /**
     * Retorna a fila por completo. Não necessário utilizar um loop para percorrê-lo.
     * @return String.
     */
    public String show_fila(){
        Aviao atual = this.inicio;
        StringBuilder texto = new StringBuilder();
        while (atual != null){
            texto.append(atual).append("\n");
            atual = atual.getProx();
        }
        return texto.toString();
    }

    /**
     * Inseri o Próximo Avião a Fila.
     * @param novoAviao Aviao.
     */
    public void inserir(Aviao novoAviao){
        if (temEspaco()) {
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

    /**
     * Checa o combustível de todos os aviões que estão para pousar, se tiver algum avião que tenha pouco combustível,
     * esse avião é priorizado.
     * @param FilaDecolagem Fila de decolagem que vai receber o Avião, caso o avião estiver com pouco combustível.
     */
    public void checaCombustivel(Fila FilaDecolagem){
        Aviao aviao = this.inicio;
        while(aviao != null){
            if(aviao.getCombustivel() <= 2){
                FilaDecolagem.inserir(aviao);
                aviao = aviao.getProx();
            }
        }
    }

    /**
     * Média de espera dos aviãos
     * @return String.
     */
    public int tempoMediaEspera(){
        Aviao aviao = this.inicio;
        int horas = 0;
        int minutos = 0;

        while(aviao != null){
            horas += aviao.getHoras();
            minutos += aviao.getMinutos();
        }
        int tempo = horas * 60 + minutos / tamanho;

        return tempo;
    }

    /**
     * Cada vez que for chamada diminui o combustível em -1.
     */
    public void diminuiCombustivelAvioes(){
        Aviao aviao = this.inicio;

        while(aviao != null){
            aviao.setCombustivel(aviao.getCombustivel()-1);
            aviao = aviao.getProx();
        }
    }

    /**
     * Aumenta o tempo de todos os aviões dentro da fila.
     */
    public void aumentaTempoTodosAviao(){
        Aviao aviao = this.inicio;

        while(aviao != null){
            aviao.aumentaTempo();
            aviao = aviao.getProx();
        }
    }
}