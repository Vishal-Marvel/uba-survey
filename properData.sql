-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: uba_survey2
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer_option`
--

DROP TABLE IF EXISTS `answer_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer_option` (
  `id` varchar(255) NOT NULL,
  `option_name` varchar(255) DEFAULT NULL,
  `field_id` varchar(255) DEFAULT NULL,
  `response_record_id` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKds7iisnc5h4gqxdxuu6t31a7m` (`field_id`),
  KEY `FK27ie4p2nv1jsejym28ucs2jk8` (`response_record_id`),
  CONSTRAINT `FK27ie4p2nv1jsejym28ucs2jk8` FOREIGN KEY (`response_record_id`) REFERENCES `response_record` (`id`),
  CONSTRAINT `FKds7iisnc5h4gqxdxuu6t31a7m` FOREIGN KEY (`field_id`) REFERENCES `field` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer_option`
--

LOCK TABLES `answer_option` WRITE;
/*!40000 ALTER TABLE `answer_option` DISABLE KEYS */;
INSERT INTO `answer_option` VALUES ('02a0bf58-da4a-46c9-b556-a40d8d657edb','EWS','922d8584-32de-4f07-afee-ad6f3a610498',NULL,NULL),('02f20bbf-e7c2-4a44-9fdd-fb9eeeee96eb','Group','e2429bdd-3fd1-4f00-a399-ebcab17b2e3b',NULL,NULL),('0745d8c4-c889-443d-b003-c4bb9cf79103','Female','ac7576c5-3c7f-44df-a887-7bea27532ba6',NULL,NULL),('0b83a8c6-5710-4058-915f-9c66de1ababe','Private','8b3526e0-728a-45b8-8a08-ae87c726e62e',NULL,NULL),('0ba2db92-6b07-49fe-bbd4-1a542bbf6e96','NPHH','d306d8de-dd48-4f86-b653-bffd0bb5bcbf',NULL,NULL),('1030562b-820e-45f6-b0f7-2e9bf7ba4721','Soak Pit','1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5',NULL,NULL),('11cb1e4c-aea8-47ea-8c75-dd9c6446d09b','6','4a66182f-a531-4d28-86c2-89d092ef0e5c',NULL,NULL),('124df25c-6ecb-43c5-a94d-4af264b05aab','No Collection System','dc483670-34ef-4601-a791-9f6564ccecbc',NULL,NULL),('135f5021-3d9f-4035-8384-897e01b29bfe','HOMELESS','4cfbc609-b1e6-4ea7-aabb-382932d60b75',NULL,NULL),('140e7a57-9d47-4983-bd6f-0e12ccfdc3b7','4','573da434-ca26-4ed3-bdbe-1cc2fec2609d',NULL,NULL),('14b84860-c54a-4c1c-9294-67eebd8349fd','Door Step','dc483670-34ef-4601-a791-9f6564ccecbc',NULL,NULL),('16c30836-042f-4f7a-9a6c-f3be5fbf3bbd','Public','485b1075-9475-46c0-904c-5141ece3e250',NULL,NULL),('1899eec8-1774-4a7f-9ab2-d38b5a8b825c','Open','3ccce80e-9448-40aa-af4e-815bd1873822',NULL,NULL),('19741771-6b7f-4a99-8a66-c7293a1a91fd','Female','80a73d29-8525-4d0d-8286-4d6dc5e497f5',NULL,NULL),('1c416679-bb5e-48c2-82c5-f82f45c41395','No','5e5eed86-c402-410d-b363-b978608051cf',NULL,NULL),('1fba7179-3a03-4145-94b7-b44f57409930','None','e2429bdd-3fd1-4f00-a399-ebcab17b2e3b',NULL,NULL),('211e5388-832e-4811-babc-fadf21926157','NPHH','8ec10b8f-529d-40a0-8a30-2307dd010345',NULL,NULL),('212b840c-6dba-47a1-adf9-ee6029aa9708','Twin pit','679dc64c-b7bb-4821-905f-53ff7dbac7a2',NULL,NULL),('21dc1bac-ef66-440a-acc6-956c755e0bd9','Yes ','2b322452-5ad8-49d6-ba17-8bc7a35394e9',NULL,NULL),('24d8ecb1-6994-479a-b11b-646ce393cbe5','Pvt','a01261c7-63b2-4010-aaa1-faa37724a6e4',NULL,NULL),('27890806-c130-4077-a3ce-a997ce99bc15','Leach pit','e10f464b-1abb-4b70-87fc-26926a13afbc',NULL,NULL),('286bf210-5dae-4b8f-b8d3-c1cb540e7512','Others','ac7576c5-3c7f-44df-a887-7bea27532ba6',NULL,NULL),('2aaec1d0-0d5c-437d-b9c6-d7b707a43aea','Canal','4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f',NULL,NULL),('2c2ef216-040a-4138-bf7b-de6cd7bc8616','Septic tank','679dc64c-b7bb-4821-905f-53ff7dbac7a2',NULL,NULL),('33674f6a-78dc-4eb1-96ac-35472a439b77','Agro Residues','372c1390-9e7f-4371-bebb-7e4df21ba148',NULL,NULL),('347efc3c-eb90-4d7e-8b14-dc9cac1d54fb','No','66309b80-898b-4ae1-acf5-b716365512a3',NULL,NULL),('35734c4a-a50a-45b1-9f33-3c3304c1033b','No','76666ba4-a81b-46fb-88f0-0d1e1ff71148',NULL,NULL),('36cb43ba-b316-4454-a0c5-5b7c95814108','Drain','1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5',NULL,NULL),('39787f00-fc9f-4e04-bc23-e1d295122521','Kaccha Pit','679dc64c-b7bb-4821-905f-53ff7dbac7a2',NULL,NULL),('3b57bc38-b87c-49d9-bfcc-7511519cb503','None','4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f',NULL,NULL),('3c8adf69-ec95-4ce0-8972-e511024d4c42','NPHH','bbb2878e-0250-449b-98b3-b704d4e7c0bc',NULL,NULL),('3f74622e-1366-45ba-9529-50851d4633f9','Single pit','679dc64c-b7bb-4821-905f-53ff7dbac7a2',NULL,NULL),('40c5cd29-69ee-4166-a77f-5b6944d9311b','Other','4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f',NULL,NULL),('417c1f90-cd31-4a65-9db3-3745c2211d2d','Soak Pit','679dc64c-b7bb-4821-905f-53ff7dbac7a2',NULL,NULL),('443ffa67-037f-4f4a-bca3-9396151a26b1','Yes ','bac7bfda-7b70-48f9-8581-13091002112c',NULL,NULL),('44831011-a769-4298-b984-5cf617fb6113','Class 8th','53bf82b5-dce4-489c-88dc-ebf41e9e0b65',NULL,NULL),('45ccc9bf-84ba-4aec-a5a1-cfdfd32ef513','Open Defecation','8b3526e0-728a-45b8-8a08-ae87c726e62e',NULL,NULL),('467e436a-ca94-4ff4-b006-b87030d44032','Community','378c03af-e019-4c37-9df5-3e116a7d3192',NULL,NULL),('47eb9115-5e02-485f-b486-9dd7e781801a','Yes','7124b5e6-f9ee-448a-8501-d2e9602d1535',NULL,NULL),('4827a4a3-bc28-462d-967d-03f6407114db','Male','80a73d29-8525-4d0d-8286-4d6dc5e497f5',NULL,NULL),('48a8e323-4f9b-42aa-90d7-117bf2e59edc','Electricity','9840c038-d6f5-4a5b-afe8-4e9ab35c0a4b',NULL,NULL),('49702938-3730-413a-9799-850b7fc0dd2d','Tank','4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f',NULL,NULL),('4a19c2d7-1e45-4bd1-9eae-5f78119c385c','Individual','1f3f7b9b-2438-4ff5-ad50-dbc30d70aa66',NULL,NULL),('4b63922e-c1da-4603-b8e1-bc3df2d2c8c6','Yes ','7453fe3f-c790-4618-b33c-dcb440b14d45',NULL,NULL),('4c07db4f-85bd-4c29-884d-29319fd71a93','Kerosene','9840c038-d6f5-4a5b-afe8-4e9ab35c0a4b',NULL,NULL),('4d7f1006-9b9c-4fa2-8ff6-24e92277b563','In-House','485b1075-9475-46c0-904c-5141ece3e250',NULL,NULL),('4e22375c-b789-4011-aeee-16fd2ede4dc1','Class 12th','53bf82b5-dce4-489c-88dc-ebf41e9e0b65',NULL,NULL),('5010c8f8-e0a6-4de2-ace1-5c679c5d8b46','Pond','1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5',NULL,NULL),('5068340d-e660-45fe-ad09-cfd3f599e7d5','Male','ac7576c5-3c7f-44df-a887-7bea27532ba6',NULL,NULL),('516147a1-1f9a-42e5-9ac4-4ebc0547d926','BPL','bdc4bb1b-4850-4ffb-b5c2-2e4ac6851d49',NULL,NULL),('528b765f-7573-41d2-a67b-270536aabfb4','No','cfea527f-b1cc-4fe5-b255-bffdfaef3d19',NULL,NULL),('53428867-aacb-4b93-aaa9-76225e746529','No','aa61d46b-61bf-46cb-95e4-a16e18e4de79',NULL,NULL),('5526c938-697c-497d-8b56-4eb3514dd7e3','KUTCHA','4cfbc609-b1e6-4ea7-aabb-382932d60b75',NULL,NULL),('57bf5564-497f-47cd-a61e-2c331354540e','No','7453fe3f-c790-4618-b33c-dcb440b14d45',NULL,NULL),('5855a788-17ed-4388-9bc0-1f8754e96755','Solar Power','9840c038-d6f5-4a5b-afe8-4e9ab35c0a4b',NULL,NULL),('5856448f-6960-4ec3-81ef-5c39950d1bcb','Other','1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5',NULL,NULL),('5b7d74a0-90d0-4a90-9f9c-1068e4b46e37','Leach pit','679dc64c-b7bb-4821-905f-53ff7dbac7a2',NULL,NULL),('5ce9148f-a751-4b32-9f24-fe5797914cd6','Other','372c1390-9e7f-4371-bebb-7e4df21ba148',NULL,NULL),('5e03406a-c877-4bee-aea1-cdfc25772535','Biogas','372c1390-9e7f-4371-bebb-7e4df21ba148',NULL,NULL),('5e24a161-1fcb-4d97-885a-a324b051fa95','LIG','922d8584-32de-4f07-afee-ad6f3a610498',NULL,NULL),('614dfc9e-fb33-45eb-8edf-c6ea2c37e42c','KANCHEEPURAM (KCP-574)','47e664a0-8863-4da0-b4a6-5450a121dfa1',NULL,NULL),('6170efc8-f82d-4df7-b7c2-653b4603f177','4','4a66182f-a531-4d28-86c2-89d092ef0e5c',NULL,NULL),('646dfa42-8e45-403e-9959-829742108943','Flooding','e5cdccec-474c-45cf-adf7-396917a05bb6',NULL,NULL),('66dec038-36ab-4ef3-9aee-c817d4fa1e56','Weekly','05e0a33f-c099-4ed0-a706-b248303145d5',NULL,NULL),('67f3162a-b644-4692-bc4e-2bd0f523dfba','Yes ','5e5eed86-c402-410d-b363-b978608051cf',NULL,NULL),('68562ac4-e325-47e4-8ea4-60083cb8ef23','Sprinkler','e5cdccec-474c-45cf-adf7-396917a05bb6',NULL,NULL),('6cd3ce60-1a46-4df4-a513-a2ce24436977','MIG','922d8584-32de-4f07-afee-ad6f3a610498',NULL,NULL),('6d82cd41-1f66-4df4-9d25-c27faa4999c5','River','4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f',NULL,NULL),('718c72aa-d731-4deb-958e-64451e515a5c','SCA','89d50461-139b-4be7-8b01-e3ccfbd7c69c',NULL,NULL),('72cdbf75-a362-414c-8b11-507703d60fd8','PUCCA','4cfbc609-b1e6-4ea7-aabb-382932d60b75',NULL,NULL),('78f7c7a3-3f88-4dfc-aa20-2fdff5d14203','Individual','e2429bdd-3fd1-4f00-a399-ebcab17b2e3b',NULL,NULL),('7b2cde09-9e32-4ca5-bf09-16caeae7ced2','9','4a66182f-a531-4d28-86c2-89d092ef0e5c',NULL,NULL),('80f31b79-73a5-4349-bccf-5ca1f7d6e11a','TAMIL NADU(33)','3d9f282e-9833-442f-a0a7-6459db24f4a0',NULL,NULL),('82d722b2-1d59-4962-a34f-a012bf26c821','No','7124b5e6-f9ee-448a-8501-d2e9602d1535',NULL,NULL),('86239d08-0722-4e59-a8ee-4ccf7c30514e','Custom','05e0a33f-c099-4ed0-a706-b248303145d5',NULL,NULL),('86fa2c13-4043-4e7e-91bb-5e5477b33cf8','Open Pit','679dc64c-b7bb-4821-905f-53ff7dbac7a2',NULL,NULL),('8790ecfd-1bae-4056-b33c-a465c035a145','Not Literate','53bf82b5-dce4-489c-88dc-ebf41e9e0b65',NULL,NULL),('8801a563-436a-4ac8-ae06-aa0b1691f098','Others','80a73d29-8525-4d0d-8286-4d6dc5e497f5',NULL,NULL),('88285edb-ffc5-4111-9453-f9b12a15a110','3','573da434-ca26-4ed3-bdbe-1cc2fec2609d',NULL,NULL),('8cb9c00d-44d4-48d8-880c-c2af05e05d0c','7','4a66182f-a531-4d28-86c2-89d092ef0e5c',NULL,NULL),('8da330de-e294-46fd-b654-87a1d211f2f7','Daily','05e0a33f-c099-4ed0-a706-b248303145d5',NULL,NULL),('90e0065d-63a5-4e41-9da1-b5cbf07b5cf9','Yes ','cfea527f-b1cc-4fe5-b255-bffdfaef3d19',NULL,NULL),('91e16eac-8775-47da-885a-751c22ea4f3e','Divorced/Separated','0e7e3eca-3a56-4a3e-96a3-38c0da5d54ca',NULL,NULL),('924e8376-baa1-4220-98cd-e34a86df8263','SC','89d50461-139b-4be7-8b01-e3ccfbd7c69c',NULL,NULL),('94b4b49e-fcd6-42d4-8414-7b6eb24409ff','Other','679dc64c-b7bb-4821-905f-53ff7dbac7a2',NULL,NULL),('96194dc6-f2b2-4e45-ae57-39db93b28b26','Borewell','4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f',NULL,NULL),('966c65b9-ae72-4531-8de4-e82023dccdee','Random','05e0a33f-c099-4ed0-a706-b248303145d5',NULL,NULL),('968b5733-a5b3-40d7-8efc-1e4a272ee7b8','Open','a9810a0f-47dd-4cac-b177-31a7dc84db30',NULL,NULL),('981b1785-f9c3-4c18-88b5-496b3fb8ae8d','Kerosene','372c1390-9e7f-4371-bebb-7e4df21ba148',NULL,NULL),('9b8b4fc0-b79c-4e5d-ac1f-50195d19eefc','ST','89d50461-139b-4be7-8b01-e3ccfbd7c69c',NULL,NULL),('9ecd4ceb-bcfa-44ef-9413-858936a1c1c7','Yes ','66309b80-898b-4ae1-acf5-b716365512a3',NULL,NULL),('a0fda44d-c41b-4dcf-a5eb-74a5ab72d39c','Literate','53bf82b5-dce4-489c-88dc-ebf41e9e0b65',NULL,NULL),('a1d3ca51-b069-42a9-8dbc-74716b6f041d','Soak Pit','e10f464b-1abb-4b70-87fc-26926a13afbc',NULL,NULL),('a2d10fca-d741-4ddb-8a0c-416625884689','OWN HOUSE','c34e9e1c-0d5b-4e6a-b116-4588f64b804d',NULL,NULL),('a7c52bc6-490a-44ee-86d4-ebad9f573d2a','None','e5cdccec-474c-45cf-adf7-396917a05bb6',NULL,NULL),('a915c789-175c-4dab-8d7c-9878d2b9959c','1','573da434-ca26-4ed3-bdbe-1cc2fec2609d',NULL,NULL),('a9d4d685-a5f0-44be-9367-210c3eb8c72d','2','4a66182f-a531-4d28-86c2-89d092ef0e5c',NULL,NULL),('aa994d37-cfad-4330-acf4-318d8fe28f28','Drip','e5cdccec-474c-45cf-adf7-396917a05bb6',NULL,NULL),('abbd063c-5d7b-4e3b-9f11-bbb90127f96f','ITI Diploma','53bf82b5-dce4-489c-88dc-ebf41e9e0b65',NULL,NULL),('acc1f197-3e5d-4464-a3d9-f05b2545a583','Class 10th','53bf82b5-dce4-489c-88dc-ebf41e9e0b65',NULL,NULL),('acfc52a6-b9fe-4f1a-a6fb-d8a6c0878f53','No','d3948b18-ae59-4dc1-b9e2-318522a06a3f',NULL,NULL),('b0128dee-ea98-4999-8f12-861d0ab0d7c8','HIG','922d8584-32de-4f07-afee-ad6f3a610498',NULL,NULL),('b17d1988-b0ed-4eb1-8920-e84f80f285fe','No','bac7bfda-7b70-48f9-8581-13091002112c',NULL,NULL),('b5b6d8d6-f860-465c-bdae-a7e78a59dc5a','Not Married','0e7e3eca-3a56-4a3e-96a3-38c0da5d54ca',NULL,NULL),('b5c03634-ac37-4433-9844-6191aa7a4705','None','1f3f7b9b-2438-4ff5-ad50-dbc30d70aa66',NULL,NULL),('b65efd7e-eeb9-4d83-8e17-5f780d18df91','Cow Dung','372c1390-9e7f-4371-bebb-7e4df21ba148',NULL,NULL),('b706b61d-6946-4f86-b98f-3dc229086e28','Yes ','aa61d46b-61bf-46cb-95e4-a16e18e4de79',NULL,NULL),('b7412988-0ea5-4ff3-b18a-7529b03a2f22','Community','8b3526e0-728a-45b8-8a08-ae87c726e62e',NULL,NULL),('bba7ea08-413d-482b-b5ee-a1fccc44e7bf','2','573da434-ca26-4ed3-bdbe-1cc2fec2609d',NULL,NULL),('bcd26d89-4f1a-45ca-8856-ac33811cada5','Kutcha','3ccce80e-9448-40aa-af4e-815bd1873822',NULL,NULL),('bfe0885f-1afb-40c3-a37a-bd5ec6a2c3bc','Open Pit','1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5',NULL,NULL),('c0858305-aa95-4d79-b745-708058b1fc64','Individual','378c03af-e019-4c37-9df5-3e116a7d3192',NULL,NULL),('c49ea885-8d0b-401f-af59-93fc978dd32c','APL','bdc4bb1b-4850-4ffb-b5c2-2e4ac6851d49',NULL,NULL),('c611598d-aa58-42f3-9f31-7c52c8ec5fb8','Other','9840c038-d6f5-4a5b-afe8-4e9ab35c0a4b',NULL,NULL),('c6c56593-c270-4824-aca6-4f9cf162f5b3','Group','1f3f7b9b-2438-4ff5-ad50-dbc30d70aa66',NULL,NULL),('c8a4b04a-e8c0-48e5-9950-69726ac89d40','8','4a66182f-a531-4d28-86c2-89d092ef0e5c',NULL,NULL),('c946445a-0e01-4a9f-9162-052924a489da','MBC','89d50461-139b-4be7-8b01-e3ccfbd7c69c',NULL,NULL),('ca5ba108-e2d6-4e4d-a520-1f0f1a24fd88','Pucca','3ccce80e-9448-40aa-af4e-815bd1873822',NULL,NULL),('cb58a4d4-09c5-484b-a1a0-785f61248ffe','OC','89d50461-139b-4be7-8b01-e3ccfbd7c69c',NULL,NULL),('cc34b6bc-17d2-4757-8ac9-0282cd1218a7','5','573da434-ca26-4ed3-bdbe-1cc2fec2609d',NULL,NULL),('d0e85e00-7cbe-4e9f-b251-f9b91c59ab7c','3','4a66182f-a531-4d28-86c2-89d092ef0e5c',NULL,NULL),('d10b61bd-0585-46f9-840b-c5640a4ea8cb','Community','1f3f7b9b-2438-4ff5-ad50-dbc30d70aa66',NULL,NULL),('d1c3d9b7-5ce1-4041-b55d-a7d9e6cec7d9','BC','89d50461-139b-4be7-8b01-e3ccfbd7c69c',NULL,NULL),('d3216828-47bb-49d4-afb8-c38be1db3361','Common Point','dc483670-34ef-4601-a791-9f6564ccecbc',NULL,NULL),('d32898bb-fec3-44d1-abc2-b111ad63012d','Others','8ec10b8f-529d-40a0-8a30-2307dd010345',NULL,NULL),('d36e7efd-afc2-464b-9cf6-eb4b699743e2','LPG','372c1390-9e7f-4371-bebb-7e4df21ba148',NULL,NULL),('d3a309ae-b319-4d2f-ba1b-bf43772d8d32','Govt. Supply','a01261c7-63b2-4010-aaa1-faa37724a6e4',NULL,NULL),('d80f939a-c5d8-4f43-8105-5f6649c5037e','Upto Class 5','53bf82b5-dce4-489c-88dc-ebf41e9e0b65',NULL,NULL),('d9e7b237-7d3e-4155-8565-57c74a835ae7','Post Graduate/ Professionalw','53bf82b5-dce4-489c-88dc-ebf41e9e0b65',NULL,NULL),('dacca0cb-8ce8-4383-81e5-658599e7f0c3','Yes ','76666ba4-a81b-46fb-88f0-0d1e1ff71148',NULL,NULL),('dc268723-7536-4bf3-a6ea-a2b1d8c0cff2','1','4a66182f-a531-4d28-86c2-89d092ef0e5c',NULL,NULL),('dc788375-1dc4-47cb-8f1f-54d8b6c10648','SEMI PUCCA','4cfbc609-b1e6-4ea7-aabb-382932d60b75',NULL,NULL),('dcf1e4cf-03e9-47f0-ad8c-7df81ad9681d','Wood','372c1390-9e7f-4371-bebb-7e4df21ba148',NULL,NULL),('e0bfd5d2-8066-4f93-9c1e-c8487e6970cc','5','4a66182f-a531-4d28-86c2-89d092ef0e5c',NULL,NULL),('e6212a84-90ec-49b8-96e5-0930e6f62243','NPHH','030194bb-0eda-47c8-8c13-512cf44a5182',NULL,NULL),('e6cb8fb3-c76e-4abf-a5da-80a2877bdbc6','PHH','8ec10b8f-529d-40a0-8a30-2307dd010345',NULL,NULL),('e869be03-76d1-4ded-b190-0416f8c2c81f','RENTAL HOUSE','c34e9e1c-0d5b-4e6a-b116-4588f64b804d',NULL,NULL),('eb2fdf11-9658-4f4e-bcfc-c28bfd742dca','Covered','a9810a0f-47dd-4cac-b177-31a7dc84db30',NULL,NULL),('ed260ec7-44c9-4d2b-a403-e9bf65a6f03a','Married','0e7e3eca-3a56-4a3e-96a3-38c0da5d54ca',NULL,NULL),('ede37b54-3988-4cf7-9bd1-9926b9e9a604','No','2b322452-5ad8-49d6-ba17-8bc7a35394e9',NULL,NULL),('eff7ab48-5be2-48fa-a51a-a9067c078fe9','Graduate','53bf82b5-dce4-489c-88dc-ebf41e9e0b65',NULL,NULL),('f4c74de0-805f-4c28-a6d2-d336b73aff92','AAY','8ec10b8f-529d-40a0-8a30-2307dd010345',NULL,NULL),('f4da9133-c797-4509-ade4-e2fbf1fed1f7','Yes ','d3948b18-ae59-4dc1-b9e2-318522a06a3f',NULL,NULL),('f6ae384c-2188-44dc-93d8-c427100b5b63','Other','e10f464b-1abb-4b70-87fc-26926a13afbc',NULL,NULL),('f7d1daa6-f2a1-4167-a3e1-225018b28bdc','Electricity','372c1390-9e7f-4371-bebb-7e4df21ba148',NULL,NULL),('f9c11e2d-14fc-4d37-97a3-e6013b893f99','None','a9810a0f-47dd-4cac-b177-31a7dc84db30',NULL,NULL),('fb3f3863-4354-40bc-8952-3924d141ba68','Kitchen Garden','e10f464b-1abb-4b70-87fc-26926a13afbc',NULL,NULL),('fc015360-80be-4076-9848-a324cfefc060','Widowed','0e7e3eca-3a56-4a3e-96a3-38c0da5d54ca',NULL,NULL);
/*!40000 ALTER TABLE `answer_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `field`
--

