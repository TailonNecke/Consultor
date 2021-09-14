CREATE TABLE role_usuarios(
    usuario_id bigint not null,
    role_nome_role varchar(45) not null
);

ALTER TABLE role_usuarios ADD CONSTRAINT fk_usuario
FOREIGN key (usuario_id) REFERENCES usuario (id);

ALTER TABLE role_usuarios ADD CONSTRAINT fk_role
FOREIGN key (role_nome_role) REFERENCES role (nome_role);