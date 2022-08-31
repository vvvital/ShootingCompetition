drop table if exists users;
drop sequence global_seq cascade ;
drop sequence if exists global_seq;


CREATE sequence global_seq start with 1000;

Create table users
(
    id        Integer primary key DEFAULT nextval('global_seq'),
    name                             VARCHAR NOT NULL ,
    lastName                         VARCHAR NOT NULL ,
    age                              INTEGER NOT NULL ,
    email                            VARCHAR NOT NULL ,
    password                         VARCHAR NOT NULL
);
create unique index user_unique_email_index on users (email);

create table categories
(
    user_id                           INTEGER NOT NULL ,
    category                         VARCHAR NOT NULL ,
    constraint user_category_index UNIQUE (user_id,category),
    foreign key (user_id) REFERENCES users (id) ON DELETE CASCADE
)