CREATE TABLE todo (
   id INT IDENTITY (1, 1) PRIMARY KEY,
   title VARCHAR (60) NOT NULL,
   description VARCHAR (255) NOT NULL,
   status VARCHAR (20) NOT NULL,
   atCreated TIMESTAMP
);