create database PMQuanLySinhVien
go

use  PMQuanLySinhVien
go

create table khoa_hoc(
	ID int identity primary key,
	ten_khoa_hoc nvarchar(100) not null,
	ngay_bat_dau date default(GETDATE()),
	ngay_ket_thuc date
)
GO

create table quyen(
	ID int identity primary key,
	ten_quyen nvarchar(100)
)
GO

create table giao_vien(
	ID int identity primary key,
	ten_giao_vien nvarchar(100),
	so_dien_thoai nvarchar(10) unique,
	email nvarchar(100) unique,
	password nvarchar(100),
	dia_chi nvarchar(100),
	ngay_sinh date default(GETDATE()),
	trang_thai tinyint default(1),
	quyen_ID int foreign key references quyen(ID) 
)
GO

create table lop_hoc(
	ID int identity primary key,
	ten_lop_hoc nvarchar(100),
	khoa_hoc_ID int foreign key references khoa_hoc(ID),
	giao_vien_ID int foreign key references giao_vien(ID)
)
GO

create table hoc_vien(
	ID int identity primary key,
	ma_hoc_vien nvarchar(100) not null unique,
	ten_hoc_vien nvarchar(100) not null,
	so_dien_thoai varchar(10) unique,
	email varchar(100) unique,
	dia_chia nvarchar(100),
	ngay_sinh date default(GETDATE()),
	gioi_tinh tinyint default(1),
	trang_thai tinyint default(1),
	lop_hoc_ID int foreign key references lop_hoc(ID)
)  
GO

create table mon_hoc(
	ID int identity primary key,
	ten_mon_hoc nvarchar(100),
	tin_chi int,
	hoc_phi int,
	trang_thai tinyint default(1)


)
GO

create table diem(
	ID INT IDENTITY PRIMARY KEY,
	ngay_thi date ,
	diem int,
	trang_thai tinyint default(1),
	ghi_chu nvarchar(500),
	hoc_vien_ID int foreign key references hoc_vien(ID),
	mon_hoc_ID int foreign key references mon_hoc(ID)
	
)
GO

insert into quyen values
(N'Hiệu trưởng'),
(N'Phó hiệu trưởng'),
(N'Giáo viên'),
(N'Giáo viên thực tập')
GO

insert into giao_vien(ten_giao_vien,so_dien_thoai,email,password,dia_chi,ngay_sinh,trang_thai,quyen_ID) values
(N'Trần Thu T','0961114104','chang@gmail.com','123456','HN','1999-11-12',1,2),
(N'Nguyễn Thái H','0886860224','hung@gmail.com','123456','HP','1995-02-24',1,1),
(N'Nguyễn Thái M','0987152452','minhanh@gmail.com','123456','BN','1997-01-12',1,3),
(N'Ngyễn Thái V','0961117584','vietanh@gmail.com','123456','HN','1998-11-24',1,4),
(N'Nguyễn Thanh T','0961114888','david@gmail.com','123456','hp','2002-11-30',1,2)
go

insert into khoa_hoc(ten_khoa_hoc,ngay_bat_dau,ngay_ket_thuc) values
(N'Khóa học 1','2016-09-05','2020-05-25'),
(N'Khóa học 2','2017-09-05','2021-05-25'),
(N'Khóa học 3','2018-09-05','2022-05-25'),
(N'Khóa học 4','2019-09-05','2023-05-25'),	
(N'Khóa học 5','2020-09-05','2024-05-25')
GO

insert into lop_hoc(ten_lop_hoc,khoa_hoc_ID,giao_vien_ID) values
(N'CA1_K1_DNO',1,2),
(N'CA2_K1_DNO',1,2),
(N'CA2_K1_DNO',1,2),
(N'CA2_K2_DNO',1,3),
(N'CA3_K1_DNO',1,3),
(N'CA3_K2_DNO',1,3),
(N'CA3_K3_DNO',1,3)
GO

