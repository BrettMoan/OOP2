/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS brettmoa_test;

USE brettmoa_test;

DROP TABLE IF EXISTS brettmoa_test.app_user;

CREATE TABLE  brettmoa_test.app_user (
id int(11) NOT NULL AUTO_INCREMENT,
uname char(20) NOT NULL,
pword char(20) NOT NULL,
PRIMARY KEY (id)
) ENGINE=MyISAM AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE app_user DISABLE KEYS */;

LOCK TABLES app_user WRITE;

INSERT INTO brettmoa_test.app_user VALUES  (37,'sally','somePass'),
(38,'dude','hey2dude');
UNLOCK TABLES;

/*!40000 ALTER TABLE app_user ENABLE KEYS */;

DROP TABLE IF EXISTS brettmoa_test.phone_number;

CREATE TABLE  brettmoa_test.phone_number (
id int(11) NOT NULL AUTO_INCREMENT,
phone varchar(20) NOT NULL,
PRIMARY KEY (id)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE phone_number DISABLE KEYS */;

LOCK TABLES phone_number WRITE;

INSERT INTO brettmoa_test.phone_number VALUES  (1,'(120)345-6789'),
(2,'(208)321-4567'),
(3,'(201)456-0987');

UNLOCK TABLES;

/*!40000 ALTER TABLE phone_number ENABLE KEYS */;

DROP TABLE IF EXISTS brettmoa_test.user_number;

CREATE TABLE  brettmoa_test.user_number (
user_id int(11) NOT NULL,
phone_id int(11) NOT NULL,
id int(11) NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE user_number DISABLE KEYS */;

LOCK TABLES user_number WRITE;

INSERT INTO brettmoa_test.user_number VALUES  (37,1,1),
(38,3,7),
(38,2,8);

UNLOCK TABLES;

/*!40000 ALTER TABLE user_number ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;