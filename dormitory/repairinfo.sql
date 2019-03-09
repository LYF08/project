-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2019-03-09 14:35:19
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
(1, '2019-02-14 18:07:48', 'A100', '日光灯', '灯管坏了', '靠近阳台那边的', '12345678901', '无', 'A', 0),
(2, '2019-02-14 19:55:31', 'C000', '门', '被踢烂了', '一不小心踢烂了', '1234567890', '没了', 'A', 0),
(4, '2019-02-15 18:22:30', 'C000', '把手', '严重损坏', '', '1472583699', '', 'C', 0),
(5, '2019-02-16 19:36:51', '', '测试', '', '', '186781684', '', '', 1),
(6, '2019-02-16 21:44:13', '', '测试2', '', '', '127837888', '', '', 1),
(7, '2019-02-16 21:44:23', '', '测试3', '', '', '83785481687', '', '', 0),
(8, '2019-02-16 21:44:37', '', '测试4', '', '', '5434867610', '', '', 0),
(9, '2019-02-16 21:44:46', '', '测试5', '', '', '8678157046', '', '', 0),
(10, '2019-02-16 21:44:58', '', '测试6', '', '', '5435716040', '', '', 0),
(11, '2019-02-16 21:45:07', '', '测试7', '', '', '8678167048', '', '', 0),
(12, '2019-02-16 21:45:16', '', '测试8', '', '', '53783718876', '', '', 0),
(13, '2019-02-16 21:45:26', '', '测试9', '', '', '5678378840', '', '', 0),
(14, '2019-02-16 22:33:44', '', '测试10', '', '我就想看看这么长他能不能正常显示我就想看看这么长他能不能正常显示我就想看看这么长他能不能正常显示我就想看看这么长他能不能正常显示我就想看看这么长他能不能正常显示我就想看看这么长他能不能正常显示我就想看看这么长他能不能正常显示我就想看看这么长他能不能正常显示', '167867940', '我就想看看这么长他能不能正常显示我就想看看这么长他能不能正常显示我就想看看这么长他能不能正常显示我就想看看这么长他能不能正常显示我就想看看这么长他能不能正常显示', 'A', 0),
(15, '2019-02-17 23:09:16', '', '看看这么长行不行看看这么长行不行看看这么长行不行', '', '', '12783781684', '', '', 0);

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
  MODIFY `ApplyID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
