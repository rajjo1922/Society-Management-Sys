-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.30-community


/* !40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/* !40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/* !40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/* !40101 SET NAMES utf8 */;

/* !40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/* !40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/* !40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema gangakunj_app
--

CREATE DATABASE IF NOT EXISTS gangakunj_app;
USE gangakunj_app;
show tables;
select * from users;
--
-- Definition of table 'complaints'
--

DROP TABLE IF EXISTS complaints;
CREATE TABLE complaints (
    complaint_id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    person_name   varchar(45) NOT NULL,
    wing   varchar(45) NOT NULL,
    flat_no   int(10) unsigned NOT NULL,
    raised_date   varchar(45) NOT NULL,
    description   varchar(255) NOT NULL,
    status   varchar(45) NOT NULL,
  PRIMARY KEY (complaint_id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table 'complaints'
--

/* !40000 ALTER TABLE complaints' DISABLE KEYS */;

INSERT INTO complaints (complaint_id,person_name,wing,flat_no,raised_date,description,status) VALUES 
 (1,'reena bade','a',102,'2021-04-14','nalala pani yet nahi','Solved'),
 (2,'vishal','g',111,'2021-06-19','nal futal','Solved');
/* !40000 ALTER TABLE 'complaints' ENABLE KEYS */;


--
-- Definition of table 'expenses'
--