insert into hoc_vien(ma_hoc_vien,ten_hoc_vien,so_dien_thoai,email,dia_chia,ngay_sinh,gioi_tinh,trang_thai,lop_hoc_ID) values
(N'B0001',N'Ngô Thị Anh','012332112','Le.NT@gmail.com',N'Phạm Văn Đồng, Bắc Từ Liêm, Hà Nội','2004-01-09',2,1,2),
(N'B0002',N'Ngô Thị Duyên','03309134','Duyen.NT@gmail.com',N'Lạc Long Quân, Bắc Từ Liêm, Hà Nội','2004-01-27',2,1,2),
(N'B0003',N'Lê Văn Hải','01804288','Hai.LV@gmail.com',N'Phạm Văn Đồng, Bắc Từ Liêm, Hà Nội','2004-01-28',1,1,2),
(N'B0004',N'Trịnh Văn Mạnh','06930886 ','Manh.TV@gmail.com',N'Âu Cơ, Bắc Từ Liêm, Hà Nội','2004-02-27',1,1,5),
(N'B0005',N'Đoạn Văn Trường','08169277','Truong.DV@gmail.com',N'Khuất Duy Tiến, Nam Từ Liêm, Hà Nội','2004-05-24',1,1,2),
(N'B0006',N'Đàm Vĩnh Quang','01463691','Quang.DV@gmail.com',N', Lê Trọng Tấn, Thanh Xuân, Hà Nội','2004-04-12',1,1,2),
(N'B0007',N'Hạ Như Quỳnh','04238335','Quynh.HN@gmail.com',N'Định Công, Hoàng Mai, Hà Nội','2004-09-11',2,1,3),
(N'B0008',N'Trần Bảo Ý','0785386','Bao_Y.TB@gmail.com',N'Nguyễn Trãi, Thanh Xuân, Hà Nội','2004-12-23',2,1,3),
(N'B0009',N'Hạ Liên Liên','0976049','Lien.HLL@gmail.com',N'Nhân Chính, Thanh Xuân, Hà Nội','2004-11-11',2,1,3),
(N'B0010',N'Hà Như Yên','0516649','Yen.HN@gmail.com',N'Trung Hòa, Thanh Xuân, Hà Nội','2004-03-09',2,1,5),
(N'B0011',N'Nguyễn Bảo Anh','019641421','Anh.NB@gmail.com',N'Phạm Văn Đồng, Bắc Từ Liêm, Hà Nội','2005-02-09',1,1,2),
(N'B0012',N'Ngô Thị Ánh','01002362','Anh.NT@gmail.com',N'Yên Hòa, Đống Đa, Hà Nội','2005-01-18',2,1,2),
(N'B0013',N'Hải Hạ Duyên','01349002','Duyen.H2@gmail.com',N'Kim Mã, Ngọc Khánh, Ba Đình, Hà Nội','2005-11-09',2,1,2),
(N'B0014',N'Cao Văn Bình','07368690','Binh.CVC@gmail.com',N'Quan Hòa Hà Nội, Hà Nội','2005-12-03',1,1,2),
(N'B0015',N'Lò Văn Đến','02520059','Den.LV@gmail.com',N'Dịch Vọng, Cầu Giấy, Hà Nội','2005-12-02',1,1,2),
(N'B0016',N'Đoạn Văn Hoàng','01751392','Hoang.DV2@gmail.com',N'Xuân Thủy, Cầu Giấy, Hà Nội','2005-05-01',1,1,2),
(N'B0017',N'Hải Lê Hoàng','00383426','Hoang.HL1@gmail.com',N'Xuân Phương, Nam Từ Liêm, Hà Nội','2005-07-09',1,1,2),
(N'B0018',N'Nguyễn Thị Duy Loan','04089172','Loan.NTD@gmail.com',N'Vân Canh, Từ Liêm, Hà Nội','2005-06-06',2,1,2),
(N'B0020',N'Ngô Cao Ánh','09034556','Anh.NCC@gmail.com',N'Lê Quang Đạo, Mễ Trì, Từ Liêm, Hà Nội','2005-09-01',2,1,2)
GO
insert into mon_hoc(ten_mon_hoc,tin_chi,hoc_phi) values
(N'Triết Học',15,45000),
(N'Kinh tế chính trị',12,45000),
(N'Chủ Nghĩa Xã Hội Khoa Học',20,45000),
(N'Lịch sử đảng',15,40000),
(N'Toán cao cấp',25,55000),
(N'Quân sự',15,45000),
(N'Tư tưởng Hồ Chí Minh',18,55000),
(N'Quan hệ kinh tế quốc tế',17,95000), 
(N'Xác suất thống kê',25,60000),
(N'Giao nhận vận tải',10,45000),
(N'Tin học đại cương',10,45000),
(N'Tiếng Anh giao tiếp',20,45000)
GO

