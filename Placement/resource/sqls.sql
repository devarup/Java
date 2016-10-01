-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 01, 2013 at 07:58 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

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
  `profile` varchar(250) NOT NULL,
  `spec` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `cmp_detail`
--

INSERT INTO `cmp_detail` (`id`, `cmp_id`, `cmp_name`, `cmp_url`, `cmp_detail`, `xii_marks`, `x_marks`, `interview`, `stream`, `profile`, `spec`) VALUES
(24, '3g', '3gtech', 'aa', 'vvfdffd', 67.7, 67.5, '2010-10-11', 'Bca', 'dfdf', 'NA'),
(25, 'IBM', 'Ibm solz', 'ibm.com', 'dgfh', 34, 68, '2013-10-11', 'Btech', 'gfg', 'CE'),
(26, 'Infosys', 'infosys soft', 'infosys.com', 'aaa', 67.7, 67.5, '2010-10-11', 'Btech', 'fdsfsd', 'CSE');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `user_id`, `user_pwd`, `role`) VALUES
(7, 'admin', 'admin', 'Admin'),
(34, 'mou', 'mou', 'Student'),
(33, 'atanu', 'atanu', 'Student'),
(32, 'arup', 'arup', 'Student');

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
  `x_board` varchar(15) NOT NULL,
  `spec` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_education`
--

INSERT INTO `user_education` (`user_id`, `stream`, `percentile`, `college`, `board`, `xii_marks`, `maths`, `xii_school`, `xii_board`, `x_marks`, `x_school`, `x_board`, `spec`) VALUES
('mou', 'Bca', 3, 'Jogmaya', 'Calcutta', 3, 1, 'United missonary', 'WB', 87, 'United missonary', 'WB', 'NA'),
('atanu', 'Bca', 87.8, 'Asutosh', 'CU', 76, 0, 'Endrews', 'WB', 77, 'Endrews', 'WB', 'NA'),
('arup', 'Btech', 56.8, 'Netajinagar', 'CU', 77, 1, 'SNNI', 'WB', 68, 'SNNI', 'WB', 'CSE');

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
  `email_id` varchar(40) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contact_1` varchar(15) NOT NULL,
  `contact_2` varchar(15) NOT NULL,
  `isSelected` tinyint(1) NOT NULL
) ENGINE=MEMORY DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_personal_detail`
--

INSERT INTO `user_personal_detail` (`user_id`, `first_name`, `last_name`, `dob`, `sex`, `email_id`, `address`, `contact_1`, `contact_2`, `isSelected`) VALUES
('arup', 'Arup Nath', 'Daw', '1983-10-12', 'M', 'mymail.arup@gmail.com', 'Tollygunge', '9903012949', '9804546217', 0),
('atanu', 'Atanu', 'Ganguly', '1985-10-12', 'M', 'atanu@gmail.com', 'Garia', '999999', '888888', 0),
('mou', 'Mou', 'Debnath', '1978-10-12', 'F', 'mouuu@gmail.com', 'Tollygunge,Regent park', '13444', '45556', 0);
