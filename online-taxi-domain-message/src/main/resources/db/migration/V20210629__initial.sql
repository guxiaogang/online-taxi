CREATE TABLE IF NOT EXISTS tbl_sms
(
  id          INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  phone       VARCHAR(50),
  operator    VARCHAR(30),
  sms_content VARCHAR(300),
  send_flag   TINYINT,
  send_number TINYINT,
  send_time   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  INDEX (phone)
) engine = InnoDB;

CREATE TABLE IF NOT EXISTS tbl_sms_template
(
  id          INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  template_id VARCHAR(50),
  content     VARCHAR(300),
  create_time TIMESTAMP Default CURRENT_TIMESTAMP,
  update_time TIMESTAMP Default CURRENT_TIMESTAMP,
  INDEX (template_id)
) engine = InnoDB;
