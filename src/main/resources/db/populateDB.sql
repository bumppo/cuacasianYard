DELETE FROM users;
DELETE FROM meal;
DELETE FROM common_meal;
DELETE FROM user_common_meal;
DELETE FROM money;
DELETE FROM menu;
DELETE FROM menu_meal;
ALTER SEQUENCE global_seq RESTART WITH 100;
ALTER SEQUENCE menu_seq RESTART WITH 100;

INSERT INTO users(name) VALUES
  ('Виталик'),
  ('Алексей Аксенов'),
  ('Алексей Хныкин'),
  ('Диана'),
  ('Шамиль'),
  ('Макс');

INSERT INTO meal(description, cost, user_id) VALUES
  ('Долма с виноградными листьями', 350, 100),
--   ('Рис отварной', 70, 100),
  ('Рис отварной', 70, 102),
--   ('Сельдь под шубой', 250, 100),
  ('Суп Харчо', 180, 101),
--   ('Сациви из курицы', 240, 101),
--   ('Сок Свелл', 70, 101),
  ('Сок Свелл', 70, 104),
--   ('Шашлык из телятины', 420, 102),
--   ('Чикен блюз', 260, 103),
--   ('Цезарь', 380, 104),
--   ('Картофель жареный', 90, 104),
  ('Картофель жареный', 90, 103),
--   ('Борщ', 180, 105),
--   ('Компот', 60, 103),
  ('Жаркое Кав. Дворик', 360, 105);

INSERT INTO common_meal(id, description, cost) VALUES
  (200, 'Лепешка', 50),
  (210, 'Хлеб', 30);

INSERT INTO user_common_meal (user_fk, common_meal_fk) VALUES
  (100, 200),
  (100, 210),
  (101, 200),
  (102, 200),
  (103, 210);

INSERT INTO money(payed_in_fact, lucky_hours) VALUES
  (2500, -900);

INSERT INTO menu(name) VALUES
  ('Салаты'),
  ('Первые блюда'),
  ('Вторые блюда из мяса'),
  ('Вторые блюда из рыбы'),
  ('Вторые блюда из птицы'),
  ('Вторые блюда из овощей'),
  ('Шашлыки'),
  ('Гарниры'),
  ('Напитки'),
  ('Прочее');

INSERT INTO menu_meal(description, cost, menu_id) VALUES
  ('салат',100,113),
  ('первое',100,114),
  ('мясо',100,115),
  ('рыба',100,116),
  ('птица',100,117),
  ('овощи',100,118),
  ('шашлык',100,119),
  ('гарнир',100,120),
  ('напиток',100,121),
  ('прочее',100,122);