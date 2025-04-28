INSERT INTO station (id, name, latitude, longitude, startDate, endDate, elevation, created_at, updated_at)
VALUES
    ('b2cb5c8d-bdd2-4e72-9c72-e7f0725c9e12', 'Station A', 52.5200, 13.4050, '2020-01-01', '2025-01-01', 50, NOW(), NOW()),
    ('d1452e9e-8a64-4cdb-8b76-2fe06bb2e47a', 'Station B', 48.8566, 2.3522, '2019-06-01', '2024-06-01', 35, NOW(), NOW()),
    ('3a420b58-bd5b-44ae-b735-7ff9abda6f88', 'Station C', 34.0522, -118.2437, '2018-03-01', '2025-03-01', 305, NOW(), NOW()),
    ('b8ff5a72-7da2-4b71-b56b-226a2b8ec9d1', 'Station D', 40.7128, -74.0060, '2021-07-01', '2026-07-01', 10, NOW(), NOW());

INSERT INTO air_quality (station_id, timestamp, pm25, pm10, no2, so2, o3, co, aqi, quality_index)
VALUES
    ('b2cb5c8d-bdd2-4e72-9c72-e7f0725c9e12', '2025-04-28 12:00:00', 35.4, 52.3, 19.2, 4.5, 30.5, 0.5, 75, 'GOOD'),
    ('d1452e9e-8a64-4cdb-8b76-2fe06bb2e47a', '2025-04-28 13:00:00', 58.2, 63.1, 32.7, 7.9, 40.1, 0.7, 120, 'MODERATE'),
    ('3a420b58-bd5b-44ae-b735-7ff9abda6f88', '2025-04-28 14:00:00', 85.7, 92.4, 45.3, 9.2, 50.8, 1.0, 160, 'UNHEALTHY'),
    ('b8ff5a72-7da2-4b71-b56b-226a2b8ec9d1', '2025-04-28 15:00:00', 110.1, 102.5, 60.2, 12.4, 60.5, 1.2, 210, 'HAZARDOUS');

INSERT INTO noise_level (station_id, timestamp, decibel_level, classification)
VALUES
    ('b2cb5c8d-bdd2-4e72-9c72-e7f0725c9e12', '2025-04-28 12:00:00', 55.3, 'MODERATE'),
    ('d1452e9e-8a64-4cdb-8b76-2fe06bb2e47a', '2025-04-28 13:00:00', 72.8, 'HIGH'),
    ('3a420b58-bd5b-44ae-b735-7ff9abda6f88', '2025-04-28 14:00:00', 88.4, 'DANGEROUS'),
    ('b8ff5a72-7da2-4b71-b56b-226a2b8ec9d1', '2025-04-28 15:00:00', 45.1, 'LOW');

INSERT INTO weather (station_id, date, timestamp, temperature, humidity, wind_speed, wind_direction, precipitation, condition)
VALUES
    ('b2cb5c8d-bdd2-4e72-9c72-e7f0725c9e12', '2025-04-28', '2025-04-28 12:00:00', 21.5, 65.2, 15.0, 270, 0.0, 'Clear'),
    ('d1452e9e-8a64-4cdb-8b76-2fe06bb2e47a', '2025-04-28', '2025-04-28 13:00:00', 19.3, 72.4, 12.3, 180, 2.1, 'Partly Cloudy'),
    ('3a420b58-bd5b-44ae-b735-7ff9abda6f88', '2025-04-28', '2025-04-28 14:00:00', 25.7, 58.3, 18.2, 90, 0.5, 'Sunny'),
    ('b8ff5a72-7da2-4b71-b56b-226a2b8ec9d1', '2025-04-28', '2025-04-28 15:00:00', 17.2, 80.5, 10.0, 360, 1.2, 'Rain');
