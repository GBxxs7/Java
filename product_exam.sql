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

-- ����000000�� ���ܷ�ʽ��000000 + 'xmcu' ��md5ժҪһ�μ�������"ec5701635819ead9a95ffb9bc8bb43b0"
insert into t_user(name,password) values("wang","ec5701635819ead9a95ffb9bc8bb43b0");

insert into t_product(name, price,quantity,descriptions) values("��ѡɽ��մ������",28,100,"���� ���ҵ����־��Ʒ");
insert into t_product(name, price,quantity,descriptions) values("��������ʯ��",36.9,100,"6��װ ����Լ��230-280g");
insert into t_product(name, price,quantity,descriptions) values("Խ�Ͻ��ں��Ļ�����",39.9,100,"3��װ�� ����Լ300~350g");
insert into t_product(name, price,quantity,descriptions) values("������ƽ����ɽ���ǳ�",39.9,100,"���ʳ� �����2.5kgװ");
insert into t_product(name, price,quantity,descriptions) values("����ţ�͹�",29.9,100,"6��װ ������Լ130-180g  �ʺ�Ů�˺ͱ����Ľ���");
insert into t_product(name, price,quantity,descriptions) values("ƻ��",29.9,100,"��̨�츻ʿ 12�� Լ80mm ����Լ2.6kg");


