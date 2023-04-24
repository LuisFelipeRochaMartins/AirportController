package Main;
import Estrutura.*;
import java.util.Random;
import java.util.Scanner;

public class Aeroporto {

    public static void main(String[] args) {

        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        Fila filaDecolagem = new Fila(10);
        Fila filaAterrissagem = new Fila(10);

        boolean primeira = true;

        while(true){
            if(!primeira){
                System.out.println("\n=======================================================\n");

                filaAterrissagem.aumentaTempoTodosAviao();
                filaDecolagem.aumentaTempoTodosAviao();

                filaAterrissagem.diminuiCombustivelAvioes();
                System.out.println("Aviões que foram priorizados: " + filaAterrissagem.checaCombustivel());

                if(filaDecolagem.getInicio() != null){
                    for (int i = 0; i < rand.nextInt(0,3); i++) {
                        filaDecolagem.remover();
                    }
                }

                /* verifica quantos aviões foram priorizados e remove a quantidade que sobrar
                 * por exemplo se 1 avião com prioridade foi remove outro avião sem prioridade vai ser removido.
                 */
                if(filaAterrissagem.getInicio() != null){
                    for (int i = 0; i < filaAterrissagem.checaCombustivel() - 2; i++) {
                        filaAterrissagem.remover();
                    }
                }
            }

            int randDecolagem = rand.nextInt(0,3);
            int randAterrissagem = rand.nextInt(0,3);

            if(randAterrissagem != 0){
                for (int i = 0; i < randAterrissagem; i++) {
                    Aviao aviao = new Aviao(rand.nextInt(4,11),null);
                    filaAterrissagem.inserir(aviao);
                }
            }

            if(randDecolagem != 0){
                for (int i = 0; i < randDecolagem; i++) {
                    Aviao aviao = new Aviao(rand.nextInt(4,11),null);
                    filaDecolagem.inserir(aviao);
                }
            }

            System.out.println("Fila Aterrissagem" + "\n" + filaAterrissagem.mostraFila());
            System.out.println("Fila Decolagem" + "\n" + filaDecolagem.mostraFila());


            System.out.println("Número de Aviões que decolaram : " + randDecolagem);
            System.out.println("Número de Aviões que aterrissaram : " + randAterrissagem + "\n");

            System.out.println("Tempo de Espera da Fila de Aterrissagem: " + filaDecolagem.tempoMediaEspera());
             System.out.println("Tempo de Espera da Fila de Decolagem: " + filaAterrissagem.tempoMediaEspera());

            System.out.print("Deseja continuar a simulação? [0/1] ");
            int opc = input.nextInt();

            while(opc != 0 && opc != 1) {
                System.out.println("Opção inválida, digite novamente!");
                opc = input.nextInt();
            }

            if(opc == 0){
                break;
            }

            if(primeira){
                primeira = !primeira;
            }
        }
    }
}
