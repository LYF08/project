-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2019-03-09 14:35:07
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
-- 表的结构 `departinfo`
--

CREATE TABLE `departinfo` (
  `departID` int(10) UNSIGNED NOT NULL,
  `registerDate` datetime NOT NULL,
  `ID` varchar(12) NOT NULL,
  `dormID` varchar(10) NOT NULL,
  `departCause` text NOT NULL,
  `departTime` datetime NOT NULL,
  `backTime` datetime NOT NULL,
  `contact` varchar(12) NOT NULL,
  `belong` varchar(12) NOT NULL,
  `name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `departinfo`
--

INSERT INTO `departinfo` (`departID`, `registerDate`, `ID`, `dormID`, `departCause`, `departTime`, `backTime`, `contact`, `belong`, `name`) VALUES
(1, '2019-02-18 16:03:31', '10001', 'A100', '去医院看病', '2019-02-18 15:57:00', '2019-02-18 18:00:00', '123456789011', 'A', ''),
(2, '2019-02-19 12:43:06', '100', '', '生病', '2019-02-19 12:42:00', '2019-02-19 11:42:00', '1234863493', 'A', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `departinfo`
--
ALTER TABLE `departinfo`
  ADD PRIMARY KEY (`departID`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `departinfo`
--
ALTER TABLE `departinfo`
  MODIFY `departID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
