DROP TABLE ym_system_user;/*SQL@Run*//*SkipError*/
CREATE TABLE ym_system_user(
    pk_id INT UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    uk_mac VARCHAR(32)    COMMENT '唯一标识' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_time TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_time TIMESTAMP    COMMENT '更新时间' ,
    full_name VARCHAR(64)    COMMENT '用户名' ,
    avator_img VARCHAR(128)    COMMENT '头像' ,
    intro_content VARCHAR(128)    COMMENT '简介' ,
    login_name VARCHAR(64)    COMMENT '登录名' ,
    user_password VARCHAR(32)    COMMENT '用户密码' ,
    user_salt VARCHAR(32)    COMMENT '盐值' ,
    mobile_no VARCHAR(11)    COMMENT '手机号' ,
    location VARCHAR(64)    COMMENT '定位' ,
    address VARCHAR(32)    COMMENT '住址' ,
    up_amount INT UNSIGNED    COMMENT '点赞量' ,
    following_amount INT UNSIGNED    COMMENT '关注量' ,
    follows_amount INT UNSIGNED    COMMENT '粉丝量' ,
    points_amount INT UNSIGNED    COMMENT '积分量' ,
    PRIMARY KEY (pk_id)
) COMMENT = '系统用户 系统用户';/*SQL@Run*/ALTER TABLE ym_system_user ADD UNIQUE uk(uk_mac);/*SQL@Run*/
DROP TABLE ym_information;/*SQL@Run*//*SkipError*/
CREATE TABLE ym_information(
    pk_id INT UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    uk_mac VARCHAR(32)    COMMENT '唯一标识' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_time TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_time TIMESTAMP    COMMENT '更新时间' ,
    info_title VARCHAR(128)    COMMENT '标题' ,
    info_content VARCHAR(1024)    COMMENT '内容' ,
    view_amount INT UNSIGNED    COMMENT '浏览量' ,
    comment_amount INT UNSIGNED    COMMENT '评论量' ,
    up_amount INT UNSIGNED    COMMENT '点赞量' ,
    down_amount INT UNSIGNED    COMMENT '踩量' ,
    PRIMARY KEY (pk_id)
) COMMENT = '信息表 ';/*SQL@Run*/ALTER TABLE ym_information ADD UNIQUE uk(uk_mac);/*SQL@Run*/
DROP TABLE ym_points_record;/*SQL@Run*//*SkipError*/
CREATE TABLE ym_points_record(
    pk_id INT UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    uk_mac VARCHAR(32)    COMMENT '唯一标识' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_time TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_time TIMESTAMP    COMMENT '更新时间' ,
    source_type INT UNSIGNED    COMMENT '积分获取类型 字典' ,
    points_amount INT UNSIGNED    COMMENT '数量' ,
    points_sign VARCHAR(1)    COMMENT '正负 0减,1加' ,
    user_mac VARCHAR(32)    COMMENT '用户外健MAC' ,
    PRIMARY KEY (pk_id)
) COMMENT = '积分记录表 ';/*SQL@Run*/
DROP TABLE ym_comment;/*SQL@Run*//*SkipError*/
CREATE TABLE ym_comment(
    pk_id INT UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    uk_mac VARCHAR(32)    COMMENT '唯一标识' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_time TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_time TIMESTAMP    COMMENT '更新时间' ,
    untitled VARCHAR(32)    COMMENT '评论者MAC' ,
    untitled1 VARCHAR(32)    COMMENT '评论信息MAC' ,
    PRIMARY KEY (pk_id)
) COMMENT = '用户评论 ';/*SQL@Run*/
DROP TABLE ym_collection;/*SQL@Run*//*SkipError*/
CREATE TABLE ym_collection(
    pk_id INT UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    uk_mac VARCHAR(32)    COMMENT '唯一标识' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_time TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (pk_id)
) COMMENT = '收藏记录表 ';/*SQL@Run*/
DROP TABLE ym_view_record;/*SQL@Run*//*SkipError*/
CREATE TABLE ym_view_record(
    pk_id INT UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    uk_mac VARCHAR(32)    COMMENT '唯一标识' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_time TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (pk_id)
) COMMENT = '浏览记录表 ';/*SQL@Run*/
DROP TABLE ym_feedback;/*SQL@Run*//*SkipError*/
CREATE TABLE ym_feedback(
    pk_id INT UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    uk_mac VARCHAR(32)    COMMENT '唯一标识' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_time TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (pk_id)
) COMMENT = '反馈记录表 ';/*SQL@Run*/
DROP TABLE ym_notification;/*SQL@Run*//*SkipError*/
CREATE TABLE ym_notification(
    pk_id INT UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    uk_mac VARCHAR(32)    COMMENT '唯一标识' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_time TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (pk_id)
) COMMENT = '通知记录表 ';/*SQL@Run*/
DROP TABLE ym_catelog;/*SQL@Run*//*SkipError*/
CREATE TABLE ym_catelog(
    pk_id INT UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    uk_mac VARCHAR(32)    COMMENT '唯一标识' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_time TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (pk_id)
) COMMENT = '类目表 ';/*SQL@Run*/
DROP TABLE ym_hot_tag;/*SQL@Run*//*SkipError*/
CREATE TABLE ym_hot_tag(
    pk_id INT UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    uk_mac VARCHAR(32)    COMMENT '唯一标识' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_time TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_time TIMESTAMP    COMMENT '更新时间' ,
    untitled VARCHAR(32)    COMMENT 'tag图片' ,
    PRIMARY KEY (pk_id)
) COMMENT = '热门标签 ';/*SQL@Run*/
DROP TABLE system_user;/*SQL@Run*//*SkipError*/
CREATE TABLE system_user(
    pk_id INT UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    uk_mac VARCHAR(32)    COMMENT '唯一标识' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_time TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_time TIMESTAMP    COMMENT '更新时间' ,
    full_name VARCHAR(64)    COMMENT '用户名' ,
    login_name VARCHAR(64)    COMMENT '登录账号' ,
    login_password VARCHAR(32)    COMMENT '登录密码' ,
    login_salt VARCHAR(32)    COMMENT '盐值' ,
    PRIMARY KEY (pk_id)
) COMMENT = '系统用户 ';/*SQL@Run*/ALTER TABLE system_user ADD UNIQUE uk(uk_mac);/*SQL@Run*/
ALTER TABLE system_user ADD UNIQUE uk_login_name(login_name);/*SQL@Run*/
DROP TABLE system_dict;/*SQL@Run*//*SkipError*/
CREATE TABLE system_dict(
    pk_id INT UNSIGNED NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    uk_mac VARCHAR(32)    COMMENT '唯一标识' ,
    created_by VARCHAR(64)    COMMENT '创建人' ,
    created_time TIMESTAMP    COMMENT '创建时间' ,
    updated_by VARCHAR(64)    COMMENT '更新人' ,
    updated_time TIMESTAMP    COMMENT '更新时间' ,
    table_field VARCHAR(64)    COMMENT '数据表名.字段名' ,
    code INT UNSIGNED    COMMENT '编号' ,
    name VARCHAR(64)    COMMENT '名称' ,
    remark VARCHAR(64)    COMMENT '备注' ,
    PRIMARY KEY (pk_id)
) COMMENT = '系统字典 ';/*SQL@Run*/