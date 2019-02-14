-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2019-02-14 10:10:38
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
-- 表的结构 `repairinfo`
--

CREATE TABLE `repairinfo` (
  `ApplyID` int(10) UNSIGNED NOT NULL,
  `ApplyDate` datetime NOT NULL,
  `dormID` varchar(10) NOT NULL,
  `RepairName` text,
  `DamageCause` text,
  `Details` text,
  `Contact` varchar(11) NOT NULL,
  `OtherRemarks` text,
  `belong` varchar(12) NOT NULL,
  `Status` smallint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `repairinfo`
--

INSERT INTO `repairinfo` (`ApplyID`, `ApplyDate`, `dormID`, `RepairName`, `DamageCause`, `Details`, `Contact`, `OtherRemarks`, `belong`, `Status`) VALUES
(1, '2019-02-14 18:07:48', 'A100', '日光灯', '灯管坏了', '靠近阳台那边的', '12345678901', '无', '', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `repairinfo`
--
ALTER TABLE `repairinfo`
  ADD PRIMARY KEY (`ApplyID`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `repairinfo`
--
ALTER TABLE `repairinfo`
  MODIFY `ApplyID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
