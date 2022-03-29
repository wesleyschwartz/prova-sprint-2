package questoes.questao_1.controller;

import questoes.factory.ConnectionFactory;
import questoes.questao_1.dao.ProdutoDAO;

import java.sql.Connection;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.produtoDAO = new ProdutoDAO(connection);
    }


    public void cadastrar() {
        this.produtoDAO.cadastrar();
    }


    public void atualizarPrimeiro() {
        this.produtoDAO.atualizarPrimeiro();
    }

    public void excluirSegundo() {
        this.produtoDAO.excluirSegundo();
    }
}
