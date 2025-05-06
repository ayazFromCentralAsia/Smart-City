CREATE TABLE perimeter (
    id SERIAL PRIMARY KEY,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    radius INT NOT NULL,
    created_at TIMESTAMPTZ DEFAULT NOW()
);

CREATE TABLE incidents (
    id SERIAL PRIMARY KEY,
    type VARCHAR(100) NOT NULL,
    status VARCHAR(50) CHECK (status IN ('OPEN', 'IN_PROGRESS', 'RESOLVED')) NOT NULL,
    description TEXT,
    perimeter_id INT REFERENCES perimeter(id) ON DELETE SET NULL,
    created_at TIMESTAMPTZ DEFAULT NOW()
);

CREATE TABLE cameras (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    zone VARCHAR(100),
    status VARCHAR(50) CHECK (status IN ('ONLINE', 'OFFLINE', 'MAINTENANCE')) NOT NULL,
    stream_url TEXT NOT NULL,
    perimeter_id INT REFERENCES perimeter(id) ON DELETE SET NULL
);

CREATE TABLE hotspots (
    id SERIAL PRIMARY KEY,
    type VARCHAR(100) NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    intensity INT NOT NULL,
    recorded_at TIMESTAMPTZ DEFAULT NOW()
);
INSERT INTO perimeter (latitude, longitude, radius) VALUES
(40.7128, -74.0060, 500),
(34.0522, -118.2437, 300),
(51.5074, -0.1278, 400);

-- Инциденты
INSERT INTO incidents (type, status, description, perimeter_id) VALUES
('Fire', 'OPEN', 'Small fire reported near main gate.', 1),
('Intrusion', 'IN_PROGRESS', 'Unauthorized entry detected.', 2),
('Equipment Failure', 'RESOLVED', 'Camera malfunction resolved.', 3);

-- Камеры
INSERT INTO cameras (name, zone, status, stream_url, perimeter_id) VALUES
('Cam A1', 'North Zone', 'ONLINE', 'http://example.com/stream/a1', 1),
('Cam B1', 'East Zone', 'OFFLINE', 'http://example.com/stream/b1', 2),
('Cam C1', 'South Zone', 'MAINTENANCE', 'http://example.com/stream/c1', 3);

-- Горячие точки (hotspots)
INSERT INTO hotspots (type, latitude, longitude, intensity) VALUES
('Heat', 40.7130, -74.0070, 80),
('Motion', 34.0525, -118.2440, 60),
('Sound', 51.5076, -0.1280, 70);

INSERT INTO perimeter (latitude, longitude, radius) VALUES
(40.7128, -74.0060, 500),
(34.0522, -118.2437, 300),
(51.5074, -0.1278, 400),
(35.6895, 139.6917, 600),
(48.8566, 2.3522, 450),
(55.7558, 37.6173, 350);

INSERT INTO incidents (type, status, description, perimeter_id) VALUES
('Fire', 'OPEN', 'Small fire reported near main gate.', 1),
('Intrusion', 'IN_PROGRESS', 'Unauthorized entry detected by motion sensors.', 2),
('Equipment Failure', 'RESOLVED', 'Camera malfunction resolved by technician.', 3),
('Gas Leak', 'OPEN', 'High methane levels detected.', 4),
('Power Outage', 'IN_PROGRESS', 'Transformer failure in north zone.', 5),
('Vandalism', 'RESOLVED', 'Graffiti removed from wall near checkpoint.', 1);

INSERT INTO cameras (name, zone, status, stream_url, perimeter_id) VALUES
('Cam A1', 'North Zone', 'ONLINE', 'http://example.com/stream/a1', 1),
('Cam B2', 'East Entrance', 'OFFLINE', 'http://example.com/stream/b2', 2),
('Cam C3', 'South Exit', 'MAINTENANCE', 'http://example.com/stream/c3', 3),
('Cam D4', 'Warehouse', 'ONLINE', 'http://example.com/stream/d4', 4),
('Cam E5', 'Main Lobby', 'ONLINE', 'http://example.com/stream/e5', 5),
('Cam F6', 'Back Gate', 'OFFLINE', 'http://example.com/stream/f6', 1);

INSERT INTO hotspots (type, latitude, longitude, intensity) VALUES
('Heat', 40.7130, -74.0070, 80),
('Motion', 34.0525, -118.2440, 60),
('Sound', 51.5076, -0.1280, 70),
('Radiation', 35.6897, 139.6920, 95),
('Chemical', 48.8568, 2.3525, 85),
('Heat', 55.7559, 37.6175, 50);
