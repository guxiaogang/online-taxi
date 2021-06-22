CREATE DATABASE IF NOT EXISTS online-taxi;

ALTER DATABASE online-taxi
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON online-taxi.* TO 'online-taxi@%' IDENTIFIED BY 'online-taxi';
