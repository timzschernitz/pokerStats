CREATE TABLE `book` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `title` varchar(70) DEFAULT NULL,
                        `author_id` int(11) DEFAULT NULL,
                        `isbn` varchar(25) DEFAULT NULL,
                        `publication_year` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `book_id_uindex` (`id`),
                        UNIQUE KEY `book_isbn_uindex` (`isbn`),
                        KEY `book_author_id_fk` (`author_id`),
                        CONSTRAINT `book_author_id_fk` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;


CREATE TABLE `author` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `first_name` varchar(25) NOT NULL,
                          `last_name` varchar(25) NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `author_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


CREATE TABLE `user` (
    `user_name` varchar(30) NOT NULL,
    `first_name` varchar(25) DEFAULT NULL,
    `last_name` varchar(40) DEFAULT NULL,
    `location` varchar(30) DEFAULT NULL,
    `league` varchar(35) NOT NULL,
    `admin` tinyint(1) NOT NULL DEFAULT 0,
    PRIMARY KEY (`user_name`),
    UNIQUE KEY `user_name_u_index` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `game` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` varchar(30) NOT NULL,
    `date_played` date NOT NULL,
    `buy_in_paid` int(2) NOT NULL DEFAULT 20,
    `rebuy_paid` int(2) DEFAULT 0,
    `position_finished` int(2) NOT NULL,
    `money_won` int(3) DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY `game_id_u_index` (`id`),
    UNIQUE `user_date_game_u` (`user_id`, `date_played`),
    KEY `user_id_fk` (`user_id`),
    CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO test_poker.user VALUES ('poker star', 'jim', 'cunningham', 'East Madison',
                                            'MAD CITY POKER', 0);

INSERT INTO test_poker.user VALUES ('bigspender21', 'sal', 'morrison', 'Tomah',
                               'MAD CITY POKER', 1);

INSERT INTO poker.user VALUES ('stacksOcash', 'rich', 'diamonds', 'Minneapolis',
                                    'MAD CITY POKER', 0);

INSERT INTO poker.game (user_id, date_played, buy_in_paid, rebuy_paid, position_finished, money_won)
VALUES ('poker star', '2021/02/21', 20, 0, 1, 60);

INSERT INTO poker.game (user_id, date_played, buy_in_paid, rebuy_paid, position_finished, money_won)
VALUES ('bigspender21', '2021/02/21', 20, 20, 2, 20);

INSERT INTO poker.game (user_id, date_played, buy_in_paid, rebuy_paid, position_finished, money_won)
VALUES ('stacksOcash', '2021/02/21', 20, 0, 3, 0);


INSERT INTO poker.game (user_id, date_played, buy_in_paid, rebuy_paid, position_finished, money_won) VALUES ('poker star', '2021/02/21', 20, 0, 1, 60), ('bigspender21', '2021/02/21', 20, 20, 2, 20), ('stacksOcash', '2021/02/21', 20, 0, 3, 0);


