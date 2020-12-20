-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-12-2020 a las 01:07:44
-- Versión del servidor: 10.4.16-MariaDB
-- Versión de PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `m6_uf2_act1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnes`
--

CREATE TABLE `alumnes` (
  `Nom` varchar(30) NOT NULL,
  `Dni` varchar(9) NOT NULL,
  `Naixement` date NOT NULL,
  `Apostal` varchar(20) NOT NULL,
  `Sexe` varchar(2) NOT NULL,
  `Cpostal` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnes`
--

INSERT INTO `alumnes` (`Nom`, `Dni`, `Naixement`, `Apostal`, `Sexe`, `Cpostal`) VALUES
('Ian', '09876543E', '2001-12-10', 'C', 'h', 12345),
('Jesus', '12345678R', '2001-07-14', 'Costa', 'H', 43205),
('Marc', '39936948R', '2001-11-11', 'Costa', 'H', 43205);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `poblacions`
--

CREATE TABLE `poblacions` (
  `Cpostal` int(5) NOT NULL,
  `Poblacio` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `poblacions`
--

INSERT INTO `poblacions` (`Cpostal`, `Poblacio`) VALUES
(12345, 'Reus'),
(43205, 'Tarragona');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnes`
--
ALTER TABLE `alumnes`
  ADD PRIMARY KEY (`Dni`),
  ADD KEY `Cpostal` (`Cpostal`);

--
-- Indices de la tabla `poblacions`
--
ALTER TABLE `poblacions`
  ADD PRIMARY KEY (`Cpostal`),
  ADD KEY `Cpostal` (`Cpostal`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnes`
--
ALTER TABLE `alumnes`
  ADD CONSTRAINT `alumnes_ibfk_1` FOREIGN KEY (`Cpostal`) REFERENCES `poblacions` (`Cpostal`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
