create sequence t_artists_SEQ start with 1 increment by 50;
create sequence t_customers_SEQ start with 1 increment by 50;
create sequence t_publishers_SEQ start with 1 increment by 50;
create table t_artists (created_date timestamp(6) with time zone not null, id bigint not null, name varchar(50) not null, bio varchar(3000), primary key (id));
create table t_customers (created_date timestamp(6) with time zone not null, id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, email varchar(255) not null, primary key (id));
create table t_publishers (created_date timestamp(6) with time zone not null, id bigint not null, name varchar(50) not null, primary key (id));
