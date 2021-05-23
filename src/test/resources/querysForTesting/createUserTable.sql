create table test_poker.user
(
    id int(11) not null auto_increment primary key,
    user_name  varchar(30)          not null,
    pass varchar(30) not null,
    first_name varchar(25)          null,
    last_name  varchar(40)          null,
    location   varchar(30)          null,
    league     varchar(35)          not null,
    admin      tinyint(1) default 0 not null,

    constraint user_name_u_index
        unique (user_name)
)
    charset = latin1;

