-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2023 at 09:39 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `capstonepersonalassignment`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `CartID` int(11) NOT NULL,
  `ItemID` int(11) NOT NULL,
  `totalPrice` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ingredient`
--

CREATE TABLE `ingredient` (
  `ingredientID` int(11) NOT NULL,
  `name` varchar(64) NOT NULL,
  `price` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ingredient`
--

INSERT INTO `ingredient` (`ingredientID`, `name`, `price`) VALUES
(1, 'Olives', '0.90'),
(2, 'Lettuce', '0.80'),
(3, 'Ranch', '0.50'),
(4, 'Tortilla', '1.50'),
(5, 'Meat', '1.20'),
(6, 'Sour Cream', '1.00'),
(7, 'Hard Shell', '2.00'),
(8, 'Cheese', '0.50'),
(9, 'Pound Of Meat', '4.00'),
(10, 'fajita Peppers', '1.50'),
(24, 'Swiss Chesse', '1.00');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `itemID` int(11) NOT NULL,
  `name` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`itemID`, `name`) VALUES
(17, 'Taco Salad'),
(18, 'Taco'),
(19, 'Taco'),
(20, 'Soft Taco'),
(38, 'dds'),
(39, 'Bob special');

-- --------------------------------------------------------

--
-- Table structure for table `itemingred`
--

CREATE TABLE `itemingred` (
  `itemID` int(11) NOT NULL,
  `ingredientID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `itemingred`
--

INSERT INTO `itemingred` (`itemID`, `ingredientID`) VALUES
(17, 1),
(17, 2),
(17, 3),
(17, 4),
(17, 5),
(18, 3),
(18, 4),
(18, 5),
(19, 5),
(19, 7),
(19, 5),
(19, 8),
(19, 7),
(19, 5),
(20, 8),
(20, 7),
(20, 5),
(20, 2),
(0, 12),
(0, 11),
(0, 12),
(0, 24),
(0, 8),
(0, 7),
(0, 6),
(0, 5),
(0, 4),
(0, 3),
(0, 2),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 2),
(0, 2),
(0, 4),
(0, 9),
(0, 8),
(0, 8),
(0, 7),
(0, 7),
(0, 3),
(0, 7),
(0, 8),
(0, 7),
(0, 10),
(0, 10),
(0, 8),
(0, 7),
(0, 24),
(0, 24),
(0, 8),
(0, 8),
(0, 8),
(0, 10),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 7),
(0, 9),
(0, 24),
(0, 9),
(0, 8),
(0, 1),
(0, 8),
(0, 9),
(0, 10),
(0, 10),
(0, 3),
(0, 3),
(0, 4),
(0, 10),
(0, 9),
(0, 8),
(0, 7),
(0, 6),
(38, 9),
(38, 8),
(38, 7),
(39, 9);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` int(11) NOT NULL,
  `firstName` varchar(64) NOT NULL,
  `lastName` varchar(64) NOT NULL,
  `userName` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `firstName`, `lastName`, `userName`, `email`, `password`) VALUES
(5, '12', '12', '12', '12', '12'),
(6, '23', '23', '23', '232', '23'),
(7, 'Ryan', 'Zimmermann', 'RyanTheCool', 'ryan@gmail.com', 'BobRoss2000'),
(8, 'Ryan', 'Zimmermann', 'RyanTheCool', 'ryan@gmail.com', 'BobRoss2000'),
(9, 'Ryan', 'Zimmermann', 'RyanTheCool', 'ryan@gmail.com', 'BobRoss2000'),
(10, '34', '24', '34', '34', '34');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`ingredientID`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `ingredientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `itemID` int(64) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
