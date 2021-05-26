create table game
(
    id                int auto_increment primary key ,
    user_id           int    not null,
    tournament_name    varchar(40) not null,
    date_played       date           not null,
    buy_in_paid       int default 1500 not null,
    rebuy_paid        int default 0  null,
    position_finished int            not null,
    money_won         int default 0  null,
    constraint game_id_u_index
        unique (id),
    constraint user_id_fk
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
)
    charset = latin1;
