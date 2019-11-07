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
  publisher VARCHAR(100)
  );
  
--   add BLOB into book table
  ALTER TABLE BOOK ADD COLUMN picture blob;
  
  
-- INSERT example
  INSERT INTO book (title, description, ISBN, firstName, lastName, publisher)
VALUES ('Cardinal','description of book','S23K45AO','Stavanger','Smith','theMcdonald');

select * from book;