insert into diem(hoc_vien_ID,mon_hoc_ID,ngay_thi,diem,trang_thai,ghi_chu) values
(19,1,N'2020-04-24',8,1,''),
(19,2,N'2020-04-24',5,1,''),
(19,3,N'2020-04-24',5,1,''),
(19,4,N'2020-04-24',6,1,''),
(19,5,N'2020-04-24',1,1,''),
(19,6,N'2020-04-24',9,1,''),
(15,11,N'2020-04-24',8,1,''),
(15,9,N'2020-01-24',5,1,''),
(15,10,N'2020-05-24',5,1,''),
(15,6,N'2020-05-24',6,1,''),
(15,8,N'2020-02-24',1,1,''),
(15,1,N'2020-04-24',9,1,'')
go
-----------------------------Proc Hoc Vien--------------------------------------------------

use PMQuanLySinhVien
go

create proc proc_getAllHV
AS
SELECT hv.*,lh.ID'lop_hoc_id',lh.ten_lop_hoc'ten_lop_hoc' FROM hoc_vien hv 
LEFT join lop_hoc lh on lh.ID = hv.lop_hoc_ID
GO

 

create proc proc_getHVById
@id nvarchar
AS
SELECT * FROM hoc_vien WHERE id like @id
GO


create proc proc_createHV
	@ma_hoc_vien nvarchar(100),
    @ten_hoc_vien nvarchar(100),
	@so_dien_thoai nvarchar(10),
	@email nvarchar(100),
	@dia_chia nvarchar(100) ,
	@ngay_sinh date,
	@gioi_tinh tinyint,
    @trang_thai tinyint,
	@lop_hoc_ID int
AS
BEGIN

	insert into hoc_vien (ma_hoc_vien, ten_hoc_vien, so_dien_thoai, email, dia_chia, ngay_sinh, gioi_tinh, trang_thai, lop_hoc_ID)
	VALUES(@ma_hoc_vien,@ten_hoc_vien,@so_dien_thoai,@email,@dia_chia,@ngay_sinh,@gioi_tinh,@trang_thai, @lop_hoc_ID)

END
go

create proc proc_updateHV
	@id int,
	@ma_hoc_vien nvarchar(100),
    @ten_hoc_vien nvarchar(100),
	@so_dien_thoai nvarchar(10),
	@email nvarchar(100),
	@dia_chia nvarchar(100) ,
	@ngay_sinh date,
	@gioi_tinh tinyint,
    @trang_thai tinyint,
	@lop_hoc_ID int

AS
BEGIN

	UPDATE hoc_vien set ma_hoc_vien =@ma_hoc_vien ,ten_hoc_vien=@ten_hoc_vien, so_dien_thoai=@so_dien_thoai , email=@email, dia_chia=@dia_chia, ngay_sinh=@ngay_sinh, gioi_tinh=@gioi_tinh, trang_thai = @trang_thai,lop_hoc_ID= @lop_hoc_ID
	WHERE id = @id

