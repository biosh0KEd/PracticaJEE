-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2019 a las 04:55:48
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `alanlegacy`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `IdCategoria` int(11) NOT NULL,
  `NombreCat` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`IdCategoria`, `NombreCat`) VALUES
(1, 'Página Web'),
(2, 'Aplicación Móvil'),
(3, 'Página Web Progresiva'),
(4, 'Juegos'),
(5, 'Aplicación de Escritorio'),
(6, 'Múltiples Tecnologías'),
(7, 'Otros');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `IdProyecto` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Descripcion` varchar(240) NOT NULL,
  `Objetivos` longtext NOT NULL,
  `Fecha` date NOT NULL,
  `EnlaceReq` varchar(100) NOT NULL,
  `EnlaceRepT` varchar(100) NOT NULL,
  `EnlaceCF` varchar(100) NOT NULL,
  `EnlaceInst` varchar(100) NOT NULL,
  `Estado` varchar(4) NOT NULL,
  `IdCategoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`IdProyecto`, `Nombre`, `Descripcion`, `Objetivos`, `Fecha`, `EnlaceReq`, `EnlaceRepT`, `EnlaceCF`, `EnlaceInst`, `Estado`, `IdCategoria`) VALUES
(1, 'GoGDL', 'DESC', 'OBJETIVO\r\nQWE\r\nWQE\r\nQWE', '2019-06-19', 'ASD', 'EWR', 'WQRQ', 'WEA', 'EXIT', 4),
(2, 'TrendyReads', 'desc1', 'object', '2019-06-02', '1', '2', '3', '4', '5', 2),
(3, 'yoyopo', 'desc1', 'object', '2019-06-02', '1', '2', '3', '4', '5', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `IdUser` int(11) NOT NULL,
  `LimiteDeProyectos` tinyint(1) NOT NULL,
  `Usuario` varchar(30) NOT NULL,
  `Contrasena` varchar(40) NOT NULL,
  `TipoDeUsuario` tinyint(1) NOT NULL,
  `Autorizacion` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`IdUser`, `LimiteDeProyectos`, `Usuario`, `Contrasena`, `TipoDeUsuario`, `Autorizacion`) VALUES
(1, 0, 'apu', '123', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `userproyecto`
--

CREATE TABLE `userproyecto` (
  `IdUserProyecto` int(11) NOT NULL,
  `IdUser` int(11) NOT NULL,
  `IdProyecto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `userproyecto`
--

INSERT INTO `userproyecto` (`IdUserProyecto`, `IdUser`, `IdProyecto`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`IdCategoria`);

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`IdProyecto`),
  ADD KEY `Categoria` (`IdCategoria`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`IdUser`);

--
-- Indices de la tabla `userproyecto`
--
ALTER TABLE `userproyecto`
  ADD PRIMARY KEY (`IdUserProyecto`),
  ADD KEY `User` (`IdUser`),
  ADD KEY `Proyecto` (`IdProyecto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `IdCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `IdProyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `IdUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `userproyecto`
--
ALTER TABLE `userproyecto`
  MODIFY `IdUserProyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD CONSTRAINT `Categoria` FOREIGN KEY (`IdCategoria`) REFERENCES `categoria` (`IdCategoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `userproyecto`
--
ALTER TABLE `userproyecto`
  ADD CONSTRAINT `Proyecto` FOREIGN KEY (`IdProyecto`) REFERENCES `proyecto` (`IdProyecto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `User` FOREIGN KEY (`IdUser`) REFERENCES `user` (`IdUser`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
