-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.5.4-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para minha_casa_tech
CREATE DATABASE IF NOT EXISTS `minha_casa_tech` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `minha_casa_tech`;

-- Copiando estrutura para tabela minha_casa_tech.caixa
CREATE TABLE IF NOT EXISTS `caixa` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `valor` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela minha_casa_tech.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cpf` varchar(18) NOT NULL,
  `id_pessoa` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_fk` (`id_pessoa`),
  CONSTRAINT `cliente_fk` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela minha_casa_tech.compra
CREATE TABLE IF NOT EXISTS `compra` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_transacao` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `compra_fk` (`id_transacao`),
  CONSTRAINT `compra_fk` FOREIGN KEY (`id_transacao`) REFERENCES `transacao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela minha_casa_tech.equipamento
CREATE TABLE IF NOT EXISTS `equipamento` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `peso` double NOT NULL,
  `preco` double NOT NULL,
  `quantidade` int(11) NOT NULL,
  `numero_de_serie` varchar(100) NOT NULL,
  `id_local` bigint(20) unsigned NOT NULL,
  `id_responsavel` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `equipamento_fk` (`id_local`),
  KEY `equipamento_fk_1` (`id_responsavel`),
  CONSTRAINT `equipamento_fk` FOREIGN KEY (`id_local`) REFERENCES `local` (`id`),
  CONSTRAINT `equipamento_fk_1` FOREIGN KEY (`id_responsavel`) REFERENCES `responsavel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela minha_casa_tech.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_responsavel` bigint(20) unsigned NOT NULL,
  `id_pessoa` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `funcionario_fk` (`id_responsavel`),
  KEY `funcionario_fk_1` (`id_pessoa`),
  CONSTRAINT `funcionario_fk` FOREIGN KEY (`id_responsavel`) REFERENCES `responsavel` (`id`),
  CONSTRAINT `funcionario_fk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela minha_casa_tech.local
CREATE TABLE IF NOT EXISTS `local` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `casa` varchar(100) NOT NULL,
  `compartimento` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela minha_casa_tech.pessoa
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela minha_casa_tech.proprietario
CREATE TABLE IF NOT EXISTS `proprietario` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_responsavel` bigint(20) unsigned NOT NULL,
  `id_pessoa` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `proprietario_fk` (`id_responsavel`),
  KEY `proprietario_fk_1` (`id_pessoa`),
  CONSTRAINT `proprietario_fk` FOREIGN KEY (`id_responsavel`) REFERENCES `responsavel` (`id`),
  CONSTRAINT `proprietario_fk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela minha_casa_tech.responsavel
CREATE TABLE IF NOT EXISTS `responsavel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `id_pessoa` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `responsavel_fk` (`id_pessoa`),
  CONSTRAINT `responsavel_fk` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela minha_casa_tech.transacao
CREATE TABLE IF NOT EXISTS `transacao` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `valor_total` double NOT NULL,
  `peso_total` double NOT NULL,
  `total_equip` int(11) NOT NULL,
  `data` date NOT NULL,
  `tipo` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela minha_casa_tech.transacao_equipamentos
CREATE TABLE IF NOT EXISTS `transacao_equipamentos` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_transacao` bigint(20) unsigned NOT NULL,
  `id_equipamento` bigint(20) unsigned NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `transacao_equipamentos_fk` (`id_transacao`),
  KEY `transacao_equipamentos_fk_1` (`id_equipamento`),
  CONSTRAINT `transacao_equipamentos_fk` FOREIGN KEY (`id_transacao`) REFERENCES `transacao` (`id`),
  CONSTRAINT `transacao_equipamentos_fk_1` FOREIGN KEY (`id_equipamento`) REFERENCES `equipamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela minha_casa_tech.venda
CREATE TABLE IF NOT EXISTS `venda` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_cliente` bigint(20) unsigned NOT NULL,
  `id_transacao` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `venda_fk` (`id_cliente`),
  KEY `venda_fk_1` (`id_transacao`),
  CONSTRAINT `venda_fk` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `venda_fk_1` FOREIGN KEY (`id_transacao`) REFERENCES `transacao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