END
go
create proc proc_deleteHV
@id int
AS
BEGIN
	DELETE FROM hoc_vien WHERE id= @id
END
go
create proc proc_SearchHV
	@ten_hoc_vien nvarchar(100)
AS
BEGIN
SELECT hv.*,lh.ID'lop_hoc_id',lh.ten_lop_hoc'ten_lop_hoc' FROM hoc_vien hv 
LEFT join lop_hoc lh on lh.ID = hv.lop_hoc_ID
WHERE ten_hoc_vien LIKE '%'+ @ten_hoc_vien +'%'
END
GO 
----------------------proc Khoa Hoc-------------------------------

create proc proc_getAllKH
AS
SELECT * FROM khoa_hoc
go

create proc proc_getKHById
@id int
AS
SELECT * FROM khoa_hoc WHERE id = @id
go

create proc proc_createKH
	@ten_khoa_hoc nvarchar(100),
	@ngay_bat_dau date,
    @ngay_ket_thuc date

AS
BEGIN
	
	insert into khoa_hoc(ten_khoa_hoc,ngay_bat_dau,ngay_ket_thuc)
	VALUES(@ten_khoa_hoc,@ngay_bat_dau,@ngay_ket_thuc)
END
go
create proc proc_updateKH
	@id int,
    @ten_khoa_hoc nvarchar(100),
	@ngay_bat_dau date,
    @ngay_ket_thuc date

AS
BEGIN
	UPDATE khoa_hoc set ten_khoa_hoc=@ten_khoa_hoc, ngay_bat_dau=@ngay_bat_dau, ngay_ket_thuc = @ngay_ket_thuc
	WHERE id = @id

END
go

create proc proc_deleteKH
@id int
AS
BEGIN
	DELETE FROM khoa_hoc WHERE id= @id
END
go
create proc proc_SearchKH
	@ten_khoa_hoc nvarchar(100)
AS
BEGIN
SELECT * FROM khoa_hoc
WHERE ten_khoa_hoc LIKE '%'+ @ten_khoa_hoc +'%'
END
GO 

-------------------ProC Lop Hoc----------------------------


create proc proc_getAllLH
AS
SELECT lh.*,kh.ID'khoa_hoc_id',kh.ten_khoa_hoc'Ten_khoa_hoc', gv.ID'giao_vien_id',gv.ten_giao_vien'Ten_giao_vien' FROM lop_hoc lh 
left join khoa_hoc kh on kh.ID = lh.khoa_hoc_ID
left join giao_vien gv on gv.ID = lh.giao_vien_ID 
GO

create proc proc_getLHById
@id int
AS
SELECT * FROM lop_hoc WHERE id like @id
GO

create proc proc_createLH
	@ten_lop_hoc nvarchar(10),
	@khoa_hoc_ID int,
	@giao_vien_ID int

AS
BEGIN
	insert into lop_hoc (ten_lop_hoc, khoa_hoc_ID, giao_vien_ID)
	VALUES(@ten_lop_hoc,@khoa_hoc_ID,@giao_vien_ID)

END
go
create proc proc_updateLH
	@id int,
	@ten_lop_hoc nvarchar(10),
	@khoa_hoc_ID int,
	@giao_vien_ID int

AS
BEGIN

	UPDATE lop_hoc set ten_lop_hoc=@ten_lop_hoc, khoa_hoc_ID=@khoa_hoc_ID, giao_vien_ID=@giao_vien_ID
	WHERE id = @id

END
go
create proc proc_deleteLH
@id int
AS
BEGIN
	DELETE FROM lop_hoc WHERE id= @id
END
go
create proc proc_SearchLH
	@ten_lop_hoc nvarchar(100)
