CREATE DATABASE healthcare;
GO
USE healthcare;
GO
--drop database healthcare
CREATE TABLE dbo.[Role]
   (roleId int PRIMARY KEY NOT NULL IDENTITY,  
   roleName nvarchar(25) NOT NULL)  
GO  

CREATE TABLE dbo.[User]  
   (
   userId int PRIMARY KEY NOT NULL IDENTITY,
   roleId int FOREIGN KEY REFERENCES [Role](roleId),
   firstName nvarchar(max) NOT NULL,  
   lastName nvarchar(max) NOT NULL,  
   email nvarchar(max) NOT NULL,
   [password] nvarchar(max) NOT NULL,
   gender nvarchar(25) NULL,
   phoneNumber nvarchar(25) NULL,
   [address] nvarchar(max)NULL,
   [image] varBinary(max) NULL,
   createdAt date NULL,
   updatedAt date NULL
   )  
GO  


CREATE TABLE dbo.[Handbook]  
   (
   handBookId int PRIMARY KEY NOT NULL IDENTITY,  
   adminId int NOT NULL FOREIGN KEY REFERENCES [User](userId),  
   name nvarchar(max) NOT NULL,
   publishAt date NOT NULL,  
   content ntext NULL
   )  
GO 

CREATE TABLE dbo.[Position]  
   (
   positionId int PRIMARY KEY NOT NULL IDENTITY,  
   name nvarchar(max) NOT NULL
   )  
GO 

CREATE TABLE dbo.[Province]  
   (
   provinceId int PRIMARY KEY NOT NULL IDENTITY,  
   name nvarchar(max) NOT NULL
   )  
GO 

CREATE TABLE dbo.[MedicalFacilityInfo]  
   (
   medicalFacilityInfoId int PRIMARY KEY NOT NULL IDENTITY,
   medicalFacilityId int NOT NULL FOREIGN KEY REFERENCES [User](userId),
   provinceId int NOT NULL FOREIGN KEY REFERENCES [Province](provinceId),
   [description] nvarchar(max) NULL,
   established date NULL,
   createdAt date NULL,
   updatedAt date NULL
   )  
GO 

CREATE TABLE dbo.[Specialty]  
   (
   specialtyId int PRIMARY KEY NOT NULL IDENTITY,  
   name nvarchar(max) NOT NULL,
   [description] nvarchar(max) NULL,
   [image] varBinary(max) NULL
   )  
GO 

CREATE TABLE dbo.[Price]  
   (
   priceId int PRIMARY KEY NOT NULL IDENTITY,
   priceValue int NOT NULL
   )  
GO 

CREATE TABLE dbo.[Doctor_Working_Info]  
   (
   doctorWorkingInfoId int PRIMARY KEY NOT NULL IDENTITY,  
   doctorId int FOREIGN KEY REFERENCES [User](userId),
   medicalFacilityInfoId int FOREIGN KEY REFERENCES [MedicalFacilityInfo](medicalFacilityInfoId),
   specialtyId int FOREIGN KEY REFERENCES [Specialty](specialtyId),
   positionId int FOREIGN KEY REFERENCES [Position](positionId),
   priceId int NOT NULL FOREIGN KEY REFERENCES [Price](priceId),
   createdAt date NULL,
   updatedAt date NULL
   )  
GO 

CREATE TABLE dbo.[Facility_Specialty]  
   (
   id int PRIMARY KEY NOT NULL IDENTITY,  
   medicalFacilityInfoId int NOT NULL FOREIGN KEY REFERENCES [MedicalFacilityInfo](medicalFacilityInfoId),
   specialtyId int NOT NULL FOREIGN KEY REFERENCES [Specialty](specialtyId),
   )  
GO 
 

CREATE TABLE dbo.[Feedback]  
   (
   feedBackId int PRIMARY KEY NOT NULL IDENTITY,  
   patientId int NOT NULL FOREIGN KEY REFERENCES [User](userId),
   doctorWorkingInfoId int NOT NULL FOREIGN KEY REFERENCES [Doctor_Working_Info](doctorWorkingInfoId),
   content nvarchar(max) NOT NULL,
   createdAt date NULL,
   updatedAt date NULL
   )  
GO 

CREATE TABLE dbo.[Status]  
   (
   statusId int PRIMARY KEY NOT NULL IDENTITY,
   statusName nvarchar(max) NOT NULL
   )  
GO 

CREATE TABLE dbo.[Time]  
   (
   timeId int PRIMARY KEY NOT NULL IDENTITY,
   timeValue nvarchar(max) NOT NULL
   )  
GO 

