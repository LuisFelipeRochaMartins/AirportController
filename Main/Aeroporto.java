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

        int contador = 0;

        while(true){

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

            System.out.println("Fila Aterrissagem" + "\n" + filaAterrissagem.show_fila());
            System.out.println("Fila Decolagem" + "\n" + filaDecolagem.show_fila());

            System.out.println("Número de Aviões que decolaram : " + randDecolagem);
            System.out.println("Número de Aviões que aterrissaram : " + randAterrissagem);

            filaAterrissagem.diminuiCombustivelAvioes();

            System.out.printf("Deseja continuar a simulação? [0/1]");
            int opc = input.nextInt();

            while(opc != 0 && opc != 1) {
                System.out.println("Opção inválida, digite novamente!");
                opc = input.nextInt();
            }

            if(opc == 0){
                break;
            }
        }


    }
}
