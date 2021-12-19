DROP DATABASE Database_BanDienThoai

--tạo Database QuanLyDT
CREATE DATABASE Database_BanDienThoai
go

-- sử dung database QuanLyDT
USE Database_BanDienThoai
go

-- bạo bản 
CREATE TABLE Loai (
	MaLoai nvarchar(50) not null,
	TenLoai nvarchar(100)

	primary key(MaLoai)
)
go

CREATE TABLE DienThoai (
	MaDT int IDENTITY(1,1) not null,
	TenDT nvarchar(100),
	Gia bigint,
	Anh nvarchar(50),
	NgayNhap date,
	SoLuong bigint,
	MaLoai nvarchar(50),
	sao int,
	DanhGia nvarchar(250),

	primary key(MaDT)
)
go

CREATE TABLE ThongSoKyThuat (
	MaTSKT int IDENTITY(1,1) not null,
	MangHinh nvarchar(100),
	CameraSau nvarchar(50),
	CameraTruoc nvarchar(50),
	CPU nvarchar(50),
	HeDieuHanh nvarchar(50),
	BoNhoVaRam nvarchar(100),
	Pin bigint,
	KetNoi nvarchar(100),
	MaDT int

	primary key(MaTSKT)
)
go

CREATE TABLE KhachHang (
	MaKH bigint IDENTITY(1,1) not null,
	TenKH nvarchar(100),
	DiaChi nvarchar(250),
	SDT nvarchar(20),
	Email nvarchar(50),
	TenDN nvarchar(50),
	PassDN nvarchar(30)

	primary key(MaKH)
)
go


CREATE TABLE LichSuMuaHang(
	MaLSMH bigint IDENTITY(1,1) not null,
	tenKH nvarchar(50),
	TenDN nvarchar(50),
	Email nvarchar(100),
	Gia bigint,
	NgayMua date,
	SoLuong bigint,
	TrangThai nvarchar(100),
	GhiChu nvarchar(250)

	primary key(MaLSMH)
)
go

CREATE TABLE adminn (
	TenDangNhap nvarchar(50) not null,
	MatKhau nvarchar(50),
	Quyen bit

	primary key(TenDangNhap)
)
go

CREATE TABLE LichSuChinhSua(
	MaLSCS int not null,
	NoiDung nvarchar(250),
	TenDangNhap nvarchar(50)
)

-- nối các bản lại với nhau
ALTER TABLE dbo.DienThoai ADD CONSTRAINT PK_ML FOREIGN KEY(MaLoai) REFERENCES dbo.Loai
ALTER TABLE dbo.ThongSoKyThuat ADD CONSTRAINT PK_MDT FOREIGN KEY(MaDT) REFERENCES dbo.DienThoai
ALTER TABLE dbo.LichSuChinhSua ADD CONSTRAINT PK_LSCS FOREIGN KEY(TenDangNhap) REFERENCES dbo.adminn

-- NHập dữ liệu
INSERT INTO dbo.adminn (TenDangNhap, MatKhau, Quyen)
VALUES	(N'ADMIN', N'ADMIN', 0 ),
		(N'hoang123', N'hoang123', 1)

INSERT INTO dbo.KhachHang (TenKH, DiaChi, Email, SDT, TenDN, PassDN)
VALUES	(N'Trần Văn Hoàng', N'Huế', N'tranvanhoang@gmail.com', N'0961523842', N'h123', N'h123'),
		(N'Trần Văn Thành Nam', N'Đà Năng', N'nam@gmail.com', N'0961523123', N'Nam1', N'1'),
		(N'Nguyễn Phúc Thành Long', N'Bình Định', N'long@gmail.com', N'0961523145', N'long1', N'1'),
		(N'Nguyễn Văn Thanh Nhân', N'Hội An', N'nhan@gmail.com', N'0961523345', N'nhan1', N'1'),
		(N'Lê Ngọc Huy', N'Thanh Hóa', N'huy@gmail.com', N'0961523543', N'huy1', N'1'),
		(N'Nguyễn Văn Minh Nhật', N'Quang Bình', N'nhat@gmail.com', N'0961523765', N'nhat1', N'1')

INSERT INTO dbo.Loai (MaLoai, TenLoai)
VALUES	('01', N'Iphone'),
		('02', N'Samsung'),
		('03', N'Oppo'),
		('04', N'Vivo'),
		('05', N'Xiaomi'),
		('06', N'Realme'),
		('07', N'Nokia'),
		('08', N'Mobell'),
		('09', N'Itel'),
		('10', N'Masstel'),
		('11', N'Energizer')

