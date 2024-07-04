-- ENTITIES --
CREATE TABLE IF NOT EXISTS customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    last_name VARCHAR(50),
    age INT(2),
    delivery_address VARCHAR(255),
    phone_number VARCHAR(16),
    email VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS restaurant (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    phone_number VARCHAR(16)
);

CREATE TABLE IF NOT EXISTS menu (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    category VARCHAR(255),
    restaurant_id BIGINT,
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(id)
);

CREATE TABLE IF NOT EXISTS meal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price DECIMAL(10, 2),
    category VARCHAR(255),
    ingredients VARCHAR(255),
    image VARCHAR(255),
    menu_id BIGINT,
    FOREIGN KEY (menu_id) REFERENCES menu(id)
);

CREATE TABLE IF NOT EXISTS role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO role (name) VALUES ('USER');

-- RELATIONS --
CREATE TABLE IF NOT EXISTS customer_roles (
    customer_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (customer_id, role_id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (role_id) REFERENCES role(id)
);

