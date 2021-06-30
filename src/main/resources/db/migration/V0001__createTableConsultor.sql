CREATE TABLE consultor(
id_consultor bigInt not null auto_increment,
id_fornecedor bigInt not null,
nome varchar(100) not null,
email varchar(100) not null,
telefone varchar(45) not null,
atuacao varchar(60) not null,
valor_hora double not null,
primary key (id_consultor)
);
