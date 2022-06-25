create table products(
    id bigserial primary key,
    title varchar (255),
    price int
);
insert into products (title,price)
values  ('tomatoes',20),
        ('beet',25),
        ('potatoes',30),
        ('radish',35),
        ('cucumbers',40),
        ('bread',45),
        ('butter',55),
        ('milk',60),
        ('egs',65),
        ('pepperoni',70),
        ('cheese',75),
        ('sausage',80);