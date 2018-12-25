CREATE TABLE `galaxy` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(64) DEFAULT '' comment 'uid',
  `name` varchar(64) DEFAULT '' comment '姓名',
  `age` int(11) DEFAULT '0' comment '年龄',
  `address` varchar(1024) DEFAULT '' comment '地址',
  `phone` varchar(64) DEFAULT '' comment '电话',
  `ext_info`varchar(1024) DEFAULT '' comment '扩展信息',
  `remark`varchar(1024) DEFAULT '' comment '扩展信息',
  `caller`varchar(64) DEFAULT '' comment '请求方',
  `invalid` int DEFAULT '0' comment '是否无效 0:否 1:是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;