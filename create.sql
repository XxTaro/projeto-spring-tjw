create sequence user_seq start with 1 increment by 50;
create table user (id bigint not null, email varchar(255), name varchar(255), password varchar(255), primary key (id));