INSERT INTO dbo.DienThoai (TenDT, Gia, Anh, NgayNhap, SoLuong, MaLoai, sao, DanhGia)
VALUES	('Iphome 13',20940000,'iphone-12.jpg',getDate(),90,'01',5,N'tốt'),
		('Iphome 13 Mini',23940000,'iphone-13-mini-blue.jpg',getDate(),80,'01',5,N'tốt'),
		('Iphome 13 Pro Max',32940000,'iphone-13-pro-max-silver.jpg',getDate(),91,'01',5,N'tốt'),
		('Iphome SE',19990000,'iphone-se.jpg',getDate(),22,'01',5,N'tốt'),
		('Iphome 12 Pro Max',28090000,'iphone-12-pro-max.jpg',getDate(),77,'01',5,N'tốt'),
		('Iphome 11',19900000,'iphone-11.jpg',getDate(),86,'01',5,N'tốt'),
		('Samsung Z Fold 3',43000000,'samsung-galaxy-z-fold-3.jpg',getDate(),66,'02',5,N'Tốt'),
		('Samsung A32',6000000,'samsung-galaxy-a32.jpg',getDate(),65,'02',3,N'Tốt'),
		('Samsung A52',7000000,'samsung-galaxy-a52.jpg',getDate(),32,'02',4,N'Tốt'),
		('Samsung Z flip 3',32000000,'samsung-galaxy-z-flip-3.jpg',getDate(),11,'02',5,N'Tốt'),
		('Samsung S21 ulatra',21000000,'samsung-galaxy-s21-ultra.jpg',getDate(),13,'02',4,N'Tốt'),
		('Oppo Reno6 Z',6000000,'oppo-reno6-z.jpg',getDate(),2,'03',5,N'Tốt'),
		('Oppo A95',9000000,'oppo-a95.jpg',getDate(),11,'03',4,N'Tốt'),
		('Oppo Find X3',13000000,'oppo-find-x3.jpg',getDate(),64,'03',3,N'Tốt'),
		('Oppo Reno5',4000000,'oppo-reno5.jpg',getDate(),199,'03',5,N'Tốt'),
		('Vivo V23',3200000,'Vivo-V23e.jpg',getDate(),222,'04',3,N'Tốt'),
		('Vivo X70 Pro',4500000,'vivo-x70-pro-xanh-hong-1-600x600.jpg',getDate(),11,'04',4,N'Tốt'),
		('Vivo V21',430000,'vivo-v21-5g-xanh-den-600x600.jpg',getDate(),66,'04',5,N'Tốt'),
		('Vivo Y53s',630000,'vivo-y53s-xanh-600x600.jpg',getDate(),63,'04',20,N'Tốt'),
		('Xiaomi 11T',3565000,'xiaomi-11t-grey-1-600x600.jpg',getDate(),56,'05',4,N'Tốt'),
		('Xiaomi Mi 11',430000,'xiaomi-mi-11-xanhduong-600x600-600x600.jpg',getDate(),2,'05',20,N'Tốt'),
		('Realme 8 Pro',8000000,'realme-8-pro-balck-600x600.jpg',getDate(),663,'06',5,N'Tốt'),
		('Realme 7 Pro',7800000,'realme-7-pro-bac-600x600.jpg',getDate(),621,'06',4,N'Tốt'),
		('Realme 7',4800000,'realme-7-blue-600x600.jpg',getDate(),62,'06',3,N'Tốt'),
		('Nokia G10',200000,'Nokia g10 xanh duong-600x600.jpg',getDate(),61,'07',1,N'Tốt'),
		('Nokia 34',500000,'nokia-34-xam-600x600-600x600.jpg',getDate(),64,'07',3,N'Tốt'),
		('Nokia 210',670000,'nokia-210-den-600x600.jpg',getDate(),66,'07',2,N'Tốt'),
		('Mobell M389i',300000,'mobell-m389i-black-001-600x600.jpg',getDate(),66,'08',3,N'Tốt'),
		('Mobell M319',450000,'mobell-m319-black-1-600x600.jpg',getDate(),66,'08',1,N'Tốt'),
		('Mobell Rock 3',120000,'mobell-rock-3-xanh-600x600-600x600.jpg',getDate(),66,'08',2,N'Tốt'),
		('Itel L6502',480000,'itel-l6502-den-600x600.jpg',getDate(),66,'09',20,N'Tốt'),
		('Itel L6006',432000,'itel-l6006-violet-600x600.jpg',getDate(),66,'09',1,N'Tốt'),
		('Masstel Fami 60',990000,'masstel-fami-60-thumb-600x600.jpeg',getDate(),66,'10',5,N'Tốt'),
		('Masstel Izi 55',610000,'masstel-izi-55-thumb-600x600.jpeg',getDate(),66,'10',4,N'Tốt'),
		('Energizer E20',220000,'energizer-e20-den-600x600.jpg',getDate(),100,'11',5,N'Tốt')


INSERT INTO dbo.ThongSoKyThuat	(MangHinh, CameraSau, CameraTruoc, CPU, HeDieuHanh, BoNhoVaRam, Pin, KetNoi, MaDT)
VALUES	( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 1),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 2),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 3),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 4),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 5),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 6),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 7),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 8),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 9),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 10),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 11),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 12),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 13),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 14),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 15),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 16),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 17),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 18),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 19),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 20),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 21),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 22),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 23),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 24),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 25),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 26),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 27),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 28),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 29),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 30),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 31),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 32),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 33),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 34),
		( N'mang hinh', N'camera trc', N'camera sau', N'cpu', N'he dieu hanh', N'ram', 30000, N'ket noi', 35)


UPDATE dbo.Loai
SET TenLoai=N''
WHERE MaLoai=11

DELETE FROM dbo.Loai WHERE MaLoai='11'

SELECT * FROM  dbo.ThongSoKyThuat

DELETE FROM dbo.ThongSoKyThuat

SELECT * FROM dbo.adminn WHERE TenDangNhap = N'ADMIN' AND MatKhau = N'ADMI'

SELECT * FROM DienThoai WHERE TenDT like '%a%' or  MaLoai like '%001%'