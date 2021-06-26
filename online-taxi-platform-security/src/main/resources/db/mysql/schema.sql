DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details
(
  client_id               varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户端标识',
  resource_ids            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接入资源列表',
  client_secret           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端秘钥',
  scope                   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  authorized_grant_types  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  web_server_redirect_uri varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  authorities             varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  access_token_validity   int(11)      NULL DEFAULT NULL,
  refresh_token_validity  int(11)      NULL DEFAULT NULL,
  additional_information  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  create_time             timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  archived                tinyint(4) NULL DEFAULT NULL,
  trusted                 tinyint(4) NULL DEFAULT NULL,
  autoapprove             varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (client_id) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '接入客户端信息' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS oauth_code;
CREATE TABLE oauth_code
(
  create_time    timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  code           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  authentication blob         NULL,
  INDEX          code_index(code) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

DROP TABLE IF EXISTS role_table;
CREATE TABLE role_table
(
  id             INTEGER  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role_code      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role
(
  user_id             INTEGER  NOT NULL,
  role_id             INTEGER  NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

DROP TABLE IF EXISTS permission;
CREATE TABLE permission
(
  id             INTEGER  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  code           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  description    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  url            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

DROP TABLE IF EXISTS role_permission;
CREATE TABLE role_permission
(
  role_id             INTEGER  NOT NULL,
  permission_id       INTEGER  NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

DROP TABLE IF EXISTS account;

CREATE TABLE IF NOT EXISTS account
(
    id        INTEGER  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username  VARCHAR(50),
    password  VARCHAR(100),
    name      VARCHAR(50),
    avatar    VARCHAR(100),
    telephone VARCHAR(20),
    email     VARCHAR(100),
    location  VARCHAR(100),
    INDEX (username)
) engine = InnoDB;
