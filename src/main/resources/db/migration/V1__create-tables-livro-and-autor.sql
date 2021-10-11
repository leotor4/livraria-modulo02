create table livros(
id bigint not null auto_increment,
title varchar(100) not null,
publication_date date not null,
price decimal(10,2) not null,
pages int not null,
primary key(id)
);

create table autores(
id bigint not null auto_increment,
name varchar(100) not null,
email varchar(100) not null,
birthday date not null,
curriculum varchar(255) ,
primary key(id)
);

create table autor_has_livro(
autor_id bigint not null,
livro_id bigint not null,
primary key(autor_id, livro_id),
constraint FK_autor_id foreign key(autor_id)
references autores(id),
constraint FK_livro_id foreign key(livro_id)
references livros(id)
);
