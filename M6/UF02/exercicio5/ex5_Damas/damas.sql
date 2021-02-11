-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-01-2021 a las 20:50:39
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
-- Base de datos: `damas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `idMoviment` int(11) NOT NULL,
  `columnaOrigen` int(11) NOT NULL,
  `columnaDesti` int(11) NOT NULL,
  `filaOrigen` int(11) NOT NULL,
  `filaDesti` int(11) NOT NULL,
  `idPartida` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`idMoviment`, `columnaOrigen`, `columnaDesti`, `filaOrigen`, `filaDesti`, `idPartida`) VALUES
(43, -1, 4, -1, 4, 13),
(44, -1, 3, -1, 3, 13),
(45, -1, 5, -1, 3, 13),
(46, -1, 4, -1, 2, 13),
(47, -1, 6, -1, 2, 13),
(48, -1, 5, -1, 1, 13),
(49, -1, 7, -1, 1, 13),
(50, -1, 6, -1, 2, 13),
(51, -1, 6, -1, 0, 13),
(52, -1, 4, -1, 4, 14),
(53, -1, 3, -1, 3, 14),
(54, -1, 5, -1, 3, 14),
(55, -1, 4, -1, 2, 14),
(56, -1, 6, -1, 2, 14),
(57, -1, 5, -1, 1, 14),
(58, -1, 7, -1, 1, 14),
(59, -1, 6, -1, 2, 14),
(60, -1, 6, -1, 0, 14),
(61, 3, 4, 5, 4, 15),
(62, 4, 3, 2, 3, 15),
(63, 4, 5, 4, 3, 15),
(64, 6, 7, 2, 3, 15),
(65, 5, 6, 3, 2, 15),
(66, 5, 4, 1, 2, 15),
(67, 6, 7, 2, 1, 15),
(68, 6, 5, 0, 1, 15),
(69, 7, 6, 1, 0, 15),
(70, 3, 4, 5, 4, 17),
(71, 4, 3, 2, 3, 17),
(72, 4, 5, 4, 3, 17),
(73, 6, 7, 2, 3, 17),
(74, 5, 6, 3, 2, 17),
(75, 5, 4, 1, 2, 17),
(76, 6, 5, 2, 1, 17),
(77, 7, 6, 1, 2, 17),
(78, 5, 6, 1, 0, 17),
(79, 3, 2, 5, 4, 18),
(80, 2, 1, 2, 3, 18),
(81, 2, 3, 4, 3, 18),
(82, 3, 2, 1, 2, 18),
(83, 3, 4, 3, 2, 18),
(84, 2, 3, 2, 3, 18),
(85, 4, 3, 2, 1, 18),
(86, 5, 4, 1, 2, 18),
(87, 3, 4, 1, 0, 18),
(88, 3, 4, 5, 4, 19),
(89, 4, 3, 2, 3, 19),
(90, 4, 5, 4, 3, 19),
(91, 6, 7, 2, 3, 19),
(92, 5, 6, 3, 2, 19),
(93, 5, 4, 1, 2, 19),
(94, 4, 3, 6, 5, 19),
(95, 3, 2, 3, 4, 19),
(96, 1, 0, 5, 4, 19),
(97, 4, 3, 2, 3, 19),
(98, 6, 7, 2, 1, 19),
(99, 4, 5, 0, 1, 19),
(100, 7, 6, 1, 0, 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `idPartida` int(11) NOT NULL,
  `ganador` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `partida`
--

INSERT INTO `partida` (`idPartida`, `ganador`) VALUES
(13, 'X'),
(14, 'X'),
(15, 'X'),
(16, 'VS'),
(17, 'X'),
(18, 'X'),
(19, 'X');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`idMoviment`),
  ADD KEY `idPartida` (`idPartida`);

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`idPartida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `idMoviment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `idPartida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `movimiento_ibfk_1` FOREIGN KEY (`idPartida`) REFERENCES `partida` (`idPartida`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
