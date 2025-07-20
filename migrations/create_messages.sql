CREATE TABLE IF NOT EXISTS config
(
    id SERIAL PRIMARY KEY,
    config_driver TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS sms-logs
(
    id SERIAL PRIMARY KEY,
    from_address VARCHAR(255) NOT NULL,
    to_address VARCHAR(255) NOT NULL,
    Driver VARCHAR(255) not null,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    retry int default 0,
    driver_response Text
);