-- MySQL dump 10.13  Distrib 8.0.45, for Linux (x86_64)
--
-- Host: localhost    Database: Amulya
-- ------------------------------------------------------
-- Server version	8.0.45-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ACCOUNT`
--

DROP TABLE IF EXISTS `ACCOUNT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ACCOUNT` (
  `ACC_NO` varchar(10) DEFAULT NULL,
  `CUST_NO` varchar(5) DEFAULT NULL,
  `BRANCH_CODE` varchar(5) DEFAULT NULL,
  `ACC_TYPE` varchar(10) DEFAULT NULL,
  `BALANCE` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACCOUNT`
--

LOCK TABLES `ACCOUNT` WRITE;
/*!40000 ALTER TABLE `ACCOUNT` DISABLE KEYS */;
INSERT INTO `ACCOUNT` VALUES ('A1001','C001','B001','Savings',25000),('A1002','C002','B002','Current',40000),('A1003','C003','B003','Savings',18000),('A1004','C004','B004','Savings',32000),('A1005','C005','B005','Current',50000);
/*!40000 ALTER TABLE `ACCOUNT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BANK_TRANSACTION`
--

DROP TABLE IF EXISTS `BANK_TRANSACTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BANK_TRANSACTION` (
  `TRANS_ID` varchar(10) DEFAULT NULL,
  `ACC_NO` varchar(10) DEFAULT NULL,
  `TRANS_TYPE` varchar(10) DEFAULT NULL,
  `TRANS_AMOUNT` decimal(10,0) DEFAULT NULL,
  `TRANS_DATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BANK_TRANSACTION`
--

LOCK TABLES `BANK_TRANSACTION` WRITE;
/*!40000 ALTER TABLE `BANK_TRANSACTION` DISABLE KEYS */;
INSERT INTO `BANK_TRANSACTION` VALUES ('T001','A1001','Deposit',5000,'2025-01-10'),('T002','A1002','Withdraw',3000,'2025-01-12'),('T003','A1003','Deposit',7000,'2025-10-15'),('T004','A1004','Withdraw',2000,'2024-01-18'),('T005','A1005','Deposit',10000,'2024-03-20');
/*!40000 ALTER TABLE `BANK_TRANSACTION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BRANCH`
--

DROP TABLE IF EXISTS `BRANCH`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BRANCH` (
  `BRANCH_CODE` varchar(5) DEFAULT NULL,
  `BRANCH_NAME` varchar(40) DEFAULT NULL,
  `LOCATION` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BRANCH`
--

LOCK TABLES `BRANCH` WRITE;
/*!40000 ALTER TABLE `BRANCH` DISABLE KEYS */;
INSERT INTO `BRANCH` VALUES ('B001','Main Branch','Delhi'),('B002','City Branch','Mumbai'),('B003','Town Branch','Chennai'),('B004','Central Town','Delhi'),('B005','Market Branch','Bengaluru');
/*!40000 ALTER TABLE `BRANCH` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER`
--

DROP TABLE IF EXISTS `CUSTOMER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CUSTOMER` (
  `CUST_NO` varchar(5) DEFAULT NULL,
  `CUST_NAME` varchar(50) DEFAULT NULL,
  `ADDRESS` varchar(40) DEFAULT NULL,
  `PHONE` decimal(10,0) DEFAULT NULL,
  `EMAIL` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER`
--

LOCK TABLES `CUSTOMER` WRITE;
/*!40000 ALTER TABLE `CUSTOMER` DISABLE KEYS */;
INSERT INTO `CUSTOMER` VALUES ('C001','Ankit Kumar','Delhi',9876543210,'ankit@gmail.com'),('C002','Anjali Verma','Mumbai',9123456780,'anjali@gmail.com'),('C004','Neha Sharma','Jaipur',9090909090,'neha@gmail.com');
/*!40000 ALTER TABLE `CUSTOMER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER_ACCOUNT`
--

DROP TABLE IF EXISTS `CUSTOMER_ACCOUNT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CUSTOMER_ACCOUNT` (
  `ACCOUNT_NO` varchar(10) DEFAULT NULL,
  `CUST_NO` varchar(5) DEFAULT NULL,
  `BRANCH_CODE` varchar(5) DEFAULT NULL,
  `ACC_TYPE` varchar(10) DEFAULT NULL,
  `BALANCE` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER_ACCOUNT`
--

LOCK TABLES `CUSTOMER_ACCOUNT` WRITE;
/*!40000 ALTER TABLE `CUSTOMER_ACCOUNT` DISABLE KEYS */;
INSERT INTO `CUSTOMER_ACCOUNT` VALUES ('A1001','C001','B001','Savings',27500),('A1002','C002','B002','Savings',44000),('A1003','C003','B003','Savings',20790),('A1004','C004','B004','Savings',55000);
/*!40000 ALTER TABLE `CUSTOMER_ACCOUNT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Departments`
--

DROP TABLE IF EXISTS `Departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Departments` (
  `dept_id` int NOT NULL,
  `dept_name` varchar(100) NOT NULL,
  `location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `dept_name` (`dept_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Departments`
--

LOCK TABLES `Departments` WRITE;
/*!40000 ALTER TABLE `Departments` DISABLE KEYS */;
INSERT INTO `Departments` VALUES (1,'Front office','Bhubaneswar'),(2,'Housekeeping','Puri'),(3,'FoodBev','Cuttack');
/*!40000 ALTER TABLE `Departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOAN`
--

DROP TABLE IF EXISTS `LOAN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LOAN` (
  `LOAN_NO` varchar(10) DEFAULT NULL,
  `CUST_NO` varchar(5) DEFAULT NULL,
  `BRANCH_CODE` varchar(5) DEFAULT NULL,
  `AMOUNT` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOAN`
--

LOCK TABLES `LOAN` WRITE;
/*!40000 ALTER TABLE `LOAN` DISABLE KEYS */;
INSERT INTO `LOAN` VALUES ('L2001','C001','B001',150000),('L2002','C002','B002',200000),('L2003','C003','B003',120000),('L2004','C004','B004',180000),('L2005','C005','B005',250000);
/*!40000 ALTER TABLE `LOAN` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-20 12:56:52
