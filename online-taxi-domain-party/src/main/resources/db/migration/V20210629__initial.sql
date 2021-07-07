CREATE TABLE IF NOT EXISTS tbl_passenger
(
  id                       INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  phone                    VARCHAR(50),
  education                VARCHAR(50),
  birthday                 date,
  passenger_name           VARCHAR(100),
  register_time            TIMESTAMP,
  balance                  DECIMAL(10, 2),
  gender                   TINYINT,
  head_img                 VARCHAR(250),
  passenger_type           TINYINT,
  user_level               TINYINT,
  register_type            SMALLINT,
  last_login_time          TIMESTAMP Default CURRENT_TIMESTAMP,
  last_login_method        TINYINT,
  last_login_screen_time   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  last_login_screen_method CHAR(2),
  last_order_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  create_time              TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_time              TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_contact               TINYINT,
  is_share                 TINYINT,
  sharing_time             VARCHAR(50),
  INDEX (phone)
) engine = InnoDB;

CREATE TABLE IF NOT EXISTS tbl_passenger_register_source
(
  id              INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  passenger_id    INTEGER,
  register_source VARCHAR(100),
  market_channel  VARCHAR(50),
  create_time     TIMESTAMP Default CURRENT_TIMESTAMP,
  update_time     TIMESTAMP Default CURRENT_TIMESTAMP,
  INDEX (passenger_id)
) engine = InnoDB;
