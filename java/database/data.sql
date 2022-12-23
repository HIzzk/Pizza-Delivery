BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Extra Cheese',1,false,true);
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Pepperoni',1,false,true);
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Basil',1,false,true);
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Black Olives',1,false,true);
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Sausage',1,false,true);
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Ham',1,false,true);
INSERT into topping (name,price,isPremium,isAvailable) VALUES ('Banana Peppers',1,false,true);

INSERT into specialty_pizzas (name, pizza_size, crust, sauce, image_url) VALUES ('Pepperoni', 'Large', 'Regular', 'Red', 'Assests/pepperoni-za.jpg');
INSERT into specialty_pizzas (name, pizza_size, crust, sauce, image_url) VALUES ('Supreme', 'Large', 'Regular', 'Red', 'Assests/supreme-za.jpg');
INSERT into specialty_pizzas (name, pizza_size, crust, sauce,image_url) VALUES ('Meat Lovers', 'Large', 'Regular', 'Red', 'Assests/meat-lovers.jpg');
INSERT into specialty_pizzas (name, pizza_size, crust, sauce,image_url) VALUES ('Veggie', 'Large', 'Regular', 'Red','Assests/Vegetarian-Pizza-720x720.jpg');
INSERT into specialty_pizzas (name, pizza_size, crust, sauce,image_url) VALUES ('Neopolitan', 'Large', 'Regular', 'Red','Assests/neapolitan-za.jpg');
INSERT into specialty_pizzas (name, pizza_size, crust, sauce,image_url) VALUES ('Cheese', 'Large', 'Regular', 'Red', 'Assests/cheese-za.jpg');

INSERT into specialty_pizza_toppings (pizza_id, topping_id) VALUES (1, 2);
INSERT into specialty_pizza_toppings (pizza_id, topping_id) VALUES (2, 4);
INSERT into specialty_pizza_toppings (pizza_id, topping_id) VALUES (3, 2);
INSERT into specialty_pizza_toppings (pizza_id, topping_id) VALUES (3, 5);
INSERT into specialty_pizza_toppings (pizza_id, topping_id) VALUES (3, 6);
INSERT into specialty_pizza_toppings (pizza_id, topping_id) VALUES (4, 3);
INSERT into specialty_pizza_toppings (pizza_id, topping_id) VALUES (4, 4);
INSERT into specialty_pizza_toppings (pizza_id, topping_id) VALUES (5, 1);
INSERT into specialty_pizza_toppings (pizza_id, topping_id) VALUES (6, 1);


COMMIT TRANSACTION;
