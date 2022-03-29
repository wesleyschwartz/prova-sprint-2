CREATE TABLE IF NOT EXISTS produto (
  idproduto INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255),
  descricao TEXT,
  quantidade INT,
  preco DOUBLE);
  
SELECT * FROM produto;

