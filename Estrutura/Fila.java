package Estrutura;


import java.util.Iterator;

public class Fila {

    /* Class Aviao */
    private Aviao inicio = null;
    private final int limite;
    private int tamanho = 0;
    public Fila(int limite) {
        this.limite = limite;
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
     * Remove o primeiro indice da Fila.
     */
    public void remover(){
        Aviao aviao = getInicio();
        if(aviao.getProx() != null){
            inicio = aviao.getProx();
        }else{
            inicio = null;
        }
        this.tamanho -= 1;
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
    public String mostraFila(){
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
     */
    public int checaCombustivel(){
        Aviao aviao = this.inicio;

        int avioesSemCombustivel = 0;
        while(aviao != null){
            if(aviao.getProx() != null){
                if(aviao.getProx().getCombustivel() <= 2){
                    aviao.setProx(aviao.getProx().getProx());
                    tamanho -= 1;
                    avioesSemCombustivel += 1;

                }
            }
            aviao = aviao.getProx();
        }
        return avioesSemCombustivel;
    }

    /**
     * Média de espera dos aviãos
     * @return String.
     */
    public float tempoMediaEspera(){
        Aviao aviao = this.inicio;
        int horas = 0;
        int minutos = 0;

        while(aviao != null){
            horas += aviao.getHoras();
            minutos += aviao.getMinutos();
            aviao = aviao.getProx();
        }

        if(tamanho == 0){
            return 0;
        }

        return ((horas * 60 + minutos) / tamanho);
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