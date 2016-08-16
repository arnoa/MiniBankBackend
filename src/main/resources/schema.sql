CREATE TABLE ACCOUNT(
	id INTEGER IDENTITY PRIMARY KEY,
	balance decimal(19, 4),
	IBAN varchar(34),
	name varchar(255),
	currency varchar(255)
);

CREATE TABLE PAYMENT(
	id INTEGER IDENTITY PRIMARY KEY,
	amount decimal(19, 4),
	sender bigint,
	receiver bigint,
	payment_date timestamp,
	currency varchar(255),
	reference_no varchar(100),
	details varchar(255)
); 



	