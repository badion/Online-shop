-- Скрипт сгенерирован Devart dbForge Studio for MySQL, Версия 6.1.166.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 16.10.2014 16:36:27
-- Версия сервера: 5.6.19-log
-- Версия клиента: 4.1

-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

-- 
-- Установка базы данных по умолчанию
--
USE online_shop;

--
-- Описание для таблицы groupp
--
DROP TABLE IF EXISTS groupp;
CREATE TABLE groupp (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 5
AVG_ROW_LENGTH = 4096
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы role
--
DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 3
AVG_ROW_LENGTH = 8192
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы customer
--
DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
  id INT(11) NOT NULL AUTO_INCREMENT,
  id_role INT(11) DEFAULT NULL,
  locked TINYINT(4) DEFAULT NULL,
  fname VARCHAR(255) DEFAULT NULL,
  lname VARCHAR(255) DEFAULT NULL,
  email VARCHAR(255) DEFAULT NULL,
  login VARCHAR(255) DEFAULT NULL,
  password VARCHAR(255) DEFAULT NULL,
  phone VARCHAR(255) DEFAULT NULL,
  email_confirm TINYINT(1) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_customer_role_id FOREIGN KEY (id_role)
    REFERENCES role(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 8
AVG_ROW_LENGTH = 3276
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы product
--
DROP TABLE IF EXISTS product;
CREATE TABLE product (
  id INT(50) NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) DEFAULT NULL,
  price DECIMAL(19, 2) DEFAULT NULL,
  description VARCHAR(255) DEFAULT NULL,
  id_group INT(11) DEFAULT NULL,
  quantity INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_product_groupp_id FOREIGN KEY (id_group)
    REFERENCES groupp(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 13
AVG_ROW_LENGTH = 2048
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы checkout
--
DROP TABLE IF EXISTS checkout;
CREATE TABLE checkout (
  id INT(11) NOT NULL AUTO_INCREMENT,
  order_status VARCHAR(255) DEFAULT NULL,
  id_customer INT(11) DEFAULT NULL,
  date DATETIME DEFAULT NULL,
  price_sum DECIMAL(19, 2) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX UK_checkout_id (id),
  CONSTRAINT FK_checkout_customer_id FOREIGN KEY (id_customer)
    REFERENCES customer(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 54
AVG_ROW_LENGTH = 8192
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы checkout_products
--
DROP TABLE IF EXISTS checkout_products;
CREATE TABLE checkout_products (
  id INT(11) NOT NULL AUTO_INCREMENT,
  id_product INT(11) NOT NULL DEFAULT 0,
  id_order INT(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  UNIQUE INDEX UK_checkout_products_id (id),
  CONSTRAINT FK_checkout_products_checkout_id FOREIGN KEY (id_order)
    REFERENCES checkout(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_checkout_products_product_id FOREIGN KEY (id_product)
    REFERENCES product(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 64
AVG_ROW_LENGTH = 5461
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы purchased_products
--
DROP TABLE IF EXISTS purchased_products;
CREATE TABLE purchased_products (
  id INT(11) NOT NULL AUTO_INCREMENT,
  id_customer INT(11) DEFAULT NULL,
  shipping VARCHAR(255) DEFAULT NULL,
  country VARCHAR(255) DEFAULT NULL,
  city VARCHAR(255) DEFAULT NULL,
  address VARBINARY(255) DEFAULT NULL,
  id_order INT(11) DEFAULT NULL,
  total_sum VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_purchased_products_checkout_products_id FOREIGN KEY (id_order)
    REFERENCES checkout_products(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_purchased_products_customer_id FOREIGN KEY (id_customer)
    REFERENCES customer(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 10
AVG_ROW_LENGTH = 8192
CHARACTER SET utf8
COLLATE utf8_general_ci;

-- 
-- Вывод данных для таблицы groupp
--
INSERT INTO groupp VALUES
(1, 'Laptops'),
(2, 'Phones'),
(3, 'Tablets'),
(4, 'eBooks');

-- 
-- Вывод данных для таблицы role
--
INSERT INTO role VALUES
(1, 'customer'),
(2, 'admin');

-- 
-- Вывод данных для таблицы customer
--
INSERT INTO customer VALUES
(1, 1, 0, 'Vitaliy', 'Badion', 'badion@yahoo.com', 'badion', '60-12517-9616755-57-48-116-90122374573-67', '380636228927', 1),
(4, 1, 0, 'Vitaliy', 'Badion', 'aaa@aa.aa', 'badion1', '12611998-96-1717-4071-1485246-16-55-116-122', '312312321', 0),
(5, 1, 0, 'Vitaliy', 'Badion', 'badionv@yahoo.com', 'oki123', '-64-42-52-2530-451259765-101-309863113-520', '0636228927', 1),
(6, 1, 0, 'Ololo', 'ldasdas', 'badion@bigmir.net', 'qwerty', '11711094-37-1216-10-95154120-7895-16-8396', '43243124132', 1),
(7, 1, 0, 'авыафвы', 'авфыафвы', 'aaa@aaa.aa', 'fdasfads', '-90326633957434114-761-129921119-736', '3123213', 1);

-- 
-- Вывод данных для таблицы product
--
INSERT INTO product VALUES
(1, 'HP-Envy-17', 1407.49, 'Screen 17.3" (1920x1080) Full HD LED / Intel Core i7. 4702MQ(2.2Ghz) / RAM 16 Gb / HDD 2 Tb', 1, 0),
(2, 'Acer-Aspire', 361.00, 'Screen 15,6" (1366x768) HD LED / Intel Celeron (1.86 Ghz) / RAM 2 Gb / HDD 500 Gb / Intel HD Graphics', 1, 154),
(3, 'Iphone-5c', 530.00, 'Screen Retina 4" (1136x640), Apple A6(1,3Ghz) / RAM 1 Gb / Camera 8mpx, front 1.2mpx, Memory 32 Gb', 2, 29),
(4, 'Ipad-mini', 350.00, 'Screen 7.9" (1024x768), Apple A6(1,3Ghz) / RAM 1 Gb / Camera 5mpx, front 1.2mpx, Memory 16 Gb', 3, 49),
(5, 'Nook-Simple-Touch', 61.92, 'Screen 6" Type - E-ink Pearl / MemoryCard - Yes / CPU - 700Mhz / OS - Google Android 2.1 / Formats - Epub, fb2, pdf, bmp, jpg, gif /  WiFi - Yes', 4, 0),
(6, 'Iphone-5s', 1000.00, 'Screen Retina 4" (1136x640), Apple A7(1,3Ghz) / RAM 1 Gb / Camera 8mpx, front 1.2mpx, Memory 32 Gb', 2, 11),
(11, 'Asus-x550cc', 532.50, 'Screen 15,6" (1366x768) HD LED / Intel Core i3-3217U (1.8Ghz) / RAM 4Gb / nVidia GeForce GT 720M, 2 Gb', 1, 25),
(12, 'Amazon-kindle-fire-hdx', 179.00, 'Screen 7" HDX display (1920x1200), high pixel density (323 PPI) / Ultra-fast 2.2GHz quad-core processor / 2GB of RAM and Adreno 330 GPU ', 3, 2);

-- 
-- Вывод данных для таблицы checkout
--
INSERT INTO checkout VALUES
(1, 'processed', 5, '2014-10-16 15:55:56', 1000.00),
(2, 'processed', 5, '2014-10-16 15:56:26', 893.50);

-- 
-- Вывод данных для таблицы checkout_products
--
INSERT INTO checkout_products VALUES
(1, 6, 1),
(2, 2, 2),
(3, 11, 2);

-- 
-- Вывод данных для таблицы purchased_products
--
INSERT INTO purchased_products VALUES
(1, 5, 'pickup', '', '', '', 1, '1000.0'),
(2, 5, 'courier', 'Ukraine', 'Lviv', 'Shevchenka 21/12', 2, '893.5');

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
