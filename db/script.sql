CREATE TABLE planets (
    id SERIAL PRIMARY KEY,
    climate TEXT,
    diameter TEXT,
    gravity TEXT,
    name TEXT,
    population TEXT,
    residents TEXT,
    terrain TEXT,
    url TEXT
);

CREATE TABLE people (
    id SERIAL PRIMARY KEY,
    name TEXT,
    birthyear TEXT,
    eyecolor TEXT,
    gender TEXT,
    haircolor TEXT,
    height TEXT,
    homeworld TEXT,
    mass TEXT,
    skincolor TEXT,
    created TEXT,
    edited TEXT,
    url TEXT
);