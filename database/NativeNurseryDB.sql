START TRANSACTION;

DROP TABLE IF EXISTS plant_soil, soil, plant_category, category, plant_light, light, line_item, nursery_plant, sale, plant, nursery, customer CASCADE;

CREATE TABLE customer (
	customer_id serial,
	"name" varchar (100) NOT NULL,
	phone char (10) NOT NULL,
	email varchar(100) NOT NULL,
	address_1 varchar (100) NOT NULL,
	address_2 varchar (100),
	city varchar(100) NOT NULL,
	"state" char(2) NOT NULL,
	zip char(5) NOT NULL,
	CONSTRAINT PK_customer PRIMARY KEY(customer_id)
);

CREATE TABLE nursery (
	nursery_id serial,
	nursery_name varchar(100) NOT NULL,
	phone char(10) NOT NULL,
	website varchar(100) NOT NULL,
	primary_contact varchar(100) NOT NULL,
	has_storefront boolean NOT NULL,
	has_shipping boolean NOT NULL,
	CONSTRAINT PK_nursery PRIMARY KEY(nursery_id)
);

CREATE TABLE plant (
	plant_id serial,
	scientific_name varchar(100) NOT NULL,
	common_name varchar(100) NOT NULL,
	max_height_cm decimal(10, 1) NOT NULL,
	planting_month int NOT NULL,
	description varchar(200),
	bloom_color varchar(100),
	pollinator_friendly boolean NOT NULL,
	CONSTRAINT PK_plant PRIMARY KEY(plant_id),
	CONSTRAINT CK_planting_month CHECK(planting_month BETWEEN 1 AND 12)
);

CREATE TABLE sale (
	sale_id serial,
	customer_id int NOT NULL,
	nursery_id int NOT NULL,
	order_date date NOT NULL,
	is_delivery boolean NOT NULL,
	pickup_date date,
	delivery_date date,
	pickup_location varchar(200),
	CONSTRAINT PK_ordser PRIMARY KEY(sale_id),
	CONSTRAINT FK_customer_id FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
	CONSTRAINT FK_nursery_id FOREIGN KEY(nursery_id) REFERENCES nursery(nursery_id)
);

CREATE TABLE nursery_plant (
	nursery_id int NOT NULL,
	plant_id int NOT NULL,
	price decimal(10, 2) NOT NULL,
	quantity_available int,
	CONSTRAINT PK_nursery_plant PRIMARY KEY(nursery_id, plant_id),
	CONSTRAINT FK_nursery_id FOREIGN KEY(nursery_id) REFERENCES nursery(nursery_id),
	CONSTRAINT FK_plant_id FOREIGN KEY(plant_id) REFERENCES plant(plant_id),
	CONSTRAINT CK_quantity CHECK(quantity_available >= 0)
);

CREATE TABLE line_item (
	line_item_id serial,
	plant_id int NOT NULL,
	sale_id int NOT NULL,
	quantity int NOT NULL,
	CONSTRAINT PK_line_item PRIMARY KEY(line_item_id),
	CONSTRAINT FK_plant_id FOREIGN KEY(plant_id) REFERENCES plant(plant_id),
	CONSTRAINT FK_order_id FOREIGN KEY(sale_id) REFERENCES sale(sale_id),
	CONSTRAINT CK_quantity CHECK(quanity > 0)
);

CREATE TABLE light (
	light_id serial,
	light_name varchar(100) NOT NULL,
	CONSTRAINT PK_light PRIMARY KEY(light_id),
	CONSTRAINT UQ_light_name UNIQUE(light_name)
);

CREATE TABLE plant_light (
	plant_id int NOT NULL,
	light_id int NOT NULL,
	CONSTRAINT PK_plant_light PRIMARY KEY(plant_id, light_id),
	CONSTRAINT FK_plant_id FOREIGN KEY(plant_id) REFERENCES plant(plant_id),
	CONSTRAINT FK_light_id FOREIGN KEY(light_id) REFERENCES light(light_id)
);

CREATE TABLE category (
	category_id serial,
	category_name varchar(100) NOT NULL,
	CONSTRAINT PK_category PRIMARY KEY(category_id),
	CONSTRAINT UQ_category_name UNIQUE(category_name)
);

CREATE TABLE plant_category (
	plant_id int NOT NULL,
	category_id int NOT NULL,
	CONSTRAINT PK_plant_category PRIMARY KEY(plant_id, category_id),
	CONSTRAINT FK_plant_id FOREIGN KEY(plant_id) REFERENCES plant(plant_id),
	CONSTRAINT FK_category_id FOREIGN KEY(category_id) REFERENCES category(category_id)
);

CREATE TABLE soil (
	soil_id serial,
	soil_name varchar(100),
	CONSTRAINT PK_soil PRIMARY KEY(soil_id),
	CONSTRAINT UQ_soil_name UNIQUE(soil_name)
);

CREATE TABLE plant_soil (
	plant_id int NOT NULL,
	soil_id int NOT NULL,
	CONSTRAINT PK_plant_soil PRIMARY KEY(plant_id, soil_id),
	CONSTRAINT FK_plant_id FOREIGN KEY(plant_id) REFERENCES plant(plant_id),
	CONSTRAINT FK_soil_id FOREIGN KEY(soil_id) REFERENCES soil(soil_id)
);

INSERT INTO soil (soil_name) VALUES ('Moist soil'), ('Well-drained'), ('Clay');
INSERT INTO category (category_name) VALUES ('Tree'), ('Shrub'), ('Grass'), ('Edible'), ('Riparian');
INSERT INTO light (light_name) VALUES ('Full sun'), ('Full shade'), ('Partial sun');

COMMIT;