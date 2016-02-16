DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100;

INSERT INTO users (name) VALUES
  ('Виталик'),
  ('Алексей Аксенов'),
  ('Алексей Хныкин'),
  ('Диана'),
  ('Шамиль'),
  ('Макс');

INSERT INTO meals (description, cost, user_id) VALUES
  ('виски', 500, 100),
  ('пиво', 300, 101),
  ('ром', 500, 102),
  ('сок', 150, 103),
  ('сидр', 350, 104),
  ('водка', 200, 105);