
CREATE TABLE Users(username varchar(25) PRIMARY KEY, password VARCHAR(255), active boolean);

INSERT INTO users VALUES('admin', '1234', true);
INSERT INTO users VALUES('user3', '1234', true);
INSERT INTO users VALUES('user4', '1234', false);



CREATE TABLE roles(role varchar(25) PRIMARY KEY);

INSERT INTO roles VALUES('ADMIN');
INSERT INTO roles VALUES('USER');


CREATE TABLE users_roles(username varchar(25)  not null, role varchar(25) not null,
  constraint pkk PRIMARY KEY(username, role));



INSERT INTO users_roles VALUES('admin','ADMIN');
INSERT INTO users_roles VALUES('admin','USER');
INSERT INTO users_roles VALUES('user3','USER');
INSERT INTO users_roles VALUES('user4','USER');
