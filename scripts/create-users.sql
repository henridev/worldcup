create table users (
    username varchar(50) not null primary key,
    password varchar(255) not null,
    enabled boolean not null) ;

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username),
    unique index authorities_idx_1 (username, authority)
);

INSERT INTO users(username,password,enabled)
VALUES
    ('user', '$2y$10$E.442wS/c9QXLpkLcXaOY.Bet9jTm/aoOUi65yvtuvmJuBJJu1KcG', '1'),
    ('admin', '$2y$10$xT2EKeAP.Ey84iy5dOwuOe5hxtRhvGVk6aLIpgAIpAzzu8xfJWPpO', '1')
;

INSERT INTO authorities(username,authority)
VALUES ('user', 'ROLE_USER'),('admin', 'ROLE_ADMIN');