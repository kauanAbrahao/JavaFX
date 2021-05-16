package sample;

public class Everton {

    public static void main(String[] args) {

        //Aqui eu vou carregar o vetor, ok?
        int[] vetor = new int[10]; //CRIEI UM VETOR DE 9 POSIÇÕES

        for(int i = 0; i<10; i++){
            vetor[i] = 999;
        }    //A CADA LOOP, A VARIAVEL i VAI SOMAR +1.

        for(int i = 0; i<10; i++){
            System.out.println("Posição " + i + ":" + vetor[i]);
        }

    }
}
