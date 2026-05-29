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

-- Volcando estructura para tabla buscaminas.cosmeticos
CREATE TABLE IF NOT EXISTS `cosmeticos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `estilo` varchar(100) DEFAULT NULL,
  `imagen_url` varchar(255) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio_puntos` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla buscaminas.logros
CREATE TABLE IF NOT EXISTS `logros` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `puntos` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla buscaminas.partidas
CREATE TABLE IF NOT EXISTS `partidas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dificultad` enum('DIFICIL','FACIL','NORMAL') NOT NULL,
  `fecha_partida` datetime(6) DEFAULT NULL,
  `minas_restantes` int(11) NOT NULL,
  `numero_minas` int(11) NOT NULL,
  `tiempo` int(11) NOT NULL,
  `jugador_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKim3ksy7ukis8sjhygl1mytn3d` (`jugador_id`),
  CONSTRAINT `FKim3ksy7ukis8sjhygl1mytn3d` FOREIGN KEY (`jugador_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla buscaminas.usuario_cosmeticos
CREATE TABLE IF NOT EXISTS `usuario_cosmeticos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `equipado` bit(1) NOT NULL,
  `cosmetico_id` bigint(20) NOT NULL,
  `jugador_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhgmbduv1o267onge2psxphtsn` (`cosmetico_id`),
  KEY `FKkscui4nr87rok9cmepuvnrakc` (`jugador_id`),
  CONSTRAINT `FKhgmbduv1o267onge2psxphtsn` FOREIGN KEY (`cosmetico_id`) REFERENCES `cosmeticos` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKkscui4nr87rok9cmepuvnrakc` FOREIGN KEY (`jugador_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla buscaminas.usuario_logros
CREATE TABLE IF NOT EXISTS `usuario_logros` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `jugador_id` bigint(20) NOT NULL,
  `logro_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlo2nbj8vb7y1qqqqmxsqdr6a3` (`jugador_id`),
  KEY `FKe9atm8496glld8c6x2nwro96n` (`logro_id`),
  CONSTRAINT `FKe9atm8496glld8c6x2nwro96n` FOREIGN KEY (`logro_id`) REFERENCES `logros` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKlo2nbj8vb7y1qqqqmxsqdr6a3` FOREIGN KEY (`jugador_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla buscaminas.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `puntos_logro` int(11) NOT NULL,
  `ultimo_acceso` datetime(6) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkfsp0s1tflm1cwlj8idhqsad0` (`email`),
  UNIQUE KEY `UKm2dvbwfge291euvmk6vkkocao` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