CREATE TABLE dbo.[Schedule]  
   (
   scheduleId int PRIMARY KEY NOT NULL IDENTITY,
   doctorWorkingInfoId int NOT NULL FOREIGN KEY REFERENCES [Doctor_Working_Info](doctorWorkingInfoId),
   timeId int NOT NULL FOREIGN KEY REFERENCES [Time](timeId),
   scheduleDate date NOT NULL
   )  
GO 

CREATE TABLE dbo.[Appointment]  
   (
   appointmentId int PRIMARY KEY NOT NULL IDENTITY,
   userId int NOT NULL FOREIGN KEY REFERENCES [User](userId),
   doctorWorkingInfoId int NOT NULL FOREIGN KEY REFERENCES [Doctor_Working_Info](doctorWorkingInfoId),
   timeId int NOT NULL FOREIGN KEY REFERENCES [Time](timeId),
   statusId int NOT NULL FOREIGN KEY REFERENCES [Status](statusId),
   reasonExamination nvarchar(max) NOT NULL,
   bookingDate date NOT NULL
   )  
GO 


SET IDENTITY_INSERT dbo.[Role] ON;
GO
INSERT dbo.[Role] (RoleID, RoleName)  
    VALUES (1, N'Qu???n tr??? vi??n') , (2, N'B??c s??'), (3, N'B???nh nh??n'), (4, N'C?? s??? y t???');
GO 
SET IDENTITY_INSERT dbo.[Role] OFF;
GO

SET IDENTITY_INSERT dbo.[User] ON;
GO
INSERT dbo.[User] (userId, roleId, firstName, lastName, email, [password], gender, phoneNumber,[address], [image], createdAt, updatedAt)  
    VALUES	(1, 1, N'Ph?? C??ng', N'Lu??n', 'luanpc@gmail.com', '123456', 'Nam', '0999999999', N'H?? N???i', NULL, NULL, NULL),
			(2, 1, N'Ph???m Xu??n', N'Trung', 'trungpx@gmail.com', '123456', 'Nam', '0966666666',N'H?? N???i' , NULL, NULL, NULL),
			
			(3, 2, N'Tr???n Ng???c', N'??n', 'antn@gmail.com', '123456', 'Nam', '0888888888', N'S??? 219 L?? Du???n - Hai B?? Tr??ng - H?? N???i' ,NULL, NULL, NULL),
			(4, 2, N'Nguy???n Mai', N'H???ng', 'hongnm@gmail.com', '123456', N'N???', '0985555555', N'S??? 1E Tr?????ng Chinh - Thanh Xu??n - H?? N???i' , NULL, NULL, NULL),
			(5, 2, N'Nguy???n Tuy???t', N'X????ng', 'xuongnt@gmail.com', '123456', 'Nam', '0888888888', N'T???ng 1, SH5-CT3 Iris Garden, 30 Tr???n H???u D???c, C???u Di???n, Nam T??? Li??m, H?? N???i' ,NULL, NULL, NULL),
			(6, 2, N'????o ????nh', N'Thi', 'thidd@gmail.com', '123456', 'Nam', '0985555555', N'S??? 33, ng?? 38, ph??? Ph????ng Mai - ?????ng ??a - H?? N???i' , NULL, NULL, NULL),
			(7, 2, N'Nguy???n Th??? Ho??i', N'An', 'annth@gmail.com', '123456', N'N???', '0888888888', N'S??? 1E Tr?????ng Chinh - Thanh Xu??n - H?? N???i' ,NULL, NULL, NULL),
			(8, 2, N'D????ng Minh', N'Tr??', 'tridm@gmail.com', '123456', 'Nam', '0985555555', N'101 Tr???n H???u Trang, Ph?????ng 10, Qu???n Ph?? Nhu???n, Th??nh ph??? H??? Ch?? Minh' , NULL, NULL, NULL),
			
			(9, 3, N'Nguy???n V??n', N'B??nh', 'binhnv@gmail.com', '123456', 'Nam', '09812312321', N'H?? N???i' , NULL, NULL, NULL),
			(10, 3, N'Nguy???n V??n', N'?????c', 'ducnv@gmail.com', '123456', 'Nam', '0777777777', N'H?? N???i' ,NULL, NULL, NULL),
			
			(11, 4, N'B???nh vi???n', N'Y h???c c??? truy???n Trung ????ng', 'yhoccotruyentw@gmail.com', '123456', NULL, '0987654321', N'S??? 29 Nguy???n B???nh Khi??m, Hai B?? Tr??ng, H?? N???i' , NULL, NULL, NULL),
			(12, 4, N'B???nh vi???n', N'Ch??? R???y', 'chorayhospital@gmail.com', '123456', NULL, '0987654321', N'201B Nguy???n Ch?? Thanh, Ph?????ng 12, Qu???n 5, H??? Ch?? Minh' , NULL, NULL, NULL),
			(13, 4, N'Ph??ng kh??m B???nh vi???n', N'?????i h???c Y D?????c 1', 'yhoccotruyentw@gmail.com', '123456', NULL, '0987654321', N'20-22 D????ng Quang Trung, Ph?????ng 12, Qu???n 10, Tp. HCM' , NULL, NULL, NULL),
			(14, 4, N'B???nh vi???n h???u ngh???', N'Vi???t ?????c', 'vietduchospital@gmail.com', '123456', NULL, '0123456789', N'S??? 16-18 Ph??? Do??n - Ho??n Ki???m - H?? N???i' , NULL, NULL, NULL),
			(15, 4, N'B???nh vi???n', N'Y h???c c??? truy???n Trung ????ng', 'yhoccotruyentw@gmail.com', '123456', NULL, '0987654321', N'S??? 29 Nguy???n B???nh Khi??m, Hai B?? Tr??ng, H?? N???i' , NULL, NULL, NULL),
			(16, 4, N'B???nh vi???n', N'Ch??? R???y', 'chorayhospital@gmail.com', '123456', NULL, '0987654321', N'201B Nguy???n Ch?? Thanh, Ph?????ng 12, Qu???n 5, H??? Ch?? Minh' , NULL, NULL, NULL),
			(17, 4, N'Ph??ng kh??m B???nh vi???n', N'?????i h???c Y D?????c 1', 'yhoccotruyentw@gmail.com', '123456', NULL, '0987654321', N'20-22 D????ng Quang Trung, Ph?????ng 12, Qu???n 10, Tp. HCM' , NULL, NULL, NULL),
			(18, 4, N'B???nh vi???n h???u ngh???', N'Vi???t ?????c', 'vietduchospital@gmail.com', '123456', NULL, '0123456789', N'S??? 16-18 Ph??? Do??n - Ho??n Ki???m - H?? N???i' , NULL, NULL, NULL);
