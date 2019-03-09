-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2019-03-09 14:35:27
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
-- 表的结构 `signed`
--

CREATE TABLE `signed` (
  `SID` varchar(12) NOT NULL,
  `recordID` int(11) NOT NULL,
  `signedtime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `signed`
--

INSERT INTO `signed` (`SID`, `recordID`, `signedtime`) VALUES
('1', 3, '2019-03-09 18:36:15'),
('1', 5, '2019-03-09 19:45:16'),
('1', 6, '2019-03-09 19:53:51'),
('1', 7, '2019-03-09 20:03:22'),
('10', 7, '2019-03-09 20:04:58'),
('100', 3, '2019-03-09 19:28:42'),
('100', 7, '2019-03-09 20:04:26');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `signed`
--
ALTER TABLE `signed`
  ADD PRIMARY KEY (`SID`,`recordID`),
  ADD KEY `recordID` (`recordID`);

--
-- 限制导出的表
--

--
-- 限制表 `signed`
--
ALTER TABLE `signed`
  ADD CONSTRAINT `signed_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `userinfo` (`ID`),
  ADD CONSTRAINT `signed_ibfk_2` FOREIGN KEY (`recordID`) REFERENCES `signrecord` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
