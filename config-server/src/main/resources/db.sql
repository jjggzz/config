create database config;

use config;

create table t_config
(
    id           bigint primary key auto_increment comment '主键id',
    access_id    varchar(32)   not null unique comment '业务id',
    group_id     bigint        not null comment '组id',
    config_name  varchar(32)   not null comment '配置名',
    config_key   varchar(32)   not null unique comment '配置key',
    config_value varchar(1024) not null comment '配置值',
    remark       varchar(255) comment '备注'
);