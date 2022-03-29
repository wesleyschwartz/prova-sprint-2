package questoes.questao_2.dao;

import questoes.questao_2.modelo.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    Connection connection;

    public FilmeDAO(Connection connection) {
        this.connection = connection;
    }

    public void listarFilmes(int qtdFilmes, int pagina) {

        List<Filme> filmeList = new ArrayList<>();
        String sql = "SELECT * FROM filmes LIMIT ? OFFSET ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, qtdFilmes);
            preparedStatement.setInt(2, (pagina * qtdFilmes) - qtdFilmes);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                Filme filme = new Filme(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4));
                filmeList.add(filme);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (!filmeList.isEmpty()) {
            for (Filme filme : filmeList) {
                System.out.println(filme);
            }
        }else{
            System.out.println("Nenhum filme encontrado, tente cadastrar no banco de dados");
        }
    }
}
