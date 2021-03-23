-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: forum
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL,
  `summary` varchar(255) NOT NULL,
  `content` longtext NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `user_id` int NOT NULL,
  `plate_id` int DEFAULT NULL,
  `created` datetime NOT NULL,
  `last_update` datetime DEFAULT NULL,
  `now_view` int DEFAULT '0',
  `yes_view` int DEFAULT '0',
  `likes` int DEFAULT '0',
  `collect` int DEFAULT '0',
  `deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_article_1_idx` (`plate_id`),
  CONSTRAINT `fk_article_plate` FOREIGN KEY (`plate_id`) REFERENCES `plate` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'Typora一款神奇的编辑软件！','Typora编辑器的使用小技巧，帮助你更加高效地办公学习。',' \n\n## 一：菜单栏\n\n- 文件：alt+F\n- 编辑：alt+E\n- 段落：alt+P\n- 格式：alt+O\n- 视图：alt+V\n- 主题：alt+T\n- 帮助：alt+H\n\n## 二：文件\n\n- 新建：Ctrl+N\n- 新建窗口：Ctrl+Shift+N\n- 打开：Ctrl+O\n- 快速打开：Ctrl+P\n- 保存：Ctrl+S\n- 另存为：Ctrl+Shift+S\n- 偏好：Ctrl+,\n- 关闭：Ctrl+W\n\n## 三：编辑\n\n- 撤销：Ctrl+Z\n- 重做：Ctrl+Y\n- 剪切：Ctrl+X\n- 复制：Ctrl+C\n- 粘贴：Ctrl+V\n- 复制为MarkDown：Ctrl+Shift+C\n- 粘贴为纯文本：Ctrl+Shift+V\n- 全选：Ctrl+A\n- 选中当前行/句：Ctrl+L\n- 选中当前格式文本：Ctrl+E\n- 选中当前词：Ctrl+D\n- 跳转到文首：Ctrl+Home\n- 跳转到所选内容：Ctrl+J\n- 跳转到文末：Ctrl+End\n- 查找：Ctrl+F\n- 查找下一个：F3\n- 查找上一个：Shift+F3\n- 替换：Ctrl+H\n\n## 四：段落\n\n- 标题：Ctrl+1/2/3/4/5\n- 段落：Ctrl+0\n- 增大标题级别：Ctrl+=\n- 减少标题级别：Ctrl+-\n- 表格：Ctrl+T\n- 代码块：Ctrl+Shift+K\n- 公式块：Ctrl+Shift+M\n- 引用：Ctrl+Shift+Q\n- 有序列表：Ctrl+Shift+[\n- 无序列表：Ctrl+Shift+]\n- 增加缩进：Ctrl+]\n- 减少缩进：Ctrl+[\n\n## 五：格式\n\n- 加粗：Ctrl+B\n- 斜体：Ctrl+I\n- 下划线：Ctrl+U\n- 代码：Ctrl+Shift+`\n- 删除线：Alt+Shift+5\n- 超链接：Ctrl+K\n- 图像：Ctrl+Shift+I\n- 清除样式：Ctrl+\n\n## 六：视图\n\n- 显示隐藏侧边栏：Ctrl+Shift+L\n- 大纲视图：Ctrl+Shift+1\n- 文档列表视图：Ctrl+Shift+2\n- 文件树视图：Ctrl+Shift+3\n- 源代码模式：Ctrl+/\n- 专注模式：F8\n- 打字机模式：F9\n- 切换全屏：F11\n- 实际大小：Ctrl+Shift+0\n- 放大：Ctrl+Shift+=\n- 缩小：Ctrl+Shift+-\n- 应用内窗口切换：Ctrl+Tab\n- 打开DevTools：Shift+F12','',1,1,'2021-01-19 10:27:47','2021-03-20 09:22:35',22,5,0,0,0),(2,'manjaro安装并使用docker','manjaro安装docker，配置镜像拉取加速器','1、安装docker：\nsudo pacman -S docker\n\n2、启动docker服务：\nsudo systemctl start docker \n3、设置docker开机启动服务：\nsudo systemctl enable docker\n4、查看docker服务的状态\nsudo systemctl status docker\n\n4、用daocloud的镜像加速服务配置加速器：\n修改配置文件 sudo vim /etc/docker/daemon.json\n加入{\"registry-mirrors\":[\"http://f136db2.daocloud.io\"]}\n\n5、干掉讨厌的 sudo\n# 如果还没有 docker group 就添加一个\nsudo groupadd docker\n\n# 将自己的登录名(${USER} )加入该 group 内。然后退出并重新登录就生效啦\nsudo gpasswd -a ${USER} docker\n\n# 重启 docker 服务\nsudo systemctl restart docker\n\n# 切换当前会话到新 group 或者重启 X 会话\n# 注意，这一步是必须的，否则因为 groups 命令获取到的是缓存的组信息，刚添加的组信息未能生效，所以 docker images 执行时同样有错。\nnewgrp - docker\nOR\npkill X\n\n','',1,2,'2021-01-19 10:27:47',NULL,22,2,0,0,0),(3,'Vue项目文件命名','不管是开发什么项目，开发人员总是会对文件分们别类的存放，一方便方便程序员开发，另一方便也有利于后期的代码维护。',' \n\n## [Vue项目中的文件/文件夹命名规范](https://www.cnblogs.com/mouseleo/p/11484550.html)\n\n# Vue项目中的文件/文件夹命名规范\n\n0.2262018.09.21 16:01:09字数 820阅读 6979\n\n> 文件或文件夹的命名遵循以下原则：\n>\n> - `index.js` 或者 `index.vue`，统一使用小写字母开头的(`kebab-case`)命名规范\n> - 属于`组件`或`类`的，统一使用大写字母开头的(`PascalCase`)命名规范\n> - 其他非`组件`或`类`的，统一使用小写字母开头的(`kebab-case`)命名规范\n\n## 1. Why？\n\n### 文件夹命名： `camelCase` VS `kebab-case`\n\n展开node_modules中的项目依赖，会发现，几乎所有的项目文件夹命名都是 `kebab-case`命名的，使用`kebab-case`命名的文件夹比`camelCase`命名的文件夹看起来更清晰\n\n### 组件命名：`kebab-case` VS `PascalCase`\n\n[vue的官方的风格指南](https://cn.vuejs.org/v2/style-guide/#单文件组件文件的大小写-强烈推荐)中关于组件文件名的推荐：\n\n> ### [单文件组件文件的大小写强烈推荐](https://cn.vuejs.org/v2/style-guide/#单文件组件文件的大小写-强烈推荐)\n>\n> [单文件组件](https://cn.vuejs.org/v2/guide/single-file-components.html)的文件名应该要么始终是单词大写开头 (PascalCase)，要么始终是横线连接 (kebab-case)。\n> 单词大写开头对于代码编辑器的自动补全最为友好，因为这使得我们在 JS(X) 和模板中引用组件的方式尽可能的一致。然而，混用文件命名方式有的时候会导致大小写不敏感的文件系统的问题，这也是横线连接命名同样完全可取的原因。\n\n## 2. 文件夹命名规范\n\n> #### 属于`components`文件夹下的子文件夹，使用大写字母开头的`PascalBase`风格\n>\n> 1. 全局通用的组件放在 /src/components下\n> 2. 其他业务页面中的组件，放在各自页面下的 ./components文件夹下\n> 3. 每个components文件夹下最多只有一层文件夹，且文件夹名称为组件的名称，文件夹下必须有`index.vue`或\n>    `index.js`，其他.vue文件统一大写开头（Pascal case），`components`下的子文件夹名称统一大写开头（PascalCase）\n>\n> #### 其他文件夹统一使用`kebab-case`的风格\n\n##### 全局公共组件：`/src/components`示例\n\n```css\n  - [components]\n    - [Breadcrumb]\n      - index.vue\n    - [Hamburger]\n      - index.vue\n    - [SvgIcon]\n      - index.vue\n```\n\n##### 业务页面内部封装的组件：以 `/src/views/layout/components`示例\n\n```css\n-[src]\n  - [views]\n    - [layout]\n      - [components]\n        - [Sidebar]\n          - index.vue\n          - Item.vue\n          - SidebarItem.vue\n        - AppMain.vue\n        - index.js\n        - Navbar.vue`\n```\n\nindex.js 中导出组件方式如下：\n\n```jsx\nexport { default as AppMain } from \'./AppMain\'\nexport { default as Navbar } from \'./Navbar\'\nexport { default as Sidebar } from \'./Sidebar\'\n```\n\n> 看index.js中最后一行代码，不难发现，为什么components下的子文件夹要使用`PascalCase`命名：\n>\n> ```jsx\n> export { default as Sidebar } from \'./sidebar\' // 使用kebab-case命名的文件夹\n> export { default as Sidebar } from \'./Sidebar\' // 使用 PascalCase命名的文件夹\n> ```\n>\n> 对于组件的导出/导入，我们一般都是使用大写字母开头的`PascalCase`风格，\n> 以区别于.vue组件内部的其他`camelCase`声明的变量，\n> `[Sidebar]`作为【侧边栏组件】的一个整体被导出，文件夹的命名也采用`PascalCase`，\n> 有利于index.js中export时的前后统一，避免很多情况下不注意区分大小写\n\n## 3. 文件命名规范\n\n### 3.1. `*.js`文件命名规范\n\n> 1. 属于类的.js文件，除index.js外，使用`PascalBase`风格\n> 2. 其他类型的.js文件，使用`kebab-case`风格\n> 3. 属于Api的，统一加上`Api`后缀\n\n### 3.2. `*.vue`文件命名规范\n\n> 除index.vue之外，其他.vue文件统一用`PascalBase`风格\n\n### 3.3. `*.less`文件命名规范\n\n> 统一使用`kebab-case`命名风格\n\n## 4 Views\n\n## views 命名\n\nviews 文件夹下面是由 以页面为单位的vue文件 或者 模块文件夹 组成的，放在 src 目录之下，与 components、assets 同级。\n\n### views 下的文件夹命名\n\n1. views 下面的文件夹代表着模块的名字\n2. 由名词组成（car、order、cart）\n3. 单词只能有一个（good: car order cart）（bad: carInfo carpage）\n4. 尽量是名词（good: car）（bad: greet good）\n5. 以小写开头（good: car）（bad: Car）\n\n### views 下的 vue 文件命名\n\n1. views 下面的 vue 文件代表着页面的名字\n2. 放在模块文件夹之下\n3. 只有一个文件的情况下不会出现文件夹，而是直接放在 views 目录下面，如 Login Home\n4. 尽量是名词\n5. 大写开头，开头的单词就是所属模块名字（CarDetail、CarEdit、CarList）\n6. 名字至少两个单词（good: CarDetail）（bad: Car）\n7. 常用结尾单词有（Detail、Edit、List、Info、Report）\n8. 以 Item 结尾的代表着组件（CarListItem、CarInfoItem）\n\n','',1,2,'2021-01-19 10:27:47',NULL,4,0,0,0,0),(4,'不备份数据库的血泪史！！！','之前把项目代码push到github上，但是忘记重新导出数据库文件','说多了都是泪，数据库构建好之后一定要导出一个文件作为**备份**。下次一定！！',NULL,1,2,'2021-03-20 09:25:25',NULL,9,0,0,0,0);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attention`
--

DROP TABLE IF EXISTS `attention`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attention` (
  `id` int NOT NULL AUTO_INCREMENT,
  `author_id` int NOT NULL,
  `user_id` int NOT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attention`
--

LOCK TABLES `attention` WRITE;
/*!40000 ALTER TABLE `attention` DISABLE KEYS */;
INSERT INTO `attention` VALUES (1,2,2,'2021-01-20 20:27:47');
/*!40000 ALTER TABLE `attention` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collect`
--

DROP TABLE IF EXISTS `collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collect` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `article_id` int NOT NULL,
  `fav_id` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collect`
--

LOCK TABLES `collect` WRITE;
/*!40000 ALTER TABLE `collect` DISABLE KEYS */;
INSERT INTO `collect` VALUES (1,2,2,1),(2,2,1,1),(4,1,1,1),(5,1,2,2),(6,1,3,3),(15,1,4,3);
/*!40000 ALTER TABLE `collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorites` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL,
  `visibility` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` VALUES (1,'默认收藏夹',1),(2,'测试',1),(3,'开发日记',0);
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `article_id` int NOT NULL,
  `user_id` int NOT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (1,2,2,'2021-01-20 20:27:47'),(2,1,2,'2021-01-20 20:27:47'),(3,2,1,'2021-01-20 20:27:47'),(4,1,1,'2021-01-20 20:27:47');
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plate`
--

DROP TABLE IF EXISTS `plate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `created` datetime NOT NULL,
  `last_update` datetime DEFAULT NULL,
  `deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plate`
--

LOCK TABLES `plate` WRITE;
/*!40000 ALTER TABLE `plate` DISABLE KEYS */;
INSERT INTO `plate` VALUES (1,'测试板块','2021-01-18 20:27:47',NULL,0),(2,'开发日记','2021-01-18 20:27:47',NULL,0),(4,'饭后茶话','2021-01-18 20:27:47',NULL,0);
/*!40000 ALTER TABLE `plate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `description` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'user','普通用户'),(2,'moderator','版主'),(3,'admin','普通管理员'),(4,'supertube','超级管理员');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `username` varchar(64) NOT NULL,
  `created` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `status` tinyint NOT NULL DEFAULT '0',
  `password` varchar(64) NOT NULL,
  `salt` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'rainbowcat','2021-01-15 20:27:47','2021-03-20 08:20:33',1,'17b9e8208146849014c82f4f6eee2b36','FK%&BKIW'),(2,'123456789','2021-01-15 20:24:45',NULL,0,'dc9fd4d70727e81bf713f8d4893f73c1','%sBQz&@B'),(6,'zhangsan','2021-01-15 20:40:29','2021-01-17 18:23:10',0,'a3680624391c103be5e8b30e1b0b47de','iL%#uczn'),(9,'bbbbbbbbb','2021-01-16 13:46:39',NULL,0,'faf1c9d21faaaa4894cb9c7ee357b848',')dadIduo');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_profile` (
  `id` int NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(145) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `introduction` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` VALUES (1,'rainbowcat','半边爱','男',NULL,'admin.163.com','12345678900','这是一条测试数据。hiahiahia~');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,4),(2,2,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-22 18:24:22
