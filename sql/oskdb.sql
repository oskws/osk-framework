CREATE TABLE `system_user`
(
    `id`            bigint unsigned NOT NULL AUTO_INCREMENT,
    `login_name`    varchar(50) DEFAULT NULL COMMENT '登录账号',
    `nickname`      varchar(50) DEFAULT NULL COMMENT '昵称',
    `password_slat` varchar(50) DEFAULT NULL COMMENT '盐',
    `user_password` varchar(50) DEFAULT NULL COMMENT '用户密码',
    `created_time`  timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    `updated_time`  timestamp NULL DEFAULT NULL COMMENT '修改时间',
    `details`       varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户账号信息表';