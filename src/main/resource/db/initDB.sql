drop table if exists users cascade;
drop table if exists competition cascade;
drop sequence if exists competition_sequence cascade;
drop sequence if exists user_sequence;


CREATE sequence user_sequence increment by 1 start with 1000;
CREATE sequence competition_sequence increment by 1 start with 1000;

Create table users
(
    user_id   Integer primary key DEFAULT nextval('user_sequence'),
    name     VARCHAR NOT NULL,
    lastName VARCHAR NOT NULL,
    age      INTEGER NOT NULL,
    email    VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    role     varchar not null
);
create unique index user_unique_email_index on users (email);

create table competition
(
    compt_id          INTEGER primary key default nextval('competition_sequence'),
    name        varchar NOT NULL,
    date_time        timestamp    not null,
    description varchar not null,
    userId      INTEGER ,
    foreign key (userId) references users (user_id)
);



insert into users
VALUES (nextval('user_sequence'), 'Vitaliy', 'Kovalenko', '44', 'vvvital@i.ua', '52159', 'ADMIN');
insert into users
VALUES (nextval('user_sequence'), 'Sergey', 'Kovalenko', '45', 'serg@i.ua', '52159', 'USER');
insert into users
VALUES (nextval('user_sequence'), 'Alex', 'Kovalenko', '46', 'alex@i.ua', '52159', 'USER');