GO 
SET IDENTITY_INSERT dbo.[User] OFF;
GO


SET IDENTITY_INSERT dbo.[Handbook] ON;
GO
INSERT dbo.[Handbook] (handBookId, adminId, name, publishAt, content)  
    VALUES	(1, 1 , N'Chi???n l?????c Online Marketing ph??ng kh??m: Tr???n b??? t??? A ?????n Z', '2022/09/13', NULL),
    	(2, 1 , N'G???i ?? 5 ?? t?????ng Marketing ph??ng kh??m gi??p thu h??t kh??ch h??ng', '2022/09/13', NULL),
    	(3, 1 , N'Review 5 ?????a ch??? ??i???u tr??? t??n nhang uy t??n, hi???u qu??? t???i H?? N???i', '2022/09/13', NULL);
GO
SET IDENTITY_INSERT dbo.[Handbook] OFF;
GO


SET IDENTITY_INSERT dbo.[Position] ON;
GO
INSERT dbo.[Position] (positionId, name)  
    VALUES	(1, N'B??c s??'),
			(2, N'Th???c s??'),
			(3, N'Ti???n s??'),
			(4, N'Ph?? gi??o s??'),
			(5, N'Gi??o s??');
GO
SET IDENTITY_INSERT dbo.[Position] OFF;
GO 


SET IDENTITY_INSERT dbo.[Province] ON;
GO
INSERT dbo.[Province] (provinceId, name)  
    VALUES	(1, N'H?? N???i'),
			(2, N'H??? Ch?? Minh'),
			(3, N'???? N???ng'),
			(4, N'C???n Th??'),
			(5, N'B??nh D????ng'),
			(6, N'?????ng Nai'),
			(7, N'Qu???ng Ninh'),
			(8, N'Th???a Thi??n Hu???'),
			(9, N'Qu???ng B??nh'),
			(10, N'Kh??nh H??a');
GO
SET IDENTITY_INSERT dbo.[Province] OFF;
GO


SET IDENTITY_INSERT dbo.[Specialty] ON;
GO
INSERT dbo.[Specialty] (specialtyId, name, [description], [image])  
    VALUES	(1, N'C?? x????ng kh???p', NULL , NULL),
			(2, N'Th???n kinh', NULL, NULL),
			(3, N'Ti??u h??a', NULL, NULL),
			(4, N'Tim m???ch', NULL , NULL),
			(5, N'Tai M??i H???ng', NULL, NULL),
			(6, N'C???t s???ng', NULL , NULL),
			(7, N'Nhi khoa', NULL , NULL),
			(8, N'Da li???u', NULL , NULL);
GO 
SET IDENTITY_INSERT dbo.[Specialty] OFF;
GO

