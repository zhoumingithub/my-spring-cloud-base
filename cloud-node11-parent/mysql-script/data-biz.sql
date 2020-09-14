CREATE TABLE `seata_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_money` bigint(20) DEFAULT '0' COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='账户表';

CREATE TABLE `seata_inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `inventory` int(11) DEFAULT '0' COMMENT '库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='库存表';

CREATE TABLE `seata_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(64) DEFAULT NULL COMMENT '订单流水号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='订单表';