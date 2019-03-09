-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2019-03-09 14:35:35
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
-- 表的结构 `signrecord`
--

CREATE TABLE `signrecord` (
  `ID` int(11) NOT NULL,
  `Rtime` datetime NOT NULL,
  `houseparentID` varchar(12) NOT NULL,
  `nums` smallint(6) NOT NULL DEFAULT '0',
  `title` varchar(30) NOT NULL,
  `govern` varchar(12) NOT NULL,
  `totalnums` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `signrecord`
--

INSERT INTO `signrecord` (`ID`, `Rtime`, `houseparentID`, `nums`, `title`, `govern`, `totalnums`) VALUES
(1, '0000-00-00 00:00:00', '12', 0, '我的第一次签到', 'A', 0),
(2, '0000-00-00 00:00:00', '12', 0, '我的第一次签到', 'A', 0),
(3, '2019-03-09 15:53:05', '12', 2, '第三次签到', 'A', 2),
(5, '2019-03-09 19:44:52', '12', 0, '第四次签到', 'A', 3),
(6, '2019-03-09 19:53:22', '1', 0, '第五次签到', 'A', 3),
(7, '2019-03-09 20:02:56', '1', 3, '第七次签到一定要成功啊', 'A', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `signrecord`
--
ALTER TABLE `signrecord`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `houseparentID` (`houseparentID`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `signrecord`
--
ALTER TABLE `signrecord`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- 限制导出的表
--

--
-- 限制表 `signrecord`
--
ALTER TABLE `signrecord`
  ADD CONSTRAINT `signrecord_ibfk_1` FOREIGN KEY (`houseparentID`) REFERENCES `userinfoh` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
