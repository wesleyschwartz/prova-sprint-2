package questoes.questao_1.util;

import questoes.questao_1.modelo.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProdutosAleatorios {
    private List<Produto> produtos = new ArrayList<>();

    public ProdutosAleatorios() {
        listaDeProdutos();
    }

    public List<Produto> tresProdutosAleatorios() {
        Random r = new Random();
        List<Produto> aleatorios = new ArrayList<>(3);
        for (int i = 0; i < 3; ) {
            Produto produto = produtos.get(r.nextInt(produtos.size()));
            if (!aleatorios.contains(produto)) {
                aleatorios.add(produto);
                i++;
            }
        }
        return aleatorios;
    }

    private void listaDeProdutos() {
        Produto mouse = new Produto(
                "Mouse Logitech G502HERO",
                "O G502 apresenta nosso sensor HERO 25K de última geração para máxima precisão e exatidão de rastreamento",
                10,
                314.90);
        this.produtos.add(mouse);
        Produto mouse2 = new Produto(
                "Mouse Razer Deathadder",
                "Desde a sua concepção, o Razer DeathAdder continua a oferecer o gameplay mais confortável de todos os tempos",
                15,
                130.50);
        this.produtos.add(mouse2);
        Produto teclado = new Produto(
                "Teclado Logitech G213",
                " G213 Prodigy traz o que há de melhor em desempenho com teclas construídas especificamente para jogadores",
                8,
                265.06);
        this.produtos.add(teclado);
        Produto teclado2 = new Produto(
                "TECLADO GAMER MECÂNICO",
                " Um teclado para jogos repleto de recursos e com belíssimo design que oferece teclas programáveis e controle dedicado de volume. Feito para proporcionar o melhor desempenho",
                5,
                1058.00);
        this.produtos.add(teclado2);
        Produto monitor = new Produto(
                "Monitor Curvo WQHD 34\" Dell",
                " Uma taxa de atualização de 144 Hz permite que imagens de movimento rápido sejam vistas com um nitidez incrível para tempos de reação mais rápido",
                2,
                4919.00);
        this.produtos.add(monitor);
        Produto monitor2 = new Produto(
                "Monitor Gamer LG Ultrawide 29\"",
                "O LG UltraWide Pro Gamer oferece 30% mais tela para uma incrível imersão visual, dando a vantagem que você precisa para ganhar de seus adversários.",
                3,
                1749.00);
        this.produtos.add(monitor2);
        Produto cpu = new Produto(
                "Processador AMD Ryzen 7 5700G",
                "3.8GHz, AM4, Vídeo Integrado, 8 Núcleos Amd ryzen 7 5700g",
                1,
                1975.90);
        this.produtos.add(cpu);
        Produto cpu2 = new Produto(
                "Intel Core i7-8700",
                "A 8ª geração de processadores Intel® Core™ redefine o desempenho do PC para desktop normal com até seis núcleos para obter mais potência de processamento, são dois núcleos a mais do que a geração anterior de processadores da família Intel® Core™,",
                2,
                1975.90);
        this.produtos.add(cpu2);
        Produto placaMae = new Produto(
                "Placa mãe ASRock B450 Pro4",
                "Suporta Soquete AMD AM4 Ryzen™ 2000, 3000, 4000 G-Series, 5000 e 5000 G-Series Desktop Processors",
                1,
                499.90);
        this.produtos.add(placaMae);

        Produto placaMae2 = new Produto(
                "Gigabyte B360M AORUS Intel LGA 1151,",
                "As placas-mãe GIGABYTE também possuem CIs anti-surto especiais que protegem sua placa-mãe e seu PC de qualquer sobrecarga de fornecimento de energia que possa ocorrer",
                1,
                749.90);
        this.produtos.add(placaMae2);

    }
}
