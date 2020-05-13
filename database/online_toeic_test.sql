-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 13, 2020 lúc 11:11 PM
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
-- Cấu trúc bảng cho bảng `achievement`
--

CREATE TABLE `achievement` (
  `id` int(11) NOT NULL,
  `examinee_id` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `test_id` int(11) NOT NULL,
  `total_correct_answer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `achievement`
--

INSERT INTO `achievement` (`id`, `examinee_id`, `date`, `test_id`, `total_correct_answer`) VALUES
(74, 1, '2020-05-14 01:22:53', 1, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `answer`
--

CREATE TABLE `answer` (
  `id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `answer`
--

INSERT INTO `answer` (`id`, `question_id`, `content`) VALUES
(5, 41, 'Salary'),
(6, 41, 'Work hours'),
(7, 41, 'Benefits'),
(8, 41, 'Vacations'),
(9, 42, 'She has only one child.'),
(10, 42, 'She is looking for a full-time job.'),
(11, 42, 'She does not like to work mornings.'),
(12, 42, 'She wants to work for the man\'s company.'),
(13, 43, 'It is a religious holiday.'),
(14, 43, 'She has a scheduling conflict.'),
(15, 43, 'Her daughter is ill.'),
(16, 43, 'She has a school class.'),
(17, 44, 'There is a traffic jam.'),
(18, 44, 'She is lost.'),
(19, 44, 'Her car broke down.'),
(20, 44, 'She was in an accident.'),
(21, 45, 'Turn left at the off-ramp'),
(22, 45, 'Drive faster'),
(23, 45, 'Use caution'),
(24, 45, 'Call him later'),
(25, 46, 'Opposite the supermarket'),
(26, 46, 'On the right-hand side'),
(27, 46, 'At the bottom of the ramp'),
(28, 46, 'On Michigan Street'),
(29, 47, 'Accountant'),
(30, 47, 'Manager'),
(31, 47, 'Travel agent'),
(32, 47, 'Receptionist'),
(33, 48, 'He does not like long flights.'),
(34, 48, 'He wants to save money.'),
(35, 48, 'He is an inexperienced traveler.'),
(36, 48, 'He is taking a vacation.'),
(37, 49, 'Change his mind'),
(38, 49, 'Reconsider his decision'),
(39, 49, 'Book the 9:30 flight'),
(40, 49, 'Pay the woman'),
(41, 50, 'Neighbors'),
(42, 50, 'Salesmen'),
(43, 50, 'Reporters'),
(44, 50, 'Co-worker'),
(45, 51, 'There are too many hotel rooms.'),
(46, 51, 'The convention center is booked.'),
(47, 51, 'There has been an unexpected change.'),
(48, 51, 'She cannot make it to the airport.'),
(49, 52, 'Scheduling transportation'),
(50, 52, 'Cancelling the reservations'),
(51, 52, 'Postponing the convention'),
(52, 52, 'Telephoning the CEO'),
(53, 53, 'Get his money back'),
(54, 53, 'Buy a briefcase'),
(55, 53, 'Exchange merchandise'),
(56, 53, 'Find his receipt'),
(57, 54, 'Perform an exchange'),
(58, 54, 'Come back tomorrow'),
(59, 54, 'Photocopy the receipt'),
(60, 54, 'Make a purchase'),
(61, 55, 'Buy a new briefcase'),
(62, 55, 'Go shopping'),
(63, 55, 'Insist on a refund'),
(64, 55, 'Leave the store'),
(65, 56, 'A salesman'),
(66, 56, 'A real estate developer'),
(67, 56, 'A landlord'),
(68, 56, 'A tenant'),
(69, 57, 'They are poorly constructed.'),
(70, 57, 'They are in a bad location.'),
(71, 57, 'The prices are too high.'),
(72, 57, 'The economy has been depressed.'),
(73, 58, 'They are ready to put on the market.'),
(74, 58, 'They need to be repainted.'),
(75, 58, 'They will be challenging to sell.'),
(76, 58, 'They are a good value for the money.'),
(77, 59, 'Negotiating a sale'),
(78, 59, 'Arranging financing'),
(79, 59, 'Debating a product'),
(80, 59, 'Making small talk'),
(81, 60, 'He can\'t find part-time work.'),
(82, 60, 'His wife lost her job.'),
(83, 60, 'He does not make much money.'),
(84, 60, 'His company is going bankrupt.'),
(88, 61, 'Reduce the price'),
(89, 61, 'Give the man a job'),
(90, 61, 'Delay monthly payments'),
(91, 61, 'Sell him a different car'),
(92, 62, 'In an office'),
(93, 62, 'At a drive-through'),
(94, 62, 'In a restaurant'),
(95, 62, 'In a park'),
(96, 63, 'Try the swordfish'),
(97, 63, 'Order crab cakes'),
(98, 63, 'Pick up the tab'),
(99, 63, 'Select a beverage'),
(100, 64, 'He is a teetotaler.'),
(101, 64, 'He does not drink wine often.'),
(102, 64, 'He would prefer to have beer.'),
(103, 64, 'He is treating the woman to lunch.'),
(104, 65, 'Find a section of a hospital.'),
(105, 65, 'Locate a doctor'),
(106, 65, 'Get driving directions'),
(107, 65, 'Leave the parking garage.'),
(108, 66, 'She leads him to the red wing.'),
(109, 66, 'She hands him a map.'),
(110, 66, 'She gives him directions.'),
(111, 66, 'She calls for a doctor.'),
(112, 67, 'They are frequently ill.'),
(113, 67, 'They work at the hospital.'),
(114, 67, 'They live near the hospital.'),
(115, 67, 'They will help the man in the future.'),
(116, 68, 'At a meeting'),
(117, 68, 'In a post office'),
(118, 68, 'In a library'),
(119, 68, 'At an airport'),
(120, 69, 'Compare rates'),
(121, 69, 'Buy a receipt'),
(122, 69, 'Mail a package'),
(123, 69, 'Cancel insurance'),
(124, 70, 'Insuring the contents'),
(125, 70, 'Using express delivery'),
(126, 70, 'Sending it air mail'),
(127, 70, 'Filing a special form'),
(128, 77, 'Professional attorneys'),
(129, 77, 'Media representatives'),
(130, 77, 'Law school graduates'),
(131, 77, 'Company clients'),
(132, 76, 'A news report'),
(133, 76, 'A weather report'),
(134, 76, 'An advertisement'),
(135, 76, 'Music'),
(136, 75, 'It is unusually heavy.'),
(137, 75, 'It is flowing smoothly.'),
(138, 75, 'It is unexpectedly light.'),
(139, 75, 'It is normal for this time of day.'),
(140, 74, 'Young women'),
(141, 74, 'Students'),
(142, 74, 'Commuters'),
(143, 74, 'Chief executives'),
(144, 73, 'By visiting City Hall.'),
(145, 73, 'By making a phone call.'),
(146, 73, 'By watching TV.'),
(147, 73, 'By sending an e-mail.'),
(148, 72, 'The road will get a new surface.'),
(149, 72, 'All lanes will be closed.'),
(150, 72, 'It will get a new name.'),
(151, 72, 'Drivers will be fined.'),
(152, 71, 'To declare an emergency'),
(153, 71, 'To publicize an Internet site'),
(154, 71, 'To inform of to a city project'),
(155, 71, 'To warn about coming dangers'),
(156, 78, 'Send an e-mail to the firm'),
(157, 78, 'Call back during normal office hours'),
(158, 78, 'Push a button on their phone'),
(159, 78, 'Leave a voice mail message'),
(160, 79, 'On Saturdays and Sundays'),
(161, 79, 'During regular office hours'),
(162, 79, 'After they press zero'),
(163, 79, 'When they need an attorney urgently.'),
(164, 80, 'Manager'),
(165, 80, 'Editor'),
(166, 80, 'Sales person'),
(167, 80, 'Accountant'),
(168, 81, 'Research results'),
(169, 81, 'New strategies'),
(170, 81, 'Financial strength'),
(171, 81, 'Corporate layoffs'),
(172, 82, 'Advertising campaign'),
(173, 82, 'New products'),
(174, 82, 'Logo re-design'),
(175, 82, 'Increased prices'),
(176, 83, 'Technology spending'),
(177, 83, 'A customer survey'),
(178, 83, 'Economic recovery'),
(179, 83, 'Paying down debt'),
(180, 84, 'They would buy a new computer.'),
(181, 84, 'They would pay off bills.'),
(182, 84, 'They would use more discretion.'),
(183, 84, 'They would put it in the bank'),
(184, 85, 'The recession has ended.'),
(185, 85, 'It will not improve for another year.'),
(186, 85, 'It is at its historic high point.'),
(187, 85, 'People have confidence in it.'),
(188, 86, 'A credit product'),
(189, 86, 'An annual sale'),
(190, 86, 'A grand opening'),
(191, 86, 'A financial service'),
(192, 87, 'A free gift'),
(193, 87, 'A special key'),
(194, 87, 'A guarantee'),
(195, 87, 'A discount'),
(196, 88, 'Make a phone call.'),
(197, 88, 'Get a new credit card.'),
(198, 88, 'Come to the store.'),
(199, 88, 'Check out a website.'),
(200, 89, 'New bus service'),
(201, 89, 'A bus route change'),
(202, 89, 'Extended hours'),
(203, 89, 'Road construction'),
(204, 90, 'The campus connector route'),
(205, 90, 'The stop at Marshall Street'),
(206, 90, 'The hours of service'),
(207, 90, 'The cost of bus tickets'),
(208, 91, 'Contact the transit coordinator'),
(209, 91, 'Ask the bus driver'),
(210, 91, 'Look in the newspaper'),
(211, 91, 'E-mail the university president'),
(212, 92, 'Ray Cheevers'),
(213, 92, 'Patty Paulson'),
(214, 92, 'Faulkner Financial Services'),
(215, 92, 'Tricia Townshend'),
(216, 93, 'To solicit a sale'),
(217, 93, 'To answer a question'),
(218, 93, 'To request a service'),
(219, 93, 'To arrange a meeting'),
(220, 94, 'Send an e-mail'),
(221, 94, 'Return the phone call'),
(222, 94, 'Meet with Patty'),
(223, 94, 'Ask for an address'),
(224, 95, 'On radio'),
(225, 95, 'On the Internet'),
(226, 95, 'On television'),
(227, 95, 'At a theater'),
(228, 96, 'Stormy'),
(229, 96, 'Sunny'),
(230, 96, 'Snowy'),
(231, 96, 'Overcast'),
(232, 97, 'It is being broadcast on Friday.'),
(233, 97, 'It is not an accurate forecast.'),
(234, 97, 'It is being broadcast in the morning.'),
(235, 97, 'It was taped the night before.'),
(236, 98, 'A business executive'),
(237, 98, 'A professor'),
(238, 98, 'An actress'),
(239, 98, 'A talk-show host'),
(240, 99, 'Got married'),
(241, 99, 'Wrote a novel'),
(242, 99, 'Became a father'),
(243, 99, 'Recorded his first song'),
(244, 100, 'Critics did not like it.'),
(245, 100, 'It is selling surprisingly well.'),
(246, 100, 'It is very well-written.'),
(247, 100, 'He is planning to write a sequel.'),
(249, 131, 'stock'),
(250, 131, 'equipment'),
(251, 131, 'property'),
(252, 131, 'revenue'),
(253, 132, 'require'),
(254, 132, 'requiring'),
(255, 132, 'are required'),
(256, 132, 'were required'),
(257, 133, 'early'),
(258, 133, 'again'),
(259, 133, 'more'),
(260, 133, 'instead'),
(261, 134, 'Folding bicycles have become more common.'),
(262, 134, 'Additional service fees may apply.'),
(263, 134, 'You can obtain route maps at most stations.'),
(264, 134, 'You must also supply your own bike lock.'),
(265, 135, 'actual'),
(266, 135, 'future'),
(267, 135, 'practical'),
(268, 135, 'effective'),
(269, 136, 'Similary'),
(270, 136, 'Therefore'),
(271, 136, 'However'),
(272, 136, 'Accordingly'),
(273, 137, 'We believe you will see that our products are still a great value'),
(274, 137, 'Our efforts to stay profitable have not been successful'),
(275, 137, 'Whe hope our competitors will raise their prices too.'),
(276, 137, 'Our products are healthier than traditional baked goods.'),
(277, 138, 'supportive'),
(278, 138, 'support'),
(279, 138, 'supporter'),
(280, 138, 'supports'),
(281, 139, 'insights'),
(282, 139, 'surveys'),
(283, 139, 'improvements'),
(284, 139, 'revisions'),
(285, 140, 'resolve'),
(286, 140, 'predict'),
(287, 140, 'consider'),
(288, 140, 'advertise'),
(289, 141, 'I look forward to networking with other professionals in the field'),
(290, 141, 'My membership will expire at the end of the year.'),
(291, 141, 'I will be giveing a presentation at the conference'),
(292, 141, 'I would like to apply for the position soon.'),
(293, 142, 'generosity'),
(294, 142, 'generous'),
(295, 142, 'generously'),
(296, 142, 'generousness'),
(297, 143, 'The association grants scholarships for those studying zoology'),
(298, 143, 'Supporters like you help preserve the park for public use.'),
(299, 143, 'We hope you enjoyed your visit to the park today'),
(300, 143, 'Interested parties can volunteer to clean wildlife habitats'),
(301, 144, 'generations'),
(302, 144, 'lifestyles'),
(303, 144, 'committees'),
(304, 144, 'planners'),
(305, 145, 'designer'),
(306, 145, 'designs'),
(307, 145, 'designing'),
(308, 145, 'designed'),
(309, 146, 'researching'),
(310, 146, 'organizing'),
(311, 146, 'leading'),
(312, 146, 'funding'),
(313, 101, 'must'),
(314, 101, 'should'),
(315, 101, 'can'),
(316, 101, 'have'),
(317, 102, 'has gone'),
(318, 102, 'had left'),
(319, 102, 'has went'),
(320, 102, 'had been'),
(321, 103, 'recommendation'),
(322, 103, 'package'),
(323, 103, 'letter'),
(324, 103, 'deal'),
(325, 104, 'association'),
(326, 104, 'associates'),
(327, 104, 'associate'),
(328, 104, 'associated'),
(329, 105, 'cut'),
(330, 105, 'laid'),
(331, 105, 'put'),
(332, 105, 'thrown'),
(333, 106, 'in'),
(334, 106, 'at'),
(335, 106, 'on'),
(336, 106, 'along'),
(337, 107, 'boring'),
(338, 107, 'bored'),
(339, 107, 'boredom'),
(340, 107, 'bores'),
(341, 108, 'good'),
(342, 108, 'superb'),
(343, 108, 'well'),
(344, 108, 'excellent'),
(345, 109, 'their'),
(346, 109, 'their'),
(347, 109, 'their'),
(348, 109, 'their'),
(349, 110, 'locally'),
(350, 110, 'locals'),
(351, 110, 'local'),
(352, 110, 'locality'),
(353, 111, 'exceptional'),
(354, 111, 'exceptional'),
(355, 111, 'exceptional'),
(356, 111, 'exceptionally'),
(357, 112, 'principal'),
(358, 112, 'principles'),
(359, 112, 'principals'),
(360, 112, 'principle'),
(361, 113, 'Prospective'),
(362, 113, 'Prospective'),
(363, 113, 'Prospective'),
(364, 113, 'Provocative'),
(365, 114, 'expand'),
(366, 114, 'expanding'),
(367, 114, 'expands'),
(368, 114, 'to expand'),
(369, 115, 'Due to'),
(370, 115, 'Because'),
(371, 115, 'As'),
(372, 115, 'Despite'),
(373, 116, 'him'),
(374, 116, 'he'),
(375, 116, 'himself'),
(376, 116, 'his'),
(377, 117, 'name'),
(378, 117, 'signature'),
(379, 117, 'autograph'),
(380, 117, 'moniker'),
(381, 118, 'often'),
(382, 118, 'seldom'),
(383, 118, 'occasionally'),
(384, 118, 'sometimes'),
(385, 119, 'on'),
(386, 119, 'at'),
(387, 119, 'in'),
(388, 119, 'below'),
(389, 120, 'important'),
(390, 120, 'import'),
(391, 120, 'importance'),
(392, 120, 'importantly'),
(393, 121, 'simply'),
(394, 121, 'simplify'),
(395, 121, 'simple'),
(396, 121, 'simplicity'),
(397, 122, 'until'),
(398, 122, 'unless'),
(399, 122, 'except'),
(400, 122, 'so'),
(401, 123, 'experience'),
(402, 123, 'experiencing'),
(403, 123, 'experiential'),
(404, 123, 'experienced'),
(405, 124, 'stable'),
(406, 124, 'rapid'),
(407, 124, 'patient'),
(408, 124, 'stagnant'),
(409, 125, 'run'),
(410, 125, 'been'),
(411, 125, 'lost'),
(412, 125, 'put'),
(413, 126, 'receiver'),
(414, 126, 'receptionist'),
(415, 126, 'reciprocal'),
(416, 126, 'recipient'),
(417, 127, 'definite'),
(418, 127, 'definition'),
(419, 127, 'definitely'),
(420, 127, 'definably'),
(421, 128, 'his'),
(422, 128, 'her'),
(423, 128, 'its'),
(424, 128, 'himself'),
(425, 129, 'stolen'),
(426, 129, 'stealing'),
(427, 129, 'stole'),
(428, 129, 'steal'),
(429, 130, 'work'),
(430, 130, 'part'),
(431, 130, 'piece'),
(432, 130, 'area'),
(433, 147, '10 percent'),
(434, 147, '15 percent'),
(435, 147, '20 percent'),
(436, 147, '25 percent'),
(437, 148, '$80'),
(438, 148, '$100'),
(439, 148, '$120'),
(440, 148, '$140'),
(441, 149, 'To inform all employees of sick-leave procedures'),
(442, 149, 'To extend staff members\' vacation time'),
(443, 149, 'To introduce the PR department'),
(444, 149, 'To inform managers of a policy change'),
(445, 150, 'Immediately'),
(446, 150, 'Next week'),
(447, 150, 'In three months'),
(448, 150, 'At the start of the new year'),
(449, 151, 'Dial extension 526'),
(450, 151, 'Contact a Human Resources director'),
(451, 151, 'E-mail the company CEO'),
(452, 151, 'Consult the employee handbook'),
(453, 152, 'She was unhappy in her job.'),
(454, 152, 'She asked for a promotion.'),
(455, 152, 'She started a new business.'),
(456, 152, 'She lent money to Thomas.'),
(457, 153, 'Organizing conferences'),
(458, 153, 'Processing business loans'),
(459, 153, 'Corresponding with clients'),
(460, 153, 'Maintaining a Web site'),
(461, 154, 'She is a skillful writer.'),
(462, 154, 'She is a diligent worker.'),
(463, 154, 'She is an excellent teacher.'),
(464, 154, 'She is an experienced supervisor.'),
(465, 155, 'Raise her salary'),
(466, 155, 'Increase her hours'),
(467, 155, 'Reduce her workload'),
(468, 155, 'Recommend her for a job'),
(469, 156, 'A name'),
(470, 156, 'An address'),
(471, 156, 'A telephone number'),
(472, 156, 'An e-mail address'),
(473, 157, 'The company\'s mailing address'),
(474, 157, 'The amount of time before delivery begins'),
(475, 157, 'The names of partner companies'),
(476, 157, 'The cost of a multiple-year subscription'),
(477, 158, 'A meal'),
(478, 158, 'A theater ticket'),
(479, 158, 'Transportation to the city center'),
(480, 158, 'The first night\'s lodging'),
(481, 159, 'Clean rooms'),
(482, 159, 'Friendly staff'),
(483, 159, 'Reasonable rates'),
(484, 159, 'Convenient location'),
(485, 160, 'It is not as good as Olympic Dreams.'),
(486, 160, 'It does not cover previous centuries in detail.'),
(487, 160, 'It is a well-written work.'),
(488, 160, 'It is currently available online.'),
(489, 161, 'Names of reference sources'),
(490, 161, 'A listing of historical dates'),
(491, 161, 'A thorough opening section'),
(492, 161, 'A schedule of local sporting events'),
(493, 162, 'Community libraries'),
(494, 162, 'University students'),
(495, 162, 'Sports centers'),
(496, 162, 'Sports players'),
(497, 163, 'A marketing firm'),
(498, 163, 'A trading company'),
(499, 163, 'A research institute'),
(500, 163, 'A publishing company'),
(501, 164, 'It was started six years ago.'),
(502, 164, 'It plans to expand its operations to other countries.'),
(503, 164, 'It will be hiring several marketing researchers.'),
(504, 164, 'It has been successful because of its marketing strategies.'),
(505, 165, 'His degree in marketing'),
(506, 165, 'His overseas travel experience'),
(507, 165, 'His familiarity with a software program'),
(508, 165, 'His presentations at professional seminars'),
(509, 166, 'Its large number of employees'),
(510, 166, 'Its international reputation'),
(511, 166, 'Its use of up-to-date computer technology'),
(512, 166, 'Its high ranking on a list of successful businesses'),
(513, 167, 'A school'),
(514, 167, 'A bookstore'),
(515, 167, 'A library'),
(516, 167, 'A housing complex'),
(517, 168, 'Nancy Johnson'),
(518, 168, 'Les Elder'),
(519, 168, 'Robert Erwin'),
(520, 168, 'Max Johnson'),
(521, 169, 'The performance of the cleaning crew is poor.'),
(522, 169, 'The cost of electricity is very high.'),
(523, 169, 'The December meeting should be rescheduled.'),
(524, 169, 'The doors of the library should be locked during non-business hours.'),
(525, 170, 'Calypso'),
(526, 170, 'Baroque'),
(527, 170, 'Mystic'),
(528, 170, 'Trend'),
(529, 171, 'It is usually expensive.'),
(530, 171, 'It is an easy way to modernize a room.'),
(531, 171, 'It will increase the resale value of the home or office.'),
(532, 171, 'It should be done only after consulting a designer.'),
(533, 172, 'They are sold in most stores.'),
(534, 172, 'They will soon be discontinued.'),
(535, 172, 'Their prices have been reduced.'),
(536, 172, 'They are the most popular models.'),
(537, 173, 'They last longer than standard lights.'),
(538, 173, 'They use less energy than regular lights do.'),
(539, 173, 'They are more expensive than standard lights.'),
(540, 173, 'They generate less heat than other types of lights do.'),
(541, 174, 'They are floor lamps.'),
(542, 174, 'They come in many sizes.'),
(543, 174, 'hey need to be professionally installed.'),
(544, 174, 'They can be exposed to moisture.'),
(545, 175, 'To help manufacturers increase their profits'),
(546, 175, 'To create new jobs in the manufacturing sector'),
(547, 175, 'To teach manufacturers how to reduce waste'),
(548, 175, 'To lower the retail prices of consumer goods'),
(549, 176, 'paper'),
(550, 176, 'money'),
(551, 176, 'sales'),
(552, 176, 'coins'),
(553, 177, 'Author of the article'),
(554, 177, 'Clear Water CEO'),
(555, 177, 'President of the MEP'),
(556, 177, 'Clear Water general manager'),
(557, 178, 'Clear Water\'s sales rose by 3 percent'),
(558, 178, 'Clear Water\'s production capacity increased 10 percent'),
(559, 178, 'Clear Water dropped its retail prices'),
(560, 178, 'Clear Water halved its energy production'),
(561, 179, '$10.5 billion'),
(562, 179, '$57,000'),
(563, 179, '$1,000,000'),
(564, 179, '$1.4 billion'),
(565, 180, 'To confirm delivery'),
(566, 180, 'To order supplies'),
(567, 180, 'To request money'),
(568, 180, 'To rectify mistakes'),
(569, 181, 'They are in different countries.'),
(570, 181, 'They do business frequently.'),
(571, 181, 'They have a poor relationship.'),
(572, 181, 'They are both new companies.'),
(573, 182, 'differences'),
(574, 182, 'errors'),
(575, 182, 'figures'),
(576, 182, 'calculations'),
(577, 183, '50'),
(578, 183, '10'),
(579, 183, '5'),
(580, 183, '6'),
(581, 184, 'For placing such a large order'),
(582, 184, 'For referring a new customer'),
(583, 184, 'For back-ordering ink cartridges'),
(584, 184, 'For being such a steady client'),
(585, 185, 'respond'),
(586, 185, 'renounce'),
(587, 185, 'receive'),
(588, 185, 'rejoice'),
(589, 186, 'To celebrate a birthday'),
(590, 186, 'To announce a wedding'),
(591, 186, 'To raise money for charity'),
(592, 186, 'To solicit lots of presents'),
(593, 187, 'Father of the bride'),
(594, 187, 'The groom'),
(595, 187, 'Father of the groom'),
(596, 187, 'The minister'),
(597, 188, '10 o\'clock'),
(598, 188, '11 o\'clock'),
(599, 188, '2 o\'clock'),
(600, 188, 'Noon'),
(601, 189, 'She used to live with Marilyn Strummers.'),
(602, 189, 'She used to live with Marilyn Strummers.'),
(603, 189, 'She will take photographs at the wedding.'),
(604, 189, 'She will serve food at the lunch and reception.'),
(605, 190, 'To apologize for maintenance work'),
(606, 190, 'To promote a swimming-diving meet'),
(607, 190, 'To publicize the information hotline'),
(608, 190, 'To announce schedule changes'),
(609, 191, 'One'),
(610, 191, 'Two'),
(611, 191, 'Three'),
(612, 191, 'Four'),
(613, 192, 'There will be a public swim from 6:30-7:30 p.m. Wednesday, July 16th.'),
(614, 192, 'There will be a Water Fun class from 1:30-2:30 p.m. on Thursday of next week.'),
(615, 192, 'Family swims are scheduled in the summer on Sundays and Thursdays.'),
(616, 192, 'Adult and senior swims are offered twice on Mondays throughout the summer.'),
(617, 193, 'strenuous'),
(618, 193, 'water'),
(619, 193, 'adolescent'),
(620, 193, 'oxygen'),
(621, 194, 'By calling the pool office'),
(622, 194, 'By calling the information hot line'),
(623, 194, 'By visiting the pool website'),
(624, 194, 'By writing for a special notice'),
(625, 195, 'A marriage'),
(626, 195, 'A graduation'),
(627, 195, 'An engagement'),
(628, 195, 'A birth'),
(629, 196, 'Obey'),
(630, 196, 'Respond'),
(631, 196, 'Come'),
(632, 196, 'Affirm'),
(633, 197, 'Snacks'),
(634, 197, 'Gifts'),
(635, 197, 'Dinner'),
(636, 197, 'Photograhs'),
(637, 198, 'She has to work.'),
(638, 198, 'Her husband is sick.'),
(639, 198, 'She will be on vacation.'),
(640, 198, 'Her car needs repair.'),
(641, 199, 'She is a relative of Keegan\'s.'),
(642, 199, 'She is impulsive.'),
(643, 199, 'She is inconsiderate.'),
(644, 199, 'She is good friends with Diane.'),
(645, 200, '5 percent'),
(646, 200, '10 percent'),
(647, 200, '15 percent'),
(648, 200, '20 percent');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `examinee_answer`
--

CREATE TABLE `examinee_answer` (
  `id` int(11) NOT NULL,
  `achievement_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `answer_id` int(11) DEFAULT NULL,
  `option` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `examinee_answer`
--

INSERT INTO `examinee_answer` (`id`, `achievement_id`, `question_id`, `answer_id`, `option`) VALUES
(269, 74, 10, NULL, 'D'),
(270, 74, 40, NULL, 'C'),
(271, 74, 70, 125, 'D'),
(272, 74, 100, 246, 'D'),
(273, 74, 111, 354, 'C'),
(274, 74, 146, 309, 'D'),
(275, 74, 154, 462, 'D');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `part`
--

CREATE TABLE `part` (
  `id` int(11) NOT NULL,
  `test_id` int(11) NOT NULL,
  `part_num` int(11) NOT NULL,
  `type` int(11) NOT NULL COMMENT '1: Listening, 2: Reading',
  `tittle` varchar(255) NOT NULL,
  `direction` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `part`
--

INSERT INTO `part` (`id`, `test_id`, `part_num`, `type`, `tittle`, `direction`) VALUES
(1, 1, 1, 1, 'Part 1: Photographs', 'Directions: For each question in this part, you will hear four statements about a picture in your test book. When you hear the statements, you must select the one statement that best describes what you see in the picture. Then find the number of the question on your answer sheet and mark your answer. The statements will not be printed.\r\n'),
(2, 1, 2, 1, 'Part 2: Question-Response', 'Directions: You will hear a question or statement and three responses spoken in English. They will not be printed in your test book and will be spoken only one time. Select the best response to the question or statement and mark the letter (A), (B ), or (C) on your answer sheet.'),
(3, 1, 3, 1, 'Part 3: Conversations', 'Directions: You will hear some conversations between two people. You will be asked to answer three questions about what the speakers say in each conversation. Select the best response to each question and mark the letter (A), (B), (C), or (D) on your answer sheet. The conversations will not be printed in your test book and will be spoken only one time'),
(4, 1, 4, 1, 'Part 4: Talks', 'Directions: You will hear some talks given by a single speaker. You will be asked to answer three questions about what the speaker says in each talk. Select the best response to each question and mark the letter (A), (B), (C), or (D) on your answer sheet. The talks will not be printed in your test book and will be spoken only one time.'),
(5, 1, 5, 2, 'Part 5: Incomplete Sentences', 'Directions: A word or phrase is missing in each of the following sentences. Four answer choices are given below each sentence. Select the best answer to complete the sentence. Then mark the letter (A), (B), (C), or (D) on your answer sheet.'),
(6, 1, 6, 2, 'Part 6: Text Completion', 'Directions: Read the texts that follow. A word or phrase is missing in some of the sentences. Four answer choices are given below each of the sentences. Select the best answer to complete the text. Then mark the letter (A), (B), (C), or (D) on your answer sheet.'),
(7, 1, 7, 2, 'Part 7: Reading Comprehension', 'Directions: In this part you will read a selection of texts, such as magazine and newspaper articles, letters, and advertisements. Each text is followed by several questions. Select the best answer for each question and mark the letter (A), (B), (C), or (D) on your answer sheet.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `question`
--

CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `index` int(11) DEFAULT NULL,
  `part_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `image_link` varchar(255) DEFAULT NULL,
  `question_tittle` longtext,
  `correct_answer` char(1) DEFAULT NULL,
  `correct_answer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `question`
--

INSERT INTO `question` (`id`, `index`, `part_id`, `group_id`, `image_link`, `question_tittle`, `correct_answer`, `correct_answer_id`) VALUES
(1, 1, 1, NULL, 'http://localhost:3000/image/1_IMAGE_1.jpg', NULL, 'c', NULL),
(2, 2, 1, NULL, 'http://localhost:3000/image/1_IMAGE_2.jpg', NULL, 'a', NULL),
(3, 3, 1, NULL, 'http://localhost:3000/image/1_IMAGE_3.jpg', NULL, 'd', NULL),
(4, 4, 1, NULL, 'http://localhost:3000/image/1_IMAGE_4.jpg', NULL, 'c', NULL),
(5, 5, 1, NULL, 'http://localhost:3000/image/1_IMAGE_5.jpg', NULL, 'b', NULL),
(6, 6, 1, NULL, 'http://localhost:3000/image/1_IMAGE_6.jpg', NULL, 'a', NULL),
(7, 7, 1, NULL, 'http://localhost:3000/image/1_IMAGE_7.jpg', NULL, 'b', NULL),
(8, 8, 1, NULL, 'http://localhost:3000/image/1_IMAGE_8.jpg', NULL, 'c', NULL),
(9, 9, 1, NULL, 'http://localhost:3000/image/1_IMAGE_9.jpg', NULL, 'b', NULL),
(10, 10, 1, NULL, 'http://localhost:3000/image/1_IMAGE_10.jpg', NULL, 'd', NULL),
(11, 11, 2, NULL, NULL, NULL, 'c', NULL),
(12, 12, 2, NULL, NULL, NULL, 'b', NULL),
(13, 13, 2, NULL, NULL, NULL, 'b', NULL),
(14, 14, 2, NULL, NULL, NULL, 'a', NULL),
(15, 15, 2, NULL, NULL, NULL, 'c', NULL),
(16, 16, 2, NULL, NULL, NULL, 'b', NULL),
(17, 17, 2, NULL, NULL, NULL, 'c', NULL),
(18, 18, 2, NULL, NULL, NULL, 'a', NULL),
(19, 19, 2, NULL, NULL, NULL, 'c', NULL),
(20, 20, 2, NULL, NULL, NULL, 'a', NULL),
(21, 21, 2, NULL, NULL, NULL, 'c', NULL),
(22, 22, 2, NULL, NULL, NULL, 'b', NULL),
(23, 23, 2, NULL, NULL, NULL, 'b', NULL),
(24, 24, 2, NULL, NULL, NULL, 'a', NULL),
(25, 25, 2, NULL, NULL, NULL, 'c', NULL),
(26, 26, 2, NULL, NULL, NULL, 'c', NULL),
(27, 27, 2, NULL, NULL, NULL, 'b', NULL),
(28, 28, 2, NULL, NULL, NULL, 'a', NULL),
(29, 29, 2, NULL, NULL, NULL, 'b', NULL),
(30, 30, 2, NULL, NULL, NULL, 'a', NULL),
(31, 31, 2, NULL, NULL, NULL, 'c', NULL),
(32, 32, 2, NULL, NULL, NULL, 'c', NULL),
(33, 33, 2, NULL, NULL, NULL, 'b', NULL),
(34, 34, 2, NULL, NULL, NULL, 'b', NULL),
(35, 35, 2, NULL, NULL, NULL, 'c', NULL),
(36, 36, 2, NULL, NULL, NULL, 'a', NULL),
(37, 37, 2, NULL, NULL, NULL, 'b', NULL),
(38, 38, 2, NULL, NULL, NULL, 'a', NULL),
(39, 39, 2, NULL, NULL, NULL, 'c', NULL),
(40, 40, 2, NULL, NULL, NULL, 'b', NULL),
(41, 41, 3, NULL, NULL, 'What are the speakers mainly discussing?', NULL, 6),
(42, 42, 3, NULL, NULL, 'What can be inferred about the woman?', NULL, 12),
(43, 43, 3, NULL, NULL, 'Why can\'t the woman work on Thursday evenings?', NULL, 14),
(44, 44, 3, NULL, NULL, 'Why is Marcia going to be late?', NULL, 17),
(45, 45, 3, NULL, NULL, 'What does Lyle suggest Marcia do?', NULL, 23),
(46, 46, 3, NULL, NULL, 'Where is Lyle\'s office located?', NULL, 28),
(47, 47, 3, NULL, NULL, 'What position does the woman most likely hold?', NULL, 31),
(48, 48, 3, NULL, NULL, 'What is implied about the man?', NULL, 34),
(49, 49, 3, NULL, NULL, 'What will the man probably do next?', NULL, 38),
(50, 50, 3, NULL, NULL, 'Who most likely are the speakers?', NULL, 44),
(51, 51, 3, NULL, NULL, 'What problem does the woman have?', NULL, 47),
(52, 52, 3, NULL, NULL, 'What does the man suggest?', NULL, 49),
(53, 53, 3, NULL, NULL, 'What does the man want to do?', NULL, 53),
(54, 54, 3, NULL, NULL, 'What does the woman suggest the man do?', NULL, 57),
(55, 55, 3, NULL, NULL, 'What will the man probably do next?', NULL, 64),
(56, 56, 3, NULL, NULL, 'Who most likely is Byron?', NULL, 66),
(57, 57, 3, NULL, NULL, 'Why does Jennifer think Byron might have difficulty?', NULL, 72),
(58, 58, 3, NULL, NULL, 'What does Byron say about the condos?', NULL, 76),
(59, 59, 3, NULL, NULL, 'What are the speakers doing?', NULL, 77),
(60, 60, 3, NULL, NULL, 'Why is the man worried about money?', NULL, 82),
(61, 61, 3, NULL, NULL, 'What does the woman offer to do?', NULL, 90),
(62, 62, 3, NULL, NULL, 'Where is this conversation most likely taking place?', NULL, 94),
(63, 63, 3, NULL, NULL, 'What does the woman suggest the man do?', NULL, 99),
(64, 64, 3, NULL, NULL, 'What can be inferred about the man?', NULL, 101),
(65, 65, 3, NULL, NULL, 'What is the man trying to do?', NULL, 104),
(66, 66, 3, NULL, NULL, 'How does the woman help the man?', NULL, 110),
(67, 67, 3, NULL, NULL, 'What does the woman imply about members of her family?', NULL, 112),
(68, 68, 3, NULL, NULL, 'Where is this conversation most likely taking place?', NULL, 117),
(69, 69, 3, NULL, NULL, 'What does the woman want to do?', NULL, 122),
(70, 70, 3, NULL, NULL, 'What does the man suggest?', NULL, 124),
(71, 71, 4, NULL, NULL, 'What is the main purpose of the announcement?', NULL, 154),
(72, 72, 4, NULL, NULL, 'What will happen on Main Street?', NULL, 148),
(73, 73, 4, NULL, NULL, 'According to the speaker, how can listeners get more information?', NULL, 145),
(74, 74, 4, NULL, NULL, 'Who is the intended audience?', NULL, 142),
(75, 75, 4, NULL, NULL, 'What does the speaker say about traffic?', NULL, 139),
(76, 76, 4, NULL, NULL, 'What will listeners hear next?', NULL, 132),
(77, 77, 4, NULL, NULL, 'Who is the message for?', NULL, 131),
(78, 78, 4, NULL, NULL, 'What should listeners do if they want to make an appointment?', NULL, 158),
(79, 79, 4, NULL, NULL, 'When should listeners call the answering service?', NULL, 163),
(80, 80, 4, NULL, NULL, 'What position does the speaker most likely hold?', NULL, 164),
(81, 81, 4, NULL, NULL, 'What is the speaker mainly discussing?', NULL, 169),
(82, 82, 4, NULL, NULL, 'The speaker mentions all of the following EXCEPT', NULL, 175),
(83, 83, 4, NULL, NULL, 'What is the speaker mainly discussing?', NULL, 178),
(84, 84, 4, NULL, NULL, 'According to the speaker, how would customers spend $500?', NULL, 181),
(85, 85, 4, NULL, NULL, 'What does the speaker say about the economy?', NULL, 185),
(86, 86, 4, NULL, NULL, 'What is being advertised?', NULL, 191),
(87, 87, 4, NULL, NULL, 'What does the speaker offer?', NULL, 194),
(88, 88, 4, NULL, NULL, 'What does the speaker urge listeners to do?', NULL, 196),
(89, 89, 4, NULL, NULL, 'What is being announced?', NULL, 201),
(90, 90, 4, NULL, NULL, 'According to the speaker, what will remain the same?', NULL, 206),
(91, 91, 4, NULL, NULL, 'What should listeners do if they have questions?', NULL, 208),
(92, 92, 4, NULL, NULL, 'Who is the message for?', NULL, 212),
(93, 93, 4, NULL, NULL, 'Why is the speaker calling?', NULL, 219),
(94, 94, 4, NULL, NULL, 'What should the listener do next?', NULL, 221),
(95, 95, 4, NULL, NULL, 'Where is this report most likely being broadcast?', NULL, 226),
(96, 96, 4, NULL, NULL, 'What kind of weather does the speaker predict for tomorrow?', NULL, 228),
(97, 97, 4, NULL, NULL, 'What can be inferred about this report?', NULL, 234),
(98, 98, 4, NULL, NULL, 'Who most likely is the speaker?', NULL, 239),
(99, 99, 4, NULL, NULL, 'What did Neal Trapp do at age 22?', NULL, 243),
(100, 100, 4, NULL, NULL, 'What does the speaker say about Neal Trapp\'s novel?', NULL, 245),
(101, NULL, 5, NULL, NULL, 'Employees who wish to take the day after Thanksgiving as a personal day off _____ to get managerial approval.', NULL, 316),
(102, NULL, 5, NULL, NULL, 'Mr. Hernandez _____ to Switzerland on a business trip, but messages can be relayed to him through his secretary, Ms. Constantinople..', NULL, 317),
(103, NULL, 5, NULL, NULL, 'After several days of negotiations, Turner Associates finally made a marketing _____ with Ignatius Imports.', NULL, 324),
(104, NULL, 5, NULL, NULL, 'In Mr. Carter\'s absence, inquiries should be directed to his _____, Mr. Zimbrowski.', NULL, 327),
(105, NULL, 5, NULL, NULL, 'Wilson Electronics announced Tuesday that 500 workers will be _____ off next month due to the slumping economy.', NULL, 330),
(106, NULL, 5, NULL, NULL, 'The post office is located _____ the end of the block, next to Charlestown Dry Cleaners.', NULL, 334),
(107, NULL, 5, NULL, NULL, 'Mrs. Summers complained that the CEO\'s power-point presentation on the history of modern architecture was _____.', NULL, 337),
(108, NULL, 5, NULL, NULL, 'Mr. Hawkins is a hard worker who usually performs quite _____ under pressure.', NULL, 343),
(109, NULL, 5, NULL, NULL, 'Because of _____ exceptional durability, IXC chips are in high demand for the new QC operating systems.', NULL, 345),
(110, NULL, 5, NULL, NULL, 'The Daily Times reports that the bubble has burst on the _____ housing market, sending home prices spiraling sharply downward.', NULL, 351),
(111, NULL, 5, NULL, NULL, 'Two delays, a thunderstorm and a missed connection combined to make Mr. Cox\'s cross country flight _____ miserable.', NULL, 356),
(112, NULL, 5, NULL, NULL, '\"Customers come first\" has always been one of the key business _____ at M & M Mortgages.', NULL, 358),
(113, NULL, 5, NULL, NULL, '_____ clients should be apprised of purchasing arrangements before they commit to a long-term contract.', NULL, 361),
(114, NULL, 5, NULL, NULL, 'The Xerxes Corporation plans _____ next year with the opening of branch offices in Zurich, Amsterdam and Tokyo.', NULL, 368),
(115, NULL, 5, NULL, NULL, '_____ heavy rain, this afternoon\'s baseball game has been rescheduled for Friday.', NULL, 369),
(116, NULL, 5, NULL, NULL, 'During the meeting, Zeke Grabowski made _____ loud and clear about his position on the firm\'s proposed acquisition of Penny Pharmaceuticals.', NULL, 375),
(117, NULL, 5, NULL, NULL, 'To be valid under state law, the contract requires the _____ of the company\'s CFO as well as its chairman.', NULL, 378),
(118, NULL, 5, NULL, NULL, 'Though not a sworn vegetarian, Health.com Chairman Harold Hopper _____ eats meat.', NULL, 382),
(119, NULL, 5, NULL, NULL, 'After speeding to the airport and sprinting across the terminal, the PelCro Corp. executives arrived just _____ time to catch their flight.', NULL, 387),
(120, NULL, 5, NULL, NULL, 'We cannot overemphasize the _____ of delivering the shipment by no later than noon on Friday the 13th.', NULL, 391),
(121, NULL, 5, NULL, NULL, 'Mr. Zenter explained that he _____ couldn\'t justify the capital expenditure required to finance Ms. Ruble\'s start-up company.', NULL, 393),
(122, NULL, 5, NULL, NULL, 'Ms. Mertenson will be unavailable next week _____ you have made a previous appointment.', NULL, 398),
(123, NULL, 5, NULL, NULL, 'Channel 2\'s weather forecasts are more reliable than Channel 7\'s, because its meteorologists have better credentials and are more _____.', NULL, 404),
(124, NULL, 5, NULL, NULL, 'Rucker Limited\'s second-quarter earnings were significantly affected by a _____ economy, which has led to rising unemployment and threat of increased inflation.', NULL, 408),
(125, NULL, 5, NULL, NULL, 'Since the restaurant had _____ out of lobster, it gave us a discount on prawns and chips.', NULL, 409),
(126, NULL, 5, NULL, NULL, 'If the intended _____ is not at home, leave notification that the package may be picked up at the post office during regular business hours.', NULL, 416),
(127, NULL, 5, NULL, NULL, 'Research director Tom Montgomery said he can\'t predict when the new arthritis drug will be ready, but he assured the board that his department is _____ making progress.', NULL, 419),
(128, NULL, 5, NULL, NULL, 'Mrs. Hammersmith asked Ms. Cotton to fax her _____ layout for the new advertisement as soon as possible, because deadline was approaching.', NULL, 422),
(129, NULL, 5, NULL, NULL, 'Ms. Griffiths was eliminated as a candidate when she answered yes to the question, \"Have you ever _____ anything from a previous employer?\"', NULL, 425),
(130, NULL, 5, NULL, NULL, 'Each employee has an important _____ to play in ensuring the success of our business model.', NULL, 429),
(131, 131, 6, 1, NULL, NULL, NULL, 250),
(132, 132, 6, 1, NULL, NULL, NULL, 255),
(133, 133, 6, 1, NULL, NULL, NULL, 257),
(134, 134, 6, 1, NULL, NULL, NULL, 264),
(135, 135, 6, 2, NULL, NULL, NULL, 268),
(136, 136, 6, 2, NULL, NULL, NULL, 271),
(137, 137, 6, 2, NULL, NULL, NULL, 273),
(138, 138, 6, 2, NULL, NULL, NULL, 278),
(139, 139, 6, 3, NULL, NULL, NULL, 281),
(140, 140, 6, 3, NULL, NULL, NULL, 287),
(141, 141, 6, 3, NULL, NULL, NULL, 289),
(142, 142, 6, 3, NULL, NULL, NULL, 294),
(143, 143, 6, 4, NULL, NULL, NULL, 298),
(144, 144, 6, 4, NULL, NULL, NULL, 301),
(145, 145, 6, 4, NULL, NULL, NULL, 308),
(146, 146, 6, 4, NULL, NULL, NULL, 312),
(147, NULL, NULL, 5, NULL, 'What discount is offered on the cost of renting a car?', NULL, 434),
(148, NULL, NULL, 5, NULL, 'How much would a 70 year-old person pay for a package that includes the Native American show?', NULL, 439),
(149, NULL, NULL, 6, NULL, 'What is the main purpose of this memo?', NULL, 444),
(150, NULL, NULL, 6, NULL, 'When does the change take effect?', NULL, 448),
(151, NULL, NULL, 6, NULL, 'What should supervisors do if they have questions?', NULL, 450),
(152, NULL, NULL, 7, NULL, 'What can be inferred about Jean?', NULL, 453),
(153, NULL, NULL, 7, NULL, 'What is NOT cited as part of Jean\'s work?', NULL, 458),
(154, NULL, NULL, 7, NULL, 'What does Thomas say about Jean?', NULL, 462),
(155, NULL, NULL, 7, NULL, 'What does Thomas offer to do for Jean?', NULL, 468),
(156, NULL, NULL, 8, NULL, 'What information must the subscriber provide to receive promotional offers?', NULL, 472),
(157, NULL, NULL, 8, NULL, 'What information is included on this card?', NULL, 474),
(158, NULL, NULL, 9, NULL, 'According to the advertisement, what is provided for free at the hotel?', NULL, 477),
(159, NULL, NULL, 9, NULL, 'What is NOT mentioned about the hotel?', NULL, 483),
(160, NULL, NULL, 10, NULL, 'What does Andrew Huff suggest about the book?', NULL, 487),
(161, NULL, NULL, 10, NULL, 'What is NOT mentioned as being included in the book?', NULL, 492),
(162, NULL, NULL, 10, NULL, 'For what group is the book particularly recommended?', NULL, 493),
(163, NULL, NULL, 11, NULL, 'What kind of business is Amarin, Ltd.?', NULL, 500),
(164, NULL, NULL, 11, NULL, 'What is stated in the letter about Amarin, Ltd.?', NULL, 501),
(165, NULL, NULL, 11, NULL, 'What did the writer want to emphasize about his background?', NULL, 507),
(166, NULL, NULL, 11, NULL, 'What does the letter indicate is a sign that Amarin, Ltd., is doing very well?', NULL, 512),
(167, NULL, NULL, 12, NULL, 'What institution is being discussed?', NULL, 515),
(168, NULL, NULL, 12, NULL, 'Who contributed money to this institution?', NULL, 519),
(169, NULL, NULL, 12, NULL, 'According to the minutes, what remark did Ms. Sprague make?', NULL, 524),
(170, NULL, NULL, 13, NULL, 'Which model is best if cost is a concern?', NULL, 525),
(171, NULL, NULL, 13, NULL, 'What is suggested about changing the lighting in a home or office?', NULL, 530),
(172, NULL, NULL, 13, NULL, 'Why are the lighting models mentioned in the brochure?', NULL, 536),
(173, NULL, NULL, 13, NULL, 'According to the brochure, what is NOT true of energy-efficient lights?', NULL, 539),
(174, NULL, NULL, 13, NULL, 'What is true of Mystic lights?', NULL, 541),
(175, NULL, NULL, 14, NULL, 'What is the main purpose of MEP?', NULL, 547),
(176, NULL, NULL, 14, NULL, 'In the article, the word \"green\" in paragraph 1, line 2, is closest in meaning to', NULL, 550),
(177, NULL, NULL, 14, NULL, 'Who is Mark McCartney?', NULL, 556),
(178, NULL, NULL, 14, NULL, 'What is NOT true?', NULL, 557),
(179, NULL, NULL, 14, NULL, 'According to the article, how much money did MEP help firms save last year?', NULL, 564),
(180, NULL, NULL, 15, NULL, 'What is the main function of the invoice?', NULL, 567),
(181, NULL, NULL, 15, NULL, 'What can be inferred about Stanley Supplies and Office Corral?', NULL, 570),
(182, NULL, NULL, 15, NULL, 'In the e-mail, the word \"discrepancies\" in paragraph 2, line 1, is closest in meaning to', NULL, 573),
(183, NULL, NULL, 15, NULL, 'How many additional crates of computer chairs is Ms. Velasquiz expecting?', NULL, 579),
(184, NULL, NULL, 15, NULL, 'According to the invoice, why did Office Corral receive free promotional brochures?', NULL, 582),
(185, NULL, NULL, 16, NULL, 'In the invitation, the letters \"RSVP\" in paragraph 4, line 1, are closest in meaning to', NULL, 585),
(186, NULL, NULL, 16, NULL, 'Why is the invitation mainly being sent?', NULL, 590),
(187, NULL, NULL, 16, NULL, 'Who is Howard Jacobson?', NULL, 595),
(188, NULL, NULL, 16, NULL, 'What time does Patty Pakola\'s flight leave for China?', NULL, 598),
(189, NULL, NULL, 16, NULL, 'What can be inferred about Gloria Stroust?', NULL, 601),
(190, NULL, NULL, 17, NULL, 'What is the main purpose of the notice?', NULL, 608),
(191, NULL, NULL, 17, NULL, 'How many Water Exercise classes will be affected by the pool closure?', NULL, 610),
(192, NULL, NULL, 17, NULL, 'What is NOT true?', NULL, 615),
(193, NULL, NULL, 17, NULL, 'In the schedule, the word \"aqua\" in line 4 is closest in meaning to', NULL, 618),
(194, NULL, NULL, 17, NULL, 'According to the schedule, how would someone find out more about the Masters Workout?', NULL, 621),
(195, NULL, NULL, 18, NULL, 'What event is the open house celebrating?', NULL, 628),
(196, NULL, NULL, 18, NULL, 'What event is the open house celebrating?', NULL, 630),
(197, NULL, NULL, 18, NULL, 'In the invitation, the term \"Hors devours\" is closest in meaning to', NULL, 633),
(198, NULL, NULL, 18, NULL, 'Why can\'t Robin attend the open house?', NULL, 639),
(199, NULL, NULL, 18, NULL, 'What can be inferred about Robin?', NULL, 644),
(200, NULL, NULL, 5, NULL, 'What discount is offered on the cost of renting a car?', NULL, 647);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `question_group`
--

CREATE TABLE `question_group` (
  `id` int(11) NOT NULL,
  `index` int(11) DEFAULT NULL,
  `tittle` varchar(255) DEFAULT NULL,
  `part_id` int(11) NOT NULL,
  `image_link` varchar(255) DEFAULT NULL,
  `paragraph` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `question_group`
--

INSERT INTO `question_group` (`id`, `index`, `tittle`, `part_id`, `image_link`, `paragraph`) VALUES
(1, 1, 'Part 6 - Group 1', 6, NULL, 'Lakeview Railway Onboard Bicycle Policy\r\nWould you like to use your bicycle to explore the Lakeview Corridor Scenic Area? Our trains have the _____(131) you need to safely transport your bike When booking your ticket, just remember that reservations _____(132) for both you and your bicycle. Reserve your bicycle sport _____(133). There are a limited number of storage racks on each train. You are responsible for stowing your bike securely _____(134). Lakeview Railway does not take responsibility for bicycles lost or damaged aboard our trains.'),
(2, 2, 'Part 6 - Group 2', 6, NULL, 'Corelli\'s Bakery\r\n15 Middlemass Street\r\nYoungstown, Ohio 44515\r\nDear Valued Customer:\r\nFor the last three years we have charged the same wholesale prices for our baked goods, including cakes, pies, cookies, and brownies. We regret that sharply rising prices for our raw ingredients, such as sugar and fruit, have forced us to raise our prices by 5 percent _____(135). August 1. We have made every attempt to avoid this price increase. _____(136), we refuse to compromise on the quality of our products. Using the best ingredients available will allow us to provide the delicious desserts your restaurant guests have come to expect. _____(137). We appreciate your _____(138) and look forward to continuing to serve you.\r\nSincerely,\r\nTony Corelli, Owner'),
(3, 3, 'Part 6 - Group 3', 6, NULL, 'To: Noora Abadi\r\nFrom: Alexis Palmer\r\nSubject: Informational interview\r\nDate: 4 February\r\nDear Ms.Abadi\r\nThank you for taking the time to meet with me yesterday about careers in the aerospace industry. Your _____(139) were helpful and have inspried me to seek additional work experience in the field before I apply to graduate school.\r\nI will consult the Web sites you recommended for job opportunities. As you also suggested, I will _____(140) a membership in the Easern Aeronautic Professioncal Association. _____(141). I appreciate the information you shared about the organization\'s conference at the end of the month. \r\nThank you again for your _____(142) assistance.\r\nSincerely,\r\nAlexis Palmer.'),
(4, 4, 'Part 6 - Group 4', 6, NULL, '15 October\r\nGPO Box 985\r\nCANBERRA ACT 6512\r\nDear Ms. Wilson,\r\nOn behalf of the Austraia Wildlife Park Association, thank you for your donation of 40 AUD to our national park. _____(143). Individual contributions have helped it stay open to visitors for more than 50 years. Our goal is to keep the park system running effectively for future _____(144) to enjoy.\r\nEnclosed please find a copy of our brochure, which lists various programmes _____(145) to benefit both park visitors and our wildlife habitats. Please consider _____(146) one of these programmes in the future. The money would be used wisely and would be deeply appreciated.\r\nSincerely.\r\nAkosua Masika, Membership Chair'),
(5, NULL, 'Part 7 - Group 1', 7, NULL, 'Put some excitement in your life..\r\nwith Adventure Tours\r\nVisit the Grand Canyon\r\nWe offer two fantastic tour packages.\r\nChoose the one that\'s right for you and your family\r\nPackage 1\r\n* A horseback tour of the Grand Canyon (morning or afternoon)\r\n* 2-day, 1-night accommodation at Canyon Caverns Hotel\r\n* 15 % discount on rental car\r\n* 20% discount at Grand Canyon souvenir shop\r\nAdults 18-64...$120 Adults 65+...$100\r\nTeens 13-17...$80 Children 5-12..$60\r\nPackage 2\r\nIncludes everything from Package 1, PLUS\r\n* 25% discount at Grand Canyon View Restaurant\r\n* Free admission to Native American show\r\nAdults 18-64...$140 Adults 65+...$120\r\nTeens 13-17...$100 Children 5-12..$80\r\nFor more information, call 1-80-555-4543\r\nor visit us on the Web at www.adventure_tours.com'),
(6, NULL, 'Part 7 - Group 2', 7, NULL, 'To: Supervisors\r\nFrom: Janelle Requia, Human Resources Director\r\nRe: Vacations\r\nAs of January 1st we will institute a new vacation policy. All employees who have been working for the\r\ncompany two years or less will receive one week (five working days) of paid vacation per year. Employees who\r\nhave been working here three to five years will receive two weeks (ten working days) of paid vacation per year.\r\nEmployees who have been with the company five to ten years will receive three weeks (15 working days) of\r\npaid vacation per year. Employees who have been here more than 10 years will receive four weeks (20 working\r\ndays) of paid vacation per year.\r\nPlease note that this does not effect current policies for sick days and personal leave. All employees, regardless\r\nof experience, will still receive five days of paid sick leave per year, as well as two days of paid personal leave.\r\nPlease post the new vacation policy in your departments as soon as possible. Also, employee handbooks are\r\nbeing revised to reflect the changes in vacation policy. These handbooks should be ready within the next two\r\nweeks. When they are, you are responsible to distribute them to employees, and to send us verification that\r\neach employee has received the handbook and understands the new vacation policy.\r\nThank you for your cooperation in this matter. If you have any questions, please contact me at extension 254 or\r\nthe assistant HR director, Gladys Haynes, at extension 256.'),
(7, NULL, 'Part 7 - Group 3', 7, NULL, 'Dear Jean,\r\nI wanted to write you a note to thank you. I am sorry that you felt disappointed that your work\r\nresponsibilities were not what you expected. I have enjoyed having your assistance with my projects.\r\nAlthough the tasks we handled were not as varied as you would have liked, just think about what you\r\nand I have accomplished since September. We organized the annual small business conference,\r\nupdated the association\'s web site, and answered scores of inquiries, many in great detail, from\r\nbusiness owners who needed advice on a range of topics: loans, benefits, licensing, etc.\r\nI feel the year has been very productive for both of us. You\'ve been an congenial and conscientious\r\nassistant and all of us have the highest regard for your abilities. Please feel free to call upon me for a\r\nrecommendation if you require one for future employment.\r\nBest of luck,\r\nThomas'),
(8, NULL, 'Part 7 - Group 4', 7, NULL, 'Don\'t Let Your Subscription to Biz News Weekly Lapse!\r\nFill out and return this card today to keep up with the latest news and trends in business!\r\n____ 3-month renewal -- $26.00 ____ 6-month renewal -- $45.00\r\n____ 12-month renewal -- $75.00 (our best value -- approximately $1.44 an issue!)\r\n(Please print)\r\nName __________________________________________\r\nAddress ________________________________________ Suite/Apt. _________________\r\nCity __________ State/Province __________ Zip/post code __________\r\nChoose one:\r\n_____ Payment enclosed. _____ Bill me later.\r\nWould you like to receive FREE offers and promotions from our partner companies via e-mail?\r\n_____ Yes, my e-mail address is ______________. _____ No, thank you.\r\nBiz News Weekly is published once a week. Please allow 4-6 weeks for delivery of first issue. The savings are\r\nbased on a 12-month cover price of $104.00. For subscription questions, please call 476-555-2378 or visit or\r\nweb site at www.bnw.com/subscriptions.'),
(9, NULL, 'Part 7 - Group 5', 7, NULL, 'Hotel Bella\r\nMadrid, Spain\r\nFind out what people are saying about us!\r\n\"This was our first stay at Hotel Bella and it was definitely worth every cent -- friendly service -- sparkling clean\r\nrooms -- wonderful! Thank you for a great few days!\" J.G.\r\n\"The service was excellent, everything was in working order and the staff was courteous and warm. Very, very\r\nnice. Don\'t change anything.\" R.S.\r\n\"Absolutely fabulous! The front desk staff was extremely helpful with directions to points of interest in the area. The restaurant -- the dinner menu in particular -- was simply superb. We have stayed at numerous hotels,\r\nbut this has to be the best!\" L.G.\r\n\"On Day 1, I was pleasantly surprised by the complimentary breakfast. I am going to tell all my family and\r\nfriends to visit your hotel when they travel to Madrid.\" K.K.\r\n\"Hotel Bella is close to public transportation, the city center, the theaters, the museums -- an excellent location\r\nfor the traveler who wants to do it all.\" E.M.'),
(10, NULL, 'Part 7 - Group 6', 7, NULL, 'A History of Sports from Ancient Times to the Present\r\nBy Rebecca Jean Porter\r\nIllustrated, 248 pp.\r\nOakview Press, Westport, CT $32.95\r\nRebecca Jean Porter, the author of Olympic Dreams, has attained another perfect score in this\r\nengaging and readable history. A History of Sports from Ancient Times to the Present covers everything\r\nfrom sporting events in ancient Rome to the origins of teams sports in North America, and it includes a\r\nsection on sports played on contemporary university campuses. I highly recommend the chapter with\r\ndetailed instructions on how to play games that had previously been lost over time. Porter\'s\r\ncomprehensive introduction and bibliography, as well as the time line of dates and events, make this a\r\nreference work that should be purchased by all public libraries. An online companion volume will be\r\npublished next year.\r\n-- Andrew Huff'),
(11, NULL, 'Part 7 - Group 7', 7, NULL, '13870 Nares Road\r\nBangkok\r\nThailand 10500\r\nJune 30\r\nDear Ms. Baharn,\r\nI\'d like to thank you for the time you spent with me discussing the marketing researcher position at\r\nAmarin, Ltd. After interviewing with you and touring the facility, I feel strongly that this company\r\nwould be an ideal place for me to work.\r\nI now understand why Amarin, Ltd., is considered the premier publisher of travel and tourism books in\r\nthe region. I am impressed by the fact that it as been listed as one of Thailand\'s ten most successful\r\nbusinesses since it was founded six years ago. The company\'s reputation for quality is also reflected in\r\nits outstanding record of employee retention.\r\nI wanted to emphasize the fact that I attended a three-week intensive seminar on MarkTrends, the\r\nforemost marketing research software package. I know the job description mentions the ability to use\r\nMarkTrends, and I wanted to let you know that I am very comfortable using this software.\r\nAgain, thank you for your time and consideration. I hope to hear from you soon concerning your hiring\r\ndecision.\r\nYours truly,\r\nAnusak Arinchai'),
(12, NULL, 'Part 7 - Group 8', 7, NULL, 'Meeting of the Milton Public Library Trustees\r\nDecember 4\r\nPresent: Les Elder (chairperson), Nancy Johnson (treasurer), Jennifer Palmatier (secretary), Justin Mayrand\r\n(technical consultant), Megan Sprague (librarian) Absent: Mary Erwin (trustee), Max Johnson (trustee)\r\nMr. Elder began the meeting at 6:00 p.m.\r\nTreasurer\'s Report/Budget Review The library has $4,300.00 remaining in this year\'s budget. This includes a\r\ndonation of $2,300.00 made by robert Erwin, former trustee and president of the National Library\r\nOrganization, and must be spent by December 31.\r\nMs. Johnson suggested that the trustees spend the $2,300.00 as follows: $900.00 will be allocated for books;\r\n$400.00 for supplies; and $1,000.00 for building repairs. All members present agreed.\r\nBuilding Repairs and Improvements Mr. Elder expressed concern about the recent electricity bills, which were\r\nquite high. The issue will be discussed at the January 14 meeting after the year\'s budget has been reviewed.\r\nMiscellaneous Business Ms. Sprague noted that the library building should be kept locked when it is not\r\nofficially open to the public, even if staff or cleaning crews are present inside the building.\r\nMr. Elder ended the meeting at 7:00 p.m.\r\nThe next meeting will be on Thursday, December 18, at 5:00 p.m. in the Milton Public Library.'),
(13, NULL, 'Part 7 - Group 9', 7, NULL, 'Classique Lighting floor lamps and ceiling light fixtures are an easy way to update any room. We offer lighting\r\nto fit every need and budget.\r\nHERE IS A LIST OF OUR BEST-SELLING MODELS\r\nCalypso\r\nVery affordable, available in a wide variety of colors and patterns, Calypso is our most economical and versatile\r\nceiling light. Works equally well in offices, retail stores, and home environments. Nor recommended for rooms\r\nexposed to moisture.\r\nTrend\r\nCreate a modern look that will enhance any office setting. This competitively priced metal light is excellent for\r\nconference rooms, office cubicles, or any business where bright lighting is important. Only available in black,\r\ngray, or off-white. Can be directly mounted to the ceiling by professionals or any skilled home owner.\r\nMystic\r\nThis floor lamp is suitable in both homes and offices. It creates a warm atmosphere with its soft light.\r\nModerately priced and available in several colors.\r\nWe recommend that you use energy-efficient lighting. In addition to being inexpensive, energy-efficient lighting\r\nhas several advantages over standard lighting:\r\n* Uses 2/3 less energy\r\n* Generates 70 % less hear\r\n* Lasts up to ten times longer'),
(14, NULL, 'Part 7 - Group 10', 7, NULL, 'Sustainability Magazine\r\nVolume 10, No. 6\r\nJune 2009\r\nManufacturers Going Green\r\nBy Leo Durham\r\nAn increasing number of manufacturing companies around the country are going green, which they\r\nhope will put more green into their cash registers.\r\nThe Manufacturers Extension Partnership (MEP) works with a variety of state and regional industry\r\nassociations and economic development groups to teach companies \"lean\" manufacturing techniques.\r\nThis not-for-profit organization, administered by the Department of Commerce, demonstrates how to\r\nreduce waste, or \"fat,\" in the manufacturing process. This includes things such as cutting energy use,\r\nincorporating more efficient production techniques, and finding cheaper methods of packaging and\r\nshipping goods.\r\nThe result is better not only for the environment, but also for company profits. Last year, MEP helped more than 1,000 firms save about $1.4 billion and increase their sales by $10.5 billion. These actions\r\nled to the creation of nearly 57,000 new jobs.\r\n\"It was tremendous for us,\" said Mark McCartney, general manager of the Clear Water bottled water\r\ncompany. \"MEP showed us how to cut our energy production in half, which led to a 3-percent increase\r\nin sales, and a 100-percent increase in production capacity.\"\r\nMcCartney has been quick to spread the wealth. Last year, a bottle of Clear Water retailed for $1.50.\r\nNow, MEP training has enabled the company to slash the price to $1.20.\r\nYour turn\r\nDear editor:\r\nI enjoyed the article on MEP in the June issue of Sustainability Magazine. When manufacturers pass\r\nsavings onto customers, everybody wins.\r\nOverall, the writer did a fine job. However, there is one mistake in the article I would like to point out.\r\nAfter our company finished training with MEP, sales jumped 30 percent, and our production capacity\r\nincreased by 10 percent.\r\nI would encourage every manufacturer to consider partnering with MEP. There\'s always some fat that\r\ncan be trimmed from the production process.\r\nWilliam Lyons\r\nCEO, Clear Water Bottling'),
(15, NULL, 'Part 7 Group 11', 7, NULL, 'Invoice #0907282\r\nDate: Sept. 15, 2009\r\nFrom: Stanley Supplies\r\n808 Merchant St.\r\nWorcester, NE\r\nTo: Office Corral\r\n912 Ocean Blvd.\r\nCosta Verdes, CA\r\nItem No. Unit cost Comments Total\r\nCases, white 6 $100 10% discount $600\r\nphotocopier\r\npaper\r\nColor ink 50 $15 50 more on $750\r\ncartridges back-order\r\nBlack ink 75 $10 $750\r\ncartridges\r\nCrates,\r\ncomputer chairs 5 $500 Back ordered $2,500\r\nfrom Aug.\r\nBoxes, 100 $5 50 medium, $500\r\nballpoint pens 50 fine point\r\nBoxes,\r\npromotional\r\nbrochures 10 $0 Referral $0\r\nbonus\r\nSub-total: 246 $620 $5,100\r\nShipping: $500\r\nTotal: $6,600\r\nTo: marccar@stansupplies.com\r\nFrom: ivel@officecorral.com\r\nSubject: Invoice no. 0907282\r\nHi Marc,\r\nWe received our Sept. order yesterday. Thank you for your usual prompt shipment. We appreciate the\r\nfast turn-around.\r\nUnfortunately, I noticed a couple of discrepancies between the freight and the invoice. First, the\r\ndiscount for the white photocopier paper does not seem to be factored into the total. We have been\r\nbuying this paper from you at $100 a case, so shouldn\'t six cases with a 10-percent discount come to\r\n$540?\r\nSecond, according to my records we had 10 crates of computer chairs on back order. Are more coming?\r\nIf so, what\'s the soonest you expect they could arrive? Also, could you please give me an idea when\r\nmore color ink cartridges will be available? Our inventory is low, and we are planning to have a special\r\nsale for Halloween.\r\nCould you please get back to me ASAP? I need to clarify these questions before I place our October\r\norder. If you prefer to call, it\'s best to reach me today on my direct line: 556-424-8737.\r\nThanks again Marc,\r\nIda Velasquiz\r\nComptroller, Office Corral'),
(16, NULL, 'Part 7 Group 12', 7, NULL, 'You\'re invited\r\nHoward and Jennifer Jacobson request the honor of your presence on Aug. 10th to celebrate the joining\r\nof their son, Jeffrey Parker Jacobson, and his fiancee, Marilyn Strummers, in holy matrimony.\r\nThe ceremony will take place at 11 a.m. in Riverside Park, 11220 River Dr. NW, followed by a luncheon\r\nreception at the adjacent Green Mansion, then a procession to the airport to see the couple off to their\r\nhoneymoon in Bermuda.\r\nGifts are appreciated but not necessary; the fellowship of family and friends at this special time is\r\nblessing enough. We hope and pray that you will be able to join us for this momentous occasion.\r\nPlease RSVP by July 15th via letter or email to:\r\nGloria Stroust\r\nSuperior Catering\r\n120 Union Ave.\r\ngstroust@fmail.com\r\nJuly 11th, 2009\r\nDear Ms. Stroust,\r\nI am writing in regard to the invitation sent by Howard and Jennifer Jacobson. Please forgive my\r\nrelatively late reply, as I was out of town and did not have a chance to read the invitation until last\r\nweek.\r\nI am thrilled that my friend and former college roommate, Marilyn Strummers, is finally tying the knot.\r\nI am disappointed, however, that I will not be able to attend her milestone event. I had a vacation to\r\nChina scheduled for several weeks prior to hearing Marilyn\'s exciting news, and subsequent efforts to\r\nrearrange my travel plans have proved unsuccessful. Ironically, my flight departs at exactly the same\r\ntime as the ceremony. I\'ll miss Jeff and Marilyn at the airport by only a few hours!\r\nIt is with great regret that I must decline this gracious invitation, though I will contact Marilyn and\r\ncongratulate her personally before I leave. Also, I would like to leave a gift for the newlyweds. Would it\r\nbe appropriate to send a present to you?\r\nPlease let me know.\r\nSincerely,\r\nPatty Pakola\r\n4334 Stone Drive\r\n555-762-0091'),
(17, NULL, 'Part 7 Group 13', 7, 'http://localhost:3000/image/1_IMAGE_11.jpg', 'City Pool - Summer swim schedule\r\nFor more information about any of these programs, call the pool office at 506-807-7667.\r\nFor the latest updates, including schedule changes and special events, call our 24-hour automated information\r\nline at 506-363-8123.\r\nNOTICE\r\nDue to a maintenance problem, City Pool will be closed on Monday and Tuesday next week. The Aqua Jog,\r\nMaster\'s Workout, Hydrofit, and Water Exercise classes on those days have been cancelled, and instructors will\r\nnotify participants when the classes will be rescheduled. We are sorry for the inconvenience, and thank you for\r\nyour patience.\r\nAlso, please note that there will be no public swims on the afternoons of July 14th through 18th, because the\r\npool will be hosting the annual All-City Swimming and Diving Meet. Tickets for the meet are $5 for adults and\r\n$2.50 for children 12 and under, and can be purchased at the pool office or online at www.citypool.com/allcity.\r\nThank you for using City Pool. For up-to-the-minute schedule information, call our info hotline at 506-363-\r\n8123.'),
(18, NULL, 'Part 7 group 14', 7, NULL, 'You\'re invited\r\nPlease join us for an open house to meet our daughter Cathleen\'s first-born, Keegan Schlictmeier and\r\nwelcome him into the world.\r\nWhere: Diane and Ken\'s house -- 23847 47th Pl. W., Bear Creek, WA, 98007.\r\nWhen: 2 p.m. to 4 p.m. Saturday, Dec. 5th.\r\nWhat: Hors devours and drinks will be provided. All you need to bring is yourselves, but if you want to bring\r\na gift, Cathleen has a registry of needs at babies.com and TotToys.\r\nRSVP: Call us at home -- 555-7362 -- or e-mail: dadkinson52@hotmail.com.\r\nWe hope to see you!\r\n* * * *\r\nTo: dadkinson52@hotmail.com\r\nFrom: dragon001@zmail.com\r\nHi Di,\r\nI got your invitation today to the open house for Cathleen and Keegan. I\'m so sorry that I have to miss it!\r\nBrad and I are going skiing in Utah that weekend. We\'ve been planning the trip for months, and it\'s too late\r\nto change even though we wish we could. I\'m dying to meet little Keegan! We\'ll be back on the ninth, and\r\nI\'d like to get together ASAP after that. Would that be OK?\r\nYou must be so proud, grandma! Wow, I never thought I\'d be calling you that so soon. I\'m glad that Cath\r\nhad a smooth delivery, and that Keegan is healthy. Thanks for sending his picture. He\'s a cute little guy.\r\nAnyway, we\'ll check the gift registries you mentioned, and I\'ll look forward to seeing Cath and Keegan\r\nshortly. Hope the open house goes well. I know it takes a lot to plan and host one.\r\nI\'ll e-mail Cathleen separately and say sorry and hi. Please give my love to Ken.\r\nSee you soon,\r\nRobin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `test`
--

CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `test_name` varchar(255) NOT NULL,
  `audio_link` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `test`
--

INSERT INTO `test` (`id`, `test_name`, `audio_link`) VALUES
(1, 'test 1', 'http://localhost:3000/mp3/TEST_1.mp3');

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
-- Chỉ mục cho bảng `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `examinee_answer`
--
ALTER TABLE `examinee_answer`
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
-- Chỉ mục cho bảng `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `achievement`
--
ALTER TABLE `achievement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT cho bảng `answer`
--
ALTER TABLE `answer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=653;

--
-- AUTO_INCREMENT cho bảng `examinee_answer`
--
ALTER TABLE `examinee_answer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=276;

--
-- AUTO_INCREMENT cho bảng `part`
--
ALTER TABLE `part`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=208;

--
-- AUTO_INCREMENT cho bảng `question_group`
--
ALTER TABLE `question_group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `test`
--
ALTER TABLE `test`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
