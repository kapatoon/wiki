DROP TABLE IF EXISTS `wiki`.`test`;
CREATE TABLE `wiki`.`test`(
    `id` BIGINT NOT NULL COMMENT 'id',
    `name` VARCHAR(50) COMMENT '名称',
    `password` VARCHAR(50) COMMENT '密码',
    PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8mb4 COMMENT='测试';

DROP TABLE IF EXISTS `wiki`.`demo`;
CREATE TABLE `wiki`.`demo`(
                              `id` BIGINT NOT NULL COMMENT 'id',
                              `name` VARCHAR(50) COMMENT '名称',
                              PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8mb4 COMMENT='演示';