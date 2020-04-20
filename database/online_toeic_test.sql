-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 20, 2020 lúc 08:01 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `online_toeic_test`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `archivement`
--

CREATE TABLE `archivement` (
  `id` int(11) NOT NULL,
  `examinee_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `difficulty` int(11) NOT NULL COMMENT '1: easy, 2: normal, 3: hard',
  `score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `part`
--

CREATE TABLE `part` (
  `id` int(11) NOT NULL,
  `type` int(11) NOT NULL COMMENT '1: Listening, 2: Reading',
  `tittle` varchar(255) NOT NULL,
  `direction` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `part`
--

INSERT INTO `part` (`id`, `type`, `tittle`, `direction`) VALUES
(1, 1, 'Part 1: Photographs', 'Directions: For each question in this part, you will hear four statements about a picture in your test book. When you hear the statements, you must select the one statement that best describes what you see in the picture. Then find the number of the question on your answer sheet and mark your answer. The statements will not be printed.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `question`
--

CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `part_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `image_link` varchar(255) DEFAULT NULL,
  `audio_link` varchar(255) DEFAULT NULL,
  `difficulty` int(11) NOT NULL COMMENT '1: easy, 2: normal, 3:hard',
  `question_tittle` longtext,
  `optionA` text,
  `optionB` text,
  `optionC` text,
  `optionD` text,
  `answer` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `question_group`
--

CREATE TABLE `question_group` (
  `id` int(11) NOT NULL,
  `part_id` int(11) NOT NULL,
  `audio_link` varchar(255) DEFAULT NULL,
  `paragraph` longtext,
  `difficulty` int(11) NOT NULL COMMENT '1: easy, 2: normal, 3: hard'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `role` int(11) DEFAULT NULL COMMENT '1: Examninee, 2:Admin'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `archivement`
--
ALTER TABLE `archivement`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `part`
--
ALTER TABLE `part`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `question_group`
--
ALTER TABLE `question_group`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
