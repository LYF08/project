-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2019-03-09 14:36:01
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
-- 表的结构 `userinfoh`
--

CREATE TABLE `userinfoh` (
  `ID` varchar(12) NOT NULL,
  `name` varchar(10) NOT NULL,
  `govern` varchar(12) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `password` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `userinfoh`
--

INSERT INTO `userinfoh` (`ID`, `name`, `govern`, `phone`, `password`) VALUES
('1', 'Fast', 'A', '111111111', ''),
('10000', 'Admin', 'A', '123456', '123456'),
('12', 'DDD', 'A', '12312', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `userinfoh`
--
ALTER TABLE `userinfoh`
  ADD PRIMARY KEY (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