DROP TABLE IF EXISTS `field`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `field` (
  `id` varchar(255) NOT NULL,
  `field_type` varchar(255) DEFAULT NULL,
  `image` blob,
  `question` varchar(255) DEFAULT NULL,
  `no_field_id` varchar(255) DEFAULT NULL,
  `parent_field_id` varchar(255) DEFAULT NULL,
  `section_id` varchar(255) DEFAULT NULL,
  `yes_field_id` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cknr8ua4fmaj4y2necyi7jkml` (`no_field_id`),
  UNIQUE KEY `UK_rey24kddp9w7q94wbhnyq4gu5` (`yes_field_id`),
  KEY `FKqxbu1ykp2hknek7dslxq3n2kr` (`parent_field_id`),
  KEY `FKee1pro6w1ocjxbya3ybrkbis4` (`section_id`),
  CONSTRAINT `FK9qrejykl3aorr6l9tjoi6f36u` FOREIGN KEY (`no_field_id`) REFERENCES `field` (`id`),
  CONSTRAINT `FKee1pro6w1ocjxbya3ybrkbis4` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`),
  CONSTRAINT `FKnn6k6oo2478xv4gpcoiy2sxhi` FOREIGN KEY (`yes_field_id`) REFERENCES `field` (`id`),
  CONSTRAINT `FKqxbu1ykp2hknek7dslxq3n2kr` FOREIGN KEY (`parent_field_id`) REFERENCES `field` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `field`
--

