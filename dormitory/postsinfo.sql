-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2019-03-20 12:20:04
-- 服务器版本： 5.7.17-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dormitory`
--

-- --------------------------------------------------------

--
-- 表的结构 `postsinfo`
--

CREATE TABLE `postsinfo` (
  `PostsID` int(10) UNSIGNED NOT NULL,
  `LatestReplyTime` datetime NOT NULL,
  `PostsDate` datetime NOT NULL,
  `ID` varchar(12) NOT NULL,
  `name` varchar(10) NOT NULL,
  `postsTitle` text NOT NULL,
  `postsContent` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `postsinfo`
--

INSERT INTO `postsinfo` (`PostsID`, `LatestReplyTime`, `PostsDate`, `ID`, `name`, `postsTitle`, `postsContent`) VALUES
(1, '2019-03-20 10:50:48', '2019-03-18 18:09:55', '10001', 'admin', '第一次测试', '哈哈'),
(2, '2019-03-18 18:33:41', '2019-03-18 18:33:41', '10001', 'admin', '第二次', '哈哈哈'),
(3, '2019-03-18 18:35:21', '2019-03-18 18:35:21', '10001', 'admin', '第三次', '额'),
(9, '2019-03-19 22:45:11', '2019-03-18 18:36:18', '10001', 'admin', '九', ''),
(10, '2019-03-18 20:21:54', '2019-03-18 20:21:21', '10002', 'abc', '十', ''),
(13, '2019-03-20 10:40:38', '2019-03-19 12:58:00', '10001', 'admin', '龙门', ''),
(14, '2019-03-20 19:42:06', '2019-03-20 19:35:07', '10001', 'admin', '何', ''),
(15, '2019-03-20 19:35:50', '2019-03-20 19:35:50', '10001', 'admin', '快乐', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `postsinfo`
--
ALTER TABLE `postsinfo`
  ADD PRIMARY KEY (`PostsID`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `postsinfo`
--
ALTER TABLE `postsinfo`
  MODIFY `PostsID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