AS
BEGIN
SELECT lh.*,kh.ID'khoa_hoc_id',kh.ten_khoa_hoc'Ten_khoa_hoc', gv.ID'giao_vien_id',gv.ten_giao_vien'Ten_giao_vien' FROM lop_hoc lh 
left join khoa_hoc kh on kh.ID = lh.khoa_hoc_ID
left join giao_vien gv on gv.ID = lh.giao_vien_ID 
WHERE ten_lop_hoc LIKE '%'+ @ten_lop_hoc +'%'
END
GO 
--------------------------ProC Diem---------------------------------------
create proc proc_getAllDiem
AS
SELECT d.*,hv.ID'hoc_vien_ID',hv.ma_hoc_vien,hv.ten_hoc_vien,mh.ID'mon_hoc_ID',mh.ten_mon_hoc FROM diem d
LEFT JOIN hoc_vien hv ON hv.ID = d.hoc_vien_ID
LEFT JOIN mon_hoc mh ON mh.ID = d.mon_hoc_ID
GO



create proc proc_createDiem
@ngay_thi date,
@diem int ,
@trang_thai tinyint,
@ghi_chu nvarchar(500),
@hoc_vien_ID int ,
@mon_hoc_ID int
AS
BEGIN
insert into diem(ngay_thi,diem,trang_thai,ghi_chu,hoc_vien_ID,mon_hoc_ID)
VALUES(@ngay_thi,@diem,@trang_thai,@ghi_chu,@hoc_vien_ID,@mon_hoc_ID)
END
GO 
create proc proc_updateDiem
@id INT,
@ngay_thi date,
@diem int ,
@trang_thai tinyint,
@ghi_chu nvarchar(500),
@hoc_vien_ID int ,
@mon_hoc_ID int
AS
BEGIN
	UPDATE diem set  ngay_thi=@ngay_thi,diem=@diem,trang_thai= @trang_thai,ghi_chu=@ghi_chu,hoc_vien_ID=@hoc_vien_ID, mon_hoc_ID= @mon_hoc_ID
	WHERE  id = @id
END
GO
create proc proc_deleteDiem
@id int
AS
BEGIN
	DELETE FROM diem WHERE id= @id
END
go
create proc proc_SearchDiem
	@ma_hoc_vien nvarchar(100)
AS
BEGIN
SELECT d.*,hv.ID'hoc_vien_ID',hv.ma_hoc_vien,hv.ten_hoc_vien,mh.ID'mon_hoc_ID',mh.ten_mon_hoc FROM diem d
LEFT JOIN hoc_vien hv ON hv.ID = d.hoc_vien_ID
LEFT JOIN mon_hoc mh ON mh.ID = d.mon_hoc_ID
WHERE ma_hoc_vien LIKE '%'+ @ma_hoc_vien +'%'
END
GO 

--------------------------ProC Giao Vien-----------------------------------

create proc proc_getAllGV
AS
SELECT gv.*,q.ID'quyen_id',q.ten_quyen'Ten_quyen' FROM giao_vien gv 
left join quyen q on q.ID = gv.quyen_ID
GO
exec proc_getAllGV
go

 

create proc proc_getGVById
@id nvarchar
AS
SELECT * FROM giao_vien WHERE id like @id
GO


create proc proc_createGV
    @ten_giao_vien nvarchar(100),
	@so_dien_thoai nvarchar(10),
	@email nvarchar(100),
	@password nvarchar(100) ,
	@dia_chi nvarchar(100),
	@ngay_sinh date,
    @trang_thai tinyint,
	@quyen_ID int
AS
BEGIN

	insert into giao_vien (ten_giao_vien, so_dien_thoai, email, password, dia_chi, ngay_sinh, trang_thai, quyen_ID)
	VALUES(@ten_giao_vien,@so_dien_thoai,@email,@password,@dia_chi,@ngay_sinh,@trang_thai,@quyen_ID)

END
go

create proc proc_updateGV
	@id int,
	@ten_giao_vien nvarchar(100),
	@so_dien_thoai nvarchar(10),
	@email nvarchar(100),
	@password nvarchar(100) ,
	@dia_chi nvarchar(100),
	@ngay_sinh date,
    @trang_thai tinyint,
	@quyen_ID int