LOCK TABLES `field` WRITE;
/*!40000 ALTER TABLE `field` DISABLE KEYS */;
INSERT INTO `field` VALUES ('030194bb-0eda-47c8-8c13-512cf44a5182','DROPDOWN',NULL,'Card Type',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:43:22.449000',NULL),('05e0a33f-c099-4ed0-a706-b248303145d5','DROPDOWN',NULL,'Frequency of collection of Waste',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:29:04.601000',NULL),('089ab75b-7b9d-44f0-a399-dd581ea75935','STRING',NULL,'Village Name',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:35.692000',NULL),('0a957429-b14a-4c10-a3d9-3e100ce83c76','YES/NO',NULL,'Electricity Connection to Household',NULL,NULL,'3f74f505-5136-45dc-a337-f7347fb711b7','60327e37-867d-45c8-9967-493bc5d7f266','2024-02-14 05:40:37.833000',NULL),('0c4d46e6-d8be-4d6c-8610-5a154b82e1f1','INTEGER',NULL,'Since how many years the migration is taking place?',NULL,'4205334d-1d67-448c-98ae-33f3e3e293e3','aafb2a2e-29cc-41f6-884e-8f6b6a886dae',NULL,'2024-02-14 05:18:44.536000',NULL),('0d15c21f-2f61-4d09-a31a-712bff883b92','STRING',NULL,'Mobile No.',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:58:51.407000',_binary '\0'),('0e297de4-6bed-4d76-8063-7c9ebb607377','STRING',NULL,'Possible Suggestions by Villagers',NULL,'73956663-9121-4667-bda2-265c7287285e','3937d505-24d7-4d50-bd67-a986e643244e',NULL,'2024-02-14 06:00:20.655000',NULL),('0e7e3eca-3a56-4a3e-96a3-38c0da5d54ca','DROPDOWN',NULL,'Marital Status',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:08:24.300000',NULL),('0e9a36e7-1253-476e-af61-2d09430e0ed4','INTEGER',NULL,'How many Years',NULL,'395a6e23-9ddd-4632-9c88-1acf7601113f','aafb2a2e-29cc-41f6-884e-8f6b6a886dae',NULL,'2024-02-14 05:19:38.791000',NULL),('1206f3db-c08a-458b-a9ba-bce9f364826e','INTEGER',NULL,'Fertilizer Use (Kg/Acre)',NULL,'396781c8-025d-406f-bc78-f7b06671e889','c803bb40-15b5-4691-b48a-67cb2048c45a',NULL,'2024-02-14 05:51:34.080000',NULL),('1344fd29-dfc0-4fd1-afe7-1ab08d5a069a','YES/NO',NULL,'Ration Card',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c','8ec10b8f-529d-40a0-8a30-2307dd010345','2024-02-13 23:41:13.744000',_binary '\0'),('14f3f571-e7b8-4acf-9890-5bf725d1eeb1','YES/NO',NULL,'Do you use it','6151e7d2-65f4-43e1-9146-5992b06dc866','485b1075-9475-46c0-904c-5141ece3e250','25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:32:46.313000',NULL),('15ce6b41-ca78-417d-a615-dd2cc3d270d0','STRING',NULL,'Gram Panchayat Name',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:37.692000',NULL),('18998923-a021-4357-94fd-1d6dd03c8d8c','STRING',NULL,'Name of the Head (As per Ration Card)',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:24:25.219000',NULL),('1a3fbf09-bb05-4963-b315-ab068a4cfea5','INTEGER',NULL,'Animal Waste/Cow Dung (in Kg.)',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:58:08.160000',NULL),('1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5','DROPDOWN',NULL,'Where does the blackwater discharge',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:34:33.853000',NULL),('1ce00821-b4d9-4e36-a681-0b060d950084','INTEGER',NULL,'Goats/ Sheep',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:25.873000',NULL),('1f3f7b9b-2438-4ff5-ad50-dbc30d70aa66','DROPDOWN',NULL,'Biogas Plant',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:29:50.046000',NULL),('2196729c-89c3-4689-adeb-2ec351331eaf','STRING',NULL,'Activity done by the SHG',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:18:16.427000',NULL),('2b322452-5ad8-49d6-ba17-8bc7a35394e9','DROPDOWN',NULL,'Presently having ID Card for  Phy.Cha (Y/N)',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:20:04.774000',NULL),('2c4f685d-6e44-409a-81b6-8b98270e3372','STRING',NULL,'Crop',NULL,'3974cf52-3cd2-497d-a7b2-99dfa8b04bc4','d5d0059e-0658-4e55-b1d9-7859c4aacefb',NULL,'2024-02-14 05:55:11.902000',NULL),('2f737927-b4c7-43dc-ada1-bead93cd90d8','STRING',NULL,'Respondent\'s Name',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:16:45.692000',NULL),('372c1390-9e7f-4371-bebb-7e4df21ba148','DROPDOWN',NULL,'Fuel used for Cooking',NULL,NULL,'e0b34e9b-0c48-4319-a318-0d3de5690d99',NULL,'2024-02-14 05:44:21.030000',NULL),('378c03af-e019-4c37-9df5-3e116a7d3192','DROPDOWN',NULL,'Mode of Water Storage',NULL,NULL,'fed067b2-16a5-4571-8e61-d9519a789fdb',NULL,'2024-02-14 05:25:24.932000',NULL),('37f0a25c-50f8-4a8b-89c4-2befead6b118',NULL,NULL,'What kind of skil yould you like to acquire',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:15:01.780000',NULL),('395a6e23-9ddd-4632-9c88-1acf7601113f','YES/NO',NULL,'Any members migrated from other area?',NULL,'4205334d-1d67-448c-98ae-33f3e3e293e3','aafb2a2e-29cc-41f6-884e-8f6b6a886dae','0e9a36e7-1253-476e-af61-2d09430e0ed4','2024-02-14 05:19:38.768000',NULL),('396781c8-025d-406f-bc78-f7b06671e889','YES/NO',NULL,'Do You use organic Manures',NULL,NULL,'c803bb40-15b5-4691-b48a-67cb2048c45a','1206f3db-c08a-458b-a9ba-bce9f364826e','2024-02-14 05:51:34.066000',NULL),('3974cf52-3cd2-497d-a7b2-99dfa8b04bc4','COUNTER',NULL,'Crop Count',NULL,NULL,'d5d0059e-0658-4e55-b1d9-7859c4aacefb',NULL,'2024-02-14 05:54:41.812000',NULL),('39f6f0b6-ce52-451c-ac2d-7fd6a93087dd','STRING',NULL,'Village Code',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:36.692000',NULL),('3afcec45-80d2-4915-bd4f-a277aa3533f0','YES/NO',NULL,'Do you use Chemical Insecticides',NULL,NULL,'c803bb40-15b5-4691-b48a-67cb2048c45a','f4084e74-15de-40d8-960f-b904c59d9938','2024-02-14 05:51:20.007000',NULL),('3c57e7a0-00b2-4dd6-80c5-ec94fadc2ded','STRING',NULL,'If, Rental House Migration from area',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:57:29.802000',NULL),('3ccce80e-9448-40aa-af4e-815bd1873822','DROPDOWN',NULL,'Shelter for Livestock',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:57:35.196000',NULL),('3d9f282e-9833-442f-a0a7-6459db24f4a0','DROPDOWN',NULL,'State',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:00:35.692000',NULL),('3e307313-cb06-485f-9930-4af37a8edcf4','YES/NO',NULL,'Do you have sanitation system',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d','485b1075-9475-46c0-904c-5141ece3e250','2024-02-14 05:31:32.610000',NULL),('41f5e600-486b-4b7b-8ada-09b78c9b6397','STRING',NULL,'Area under the Crop in Prev. (Acre)',NULL,'3974cf52-3cd2-497d-a7b2-99dfa8b04bc4','d5d0059e-0658-4e55-b1d9-7859c4aacefb',NULL,'2024-02-14 05:55:20.446000',NULL),('4205334d-1d67-448c-98ae-33f3e3e293e3','INTEGER',NULL,'How many members of the family migrated',NULL,'754d63e0-c153-4f7d-b8b3-2bbdd236315f','aafb2a2e-29cc-41f6-884e-8f6b6a886dae',NULL,'2024-02-14 05:17:06.249000',NULL),('43431db1-599b-4cb7-8826-206d926bac2d','INTEGER',NULL,'Cows',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:12.660000',NULL),('46c19fd2-194b-45be-a255-6587fa93cbd7','INTEGER',NULL,'Annual Income',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:55:51.700000',NULL),('47e664a0-8863-4da0-b4a6-5450a121dfa1','DROPDOWN',NULL,'District',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:34.692000',NULL),('485b1075-9475-46c0-904c-5141ece3e250','DROPDOWN',NULL,'Location',NULL,'3e307313-cb06-485f-9930-4af37a8edcf4','25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:31:32.625000',NULL),('48c2e680-039e-40e9-8fcf-873399df46c6','STRING',NULL,'Cost of the system',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:37:41.332000',NULL),('4a516891-c03a-41fe-a2b0-bf4edc1eb8ce','INTEGER',NULL,'Male',NULL,'5ce7fb31-ae67-4bce-9327-19e836301d58','1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:25:43.349000',NULL),('4a66182f-a531-4d28-86c2-89d092ef0e5c','DROPDOWN',NULL,'Ward No.',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:39.692000',NULL),('4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f','DROPDOWN',NULL,'Irrigation',NULL,NULL,'c803bb40-15b5-4691-b48a-67cb2048c45a',NULL,'2024-02-14 05:52:19.635000',NULL),('4cfbc609-b1e6-4ea7-aabb-382932d60b75','DROPDOWN',NULL,'Type of House',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:58:19.602000',NULL),('4d58074e-e278-4874-9cb4-c8d64e53ce7b','STRING',NULL,'Year Productivity (in quintals per Acre)',NULL,'3974cf52-3cd2-497d-a7b2-99dfa8b04bc4','d5d0059e-0658-4e55-b1d9-7859c4aacefb',NULL,'2024-02-14 05:55:24.707000',NULL),('51aa58a6-4935-4cad-b536-f45d0b10cfc4','STRING',NULL,'Block Code',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:41.692000',NULL),('53bf82b5-dce4-489c-88dc-ebf41e9e0b65','DROPDOWN',NULL,'Level of Education (choose the highest level applicable)',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:11:43.455000',NULL),('56ed03e3-a71e-419f-8e03-ac47e4694fce','YES/NO',NULL,'Do you use Chemical Fertilisers',NULL,NULL,'c803bb40-15b5-4691-b48a-67cb2048c45a','ab5b6e88-6999-41a8-91e4-ea07ef42fd21','2024-02-14 05:51:12.420000',NULL),('573da434-ca26-4ed3-bdbe-1cc2fec2609d','DROPDOWN',_binary 'ÿ\Øÿ\à\0JFIF\0\0`\0`\0\0ÿ\Û\0C\0\n\n\n\r\rÿ\Û\0C		\r\rÿÀ\0\0”\0¥\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñð$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rðbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Ú\0\0\0?\0ýS¢Š(\0¢Š(\0¢Š(\0¢²¼O\â­Á:Îµ\â-b\Ã@\Ñ\í¶ùú†©t–\Öñnp‹ºG!W,Ê£\'’Àu5ó\ß\ÆOÛ—\Ã?\í\ìF…kk¬O4\è.$×¯e\Ñ`‚Ý‘˜Lª\Öò\Ü\Üò`Án\èC¼i\ns¨ù`®ÀúfŠü\ØñoüW-2\é)¦Áó¾\"´\Ò%¸P¼l\Ùu5\ÄDžKZ†\0Ž|óPÿ\0‚–øúH\Ê\Ø^kp¿g¸¸\Ó$º4\ÕÀ\Çlž{šõa“\ãjj¡o[!]w?Z¨¯È‹ø)G\Äõ”}£UÔ¤‹+\ÓQ½°MƒÒºþ\ny\â\ë9gš\à#.\Ù%\Ö,-µ\\>dKo\ìþù,x=r3W,—~Kü\Ð]w?S¨¯‰þÿ\0ÁHôO4v\Þ M&\âb	l§:mÄ·’`»?gr?\çõ\Ï=8\ç\éü|ðµ\r;MÓ¼Km³©+½Ž‘ª#\Ø_\Þ\"©f’k…I%Œ*³yˆ¥RA \Zò\ê\á\ê\Ðv«†zQ\\\àQE\0QE\0QE\0QE\0QH\ÌK1\n d“\ÐP\×ÊŸ´\×\í¹cð›ýÂ·\Z-\í\Ô3Io}©jFyc‚X¤‹t6\ÖÑ…ûl…ZtfY\âŽ\"+$›ÿ\0v|\Óö\Òý¶¬t}6Oøb\âKp‘\Í\Û\Êðýµs¸J\î„0´8UH7#$‘nW\í_œ¾ º×¼S2x—]ûlÖ·“ý”jon|ŒÆ«˜bÀhÉˆ\×T¨\0W\Ò\å\ÙC\Ä%V¾‘\éÝ‰»ñ/ö§ñ§\ÄP]k\ê&\åX2jw\×[\Õ`7Ã±R2@Á‘Ã»\'y\å?†ÿ\0³Î¿ñ\Å\ÚŸ®\êú‚añ¯\Ûô\íSÄ’´i¨+L±ƒ\0ù’³¸\Â	\0œ\ãú‡ÅŸ²\Èý”ÿ\0\á^|nøm©\Üø\ßA\ÒV\ÍqdK\Ïk ù®!P0\"x†L+e¹+\éß¶\Ã/x\Ãö{À6¶:—ƒ¡_\é\ÖÐ»F£O»wy\Z\Ä]Bd‰P+ÚŽ6…%\nxH\Ú2\Òö\Ù\íªõ¶ý6os\çÿ\0…ÿ\0²‚n¿i\Ïü/\Öu-WÄ£\Ã\Ú_A\ä¦½\Ý\Òù;¢\ÃùH— ƒÓœ‘]Ÿü2?\Ã\íöñÏ‚?²&»°—\áô\Úþ—gyu ’\Â÷\ÌX\Â,Ÿ(“i\ÜA%—œ\à\ãñ\í]\à#öšøkñš\Î\âmB\â\ãÃ‹‹t½6Ý–X\îÍ»\Æ@2mGÁhñ†\Æ!\Íi?·M®ƒ\ã\ïx x>mb\ãA\Ñ\ïô…º¾H~\Ýe$\Å\íP\â\'\ØbL÷·A\Õ8\ã\ê{\Êú\Ç\Ó\Þ\×Óªü{‡ûü-ð\Ï\Å/x²/iË©hºG…\ï5C<‰‰Q¢T`ce9\Øþ+\Ñ4O\Ù\'Á\Öÿ\0±]\ï\ÄMx\ßG\ã¦Ó¥\Öm-\à¹ò\Â\Û–8‘•`Q‡\ÎÁ`øŒøû@Yüð‡´\è|(º®¹\â2M!5–¿h¾\Åo\"‘ \ì!\É$6I*;d <Qûvø?\âW\Âÿ\0x\n\ï\Ã3x7N¾²\Ó42\â\Îº{{H¥_=g—p,ª›¼µHø\Ëw9®¬R\Æ{{\ÓO–ñ\ë\Ño§õôµ$oØŸ\Æ_ü\â\Ý>\ê\Þy¼C§^j\ÓX\\/,m _0JÒ–ÁB8.£Þ¼s\Âÿ\0µÿ\0Æ–öW¦M=g[Ÿ\ì\ëµ[y«²ˆ\Û!d\\².O*\Êy¯Ð_µ¿‚|Qû0\êº‡\ï\íllõ-\\x^\Æ<¬—\Öú:”óg0;+(’8]UfC =3^û3þ\Î\ÖüW\â\Z\ëwrx\Ç\áw‡Œv\ÖL,\äµ}wQ™PEf‘1\Îðò*‘»\ÊrU‰¥G9Pœñ±\Ò\î\Ê\Û\ë·k\ê’ôl-¯ºzŸÀ_ø)£µ\ÒüAß—ž(Í®¥å”ˆ•W6×’Y•Aa\Û\ì[7kò¥~‚ø\â…ñ+A:¿‡\îäº³Yäµ‘n-fµž£m¯°L‰$l88u«+«!?iO\Ùm<%ñ\ê|0¶¿ñ5\ÇöXÕ®´{`ne\Ò\Îž \0¸\n”°Dˆ¿3œ\Ï\Ù\ïö§ñÂ¿h±\ßj×‹e§\Ê¼­s0‰Sk§\Ù\î\ãCþ‘lµX3@\ÇÌ‡ñ\Ë\ãâ²ªXŠ~\ß\Õ_—\×úÿ\0\"¹º3öÂŠ\â>üX\Ò~-xtj\Z~\Ûk\ØDb÷O3$¯lÎÐ‡BU\ãu!’E;YOb½|‹N.Ì ¢Š)\0QE\0QE\0W\Å·\Ç\í1‚4?øG4Ë¨fF‘¡¼³!]uBsk #þ=\ã.ó\ÇJ›€¿I|tø¡mð£Àz£\Ü\Çm}>\ë{7\â7’IŠžb†9f+XDT|Ì þ!ø\ë\ÆOñ;Ç‚\î\êò[5\å[kiu^\á\í­Ë“\æL\à–BY\å–L’G‘\ÎY\Í{ùF\ëUy\ê/r?›²\á;\Ý+\Æ\ß´Û¯ˆš\ÝüZN£¨,šÆ­ó®v3eßœ\äúœ­§õ\Ò\Ó\à?Ã+öu¾ð%õ\Çü%^’;_J[dŽK\ÈmN%ó xù™\ãi–@uB?7‚[ÿ\0Á>ü%\ãÏ‚º|V\Ú÷‡`Ô­“n‡\ãM\nGòu„wb\ä,Hß¸•\rŒFqŒ Cò¿‰¾\"|Ný›¬u„:\ã@—ú=\ÜwšUü7L\×:,¬™,çEš6ù‘¸Ãœ¨%³\îW”sY(\áªr¸=¶Ûªôü6\ßy^\î\ç\Ðþ\ØVÿ\0²ÿ\0\Â\ÛÏ†6\ZŽñRÑ¯\Õ4{ø•n4ûýe•ò²(‘—h\ÎQÊƒŸ	øuð\ã\íuq§\Éedl|)`mc}¨!\Ól`ó¼‹rw<Š¬H\n»\ÈÀŒf¾„ýÿ\0\àj\Ö:WŽþ*+OÊ‹»?Œ§\r—Mœœ›\Ê«¸ý\ä¯\Ð\ë{k=LŽh!±°´ˆ$pÂ‹QF£…P0@:WŸˆÌ¨`%(\áW4\Þò\é/\Ç\Èv¾\ç\Æ\ßÿ\0\à–ü93x\ÇVÔ¼az9’œ\ÙZm¨Lž\Ùó}}\á\ß\Ù_\àÿ\0…`ò´ÿ\0†þ#\0o¼\Óãº“ý¹C7\ë\Íz„\ÜÇ¾\'Y%r§8 \à¨<W\'ñsR¹Ò¾\ëwŒR)c½B»ª1ð5òX\ì\ß\Z15j6¢œ¬Ÿe~šXzµxPZ94¾÷c‘ÿ\0„\à‡‰5ItøD¼yy°\Å\ä\ZF9T/Šr1\í\\gŽ¿\àžÿ\0¼m†?\Ëá»§ÿ\0—­\n\é\à#\én‹ÿ\0¯/\Òfº·\Õ,\å²\ÝöÄ™\Z\r½w†qø\â¾á¯“\áž&\Æf±«)7¶n\Öw\î÷V\×ò>‡>\É\é\å2¦©\É\ÉI=û«~\ZŸ–Ÿ\Z¿\à—~0ð…¬ú—€5hüeg,\Úm\Âk\å^¿/;%\ã\ÝI\à5\Âüý±<AðC·ð_‰¼\re¬?†n\'¸\Ñá¿\ì®4\Ë\æY´\Ê÷¸ó†P\ãqÃŽ1ú÷¥·\Íh¾UR[o!HÛ•\'±ù”\ã\Ð×Œ~\Òß²Wƒÿ\0i\rÎ¡\é^)‚2¶Zõ´c\ÍOD”\ËXóü\'‘“´®NP\ÃgQ\Ä%G¹£\Ýn¾\ï\Óñ>U\ÅÅžKðU¾øoáŸõ]O]›[´\Ôl—Uñ§Ä«;–·Š\î\îFY?³\íß‰B…cÁ_0/\Ë#\í_—> ~\Ì~;ý¡?\á*ø§\áO‡¶^ð}­ª¾“¢4fº¿¶‰@Y.c‰ùCpy\É<NŸ®x\ßö1ø­ÿ\0Ç‹´{]z\ËL¸kø4]JG—L–vB\ß\Â1‚F\r·wN\Ö/ÜŸuO~\ØZ\\^øm|4‡·‘F\Þ!ñÄ‘È°\ß6\Ð\Z\Ö\Æ6;\Ù>0Vaóoô\å\í05UjrN3×™ì–W\Ó\îKv-$ˆ¿d_\ÚSVø=\â\ë[F¹W¶eh¬\Ö\ê\ãÉ€±,\Â\Öi0vA#±\Ã\àù0”¦h\æýŽðŸŠ,<i\á\ë-gLwkK¥8YP¤±:±Y\"‘)\":²:U•”\àƒ_¶\ì»À\ÝB\Þó\Ã:n¸<#lc\Ò\ç\ÕõÆZ÷P*ò;Á\n\Æ¡W~Ý¥”\àž	ú+þ	³ñ\Â\ËýOFÕ¯¯$Ô¯…­¤«5Ûµ¸x–AÈŒü¨ò©[ycsCfw•ˆ\Ã5\ÃS\ÄRX\ì>\Ý\Ïü\Â=™ú#EWÈ”QE\0QTu\Ýj\Ó\Ãz¡«_\É\åX\Ø[\Éu<˜\Î\Ø\ÑK1Ç°€?7à¦¿Mö¼¾\Ó\î·E}\ÕN0$\×$Ã«¸´Œ¨öw	\Æ\æÏŽ~Ã¶\ßµOk\Ú/\ÅøaiõH¢‡J“Q-\rša‰|Ì¬\Z9\ä\ÚÄ¨Àa»,ó/\ÚS\Äwž!ø½­\æ\ÍÍ‹›k„WÞ©tY¥¼\nºn¥¹`;\Å~‚ü½øAñ\á-¿ƒañ„~)K§\ØGo¢\è>$±J¾‰Âñ‰YXðñÇ‘ÝŸ9¯¼”~¥—BšO\ÞÕ¸\è\×]öû\ÚÓ©\È\ç>8|1ð¯\ìk\à]SUð×‰\ï \Ò5¤d?¼Igý¯¤j\ÎE\'o”À}\å\Ë\á	\ä)Zñoø\'\ï\ì\Ãÿ\0»Æ“ø÷Å°›¿hw\n±Aq–[û\Å•z\Ç\ÚXQy…s¶©w¨xÿ\0Ã¿¼7£kZ\r†’\Ñ\"x_Q\Õýa¿¸ÀE‚A$Ÿº1´[°\Û\æ?Ê™\"¿S~\rü0±ø;ð³\Ã\Þ\r\ÓJˆ´»E‰\æAþ¶cóK.v‘™¿W\'<	{×©W®—\åùyy¿]»-\ÍñcÁvþ\"mo\èñkJþY±{\è\ÖPý6m\'\ï³\×Úº™HŒŒ2¬0Gµ~9ø\ë\Âú¿‚üa«hº\ìrG«Z\\2\\I%\Û9ß“÷ƒ7pÀ÷¯¸¿`¿ŠZÏ‹¼¯øU’[õðù…­.$b\Ï\åJ$\ÄD÷\nc8ölt¿:£Šu\'\É%c\ã²\Î!x\Ü[\ÂV§\Ë-mò\èÎ—\à–½­ø\Ë\àÏ†ü_\áÛ•—]‚\Û\ì:¦Ÿ3nKÖƒ÷{›ž%(¨\Ù\àÀf»ÿ\0üRðÿ\0\Ä(e\Ð5H$\Óu¥kiln‰W\Ç_®z\nñ\Ïø\'…\ä’|-ñ£–e¤?Þ† Gþ9ú\×\Ð^\"øq£xV´\Õd‰­uKYRd»·!YŠT0\Æd~8\"¼™\áqI*\Ø9&¥ñB_\î\×fþ\æõ~u‘fqy}®§Ì¢­5ñ&»÷W^«dq6?\n¼1ð®\éüI«j3\\\ÛÚ¸6\ë4|#“òœ/\ßoN\0q\ÆE›k¿¯\Z\×\Ã\ÐÍ¡\è(\Ûnui\0ó\Ør1\ÑXúŒãƒ‘\Ð÷~&ð~›\ã­a\Õc{‹ky<\ánª³`€[œ{÷\ç5©geo§Z\Çmkv\Öñ©JTz\0*i\å2£Q\ÐÃµK»Q¿4Ÿ[Ë¢é¦¾ˆ÷\'šF¬j÷©_d\ånX¯%\Õú\é\êy?\Â\ß[\ê\ß¾!hZ~\ÕÒ¼/k§ið*¶\ì\Ë\'Ÿ,\îO]Å¶«z˜Á<×¥ø‡\ÅZ/„l\Åæ¹«\Ø\èÖ¤\í\ßÜ¤O ,@\'Ú¾]ý‰üDú\çŽ>4j’\ëSŠô| rò\Ý1\\cjø\Û\â‡\Ä\Ýo\â×‹¯5ýr\å\å–g>M¾\âcµ‹?,QŽ\Ê\ærNI&½H×\Z1\å]\í\Ú\Ç\äøŽ x\\q\\ó©)\ÚþR{¿-=O½?jo€¾ý®¾ùþ\Ô4û\ïi¾d\Ú.«i:KIž\Ý\ÝI\0~V\n{9¾\0þÔš÷\ì\Ãÿ\0	-„\Ú$Ú¾»Ma¥Áª\ÞL¶ú4¾i7?\èùÁ,Ás­”\ë‚Aû«þ	\á\á}cMð‰õ»±$Z>§qvQ¹8vˆH$‘G¦]W#©B?†¾cÿ\0‚“ü\'ÿ\0…cñ\ÃIñö•k\ØxŒ™\âWˆ_@W\ÌÜ„`‡SG\ÌLy¯¼\áüZ\ÅSúž!^2\Õ/5\Ó\Ñ\ï÷÷>‹‰ž3L£\Ê\ä¶þ»\îs~\rüOý¶<K{\ãŸ\êÚ¸ð­’³Ï«‹7FI·°¶Aó¶F0‹…\êr\ØVñ¿‡ú¶§ðO\â\äQj\âÿ\0@–\Þ±j\à1\ÝZ£û\å\Ç\Ä\Û\'#‡Š3Ú¾\Öø}\á?\ÚöŠ\Ðt\ëm¾ø_SLiZnŽM»y#…òá“+\ÇËºB\Ø\ÇlW\Îÿ\0¶\ß\ìßª|ñ>ƒ«j1¾ñ²ø–)X\ê:²º\Þù\Ðyk “{1e\ÃÇµ‰\é\Ç`O\Óañ©VXZ’š²Š¾–\Ý^\É\Ã\ïMQú\éð\Ï\Å\Ï\ãŸ\é\Z\Ä\ëwò\Æa¾†Ù·G\r\äL\Ñ\\Ä­““$‰œœ\í\ÎOZ\é\ë\ä¯ø\'O\Ä)<]ðº\çNš\è\Ü\Ím¥\ï–:[\Úúý\ç}>K†8\ä\ÝÔšúÖ¾µ7F¬©¾ŽÆEV\0\ç¿n­\áøQ¬\Ú^:\Åe«Ik¢\\H\Ä\r±^\Ü\Åh\çž\ág${úW¡W’þ\ÕP\Ü\Íð7\\kD\ßqÖt¹Á\Û\å_\Û\È[ž8O\áW\Í$†·?þ\êZ‰¾?h:¯®­\í|?u®¥þ«%\â³\Ä\Ñy¾lˆ\àHnTÿ\0½_ª\èÿ\0³\ïÅ¹(->øš;‡À6\Æ\Þ\Öö(ú`\r!`ªv\é\Å~\\þ\ÍwŸ¬~/iüT\Íðb$¿iC²)r„FYbù\ÈA\ã=:_£\Z\'‹f›\í6K_‡Sü\'´\Õ\ÌQÃ§/ˆ´q	3o;Œ’HGx®\ìrw_qœEûHò©«-\×\Ã÷÷3‰òO\ì©\à+\Æ?· ŠÁ&›Ãº.­¨j‹<#¬\æAk¹˜’v·‘\Éô¯\×jü¬ÿ\0‚VF—ß´7‰\ï%)\ç/‡.S\Ú\ê\Û,=1\Óþ_¨šÖ¡q¦Ø´¶ÖŸl—²Ø£Ýˆô¾ˆ\'lJ‹zF(q\ÛC˜ø‹ð_ÁøJt}NXØ®7<S\"ä¢D*\ÛrIÛœsÒ¼\ËBø±ð;ö}\Õ\åðFu›3Kº\ä\Ù\Ã=\àó³€’J7³?m¼\í\äqÒ§×¼+ãŸ†[¿ˆ\ÚG…ôV8—Ið™72&>e’\å\Ê0<pHê¦º…?³?€þH—ZF–o5eþ\ÔÔ˜Mp:ý\Þ§‘A#®k\ã£/lù\è¥nÿ\0ðÇZŽ\'\ë*th(>²š÷šòK_½¯Cµðßƒô\rÿ\0l]h¶ƒO}j\ä\ê%P®fdU/°” ‘Ž¤“\É5ò+\Ãoop¿ðŠ\íWeVal7\0H\rŒ÷úó\Í}³_\Z~\Õß³_\Â\rC\âü&¾<ø•ªø\ã]*ŸgŠ\æ4†f†4F1ƒ \í	œç“žø¯£\Ëe\ÍÓ”S¿xó}\É4{ŠŠ´U\"ð\Ï\íûZx\Ë\âgˆü£ó\Ä\Ú\0f¿·ò-cDUuBUÝ€a—^žµö\Ç\ì\ï¨|O¾ð/Å­*\ÛMñT7R ’\ÎX^;ˆˆ˜… –R?\Ù½~pþ\Î³„>8|yø…\áý+\Æz\ÊøsEV›M\Ö,%O>\î3(Ugb€PM}\ãû?~\Èö³çŠ¯õ­;Æ¾\"\×Vö\Ï\ìsYjÒ£\Â@p\Ê\ã\ne;€ç£·­{ª\Â\Â>\Ê<±•“\Ò\r?¾ÿ\0…/ˆ<yð\Ûög\Ó~\Éy\æh‘\ê7]…†\ÊiZ\êf;¤c R|Ã«p0\0°|7û=ü\røŒ\Ñø\ÇEÐ¬uk{¹~\Ð\Þ\êao¼\ÅZ\r\áT‚yŒ¨\ÇB½«\Ø|O\ám\'Æš-Î‘®iðjzu\Â\í’\Þ\á)ô#ÐŽ\Är\"¼\Z?\Ù.O‡:Ôº\ç\Ã\ê•Ž\é¬/”]\ÙJD`H;y<¶ò3Á¾qiü)\Å~‹‰¡W\ÚE{Ô¤¶V\\\Éù_GøDY\ÙÁ§\ÚCkkv\ÖÐ Ž(a@‰\Z€ª£€\0\ã¾_ÿ\0‚“x-<Uû/êº†\Õ7\Zõ®£®ùÿ\0vr\à?Jö\ï‡þ*\×õKsm¯G¡\Þ\ßD\Û$»ð\Õùžy\Ò@­û ¿Ö¹\Úö\Ö;\ÏÙ\âTrÊº,òqó(Ü¿¨\êåµ—\Ö)T¦ôºü\Ïj\Î\ÖqkÉ«3\ã?\Ù\â\Å\Ýsö:/„¼\à/Á¢\êOcñb<wvð2‰U£GR\Ï \nñ\äm#v0’~Öž\Ö[G¶ño‹¾:øo\âg‰¾Ò–k£\è÷q\Ê\Ö\Ñ2³³ª!2\à\â0\åúW[û\ë\ß´\rø¼üI¸ðzš¦8|Oi\Åû\ÌS\0Â®~h€p\nNH\äf´k¯þ\Ì:\Ç\Ã+û†öZAñÌ“\Ã\åO¢\é3\ÚDŠ$\r\'UXÀ*Xn\ì=+\ï#z9ƒP¦\ì\Þ\ê+¯y~b\èz—üfHo<\ã\r¶\ê\Âô\ÇWŽdB€û+A&?\ë£W\ß\Õù\Ñÿ\0ƒ‘\Ù>+\ÆX\ìS¥0_B~Ù“úÊ¿E\ë\æsxò\ãª%\åù\"£°QE\ãŒ+\Ìÿ\0h\Í1µ¯…7v\n\åÖ§¥B\ä1Q±µ`\àF© žÀšô\Ê\å¾*xf\ãÆŸüU \Ùùk}¨\éw6Ö¯ \á&h˜DýF\n¾\Ö#‘U\Ê\Óø«û(\éþ¼ý¡¼\'kñû>/\ny·nþØ˜Clm¥1	Yˆ\0y¢>\àžA\"¿B|Eñ{\à\'€\ä/\á?ˆ~ðe\ÌÒ´šÏ‡ü6·\ÏpB…A—¹PCNF	;¿7ükc£øo\ã\ÕÙ»¶3ø]µ˜\ï\Ö¾n3¬ñŒ`º	\Ðó_uþ\Ñ?d\ßxV\Ã\Ãz•\×ö…¾“vn­-<¦‹vŒ*PHUb*\Ù…a’ªx\Å}\îaO\ÛÕ¥;M\ÆK\ìÙ®û4\×S8\èxGüO^¶ð\ï\íXút7xu]*÷O‚]¤y¡JN2¶\äò~·W\á…þ(xw\á\×\í¤x\ÛÁšu\î“\ám7V†\â\Þ\Âò_6\ámxYQ›\'%”\É\Üý\îõû[\â[\èþ¹ñ“Goöež\Ù\ã;£”><¶\È\ê§rœŽ\Õó\ÜMl<–.¦‘\å»ò¶¯ð5¡NU§\ZPÕ·eó ñw\Ã]\Æ \Ëumö{þ©}mòJ\èIþ.ó\íŠ\ä<;¦üDðwˆR\É\Ûþ]œy\ÓÎªÊ¤õŽ\à\Ãû¿0\ì=G‚k\Þ,\ÕüMxnµ-Bk™7nP\ÌB§ûª8_Â¾‰ø«j÷\Þ–\çS’k¿.y«\ÎÄ³\Æq¸õ·\0O¦;W\á˜\Ó	f¡NT¤µ\æ‹Z¥ü\Ê\Öü\ÏÐ±™~+)ÀÞµHÔ‹Ó–I\è\ßò»\ßò=.¼§öýžt\Ú;\áôþ\ÕÀ¶\Ô!\Ý6—ª*\æK9ñ€\Øþ$<^\ãÐ…#_\à\çŒoüo¢êšŽ Ë»\í\ì‘Fƒ\ZlBzõ<ŸZ\ï\ëôl¿«Ó†3Ú¾«¹ð¸¬4ð•¥B¦ñ\Üøgþ	\ë\àà¿Œ¼u\ào[\\i\ãuóR\ê@`½°F%&³;A(I\Ëd’p§Œ¿sW˜ü`ø¤|ZÔ¼;­‹\ë¿x·\Ã\×is§xƒL\Ú.bMÀ\É	\Üx\Ýw\r¬\èAeoN¯_]b¦«\ß\Þ{®\Ívò\Èr?uOXY¢xcIK\Ù\\÷\"þ\ëè„\Çß§±®_Ã¿¯5©#\Ôüs¨O«]\çz\ØO•{qø.Žõ{\àŸµè·‹©\"µÅ‹¢}¡xóCy£{\çóðø›\ÄrøŠ\íµ-B\î;øfu(³2ˆ˜€Ò¿%\Í3Li\Ñ\ÌjFuaSh·h«oum_kß©ú[—\â\Ü\ê\à)¸Óœ7’W“¾\Öw\Ñz[¡ö\r¾Ÿm½¬\Û[\Æ0‘BUG ¥x\'\í\ë\â4ð\ß\ì£\ã©¢9¯!‚\Æ%\ÉÌ³Æ¬ü\0¹úô­€¿5O^\\\èz¤\Ízb€\Ï\rÔ§2\0T«\âûÀ‚y\ë×Œ|\Ãÿ\0`ø hþø{m03\\L\Ú\Õ\ìc9T@\Ñ@³˜\ã\Ö1_¤ð\Æ*–s*5°\êÑ¾Ý¹wG\Ç\æX*¹~\"T+;½\ï\ÞýNöñ?†>øZñŽ|U{¡øgPÔ»\é’xu\î¬/Lq.Ö’\ë\ìò \Ê\Ã\Ë­\Æzt¿nü4ñ/\Ãy\î>\Çð²\æ\Ö{˜®t\Ø\Ò?+n,\Å#XÔ¬.‰\ä7½fþË¿µ§\Ãƒ\ßað•\î¥\â\Í?Xº•\æ\Ô]¬ ¾°\ÜYò±F\ï\Â:VùA%{u¯2ý²¼uðK\ÇRxnÿ\0\áF\r†«)™õ©­\ìd±Œñ–$ù`’e$¨\Ï$\æ¿GO0u%	-w\é§}\ÉÝž]ô>“ÿ\0‚E\ém†þ$\êE@[›»+uny1$¬G\á\ç\Ï\é_ \Õð\ïü\ï\Â÷z_\Ã\Ûû\ÙU¾\Åp‚\êR1\ç\Í,‘Ì\ßpŠ\Î\ÍÀ\àmœwq÷|¶i?i¨\×{}\Ú¶\n(¢¼¡…Q@Žß·÷Áù~üPk\ÈÄgq$‘¤²¾\çh™Œ\Ö\ç;cH\äkHÁ9#Oc\ÇJùb¿e?n¯\Ã\â§\Ãy.\ì\àV¿ˆ$¸þ¹¼Ç1®UŽ\Øá¹ºnµø\áuk5\Ô\Ö\×0½½\Ä.\Ñ\ËŠU‘ÁRB\Æ+ôœ—«\á”ñ\Ó\å\Ð\Îk[‘W\êÿ\0üã…—\Å?ƒoðûZ™.u¿\rDmÅ½Ánt\æ8€=Bg\Ê#\0G\Ï\Í_~j_4mgZšþG\Ól¤ºYe¦žò@\ËqA|\î^gH÷p “\É*EføÆ¾-ýž¾(Ykv0\\h¾$\Ñ\æýí–¡\ÆH#\ç†h\Îk)Á0pkl\ÇO2£,=ý\åùÿ\0[Š-Á©#öº\ß\àOƒ­\ïM\Çö|’®r°I;˜\×ð\ÎO\âMw_gŠ\Ö\ËÉ†5†\ãÚ‘Æ¡U@\0A^aû;þ\Ñ\Þý£¼³ Î¶Ú”*«©h³Hö2‘\Ðð7!\çl€a‡£Uôû\äi,\î3½£`»z\çb¿†]G-s…**\ëd—õ\äz5±˜ŒS·¨\ån\í³\Äü!\ã}\àÁ1\â?]}š¹\äš(fiÜ©kÜ‘{\0I\0\\\'‚µŒ\ßüw£kš¥¤\Þ	øqkw\à\Ó÷˜žñ·*7IC|¹\Ü29=}£Kø3¦M\â+]{\Ä*š\Íîž‹‘g(\Ýi¥Ä¸\å!\á¥8RÒ·$·h\0Vw\íM\â\íOÀÿ\0<Qª\è÷-g¨ˆâ·Ž\â2C\Æ%™#fR9\rµ\Ûrj\à\Âa^	NŒžŠÛ­·û\Ù\âg5j\ãq±õ\ä\ãM7.U»K_yö·Eó}_´gƒ|k\âo\r\é·ÿ\0µ\ÓüS¤\Þ	—eÏ“öˆJ\Ñü–ò\Î\Ù>_”þ<\çÁ_\ÚJ\ï^×“À\ßt™<)\ã¨\Æ\Ø\Öt1\Ã\èS=\ã %[S\Î\Ñð\çÀ_ŠÚ·\Â\ï‰\ÚF§m{2\Ù\\\Ý\Ç¥o¸²\ÜBÏ‡Ü½\Ø%Ocø\×\é\×\Ä†žø¤\r?\Ä\Zz]¬g}½Â“\Û?gŠAó#N¸\ç#Š\è¥7Yº\Ñö\è|\î]Œ–h\å‹\Ã7	+)A»\Åö\é£óò\Õ3\á•ýƒ}\ã\r8†Q™S9>[((\Ånø³á—‡¼g/Ÿ¨\Øÿ\0¥\ãoÚ c˜÷#†üA¦x\'Ãº—‡®.\ÓT»:¥\ÃCCRØ¨\×+p¯(%\ÚÊ­”\ì1¸ªô÷—–úmœ÷ws\ÇkkoK4ó8De™˜ð\0\0’OLW>/¥õE„­(¦ôjús;|\ì~‰[0«<O\Ö\éI\ÆM+ôw²¿\âq+£ø?\à_…uŸ\\2\éöV\Í=\î¡r\å\ß\ËQœ©À\n£\æ8\'ø¥ñ\ë\â\å÷\Ç/‹ ñ•ò´Bþ|[[œ~\â\ÝØ£ãŒ„$ulžõô\í\áûeÚ’ø3Á\×n<c ’{”©8\ä1\ÊC÷Tõo˜ô]¾ð{ö|×¾6I}g¢_iöš\Üv\Éye¥\êM$2jP\Z\'xaS±\Ô¸€\ã±ú¾C•Q\Éð\Þ\ÒQP¿KZ\Ëþ\ïñ\êy\Õ\ë\Õ\Ä\ÍÎ¬œ¤ú³\Ë\êÿ\0‡ô+\ßk\Úv§Dg\Ô5˜\í-\â\Ç#°U™\ÝoG¸ðþ«s§\Ý=´—\íµ\Ú\Î\ê+˜\Ê\Ë28çª’+\éo\ØW\à<ÿ\0<}¡ulÍ¦n’\×\Ì<(*ý²@q\Ú)‚^ò7_õm§\Åb#‡¡*Ï§ôŽt®\ì~š~\Ëþ²ð/\Â), Xc\ÔU/‚2\Â\"ŽYOÝ\ÚÁm¼}z\Í\"¨E\n *€AK_’JNRr{³`¢Š*@(¢Š\0†ò\Î\rB\Òk[¨#¹¶\Z)a™¤ˆ\Ã¬§‚$kòCö\ëý˜\îþ\Zø\Â\ç]\Óc¸»²™\r\ÄÓ°,f‡pQ98û\èY\"—$’LR–&vXÿ\0]k–ø‘ðóMø›\á{QQoš\Þ\í#G’\ÞL¹C‚¤,ŒŒ\nº;£®ÀúdðU•H\í\ÕwA¾ŒüOýžþ8kŸüL±Xx‚\ë\Ã\ÚV¥<+ywl¬ÿ\0g\ÃmûCD¤y\ÞZ<„FùBH%[>Á«|&ÿ\0†„ð¿Š|b\'²ðÅ¶“\ËfÚ…\Ä7W—N‰3M=\Õ\æõi¡–H,\ìŒL²\ì@±¡®#öªý—µ_¾)¸’\Þ\×v\È\'’8Ieµ\ËÜ„’\ÍfP®Ü©a’\Øgó?‡ÿ\0ŸÁ^dz&›\â]2[»k\Ù4ýY]¢i`YR\"v0%Ug—\ä\'i%K+¿A´11ú\Îû\Î\ßðÞ¾¿©ž\Ú3?Á>8ñ?ÂŸYxƒ\Ãz•æƒ¬B\Ãs\ÊY8*F«§¸5úUû=ÿ\0ÁL¼\'\ã;[M\'\âDk\á-{ˆÎ§\Z³i÷\rý\ãÕ¡\'Ñ²£\î+\ä¦\Óü7ûCx\ÓÇž(ñ‰/,<7¢\éRZøyn\Íw¤A\Ø0¥Å¼o#e‘<Ù‘r\ÅyŸ>x£\Â:µ½´:Mü\âñ¬b´·x\Úeš\ê:;tAÌ² ù_`!_\npHŽ\'…\Ì=\Ê\ê\ÓK~«\ç\Ô5[¹úF³a\â\r:\rCK¾¶Ô¬\']ñ]YÌ²\Å\"ú«) ¥e|@ðNŸñ#Áz¿†µ@\ßb\Ô`0»\'Þ²\n:û«až2¢¿ü!ñ\Æožo\rø‡Wð\Õ\Ë\Þ}‚\êK}ø\ì\ê8\èA\é^ß ÿ\0ÁE¾:\è«\ZK\â›]Z8Àoô\ËrH\êÈŠÇ§RsÉ¯š­\ÃuµT¦šó\Óü\Å.Z‘pšÑŸW|<ýüC£üH°»ñ«¥\Üøj\Â\én	·.\ÒÝª6\åC\\(l\0\ß1À\'\ë_rW\ä¥ÿ\00ø\Ý}»\É\Ôt}?+öm1¯\ïsúW™ø\×ö¼ø\Çñ9\"\Ö> \ëDƒkÁa\"\ÙFËŒ`¬Æ¹°ü/^žœ\É\'\êÿ\0C\ÏÀ\à0\Ùte:µ\ÝûŸ­\Z?jÏ†\ß\à•<I¯\Å.¬£+¢\é\äOx\Ý1”\ä\Îz¹Pkóö›ý·¼iûD4úDgþ¿y™M\ÖBZ\àò›‰8ó9\çhA\Ç€\Õ\ào ê­¥¾¯-…\Ø\Ó>Ð¶Ï¨</ä‰™w„/Œn+–\ÆrG5\í\Þø_gð\ë[ðÞ±­\Ú\Ûxš{\ëÛ¨´\Û4;¬\ïü¨\í¥ˆ\Æ\ÅN\áqÄ‹\å\ÊÌˆxu¯¦\Â\å˜\\¾\Ó~üúÀ\ìz:\Èóÿ\0†ÿ\0\rou\ë¨õ‹\í÷R\Ð4ø\ÓV¾²¶\Å\æ›\â+©-\Ûn\Ö\Ørƒ•\É8Â±_\\ý¡µ­#\á~½§\ØøS\Æc\Å\×6PCq£\ê[<7ú=¼±,‰l\ÒyB«W‚^ibª—Y0¼}ñ\â}/Ã£Ãº¼\ÚÛ½\Òß^{l\É\ÆöWl£n/D~lS}\äa\åd»\Æx¾\áýOÆš\Ò\Ùið‰\î¤\r#³2\ÅQ¨\Üò;±\Z*‚K@\í^šŒª\Ë\Ú\ÖvŠ¾Ÿ\çøë¦¶ˆ·\à?\ß|@ñ-¶‘b\no!§¸ò\ÚA[€.UAf9`ªŠ;2¢†fPkÿ\0f?‚_~\Û[%›Y\êwpÄ³\Â\ì¬\ÐD…\ÌP’¼I$s–Y¦*BlUò\Ø\×ö=²øK¤\éž!\Ö ˜kKþ“\çš–FGO6x‰\\\"£°Š]Ë¹¤	Yc·úÞ¾+6\Ì~¹?gO\à_™q\\¡EW\Ï(¢Š\0(¢Š\0(¢Š\0\æ|}ð\ïDø•¢7Z¶óIh.#À– ‚TA­†I²:º3)ü§ý¥?b?|9\×&»°\Ó\í\í¬î¥‘­š\Í\äm6eó¶F‚i-g`\Ñb\ÞfÃ¼ –f\Ê/\ëõTÕ´›{K¼\Ó5;;}GM½…\í®¬\î\âYaž\'R¯£YIHÁƒ]øLmlù©½;ta¾Œþ|MkÀú\Ý\Ì·Z>§k{›i£1¸\Å‘°\ä…`÷\îkð\ã\Çú>½\âþ9-\ïe\ïšv2Àn¥g¾ºH\Ï\rr\ë\å mÊ»\"+Œ¹qúñ\Ãöð‡\Äo\Ý\r\Ò\Þ\×R†)\Z\Æ\ÏPwkU‘œ¾Å™Až\Ý9ØˆŒ\ÐD¤·}¡O\Â?¿`O\Zø7XKK=7Uv™%’&·±ŸV³}‰K«HYÁùÊƒsoj‘\Ân\'\ìi\æ˜,l9+û­ÿ\0[¢9ZØ“\à/|«\ë°ø‘®\Çq\á\Z\ÞW¹\Ñ\ïQå·›S»»™T4dªŠ®\\|ª\àw\àü\rø?\á\ß| ø¯­jö–Z…Æ†$KK‰%•\n\Ú]:²Ê’\ãD„ƒ ur<±‚á‡˜_üøeuuo†o5i­nSF\Û~\Öü\ã÷«s\È#k… ‚b¹mCÁúþÎ·\Ú&¥dQ¶0¸´’<7¡\È\ë^¢§\nœÎ]\í³\ì\ïÓ½\Åw\ÕS\é~Zx\Ò\Åõ’¾\Óõý~=zK¦’\ß\ìöñ[Yý’\0þc\åVyö‰0Œœƒ\\Ö½¦\è~	ð2‹)ü&\Ï\á«u2G5µ¬÷:Î /¦·¸‚GóÁŠKYVe\Ú\Z=ˆ¥Yšù¾=>ò\éœ\Çm<¬†\Û6p}\ë~\Ë\áoŒµ6¼·ð®³%ŠŒ½\ß\Ø% õi\n\í‘\É=ê½‡-Jºyüÿ\0\Î\ßp_²=o\Å|.\Ö:Ñ­´›gF×µ6\Î\Ð\ÝI6¿gb\nÉšJ¬\ÊF#aó9ñ;¯\ë7¾±ð\ÝÆ£4\ÚÄ·v¶R¤2\ÈH\Ë\ÜnØ¹3\Î2Mz7f\Zøò;;›\r:\æú\Â\îu¶‚\çD´—UŠY…)ö‹ukhŠ“ó}¢h•\0;™q_büÿ\0‚j\îK{ÿ\0\ÛË¡˜•¾’\ÞóQ\Z@Œ°\'›gùb\Þ=òº;)X˜nU3\rYK™ùk\å\è”·>øoð[\Ä5&;9¡·\Õ.M­”¾Qi/e\nY£¶ƒ+*©,\Ù\Æ>i^$\Ç\êG\ì£ûi	ô=/Yñ_¬‚\ítÿ\0<8‡1¦F)<\É\Ãm\Ã…1‡x\ÅÄž\éð·\àÿ\0†þ\è\â\ÓD¶’k\é †\Ýjù„Ú†¡\åg›\0°]\ïµ\0\Æ¬h‰…µ|Ž;5­Œ÷W»\ß\æZIlQExƒ\n(¢€\n(¢€\n(¢€\n(¢€\n(¢€\n(¢€\Ð\Æ\Ó,¦52ª•W n\0H\Ð\í¢HRd(è®‡ª°\È4Q@\r†\Öu\"(£ˆHE¡½\Òlu&…®\ì­\îšDf‰\\£Œ¹qEnŠ( Š( Š( Š( Š( ÿ\Ù','National Mission on Financial Inclusion - Awareness Level',NULL,NULL,'f98674d7-8a2e-4b6b-9169-0fbccd9626e9',NULL,'2024-02-14 06:22:23.076000',NULL),('585748b3-215f-41c4-b6b2-7941ec6db3aa','INTEGER',NULL,'Poultry/Ducks',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:43.122000',NULL),('59fb0cdb-874f-4109-9bec-2f84ce6c0ca5','INTEGER',NULL,'Uncultivable Area (in Acres)',NULL,NULL,'dc34817f-ba0b-41dc-9157-d447448c6796',NULL,'2024-02-14 05:47:37.381000',NULL),('5bf383b6-a5bc-4836-aafe-1c9a5d79859c','STRING',NULL,'Problems',NULL,'73956663-9121-4667-bda2-265c7287285e','3937d505-24d7-4d50-bd67-a986e643244e',NULL,'2024-02-14 06:00:12.743000',NULL),('5ce7fb31-ae67-4bce-9327-19e836301d58','INTEGER',NULL,'No. of family members',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:24:37.936000',NULL),('5e5eed86-c402-410d-b363-b978608051cf','DROPDOWN',NULL,'Open Well (Public / Private)',NULL,NULL,'fed067b2-16a5-4571-8e61-d9519a789fdb',NULL,'2024-02-14 05:25:00.013000',NULL),('60327e37-867d-45c8-9967-493bc5d7f266','INTEGER',NULL,'Electricity Availability per day (hours)',NULL,'0a957429-b14a-4c10-a3d9-3e100ce83c76','3f74f505-5136-45dc-a337-f7347fb711b7',NULL,'2024-02-14 05:40:37.847000',NULL),('6151e7d2-65f4-43e1-9146-5992b06dc866','STRING',NULL,'Why are you not using the sanitation system',NULL,'14f3f571-e7b8-4acf-9890-5bf725d1eeb1','25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:32:46.337000',NULL),('61efb724-e89c-4211-adea-259f42603027','INTEGER',NULL,'Others',NULL,'5ce7fb31-ae67-4bce-9327-19e836301d58','1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:25:53.027000',NULL),('64f7a260-0ace-4a71-b0c0-f8263e7e9522','STRING',NULL,'Nature of Disability',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:19:18.339000',NULL),('65861d0a-4db1-4cfe-aea1-013464c7a66b','INTEGER',NULL,'Barren/Waste land area (in Acres)',NULL,NULL,'dc34817f-ba0b-41dc-9157-d447448c6796',NULL,'2024-02-14 05:47:12.981000',NULL),('66309b80-898b-4ae1-acf5-b716365512a3','DROPDOWN',NULL,'Piped Water at Home',NULL,NULL,'fed067b2-16a5-4571-8e61-d9519a789fdb',NULL,'2024-02-14 05:23:48.882000',NULL),('66b66a4c-d3a9-46c3-bf09-c1673759c183','STRING',NULL,'Address',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:23:04.695000',NULL),('679dc64c-b7bb-4821-905f-53ff7dbac7a2','DROPDOWN',NULL,'Type of system',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:37:05.214000',NULL),('67b31d07-26cb-4fbb-b9b2-aeef984d30f4','INTEGER',NULL,'Un irrigated Area (in Acres)',NULL,NULL,'dc34817f-ba0b-41dc-9157-d447448c6796',NULL,'2024-02-14 05:47:23.239000',NULL),('6b17fbb6-742b-42d9-92dc-9bf9000e7212','STRING',NULL,'Cleaning period',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:37:36.616000',NULL),('6c641d8d-b25a-471e-a710-dbfb5e909a1d','STRING',NULL,'Aadhaar No',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:58:43.419000',_binary '\0'),('6dfda638-c271-4bb4-9ebd-ee31267f7a9a','STRING',NULL,'Gram Panchayat Code',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:38.692000',NULL),('7082055e-d2f1-4ae5-9d36-1a9b8aa14820','ID',NULL,'Survey Id',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:00:33.692000',NULL),('7124b5e6-f9ee-448a-8501-d2e9602d1535','DROPDOWN',NULL,'If LPG, Subsidy',NULL,NULL,'e0b34e9b-0c48-4319-a318-0d3de5690d99',NULL,'2024-02-14 05:44:56.105000',NULL),('73956663-9121-4667-bda2-265c7287285e','COUNTER',NULL,'Major problems in village, if any (Top 3)',NULL,NULL,'3937d505-24d7-4d50-bd67-a986e643244e',NULL,'2024-02-14 05:59:40.444000',NULL),('73ab11be-420a-4bd0-8137-f453258731dd','INTEGER',NULL,'Ration Card No.',NULL,'8ec10b8f-529d-40a0-8a30-2307dd010345','1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:46:12.921000',NULL),('7453fe3f-c790-4618-b33c-dcb440b14d45','DROPDOWN',NULL,'Community Water Tap',NULL,NULL,'fed067b2-16a5-4571-8e61-d9519a789fdb',NULL,'2024-02-14 05:23:57.136000',NULL),('754d63e0-c153-4f7d-b8b3-2bbdd236315f','YES/NO',NULL,'Does any member of the household migrate for Work?',NULL,NULL,'aafb2a2e-29cc-41f6-884e-8f6b6a886dae','4205334d-1d67-448c-98ae-33f3e3e293e3','2024-02-14 05:17:06.229000',NULL),('76666ba4-a81b-46fb-88f0-0d1e1ff71148','DROPDOWN',NULL,'Details of Phy. Challened (Y/N)',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:18:33.299000',NULL),('79acef1c-1027-40be-a853-ced12182bb7e','STRING',NULL,'Relationship with Head of Household ',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:16:48.692000',NULL),('7a849534-ee63-484b-bff9-fff7249f7eff','INTEGER',NULL,'Bullocks',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:35.040000',NULL),('7b9a82c1-501c-4b42-988c-882a55299147','INTEGER',NULL,'Fertilizer Use (Kg/Acre)',NULL,'849e04a6-169a-482c-9daf-38c938ce6251','c803bb40-15b5-4691-b48a-67cb2048c45a',NULL,'2024-02-14 05:51:26.048000',NULL),('7ea68279-4cb9-4113-9044-8f1569d53b83','STRING',NULL,'Name of the SHG',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:18:02.700000',NULL),('80a73d29-8525-4d0d-8286-4d6dc5e497f5','DROPDOWN',NULL,'Respondent\'s Gender',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:16:47.692000',NULL),('849e04a6-169a-482c-9daf-38c938ce6251','YES/NO',NULL,'Do you use Chemical Weedicide',NULL,NULL,'c803bb40-15b5-4691-b48a-67cb2048c45a','7b9a82c1-501c-4b42-988c-882a55299147','2024-02-14 05:51:26.034000',NULL),('8652d8f7-8b87-45ec-a14c-3ac351e536dc','INTEGER',NULL,'Average Daily Production of Milk(Litres)',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:57:59.315000',NULL),('89d50461-139b-4be7-8b01-e3ccfbd7c69c','DROPDOWN',NULL,'Category',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:33:22.852000',NULL),('8b3526e0-728a-45b8-8a08-ae87c726e62e','DROPDOWN',NULL,'Toilet',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:28:18.564000',NULL),('8b74e3ee-9105-4d36-aff2-fe26dec0db8f','STRING',NULL,'Pincode',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:23:10.318000',NULL),('8ec10b8f-529d-40a0-8a30-2307dd010345','DROPDOWN',NULL,'Card Type',NULL,'1344fd29-dfc0-4fd1-afe7-1ab08d5a069a','1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:41:13.830000',NULL),('922d8584-32de-4f07-afee-ad6f3a610498','DROPDOWN',NULL,'If APL',NULL,'bdc4bb1b-4850-4ffb-b5c2-2e4ac6851d49','1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:55:23.347000',NULL),('961436c9-e14f-491d-8a42-60c56f674dd8','INTEGER',NULL,'Cultivable Area (in Acres)',NULL,NULL,'dc34817f-ba0b-41dc-9157-d447448c6796',NULL,'2024-02-14 05:46:53.223000',NULL),('9840c038-d6f5-4a5b-afe8-4e9ab35c0a4b','DROPDOWN',NULL,'Lighting',NULL,NULL,'3f74f505-5136-45dc-a337-f7347fb711b7',NULL,'2024-02-14 05:41:50.345000',NULL),('9a5d3f8a-c648-43a3-911a-a7df00306c08','INTEGER',NULL,'Female',NULL,'5ce7fb31-ae67-4bce-9327-19e836301d58','1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:25:48.999000',NULL),('a01261c7-63b2-4010-aaa1-faa37724a6e4','DROPDOWN',NULL,'Supplied water by Pvt / GOVT Supply',NULL,NULL,'fed067b2-16a5-4571-8e61-d9519a789fdb',NULL,'2024-02-14 05:24:25.710000',NULL),('a1b86793-da7d-4f5b-8eab-3c920b7448e9','STRING',NULL,'Bank A/C',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:12:30.326000',NULL),('a1f9bba9-7daf-4aa2-ab96-03f4eaa405e2','STRING',NULL,'Present Status of employment (Employed / Unemployed )',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:12:49.011000',NULL),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','COUNTER',NULL,'Family Member Count',NULL,NULL,'b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-13 23:59:54.127000',NULL),('a5be65cd-8066-48ee-bc08-fc56d61e794a','STRING',NULL,'Mobile No.',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:12:35.119000',NULL),('a9810a0f-47dd-4cac-b177-31a7dc84db30','DROPDOWN',NULL,'Drainage linked to House',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:28:39.234000',NULL),('aa61d46b-61bf-46cb-95e4-a16e18e4de79','DROPDOWN',NULL,'Hand Pump (Public / Private)',NULL,NULL,'fed067b2-16a5-4571-8e61-d9519a789fdb',NULL,'2024-02-14 05:24:52.607000',NULL),('aabf40f5-c753-45ba-946d-d9bd00e2176d','STRING',NULL,'Respondent\'s Mobile No.',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:23:17.739000',NULL),('ab5b6e88-6999-41a8-91e4-ea07ef42fd21','INTEGER',NULL,'Fertilizer Use (Kg/Acre)',NULL,'56ed03e3-a71e-419f-8e03-ac47e4694fce','c803bb40-15b5-4691-b48a-67cb2048c45a',NULL,'2024-02-14 05:51:12.436000',NULL),('ac7576c5-3c7f-44df-a887-7bea27532ba6','DROPDOWN',NULL,'Gender M/F/O',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:07:25.764000',NULL),('b3d00603-91e3-4f74-aadf-921abd62d023','STRING',NULL,'Migrated From',NULL,'0e9a36e7-1253-476e-af61-2d09430e0ed4','aafb2a2e-29cc-41f6-884e-8f6b6a886dae',NULL,'2024-02-14 05:21:01.186000',NULL),('b8b6e19f-84bb-4284-af23-67f3e831f678','INTEGER',NULL,'Irrigated Area (in Acres)',NULL,NULL,'dc34817f-ba0b-41dc-9157-d447448c6796',NULL,'2024-02-14 05:47:00.889000',NULL),('bac7bfda-7b70-48f9-8581-13091002112c','DROPDOWN',NULL,'Waste Source segregated',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:27:22.144000',NULL),('bbb2878e-0250-449b-98b3-b704d4e7c0bc','DROPDOWN',NULL,'Card Type',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:38:08.243000',NULL),('bdc4bb1b-4850-4ffb-b5c2-2e4ac6851d49','DROPDOWN',NULL,'Social Status',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:54:20.519000',NULL),('c0973fdb-c022-468b-b2e8-1e3a9a16ba95','INTEGER',NULL,'Family migrates for how many days / months?',NULL,'4205334d-1d67-448c-98ae-33f3e3e293e3','aafb2a2e-29cc-41f6-884e-8f6b6a886dae',NULL,'2024-02-14 05:17:57.144000',NULL),('c34e9e1c-0d5b-4e6a-b116-4588f64b804d','DROPDOWN',NULL,'Living in',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:56:39.275000',NULL),('c4ca68af-caee-4b9d-8634-18dc78bee7c4','INTEGER',NULL,'Buffalo',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:17.944000',NULL),('c5fc1b01-f6c0-48c2-9856-2a4d92eb35a0','STRING',NULL,'Aadhaar Card',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:12:04.752000',NULL),('c76420a0-7afe-4e97-bba8-7a25eede0aee','STRING',NULL,'Chief Minister Comprehensive Health Insurance Scheme No',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:12:19.586000',NULL),('cdd47167-ae31-458d-8a6c-c2186d01c5e0','STRING',NULL,'Block Name',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:40.692000',NULL),('cfea527f-b1cc-4fe5-b255-bffdfaef3d19','DROPDOWN',NULL,'If women, is she a member of a SHG',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:17:44.515000',NULL),('d306d8de-dd48-4f86-b653-bffd0bb5bcbf','DROPDOWN',NULL,'Card Type',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:44:03.242000',NULL),('d3948b18-ae59-4dc1-b9e2-318522a06a3f','DROPDOWN',NULL,'If unemployed Would like to under go skill training',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:13:37.968000',NULL),('d47ef7f0-c05c-423f-8085-23190cb68187','INTEGER',NULL,'Respondent\'s Age (years) :',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:16:46.692000',NULL),('d5dce7fd-2114-4c3f-886f-1a9f78ba3af0','INTEGER',NULL,'Total (in Acres)',NULL,NULL,'dc34817f-ba0b-41dc-9157-d447448c6796',NULL,'2024-02-14 05:46:45.662000',NULL),('d61fedc5-7aac-4f3c-b5e2-0da2efb59aae','STRING',NULL,'Religion',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:33:53.481000',NULL),('dc483670-34ef-4601-a791-9f6564ccecbc','DROPDOWN',NULL,'Waste Collection',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:27:55.234000',NULL),('ddf96dd3-2b58-4e01-b8df-f13ace0da463','INTEGER',NULL,'Age (Yrs.)',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:05:50.798000',NULL),('e10f464b-1abb-4b70-87fc-26926a13afbc','DROPDOWN',NULL,'Where do they discharge the greywater',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:38:12.587000',NULL),('e1fa2a06-e562-4324-a6d2-e37ba27a08b6','STRING',NULL,'Relationship to the Head of Family',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:05:12.619000',NULL),('e2429bdd-3fd1-4f00-a399-ebcab17b2e3b','DROPDOWN',NULL,'Compost Pit',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:29:27.351000',NULL),('e4144824-19bb-4f36-9bc4-fca2d69b5458','STRING',NULL,'Material used to make the system',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:37:31.794000',NULL),('e5cdccec-474c-45cf-adf7-396917a05bb6','DROPDOWN',NULL,'Irrigation System',NULL,NULL,'c803bb40-15b5-4691-b48a-67cb2048c45a',NULL,'2024-02-14 05:52:55.399000',NULL),('e7d38132-7bc4-483b-bf1a-11fdd21d0ac1','STRING',NULL,'Name (First name)',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:00:31.082000',NULL),('e915e49d-718c-4700-b747-a9d71db12259','STRING',NULL,'Others (mention )',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:53.664000',NULL),('ec6d95e9-bef1-4e04-ad18-420a0748905b','INTEGER',NULL,'National Mission on Financial Inclusion - Beneficiary Individuals',NULL,NULL,'f98674d7-8a2e-4b6b-9169-0fbccd9626e9',NULL,'2024-02-14 06:22:26.349000',NULL),('f2a8d49c-ccfc-44f7-89e3-fe56907695a2','STRING',NULL,'Dimension of the system',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:37:24.931000',NULL),('f4084e74-15de-40d8-960f-b904c59d9938','INTEGER',NULL,'Fertilizer Use (Kg/Acre)',NULL,'3afcec45-80d2-4915-bd4f-a277aa3533f0','c803bb40-15b5-4691-b48a-67cb2048c45a',NULL,'2024-02-14 05:51:20.023000',NULL),('fe5c42aa-3b3d-447f-8e9c-f05d4a8145c5','DROPDOWN',NULL,'Social Status',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:53:13.865000',NULL),('ff9d44fd-0120-4fa6-a607-160b06fb658d','INTEGER',NULL,'Calves',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:30.400000',NULL);
/*!40000 ALTER TABLE `field` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `field_answer_options`
--

DROP TABLE IF EXISTS `field_answer_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `field_answer_options` (
  `field_id` varchar(255) NOT NULL,
  `answer_options_id` varchar(255) NOT NULL,
  PRIMARY KEY (`field_id`,`answer_options_id`),
  UNIQUE KEY `UK_pvln69e5a9pedxa8qbwfdnox` (`answer_options_id`),
  CONSTRAINT `FKf03akktevqwv1y037w0wmpneo` FOREIGN KEY (`answer_options_id`) REFERENCES `answer_option` (`id`),
  CONSTRAINT `FKfcjgofw0d4yng9pp08c2ei4yi` FOREIGN KEY (`field_id`) REFERENCES `field` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `field_answer_options`
--

LOCK TABLES `field_answer_options` WRITE;
/*!40000 ALTER TABLE `field_answer_options` DISABLE KEYS */;
INSERT INTO `field_answer_options` VALUES ('922d8584-32de-4f07-afee-ad6f3a610498','02a0bf58-da4a-46c9-b556-a40d8d657edb'),('e2429bdd-3fd1-4f00-a399-ebcab17b2e3b','02f20bbf-e7c2-4a44-9fdd-fb9eeeee96eb'),('ac7576c5-3c7f-44df-a887-7bea27532ba6','0745d8c4-c889-443d-b003-c4bb9cf79103'),('8b3526e0-728a-45b8-8a08-ae87c726e62e','0b83a8c6-5710-4058-915f-9c66de1ababe'),('1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5','1030562b-820e-45f6-b0f7-2e9bf7ba4721'),('4a66182f-a531-4d28-86c2-89d092ef0e5c','11cb1e4c-aea8-47ea-8c75-dd9c6446d09b'),('dc483670-34ef-4601-a791-9f6564ccecbc','124df25c-6ecb-43c5-a94d-4af264b05aab'),('4cfbc609-b1e6-4ea7-aabb-382932d60b75','135f5021-3d9f-4035-8384-897e01b29bfe'),('573da434-ca26-4ed3-bdbe-1cc2fec2609d','140e7a57-9d47-4983-bd6f-0e12ccfdc3b7'),('dc483670-34ef-4601-a791-9f6564ccecbc','14b84860-c54a-4c1c-9294-67eebd8349fd'),('485b1075-9475-46c0-904c-5141ece3e250','16c30836-042f-4f7a-9a6c-f3be5fbf3bbd'),('3ccce80e-9448-40aa-af4e-815bd1873822','1899eec8-1774-4a7f-9ab2-d38b5a8b825c'),('80a73d29-8525-4d0d-8286-4d6dc5e497f5','19741771-6b7f-4a99-8a66-c7293a1a91fd'),('5e5eed86-c402-410d-b363-b978608051cf','1c416679-bb5e-48c2-82c5-f82f45c41395'),('e2429bdd-3fd1-4f00-a399-ebcab17b2e3b','1fba7179-3a03-4145-94b7-b44f57409930'),('8ec10b8f-529d-40a0-8a30-2307dd010345','211e5388-832e-4811-babc-fadf21926157'),('679dc64c-b7bb-4821-905f-53ff7dbac7a2','212b840c-6dba-47a1-adf9-ee6029aa9708'),('2b322452-5ad8-49d6-ba17-8bc7a35394e9','21dc1bac-ef66-440a-acc6-956c755e0bd9'),('a01261c7-63b2-4010-aaa1-faa37724a6e4','24d8ecb1-6994-479a-b11b-646ce393cbe5'),('e10f464b-1abb-4b70-87fc-26926a13afbc','27890806-c130-4077-a3ce-a997ce99bc15'),('ac7576c5-3c7f-44df-a887-7bea27532ba6','286bf210-5dae-4b8f-b8d3-c1cb540e7512'),('4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f','2aaec1d0-0d5c-437d-b9c6-d7b707a43aea'),('679dc64c-b7bb-4821-905f-53ff7dbac7a2','2c2ef216-040a-4138-bf7b-de6cd7bc8616'),('372c1390-9e7f-4371-bebb-7e4df21ba148','33674f6a-78dc-4eb1-96ac-35472a439b77'),('66309b80-898b-4ae1-acf5-b716365512a3','347efc3c-eb90-4d7e-8b14-dc9cac1d54fb'),('76666ba4-a81b-46fb-88f0-0d1e1ff71148','35734c4a-a50a-45b1-9f33-3c3304c1033b'),('1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5','36cb43ba-b316-4454-a0c5-5b7c95814108'),('679dc64c-b7bb-4821-905f-53ff7dbac7a2','39787f00-fc9f-4e04-bc23-e1d295122521'),('4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f','3b57bc38-b87c-49d9-bfcc-7511519cb503'),('679dc64c-b7bb-4821-905f-53ff7dbac7a2','3f74622e-1366-45ba-9529-50851d4633f9'),('4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f','40c5cd29-69ee-4166-a77f-5b6944d9311b'),('679dc64c-b7bb-4821-905f-53ff7dbac7a2','417c1f90-cd31-4a65-9db3-3745c2211d2d'),('bac7bfda-7b70-48f9-8581-13091002112c','443ffa67-037f-4f4a-bca3-9396151a26b1'),('53bf82b5-dce4-489c-88dc-ebf41e9e0b65','44831011-a769-4298-b984-5cf617fb6113'),('8b3526e0-728a-45b8-8a08-ae87c726e62e','45ccc9bf-84ba-4aec-a5a1-cfdfd32ef513'),('378c03af-e019-4c37-9df5-3e116a7d3192','467e436a-ca94-4ff4-b006-b87030d44032'),('7124b5e6-f9ee-448a-8501-d2e9602d1535','47eb9115-5e02-485f-b486-9dd7e781801a'),('80a73d29-8525-4d0d-8286-4d6dc5e497f5','4827a4a3-bc28-462d-967d-03f6407114db'),('9840c038-d6f5-4a5b-afe8-4e9ab35c0a4b','48a8e323-4f9b-42aa-90d7-117bf2e59edc'),('4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f','49702938-3730-413a-9799-850b7fc0dd2d'),('1f3f7b9b-2438-4ff5-ad50-dbc30d70aa66','4a19c2d7-1e45-4bd1-9eae-5f78119c385c'),('7453fe3f-c790-4618-b33c-dcb440b14d45','4b63922e-c1da-4603-b8e1-bc3df2d2c8c6'),('9840c038-d6f5-4a5b-afe8-4e9ab35c0a4b','4c07db4f-85bd-4c29-884d-29319fd71a93'),('485b1075-9475-46c0-904c-5141ece3e250','4d7f1006-9b9c-4fa2-8ff6-24e92277b563'),('53bf82b5-dce4-489c-88dc-ebf41e9e0b65','4e22375c-b789-4011-aeee-16fd2ede4dc1'),('1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5','5010c8f8-e0a6-4de2-ace1-5c679c5d8b46'),('ac7576c5-3c7f-44df-a887-7bea27532ba6','5068340d-e660-45fe-ad09-cfd3f599e7d5'),('bdc4bb1b-4850-4ffb-b5c2-2e4ac6851d49','516147a1-1f9a-42e5-9ac4-4ebc0547d926'),('cfea527f-b1cc-4fe5-b255-bffdfaef3d19','528b765f-7573-41d2-a67b-270536aabfb4'),('aa61d46b-61bf-46cb-95e4-a16e18e4de79','53428867-aacb-4b93-aaa9-76225e746529'),('4cfbc609-b1e6-4ea7-aabb-382932d60b75','5526c938-697c-497d-8b56-4eb3514dd7e3'),('7453fe3f-c790-4618-b33c-dcb440b14d45','57bf5564-497f-47cd-a61e-2c331354540e'),('9840c038-d6f5-4a5b-afe8-4e9ab35c0a4b','5855a788-17ed-4388-9bc0-1f8754e96755'),('1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5','5856448f-6960-4ec3-81ef-5c39950d1bcb'),('679dc64c-b7bb-4821-905f-53ff7dbac7a2','5b7d74a0-90d0-4a90-9f9c-1068e4b46e37'),('372c1390-9e7f-4371-bebb-7e4df21ba148','5ce9148f-a751-4b32-9f24-fe5797914cd6'),('372c1390-9e7f-4371-bebb-7e4df21ba148','5e03406a-c877-4bee-aea1-cdfc25772535'),('922d8584-32de-4f07-afee-ad6f3a610498','5e24a161-1fcb-4d97-885a-a324b051fa95'),('47e664a0-8863-4da0-b4a6-5450a121dfa1','614dfc9e-fb33-45eb-8edf-c6ea2c37e42c'),('4a66182f-a531-4d28-86c2-89d092ef0e5c','6170efc8-f82d-4df7-b7c2-653b4603f177'),('e5cdccec-474c-45cf-adf7-396917a05bb6','646dfa42-8e45-403e-9959-829742108943'),('05e0a33f-c099-4ed0-a706-b248303145d5','66dec038-36ab-4ef3-9aee-c817d4fa1e56'),('5e5eed86-c402-410d-b363-b978608051cf','67f3162a-b644-4692-bc4e-2bd0f523dfba'),('e5cdccec-474c-45cf-adf7-396917a05bb6','68562ac4-e325-47e4-8ea4-60083cb8ef23'),('922d8584-32de-4f07-afee-ad6f3a610498','6cd3ce60-1a46-4df4-a513-a2ce24436977'),('4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f','6d82cd41-1f66-4df4-9d25-c27faa4999c5'),('89d50461-139b-4be7-8b01-e3ccfbd7c69c','718c72aa-d731-4deb-958e-64451e515a5c'),('4cfbc609-b1e6-4ea7-aabb-382932d60b75','72cdbf75-a362-414c-8b11-507703d60fd8'),('e2429bdd-3fd1-4f00-a399-ebcab17b2e3b','78f7c7a3-3f88-4dfc-aa20-2fdff5d14203'),('4a66182f-a531-4d28-86c2-89d092ef0e5c','7b2cde09-9e32-4ca5-bf09-16caeae7ced2'),('3d9f282e-9833-442f-a0a7-6459db24f4a0','80f31b79-73a5-4349-bccf-5ca1f7d6e11a'),('7124b5e6-f9ee-448a-8501-d2e9602d1535','82d722b2-1d59-4962-a34f-a012bf26c821'),('05e0a33f-c099-4ed0-a706-b248303145d5','86239d08-0722-4e59-a8ee-4ccf7c30514e'),('679dc64c-b7bb-4821-905f-53ff7dbac7a2','86fa2c13-4043-4e7e-91bb-5e5477b33cf8'),('53bf82b5-dce4-489c-88dc-ebf41e9e0b65','8790ecfd-1bae-4056-b33c-a465c035a145'),('80a73d29-8525-4d0d-8286-4d6dc5e497f5','8801a563-436a-4ac8-ae06-aa0b1691f098'),('573da434-ca26-4ed3-bdbe-1cc2fec2609d','88285edb-ffc5-4111-9453-f9b12a15a110'),('4a66182f-a531-4d28-86c2-89d092ef0e5c','8cb9c00d-44d4-48d8-880c-c2af05e05d0c'),('05e0a33f-c099-4ed0-a706-b248303145d5','8da330de-e294-46fd-b654-87a1d211f2f7'),('cfea527f-b1cc-4fe5-b255-bffdfaef3d19','90e0065d-63a5-4e41-9da1-b5cbf07b5cf9'),('0e7e3eca-3a56-4a3e-96a3-38c0da5d54ca','91e16eac-8775-47da-885a-751c22ea4f3e'),('89d50461-139b-4be7-8b01-e3ccfbd7c69c','924e8376-baa1-4220-98cd-e34a86df8263'),('679dc64c-b7bb-4821-905f-53ff7dbac7a2','94b4b49e-fcd6-42d4-8414-7b6eb24409ff'),('4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f','96194dc6-f2b2-4e45-ae57-39db93b28b26'),('05e0a33f-c099-4ed0-a706-b248303145d5','966c65b9-ae72-4531-8de4-e82023dccdee'),('a9810a0f-47dd-4cac-b177-31a7dc84db30','968b5733-a5b3-40d7-8efc-1e4a272ee7b8'),('372c1390-9e7f-4371-bebb-7e4df21ba148','981b1785-f9c3-4c18-88b5-496b3fb8ae8d'),('89d50461-139b-4be7-8b01-e3ccfbd7c69c','9b8b4fc0-b79c-4e5d-ac1f-50195d19eefc'),('66309b80-898b-4ae1-acf5-b716365512a3','9ecd4ceb-bcfa-44ef-9413-858936a1c1c7'),('53bf82b5-dce4-489c-88dc-ebf41e9e0b65','a0fda44d-c41b-4dcf-a5eb-74a5ab72d39c'),('e10f464b-1abb-4b70-87fc-26926a13afbc','a1d3ca51-b069-42a9-8dbc-74716b6f041d'),('c34e9e1c-0d5b-4e6a-b116-4588f64b804d','a2d10fca-d741-4ddb-8a0c-416625884689'),('e5cdccec-474c-45cf-adf7-396917a05bb6','a7c52bc6-490a-44ee-86d4-ebad9f573d2a'),('573da434-ca26-4ed3-bdbe-1cc2fec2609d','a915c789-175c-4dab-8d7c-9878d2b9959c'),('4a66182f-a531-4d28-86c2-89d092ef0e5c','a9d4d685-a5f0-44be-9367-210c3eb8c72d'),('e5cdccec-474c-45cf-adf7-396917a05bb6','aa994d37-cfad-4330-acf4-318d8fe28f28'),('53bf82b5-dce4-489c-88dc-ebf41e9e0b65','abbd063c-5d7b-4e3b-9f11-bbb90127f96f'),('53bf82b5-dce4-489c-88dc-ebf41e9e0b65','acc1f197-3e5d-4464-a3d9-f05b2545a583'),('d3948b18-ae59-4dc1-b9e2-318522a06a3f','acfc52a6-b9fe-4f1a-a6fb-d8a6c0878f53'),('922d8584-32de-4f07-afee-ad6f3a610498','b0128dee-ea98-4999-8f12-861d0ab0d7c8'),('bac7bfda-7b70-48f9-8581-13091002112c','b17d1988-b0ed-4eb1-8920-e84f80f285fe'),('0e7e3eca-3a56-4a3e-96a3-38c0da5d54ca','b5b6d8d6-f860-465c-bdae-a7e78a59dc5a'),('1f3f7b9b-2438-4ff5-ad50-dbc30d70aa66','b5c03634-ac37-4433-9844-6191aa7a4705'),('372c1390-9e7f-4371-bebb-7e4df21ba148','b65efd7e-eeb9-4d83-8e17-5f780d18df91'),('aa61d46b-61bf-46cb-95e4-a16e18e4de79','b706b61d-6946-4f86-b98f-3dc229086e28'),('8b3526e0-728a-45b8-8a08-ae87c726e62e','b7412988-0ea5-4ff3-b18a-7529b03a2f22'),('573da434-ca26-4ed3-bdbe-1cc2fec2609d','bba7ea08-413d-482b-b5ee-a1fccc44e7bf'),('3ccce80e-9448-40aa-af4e-815bd1873822','bcd26d89-4f1a-45ca-8856-ac33811cada5'),('1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5','bfe0885f-1afb-40c3-a37a-bd5ec6a2c3bc'),('378c03af-e019-4c37-9df5-3e116a7d3192','c0858305-aa95-4d79-b745-708058b1fc64'),('bdc4bb1b-4850-4ffb-b5c2-2e4ac6851d49','c49ea885-8d0b-401f-af59-93fc978dd32c'),('9840c038-d6f5-4a5b-afe8-4e9ab35c0a4b','c611598d-aa58-42f3-9f31-7c52c8ec5fb8'),('1f3f7b9b-2438-4ff5-ad50-dbc30d70aa66','c6c56593-c270-4824-aca6-4f9cf162f5b3'),('4a66182f-a531-4d28-86c2-89d092ef0e5c','c8a4b04a-e8c0-48e5-9950-69726ac89d40'),('89d50461-139b-4be7-8b01-e3ccfbd7c69c','c946445a-0e01-4a9f-9162-052924a489da'),('3ccce80e-9448-40aa-af4e-815bd1873822','ca5ba108-e2d6-4e4d-a520-1f0f1a24fd88'),('89d50461-139b-4be7-8b01-e3ccfbd7c69c','cb58a4d4-09c5-484b-a1a0-785f61248ffe'),('573da434-ca26-4ed3-bdbe-1cc2fec2609d','cc34b6bc-17d2-4757-8ac9-0282cd1218a7'),('4a66182f-a531-4d28-86c2-89d092ef0e5c','d0e85e00-7cbe-4e9f-b251-f9b91c59ab7c'),('1f3f7b9b-2438-4ff5-ad50-dbc30d70aa66','d10b61bd-0585-46f9-840b-c5640a4ea8cb'),('89d50461-139b-4be7-8b01-e3ccfbd7c69c','d1c3d9b7-5ce1-4041-b55d-a7d9e6cec7d9'),('dc483670-34ef-4601-a791-9f6564ccecbc','d3216828-47bb-49d4-afb8-c38be1db3361'),('8ec10b8f-529d-40a0-8a30-2307dd010345','d32898bb-fec3-44d1-abc2-b111ad63012d'),('372c1390-9e7f-4371-bebb-7e4df21ba148','d36e7efd-afc2-464b-9cf6-eb4b699743e2'),('a01261c7-63b2-4010-aaa1-faa37724a6e4','d3a309ae-b319-4d2f-ba1b-bf43772d8d32'),('53bf82b5-dce4-489c-88dc-ebf41e9e0b65','d80f939a-c5d8-4f43-8105-5f6649c5037e'),('53bf82b5-dce4-489c-88dc-ebf41e9e0b65','d9e7b237-7d3e-4155-8565-57c74a835ae7'),('76666ba4-a81b-46fb-88f0-0d1e1ff71148','dacca0cb-8ce8-4383-81e5-658599e7f0c3'),('4a66182f-a531-4d28-86c2-89d092ef0e5c','dc268723-7536-4bf3-a6ea-a2b1d8c0cff2'),('4cfbc609-b1e6-4ea7-aabb-382932d60b75','dc788375-1dc4-47cb-8f1f-54d8b6c10648'),('372c1390-9e7f-4371-bebb-7e4df21ba148','dcf1e4cf-03e9-47f0-ad8c-7df81ad9681d'),('4a66182f-a531-4d28-86c2-89d092ef0e5c','e0bfd5d2-8066-4f93-9c1e-c8487e6970cc'),('8ec10b8f-529d-40a0-8a30-2307dd010345','e6cb8fb3-c76e-4abf-a5da-80a2877bdbc6'),('c34e9e1c-0d5b-4e6a-b116-4588f64b804d','e869be03-76d1-4ded-b190-0416f8c2c81f'),('a9810a0f-47dd-4cac-b177-31a7dc84db30','eb2fdf11-9658-4f4e-bcfc-c28bfd742dca'),('0e7e3eca-3a56-4a3e-96a3-38c0da5d54ca','ed260ec7-44c9-4d2b-a403-e9bf65a6f03a'),('2b322452-5ad8-49d6-ba17-8bc7a35394e9','ede37b54-3988-4cf7-9bd1-9926b9e9a604'),('53bf82b5-dce4-489c-88dc-ebf41e9e0b65','eff7ab48-5be2-48fa-a51a-a9067c078fe9'),('8ec10b8f-529d-40a0-8a30-2307dd010345','f4c74de0-805f-4c28-a6d2-d336b73aff92'),('d3948b18-ae59-4dc1-b9e2-318522a06a3f','f4da9133-c797-4509-ade4-e2fbf1fed1f7'),('e10f464b-1abb-4b70-87fc-26926a13afbc','f6ae384c-2188-44dc-93d8-c427100b5b63'),('372c1390-9e7f-4371-bebb-7e4df21ba148','f7d1daa6-f2a1-4167-a3e1-225018b28bdc'),('a9810a0f-47dd-4cac-b177-31a7dc84db30','f9c11e2d-14fc-4d37-97a3-e6013b893f99'),('e10f464b-1abb-4b70-87fc-26926a13afbc','fb3f3863-4354-40bc-8952-3924d141ba68'),('0e7e3eca-3a56-4a3e-96a3-38c0da5d54ca','fc015360-80be-4076-9848-a324cfefc060');
/*!40000 ALTER TABLE `field_answer_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `field_response_records`
--

DROP TABLE IF EXISTS `field_response_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `field_response_records` (
  `field_id` varchar(255) NOT NULL,
  `response_records_id` varchar(255) NOT NULL,
  PRIMARY KEY (`field_id`,`response_records_id`),
  UNIQUE KEY `UK_6fubqvjnme4g11dtn502mpsj6` (`response_records_id`),
  CONSTRAINT `FK32hc471bm2m8mmvl4dpebkqca` FOREIGN KEY (`response_records_id`) REFERENCES `response_record` (`id`),
  CONSTRAINT `FKnlnl1sigawpqvcdsary5ht32e` FOREIGN KEY (`field_id`) REFERENCES `field` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `field_response_records`
--

LOCK TABLES `field_response_records` WRITE;
/*!40000 ALTER TABLE `field_response_records` DISABLE KEYS */;
/*!40000 ALTER TABLE `field_response_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `field_sub_fields`
--

DROP TABLE IF EXISTS `field_sub_fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `field_sub_fields` (
  `field_id` varchar(255) NOT NULL,
  `sub_fields_id` varchar(255) NOT NULL,
  PRIMARY KEY (`field_id`,`sub_fields_id`),
  UNIQUE KEY `UK_mag0b4uidx65yxhluw9linjk7` (`sub_fields_id`),
  CONSTRAINT `FK2nkukkh12gl65qirq06d8l64b` FOREIGN KEY (`field_id`) REFERENCES `field` (`id`),
  CONSTRAINT `FKf0q99hy7q02qpu8xofafc6f26` FOREIGN KEY (`sub_fields_id`) REFERENCES `field` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `field_sub_fields`
--

LOCK TABLES `field_sub_fields` WRITE;
/*!40000 ALTER TABLE `field_sub_fields` DISABLE KEYS */;
INSERT INTO `field_sub_fields` VALUES ('4205334d-1d67-448c-98ae-33f3e3e293e3','0c4d46e6-d8be-4d6c-8610-5a154b82e1f1'),('73956663-9121-4667-bda2-265c7287285e','0e297de4-6bed-4d76-8063-7c9ebb607377'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','0e7e3eca-3a56-4a3e-96a3-38c0da5d54ca'),('485b1075-9475-46c0-904c-5141ece3e250','14f3f571-e7b8-4acf-9890-5bf725d1eeb1'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','2196729c-89c3-4689-adeb-2ec351331eaf'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','2b322452-5ad8-49d6-ba17-8bc7a35394e9'),('3974cf52-3cd2-497d-a7b2-99dfa8b04bc4','2c4f685d-6e44-409a-81b6-8b98270e3372'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','37f0a25c-50f8-4a8b-89c4-2befead6b118'),('4205334d-1d67-448c-98ae-33f3e3e293e3','395a6e23-9ddd-4632-9c88-1acf7601113f'),('3974cf52-3cd2-497d-a7b2-99dfa8b04bc4','41f5e600-486b-4b7b-8ada-09b78c9b6397'),('5ce7fb31-ae67-4bce-9327-19e836301d58','4a516891-c03a-41fe-a2b0-bf4edc1eb8ce'),('3974cf52-3cd2-497d-a7b2-99dfa8b04bc4','4d58074e-e278-4874-9cb4-c8d64e53ce7b'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','53bf82b5-dce4-489c-88dc-ebf41e9e0b65'),('73956663-9121-4667-bda2-265c7287285e','5bf383b6-a5bc-4836-aafe-1c9a5d79859c'),('5ce7fb31-ae67-4bce-9327-19e836301d58','61efb724-e89c-4211-adea-259f42603027'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','64f7a260-0ace-4a71-b0c0-f8263e7e9522'),('8ec10b8f-529d-40a0-8a30-2307dd010345','73ab11be-420a-4bd0-8137-f453258731dd'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','76666ba4-a81b-46fb-88f0-0d1e1ff71148'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','7ea68279-4cb9-4113-9044-8f1569d53b83'),('bdc4bb1b-4850-4ffb-b5c2-2e4ac6851d49','922d8584-32de-4f07-afee-ad6f3a610498'),('5ce7fb31-ae67-4bce-9327-19e836301d58','9a5d3f8a-c648-43a3-911a-a7df00306c08'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','a1b86793-da7d-4f5b-8eab-3c920b7448e9'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','a1f9bba9-7daf-4aa2-ab96-03f4eaa405e2'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','a5be65cd-8066-48ee-bc08-fc56d61e794a'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','ac7576c5-3c7f-44df-a887-7bea27532ba6'),('0e9a36e7-1253-476e-af61-2d09430e0ed4','b3d00603-91e3-4f74-aadf-921abd62d023'),('4205334d-1d67-448c-98ae-33f3e3e293e3','c0973fdb-c022-468b-b2e8-1e3a9a16ba95'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','c5fc1b01-f6c0-48c2-9856-2a4d92eb35a0'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','c76420a0-7afe-4e97-bba8-7a25eede0aee'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','cfea527f-b1cc-4fe5-b255-bffdfaef3d19'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','d3948b18-ae59-4dc1-b9e2-318522a06a3f'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','ddf96dd3-2b58-4e01-b8df-f13ace0da463'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','e1fa2a06-e562-4324-a6d2-e37ba27a08b6'),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','e7d38132-7bc4-483b-bf1a-11fdd21d0ac1');
/*!40000 ALTER TABLE `field_sub_fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gram_panchayat`
--

DROP TABLE IF EXISTS `gram_panchayat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gram_panchayat` (
  `village_id` varchar(255) NOT NULL,
  `gram_panchayat_code` int DEFAULT NULL,
  `gram_panchayat_name` varchar(255) NOT NULL,
  PRIMARY KEY (`village_id`,`gram_panchayat_name`),
  CONSTRAINT `FK3ani2coxr6wdlcku846bt0fey` FOREIGN KEY (`village_id`) REFERENCES `village` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gram_panchayat`
--

LOCK TABLES `gram_panchayat` WRITE;
/*!40000 ALTER TABLE `gram_panchayat` DISABLE KEYS */;
/*!40000 ALTER TABLE `gram_panchayat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `next_id`
--

DROP TABLE IF EXISTS `next_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `next_id` (
  `id` varchar(255) NOT NULL,
  `next_id` int DEFAULT NULL,
  `survey_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `next_id`
--

LOCK TABLES `next_id` WRITE;
/*!40000 ALTER TABLE `next_id` DISABLE KEYS */;
INSERT INTO `next_id` VALUES ('48bcba5e-a969-4f77-a18b-955dc97cefcc',0,'7bf67165-0a45-4a8a-943f-0b49d6ce75af'),('e541e68e-36a2-4887-8cd1-e4a4dd78babc',0,'647e5849-3a3c-47ab-82ec-17326f8d3b68');
/*!40000 ALTER TABLE `next_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response`
--

DROP TABLE IF EXISTS `response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response` (
  `id` varchar(255) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `survey_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `village_id` varchar(255) DEFAULT NULL,
  `response_id_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i84hnjgg8et0mgs3qs55aml4v` (`response_id_id`),
  KEY `FKkkoy63t965j9k9ckvtt32uequ` (`survey_id`),
  KEY `FKo86so3ptvukgyfb2rkb63hab4` (`user_id`),
  KEY `FK6l24i4qfvaomha4th3k8hjca6` (`village_id`),
  CONSTRAINT `FK6l24i4qfvaomha4th3k8hjca6` FOREIGN KEY (`village_id`) REFERENCES `village` (`id`),
  CONSTRAINT `FKkkoy63t965j9k9ckvtt32uequ` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`),
  CONSTRAINT `FKktv77ah5qah0fwg6wr5a1q0s6` FOREIGN KEY (`response_id_id`) REFERENCES `unique_survey` (`id`),
  CONSTRAINT `FKo86so3ptvukgyfb2rkb63hab4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response`
--

LOCK TABLES `response` WRITE;
/*!40000 ALTER TABLE `response` DISABLE KEYS */;
/*!40000 ALTER TABLE `response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response_record`
--

DROP TABLE IF EXISTS `response_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response_record` (
  `id` varchar(255) NOT NULL,
  `counter` int DEFAULT NULL,
  `field_id` varchar(255) DEFAULT NULL,
  `response_id` varchar(255) DEFAULT NULL,
  `section_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8duc3xbv72cnu0sl0bsxdnlda` (`field_id`),
  KEY `FKrr5cwhuvjoq5rjjvla2w6yfkn` (`response_id`),
  KEY `FKphpk4k5g1xex5kye0hxv6hl9v` (`section_id`),
  CONSTRAINT `FK8duc3xbv72cnu0sl0bsxdnlda` FOREIGN KEY (`field_id`) REFERENCES `field` (`id`),
  CONSTRAINT `FKphpk4k5g1xex5kye0hxv6hl9v` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`),
  CONSTRAINT `FKrr5cwhuvjoq5rjjvla2w6yfkn` FOREIGN KEY (`response_id`) REFERENCES `response` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response_record`
--

LOCK TABLES `response_record` WRITE;
/*!40000 ALTER TABLE `response_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `response_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response_record_answers`
--

DROP TABLE IF EXISTS `response_record_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response_record_answers` (
  `response_record_id` varchar(255) NOT NULL,
  `answers_id` varchar(255) NOT NULL,
  PRIMARY KEY (`response_record_id`,`answers_id`),
  UNIQUE KEY `UK_aqih8f6ychvicmgveas2rcaah` (`answers_id`),
  CONSTRAINT `FKq0py2c92es5gjd507gqdmxqfe` FOREIGN KEY (`answers_id`) REFERENCES `answer_option` (`id`),
  CONSTRAINT `FKski4qrycuwtmnmp7ggfk1d30m` FOREIGN KEY (`response_record_id`) REFERENCES `response_record` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response_record_answers`
--

LOCK TABLES `response_record_answers` WRITE;
/*!40000 ALTER TABLE `response_record_answers` DISABLE KEYS */;
/*!40000 ALTER TABLE `response_record_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response_response_records`
--

DROP TABLE IF EXISTS `response_response_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response_response_records` (
  `response_id` varchar(255) NOT NULL,
  `response_records_id` varchar(255) NOT NULL,
  PRIMARY KEY (`response_id`,`response_records_id`),
  UNIQUE KEY `UK_m4k9s69bbxyebugcwqbkkxw39` (`response_records_id`),
  CONSTRAINT `FKdrk833ns55bif4est78xusm4i` FOREIGN KEY (`response_records_id`) REFERENCES `response_record` (`id`),
  CONSTRAINT `FKfp1tf1c97wa1gl48auwbll27r` FOREIGN KEY (`response_id`) REFERENCES `response` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response_response_records`
--

LOCK TABLES `response_response_records` WRITE;
/*!40000 ALTER TABLE `response_response_records` DISABLE KEYS */;
/*!40000 ALTER TABLE `response_response_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `section` (
  `id` varchar(255) NOT NULL,
  `section_name` varchar(255) DEFAULT NULL,
  `survey_id` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKll9lahcn8bkpu4mfj98u6iuua` (`survey_id`),
  CONSTRAINT `FKll9lahcn8bkpu4mfj98u6iuua` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
INSERT INTO `section` VALUES ('168af1f9-2dc9-4b1a-921a-b7f96eab9617','INFORMATION OF GOVERNMENT SCHEMES - STATE GOVERNMENT SCHEME','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-14 06:02:02.419000',NULL),('1b305ba2-efcc-4e06-875e-377ced5ba65c','2. General Household Information','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-13 22:23:58.880000',NULL),('20b9851c-c366-4638-97e1-cdaab4fcbf7a','12. Livestock Numbers','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-14 05:55:46.389000',NULL),('25085bda-da69-4550-990c-b5021eff380d','6. Swachh Bharat Mission','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-14 05:25:33.694000',NULL),('3937d505-24d7-4d50-bd67-a986e643244e','Problems Faced','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-14 05:58:52.897000',NULL),('3f74f505-5136-45dc-a337-f7347fb711b7','7. Electricity to all Households','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-14 05:38:31.539000',NULL),('43b5b00b-c871-4b76-a7a8-8d5c8278e136','1. Respondent\'s Profile','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-13 22:15:48.692000',NULL),('4572d9e8-f379-43a3-ad88-d996498d2d2a','General','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-13 22:14:48.692000',_binary '\0'),('aafb2a2e-29cc-41f6-884e-8f6b6a886dae','4. Migration Status in a family','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-14 05:15:16.873000',NULL),('b5b662b5-11bf-40dd-b1c9-362f3a881033','3. Family Member Information including Head of the Family','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-13 23:59:04.793000',NULL),('c803bb40-15b5-4691-b48a-67cb2048c45a','10. Agricultural Inputs','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-14 05:49:29.708000',NULL),('d5d0059e-0658-4e55-b1d9-7859c4aacefb','11. Agricultural Produce in a normal year','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-14 05:53:12.167000',NULL),('dc34817f-ba0b-41dc-9157-d447448c6796','9. Landholding Information','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-14 05:46:07.473000',NULL),('e0b34e9b-0c48-4319-a318-0d3de5690d99','8. Cooking','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-14 05:43:03.684000',NULL),('f98674d7-8a2e-4b6b-9169-0fbccd9626e9','INFORMATION OF GOVERNMENT SCHEMES - CENTRAL GOVERNMENT SCHEME','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-14 06:07:49.077000',NULL),('fed067b2-16a5-4571-8e61-d9519a789fdb','5. Piped Drinking Water at Home','647e5849-3a3c-47ab-82ec-17326f8d3b68','2024-02-14 05:23:10.797000',NULL);
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_fields`
--

DROP TABLE IF EXISTS `section_fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `section_fields` (
  `section_id` varchar(255) NOT NULL,
  `fields_id` varchar(255) NOT NULL,
  PRIMARY KEY (`section_id`,`fields_id`),
  UNIQUE KEY `UK_b5ahqxosfr1sng1pipg8mnftc` (`fields_id`),
  CONSTRAINT `FK26sbcywvf8yh4q1ypjkpcew0x` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`),
  CONSTRAINT `FKpp54r3u6i6j7tosvn0gbhasb` FOREIGN KEY (`fields_id`) REFERENCES `field` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_fields`
--

LOCK TABLES `section_fields` WRITE;
/*!40000 ALTER TABLE `section_fields` DISABLE KEYS */;
INSERT INTO `section_fields` VALUES ('25085bda-da69-4550-990c-b5021eff380d','05e0a33f-c099-4ed0-a706-b248303145d5'),('4572d9e8-f379-43a3-ad88-d996498d2d2a','089ab75b-7b9d-44f0-a399-dd581ea75935'),('3f74f505-5136-45dc-a337-f7347fb711b7','0a957429-b14a-4c10-a3d9-3e100ce83c76'),('aafb2a2e-29cc-41f6-884e-8f6b6a886dae','0c4d46e6-d8be-4d6c-8610-5a154b82e1f1'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','0d15c21f-2f61-4d09-a31a-712bff883b92'),('3937d505-24d7-4d50-bd67-a986e643244e','0e297de4-6bed-4d76-8063-7c9ebb607377'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','0e7e3eca-3a56-4a3e-96a3-38c0da5d54ca'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','1344fd29-dfc0-4fd1-afe7-1ab08d5a069a'),('25085bda-da69-4550-990c-b5021eff380d','14f3f571-e7b8-4acf-9890-5bf725d1eeb1'),('4572d9e8-f379-43a3-ad88-d996498d2d2a','15ce6b41-ca78-417d-a615-dd2cc3d270d0'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','18998923-a021-4357-94fd-1d6dd03c8d8c'),('20b9851c-c366-4638-97e1-cdaab4fcbf7a','1a3fbf09-bb05-4963-b315-ab068a4cfea5'),('25085bda-da69-4550-990c-b5021eff380d','1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5'),('20b9851c-c366-4638-97e1-cdaab4fcbf7a','1ce00821-b4d9-4e36-a681-0b060d950084'),('25085bda-da69-4550-990c-b5021eff380d','1f3f7b9b-2438-4ff5-ad50-dbc30d70aa66'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','2196729c-89c3-4689-adeb-2ec351331eaf'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','2b322452-5ad8-49d6-ba17-8bc7a35394e9'),('d5d0059e-0658-4e55-b1d9-7859c4aacefb','2c4f685d-6e44-409a-81b6-8b98270e3372'),('43b5b00b-c871-4b76-a7a8-8d5c8278e136','2f737927-b4c7-43dc-ada1-bead93cd90d8'),('e0b34e9b-0c48-4319-a318-0d3de5690d99','372c1390-9e7f-4371-bebb-7e4df21ba148'),('fed067b2-16a5-4571-8e61-d9519a789fdb','378c03af-e019-4c37-9df5-3e116a7d3192'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','37f0a25c-50f8-4a8b-89c4-2befead6b118'),('aafb2a2e-29cc-41f6-884e-8f6b6a886dae','395a6e23-9ddd-4632-9c88-1acf7601113f'),('c803bb40-15b5-4691-b48a-67cb2048c45a','396781c8-025d-406f-bc78-f7b06671e889'),('d5d0059e-0658-4e55-b1d9-7859c4aacefb','3974cf52-3cd2-497d-a7b2-99dfa8b04bc4'),('4572d9e8-f379-43a3-ad88-d996498d2d2a','39f6f0b6-ce52-451c-ac2d-7fd6a93087dd'),('c803bb40-15b5-4691-b48a-67cb2048c45a','3afcec45-80d2-4915-bd4f-a277aa3533f0'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','3c57e7a0-00b2-4dd6-80c5-ec94fadc2ded'),('20b9851c-c366-4638-97e1-cdaab4fcbf7a','3ccce80e-9448-40aa-af4e-815bd1873822'),('4572d9e8-f379-43a3-ad88-d996498d2d2a','3d9f282e-9833-442f-a0a7-6459db24f4a0'),('25085bda-da69-4550-990c-b5021eff380d','3e307313-cb06-485f-9930-4af37a8edcf4'),('d5d0059e-0658-4e55-b1d9-7859c4aacefb','41f5e600-486b-4b7b-8ada-09b78c9b6397'),('20b9851c-c366-4638-97e1-cdaab4fcbf7a','43431db1-599b-4cb7-8826-206d926bac2d'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','46c19fd2-194b-45be-a255-6587fa93cbd7'),('4572d9e8-f379-43a3-ad88-d996498d2d2a','47e664a0-8863-4da0-b4a6-5450a121dfa1'),('25085bda-da69-4550-990c-b5021eff380d','48c2e680-039e-40e9-8fcf-873399df46c6'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','4a516891-c03a-41fe-a2b0-bf4edc1eb8ce'),('4572d9e8-f379-43a3-ad88-d996498d2d2a','4a66182f-a531-4d28-86c2-89d092ef0e5c'),('c803bb40-15b5-4691-b48a-67cb2048c45a','4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','4cfbc609-b1e6-4ea7-aabb-382932d60b75'),('d5d0059e-0658-4e55-b1d9-7859c4aacefb','4d58074e-e278-4874-9cb4-c8d64e53ce7b'),('4572d9e8-f379-43a3-ad88-d996498d2d2a','51aa58a6-4935-4cad-b536-f45d0b10cfc4'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','53bf82b5-dce4-489c-88dc-ebf41e9e0b65'),('c803bb40-15b5-4691-b48a-67cb2048c45a','56ed03e3-a71e-419f-8e03-ac47e4694fce'),('f98674d7-8a2e-4b6b-9169-0fbccd9626e9','573da434-ca26-4ed3-bdbe-1cc2fec2609d'),('20b9851c-c366-4638-97e1-cdaab4fcbf7a','585748b3-215f-41c4-b6b2-7941ec6db3aa'),('dc34817f-ba0b-41dc-9157-d447448c6796','59fb0cdb-874f-4109-9bec-2f84ce6c0ca5'),('3937d505-24d7-4d50-bd67-a986e643244e','5bf383b6-a5bc-4836-aafe-1c9a5d79859c'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','5ce7fb31-ae67-4bce-9327-19e836301d58'),('fed067b2-16a5-4571-8e61-d9519a789fdb','5e5eed86-c402-410d-b363-b978608051cf'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','61efb724-e89c-4211-adea-259f42603027'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','64f7a260-0ace-4a71-b0c0-f8263e7e9522'),('dc34817f-ba0b-41dc-9157-d447448c6796','65861d0a-4db1-4cfe-aea1-013464c7a66b'),('fed067b2-16a5-4571-8e61-d9519a789fdb','66309b80-898b-4ae1-acf5-b716365512a3'),('43b5b00b-c871-4b76-a7a8-8d5c8278e136','66b66a4c-d3a9-46c3-bf09-c1673759c183'),('25085bda-da69-4550-990c-b5021eff380d','679dc64c-b7bb-4821-905f-53ff7dbac7a2'),('dc34817f-ba0b-41dc-9157-d447448c6796','67b31d07-26cb-4fbb-b9b2-aeef984d30f4'),('25085bda-da69-4550-990c-b5021eff380d','6b17fbb6-742b-42d9-92dc-9bf9000e7212'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','6c641d8d-b25a-471e-a710-dbfb5e909a1d'),('4572d9e8-f379-43a3-ad88-d996498d2d2a','6dfda638-c271-4bb4-9ebd-ee31267f7a9a'),('4572d9e8-f379-43a3-ad88-d996498d2d2a','7082055e-d2f1-4ae5-9d36-1a9b8aa14820'),('e0b34e9b-0c48-4319-a318-0d3de5690d99','7124b5e6-f9ee-448a-8501-d2e9602d1535'),('3937d505-24d7-4d50-bd67-a986e643244e','73956663-9121-4667-bda2-265c7287285e'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','73ab11be-420a-4bd0-8137-f453258731dd'),('fed067b2-16a5-4571-8e61-d9519a789fdb','7453fe3f-c790-4618-b33c-dcb440b14d45'),('aafb2a2e-29cc-41f6-884e-8f6b6a886dae','754d63e0-c153-4f7d-b8b3-2bbdd236315f'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','76666ba4-a81b-46fb-88f0-0d1e1ff71148'),('43b5b00b-c871-4b76-a7a8-8d5c8278e136','79acef1c-1027-40be-a853-ced12182bb7e'),('20b9851c-c366-4638-97e1-cdaab4fcbf7a','7a849534-ee63-484b-bff9-fff7249f7eff'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','7ea68279-4cb9-4113-9044-8f1569d53b83'),('43b5b00b-c871-4b76-a7a8-8d5c8278e136','80a73d29-8525-4d0d-8286-4d6dc5e497f5'),('c803bb40-15b5-4691-b48a-67cb2048c45a','849e04a6-169a-482c-9daf-38c938ce6251'),('20b9851c-c366-4638-97e1-cdaab4fcbf7a','8652d8f7-8b87-45ec-a14c-3ac351e536dc'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','89d50461-139b-4be7-8b01-e3ccfbd7c69c'),('25085bda-da69-4550-990c-b5021eff380d','8b3526e0-728a-45b8-8a08-ae87c726e62e'),('43b5b00b-c871-4b76-a7a8-8d5c8278e136','8b74e3ee-9105-4d36-aff2-fe26dec0db8f'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','922d8584-32de-4f07-afee-ad6f3a610498'),('dc34817f-ba0b-41dc-9157-d447448c6796','961436c9-e14f-491d-8a42-60c56f674dd8'),('3f74f505-5136-45dc-a337-f7347fb711b7','9840c038-d6f5-4a5b-afe8-4e9ab35c0a4b'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','9a5d3f8a-c648-43a3-911a-a7df00306c08'),('fed067b2-16a5-4571-8e61-d9519a789fdb','a01261c7-63b2-4010-aaa1-faa37724a6e4'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','a1b86793-da7d-4f5b-8eab-3c920b7448e9'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','a1f9bba9-7daf-4aa2-ab96-03f4eaa405e2'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','a43011ce-5aa0-488f-8f4a-77b4f74d4db8'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','a5be65cd-8066-48ee-bc08-fc56d61e794a'),('25085bda-da69-4550-990c-b5021eff380d','a9810a0f-47dd-4cac-b177-31a7dc84db30'),('fed067b2-16a5-4571-8e61-d9519a789fdb','aa61d46b-61bf-46cb-95e4-a16e18e4de79'),('43b5b00b-c871-4b76-a7a8-8d5c8278e136','aabf40f5-c753-45ba-946d-d9bd00e2176d'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','ac7576c5-3c7f-44df-a887-7bea27532ba6'),('aafb2a2e-29cc-41f6-884e-8f6b6a886dae','b3d00603-91e3-4f74-aadf-921abd62d023'),('dc34817f-ba0b-41dc-9157-d447448c6796','b8b6e19f-84bb-4284-af23-67f3e831f678'),('25085bda-da69-4550-990c-b5021eff380d','bac7bfda-7b70-48f9-8581-13091002112c'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','bdc4bb1b-4850-4ffb-b5c2-2e4ac6851d49'),('aafb2a2e-29cc-41f6-884e-8f6b6a886dae','c0973fdb-c022-468b-b2e8-1e3a9a16ba95'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','c34e9e1c-0d5b-4e6a-b116-4588f64b804d'),('20b9851c-c366-4638-97e1-cdaab4fcbf7a','c4ca68af-caee-4b9d-8634-18dc78bee7c4'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','c5fc1b01-f6c0-48c2-9856-2a4d92eb35a0'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','c76420a0-7afe-4e97-bba8-7a25eede0aee'),('4572d9e8-f379-43a3-ad88-d996498d2d2a','cdd47167-ae31-458d-8a6c-c2186d01c5e0'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','cfea527f-b1cc-4fe5-b255-bffdfaef3d19'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','d3948b18-ae59-4dc1-b9e2-318522a06a3f'),('43b5b00b-c871-4b76-a7a8-8d5c8278e136','d47ef7f0-c05c-423f-8085-23190cb68187'),('dc34817f-ba0b-41dc-9157-d447448c6796','d5dce7fd-2114-4c3f-886f-1a9f78ba3af0'),('1b305ba2-efcc-4e06-875e-377ced5ba65c','d61fedc5-7aac-4f3c-b5e2-0da2efb59aae'),('25085bda-da69-4550-990c-b5021eff380d','dc483670-34ef-4601-a791-9f6564ccecbc'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','ddf96dd3-2b58-4e01-b8df-f13ace0da463'),('25085bda-da69-4550-990c-b5021eff380d','e10f464b-1abb-4b70-87fc-26926a13afbc'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','e1fa2a06-e562-4324-a6d2-e37ba27a08b6'),('25085bda-da69-4550-990c-b5021eff380d','e2429bdd-3fd1-4f00-a399-ebcab17b2e3b'),('25085bda-da69-4550-990c-b5021eff380d','e4144824-19bb-4f36-9bc4-fca2d69b5458'),('c803bb40-15b5-4691-b48a-67cb2048c45a','e5cdccec-474c-45cf-adf7-396917a05bb6'),('b5b662b5-11bf-40dd-b1c9-362f3a881033','e7d38132-7bc4-483b-bf1a-11fdd21d0ac1'),('20b9851c-c366-4638-97e1-cdaab4fcbf7a','e915e49d-718c-4700-b747-a9d71db12259'),('f98674d7-8a2e-4b6b-9169-0fbccd9626e9','ec6d95e9-bef1-4e04-ad18-420a0748905b'),('25085bda-da69-4550-990c-b5021eff380d','f2a8d49c-ccfc-44f7-89e3-fe56907695a2'),('20b9851c-c366-4638-97e1-cdaab4fcbf7a','ff9d44fd-0120-4fa6-a607-160b06fb658d');
/*!40000 ALTER TABLE `section_fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_response_records`
--

DROP TABLE IF EXISTS `section_response_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `section_response_records` (
  `section_id` varchar(255) NOT NULL,
  `response_records_id` varchar(255) NOT NULL,
  PRIMARY KEY (`section_id`,`response_records_id`),
  UNIQUE KEY `UK_j772rnodrdwmttwcipmajs969` (`response_records_id`),
  CONSTRAINT `FKcxu776jntfb7fhbxdvn8amm32` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`),
  CONSTRAINT `FKfahca6pfo3w7d3joemse4arat` FOREIGN KEY (`response_records_id`) REFERENCES `response_record` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_response_records`
--

LOCK TABLES `section_response_records` WRITE;
/*!40000 ALTER TABLE `section_response_records` DISABLE KEYS */;
/*!40000 ALTER TABLE `section_response_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey`
--

DROP TABLE IF EXISTS `survey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `survey` (
  `id` varchar(255) NOT NULL,
  `survey_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey`
--

LOCK TABLES `survey` WRITE;
/*!40000 ALTER TABLE `survey` DISABLE KEYS */;
INSERT INTO `survey` VALUES ('647e5849-3a3c-47ab-82ec-17326f8d3b68','House Hold survey'),('7bf67165-0a45-4a8a-943f-0b49d6ce75af','Village survey');
/*!40000 ALTER TABLE `survey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_responses`
--

DROP TABLE IF EXISTS `survey_responses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `survey_responses` (
  `survey_id` varchar(255) NOT NULL,
  `responses_id` varchar(255) NOT NULL,
  PRIMARY KEY (`survey_id`,`responses_id`),
  UNIQUE KEY `UK_31c67to9p73ufkwvbm5lm4p4e` (`responses_id`),
  CONSTRAINT `FK8y6i39ewu0niqk60pjwm2wvnj` FOREIGN KEY (`responses_id`) REFERENCES `response` (`id`),
  CONSTRAINT `FKp0gml0ba3fdu10y089635nsii` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_responses`
--

LOCK TABLES `survey_responses` WRITE;
/*!40000 ALTER TABLE `survey_responses` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_responses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_sections`
--

DROP TABLE IF EXISTS `survey_sections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `survey_sections` (
  `survey_id` varchar(255) NOT NULL,
  `sections_id` varchar(255) NOT NULL,
  PRIMARY KEY (`survey_id`,`sections_id`),
  UNIQUE KEY `UK_jissqvn2e6t3r0o61nmc8iadb` (`sections_id`),
  CONSTRAINT `FK5fn0qrcv2dlayxmdhwvan1vlg` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`),
  CONSTRAINT `FK8ddmt8anglbs5v25wc7kkyiec` FOREIGN KEY (`sections_id`) REFERENCES `section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_sections`
--

LOCK TABLES `survey_sections` WRITE;
/*!40000 ALTER TABLE `survey_sections` DISABLE KEYS */;
INSERT INTO `survey_sections` VALUES ('647e5849-3a3c-47ab-82ec-17326f8d3b68','168af1f9-2dc9-4b1a-921a-b7f96eab9617'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','1b305ba2-efcc-4e06-875e-377ced5ba65c'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','20b9851c-c366-4638-97e1-cdaab4fcbf7a'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','25085bda-da69-4550-990c-b5021eff380d'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','3937d505-24d7-4d50-bd67-a986e643244e'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','3f74f505-5136-45dc-a337-f7347fb711b7'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','43b5b00b-c871-4b76-a7a8-8d5c8278e136'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','4572d9e8-f379-43a3-ad88-d996498d2d2a'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','aafb2a2e-29cc-41f6-884e-8f6b6a886dae'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','b5b662b5-11bf-40dd-b1c9-362f3a881033'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','c803bb40-15b5-4691-b48a-67cb2048c45a'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','d5d0059e-0658-4e55-b1d9-7859c4aacefb'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','dc34817f-ba0b-41dc-9157-d447448c6796'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','e0b34e9b-0c48-4319-a318-0d3de5690d99'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','f98674d7-8a2e-4b6b-9169-0fbccd9626e9'),('647e5849-3a3c-47ab-82ec-17326f8d3b68','fed067b2-16a5-4571-8e61-d9519a789fdb');
/*!40000 ALTER TABLE `survey_sections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unique_survey`
--

DROP TABLE IF EXISTS `unique_survey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unique_survey` (
  `id` varchar(255) NOT NULL,
  `aadhar_no` varchar(255) DEFAULT NULL,
  `gram_panchayat_code` int DEFAULT NULL,
  `gram_panchayat_name` varchar(255) DEFAULT NULL,
  `head_name` varchar(255) DEFAULT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  `ration_no` varchar(255) DEFAULT NULL,
  `village_id` varchar(255) DEFAULT NULL,
  `ward_no` int DEFAULT NULL,
  `response_id` varchar(255) DEFAULT NULL,
  `card_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_byqfjoquqt1jg4svdoi02ylr9` (`response_id`),
  CONSTRAINT `FKioc0dfa3x180dw2096dd8omib` FOREIGN KEY (`response_id`) REFERENCES `response` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unique_survey`
--

LOCK TABLES `unique_survey` WRITE;
/*!40000 ALTER TABLE `unique_survey` DISABLE KEYS */;
INSERT INTO `unique_survey` VALUES ('SAPHS500001','string',0,'string','string','string','string',NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `unique_survey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` tinyint DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `user_chk_1` CHECK ((`role` between 0 and 1))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('3633c7a6-63d1-4826-9d1d-0bf48e22e3f4','admin@ubasurvey.com','$2a$10$fQBaYMyUK/Cox76QZoKb7OaUxAP82zL9iAgby4P0mDDVcu4Nawh5a',0,'admin'),('44247dd4-5856-4a87-8912-c01d41784efa','string','$2a$10$hnsR7tbooHSbtWQTFKkMV.RgPe2oTI0Kn2UAWWg5igyO6HHsQ22NC',1,'string');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_responses`
--

DROP TABLE IF EXISTS `user_responses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_responses` (
  `user_id` varchar(255) NOT NULL,
  `responses_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`,`responses_id`),
  UNIQUE KEY `UK_2921lyhsw5ig4r06x3yvjj5f1` (`responses_id`),
  CONSTRAINT `FKcvcv4ys1m7qtrjthcl37brynm` FOREIGN KEY (`responses_id`) REFERENCES `response` (`id`),
  CONSTRAINT `FKti6mo76xpvlgc07ounl6c4in` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_responses`
--

LOCK TABLES `user_responses` WRITE;
/*!40000 ALTER TABLE `user_responses` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_responses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `village`
--

DROP TABLE IF EXISTS `village`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `village` (
  `id` varchar(255) NOT NULL,
  `village_name` varchar(255) DEFAULT NULL,
  `block_code` varchar(255) DEFAULT NULL,
  `block_name` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `gram_panchayat_code` varchar(255) DEFAULT NULL,
  `gram_panchyat_name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `village_code` varchar(255) DEFAULT NULL,
  `college_name` varchar(255) DEFAULT NULL,
  `ward_no` int DEFAULT NULL,
  `village_num` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `village`
--

LOCK TABLES `village` WRITE;
/*!40000 ALTER TABLE `village` DISABLE KEYS */;
INSERT INTO `village` VALUES ('0ea70aae-75a5-4ba3-9f4f-adbaf4fbbba9','Amarambedu','6484','Kundrathur','Kancheepuram','6484','Kundrathur','Tamil Nadu','224074','Sairam Institute of Technology',6,0),('28684d84-f5f5-4645-9d07-c54e27b93ef7','Pazhandhandalam','6484','Kundrathur','Kancheepuram','6484','Kundrathur','Tamil Nadu','224099','Sairam Institute of Technology',9,4),('49b05cf6-f79f-4698-a07d-3e3e47bf263f','Somangalam','6484','Kundrathur','Kancheepuram','6484','Kundrathur','Tamil Nadu','224108','Sri Sairam Engineering College',9,7),('58350372-82c9-42c3-a0f0-95fa7fb202b9','Varadharajapuram','6484','Kundrathur','Kancheepuram','6484','Kundrathur','Tamil Nadu','224115','Sri Sairam Engineering College',6,9),('60bd8fca-8d4f-4273-9945-a0030b532b70','Thirumudivakkam','6484','Kundrathur','Kancheepuram','6484','Kundrathur','Tamil Nadu','224111','Sairam Institute of Technology',9,8),('a3190834-9bbb-4964-896f-f2f2c1053be8','Nandambakkam','6484','Kundrathur','Kancheepuram','6484','Kundrathur','Tamil Nadu','224094','Sri Sairam Engineering College',9,3),('add8786f-3b6d-4a01-8d9c-8a3b9b824b37','Erumaiyur','6484','Kundrathur','Kancheepuram','6484','Kundrathur','Tamil Nadu','224076','Sairam Institute of Technology',9,1),('ae2b5b7f-c3fd-4c8c-8750-900387d40bac','Naduveerappattu','6484','Kundrathur','Kancheepuram','6484','Kundrathur','Tamil Nadu','224093','Sri Sairam Engineering College',9,2),('c7b573f8-1441-4a1a-8f99-29bb4aba6990','Poonthandalam','6484','Kundrathur','Kancheepuram','6484','Kundrathur','Tamil Nadu','224101','Sri Sairam Engineering College',9,5),('fc964c26-f7dc-4cd0-b825-96e64c43c6b5','Sethupattu','6484','Kundrathur','Kancheepuram','6484','Kundrathur','Tamil Nadu','224105','Sairam Institute of Technology',9,6);
/*!40000 ALTER TABLE `village` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `village_survey_response`
--

DROP TABLE IF EXISTS `village_survey_response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `village_survey_response` (
  `village_id` varchar(255) NOT NULL,
  `survey_response_id` varchar(255) NOT NULL,
  PRIMARY KEY (`village_id`,`survey_response_id`),
  UNIQUE KEY `UK_4ny96mh4ermnihysqf5fy6xh1` (`survey_response_id`),
  CONSTRAINT `FKabvdaf3fpujc3w82e34sgl7bm` FOREIGN KEY (`village_id`) REFERENCES `village` (`id`),
  CONSTRAINT `FKj4w5j3byavr61jpu8duv2mwgu` FOREIGN KEY (`survey_response_id`) REFERENCES `response` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `village_survey_response`
--

LOCK TABLES `village_survey_response` WRITE;
/*!40000 ALTER TABLE `village_survey_response` DISABLE KEYS */;
/*!40000 ALTER TABLE `village_survey_response` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-25 16:18:11
