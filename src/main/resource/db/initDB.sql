drop table if exists users cascade ;
drop sequence if exists global_seq cascade ;
drop sequence if exists serial;


CREATE sequence serial increment by 1 start with 1000;

Create table users
(
    id        Integer primary key DEFAULT nextval('serial'),
    name                             VARCHAR NOT NULL ,
    lastName                         VARCHAR NOT NULL ,
    age                              INTEGER NOT NULL ,
    email                            VARCHAR NOT NULL ,
    password                         VARCHAR NOT NULL,
    role                             varchar not null
);
create unique index user_unique_email_index on users (email);



insert into users VALUES (nextval('serial'),'Vitaliy','Kovalenko','44','vvvital@i.ua','52159','ADMIN');
insert into users VALUES (nextval('serial'),'Sergey','Kovalenko','45','serg@i.ua','52159','USER');
insert into users VALUES (nextval('serial'),'Alex','Kovalenko','46','alex@i.ua','52159','USER');