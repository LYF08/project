-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2019-03-20 12:20:33
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
-- 表的结构 `sendmessageinfo`
--

CREATE TABLE `sendmessageinfo` (
  `SendTime` datetime NOT NULL,
  `SenderID` varchar(12) NOT NULL,
  `SenderName` varchar(10) NOT NULL,
  `PostsID` int(11) NOT NULL,
  `Message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `sendmessageinfo`
--

INSERT INTO `sendmessageinfo` (`SendTime`, `SenderID`, `SenderName`, `PostsID`, `Message`) VALUES
('2019-03-18 18:16:43', '10001', 'admin', 1, '吐了'),
('2019-03-18 20:21:54', '10002', 'abc', 10, '和'),
('2019-03-19 22:45:11', '10001', 'admin', 9, '快乐'),
('2019-03-20 10:40:32', '10001', 'admin', 13, '歌'),
('2019-03-20 10:40:38', '10001', 'admin', 13, '哦哦哦'),
('2019-03-20 10:50:48', '10001', 'admin', 1, '7如图'),
('2019-03-20 19:42:06', '10001', 'admin', 14, '龙猫');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sendmessageinfo`
--
ALTER TABLE `sendmessageinfo`
  ADD PRIMARY KEY (`SendTime`,`SenderID`,`PostsID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
