package Estrutura;
import java.util.Random;

public class Aviao {

    private String nome;

    private int combustivel;

    private Aviao prox;

    public Aviao(int combustivel, Aviao prox) {
        setNome(criaNome());
        setCombustivel(combustivel);
        setProx(prox);
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
     * @param prox Aviao
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

        return nome[rand.nextInt(0,19)];
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Aviao:").append("\n");
        sb.append("Nome =").append(getNome()).append("\n");
        sb.append("Combustível = ").append(getCombustivel()).append("\n");
        return sb.toString();
    }
}
