create table test_poker.role
(
    id        int auto_increment primary key,
    role_name varchar(25) not null,
    user_name varchar(30) not null,
    user_id   int         not null,
    constraint role_id_uindex
        unique (id),
    constraint role_user_user_id_fk
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);