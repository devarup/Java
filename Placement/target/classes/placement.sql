-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 27, 2013 at 12:34 AM
-- Server version: 5.1.33
-- PHP Version: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `placement`
--

-- --------------------------------------------------------

--
-- Table structure for table `cmp_detail`
--

CREATE TABLE IF NOT EXISTS `cmp_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cmp_id` varchar(20) NOT NULL,
  `cmp_name` varchar(50) NOT NULL,
  `cmp_url` varchar(20) NOT NULL,
  `cmp_detail` varchar(150) NOT NULL,
  `xii_marks` double NOT NULL,
  `x_marks` double NOT NULL,
  `interview` date NOT NULL,
  `stream` varchar(10) NOT NULL,
  `profile` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `cmp_detail`
--

INSERT INTO `cmp_detail` (`id`, `cmp_id`, `cmp_name`, `cmp_url`, `cmp_detail`, `xii_marks`, `x_marks`, `interview`, `stream`, `profile`) VALUES
(18, 'aaa', 'sasa', 'ewe', 'dfdf', 34, 33, '2010-10-11', 'Bca', 'dsfsd'),
(17, 'ayata', 'Ayata software solutions pvt ltd', 'ayata.com', 'dsfs', 34, 67.5, '2013-10-11', 'Btech', 'dfdsf'),
(19, 'wipro', 'Wipro tech', 'wipro.com', 'development', 45, 45, '2010-10-11', 'Bca', 'scasc');

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE IF NOT EXISTS `jobs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` varchar(20) NOT NULL,
  `comp_id` varchar(20) NOT NULL,
  `profile` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL,
  `interview` date NOT NULL,
  `stream_type` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`id`, `job_id`, `comp_id`, `profile`, `description`, `interview`, `stream_type`) VALUES
(1, 'careerstechno_0', 'Trcs', 'aaa', 'asdxad', '2010-10-11', 'Both'),
(2, 'careerstechno_1', 'ayata', 'aaa', 'asss', '2010-10-11', 'Bca'),
(3, 'careerstechno_2', 'ayata', 'a', 'cs', '2010-10-11', 'Bca'),
(4, 'careerstechno_3', 'TCS', 'developer', 'sfsf', '2013-10-11', 'Bca'),
(5, 'careerstechno_4', 'IBM', 'Develop', 'ssss', '2013-10-11', 'Bca');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `user_pwd` varchar(20) NOT NULL,
  `role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `user_id`, `user_pwd`, `role`) VALUES
(15, 'basudeb', 'basudev', 'Student'),
(14, 'sachin', 'sachin', 'Student'),
(13, 'tabla', 'tabla', 'Student'),
(7, 'admin', 'admin', 'Admin'),
(12, 'arup123', 'arup123', 'Student'),
(11, 'arup123', 'arup123', 'Student'),
(16, 'sudeb', 'sudeb', 'Student'),
(17, 'bam', 'bam', 'Student');

-- --------------------------------------------------------

--
-- Table structure for table `shortlist`
--

CREATE TABLE IF NOT EXISTS `shortlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `cmp_id` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `shortlist`
--


-- --------------------------------------------------------

--
-- Table structure for table `user_education`
--

CREATE TABLE IF NOT EXISTS `user_education` (
  `user_id` varchar(20) NOT NULL,
  `stream` varchar(10) NOT NULL,
  `percentile` double NOT NULL,
  `college` varchar(50) NOT NULL,
  `board` varchar(10) NOT NULL,
  `xii_marks` double NOT NULL,
  `maths` tinyint(1) NOT NULL,
  `xii_school` varchar(50) NOT NULL,
  `xii_board` varchar(15) NOT NULL,
  `x_marks` int(5) NOT NULL,
  `x_school` varchar(50) NOT NULL,
  `x_board` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_education`
--

INSERT INTO `user_education` (`user_id`, `stream`, `percentile`, `college`, `board`, `xii_marks`, `maths`, `xii_school`, `xii_board`, `x_marks`, `x_school`, `x_board`) VALUES
('arup123', 'Btech', 9.9, 'Techno Hooghly,Chinsurah', 'WBUT', 67.7, 1, 'SNNI', 'WB', 3, 'SNNI', 'WB'),
('arup_daw', 'Bca', 9.8, 'Techno Hooghly', 'WBUT', 59.5, 1, 'Sir nripendra nath institution', 'wb', 46, 'Sir nripendra nath institution', 'Westbengal'),
('tabla', 'Bca', 9.9, 'Netajinagar', 'CU', 34, 1, 'SNNI', 'WB', 68, 'fgdfg', 'WB'),
('sachin', 'Bca', 67.7, 'Techno Main', 'Wbut', 70, 1, 'SNNI', 'WB', 80, 'SNNi', 'WBUT'),
('basudeb', 'Btech', 45, 'wbut', 'wbut', 34, 1, 'sfdsf', 'Westbengal', 68, 'SNNI', 'asdasd'),
('sudeb', 'Bca', 67.9, 'Techno', 'Wbut', 45, 1, 'SNNI', 'Wb', 59, 'SNNI', 'wb'),
('bam', 'Btech', 60, 'aaaaaaa', 'bbbbbbbb', 56, 1, 'SNNI', 'WB', 68, 'SNNI', 'WB');

-- --------------------------------------------------------

--
-- Table structure for table `user_personal_detail`
--

CREATE TABLE IF NOT EXISTS `user_personal_detail` (
  `user_id` varchar(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `dob` date NOT NULL,
  `sex` varchar(1) NOT NULL,
  `email_id` varchar(25) NOT NULL,
  `address` varchar(50) NOT NULL,
  `contact_1` varchar(15) NOT NULL,
  `contact_2` varchar(15) NOT NULL,
  `isSelected` tinyint(1) NOT NULL
) ENGINE=MEMORY DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_personal_detail`
--

INSERT INTO `user_personal_detail` (`user_id`, `first_name`, `last_name`, `dob`, `sex`, `email_id`, `address`, `contact_1`, `contact_2`, `isSelected`) VALUES
('sudeb', 'sudeb', 'das', '1988-12-11', 'M', 'sudeb@gmail.com', 'Bullygunge', '9098776', '12345', 0),
('bam', 'bam', 'daw', '2001-12-12', 'M', 'sasf@gmail.com', 'tollygunge', '9903012949', '8888888', 0);
