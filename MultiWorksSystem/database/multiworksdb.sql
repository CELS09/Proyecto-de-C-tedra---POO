-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 23-05-2025 a las 02:22:29
-- Versión del servidor: 9.1.0
-- Versión de PHP: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `multiworksdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividades`
--

DROP TABLE IF EXISTS `actividades`;
CREATE TABLE IF NOT EXISTS `actividades` (
  `idActividad` int NOT NULL AUTO_INCREMENT,
  `tituloActividad` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `trabajadorAsignado` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `areaAsignada` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `costoPorHoraParaEmpleado` double DEFAULT NULL,
  `fechaHoraInicio` datetime DEFAULT NULL,
  `fechaHoraFin` datetime DEFAULT NULL,
  `cantidadHorasAproximadas` int DEFAULT NULL,
  `costoBase` double DEFAULT NULL,
  `incrementoExtra` double DEFAULT NULL,
  `costoTotal` double DEFAULT NULL,
  PRIMARY KEY (`idActividad`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

DROP TABLE IF EXISTS `administrador`;
CREATE TABLE IF NOT EXISTS `administrador` (
  `idAdministrador` int NOT NULL AUTO_INCREMENT,
  `usuarioAdmin` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `contrasenaAdmin` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idAdministrador`),
  UNIQUE KEY `usuarioAdmin` (`usuarioAdmin`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`idAdministrador`, `usuarioAdmin`, `contrasenaAdmin`) VALUES
(1, 'Admin', '$2a$10$EnxM6kZLDFLkZtvQ/7l8AuVqLfSPx8rht5Ue.HUeMtXkNfNw7O0Ge');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaciones`
--

DROP TABLE IF EXISTS `asignaciones`;
CREATE TABLE IF NOT EXISTS `asignaciones` (
  `idAsignacion` int NOT NULL AUTO_INCREMENT,
  `tituloActividad` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `tituloSubTarea` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `descripcionSubTarea` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`idAsignacion`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `documentoIdentificacion` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `contrasena` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `tipoPersona` enum('NATURAL','JURIDICA') COLLATE utf8mb4_general_ci NOT NULL,
  `tipoContratacion` enum('FIJO','TEMPORAL','PROYECTO') COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `correo` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `direccion` varchar(150) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `estado` enum('ACTIVO','INACTIVO') COLLATE utf8mb4_general_ci NOT NULL,
  `creadoPor` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fechaCreacion` date DEFAULT NULL,
  `fechaActualizacion` date DEFAULT NULL,
  `fechaInactivacion` date DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `documentoIdentificacion` (`documentoIdentificacion`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cotizaciones`
--

DROP TABLE IF EXISTS `cotizaciones`;
CREATE TABLE IF NOT EXISTS `cotizaciones` (
  `idCotizacion` int NOT NULL AUTO_INCREMENT,
  `nombreCliente` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `cantidadHorasProyecto` int NOT NULL,
  `fechaTentativaInicio` date NOT NULL,
  `fechaTentativaFin` date NOT NULL,
  `costoAsignaciones` double NOT NULL,
  `costoAdicionales` double DEFAULT '0',
  `total` double NOT NULL,
  PRIMARY KEY (`idCotizacion`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `idEmpleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `documentoIdentificacion` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `contrasena` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `tipoPersona` enum('NATURAL','JURIDICA') COLLATE utf8mb4_general_ci NOT NULL,
  `tipoContratacion` enum('FIJO','TEMPORAL','PROYECTO') COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `correo` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `direccion` varchar(150) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `estado` enum('ACTIVO','INACTIVO') COLLATE utf8mb4_general_ci NOT NULL,
  `creadoPor` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fechaCreacion` date DEFAULT NULL,
  `fechaActualizacion` date DEFAULT NULL,
  `fechaInactivacion` date DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`),
  UNIQUE KEY `documentoIdentificacion` (`documentoIdentificacion`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
