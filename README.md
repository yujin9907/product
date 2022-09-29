# JUNIT 학습 - 배포를 위해

### 1. 테이블 생성

```SQL
create table product(
    product_id int primary key auto_increment,
    product_name varchar(20) not null,
    product_price int not null,
    product_qty int not null,
    create_at timestamp not null
);
create table customer(
    customer_id int primary key auto_increment,
    username varchar(20) not null,
    password varchar(20) not null,
    create_at timestamp not null
);
create table orders(
    order_id int primary key auto_increment,
    customer_id int not null,
    product_id int not null,
    create_at timestamp not null
);
```

### 2. 더미데이터

```sql

insert into customer(username, password, create_at) VALUES ('사용자1', '1234', now());
insert into customer(username, password, create_at) VALUES ('사용자2', '1234', now());

insert into product(product_name, product_price, product_qty, create_at) VALUES ('바나나', 3000, 98, now());
insert into product(product_name, product_price, product_qty, create_at) VALUES ('딸기', 2000, 100, now());

insert into orders(customer_id, product_id, create_at) values (1, 1, now());
insert into orders(customer_id, product_id, create_at) values (2, 1, now());
```
