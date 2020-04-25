CREATE TABLE replacement(
	id SERIAL PRIMARY KEY,
	name_of_medicine VARCHAR (50) NOT NULL,
	generic VARCHAR (50) NOT NULL
	);
CREATE TABLE medicine(
	id SERIAL PRIMARY KEY,
	name_of_medicine VARCHAR (50) NOT NULL,
	inn VARCHAR (50) NOT NULL,
	farm_group VARCHAR (50) NOT NULL,
	replacement_id INTEGER,
	FOREIGN KEY (replacement_id) REFERENCES replacement (id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE pharmacy(
	id SERIAL PRIMARY KEY,
	pharmacy_name VARCHAR (50) NOT NULL,
	city VARCHAR (20) NOT NULL,
	address VARCHAR (50) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
	medicine_id INTEGER,
	FOREIGN KEY (medicine_id) REFERENCES medicine(id) ON DELETE CASCADE
);
INSERT INTO replacement (name_of_medicine, generic) VALUES ('Эналаприл','Эналаприл Гексал, Берлиприл');
INSERT INTO replacement (name_of_medicine, generic) VALUES ('Зиннат','Мегасеф, Зинекс');
INSERT INTO medicine (name_of_medicine,inn, farm_group, replacement_id) VALUES ('Берлиприл','Эналаприл','антигипертензивные',1);
INSERT INTO medicine (name_of_medicine,inn, farm_group, replacement_id) VALUES ('Мегасеф','Цефуроксим','антибиотик',2);
INSERT INTO pharmacy (pharmacy_name,city,address,medicine_id) VALUES ('Любимая аптека','Минск','Леси Украинки-22',1);
INSERT INTO pharmacy (pharmacy_name,city,address,medicine_id) VALUES ('Зеленая аптека','Витебск','Московский пр. 7',2);