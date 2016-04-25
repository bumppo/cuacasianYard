DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS money;
DROP TABLE IF EXISTS menu_meal;
DROP TABLE IF EXISTS menu;
DROP SEQUENCE IF EXISTS global_seq;
DROP SEQUENCE IF EXISTS menu_seq;

CREATE SEQUENCE global_seq START 100;
CREATE SEQUENCE menu_seq START 100;

CREATE TABLE users
(
  id    INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name  VARCHAR UNIQUE NOT NULL
);

CREATE TABLE meals
(
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  description    VARCHAR NOT NULL,
  cost           INTEGER NOT NULL,
  user_id        INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE money
(
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  payed_in_fact  INTEGER NOT NULL,
  lucky_hours    INTEGER NOT NULL
);

CREATE TABLE menu
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR NOT NULL
);

CREATE TABLE menu_meal
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  description VARCHAR NOT NULL,
  cost        INTEGER NOT NULL,
  menu_id     INTEGER NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menu (id) ON DELETE CASCADE
);
