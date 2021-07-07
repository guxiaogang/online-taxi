CREATE TABLE IF NOT EXISTS tbl_wallet
(
  id              INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  passenger_id    INTEGER,
  capital         DECIMAL(10, 2),
  give_fee        DECIMAL(10, 2),
  freeze_capital  DECIMAL(10, 2),
  freeze_give_fee DECIMAL(10, 2),
  create_time     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_time     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  INDEX (passenger_id)
) engine = InnoDB;

CREATE TABLE IF NOT EXISTS tbl_wallet_record
(
  id                INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  passenger_id      INTEGER,
  pay_time          TIMESTAMP Default CURRENT_TIMESTAMP,
  pay_capital       DECIMAL(10, 2),
  pay_give_fee      DECIMAL(10, 2),
  refund_capital    DECIMAL(10, 2),
  refund_give_fee   DECIMAL(10, 2),
  recharge_discount DECIMAL(10, 2),
  pay_type          TINYINT,
  pay_status        TINYINT,
  trade_type        TINYINT,
  trade_reason      VARCHAR(200),
  description       VARCHAR(200),
  create_user       VARCHAR(50),
  order_id          INTEGER,
  create_time       TIMESTAMP Default CURRENT_TIMESTAMP,
  update_time       TIMESTAMP Default CURRENT_TIMESTAMP,
  INDEX (passenger_id)
) engine = InnoDB;
