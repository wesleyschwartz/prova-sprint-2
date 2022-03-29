package questoes.questao_2.main;

import questoes.questao_2.controller.FilmeController;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int escolha = 99;
        int qtdFilmes = 25;
        int pagina;
        FilmeController filmeController = new FilmeController();
        Scanner ler = new Scanner(System.in);
        do {
            System.out.println("Olá!!! O que deseja fazer?" +
                    "\n1 - Listar filmes" +
                    "\n0 - Sair");
            escolha = ler.nextInt();

            switch (escolha) {
                case 1:
                    do {
                        System.out.println("\nQuantos filmes deseja exibir?");
                        qtdFilmes = ler.nextInt();
                        if(qtdFilmes > 20){
                            System.out.println("Nós só temos 20 filmes catalogados");
                        }
                    }while(qtdFilmes > 20);

                    int qtdPaginas = Math.round(20F / qtdFilmes);

                    System.out.println("Com essa quantidade de filmes, você pode navegar até a página " + qtdPaginas + "." +
                            "\nQual página deseja visualizar ?");

                    pagina = ler.nextInt();

                    while (pagina > qtdPaginas) {
                        System.out.println("Por favor informe uma quantidade <= " + qtdPaginas + ". Tente novamente");
                        pagina = ler.nextInt();
                    }

                    filmeController.listarFilmes(qtdFilmes, pagina);
                    break;

                case 0:
                    System.out.println("Fechando o sistema...");
                    break;
                default:
                    System.out.println("Algo deu de errado... Tente novamente");
            }
        } while (escolha != 0);
        ler.close();
    }
}
