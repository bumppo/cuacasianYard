DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS meal;
DROP TABLE IF EXISTS common_meal CASCADE;
DROP TABLE IF EXISTS user_common_meal;
DROP TABLE IF EXISTS money;
DROP TABLE IF EXISTS menu CASCADE;
DROP TABLE IF EXISTS menu_meal;
DROP SEQUENCE IF EXISTS global_seq;
DROP SEQUENCE IF EXISTS menu_seq;

CREATE SEQUENCE global_seq START 100;
CREATE SEQUENCE menu_seq START 100;

CREATE TABLE users
(
  id    INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name  VARCHAR UNIQUE NOT NULL
);

CREATE TABLE meal
(
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  description    VARCHAR NOT NULL,
  cost           INTEGER NOT NULL,
  user_id        INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE common_meal
(
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  description    VARCHAR NOT NULL,
  cost           INTEGER NOT NULL
);

CREATE TABLE user_common_meal
(
  user_fk        INTEGER NOT NULL,
  common_meal_fk INTEGER NOT NULL,
  FOREIGN KEY (user_fk) REFERENCES users (id),
  FOREIGN KEY (common_meal_fk) REFERENCES common_meal (id)
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
