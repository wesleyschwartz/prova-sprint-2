package questoes.questao_2.controller;

import questoes.factory.ConnectionFactory;
import questoes.questao_2.dao.FilmeDAO;

import java.sql.Connection;

public class FilmeController {
    private FilmeDAO filmeDAO;

    public FilmeController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.filmeDAO =  new FilmeDAO(connection);
    }

    public void listarFilmes(int qtdFilmes, int pagina) {
        filmeDAO.listarFilmes(qtdFilmes, pagina);
    }
}
