CREATE TABLE locations (
    id SERIAL PRIMARY KEY,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    timestamp TIMESTAMPTZ NOT NULL,
    speed DOUBLE PRECISION NOT NULL,
    direction DOUBLE PRECISION NOT NULL
);

CREATE TABLE stops (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location_id INT REFERENCES locations(id) ON DELETE CASCADE,
    facilities TEXT[] -- Массив строк для удобства хранения
);

CREATE TABLE routes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    start_point VARCHAR(255) NOT NULL,
    end_point VARCHAR(255) NOT NULL,
    distance DOUBLE PRECISION NOT NULL,
    average_time INT NOT NULL
);

CREATE TABLE route_stops (
    route_id INT REFERENCES routes(id) ON DELETE CASCADE,
    stop_id INT REFERENCES stops(id) ON DELETE CASCADE,
    PRIMARY KEY (route_id, stop_id)
);

CREATE TABLE vehicles (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50) CHECK (type IN ('BUS', 'TRAM', 'TROLLEY')) NOT NULL,
    registration_number VARCHAR(255) NOT NULL,
    capacity INT NOT NULL,
    status VARCHAR(50) CHECK (status IN ('ACTIVE', 'MAINTENANCE', 'OUT_OF_SERVICE')) NOT NULL,
    current_location_id INT REFERENCES locations(id) ON DELETE SET NULL,
    current_route_id INT REFERENCES routes(id) ON DELETE SET NULL
);