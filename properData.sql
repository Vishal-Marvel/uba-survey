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
INSERT INTO `field` VALUES ('030194bb-0eda-47c8-8c13-512cf44a5182','DROPDOWN',NULL,'Card Type',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:43:22.449000',NULL),('05e0a33f-c099-4ed0-a706-b248303145d5','DROPDOWN',NULL,'Frequency of collection of Waste',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:29:04.601000',NULL),('089ab75b-7b9d-44f0-a399-dd581ea75935','STRING',NULL,'Village Name',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:35.692000',NULL),('0a957429-b14a-4c10-a3d9-3e100ce83c76','YES/NO',NULL,'Electricity Connection to Household',NULL,NULL,'3f74f505-5136-45dc-a337-f7347fb711b7','60327e37-867d-45c8-9967-493bc5d7f266','2024-02-14 05:40:37.833000',NULL),('0c4d46e6-d8be-4d6c-8610-5a154b82e1f1','INTEGER',NULL,'Since how many years the migration is taking place?',NULL,'4205334d-1d67-448c-98ae-33f3e3e293e3','aafb2a2e-29cc-41f6-884e-8f6b6a886dae',NULL,'2024-02-14 05:18:44.536000',NULL),('0d15c21f-2f61-4d09-a31a-712bff883b92','STRING',NULL,'Mobile No.',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:58:51.407000',_binary '\0'),('0e297de4-6bed-4d76-8063-7c9ebb607377','STRING',NULL,'Possible Suggestions by Villagers',NULL,'73956663-9121-4667-bda2-265c7287285e','3937d505-24d7-4d50-bd67-a986e643244e',NULL,'2024-02-14 06:00:20.655000',NULL),('0e7e3eca-3a56-4a3e-96a3-38c0da5d54ca','DROPDOWN',NULL,'Marital Status',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:08:24.300000',NULL),('0e9a36e7-1253-476e-af61-2d09430e0ed4','INTEGER',NULL,'How many Years',NULL,'395a6e23-9ddd-4632-9c88-1acf7601113f','aafb2a2e-29cc-41f6-884e-8f6b6a886dae',NULL,'2024-02-14 05:19:38.791000',NULL),('1206f3db-c08a-458b-a9ba-bce9f364826e','INTEGER',NULL,'Fertilizer Use (Kg/Acre)',NULL,'396781c8-025d-406f-bc78-f7b06671e889','c803bb40-15b5-4691-b48a-67cb2048c45a',NULL,'2024-02-14 05:51:34.080000',NULL),('1344fd29-dfc0-4fd1-afe7-1ab08d5a069a','YES/NO',NULL,'Ration Card',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c','8ec10b8f-529d-40a0-8a30-2307dd010345','2024-02-13 23:41:13.744000',_binary '\0'),('14f3f571-e7b8-4acf-9890-5bf725d1eeb1','YES/NO',NULL,'Do you use it','6151e7d2-65f4-43e1-9146-5992b06dc866','485b1075-9475-46c0-904c-5141ece3e250','25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:32:46.313000',NULL),('15ce6b41-ca78-417d-a615-dd2cc3d270d0','STRING',NULL,'Gram Panchayat Name',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:37.692000',NULL),('18998923-a021-4357-94fd-1d6dd03c8d8c','STRING',NULL,'Name of the Head (As per Ration Card)',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:24:25.219000',NULL),('1a3fbf09-bb05-4963-b315-ab068a4cfea5','INTEGER',NULL,'Animal Waste/Cow Dung (in Kg.)',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:58:08.160000',NULL),('1c88b9f1-c3f5-4bf2-85bd-ff816eec34d5','DROPDOWN',NULL,'Where does the blackwater discharge',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:34:33.853000',NULL),('1ce00821-b4d9-4e36-a681-0b060d950084','INTEGER',NULL,'Goats/ Sheep',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:25.873000',NULL),('1f3f7b9b-2438-4ff5-ad50-dbc30d70aa66','DROPDOWN',NULL,'Biogas Plant',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:29:50.046000',NULL),('2196729c-89c3-4689-adeb-2ec351331eaf','STRING',NULL,'Activity done by the SHG',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:18:16.427000',NULL),('2b322452-5ad8-49d6-ba17-8bc7a35394e9','DROPDOWN',NULL,'Presently having ID Card for  Phy.Cha (Y/N)',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:20:04.774000',NULL),('2c4f685d-6e44-409a-81b6-8b98270e3372','STRING',NULL,'Crop',NULL,'3974cf52-3cd2-497d-a7b2-99dfa8b04bc4','d5d0059e-0658-4e55-b1d9-7859c4aacefb',NULL,'2024-02-14 05:55:11.902000',NULL),('2f737927-b4c7-43dc-ada1-bead93cd90d8','STRING',NULL,'Respondent\'s Name',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:16:45.692000',NULL),('372c1390-9e7f-4371-bebb-7e4df21ba148','DROPDOWN',NULL,'Fuel used for Cooking',NULL,NULL,'e0b34e9b-0c48-4319-a318-0d3de5690d99',NULL,'2024-02-14 05:44:21.030000',NULL),('378c03af-e019-4c37-9df5-3e116a7d3192','DROPDOWN',NULL,'Mode of Water Storage',NULL,NULL,'fed067b2-16a5-4571-8e61-d9519a789fdb',NULL,'2024-02-14 05:25:24.932000',NULL),('37f0a25c-50f8-4a8b-89c4-2befead6b118',NULL,NULL,'What kind of skil yould you like to acquire',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:15:01.780000',NULL),('395a6e23-9ddd-4632-9c88-1acf7601113f','YES/NO',NULL,'Any members migrated from other area?',NULL,'4205334d-1d67-448c-98ae-33f3e3e293e3','aafb2a2e-29cc-41f6-884e-8f6b6a886dae','0e9a36e7-1253-476e-af61-2d09430e0ed4','2024-02-14 05:19:38.768000',NULL),('396781c8-025d-406f-bc78-f7b06671e889','YES/NO',NULL,'Do You use organic Manures',NULL,NULL,'c803bb40-15b5-4691-b48a-67cb2048c45a','1206f3db-c08a-458b-a9ba-bce9f364826e','2024-02-14 05:51:34.066000',NULL),('3974cf52-3cd2-497d-a7b2-99dfa8b04bc4','COUNTER',NULL,'Crop Count',NULL,NULL,'d5d0059e-0658-4e55-b1d9-7859c4aacefb',NULL,'2024-02-14 05:54:41.812000',NULL),('39f6f0b6-ce52-451c-ac2d-7fd6a93087dd','STRING',NULL,'Village Code',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:36.692000',NULL),('3afcec45-80d2-4915-bd4f-a277aa3533f0','YES/NO',NULL,'Do you use Chemical Insecticides',NULL,NULL,'c803bb40-15b5-4691-b48a-67cb2048c45a','f4084e74-15de-40d8-960f-b904c59d9938','2024-02-14 05:51:20.007000',NULL),('3c57e7a0-00b2-4dd6-80c5-ec94fadc2ded','STRING',NULL,'If, Rental House Migration from area',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:57:29.802000',NULL),('3ccce80e-9448-40aa-af4e-815bd1873822','DROPDOWN',NULL,'Shelter for Livestock',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:57:35.196000',NULL),('3d9f282e-9833-442f-a0a7-6459db24f4a0','DROPDOWN',NULL,'State',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:00:35.692000',NULL),('3e307313-cb06-485f-9930-4af37a8edcf4','YES/NO',NULL,'Do you have sanitation system',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d','485b1075-9475-46c0-904c-5141ece3e250','2024-02-14 05:31:32.610000',NULL),('41f5e600-486b-4b7b-8ada-09b78c9b6397','STRING',NULL,'Area under the Crop in Prev. (Acre)',NULL,'3974cf52-3cd2-497d-a7b2-99dfa8b04bc4','d5d0059e-0658-4e55-b1d9-7859c4aacefb',NULL,'2024-02-14 05:55:20.446000',NULL),('4205334d-1d67-448c-98ae-33f3e3e293e3','INTEGER',NULL,'How many members of the family migrated',NULL,'754d63e0-c153-4f7d-b8b3-2bbdd236315f','aafb2a2e-29cc-41f6-884e-8f6b6a886dae',NULL,'2024-02-14 05:17:06.249000',NULL),('43431db1-599b-4cb7-8826-206d926bac2d','INTEGER',NULL,'Cows',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:12.660000',NULL),('46c19fd2-194b-45be-a255-6587fa93cbd7','INTEGER',NULL,'Annual Income',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:55:51.700000',NULL),('47e664a0-8863-4da0-b4a6-5450a121dfa1','DROPDOWN',NULL,'District',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:34.692000',NULL),('485b1075-9475-46c0-904c-5141ece3e250','DROPDOWN',NULL,'Location',NULL,'3e307313-cb06-485f-9930-4af37a8edcf4','25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:31:32.625000',NULL),('48c2e680-039e-40e9-8fcf-873399df46c6','STRING',NULL,'Cost of the system',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:37:41.332000',NULL),('4a516891-c03a-41fe-a2b0-bf4edc1eb8ce','INTEGER',NULL,'Male',NULL,'5ce7fb31-ae67-4bce-9327-19e836301d58','1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:25:43.349000',NULL),('4a66182f-a531-4d28-86c2-89d092ef0e5c','DROPDOWN',NULL,'Ward No.',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:39.692000',NULL),('4ac8f1c1-9e23-4b59-a39c-d6ce1f5f398f','DROPDOWN',NULL,'Irrigation',NULL,NULL,'c803bb40-15b5-4691-b48a-67cb2048c45a',NULL,'2024-02-14 05:52:19.635000',NULL),('4cfbc609-b1e6-4ea7-aabb-382932d60b75','DROPDOWN',NULL,'Type of House',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:58:19.602000',NULL),('4d58074e-e278-4874-9cb4-c8d64e53ce7b','STRING',NULL,'Year Productivity (in quintals per Acre)',NULL,'3974cf52-3cd2-497d-a7b2-99dfa8b04bc4','d5d0059e-0658-4e55-b1d9-7859c4aacefb',NULL,'2024-02-14 05:55:24.707000',NULL),('51aa58a6-4935-4cad-b536-f45d0b10cfc4','STRING',NULL,'Block Code',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:41.692000',NULL),('53bf82b5-dce4-489c-88dc-ebf41e9e0b65','DROPDOWN',NULL,'Level of Education (choose the highest level applicable)',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:11:43.455000',NULL),('56ed03e3-a71e-419f-8e03-ac47e4694fce','YES/NO',NULL,'Do you use Chemical Fertilisers',NULL,NULL,'c803bb40-15b5-4691-b48a-67cb2048c45a','ab5b6e88-6999-41a8-91e4-ea07ef42fd21','2024-02-14 05:51:12.420000',NULL),('573da434-ca26-4ed3-bdbe-1cc2fec2609d','DROPDOWN',_binary '�\��\�\0JFIF\0\0`\0`\0\0�\�\0C\0\n\n\n\r\r�\�\0C		\r\r��\0\0�\0�\"\0�\�\0\0\0\0\0\0\0\0\0\0\0	\n�\�\0�\0\0\0}\0!1AQa\"q2���#B��R\��$3br�	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz�����������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\������������\�\0\0\0\0\0\0\0\0	\n�\�\0�\0\0w\0!1AQaq\"2�B����	#3R�br\�\n$4\�%�\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz������������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�����������\�\0\0\0?\0�S��(\0��(\0��(\0���O\��:ε\�-b\�@\�\�����t�\��np��G!W,ʣ\'��u5�\�\�Oۗ\�?\�\�F�kk�O4\�.$ׯe\�`�ݑ�L�\��\�\��`�n\�C�i\ns��`���f��\��o�W-2\�)���\"�\�%�P�l\�u5\�D�KZ�\0�|�P�\0����H\�\�^kp�g��\�$�4\��\�l�{��a�\�jj�o[!]w?Z��ȋ�)G\���}�UԤ�+\�Q��M�Һ��\ny\�\�9g�\�#.\�%\�,-�\\>dKo\���,x=r3W,�~K�\�]w?S�����\0�H�O4v\� M&\�b	l�:mč��`�?g�r?\��\�=8\�\��|���\r;MӼKm��+����#\�_\�\"�f�k�I%�*�y��RA \Z�\�\�\�\�v��zQ\\\�QE\0QE\0QE\0QE\0QH\�K1\n�d�\�P\�ʟ�\�\�c��·\Z-\�\�3Io}�jFyc�X��t6\�х�l�ZtfY\�\"+$��\0v|\��\����t}6O�b\�K�p�\�\�\����s�J\�0�8UH7#$�nW\�_�� �׼S2x�]�lַ���jon|�ƫ�b�hɈ\�T�\0W\�\�\�C\�%V��\�݉���/���\�P]k\�&\�X2jw\�[\�`�7ñR2@��û\'y�\�?��\0�ο�\�\���\���a��\��\�SĒ�i�+L��\0����\�	\0�\���ş�\����\0\�^|n�m�\��\�A\�V\�qd�K\�k ��!P0\"x��L+e�+\�߶\�/x\��{�6�:���_\�\�лF�O�wy\Z\�]Bd�P�+ڎ6�%\nxH\�2\��\�\����6os\��\0��\0��n�i\��/\�u-Wģ\�\�_A\���\�\��;�\��H� �Ӝ�]��2?\�\����ς?�&���\��\���gyu �\��\�X\�,�(�i\�A%��\�\��\�]\��#���k�\�\�mB\�\�Ë�t�6ݖX\�ͻ\�@2mG�h�\�!\�i?�M��\�\�x�x>mb\�A\�\�����H~\�e$\�\�P\�\'\�bL��A\�8\�\�{\��\�\�\�\�Ӫ�{���-�\�\�/x�/i˩h�G�\�5C<��Q�T`ce9\��+\�4O\�\'�\��\0�]\�\�Mx\�G\�ӥ\�m-\��\�\��8��`Q�\��`�����@Y�����\�|(���\�2M!5��h�\�o\"� \�!\�$6I*;d�<Q�v�?\�W\��\0x\n\�\�3x7N��\�4�2\�\��{{H�_=g�p,����H�\�w9��R\�{{\�O��\�\�o������$o؟\�_�\�\�>\�\�y�C�^j\�X\\/�,m _0JҖ�B8.�޼s\��\0��\0Ɩ�W�M=g[�\�\�[y����\�!d\\��.O*\�y�Џ�_���|Q�0\��\�\�ll�-\\x^\�<��\��:��g0;+(�8]UfC�=3^�3�\�\��W\�\Z\�wrx\�\�w��v\�L,\�}wQ�PEf�1\���*��\�rU��G9P��\�\�\�\�\�k\��l-��z��_�)��\��Aߗ�(ͮ�唈�W6גY�Aa\�\�[7k�~��\���+A:��\�亳Y䵑n-f���m��L�$l88u�+�!?iO\�m<%�\�|0���5\��Xծ�{`ne\�\�� \0�\n��D��3�\�\�\����¿h�\�j׋e�\���s0�Sk�\�\�\�C��l��X3@\�̇��\�\�ⲪX�~\�\�_�\���\0\"��3�\�>�X\�~-xtj\Z~\�k\�Db�O3$�l΁ЇBU\�u!�E;YOb�|�N.̠��)\0QE\0QE\0W\��\�\�1�4?�G4˨fF����!]uBsk #�=\��.�\�J���I|t��m��z�\�\�m}>\�{7�\�7�I��b�9f+�XDT|̠�!�\�\�O�;ǂ\�\��[5\�[kiu^\�\�˓\�L\��BY\�L�G�\�Y\�{�F\�Uy\�/r?����\�;\�+\�\��ۯ��\��ZN��,�ƭ�v3eߜ\��������\�\�\�?Í+�u��%�\��%^�;�_J[d�K\�mN%� x��\�i�@uB?7�[�\0�>�%\�ς�|V\���`ԭ�n�\�M\nG�u�wb\�,H߸�\r�Fq� C򿉾\"|N���u�:\�@��=\�w�U�7L\�:,��,獁E�6���Ü�%�\�W�sY(\�r�=�۪��6\�y^\�\�\��\�V�\0��\0\�\�φ6\Z���Rѯ\�4{��n4��e���(��h\�Qʃ�	�u�\�\�uq�\�edl|)`�mc}�!\�l`���rw<��H\n�\���f�����\0\���j\�:W��*+Oʋ�?��\r�M����\����\�\�\�{k=L�h!����$pQF��P0@:W��̨`%(\�W4\��\�/\�\�v�\�\�\��\0\���93x\�VԼaz9��\�Zm�L�\��}}\�\�\�_\��\0�`��\0��#\0o�\�㺓��C7\�\�z�\�Ǿ\'Y%r�8 \���<W\'�sR�Ҿ\�w�R)c�B��1�5�X\�\�\Z15j6����e~�Xz�xPZ94��c��\0�\���5It�D�yy�\�\�\ZF9T/�r1\�\\g��\���\0�m�?\�ủ�\0��\n\�\�#\�n��\0�/\�f��\�,\�\��ę\Z\r�w�q�\�ᯓ\�&\�f��)7�n\�w\��V\��>�>\�\�\�2��\�\�I=��~\Z���\Z�\��~0������5h�eg,\�m\�k\�^�/;%\�\�I\�5\����<A�C��_��\re�?�n\'�\�῍\�4\�\�Y�\�����P\�qÎ1����\�h��UR[o!Hە\'���\�\�׌~\�߲W��\0i\rΡ\�^)�2�Z��c\�OD�\�X��\'����NP\�gQ\�%G��\�n�\�\��>U\�ŞK�U��o៍�]O]�[�\�l�U�ī;���\�\�FY?�\�߉B�c�_0/\�#\�_�> ~\�~;��?\�*��\�O��^�}�����4f����@Y.c��Cpy\�<N��x\��1���\0ǋ�{]z\�L�k�4]JG�L�vB�\�\�1�F\r�wN\�/ܟuO~\�Z\\^�m|4���F\�!�đȰ\�6\�\Z\�\�6;\�>0Va�o�\�\�05UjrN3י얝W\�\�Kv-$���d_\�SV�=\�\�[F�W�eh�\�\�\�ɀ�,\�\�i0vA#�\�\��0��h\����,<i\�\�-gLwkK�8YP��:�Y\"�)\":�:U��\��_��\��\�B\��\�:n�<#lc\�\�\��ƍZ�P*�;�\n\��W~ݥ�\��	�+�	��\�\��OFկ�$ԯ����5۵�x�AȌ���[ycsCfw��\�5\�S\�RX\�>\�\��\�=��#EWȔQE\0QTu\�j\�\�z��_\�\�X\�[\�u<�\�\�\�K1ǰ�?7িM���\�\�E}�\�N0$\�$ë�����w	\�\�ώ~ö\��Ok\�/\��ai�H��J�Q-\r�a�|̬\Z9\�\�Ĩ�a�,�/\�S\�w�!���\�\�͋�k�WީtY��\n�n��`;\�~����A�\�-��a��~)K�\�Go�\�>$��J���YX��Ǒݟ9���~��B�O\�ո\�\�]��\�ө\�\�>8|1�\�k\�]SU�׉\� \�5�d?�Ig���j\�E\'o��}\�\�\�	\�)Z�o�\'\�\�\��\0�Ɠ��Ű��hw\n�Aq�[�\��z\�\�XQy�s��w�x�\0ÿ�7�kZ\r��\�\"x_Q\��a���E�A$��1�[�\�\�?ʙ\"�S~\r�0��;�\�\�\r\�J���E�\�A��c�K.v���W\'<	{שW��\��yy�]�-\��c�v�\"mo\��kJ�Y�{\�\�P�6m\'\��\�ں�H��2�0G�~9�\�\�����a�h�\�rG�Z\\2\\I%\�9ߓ��7p�����`��Zϋ���U�[�����.$b\�\�J$\�D�\nc8�lt�:��u\'\�%c\�\�!x\�[\�V�\�-m�\�Η\�����\�\�φ�_\�ە�]�\�\�:��3nKփ�{��%(�\�\���f��\0�R��\0\�(e\�5H$\�u�kiln��W\�_�z\n�\��\'�\�|-���e�?ކ G�9�\�\�^\"�q�x�V�\�d��uKYRd��!Y�T0\�d~8\"��\�qI*\�9&��B_\�\�f�\��~u�fqy}��̢�5�&��W^�dq6?\n�1�\��I�j3\\\�ڸ6\�4|#��/\�oN\0q\�E�k��\Z\�\�\�͡\�(\�nui\0�\�r1\�X��パ\��~&�~�\��a\�c{�ky<\�n��`�[�{�\�5�geo�Z\�mkv\��JTz\0*i\�2�Q\�õK�Q�4�[ˢ馾��\'�F�j��_d\�nX�%\��\�\�y?\�\�[\�\��!hZ~\�Ҽ/k�i�*�\�\�\'�,\�O]Ŷ�z��<ץ��\�Z/�l\�湫\�\�֤\�\�ܤO�,@\'ھ]���D�\�>4j�\�S��|�r�\�1\\c�j�\�\�\�\�o\�׋�5�r\�\�g>M�\�c��?,Q�\�\�rNI&�H׍\Z1\�]\�\�\�\��� x\\q\\�)\��R{�-=O�?jo�������\�4�\�i�d\�.�i:KI��\�\�I\0~V\n{9�\0�Ԛ�\�\��\0	-�\�$ھ�Ma���\�L��4�i7?\���,�s���\�A���	\�\�}cM������$Z>�qvQ�8v�H$�G�]W#�B?��c�\0���\'�\0�c�\�I���k\�x��\�W�_@W\�܄`�SG\�L�y��\��Z\�S��!^2\�/5\�\�\���>���3L�\�\���\�s~\r�O��<K{\�\�ڸ𭒳ϫ�7��FI���A�F0��\�r\�V�����O\�\�Qj\��\0@�\��j\�1\�Z��\�\�\�\�\'�#��3ھ\��}\�?\���\�t\�m��_SLiZn�M�y#��ፓ+\�˺B\�\�lW\��\0�\�\�ߪ|�>��j1����)X\�:��\��\�yk �{1e\�ǵ�\�\�`O\�a��VXZ�������\�^\�\�\�MQ�\��\�\�\�\�\�\Z\�\�w�\�a��ٷG\r\�L\�\\ĭ���$���\�\�OZ\�\�\��\'O\�)<]�\�N�\�\�\�m�\�:[\���\�}>K�8\�\�Ԛ�־�7F����ƁEV\0\�n�\��Q�\�^:\�e�Ik�\\H\�\r�^\�\�h\�\�g${�W�W��\�P\�\��7\\kD\�q֝t��\�\�_\�\�[�8O\�W\�$��?�\�Z��?h:����\�|?u����%\�\�\�y�l�\�HnT�\0�_�\��\0�\�Ź(->��;��6\�\�\��(�`\r!`�v\�\�~\\�\�w��~/i�T�\��b$�iC�)r�FYb�\�A\�=:_�\Z\'�f�\�6K_�S�\'�\�\�Qç/��q	3o;��HGx�\�rw_q�E�H�-\�\���3��O\�\��+\�?����&�ú.��j�<�#�\�Ak���v��\���\�j���\0�VF�ߴ7�\�%)\�/�.S\�\�\�,=1\��_��֡q�ش�֟l��أ݈����\'lJ�zF(q\�C����_��Jt}NXخ7<S\"䝢D*\�rIۜsҼ\�B���;�}\�\��F�u�3K�\�\�\�=\�󳀒J7�?m�\�\�qҧ׼+㟍�[��\�G��V8�I�72&>e�\�\�0<�p�Hꦺ��?�?��H�ZF�o5e�\�ԘMp:�\����A#�k\�/l�\�n�\0�ǏZ�\'\�*th(>�����K_��C��߃�\r�\0l]h��O}j\�\�%P�fdU/���������\�5�+\�oop���\�WeVal7\0H\r����\�}�_\Z~\�߳_\�\rC\��&�<����\�]*�g�\�4�f�4F1� \�	�瓞���\�e\�ӔS�x�}\�4{���U�\"�\�\��Zx\�\�g�����\�\�\0f���-cDUuBU݀a�^���\�\�\�|O��/ŭ*\�M�T7R �\�X^;����� �R?\��~p�\���>8|y��\��+\�z\��sEV�M\�,%O>\�3(Ugb�PM}\��?~\���犯��;ƾ\"\�V�\�\�sYjң\�@p\�\�\ne;�磷�{�\�\�>\�<���\�\r?��\0��/�<y�\��g\�~\�y\�h�\�7]��\�iZ\�f;�c R|ëp0\0�|7�=�\r��\��\�EЬuk{�~\�\�\�ao��\�Z\r\�T�y��\�B��\�|O\�m\'ƚ-Α�i�jzu\�\�\�\�)�#Ў\�r\"�\Z?\�.O�:Ժ\�\�\���\�/�]\�JD`H;y<��3��qi�)\�~���W\�E{Ԥ�V\\\��_G�DY\���\�Ckkv\�Р�(a@�\Z�����\0\��_�\0��x-<U�/꺆\�7\Z������\0vr\�?J�\��*\��Ksm�G�\�\�D\�$��\���y\�@����ֹ�\��\�;\�ُ\�Tr�ʺ,�q�(ܿ�\�嵗\�)T����\�j\�\�qkɫ3\�?\�\�\�\�s�:/��\�/��\�Oc�b<wv�2�U��GR\� \n�\�m#v0�~֞\�[G��o��:�o\�g��Җk�\��q\�\�\�2���!2\�\�0\��W[�\�\��\r���I��z��8|Oi\��\�S\0®~h�p\nNH\�f�k��\�:\�\�+���ZA�̓\�\�O�\�3\�D�$\r\'UX�*Xn\�=+\�#z9�P�\�\�\�+�y~b\�z��fHo<\�\r�\�\��\�W�dB��+A&?\�W\�\��\��\0��\�>+\�X\�S�0_B~ٓ�ʿE\�\�sx�\�%\��\"��QE\�+\��\0h\�1���7v\n\�֧�B\�1Q��`\��F� ����\�\�*xf\�Ɵ�U�\��k}�\�w6֯ \�&h�D�F\n�\�#�U\�\����(\������\'k��>/\ny�n�ؘClm�1	Y�\0y�>\��A\"�B|E�{\�\'�\�/\�?�~�e\�Ҵ��χ�6�\�pB�A��PC�NF	;�7�kc��o\�\�ٻ�3�]��\�\��n�3��`�	\��_u�\�?d\�xV\�\�z�\�����vn�-<��v�*PHUb*\��a��x\�}\�aO\�ե;M\�K\�ٮ�4\�S8\�xG�O^��\�\�X�t7xu]*�O�]�y�JN2�\��~�W\���(xw\�\�\��x\���u\�\�m7V�\�\�\��_6\�mxYQ�\'%�\�\��\���[\�[\�����Go�e�\�\�;��><�\�\�r��\��\�Ml<�.��\���5�NU�\ZPշe� �w\�]\� \�um�{��}m�J\�I�.��\�\�<;��D�w�R\�\��]�y\�Ϊʤ��\�\���0\�=G�k\�,\��Mxn�-Bk�7nP\�B���8_¾���j�\��\�S�k�.y�\�ĳ\�q���\0O�;W\�\�	�f�NT��\�Z��\�\��\�б�~+)�޵HԋӖI\�\��\��=.������t\�;\���\���\�!\�6��*\�K9�\��$<^\�Ѕ#_\�\�o�o�Ꚏ�˻\�\�F�\ZlBz�<�Z\�\��l��ӆ3ھ���4�B��\��g�	\�\��࿌�u\�o[\\i\�u�R\�@`��F%&�;A(I\�d�p���sW��`��|ZԼ;��\�x�\�\�is�x�L\�.bM�\�	\�x\�w\r�\�AeoN�_]b��\�\�{�\�v��\�r?uOXY�xcIK\�\\�\"�\�脍\�ߧ��_ÿ�5�#\��s�O�]\�z\�O�{q�.��{\����跋�\"�ŋ�}�x�Cy�{\�����\�r��\�-B\�;�fu(�2���ҿ%\�3Li\�\�jFuaSh�h�oum_kߩ�[�\�\�\�\�)�Ӝ7�W��\�w\�z[��\r����m��\�[\�0�B�UG��x\'\�\�\�4�\�\�\��9�!�\�%\�̳Ƭ�\0�������5O^\\\�z�\�zb�\�\rԧ2\0T�\����y\�׌|\��\0`���h��{m03\\L\�\�\�c9T@\�@��\�\�1_��\�*�s*5�\�ѾݹwG\�\�X*�~\"T+;�\�\��N��?�>�Z��|U{��gPԍ�\�xu\�/Lq.֒\�\�� \�\�\��\�zt�n�4�/\�y\�>\��\�\�{��t\�\�?+n,\�#XԬ.�\�7�f�˿��\��\�a�\�\�\�?X��\�\�]� ��\�Y�F\�\�:V�A%{u�2���u�K\�Rxn�\0\�F�\r��)����\�d����$�`�e$�\�$\�G�O0u%	-w\�}\�ݞ]�>��\0�E\�m��$\�E@[��+uny1$�G\�\�\�\�_�\��\��\�\��z_\�\��\�U�\�p�\�R1\�\�,�̍\�p�\�\��\�m�wq�|�i?i��\�{}\��\n(����Q@�߷���~�Pk\�ďgq$����\�h��\�\�;cH\�kH�9#Oc\�J�b�e?n��\�\�\�y.\�\�V��$�����ǐ1�U��\�Ṻn��\�uk5�\�\�\�0��\�.\�\��U���RB\�+����\��\�\�\�\�k[�W\��\0��ㅗ\�?�o��Z�.u�\rDmŽ�nt\�8��=Bg\�#\0G\�\�_�~j_4mgZ��G\�l��Ye����@\�qA|\�^gH�p��\�*Ef�ƾ-���(Ykv0\\h�$\�\��햡\�H#\�h\�k)�0pkl\�O2�,=�\���\0[�-��#��\�\�O��\�M\��|��r�I;�\��\�O\�Mw_g�\�\�Ɇ5�\�ڑơU@\0A^a�;�\�\������ζڔ*��h�H�2�\��7!\�l�a��U��\�i,\�3��`�z\�b��]G-s�**\�d��\�z5���S���\�n\�\��!\�}\��1\�?]}��\�(fi܍�kܑ{\0I\0\\\'���\��w�k���\�	�qkw\�\������*7IC|�\�29=}�K�3�M\�+]{\�*�\��g(\�i�ĸ\�!\�8Rҷ$��h\0Vw\�M\�\�O��\0<Q�\��-g��ⷎ\�2C\�%�#fR9\r�\�rj\�\�a^	N����ۭ��\�\�g5j\�q��\�\�M7.U�K_y��E�}_�g�|k\�o\r\��\0�\��S�\�	�eϓ��J\�����\�\�>_��<\��_\�J\�^ד�\�t�<)\�\�\�\�t1\�\�S=\�%[S\�\��\��_�ڷ\�\�\�F�m{2\�\\\�\��o��\�Bχܽ\�%Oc�\�\�\�\������\r?\�\Zz]�g}��\�?g�A�#N�\�#�\�7Y��\��\�|\�]��h\�\�7	+)A�\��\���\�3\����}\�\r8��Q�S9>[((\�n��ᗇ�g/��\��\0�\�oڠc��#��A�x\'ú���.\�T�:�\�CCRب\�+p�(%\�ʭ��\�1�������m��ws\�kkoK4�8D�e���\0\0�OLW>/��E��(��j�s;|\�~�[0�<O\�\�I\�M+�w��\�q+��?\�_�u�\\2\��V\�=\�r\�\�\�Q���\n�\�8\'���\�\�\��\�/� ��B�|[[�~\�\�أ㌄$ul���\�\��e�ڒ�3�\�n<c �{��8\�1\�C�T�o��]��{�|׾6I}g�_i��\�v\�ye�\�M$2jP\Z\'xaS�\���\����C�Q\��\�\�QP�KZ\��\��\�y\�\�\�\�\�ά����\�\��\0��+\�k\�v��Dg\�5�\�-\�\�#�U�\�oG����s�\�=��\�\�\�\�+��\�\�28窒+\�o\�W\�<�\0<}�ulͦn�\�\�<(*��@q\�)�^�7_�m��\�b#��*ϧ�t�\�~�~\����/\�),�Xc\�U/�2\�\"�YOݐ\��m�}z\�\"�E\n�*��AK_�JNRr{�`��*@(��\0��\�\rB\�k[�#���\Z)a���\����$k�C�\���\��\Z�\�\�]\�c����\r\�Ӱ,f�pQ98�\�Y\"�$�LR�&vX�\0]k�����M��\�{�QQo�\�\�#G�\�L�C��,��\n�;����d�U�H\�\�wA���O���8k��L�Xx�\�\�\�V�<+ywl��\0g\�m�CD�y\�Z<�F�BH%[>��|&�\0���|b\'��Ŷ�\�fڅ\�7W�N�3M=\�\��i��H,\�L�\�@���#�����_��)��\�\�v�\�\'�8Ie�\�܄�\�fP�ܩa�\�g�?��\0��^dz&�\�]2[�k\�4�Y]�i`YR\"v0%Ug�\�\'i%K+�A�11�\��\�\��޾���\�3?�>8�?Yx�\�z�惬B\�s\�Y8*F���5�U�=�\0�L�\'\�;[M\'\�Dk\�-{�Χ\Z�i�\r�\�ա\'Ѳ�\�+\�\��7�Cx\�Ǟ(��/,<7�\�RZ�yn\�w�A�\�0�żo#e�<ّr\�y��>x�\�:���:M�\��b��x\�e�\�:;tA̲ �_`!_\npH�\'�\�=\�\�\�K~�\�\�5[��F�a\�\r:\rCK��Ԭ\']�]Y̲\�\"��) ��e|@�N��#�z���@\�b\�`0�\'ލ�\n:��a�2���!�\�o�o\r��W�\�\�\�}�\�K}�\�\�8\�A\�^ߠ�\0�E�:\�\ZK\�]Z8�o�\�rH\�ȊǧRsɯ��\�u�T���\��\�.Z�p�џW|<���C��H�����\��j\�\�n	�.\�ݪ6\�C\\(l\0\�1�\'\�_rW\���\00�\�}�\�\�t}?+��m1�\�s�W��\����\��9\"\�> \�D�k�a\"\�Fˌ`�ƹ��/^��\�\'\��\0C\��\�0\�te:�\����\Z?jφ\�\��<I�\�.��+�\�\�Ox\�1�\�\�z�Pk������i�D4�Dg��y�M\�BZ\��8�9\�hA\��\�\�o�ꭥ��-�\�\�>жϨ</䉙w�/�n+�\�rG5\�\��_g�\�[�ޱ�\�\�x�{\�ۨ�\�4;�\���\�\�\�N\�qċ\�\�̈xu��\�\�\\�\�~���\�z:\���\0��\0\rou\���\��R\�4�\�V���\�\�\�+�-\�n\�\�r��\�8±_\\����#\�~��\��S\�c\�\�6PCq�\�[<7�=��,�l\�yB�W�^ib��Y0�}�\�}/ãú�\�۽\�ߝ^{l\�\��Wl�n/D~lS}\�a\�d�\�x��\��Oƚ\�\�i��\�\r#�2\�Q�\��;�\Z*�K@\�^���\�\�\�v���\��릁���\�?\�|@�-��b\no!���\�A[�.UAf9`��;2��fPk�\0f?�_~\�[%�Y\�wpĳ\�\�\�D�\�P��I$s�Y�*BlU�\�\��=��K�\�!\� �kK��\��FGO6x�\\\"���]˹��	Yc��޾+6\�~�?gO\�_��q\\�EW\�(��\0(��\0(��\0\�|}�\�D����7Z��Ih.#�� �T�A��I�:�3)����?b?|9\�&��\�\�\���\�\�m6e�F�i-g`\�b\�fü� �f\�/\��Tմ�{K�\�5;;}GM��\�\�\�Ya�\'R��YIH��]�Lml���;ta���|Mk��\�\��Z>�k{�i�1�\���\��`�\�k�\�\��>�\��9-\�e�\�v2�n�g��H\�\rr\�\� mʻ\"+��q��\����\�o\�\r\�\�\�R�)\Z\�\�PwkU���řA�\�9؈�\�D��}�O\�?�`O\Z�7XKK=7Uv�%�&���V�}�K�HY��ʃsoj�\�n\'\�i\�,l9+���\0[�9Zؓ\�/�|�\�����\�q\�\Z\�W�\�\�Q巛S���T4d���\\|�\�w\��\r�?\�\�| ���j��Z�Ɔ$KK�%�\n\�]:�ʒ\�D�� ur<��ᇘ_���euuo�o5i�nSF\�~\��\���s\�#k� �b�mC����η\�&�dQ�0���<7�\�\�^��\n�΍]\�\�\�ӽ\�w\�S\�~Zx\�\����\���~=zK��\�\���[Y��\0�c\�Vy��0����\\ֽ�\�~	�2�)�&\�\�u2G5���:Π/����G���KYVe\�\Z=��Y���=>�\�\�m<��\�6p}\�~\�\�o��6���%���\�\�%��i\n\��\�=꽇-�J�y��\0\�\�p_�=o\�|.\�:ѭ���gF׵6\�\�\�I6�g�b\nɚJ�\�F#a�9�;�\�7���\�ƣ4\��ķv�R�2\�H\�\�nع3\�2Mz7�f\Z��;;�\r:\��\�\�u��\�D��U�Y�)��ukh���}�h�\0;�q_b��\0�j\�K{�\0\�ˡ�����\��Q\Z@��\'�g�b\�=�;)X�nU3\rYK��k\�\���>�o�[\�5&;9��\�.M���Qi/e\nY����+*�,\�\�>i^$\�\�G\��i	�=/Y��_��\�t�\0<8��1�F)<\�\�m\��1�x\�Ğ\��\��\0��\�\�\�D��k\� �\�j��چ�\�g�\0�]\�\0\��h���|�;5���W�\�\�ZIlQEx�\n(��\n(��\n(��\n(��\n(��\n(��\�\�\�,�52��W n\0�H\�\���HRd(讇��\�4Q@\r�\�u\"(��HE��\�lu&��\�\�Df�\\���qEn�(��(��(��(��(��\�','National Mission on Financial Inclusion - Awareness Level',NULL,NULL,'f98674d7-8a2e-4b6b-9169-0fbccd9626e9',NULL,'2024-02-14 06:22:23.076000',NULL),('585748b3-215f-41c4-b6b2-7941ec6db3aa','INTEGER',NULL,'Poultry/Ducks',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:43.122000',NULL),('59fb0cdb-874f-4109-9bec-2f84ce6c0ca5','INTEGER',NULL,'Uncultivable Area (in Acres)',NULL,NULL,'dc34817f-ba0b-41dc-9157-d447448c6796',NULL,'2024-02-14 05:47:37.381000',NULL),('5bf383b6-a5bc-4836-aafe-1c9a5d79859c','STRING',NULL,'Problems',NULL,'73956663-9121-4667-bda2-265c7287285e','3937d505-24d7-4d50-bd67-a986e643244e',NULL,'2024-02-14 06:00:12.743000',NULL),('5ce7fb31-ae67-4bce-9327-19e836301d58','INTEGER',NULL,'No. of family members',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:24:37.936000',NULL),('5e5eed86-c402-410d-b363-b978608051cf','DROPDOWN',NULL,'Open Well (Public / Private)',NULL,NULL,'fed067b2-16a5-4571-8e61-d9519a789fdb',NULL,'2024-02-14 05:25:00.013000',NULL),('60327e37-867d-45c8-9967-493bc5d7f266','INTEGER',NULL,'Electricity Availability per day (hours)',NULL,'0a957429-b14a-4c10-a3d9-3e100ce83c76','3f74f505-5136-45dc-a337-f7347fb711b7',NULL,'2024-02-14 05:40:37.847000',NULL),('6151e7d2-65f4-43e1-9146-5992b06dc866','STRING',NULL,'Why are you not using the sanitation system',NULL,'14f3f571-e7b8-4acf-9890-5bf725d1eeb1','25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:32:46.337000',NULL),('61efb724-e89c-4211-adea-259f42603027','INTEGER',NULL,'Others',NULL,'5ce7fb31-ae67-4bce-9327-19e836301d58','1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:25:53.027000',NULL),('64f7a260-0ace-4a71-b0c0-f8263e7e9522','STRING',NULL,'Nature of Disability',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:19:18.339000',NULL),('65861d0a-4db1-4cfe-aea1-013464c7a66b','INTEGER',NULL,'Barren/Waste land area (in Acres)',NULL,NULL,'dc34817f-ba0b-41dc-9157-d447448c6796',NULL,'2024-02-14 05:47:12.981000',NULL),('66309b80-898b-4ae1-acf5-b716365512a3','DROPDOWN',NULL,'Piped Water at Home',NULL,NULL,'fed067b2-16a5-4571-8e61-d9519a789fdb',NULL,'2024-02-14 05:23:48.882000',NULL),('66b66a4c-d3a9-46c3-bf09-c1673759c183','STRING',NULL,'Address',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:23:04.695000',NULL),('679dc64c-b7bb-4821-905f-53ff7dbac7a2','DROPDOWN',NULL,'Type of system',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:37:05.214000',NULL),('67b31d07-26cb-4fbb-b9b2-aeef984d30f4','INTEGER',NULL,'Un irrigated Area (in Acres)',NULL,NULL,'dc34817f-ba0b-41dc-9157-d447448c6796',NULL,'2024-02-14 05:47:23.239000',NULL),('6b17fbb6-742b-42d9-92dc-9bf9000e7212','STRING',NULL,'Cleaning period',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:37:36.616000',NULL),('6c641d8d-b25a-471e-a710-dbfb5e909a1d','STRING',NULL,'Aadhaar No',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:58:43.419000',_binary '\0'),('6dfda638-c271-4bb4-9ebd-ee31267f7a9a','STRING',NULL,'Gram Panchayat Code',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:38.692000',NULL),('7082055e-d2f1-4ae5-9d36-1a9b8aa14820','ID',NULL,'Survey Id',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:00:33.692000',NULL),('7124b5e6-f9ee-448a-8501-d2e9602d1535','DROPDOWN',NULL,'If LPG, Subsidy',NULL,NULL,'e0b34e9b-0c48-4319-a318-0d3de5690d99',NULL,'2024-02-14 05:44:56.105000',NULL),('73956663-9121-4667-bda2-265c7287285e','COUNTER',NULL,'Major problems in village, if any (Top 3)',NULL,NULL,'3937d505-24d7-4d50-bd67-a986e643244e',NULL,'2024-02-14 05:59:40.444000',NULL),('73ab11be-420a-4bd0-8137-f453258731dd','INTEGER',NULL,'Ration Card No.',NULL,'8ec10b8f-529d-40a0-8a30-2307dd010345','1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:46:12.921000',NULL),('7453fe3f-c790-4618-b33c-dcb440b14d45','DROPDOWN',NULL,'Community Water Tap',NULL,NULL,'fed067b2-16a5-4571-8e61-d9519a789fdb',NULL,'2024-02-14 05:23:57.136000',NULL),('754d63e0-c153-4f7d-b8b3-2bbdd236315f','YES/NO',NULL,'Does any member of the household migrate for Work?',NULL,NULL,'aafb2a2e-29cc-41f6-884e-8f6b6a886dae','4205334d-1d67-448c-98ae-33f3e3e293e3','2024-02-14 05:17:06.229000',NULL),('76666ba4-a81b-46fb-88f0-0d1e1ff71148','DROPDOWN',NULL,'Details of Phy. Challened (Y/N)',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:18:33.299000',NULL),('79acef1c-1027-40be-a853-ced12182bb7e','STRING',NULL,'Relationship with Head of Household ',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:16:48.692000',NULL),('7a849534-ee63-484b-bff9-fff7249f7eff','INTEGER',NULL,'Bullocks',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:35.040000',NULL),('7b9a82c1-501c-4b42-988c-882a55299147','INTEGER',NULL,'Fertilizer Use (Kg/Acre)',NULL,'849e04a6-169a-482c-9daf-38c938ce6251','c803bb40-15b5-4691-b48a-67cb2048c45a',NULL,'2024-02-14 05:51:26.048000',NULL),('7ea68279-4cb9-4113-9044-8f1569d53b83','STRING',NULL,'Name of the SHG',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:18:02.700000',NULL),('80a73d29-8525-4d0d-8286-4d6dc5e497f5','DROPDOWN',NULL,'Respondent\'s Gender',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:16:47.692000',NULL),('849e04a6-169a-482c-9daf-38c938ce6251','YES/NO',NULL,'Do you use Chemical Weedicide',NULL,NULL,'c803bb40-15b5-4691-b48a-67cb2048c45a','7b9a82c1-501c-4b42-988c-882a55299147','2024-02-14 05:51:26.034000',NULL),('8652d8f7-8b87-45ec-a14c-3ac351e536dc','INTEGER',NULL,'Average Daily Production of Milk(Litres)',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:57:59.315000',NULL),('89d50461-139b-4be7-8b01-e3ccfbd7c69c','DROPDOWN',NULL,'Category',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:33:22.852000',NULL),('8b3526e0-728a-45b8-8a08-ae87c726e62e','DROPDOWN',NULL,'Toilet',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:28:18.564000',NULL),('8b74e3ee-9105-4d36-aff2-fe26dec0db8f','STRING',NULL,'Pincode',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:23:10.318000',NULL),('8ec10b8f-529d-40a0-8a30-2307dd010345','DROPDOWN',NULL,'Card Type',NULL,'1344fd29-dfc0-4fd1-afe7-1ab08d5a069a','1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:41:13.830000',NULL),('922d8584-32de-4f07-afee-ad6f3a610498','DROPDOWN',NULL,'If APL',NULL,'bdc4bb1b-4850-4ffb-b5c2-2e4ac6851d49','1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:55:23.347000',NULL),('961436c9-e14f-491d-8a42-60c56f674dd8','INTEGER',NULL,'Cultivable Area (in Acres)',NULL,NULL,'dc34817f-ba0b-41dc-9157-d447448c6796',NULL,'2024-02-14 05:46:53.223000',NULL),('9840c038-d6f5-4a5b-afe8-4e9ab35c0a4b','DROPDOWN',NULL,'Lighting',NULL,NULL,'3f74f505-5136-45dc-a337-f7347fb711b7',NULL,'2024-02-14 05:41:50.345000',NULL),('9a5d3f8a-c648-43a3-911a-a7df00306c08','INTEGER',NULL,'Female',NULL,'5ce7fb31-ae67-4bce-9327-19e836301d58','1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:25:48.999000',NULL),('a01261c7-63b2-4010-aaa1-faa37724a6e4','DROPDOWN',NULL,'Supplied water by Pvt / GOVT Supply',NULL,NULL,'fed067b2-16a5-4571-8e61-d9519a789fdb',NULL,'2024-02-14 05:24:25.710000',NULL),('a1b86793-da7d-4f5b-8eab-3c920b7448e9','STRING',NULL,'Bank A/C',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:12:30.326000',NULL),('a1f9bba9-7daf-4aa2-ab96-03f4eaa405e2','STRING',NULL,'Present Status of employment (Employed / Unemployed )',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:12:49.011000',NULL),('a43011ce-5aa0-488f-8f4a-77b4f74d4db8','COUNTER',NULL,'Family Member Count',NULL,NULL,'b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-13 23:59:54.127000',NULL),('a5be65cd-8066-48ee-bc08-fc56d61e794a','STRING',NULL,'Mobile No.',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:12:35.119000',NULL),('a9810a0f-47dd-4cac-b177-31a7dc84db30','DROPDOWN',NULL,'Drainage linked to House',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:28:39.234000',NULL),('aa61d46b-61bf-46cb-95e4-a16e18e4de79','DROPDOWN',NULL,'Hand Pump (Public / Private)',NULL,NULL,'fed067b2-16a5-4571-8e61-d9519a789fdb',NULL,'2024-02-14 05:24:52.607000',NULL),('aabf40f5-c753-45ba-946d-d9bd00e2176d','STRING',NULL,'Respondent\'s Mobile No.',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:23:17.739000',NULL),('ab5b6e88-6999-41a8-91e4-ea07ef42fd21','INTEGER',NULL,'Fertilizer Use (Kg/Acre)',NULL,'56ed03e3-a71e-419f-8e03-ac47e4694fce','c803bb40-15b5-4691-b48a-67cb2048c45a',NULL,'2024-02-14 05:51:12.436000',NULL),('ac7576c5-3c7f-44df-a887-7bea27532ba6','DROPDOWN',NULL,'Gender M/F/O',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:07:25.764000',NULL),('b3d00603-91e3-4f74-aadf-921abd62d023','STRING',NULL,'Migrated From',NULL,'0e9a36e7-1253-476e-af61-2d09430e0ed4','aafb2a2e-29cc-41f6-884e-8f6b6a886dae',NULL,'2024-02-14 05:21:01.186000',NULL),('b8b6e19f-84bb-4284-af23-67f3e831f678','INTEGER',NULL,'Irrigated Area (in Acres)',NULL,NULL,'dc34817f-ba0b-41dc-9157-d447448c6796',NULL,'2024-02-14 05:47:00.889000',NULL),('bac7bfda-7b70-48f9-8581-13091002112c','DROPDOWN',NULL,'Waste Source segregated',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:27:22.144000',NULL),('bbb2878e-0250-449b-98b3-b704d4e7c0bc','DROPDOWN',NULL,'Card Type',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:38:08.243000',NULL),('bdc4bb1b-4850-4ffb-b5c2-2e4ac6851d49','DROPDOWN',NULL,'Social Status',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:54:20.519000',NULL),('c0973fdb-c022-468b-b2e8-1e3a9a16ba95','INTEGER',NULL,'Family migrates for how many days / months?',NULL,'4205334d-1d67-448c-98ae-33f3e3e293e3','aafb2a2e-29cc-41f6-884e-8f6b6a886dae',NULL,'2024-02-14 05:17:57.144000',NULL),('c34e9e1c-0d5b-4e6a-b116-4588f64b804d','DROPDOWN',NULL,'Living in',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:56:39.275000',NULL),('c4ca68af-caee-4b9d-8634-18dc78bee7c4','INTEGER',NULL,'Buffalo',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:17.944000',NULL),('c5fc1b01-f6c0-48c2-9856-2a4d92eb35a0','STRING',NULL,'Aadhaar Card',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:12:04.752000',NULL),('c76420a0-7afe-4e97-bba8-7a25eede0aee','STRING',NULL,'Chief Minister Comprehensive Health Insurance Scheme No',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:12:19.586000',NULL),('cdd47167-ae31-458d-8a6c-c2186d01c5e0','STRING',NULL,'Block Name',NULL,NULL,'4572d9e8-f379-43a3-ad88-d996498d2d2a',NULL,'2024-02-13 22:16:40.692000',NULL),('cfea527f-b1cc-4fe5-b255-bffdfaef3d19','DROPDOWN',NULL,'If women, is she a member of a SHG',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:17:44.515000',NULL),('d306d8de-dd48-4f86-b653-bffd0bb5bcbf','DROPDOWN',NULL,'Card Type',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:44:03.242000',NULL),('d3948b18-ae59-4dc1-b9e2-318522a06a3f','DROPDOWN',NULL,'If unemployed Would like to under go skill training',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:13:37.968000',NULL),('d47ef7f0-c05c-423f-8085-23190cb68187','INTEGER',NULL,'Respondent\'s Age (years) :',NULL,NULL,'43b5b00b-c871-4b76-a7a8-8d5c8278e136',NULL,'2024-02-13 22:16:46.692000',NULL),('d5dce7fd-2114-4c3f-886f-1a9f78ba3af0','INTEGER',NULL,'Total (in Acres)',NULL,NULL,'dc34817f-ba0b-41dc-9157-d447448c6796',NULL,'2024-02-14 05:46:45.662000',NULL),('d61fedc5-7aac-4f3c-b5e2-0da2efb59aae','STRING',NULL,'Religion',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 22:33:53.481000',NULL),('dc483670-34ef-4601-a791-9f6564ccecbc','DROPDOWN',NULL,'Waste Collection',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:27:55.234000',NULL),('ddf96dd3-2b58-4e01-b8df-f13ace0da463','INTEGER',NULL,'Age (Yrs.)',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:05:50.798000',NULL),('e10f464b-1abb-4b70-87fc-26926a13afbc','DROPDOWN',NULL,'Where do they discharge the greywater',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:38:12.587000',NULL),('e1fa2a06-e562-4324-a6d2-e37ba27a08b6','STRING',NULL,'Relationship to the Head of Family',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:05:12.619000',NULL),('e2429bdd-3fd1-4f00-a399-ebcab17b2e3b','DROPDOWN',NULL,'Compost Pit',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:29:27.351000',NULL),('e4144824-19bb-4f36-9bc4-fca2d69b5458','STRING',NULL,'Material used to make the system',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:37:31.794000',NULL),('e5cdccec-474c-45cf-adf7-396917a05bb6','DROPDOWN',NULL,'Irrigation System',NULL,NULL,'c803bb40-15b5-4691-b48a-67cb2048c45a',NULL,'2024-02-14 05:52:55.399000',NULL),('e7d38132-7bc4-483b-bf1a-11fdd21d0ac1','STRING',NULL,'Name (First name)',NULL,'a43011ce-5aa0-488f-8f4a-77b4f74d4db8','b5b662b5-11bf-40dd-b1c9-362f3a881033',NULL,'2024-02-14 00:00:31.082000',NULL),('e915e49d-718c-4700-b747-a9d71db12259','STRING',NULL,'Others (mention )',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:53.664000',NULL),('ec6d95e9-bef1-4e04-ad18-420a0748905b','INTEGER',NULL,'National Mission on Financial Inclusion - Beneficiary Individuals',NULL,NULL,'f98674d7-8a2e-4b6b-9169-0fbccd9626e9',NULL,'2024-02-14 06:22:26.349000',NULL),('f2a8d49c-ccfc-44f7-89e3-fe56907695a2','STRING',NULL,'Dimension of the system',NULL,NULL,'25085bda-da69-4550-990c-b5021eff380d',NULL,'2024-02-14 05:37:24.931000',NULL),('f4084e74-15de-40d8-960f-b904c59d9938','INTEGER',NULL,'Fertilizer Use (Kg/Acre)',NULL,'3afcec45-80d2-4915-bd4f-a277aa3533f0','c803bb40-15b5-4691-b48a-67cb2048c45a',NULL,'2024-02-14 05:51:20.023000',NULL),('fe5c42aa-3b3d-447f-8e9c-f05d4a8145c5','DROPDOWN',NULL,'Social Status',NULL,NULL,'1b305ba2-efcc-4e06-875e-377ced5ba65c',NULL,'2024-02-13 23:53:13.865000',NULL),('ff9d44fd-0120-4fa6-a607-160b06fb658d','INTEGER',NULL,'Calves',NULL,NULL,'20b9851c-c366-4638-97e1-cdaab4fcbf7a',NULL,'2024-02-14 05:56:30.400000',NULL);
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
