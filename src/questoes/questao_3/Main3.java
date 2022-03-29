package questoes.questao_3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main3 {
    public static void main(String[] args) {
        try (Scanner ler = new Scanner(System.in)) {
            String divertido = ":-\\)" ;
            String triste = ":-\\(" ;

            System.out.println("Expresse sua frase sentimental: ");
            String frase = ler.nextLine();

            int qtdDivertido = (int) Pattern.compile(divertido).matcher(frase).results().count();
            int qtdTriste = (int) Pattern.compile(triste).matcher(frase).results().count();


            String saida = "" ;
            if (qtdTriste < qtdDivertido) {
                saida = "divertido" ;
            } else if (qtdTriste == qtdDivertido) {
                saida = "neutro" ;
            } else {
                saida = "chateado" ;
            }
            System.out.println("Você está " + saida);
        }
    }
}

