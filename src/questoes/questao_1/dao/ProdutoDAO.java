package questoes.questao_1.dao;

import questoes.questao_1.modelo.Produto;
import questoes.questao_1.util.ProdutosAleatorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar() {
        List<Produto> produtos = new ProdutosAleatorios().tresProdutosAleatorios();
        String sql = "INSERT INTO produto(nome, descricao, quantidade, preco) VALUES(?, ?, ?, ?)";
        try {
            for (Produto produto : produtos) {
                System.out.println("NOME: " + produto.getNome() +
                        "\nDESCRIÇÃO: " + produto.getDescricao() +
                        "\nQUANTIDADE: " + produto.getQuantidade() +
                        "\nPREÇO: " + produto.getPreco());
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, produto.getNome());
                preparedStatement.setString(2, produto.getDescricao());
                preparedStatement.setInt(3, produto.getQuantidade());
                preparedStatement.setDouble(4, produto.getPreco());
                int linhasAfetadas = preparedStatement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("\nItem cadastrado com sucesso\n");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizarPrimeiro() {
        List<Produto> produtos = pegarListaProduto();
        String sql = "UPDATE PRODUTO P SET P.nome = ?, P.descricao = ?, P.quantidade = ?, P.preco = ? WHERE idproduto = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            System.out.println("Atualizando o " + produtos.get(0).getNome());
            preparedStatement.setInt(5, produtos.get(0).getId());

            preparedStatement.setString(1, "Produto X");
            preparedStatement.setString(2, "Produto X, deve se atualizar o primeiro produto cadastrado na opção 1.");
            preparedStatement.setInt(3, 10);
            preparedStatement.setDouble(4, 99.99);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Primeiro item cadastrado atualizado");
            } else {
                System.out.println("Tente novamente");
            }
        } catch (SQLException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void excluirSegundo() {
        List<Produto> produtos = pegarListaProduto();
        String sql = "DELETE FROM PRODUTO  WHERE idproduto = ?;";
        if (produtos.size() > 0) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("Deletando o " + produtos.get(1).getNome());
                preparedStatement.setInt(1, produtos.get(1).getId());

                int i = preparedStatement.executeUpdate();
                if (i > 0) {
                    System.out.println("Segundo item do cadastro deletado");
                } else {
                    System.out.println("Tente novamente");
                }
            } catch (SQLException | IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

        public List<Produto> pegarListaProduto () {
            String sql = "SELECT * FROM produto";
            List<Produto> produtos = new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {
                    Produto produto = (
                            new Produto(resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getString(3),
                                    resultSet.getInt(4),
                                    resultSet.getDouble(5)));
                    produtos.add(produto);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return produtos;
        }
    }
