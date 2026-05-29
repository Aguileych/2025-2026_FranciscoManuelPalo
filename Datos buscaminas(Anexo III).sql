-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         12.2.2-MariaDB - MariaDB Server
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.14.0.7165
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando datos para la tabla buscaminas.cosmeticos: ~2 rows (aproximadamente)
INSERT INTO `cosmeticos` (`id`, `estilo`, `imagen_url`, `nombre`, `precio_puntos`) VALUES
	(2, 'theme-hacker.css', './img/cosmeticos/hacker.png', 'Tema hacker', 150),
	(3, 'theme-pirate.css', './img/cosmeticos/pirate.png', 'Tema pirata', 200);

-- Volcando datos para la tabla buscaminas.logros: ~6 rows (aproximadamente)
INSERT INTO `logros` (`id`, `descripcion`, `nombre`, `puntos`) VALUES
	(10, 'logros.incauto.desc', 'incauto', 10),
	(11, 'logros.principiante.desc', 'principiante', 50),
	(12, 'logros.normalidad.desc', 'normalidad', 100),
	(13, 'logros.experto.desc', 'experto', 150),
	(14, 'logros.velocista.desc', 'velocista', 150),
	(15, 'logros.temerario.desc', 'temerario', 150);

-- Volcando datos para la tabla buscaminas.partidas: ~100 rows (aproximadamente)
INSERT INTO `partidas` (`id`, `dificultad`, `fecha_partida`, `minas_restantes`, `numero_minas`, `tiempo`, `jugador_id`) VALUES
	(1, 'FACIL', '2025-03-01 10:00:00.000000', 0, 10, 45, 1),
	(2, 'FACIL', '2025-03-05 11:15:00.000000', 2, 10, 38, 1),
	(3, 'NORMAL', '2025-03-10 14:30:00.000000', 5, 40, 120, 1),
	(4, 'NORMAL', '2025-03-15 16:00:00.000000', 0, 40, 98, 1),
	(5, 'DIFICIL', '2025-03-20 18:45:00.000000', 20, 99, 300, 1),
	(6, 'FACIL', '2025-04-01 09:00:00.000000', 1, 10, 52, 1),
	(7, 'NORMAL', '2025-04-08 13:00:00.000000', 8, 40, 145, 1),
	(8, 'DIFICIL', '2025-04-15 20:00:00.000000', 10, 99, 275, 1),
	(9, 'NORMAL', '2025-04-22 17:30:00.000000', 0, 40, 110, 1),
	(10, 'DIFICIL', '2025-05-01 21:00:00.000000', 0, 99, 330, 1),
	(11, 'FACIL', '2025-03-02 10:00:00.000000', 0, 10, 30, 2),
	(12, 'FACIL', '2025-03-06 12:00:00.000000', 3, 10, 25, 2),
	(13, 'FACIL', '2025-03-11 09:30:00.000000', 0, 10, 28, 2),
	(14, 'NORMAL', '2025-03-16 14:00:00.000000', 12, 40, 180, 2),
	(15, 'NORMAL', '2025-03-21 16:30:00.000000', 6, 40, 155, 2),
	(16, 'FACIL', '2025-04-02 10:00:00.000000', 0, 10, 22, 2),
	(17, 'NORMAL', '2025-04-09 11:00:00.000000', 0, 40, 130, 2),
	(18, 'NORMAL', '2025-04-16 15:00:00.000000', 3, 40, 142, 2),
	(19, 'DIFICIL', '2025-04-23 19:00:00.000000', 30, 99, 400, 2),
	(20, 'DIFICIL', '2025-05-02 20:30:00.000000', 15, 99, 360, 2),
	(21, 'DIFICIL', '2025-03-03 08:00:00.000000', 0, 99, 180, 3),
	(22, 'DIFICIL', '2025-03-07 09:00:00.000000', 0, 99, 165, 3),
	(23, 'DIFICIL', '2025-03-12 10:00:00.000000', 0, 99, 172, 3),
	(24, 'DIFICIL', '2025-03-17 11:00:00.000000', 0, 99, 158, 3),
	(25, 'DIFICIL', '2025-03-22 12:00:00.000000', 0, 99, 190, 3),
	(26, 'DIFICIL', '2025-04-03 08:30:00.000000', 0, 99, 161, 3),
	(27, 'DIFICIL', '2025-04-10 09:30:00.000000', 0, 99, 155, 3),
	(28, 'NORMAL', '2025-04-17 10:30:00.000000', 0, 40, 75, 3),
	(29, 'DIFICIL', '2025-04-24 08:00:00.000000', 0, 99, 148, 3),
	(30, 'DIFICIL', '2025-05-03 07:45:00.000000', 0, 99, 140, 3),
	(31, 'FACIL', '2025-03-04 10:00:00.000000', 4, 10, 60, 4),
	(32, 'FACIL', '2025-03-08 11:30:00.000000', 0, 10, 48, 4),
	(33, 'NORMAL', '2025-03-13 14:00:00.000000', 10, 40, 200, 4),
	(34, 'FACIL', '2025-03-18 15:00:00.000000', 2, 10, 55, 4),
	(35, 'NORMAL', '2025-03-23 17:00:00.000000', 4, 40, 175, 4),
	(36, 'NORMAL', '2025-04-04 10:00:00.000000', 0, 40, 160, 4),
	(37, 'DIFICIL', '2025-04-11 14:00:00.000000', 25, 99, 420, 4),
	(38, 'FACIL', '2025-04-18 09:00:00.000000', 0, 10, 42, 4),
	(39, 'NORMAL', '2025-04-25 16:00:00.000000', 7, 40, 190, 4),
	(40, 'DIFICIL', '2025-05-04 20:00:00.000000', 18, 99, 380, 4),
	(41, 'NORMAL', '2025-03-05 10:00:00.000000', 15, 40, 220, 5),
	(42, 'NORMAL', '2025-03-09 12:00:00.000000', 8, 40, 195, 5),
	(43, 'DIFICIL', '2025-03-14 15:00:00.000000', 40, 99, 500, 5),
	(44, 'FACIL', '2025-03-19 09:00:00.000000', 0, 10, 35, 5),
	(45, 'NORMAL', '2025-03-24 14:00:00.000000', 2, 40, 165, 5),
	(46, 'FACIL', '2025-04-05 11:00:00.000000', 1, 10, 40, 5),
	(47, 'NORMAL', '2025-04-12 13:00:00.000000', 0, 40, 150, 5),
	(48, 'DIFICIL', '2025-04-19 18:00:00.000000', 22, 99, 440, 5),
	(49, 'FACIL', '2025-04-26 10:00:00.000000', 0, 10, 32, 5),
	(50, 'NORMAL', '2025-05-05 15:00:00.000000', 5, 40, 178, 5),
	(51, 'FACIL', '2025-03-06 09:00:00.000000', 0, 10, 27, 6),
	(52, 'FACIL', '2025-03-10 10:00:00.000000', 0, 10, 31, 6),
	(53, 'FACIL', '2025-03-15 11:00:00.000000', 1, 10, 36, 6),
	(54, 'NORMAL', '2025-03-20 14:00:00.000000', 18, 40, 240, 6),
	(55, 'FACIL', '2025-03-25 09:30:00.000000', 0, 10, 29, 6),
	(56, 'NORMAL', '2025-04-06 12:00:00.000000', 9, 40, 210, 6),
	(57, 'FACIL', '2025-04-13 10:00:00.000000', 0, 10, 24, 6),
	(58, 'NORMAL', '2025-04-20 14:30:00.000000', 0, 40, 185, 6),
	(59, 'DIFICIL', '2025-04-27 19:00:00.000000', 35, 99, 460, 6),
	(60, 'NORMAL', '2025-05-06 16:00:00.000000', 4, 40, 168, 6),
	(61, 'DIFICIL', '2025-03-07 08:00:00.000000', 12, 99, 350, 7),
	(62, 'NORMAL', '2025-03-11 10:30:00.000000', 0, 40, 125, 7),
	(63, 'DIFICIL', '2025-03-16 13:00:00.000000', 5, 99, 290, 7),
	(64, 'NORMAL', '2025-03-21 15:00:00.000000', 3, 40, 140, 7),
	(65, 'DIFICIL', '2025-03-26 18:00:00.000000', 0, 99, 260, 7),
	(66, 'NORMAL', '2025-04-07 09:00:00.000000', 0, 40, 118, 7),
	(67, 'DIFICIL', '2025-04-14 11:00:00.000000', 8, 99, 310, 7),
	(68, 'FACIL', '2025-04-21 08:30:00.000000', 0, 10, 20, 7),
	(69, 'DIFICIL', '2025-04-28 20:00:00.000000', 0, 99, 245, 7),
	(70, 'NORMAL', '2025-05-07 14:00:00.000000', 1, 40, 132, 7),
	(71, 'FACIL', '2025-03-08 10:00:00.000000', 5, 10, 70, 8),
	(72, 'FACIL', '2025-03-12 11:00:00.000000', 3, 10, 65, 8),
	(73, 'FACIL', '2025-03-17 09:30:00.000000', 0, 10, 50, 8),
	(74, 'NORMAL', '2025-03-22 14:00:00.000000', 20, 40, 260, 8),
	(75, 'FACIL', '2025-03-27 10:00:00.000000', 2, 10, 58, 8),
	(76, 'FACIL', '2025-04-08 09:00:00.000000', 0, 10, 44, 8),
	(77, 'NORMAL', '2025-04-15 13:00:00.000000', 14, 40, 230, 8),
	(78, 'NORMAL', '2025-04-22 15:30:00.000000', 6, 40, 200, 8),
	(79, 'DIFICIL', '2025-04-29 19:30:00.000000', 45, 99, 520, 8),
	(80, 'NORMAL', '2025-05-08 16:00:00.000000', 0, 40, 175, 8),
	(81, 'NORMAL', '2025-03-09 08:00:00.000000', 0, 40, 95, 9),
	(82, 'DIFICIL', '2025-03-13 10:00:00.000000', 3, 99, 230, 9),
	(83, 'NORMAL', '2025-03-18 12:00:00.000000', 0, 40, 88, 9),
	(84, 'DIFICIL', '2025-03-23 14:00:00.000000', 0, 99, 210, 9),
	(85, 'NORMAL', '2025-03-28 16:00:00.000000', 1, 40, 102, 9),
	(86, 'DIFICIL', '2025-04-09 09:00:00.000000', 0, 99, 198, 9),
	(87, 'NORMAL', '2025-04-16 10:00:00.000000', 0, 40, 91, 9),
	(88, 'DIFICIL', '2025-04-23 11:00:00.000000', 2, 99, 220, 9),
	(89, 'FACIL', '2025-04-30 08:00:00.000000', 0, 10, 18, 9),
	(90, 'DIFICIL', '2025-05-09 07:30:00.000000', 0, 99, 195, 9),
	(91, 'FACIL', '2025-03-10 10:00:00.000000', 6, 10, 80, 10),
	(92, 'FACIL', '2025-03-14 11:00:00.000000', 4, 10, 72, 10),
	(93, 'NORMAL', '2025-03-19 14:00:00.000000', 22, 40, 280, 10),
	(94, 'FACIL', '2025-03-24 09:00:00.000000', 1, 10, 66, 10),
	(95, 'FACIL', '2025-03-29 10:30:00.000000', 0, 10, 54, 10),
	(96, 'NORMAL', '2025-04-10 12:00:00.000000', 11, 40, 250, 10),
	(97, 'FACIL', '2025-04-17 09:00:00.000000', 0, 10, 46, 10),
	(98, 'NORMAL', '2025-04-24 14:00:00.000000', 5, 40, 215, 10),
	(99, 'DIFICIL', '2025-05-01 18:00:00.000000', 50, 99, 540, 10),
	(100, 'NORMAL', '2025-05-10 15:00:00.000000', 0, 40, 188, 10);

