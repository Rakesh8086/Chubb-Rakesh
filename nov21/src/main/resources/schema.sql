CREATE TABLE IF NOT EXISTS "flight" (
    id INT NOT NULL AUTO_INCREMENT,
    airline_name VARCHAR(255),
    from_place VARCHAR(255),
    to_place VARCHAR(255),
    schedule_date DATE,
    departure_time TIME,
    arrival_time TIME,
    price DOUBLE,
    total_seats INT,
    available_seats INT,
    PRIMARY KEY (id)
);
