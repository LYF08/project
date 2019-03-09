-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2019-03-09 14:35:44
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
-- 表的结构 `stayinfo`
--

CREATE TABLE `stayinfo` (
  `stayID` int(10) UNSIGNED NOT NULL,
  `registerDate` datetime NOT NULL,
  `ID` varchar(12) NOT NULL,
  `dormID` varchar(10) NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  `contact` varchar(12) NOT NULL,
  `belong` varchar(12) NOT NULL,
  `name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `stayinfo`
--

INSERT INTO `stayinfo` (`stayID`, `registerDate`, `ID`, `dormID`, `startDate`, `endDate`, `contact`, `belong`, `name`) VALUES
(1, '2019-02-19 12:43:35', '100', '', '2019-02-19 12:43:00', '2019-02-19 13:00:00', '153758884665', 'A', ''),
(3, '2019-03-05 01:00:00', '24', 'A777', '2019-03-06 00:00:00', '2019-03-07 00:00:00', '252727', '', 'ROBOT');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `stayinfo`
--
ALTER TABLE `stayinfo`
  ADD PRIMARY KEY (`stayID`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `stayinfo`
--
ALTER TABLE `stayinfo`
  MODIFY `stayID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
