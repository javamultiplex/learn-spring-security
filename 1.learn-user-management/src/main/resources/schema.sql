CREATE TABLE users
(   id INT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE authorities
(   id INT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users_authorities
(   user_id INT NOT NULL,
    authority_id INT NOT NULL
);