SET IDENTITY_INSERT dbo.[MedicalFacilityInfo] ON;
GO
INSERT dbo.[MedicalFacilityInfo] (medicalFacilityInfoId, medicalFacilityId, provinceId, [description], established, createdAt, updatedAt)  
    VALUES	(1, 11, 1, NULL , NULL, NULL, NULL),
			(2, 12, 2, NULL , NULL, NULL, NULL),
			(3, 13, 2, NULL , NULL, NULL, NULL),
			(4, 14, 1, NULL , NULL, NULL, NULL),
			(5, 15, 1, NULL , NULL, NULL, NULL),
			(6, 16, 2, NULL , NULL, NULL, NULL),
			(7, 17, 2, NULL , NULL, NULL, NULL),
			(8, 18, 1, NULL , NULL, NULL, NULL);
GO
SET IDENTITY_INSERT dbo.[MedicalFacilityInfo] OFF;
GO


SET IDENTITY_INSERT dbo.[Price] ON;
GO
INSERT dbo.[Price] (priceId, priceValue)  
    VALUES	(1, 200000),
			(2, 250000),
			(3, 300000),
			(4, 350000),
			(5, 400000),
			(6, 450000),
			(7, 500000);
GO
SET IDENTITY_INSERT dbo.[Price] OFF;
GO


SET IDENTITY_INSERT dbo.[Doctor_Working_Info] ON;
GO
INSERT dbo.[Doctor_Working_Info] (doctorWorkingInfoId, doctorId, medicalFacilityInfoId, specialtyId, positionId, priceId, createdAt, updatedAt)  
    VALUES	(1, 3, 1, 1, 1, 1, NULL, NULL),
			(2, 4, 2, 2, 3, 3, NULL, NULL),
			(3, 5, 3, 3, 2, 4, NULL, NULL),
			(4, 6, 4, 4, 5, 5, NULL, NULL),
			(5, 7, 5, 5, 4, 6, NULL, NULL),
			(6, 8, 6, 6, 3, 7, NULL, NULL);
GO 
SET IDENTITY_INSERT dbo.[Doctor_Working_Info] OFF;
GO


SET IDENTITY_INSERT dbo.[Facility_Specialty] ON;
GO
INSERT dbo.[Facility_Specialty] (id, medicalFacilityInfoId, specialtyId)  
    VALUES	(1, 1, 1),(2, 1, 2),(3, 1, 3),(4, 1, 4),(5, 1, 5),(6, 1, 6),(7, 1, 7),(8, 1, 8),
			(9, 2, 1),(10, 2, 2),(11, 2, 3),(12, 2, 4),(13, 2, 5),
			(14, 3, 1),(15, 3, 2),(16, 3, 3),(17, 3, 4),(18, 3, 5),(19, 3, 6),(20, 3, 7),(21, 3, 8),
			(22, 4, 1),(23, 4, 2),(24, 4, 3),(25, 4, 4),(26, 4, 5),(27, 4, 6),(28, 4, 7),(29, 4, 8),
			(30, 5, 1),(31, 5, 2),(32, 5, 3),(33, 5, 4),(34, 5, 5),(35, 5, 6),(36, 5, 7),(37, 5, 8),
			(38, 6, 1),(39, 6, 2),(40, 6, 3),(41, 6, 4),(42, 6, 5),
			(43, 7, 1),(44, 7, 2),(45, 7, 3),(46, 7, 4),(47, 7, 5),(48, 7, 6),(49, 7, 7),(50, 7, 8),
			(51, 8, 1),(52, 8, 2),(53, 8, 3),(54, 8, 4),(55, 8, 5),(56, 8, 6),(57, 8, 7),(58, 8, 8);
GO
SET IDENTITY_INSERT dbo.[Facility_Specialty] OFF;
GO


SET IDENTITY_INSERT dbo.[Status] ON;
GO
INSERT dbo.[Status] (statusId, statusName)  
    VALUES	(1, N'L???ch h???n m???i'),
			(2, N'???? x??c nh???n'),
			(3, N'???? kh??m xong'),
			(4, N'???? h???y');
GO 
SET IDENTITY_INSERT dbo.[Status] OFF;
GO


SET IDENTITY_INSERT dbo.[Time] ON;
GO
INSERT dbo.[Time] (timeId, timeValue)  
    VALUES	(1, '8:00 - 9:00'),
			(2, '9:00 - 10:00'),
			(3, '10:00 - 11:00'),
			(4, '11:00 - 12:00'),
			(5, '13:00 - 14:00'),
			(6, '14:00 - 15:00'),
			(7, '15:00 - 16:00'),
			(8, '16:00 - 17:00');
GO 
SET IDENTITY_INSERT dbo.[Time] OFF;