-- Volcando datos para la tabla buscaminas.usuario_cosmeticos: ~4 rows (aproximadamente)
INSERT INTO `usuario_cosmeticos` (`id`, `equipado`, `cosmetico_id`, `jugador_id`) VALUES
	(1, b'0', 2, 3),
	(2, b'1', 3, 3),
	(3, b'1', 2, 7),
	(4, b'1', 2, 9);

-- Volcando datos para la tabla buscaminas.usuario_logros: ~21 rows (aproximadamente)
INSERT INTO `usuario_logros` (`id`, `jugador_id`, `logro_id`) VALUES
	(1, 1, 10),
	(2, 1, 11),
	(3, 2, 10),
	(4, 2, 11),
	(5, 2, 12),
	(6, 3, 10),
	(7, 3, 11),
	(8, 3, 12),
	(9, 3, 13),
	(10, 3, 14),
	(11, 3, 15),
	(12, 4, 10),
	(13, 5, 10),
	(14, 5, 12),
	(15, 6, 10),
	(16, 6, 11),
	(17, 7, 12),
	(18, 7, 13),
	(19, 9, 13),
	(20, 9, 14),
	(21, 9, 15);

-- Volcando datos para la tabla buscaminas.usuarios: ~10 rows (aproximadamente)
INSERT INTO `usuarios` (`id`, `created_at`, `email`, `password_hash`, `puntos_logro`, `ultimo_acceso`, `username`) VALUES
	(1, '2024-11-01 09:15:00.000000', 'alejandro.garcia@gmail.com', '$2a$10$jTIdi13GQpJHYDl9pmUgs.ued94OM/lp6useBImet1ShmsuxAYFyi', 0, '2025-05-10 18:30:00.000000', 'AlejandroG'),
	(2, '2024-11-15 14:20:00.000000', 'maria.lopez@hotmail.com', '$2a$10$qNpNAzyVjDWn2U4OmMaspOGY8Rrus/CwKsn3M3fo.YRtUPUMMkE2G', 0, '2025-05-18 21:00:00.000000', 'MariaL'),
	(3, '2024-10-05 08:00:00.000000', 'carlos.reyes@gmail.com', '$2a$10$CWtAbNxKpsi5fysRxHrRXuWx84CBtQ0MGauP0MgyXgCZlO0k7A7Xa', 1000, '2025-05-28 10:45:00.000000', 'CarlosRey'),
	(4, '2024-12-01 17:30:00.000000', 'lucia.fernandez@yahoo.com', '$2a$10$mS0BFA05TLJoZjV.ibuD0.ouXcXY/n2gVcc4Ejgtda0QNCwvHX78m', 0, '2025-05-20 16:15:00.000000', 'LuciaFdez'),
	(5, '2025-01-10 11:00:00.000000', 'pablo.martin@gmail.com', '$2a$10$nXzYbT0xoe2ck1UdJZRxoOFM1bnx8IfxHNesRzfm040SmiqgpfUY6', 0, '2025-05-25 09:30:00.000000', 'PabloM'),
	(6, '2025-01-22 13:45:00.000000', 'sofia.ruiz@outlook.com', '$2a$10$mWLpndBNi91B6KtaI5wNWeHEKZuwNbQvIrvBUjjkhFaD38igSaAzi', 0, '2025-05-27 20:00:00.000000', 'SofiaRuiz'),
	(7, '2025-02-03 10:10:00.000000', 'david.sanchez@gmail.com', '$2a$10$SIO2W/RFeEZJdYdJNAh.lu6hiE.tyCBcm2NXzAvzvPYdKQs.X91s6', 0, '2025-05-22 14:50:00.000000', 'DavidS'),
	(8, '2025-02-18 16:00:00.000000', 'elena.torres@hotmail.com', '$2a$10$wGobtU5txB5ioseE8jlUQevYEx9eU995THjg/5OoN1jOUDDYxCPM.', 0, '2025-05-15 11:20:00.000000', 'ElenaTorres'),
	(9, '2025-03-05 09:30:00.000000', 'miguel.diaz@gmail.com', '$2a$10$5Ei1MleL5joakyfR/xwhjeXd/S/uMbQfy2dG/r3SHCy7hcQyn8ng.', 0, '2025-05-29 08:00:00.000000', 'MiguelDiaz'),
	(10, '2025-03-20 12:00:00.000000', 'ana.jimenez@yahoo.com', '$2a$10$V3RxF5RKzzVbKN05Sa3eredkbcV0hOEXVU3MyZv60JcRGn8f5KI4C', 0, '2025-05-26 19:45:00.000000', 'AnaJimenez');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
