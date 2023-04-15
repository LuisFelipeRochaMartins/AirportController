package Estrutura;

public class Relogio {

    public int minutos;

    public int horas;

    /**
     * Constructor da Classe Relógio.
     * @param minutos minutos.
     * @param horas horas.
     */
    public Relogio(int minutos, int horas){
        setMinutos(minutos);
        setHoras(horas);
    }

    /**
     * Retorna os minutos do Relogio.
     * @return minutos
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * Define os minutos do Relógio.
     * @param minutos minutos.
     */
    public void setMinutos(int minutos) {
        if(minutos > 60){
            minutos = minutos % 60;
            horas += 1;
        }
        this.minutos = minutos;
    }

    /**
     * Retorna as horas do Relógio.
     * @return horas
     */
    public int getHoras() {
        return horas;
    }

    /**
     * Define as horas do Relogio.
     * @param horas horas
     */
    public void setHoras(int horas) {
        if(horas > 24){
            horas = horas % 24;
        }
        this.horas = horas;
    }


    /**
     * Método que incrementa os minutos em 10.
     */
    public void aumentaTempo(){
        minutos += 10;
        if(minutos == 60){
            horas += 1;
            minutos = 0;
            if(horas > 24){
                horas = 0;
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Horario Atual: ");
        sb.append(getMinutos()).append(':');
        sb.append(getHoras());
        return sb.toString();
    }
}
