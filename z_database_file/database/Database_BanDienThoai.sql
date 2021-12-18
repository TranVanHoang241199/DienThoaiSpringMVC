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
	MaTSKT nvarchar(50) not null,
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

UPDATE dbo.Loai
SET TenLoai=N''
WHERE MaLoai=11

DELETE FROM dbo.Loai WHERE MaLoai='11'

SELECT * FROM  dbo.LichSuMuaHang


SELECT * FROM dbo.adminn WHERE TenDangNhap = N'ADMIN' AND MatKhau = N'ADMI'

SELECT * FROM DienThoai WHERE TenDT like '%a%' or  MaLoai like '%001%'