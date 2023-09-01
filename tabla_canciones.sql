-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-09-2023 a las 16:15:46
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_parcial`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_canciones`
--

CREATE TABLE `tabla_canciones` (
  `id` int(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `genero` varchar(30) NOT NULL,
  `duracion` varchar(5) NOT NULL,
  `lanzamiento` varchar(10) NOT NULL,
  `plataforma` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tabla_canciones`
--

INSERT INTO `tabla_canciones` (`id`, `nombre`, `autor`, `genero`, `duracion`, `lanzamiento`, `plataforma`) VALUES
(1, 'Oreste Síndici', 'Himno de colombia', 'Regional', '01:20', '18 de ocru', 'Youtube');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tabla_canciones`
--
ALTER TABLE `tabla_canciones`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
