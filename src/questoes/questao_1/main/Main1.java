package questoes.questao_1.main;

import questoes.questao_1.controller.ProdutoController;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        ProdutoController produtoController = new ProdutoController();
        int escolha = 99;
        try (Scanner ler = new Scanner(System.in)) {
            do {
                System.out.println("Olá, o que deseja fazer?");
                System.out.println(" 1 - Cadastrar produtos"
                        + "\n 2 - Atualizar o primeiro produto cadastrado"
                        + "\n 3 - Excluir o segundo produto cadastrado"
                        + "\n 0 - Encerrar o sistema");
                    escolha = ler.nextInt();
                    switch (escolha) {
                        case 1:
                            produtoController.cadastrar();
                            break;
                        case 2:
                            produtoController.atualizarPrimeiro();
                            break;
                        case 3:
                            produtoController.excluirSegundo();
                            break;
                        case 0:
                            System.out.println("Sistema encerrado");
                            break;
                        default:
                            System.out.println("Tente novamente");
                    }
            } while (escolha != 0);
        }
    }
}
