CREATE DATABASE Book

Create Table book(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(50),
  description VARCHAR(200),
  ISBN VARCHAR(20),
  UNIQUE KEY unique_isbn (ISBN),
  author VARCHAR(40),
  publisher VARCHAR(100)
  );
  
-- INSERT example
  INSERT INTO book (title, description, ISBN, author, publisher)
VALUES ('Cardinal','description of book','S23K45AO','Stavanger','theMcdonald');


