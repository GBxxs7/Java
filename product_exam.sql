--
-- ER/Studio 8.0 SQL Code Generation
-- Company :      Microsoft
-- Project :      Shopping.DM1
-- Author :       Microsoft
--
-- Date Created : Thursday, December 07, 2017 19:31:49
-- Target DBMS : MySQL 5.x
--

DROP DATABASE IF EXISTS product_exam ;
CREATE DATABASE product_exam DEFAULT CHARSET=utf8 ;
USE product_exam ;

-- 
-- TABLE: t_user 
--

CREATE TABLE t_user(
    user_id       INT            AUTO_INCREMENT,
    name          CHAR(20)       NOT NULL UNIQUE,
    password      CHAR(100)      NOT NULL,
    PRIMARY KEY (user_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8
;

-- 
-- TABLE: t_product 
--

CREATE TABLE t_product(
    product_id      INT               AUTO_INCREMENT,
    name            VARCHAR(30)       UNIQUE NOT NULL,
    price           DOUBLE    	      NOT NULL,
    quantity        INT               NOT NULL,
    descriptions    VARCHAR(300)      NOT NULL,
    status          BIT(1)            DEFAULT 1 NOT NULL,
    PRIMARY KEY (product_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 
;

-- 密码000000， 加密方式：000000 + 'xmcu' ，md5摘要一次计算生成"ec5701635819ead9a95ffb9bc8bb43b0"
insert into t_user(name,password) values("wang","ec5701635819ead9a95ffb9bc8bb43b0");

insert into t_product(name, price,quantity,descriptions) values("精选山东沾化冬枣",28,100,"脆甜 国家地理标志产品");
insert into t_product(name, price,quantity,descriptions) values("云南蒙自石榴",36.9,100,"6粒装 单果约重230-280g");
insert into t_product(name, price,quantity,descriptions) values("越南进口红心火龙果",39.9,100,"3个装中 单果约300~350g");
insert into t_product(name, price,quantity,descriptions) values("云南新平哀牢山冰糖橙",39.9,100,"新鲜橙 甜橙子2.5kg装");
insert into t_product(name, price,quantity,descriptions) values("进口牛油果",29.9,100,"6个装 单果重约130-180g  适合女人和宝宝的健康");
insert into t_product(name, price,quantity,descriptions) values("苹果",29.9,100,"烟台红富士 12个 约80mm 总重约2.6kg");