DROP TABLE IF EXISTS expenses;
CREATE TABLE expenses (
    expense_id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    purpose   varchar(45) NOT NULL,
    wing_id   int(10) unsigned NOT NULL,
    flat_id   int(10) unsigned NOT NULL,
    done_by   varchar(45) NOT NULL,
    client_name   varchar(45) NOT NULL,
    date   varchar(45) NOT NULL,
    expense_amount   int(10) unsigned NOT NULL,
  PRIMARY KEY (  expense_id  )
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table   expenses  
--

/* !40000 ALTER TABLE   expenses   DISABLE KEYS */;
INSERT INTO   expenses   (  expense_id  ,  purpose  ,  wing_id  ,  flat_id  ,  done_by  ,  client_name  ,  date  ,  expense_amount  ) VALUES 
 (1,'electricity bill',3,3,'cleark','samdhann ','2021-04-13',300),
 (2,'electrial',4,5,'cleark','samadhan','2021-06-19',100);
/* !40000 ALTER TABLE 'expenses' ENABLE KEYS */;


--
-- Definition of table 'flat_maintenance'
--

DROP TABLE IF EXISTS   flat_maintenance  ;
CREATE TABLE   flat_maintenance   (
    maintenance_id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    wing_id   int(10) unsigned NOT NULL,
    flat_id   int(10) unsigned NOT NULL,
    paid_amount   int(10) unsigned NOT NULL,
    paid_date   varchar(45) NOT NULL,
  PRIMARY KEY (  maintenance_id  )
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table 'flat_maintenance'
--

/* !40000 ALTER TABLE 'flat_maintenance' DISABLE KEYS */;
INSERT INTO   flat_maintenance   (  maintenance_id  ,  wing_id  ,  flat_id  ,  paid_amount  ,  paid_date  ) VALUES 
 (2,3,3,500,'2021-04-07'),
 (3,3,4,300,'2021-04-07'),
 (4,4,5,500,'2021-06-19'),
 (5,4,5,500,'2021-06-19');
/* !40000 ALTER TABLE 'flat_maintenance' ENABLE KEYS */;


--
-- Definition of table 'past_rentalmembers'
--

DROP TABLE IF EXISTS past_rentalmembers;
CREATE TABLE past_rentalmembers(
    id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    renter_id   int(10) unsigned NOT NULL,
    renter_name   varchar(45) NOT NULL,
    gender   varchar(45) NOT NULL,
    dob   varchar(45) NOT NULL,
    mobile_no   varchar(25) NOT NULL,
    aadhar_no   varchar(45) NOT NULL,
    email_id   varchar(45) NOT NULL,
    wing_id   int(10) unsigned NOT NULL,
    flat_id   int(10) unsigned NOT NULL,
    on_rent_date   varchar(45) NOT NULL,
    flat_maintenance   int(10) unsigned NOT NULL,
    leave_date   varchar(45) DEFAULT NULL,
  PRIMARY KEY (  id  )
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table   past_rentalmembers'
--

/*  !40000 ALTER TABLE 'past_rentalmembers' DISABLE KEYS */;
/* !40000 ALTER TABLE 'past_rentalmembers' ENABLE KEYS */;


--
-- Definition of table 'past_societymembers'
--

DROP TABLE IF EXISTS   past_societymembers  ;
CREATE TABLE   past_societymembers   (
    id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    member_id   int(10) unsigned NOT NULL,
    owner_name   varchar(45) NOT NULL,
    gender   varchar(45) NOT NULL,
    dob   varchar(45) NOT NULL,
    mobile_no   varchar(25) NOT NULL,
    aadhar_no   varchar(45) NOT NULL,
    email_id   varchar(45) NOT NULL,
    wing_id   int(10) unsigned NOT NULL,
    flat_id   int(10) unsigned NOT NULL,
    rental_status   varchar(45) NOT NULL,
    flat_maintenance   int(10) unsigned NOT NULL,
    buy_date   varchar(45) NOT NULL,
    sold_date   varchar(45) DEFAULT NULL,
  PRIMARY KEY (  id  )
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table 'past_societymembers'
--

/* !40000 ALTER TABLE 'past_societymembers' DISABLE KEYS */;
INSERT INTO   past_societymembers   (  id  ,  member_id  ,  owner_name  ,  gender  ,  dob  ,  mobile_no  ,  aadhar_no  ,  email_id  ,  wing_id  ,  flat_id  ,  rental_status  ,  flat_maintenance  ,  buy_date  ,  sold_date  ) VALUES 
 (1,3,'Raghunath B','Male','1989-07-03','8668768612','444567456547','er.raghunath1@gmail.com',3,3,'No',0,'2020-10-15','2021-04-07');
/* !40000 ALTER TABLE 'past_societymembers' ENABLE KEYS */;


--
-- Definition of table 'past_staffmembers'
--

DROP TABLE IF EXISTS   past_staffmembers  ;
CREATE TABLE   past_staffmembers   (
    id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    staff_id   int(10) unsigned NOT NULL,
    staff_name   varchar(45) NOT NULL,
    gender   varchar(45) NOT NULL,
    dob   varchar(25) NOT NULL,
    mobile_no   varchar(25) NOT NULL,
    aadhar_no   varchar(25) NOT NULL,
    work   varchar(45) NOT NULL,
    payment_amount   int(10) unsigned NOT NULL,
    join_date   varchar(25) NOT NULL,
    leave_date   varchar(25) DEFAULT NULL,
  PRIMARY KEY (  id  )
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table 'past_staffmembers'
--

/* !40000 ALTER TABLE 'past_staffmembers' DISABLE KEYS */;
/* !40000 ALTER TABLE 'past_staffmembers' ENABLE KEYS */;


--
-- Definition of table 'rentalmembers'
--

DROP TABLE IF EXISTS   rentalmembers  ;
CREATE TABLE   rentalmembers   (
    renter_id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    renter_name   varchar(45) NOT NULL,
    gender   varchar(45) NOT NULL,
    dob   varchar(45) NOT NULL,
    mobile_no   varchar(25) NOT NULL,
    aadhar_no   varchar(45) NOT NULL,
    email_id   varchar(45) NOT NULL,
    wing_id   int(10) unsigned NOT NULL,
    flat_id   int(10) unsigned NOT NULL,
    on_rent_date   varchar(45) NOT NULL,
    flat_maintenance   int(10) unsigned NOT NULL,
  PRIMARY KEY (  renter_id  )
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table   rentalmembers  
--

/* !40000 ALTER TABLE 'rentalmembers' DISABLE KEYS */;
INSERT INTO   rentalmembers   (  renter_id  ,  renter_name  ,  gender  ,  dob  ,  mobile_no  ,  aadhar_no  ,  email_id  ,  wing_id  ,  flat_id  ,  on_rent_date  ,  flat_maintenance  ) VALUES 
 (2,'bban bade','Male','1999-08-26','7507316272','234567896789','bab@gmail.com',3,3,'2021-04-01',700);
/* !40000 ALTER TABLE 'rentalmembers' ENABLE KEYS */;


--
-- Definition of table 'society_flats'
--

DROP TABLE IF EXISTS   society_flats  ;
CREATE TABLE   society_flats   (
    flat_id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    wing_id   int(10) unsigned NOT NULL,
    flat_no   int(10) unsigned NOT NULL,
    owner_name   varchar(45) NOT NULL DEFAULT 'Available'  ,
    renter_name   varchar(45) NOT NULL DEFAULT   'Available'  ,
    maintenance   int(10) unsigned NOT NULL DEFAULT   0  ,
    balance_maintenance   int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (flat_id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table 'society_flats'
--

/* !40000 ALTER TABLE 'society_flats' DISABLE KEYS */;
INSERT INTO   society_flats   (  flat_id  ,  wing_id  ,  flat_no  ,  owner_name  ,  renter_name  ,  maintenance  ,  balance_maintenance  ) VALUES 
 (3,3,101,'Available','bban bade',700,3000),
 (4,3,102,'Available','Available',0,200),
 (5,4,111,'Available','Available',0,100);
 
/* !40000 ALTER TABLE 'society_flats' ENABLE KEYS */;


--
-- Definition of table 'society_wings'
--

DROP TABLE IF EXISTS society_wings;
CREATE TABLE   society_wings   (
    wing_id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    wing_name   varchar(45) NOT NULL,
  PRIMARY KEY (  wing_id  )
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table   society_wings  
--

/*!40000 ALTER TABLE   society_wings   DISABLE KEYS */;
INSERT INTO   society_wings   (  wing_id  ,  wing_name  ) VALUES 
 (3,'A'),
 (4,'G');
/* !40000 ALTER TABLE 'society_wings' ENABLE KEYS */;


--
-- Definition of table 'societymembers'
--

DROP TABLE IF EXISTS   societymembers  ;
CREATE TABLE   societymembers   (
    member_id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    owner_name   varchar(45) NOT NULL,
    gender   varchar(45) NOT NULL,
    dob   varchar(45) NOT NULL,
    mobile_no   varchar(25) NOT NULL,
    aadhar_no   varchar(45) NOT NULL,
    email_id   varchar(45) NOT NULL,
    wing_id   int(10) unsigned NOT NULL,
    flat_id   int(10) unsigned NOT NULL,
    rental_status   varchar(45) NOT NULL,
    flat_maintenance   int(10) unsigned NOT NULL,
    buy_date   varchar(45) NOT NULL,
  PRIMARY KEY (  member_id  )
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table   societymembers  
--

/* !40000 ALTER TABLE   societymembers   DISABLE KEYS */;
INSERT INTO   societymembers   (  member_id  ,  owner_name  ,  gender  ,  dob  ,  mobile_no  ,  aadhar_no  ,  email_id  ,  wing_id  ,  flat_id  ,  rental_status  ,  flat_maintenance  ,  buy_date  ) VALUES 
 (4,  'vishal'  ,'Male','1086-04-21','9130202016','123456732145','katore.vb@gmail.com',3,4,'No',600,'2021-04-06'),
 (5,'vishal munde','Male','1998-07-11','9889909090','626117238277','mundevishal98@gmail.com',4,5,'No',500,'2021-05-12');
/* !40000 ALTER TABLE 'societymembers' ENABLE KEYS */;


--
-- Definition of table 'staffattendance'
--

DROP TABLE IF EXISTS staffattendance  ;
CREATE TABLE   staffattendance   (
    attendance_id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    staff_id   int(10) unsigned NOT NULL,
    date   varchar(25) NOT NULL,
    attendance   varchar(45) NOT NULL DEFAULT 'Absent'  ,
  PRIMARY KEY (  attendance_id  )
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table 'staffattendance'
--

/* !40000 ALTER TABLE 'staffattendance' DISABLE KEYS */;
INSERT INTO   staffattendance   (  attendance_id  ,  staff_id  ,  date  ,  attendance  ) VALUES 
 (5,2,'2021-04-13','Present'),
 (6,2,'2021-04-12','Present'),
 (7,3,'2021-06-19','Present'),
 (8,3,'2021-06-16','Present');
/* !40000 ALTER TABLE 'staffattendance' ENABLE KEYS */;


--
-- Definition of table 'staffmembers'
--

DROP TABLE IF EXISTS   staffmembers  ;
CREATE TABLE   staffmembers   (
    staff_id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    staff_name   varchar(45) NOT NULL,
    gender   varchar(45) NOT NULL,
    dob   varchar(25) NOT NULL,
    mobile_no   varchar(25) NOT NULL,
    aadhar_no   varchar(25) NOT NULL,
    work   varchar(45) NOT NULL,
    payment_amount   int(10) unsigned NOT NULL,
    join_date   varchar(25) NOT NULL,
  PRIMARY KEY (  staff_id  )
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table 'staffmembers'
--

/* !40000 ALTER TABLE 'staffmembers' DISABLE KEYS */;
INSERT INTO   staffmembers   (  staff_id  ,  staff_name  ,  gender  ,  dob  ,  mobile_no  ,  aadhar_no  ,  work  ,  payment_amount  ,  join_date  ) VALUES 
 (2,'sarika sawant','Female','1999-04-14','9130330210','987678564534','Cleaner',7000,'2021-03-01'),
 (3,'raghu','Male','1989-06-19','7507316272','234554323456','Plumber',10000,'2021-05-05');
 
/* !40000 ALTER TABLE 'staffmembers' ENABLE KEYS */;


--
-- Definition of table 'users'
--

DROP TABLE IF EXISTS   users  ;
CREATE TABLE   users   (
    id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    username   varchar(45) NOT NULL,
    password   varchar(45) NOT NULL,
  PRIMARY KEY (  id  )
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table   users'
--

/* !40000 ALTER TABLE 'users' DISABLE KEYS */;
INSERT INTO   users   (  id  ,  username  ,  password  ) VALUES 
 (1,'admin','admin');
/* !40000 ALTER TABLE 'users' ENABLE KEYS */;

DROP TABLE IF EXISTS   Regusers  ;
CREATE TABLE   Regusers   (
    id   int(10) unsigned NOT NULL AUTO_INCREMENT,
    username   varchar(45) NOT NULL,
    password   varchar(45) NOT NULL,
    Email varchar(100)NOT NULL,
  PRIMARY KEY (  id  )
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO   Regusers   (  id  ,  username  ,  password , Email ) VALUES 
 (1,'root','root','root@gmail.com');

/* !40101 SET SQL_MODE=@OLD_SQL_MODE */;
/* !40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/* !40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/* !40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/* !40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/* !40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/* !40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;