AS
BEGIN

	UPDATE giao_vien set ten_giao_vien =@ten_giao_vien ,so_dien_thoai=@so_dien_thoai, email=@email , password=@password, dia_chi=@dia_chi, ngay_sinh=@ngay_sinh, trang_thai=@trang_thai,quyen_ID= @quyen_ID
	WHERE id = @id

END
go
create proc proc_deleteGV
@id int
AS
BEGIN
	DELETE FROM giao_vien WHERE id= @id
END
go
create proc proc_SearchGV
	@ten_giao_vien nvarchar(100)
AS
BEGIN
SELECT gv.*,q.ID'quyen_id',q.ten_quyen'Ten_quyen' FROM giao_vien gv 
left join quyen q on q.ID = gv.quyen_ID
WHERE ten_giao_vien LIKE '%'+ @ten_giao_vien +'%'
END
GO 
-----------------------ProC Mon Hoc------------------------------
create proc proc_getAllMH
AS
SELECT * FROM mon_hoc
GO

create proc proc_getMHById
@id int
AS
SELECT * FROM mon_hoc WHERE id like @id
GO

create proc proc_createMH
	@ten_mon_hoc nvarchar(100),
	@tin_chi int,
	@hoc_phi int,
	@trang_thai tinyint

AS
BEGIN
	insert into mon_hoc (ten_mon_hoc, tin_chi, hoc_phi,trang_thai)
	VALUES(@ten_mon_hoc,@tin_chi,@hoc_phi,@trang_thai)

END
go
create proc proc_updateMH
	@id int,
	@ten_mon_hoc nvarchar(100),
	@tin_chi int,
	@hoc_phi int,
	@trang_thai tinyint

AS
BEGIN

	UPDATE mon_hoc set ten_mon_hoc=@ten_mon_hoc, tin_chi=@tin_chi, hoc_phi=@hoc_phi,trang_thai=@trang_thai
	WHERE id = @id

END
go
create proc proc_deleteMH
@id int
AS
BEGIN
	DELETE FROM mon_hoc WHERE id= @id
END
go
create proc proc_SearchMH
	@ten_mon_hoc nvarchar(100)
AS
BEGIN
SELECT * FROM mon_hoc
WHERE ten_mon_hoc LIKE '%'+ @ten_mon_hoc +'%'
END
GO 
--------------------ProC Quyen-----------------------------
create proc proc_getAllQuyen
AS
SELECT * FROM quyen
GO

create proc proc_getQuyenById
@id int
AS
SELECT * FROM quyen WHERE id like @id
GO

create proc proc_createQuyen
	@ten_quyen nvarchar(100)

AS
BEGIN
	insert into quyen (ten_quyen)
	VALUES(@ten_quyen)

END
go
create proc proc_updateQuyen
	@id int,
	@ten_quyen nvarchar(100)

AS
BEGIN

	UPDATE quyen set ten_quyen=@ten_quyen
	WHERE id = @id

END
go
create proc proc_deleteQuyen
@id int
AS
BEGIN
	DELETE FROM quyen WHERE id= @id
END
go

create proc proc_login
@email nvarchar(100),
@password nvarchar(100),
@quyen_ID int out
AS
BEGIN
	SELECT giao_vien.ID,ten_giao_vien,so_dien_thoai,email,password,dia_chi,ngay_sinh,trang_thai,quyen.ID'quyen_ID',quyen.ten_quyen FROM giao_vien
	 INNER JOIN quyen on quyen.ID = giao_vien.quyen_ID WHERE email = @email and password = @password
	 set @quyen_ID = (SELECT quyen.ID'role_ID' FROM giao_vien
	 INNER JOIN quyen on quyen.ID = giao_vien.quyen_ID WHERE email = @email and password = @password)
END
GO

