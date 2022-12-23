BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, pizza, specialty_pizzas, orders, topping, order_pizza, specialty_pizza_toppings, pizza_toppings, customer;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

create table pizza (
pizza_id serial,
name varchar(50) DEFAULT 'Custom Pizza',
pizza_size varchar(50) not null,
crust varchar(50) not null,
sauce varchar(50),

constraint pk_pizza_id primary key (pizza_id)
);

create table orders (
order_id serial,
order_time timestamp,
order_status varchar(50) not null,
price decimal not null,
isDelivery Boolean,

constraint pk_order_id primary key (order_id)
);

create table topping (
name varchar(50) not null,
topping_id serial,
price decimal not null,
isPremium boolean,
isAvailable boolean,

constraint pk_topping_id primary key (topping_id)
);

create table order_pizza (
pizza_id int not null,
order_id int not null,

constraint fk_pizza foreign key (pizza_id) references pizza(pizza_id),
constraint fk_order foreign key (order_id) references orders(order_id),
constraint pk_pizza_order primary key (pizza_id,order_id)
);

create table pizza_toppings (
pizza_id int,
topping_id int,
constraint fk_pizza_top foreign key (pizza_id) references pizza(pizza_id),
constraint fk_topping_piz foreign key (topping_id) references topping(topping_id),
constraint pk_topping_pizza primary key (pizza_id,topping_id)
);

create table specialty_pizzas (
pizza_id serial,
name varchar(50) DEFAULT 'Custom Pizza',
pizza_size varchar(50) not null,
crust varchar(50) not null,
sauce varchar(50),
image_url varchar(50),

constraint pk_specialty_pizza_id primary key (pizza_id)
);

create table specialty_pizza_toppings (
pizza_id int,
topping_id int,
constraint fk_specialty_pizza_top foreign key (pizza_id) references specialty_pizzas(pizza_id),
constraint fk_specialty_topping_piz foreign key (topping_id) references topping(topping_id),
constraint pk_specialty_topping_pizza primary key (pizza_id,topping_id)
);

create table customer (
cust_id serial primary key,
order_id int,
address varchar(100),
credit_card varchar(16),
CVV varchar(3),
constraint fk_order foreign key (order_id) references orders(order_id)
);



COMMIT TRANSACTION;
