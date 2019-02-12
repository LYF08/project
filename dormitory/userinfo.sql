-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2019-02-12 09:34:49
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
-- 表的结构 `userinfo`
--

CREATE TABLE `userinfo` (
  `ID` varchar(12) NOT NULL,
  `name` varchar(10) NOT NULL,
  `dormID` varchar(10) NOT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `password` varchar(11) NOT NULL,
  `nickname` varchar(10) DEFAULT NULL,
  `belong` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `userinfo`
--

INSERT INTO `userinfo` (`ID`, `name`, `dormID`, `phone`, `password`, `nickname`, `belong`) VALUES
('1', '', '', '', '', NULL, ''),
('10', '', '', '', '123456', NULL, ''),
('100', '', '', '', '', NULL, ''),
('10001', 'admin', 'A100', '12345678', '123456', NULL, ''),
('10002', 'abc', 'A000', '1234567890', '123456', NULL, ''),
('10003', 'abc', 'A000', '1234567890', '123456', NULL, ''),
('321', 'qqq', 'B000', '1236547890', '123456', 'dada', ''),
('666', '正式', 'C000', '1472583690', '123456', 'ok', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD PRIMARY KEY (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
