DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100;

INSERT INTO users(name) VALUES
  ('Виталик'),
  ('Алексей Аксенов'),
  ('Алексей Хныкин'),
  ('Диана'),
  ('Шамиль'),
  ('Макс');

INSERT INTO meals(description, cost, user_id) VALUES
  ('виски', 500, 100),
  ('пиво', 300, 101),
  ('ром', 500, 102),
  ('сок', 150, 103),
  ('сидр', 350, 104),
  ('водка', 200, 105),
  ('сникерс', 35, 100),
  ('натс', 35, 101),
  ('баунти', 40, 102),
  ('твикс', 30, 103),
  ('марс', 35, 104),
  ('пикник', 30, 105);

INSERT INTO money(payed_in_fact, lucky_hours) VALUES
  (2200, -250);
