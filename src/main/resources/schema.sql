DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS comments;

CREATE TABLE posts (
      id INT NOT NULL AUTO_INCREMENT
     , title VARCHAR(100) NOT NULL
     , version INT NOT NULL DEFAULT 0
     , UNIQUE UQ_POST_1 (title)
     , PRIMARY KEY (id)
);

CREATE TABLE comments (
      id INT NOT NULL AUTO_INCREMENT
     , post_id INT NOT NULL
     , text VARCHAR(250) NOT NULL
     , version INT NOT NULL DEFAULT 0
     , UNIQUE UQ_COMMNENT_1 (text)
     , PRIMARY KEY (id)
);
