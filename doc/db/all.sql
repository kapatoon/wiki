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

# 电子书表
drop table if exists `ebook`;
create table `ebook` (
                         `id` bigint not null comment 'id',
                         `name` varchar(50) comment '名称',
                         `category1_id` bigint comment '分类1',
                         `category2_id` bigint comment '分类2',
                         `description` varchar(200) comment '描述',
                         `cover` varchar(200) comment '封面',
                         `doc_count` int not null default 0 comment '文档数',
                         `view_count` int not null default 0 comment '阅读数',
                         `vote_count` int not null default 0 comment '点赞数',
                         primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='电子书';

insert into `ebook` (id, name, description) values (1, 'Spring Boot 入门教程', '零基础入门 Java 开发，企业级应用开发最佳首选框架');
insert into `ebook` (id, name, description) values (2, 'Vue 入门教程', '零基础入门 Vue 开发，企业级应用开发最佳首选框架');
insert into `ebook` (id, name, description) values (3, 'Python 入门教程', '零基础入门 Python 开发，企业级应用开发最佳首选框架');
insert into `ebook` (id, name, description) values (4, 'Mysql 入门教程', '零基础入门 Mysql 开发，企业级应用开发最佳首选框架');
insert into `ebook` (id, name, description) values (5, 'Oracle 入门教程', '零基础入门 Oracle 开发，企业级应用开发最佳首选框架');

# 文档表
drop table if exists `doc`;
create table `doc` (
                         `id` bigint not null comment 'id',
                         ebook_id bigint not null default 0 comment '电子书id',
                         `parent` bigint not null default 0 comment '父id',
                         `name` varchar(50) not null comment '名称',
                         `sort` int comment '顺序',
                         `view_count` int default 0 comment '阅读数',
                         `vote_count` int default 0 comment '点赞数',
                         primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='文档';

insert into `doc` (id, ebook_id, parent, name, sort, view_count, vote_count) values (1, 1, 0, '文档1', 1, 0, 0);
insert into `doc` (id, ebook_id, parent, name, sort, view_count, vote_count) values (2, 1, 1, '文档1.1', 1, 0, 0);
insert into `doc` (id, ebook_id, parent, name, sort, view_count, vote_count) values (3, 1, 0, '文档2', 2, 0, 0);
insert into `doc` (id, ebook_id, parent, name, sort, view_count, vote_count) values (4, 1, 3, '文档2.1', 1, 0, 0);
insert into `doc` (id, ebook_id, parent, name, sort, view_count, vote_count) values (5, 1, 3, '文档2.2', 2, 0, 0);
insert into `doc` (id, ebook_id, parent, name, sort, view_count, vote_count) values (6, 1, 5, '文档2.2.1', 1, 0, 0);

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content`  (
                            `id` bigint(20) NOT NULL COMMENT '文档id',
                            `content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文档内容' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES (1, '<p>1111</p>');
INSERT INTO `content` VALUES (15003445139611904, '<p>1</p>');
INSERT INTO `content` VALUES (15799464349671680, '<p>32112</p>');

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo`  (
                         `id` bigint(20) NOT NULL COMMENT 'id',
                         `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '测试' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES (1, '测试');

-- ----------------------------
-- Table structure for doc
-- ----------------------------
DROP TABLE IF EXISTS `doc`;
CREATE TABLE `doc`  (
                        `id` bigint(20) NOT NULL COMMENT 'id',
                        `ebook_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '电子书id',
                        `parent` bigint(20) NOT NULL DEFAULT 0 COMMENT '父id',
                        `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
                        `sort` int(11) NULL DEFAULT NULL COMMENT '顺序',
                        `view_count` int(11) NULL DEFAULT 0 COMMENT '阅读数',
                        `vote_count` int(11) NULL DEFAULT 0 COMMENT '点赞数',
                        `collection_count` int(11) NULL DEFAULT 0 COMMENT '收藏数',
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文档' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doc
-- ----------------------------
INSERT INTO `doc` VALUES (1, 1, 0, '文档1', 1, 12, 0, 0);
INSERT INTO `doc` VALUES (2, 1, 1, '文档1.1', 1, 7, 1, 0);
INSERT INTO `doc` VALUES (3, 1, 0, '文档2', 2, 3, 0, 0);
INSERT INTO `doc` VALUES (4, 1, 3, '文档2.1', 1, 7, 1, 0);
INSERT INTO `doc` VALUES (5, 1, 3, '文档2.2', 2, 4, 0, 0);
INSERT INTO `doc` VALUES (6, 1, 5, '文档2.2.1', 1, 4, 1, 0);
INSERT INTO `doc` VALUES (15799464349671680, 2, 0, '11', 213, 7, 1, 0);

-- ----------------------------
-- Table structure for ebook
-- ----------------------------
DROP TABLE IF EXISTS `ebook`;
CREATE TABLE `ebook`  (
                          `id` bigint(20) NOT NULL COMMENT 'id',
                          `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
                          `category1_id` bigint(20) NULL DEFAULT NULL COMMENT '分类1',
                          `category2_id` bigint(20) NULL DEFAULT NULL COMMENT '分类2',
                          `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
                          `cover` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '封面',
                          `doc_count` int(11) NOT NULL DEFAULT 0 COMMENT '文档数',
                          `view_count` int(11) NOT NULL DEFAULT 0 COMMENT '阅读数',
                          `vote_count` int(11) NOT NULL DEFAULT 0 COMMENT '点赞数',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '电子书' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ebook
-- ----------------------------
INSERT INTO `ebook` VALUES (1, 'Spring Boot 入门教程', 200, 202, '零基础入门 Java 开发，企业级应用开发最佳首选框架', '/image/cover1.png', 6, 37, 3);
INSERT INTO `ebook` VALUES (2, 'Vue 入门教程', 100, 101, '零基础入门 Vue 开发，企业级应用开发最佳首选框架', '/image/cover2.png', 1, 7, 1);
INSERT INTO `ebook` VALUES (3, 'Python 入门教程', 300, 301, '零基础入门 Python 开发，企业级应用开发最佳首选框架', NULL, 0, 0, 0);
INSERT INTO `ebook` VALUES (4, 'Mysql 入门教程', 400, 401, '零基础入门 Mysql 开发，企业级应用开发最佳首选框架', NULL, 0, 0, 0);
INSERT INTO `ebook` VALUES (5, 'Oracle 入门教程', 400, 14995122544189696, '零基础入门 Oracle 开发，企业级应用开发最佳首选框架', NULL, 0, 0, 0);

-- ----------------------------
-- Table structure for ebook_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `ebook_snapshot`;
CREATE TABLE `ebook_snapshot`  (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
                                   `ebook_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '电子书id',
                                   `date` date NOT NULL COMMENT '快照日期',
                                   `view_count` int(11) NOT NULL DEFAULT 0 COMMENT '阅读数',
                                   `vote_count` int(11) NOT NULL DEFAULT 0 COMMENT '点赞数',
                                   `view_increase` int(11) NOT NULL DEFAULT 0 COMMENT '阅读增长',
                                   `vote_increase` int(11) NOT NULL DEFAULT 0 COMMENT '点赞增长',
                                   PRIMARY KEY (`id`) USING BTREE,
                                   UNIQUE INDEX `ebook_id_date_unique`(`ebook_id`, `date`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '电子书快照表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ebook_snapshot
-- ----------------------------
INSERT INTO `ebook_snapshot` VALUES (1, 1, '2022-12-09', 5, 0, 5, 0);
INSERT INTO `ebook_snapshot` VALUES (2, 2, '2022-12-09', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (3, 3, '2022-12-09', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (4, 4, '2022-12-09', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (5, 5, '2022-12-09', 10, 0, 5, 0);
INSERT INTO `ebook_snapshot` VALUES (6, 1, '2022-12-10', 6, 0, 6, 0);
INSERT INTO `ebook_snapshot` VALUES (7, 2, '2022-12-10', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (8, 3, '2022-12-10', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (9, 4, '2022-12-10', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (10, 5, '2022-12-10', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (13, 1, '2022-12-11', 29, 3, 29, 3);
INSERT INTO `ebook_snapshot` VALUES (14, 2, '2022-12-11', 5, 1, 5, 1);
INSERT INTO `ebook_snapshot` VALUES (15, 3, '2022-12-11', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (16, 4, '2022-12-11', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (17, 5, '2022-12-11', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (20, 1, '2022-12-12', 37, 3, 8, 0);
INSERT INTO `ebook_snapshot` VALUES (21, 2, '2022-12-12', 7, 1, 2, 0);
INSERT INTO `ebook_snapshot` VALUES (22, 3, '2022-12-12', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (23, 4, '2022-12-12', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (24, 5, '2022-12-12', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (27, 1, '2022-12-13', 37, 3, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (28, 2, '2022-12-13', 7, 1, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (29, 3, '2022-12-13', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (30, 4, '2022-12-13', 0, 0, 0, 0);
INSERT INTO `ebook_snapshot` VALUES (31, 5, '2022-12-13', 0, 0, 0, 0);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
                         `id` int(11) NOT NULL,
                         `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `id` bigint(20) NOT NULL COMMENT 'ID',
                         `login_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登陆名',
                         `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
                         `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
                         PRIMARY KEY (`id`) USING BTREE,
                         UNIQUE INDEX `login_name_unique`(`login_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'fb09b64e309e1c33e7cf8cfe99b07bd5');
INSERT INTO `user` VALUES (15029467965563136, 'tets11', 'test112', 'fb09b64e309e1c33e7cf8cfe99b07bd5');
INSERT INTO `user` VALUES (15029966096572672, 'test', 'test', 'fb09b64e309e1c33e7cf8cfe99b07bd5');

SET FOREIGN_KEY_CHECKS = 1;
