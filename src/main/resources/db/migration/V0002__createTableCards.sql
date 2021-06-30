CREATE TABLE card(
id_card bigInt not null auto_increment,
secao varchar(50) not null,
cod_projeto bigInt not null,
desc_projeto varchar(500) not null,
status varchar(50) not null,
data_inicio date not null,
data_encerramento date not null,
horas_apontadas integer,
primary key (id_card)
);
