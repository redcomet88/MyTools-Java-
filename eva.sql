//清理评测账号

delete from  t_user where dah like 'PC%';
delete  from  t_user_role where dah like 'PC%';
delete  from  t_evaluate_record where dah like 'PC%';



//在jscx中新增统计用的表
CREATE TABLE
    t_evaluate_record_statistics
    (
        id INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
        eva_dah VARCHAR(50) COMMENT '被评测人工号',
        eva_zw VARCHAR(255) COMMENT '被评测人职务',
        zzsx1 INT(4) COMMENT '政治思想',
        zzsx2 INT(4) COMMENT '政治思想',
        zzsx3 INT(4) COMMENT '政治思想',
        zzsx4 INT(4) COMMENT '政治思想',
        ywzs1 INT(4) COMMENT '业务知识',
        ywzs2 INT(4) COMMENT '业务知识',
        ywzs3 INT(4) COMMENT '业务知识',
        ywzs4 INT(4) COMMENT '业务知识',
        gztd1 INT(4) COMMENT '工作态度',
        gztd2 INT(4) COMMENT '工作态度',
        gztd3 INT(4) COMMENT '工作态度',
        gztd4 INT(4) COMMENT '工作态度',
        wcgz1 INT(4) COMMENT '完成工作',
        wcgz2 INT(4) COMMENT '完成工作',
        wcgz3 INT(4) COMMENT '完成工作',
        wcgz4 INT(4) COMMENT '完成工作',
        zjsf1 INT(4) COMMENT '遵纪守法',
        zjsf2 INT(4) COMMENT '遵纪守法',
        zjsf3 INT(4) COMMENT '遵纪守法',
        zjsf4 INT(4) COMMENT '遵纪守法',
        zhpj1 INT(4) COMMENT '综合评价',
        zhpj2 INT(4) COMMENT '综合评价',
        zhpj3 INT(4) COMMENT '综合评价',
        zhpj4 INT(4) COMMENT '综合评价',
        rzjy1 INT(4) COMMENT '任职建议',
        rzjy2 INT(4) COMMENT '任职建议',
        rzjy3 INT(4) COMMENT '任职建议',
        rzjy4 INT(4) COMMENT '任职建议',
        zongji int(5) COMMENT '总计',
        eva_year VARCHAR(8) COMMENT '评价年',
        flag1 VARCHAR(10) COMMENT 'flag1',
        flag2 INT(10) COMMENT 'flag2',
        flag3 DOUBLE COMMENT 'flag3',
        column1 VARCHAR(255) COMMENT '备用1',
        column2 INT(10)  COMMENT '备用2',
        column3 DOUBLE COMMENT '备用3',
        PRIMARY KEY (id),
        CONSTRAINT code UNIQUE (dah, eva_dah, eva_year, finished)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中层干部民主评测汇总';