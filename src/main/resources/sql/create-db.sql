CREATE TABLE  price (
                      price_id INT PRIMARY KEY,
                      amount DOUBLE
);
CREATE TABLE address (
                       address_id INT PRIMARY KEY,
                       address VARCHAR(100)
);
CREATE TABLE payment (
                       payment_id INT PRIMARY KEY,
                       payment_status VARCHAR(100)
);
CREATE TABLE landlord (
                       landlord_id INT PRIMARY KEY,
                       address_id INT,
                       payment_id INT,
                       FOREIGN KEY (address_id) REFERENCES address(address_id),
                       FOREIGN KEY (payment_id) REFERENCES payment(payment_id)
);
CREATE TABLE tenant (
                       tenant_id INT PRIMARY KEY,
                       address_id INT,
                       payment_id INT,
                       FOREIGN KEY (address_id) REFERENCES address(address_id),
                       FOREIGN KEY (payment_id) REFERENCES payment(payment_id)
);
CREATE TABLE deposit (
                       deposit_id INT PRIMARY KEY,
                       landlord_id INT,
                       tenant_id INT,
                       FOREIGN KEY (landlord_id) REFERENCES landlord(landlord_id),
                       FOREIGN KEY (tenant_id) REFERENCES tenant(tenant_id)
);
CREATE TABLE orders (
                      order_id INT ,
                      order_name VARCHAR(100),
                      price_id INT,
                      deposit_id INT,
                      payment_id INT,
                      FOREIGN KEY (price_id) REFERENCES price(price_id),
                      FOREIGN KEY (deposit_id) REFERENCES deposit(deposit_id),
                      FOREIGN KEY (payment_id) REFERENCES payment(payment_id)
);


