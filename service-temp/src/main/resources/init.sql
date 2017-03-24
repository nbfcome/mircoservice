
create table `user`(
`userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键：用户id',
`icon` varchar(100) NOT NULL COMMENT '头像图片',
`nickName` varchar(32) NOT NULL COMMENT '',
`gender` char(1) NOT NULL COMMENT '',
`birthDay` varchar(8) NOT NULL COMMENT '',
`password` char(1) NOT NULL COMMENT '',
`mobile` varchar(11) NOT NULL  COMMENT '',
`city` varchar(10) NOT NULL  COMMENT '',
`province` varchar(10) NOT NULL  COMMENT '',
`status` char(1) NOT NULL DEFAULT '1' COMMENT '',
`createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON INSERT CURRENT_TIMESTAMP,
PRIMARY KEY (`userId`),
key `idx_nickName` (`nickName`)
) ENGINE=MyISAM AUTO_INCREMENT=1005550000 DEFAULT CHARSET=utf8;


create table `fans`(
`userId` int(11)  NOT NULL COMMENT '主键：用户id',
`fansId`  int(11)  NOT NULL,
`status` char(1) NOT NULL DEFAULT '1' COMMENT '',
`createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON INSERT CURRENT_TIMESTAMP,
PRIMARY KEY (`userId`, `fansId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

create table `focus`(
`userId` int(11)  NOT NULL COMMENT '主键：用户id',
`focusId`  int(11)  NOT NULL,
`status` char(1) NOT NULL DEFAULT '1' COMMENT '',
`createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON INSERT CURRENT_TIMESTAMP,
PRIMARY KEY (`userId`, `focusId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


create table `content`(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键：id',
`userId` int(11) NOT NULL COMMENT '',
`userIcon` varchar(100) NOT NULL DEFAULT '' COMMENT '',
`nickName` varchar(32) NOT NULL DEFAULT '' COMMENT '',
`praiseCount` int(11) unsign NOT NULL DEFAULT 0 COMMENT '',
`commentCount` int(11) unsign NOT NULL DEFAULT 0 COMMENT '',
`shareCount` int(11) unsign NOT NULL DEFAULT 0 COMMENT '',
`collectionCount` int(11) unsign NOT NULL DEFAULT 0 COMMENT '',
`country` varchar(10) NOT NULL DEFAULT '' COMMENT '',
`province` varchar(10) NOT NULL DEFAULT '' COMMENT '',
`city` varchar(10) NOT NULL DEFAULT '' COMMENT '',
`content` varchar(150) NOT NULL DEFAULT '' COMMENT '',
`pics` varchar(300) NOT NULL DEFAULT '' COMMENT '',
`status` char(1) NOT NULL DEFAULT '1' COMMENT '',
`createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON INSERT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
key `idx_userId` (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=2305550000 DEFAULT CHARSET=utf8;

create table `comment`(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键：id',
`contentId` int(11) NOT NULL COMMENT '',
`userId` int(11) NOT NULL COMMENT '',
`commentedId` int(11) NOT NULL COMMENT '',
`comment` varchar(150) NOT NULL DEFAULT '' COMMENT '',
`pics` varchar(300) NOT NULL DEFAULT '' COMMENT '图片',
`userIcon` varchar(100) NOT NULL COMMENT '',
`nickName` varchar(32) NOT NULL COMMENT '',
`praiseCount` int(11) unsign NOT NULL DEFAULT 0 COMMENT '',
`status` char(1) NOT NULL DEFAULT '1' COMMENT '',
`createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON INSERT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
key `idx_contentId_userId` (`contentId`,`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=2305550000 DEFAULT CHARSET=utf8;


create table `commentPraise`(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键：id',
`contentId` int(11) NOT NULL COMMENT '',
`commentId` int(11) NOT NULL COMMENT '',
`userId` int(11) NOT NULL COMMENT '',
`userIcon` varchar(100) NOT NULL DEFAULT '' COMMENT '',
`nickName` varchar(32) NOT NULL DEFAULT '' COMMENT '',
`status` char(1) NOT NULL DEFAULT '1' COMMENT '',
`createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON INSERT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
key `idx_commentId` (`commentId`)
) ENGINE=MyISAM AUTO_INCREMENT=2305550000 DEFAULT CHARSET=utf8;

create table `contentShare`(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键：id',
`contentId` int(11) NOT NULL COMMENT '',
`userId` int(11) NOT NULL COMMENT '',
`userIcon` varchar(100) NOT NULL COMMENT '',
`nickName` varchar(32) NOT NULL DEFAULT '' COMMENT '',
`status` char(1) NOT NULL DEFAULT '1' COMMENT '',
`createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2305550000 DEFAULT CHARSET=utf8;

create table `contentCollection`(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键：id',
`contentId` int(11) NOT NULL COMMENT '',
`userId` int(11) NOT NULL COMMENT '',
`userIcon` varchar(100) NOT NULL DEFAULT '' COMMENT '',
`nickName` varchar(32) NOT NULL DEFAULT '' COMMENT '',
`status` char(1) NOT NULL DEFAULT '1' COMMENT '',
`createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON INSERT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2305550000 DEFAULT CHARSET=utf8;

create table `contentPraise`(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键：id'
`contentId` int(11) NOT NULL COMMENT '',
`userId` int(11) NOT NULL COMMENT '',
`userIcon` varchar(100) NOT NULL DEFAULT '' COMMENT '',
`nickName` varchar(32) NOT NULL DEFAULT '' COMMENT '',
`status` char(1) NOT NULL DEFAULT '1' COMMENT '',
`createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON INSERT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2305550000 DEFAULT CHARSET=utf8;

create table `score`(
`userId` int(11) NOT NULL COMMENT '主键：用户id',
`count` int(11) unsign NOT NULL DEFAULT 0 COMMENT '',
`createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON INSERT CURRENT_TIMESTAMP,
PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

create table scoreHistory(
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键：id',
`userId` int(11) NOT NULL COMMENT '',
`score` int(11) NOT NULL COMMENT '',
`type` char(2) NOT NULL COMMENT '',
`createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2305550000 DEFAULT CHARSET=utf8;


