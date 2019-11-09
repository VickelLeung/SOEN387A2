show databases;

use soen387a2;


Create Table Book(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(50),
  description VARCHAR(200),
  ISBN VARCHAR(20),
  UNIQUE KEY unique_isbn (ISBN),
  firstName VARCHAR(100),
  lastName VARCHAR(100),
  publisher_company VARCHAR(100),
  publisher_address VARCHAR(100)
  );
  
--   add BLOB into book table
  ALTER TABLE BOOK ADD COLUMN picture blob;
  
-- INSERT example
 INSERT INTO book (title, description, ISBN, firstName, lastName, picture, publisher_company, publisher_address) 
 VALUES ("The joker", "A scary book about clowns that will murder you.", "J4L 1M5", "Joaquin", "Phoenix", "", "TheGothan", "GothamCity");
 
--  Insert data dummy
 INSERT INTO book (title, description, ISBN, firstName, lastName, picture, publisher_company, publisher_address) 
 VALUES ("The dark knight", "A knight that will try to help you do your task such as cleaning.", "L6M 2S8", "Good", "Knight", "", "TheKnight", "Medieval");

 INSERT INTO book (title, description, ISBN, firstName, lastName, picture, publisher_company, publisher_address) 
 VALUES ("A funny book", "A book that will make you laught.", "H5K 2M1", "Will", "Smith", "", "BlackGuy", "HomieHood");

select * from book;
