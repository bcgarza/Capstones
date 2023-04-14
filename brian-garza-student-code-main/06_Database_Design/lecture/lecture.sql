Begin Transaction;
Drop Table If Exists invoice;
Drop Table If Exists invoice_pet;
Drop Table If Exists pet;
Drop Table If Exists customer;

Create Table invoice
(
	invoice_id serial,
	invoice_date timestamp not null,
	customer_id int,
	
	Primary Key(invoice_id)
);

Create Table invoice_pet
(
	invoice_id int,
	pet_id int,
	pet_procedure varchar(200)Not null,
	amount money Not null,
	
	Primary Key(invoice_id, pet_id) 
);

Create Table pet
(
	pet_id serial,
	pet_name varchar(200) not null,
	customer_id int,
	
	Primary Key (pet_id)
);

Create Table customer
(
	customer_id serial,
	customer_name varchar(200)Not Null,
	customer_street varchar(200) Not Null,
	customer_city varchar(200) Not Null,
	customer_state varchar(200) Not Null,
	customer_zipcode varchar(200) Not Null,
	
	Primary Key(customer_id)
);

Alter Table invoice
Add Foreign Key (customer_id) References customer(customer_id);

Alter Table invoice_pet 
Add Foreign Key (invoice_id) References invoice(invoice_id);

Alter Table invoice_pet
Add Foreign Key (pet_id) References pet(pet_id);

Alter Table pet
Add foreign key (customer_id) references customer(customer_id);

Commit;