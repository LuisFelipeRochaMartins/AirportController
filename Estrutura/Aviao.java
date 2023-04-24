package Estrutura;
import java.util.Random;

public class Aviao {

    private String nome;
    private int combustivel;
    /* Class Aviao */
    private Aviao prox;

    private int horas;
    private int minutos;

    public Aviao(int combustivel, Aviao prox) {
        setNome(criaNome());
        setCombustivel(combustivel);
        setProx(prox);
    }

    /**
     * Retorna os horas que aviao está esperando pra pousar ou pra decolar.
     * @return int
     */
    public int getHoras() {
        return horas;
    }

    /**
     * Define o tempo de espera de um aviao.
     * @param horas int
     */
    public void setHoras(int horas) {
        this.horas = horas;
    }

    /**
     * Retorna os minutos que aviao está esperando pra pousar ou pra decolar.
     * @return int
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     *
     * Define o tempo de espera de um aviao.
     * @param minutos int
     */
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a quantidade de combustível.
     * @return int.
     */
    public int getCombustivel() {
        return combustivel;
    }

    /**
     * Define a Quantidade de Avioes.
     */
    public void setCombustivel(int combustivel) {
        if(combustivel > 0){
            this.combustivel = combustivel;
        }
    }

    /**
     * Retorna o próximo aviao da Lista de Aviões.
     * @return prox
     */
    public Aviao getProx() {
        return prox;
    }

    /**
     * Retorna o próximo aviao da Lista de Aviões.
     * @param prox Aviao.
     */
    public void setProx(Aviao prox) {
        this.prox = prox;
    }

    /**
     * Retorna um nome aleatório para o aviao.
     * @return String.
     */
    public String criaNome(){
        Random rand = new Random();
        String[] nome = {"Embraer ERJ-170", "Airbus A319" , "Boeing 747-200", "Cessna 162 Skycatcher",
                         "Airbus A320-200", "Embraer 175-E2", "Boeing 777-300", "Cessna 210 Centurion",
                         "Boeing 777-200", "Embraer 190-E2", "ATR 42-600", "Lockheed L-1011 Tristar",
                         "McDonnell Douglas DC-10", "Ilyushin Il-86", "Tupolev Tu-134", "EMB-120 Brasilia",
                         "Boeing 787-10", "Airbus A350-900", "Cessna 180 Skywagon", "McDonnell Douglas MD-90-30"
        };

        return nome[rand.nextInt(0,20)];
    }

    public void aumentaTempo(){
        minutos += 30;
        if(minutos == 60){
            horas += 1;
            minutos = 0;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Nome = ").append(getNome()).append(" | ");
        sb.append("Combustível = ").append(getCombustivel()).append(" | ");

        if(this.getHoras() < 10 && this.getMinutos() == 0){
            sb.append("Tempo Esperando= ").append("0" + this.getHoras() + ":").append("0" + this.getMinutos());
        } else if (this.getMinutos() == 0){
            sb.append("Tempo Esperando= ").append(this.getHoras() + ":").append("0" + this.getMinutos());
        } else{
            sb.append("Tempo Esperando= ").append(this.getHoras() + ":").append(this.getMinutos());
        }
        return sb.toString();
    }
}
