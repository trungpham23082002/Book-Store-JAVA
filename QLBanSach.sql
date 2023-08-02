create database QLBanSach_DoAnJava
go
use QLBanSach_DoAnJava
go
create table TheLoaiSach
(
MaTheLoai char(20),
TenTheLoai nvarchar(100)
constraint PK_MaTheLoai primary key(MaTheLoai)
)

create table Tang
(
MaTang char(20),
TenTang nvarchar(100)
constraint PK_Tang primary key(MaTang)
)

create table KeDat
(
MaKe char(20),
TenKe nvarchar(100),
constraint PK_KeDat primary key(MaKe)
)

create table PhieuGiamGia
(
MaGiamGia char(20),
TenGiamGia nvarchar(100),
PhanTramGiamGia int,
NgayBD date,
NgayKT date,
constraint PK_PhieuGiamGia primary key(MaGiamGia)
)


create table NhaXuatBan
(
MaNXB char(20),
TenNXB nvarchar(100),
constraint PK_NhaXuatBan primary key(MaNXB) 
)

create table Sach
(
MaSach char(20),
TenSach nvarchar(max),
TacGia nvarchar(100),
SoTrang int,
GiaBan int,
SoLuongTon int,
MaTheLoai char(20),
MaNXB char(20),
MaTang char(20),
MaKe char(20),
HinhAnh nvarchar(max),
constraint PK_Sach primary key(MaSach)
)

create table Quyen
(
MaQuyen char(20),
TenQuyen nvarchar(50),
constraint PK_Quyen primary key(MaQuyen)
)


create table HoaDonKho
(
SoHDK int identity(1,1),
SoLuong int,
TongTien int,
NgayLap date,
GhiChu nvarchar(max),
MaSach char(20),
MaTaiKhoan char(20),
MaLoaiHD char(20),
constraint PK_HoaDonKho primary key(SoHDK)
)



create table LoaiHoaDon
(
MaLoaiHD char(20),
TenLoaiHD nvarchar(50),
constraint PK_LoaiHoaDon primary key(MaLoaiHD)
)

create table ThanhVien
(
MaTV int identity(1,1),
TenThanhVien nvarchar(100),
SDT char(20) unique,
TienDaMua int,
MaLoaiTV char(20) not null,
constraint PK_ThanhVien primary key(MaTV)
)

create table LoaiThanhVien
(
MaLoaiTV char(20),
TenLoaiTV nvarchar(50),
TienCanDat int,
PhanTramGiamGia int
constraint PK_LoaiThanhVien primary key(MaLoaiTV)
)

create table TaiKhoan
(
MaTaiKhoan char(20),
TenDangNhap nvarchar(50) unique,
MatKhau char(20),
HoTen nvarchar(100),
SDT char(20),
MaQuyen char(20),
BiKhoa bit,
constraint PK_TaiKhoan primary key(MaTaiKhoan)
)



create table ChiTietHoaDonBan
(
SoHD int,
MaSach char(20),
SoLuong int,
TongTien int,
constraint PK_CTHoaDon primary key(SoHD, MaSach)
)


create table HoaDonBan
(
SoHD int identity(1,1),
NgayLap date,
--SoLuong int,
TongTien int,
TongGiam int,
ThanhTien int,
--MaSach char(20),
MaTV int,
MaGiamGia char(20),
MaTaiKhoan char(20),
constraint PK_HoaDon primary key(SoHD)
)

alter table Sach
add constraint FK_Sach_TheLoaiSach foreign key(MaTheLoai) references TheLoaiSach(MaTheLoai)

alter table Sach
add constraint FK_Sach_Tang foreign key(MaTang) references Tang(MaTang)

alter table Sach
add constraint FK_Sach_NhaXuatBan foreign key(MaNXB) references NhaXuatBan(MaNXB)

alter table Sach
add constraint FK_Sach_KeDat foreign key(MaKe) references KeDat(MaKe)

alter table HoaDonBan
add constraint FK_HoaDonBan_PhieuGiamGia foreign key(MaGiamGia) references PhieuGiamGia(MaGiamGia)

alter table HoaDonBan
add constraint FK_HoaDonBan_ThanhVien foreign key(MaTV) references ThanhVien(MaTV)

alter table HoaDonBan
add constraint FK_HoaDonBan_TaiKhoan foreign key(MaTaiKhoan) references TaiKhoan(MaTaiKhoan)

alter table ChiTietHoaDonBan
add constraint FK_CTHoaDonBan_HoaDon foreign key(SoHD) references HoaDonBan(SoHD)

alter table ChiTietHoaDonBan
add constraint FK_CTHoaDonBan_Sach foreign key(MaSach) references Sach(MaSach)

alter table TaiKhoan
add constraint FK_TaiKhoan_Quyen foreign key(MaQuyen) references Quyen(MaQuyen)

alter table ThanhVien
add constraint FK_ThanhVien_LoaiThanhVien foreign key(MaLoaiTV) references LoaiThanhVien(MaLoaiTV)

alter table HoaDonKho
add constraint FK_HoaDonKho_Sach foreign key(MaSach) references Sach(MaSach)

alter table HoaDonKho
add constraint FK_HoaDonKho_TaiKhoan foreign key(MaTaiKhoan) references TaiKhoan(MaTaiKhoan)

alter table HoaDonKho
add constraint FK_HoaDonKho_LoaiHoaDon foreign key(MaLoaiHD) references LoaiHoaDon(MaLoaiHD)


insert into TheLoaiSach
values
('phongthuy',N'Phong thủy'),
('ngontinh',N'Ngôn tình'),
('khoahoc',N'Khoa học'),
('kinhte',N'Kinh tế'),
('vanhoc',N'Văn học'),
('tieuthuyet',N'Tiểu thuyết'),
('thieunhi',N'Thiếu nhi'),
('ngoaingu',N'Ngoại Ngữ'),
('luatphap',N'Luật pháp')

insert into Tang
values
('T01',N'Tầng 01'),
('T02',N'Tầng 02'),
('T03',N'Tầng 03'),
('T04',N'Tầng 04')

insert into KeDat
values
('K01',N'Kệ 01'),
('K02',N'Kệ 02'),
('K03',N'Kệ 03'),
('K04',N'Kệ 04'),
('K05',N'Kệ 05')


insert into NhaXuatBan
values
('NXBHongBang',N'Nhà xuất bản Hồng Bàng'),
('NXBHongDuc',N'Nhà xuất bản Hồng Đức'),
('NXBKimDong',N'Nhà xuất bản Kim Đồng'),
('NXBPhuNu',N'Nhà xuất bản Phụ Nữ'),
('NXBTre',N'Nhà xuất bản Trẻ'),
('NXBLaoDong',N'Nhà xuất bản Lao Động'),
('NXBVanHoc',N'Nhà xuất bản Văn Học'),
('NXBThanhNien',N'Nhà xuất bản Thanh Niên'),
('NXBChinhTri',N'Nhà xuất bản Chính Trị')

insert into LoaiThanhVien
values
('None','Không có thành viên',0,0),
('Bronze',N'Thành viên đồng',0,5),
('Silver',N'Thành viên bạc',1000000,10),
('Golden',N'Thành viên vàng',3000000,15),
('Diamon',N'Thành viên kim cương',5000000,20)

insert into ThanhVien
values
(N'None','None',0,'None'),
(N'Phạm Thành Trung','0343434343',0,'Bronze'),
(N'Phạm Minh Châu','0424937434',1250000,'Silver'),
(N'Vương Chí Hải','0479432325',10000000,'Diamon')



insert into Quyen
values
('user',N'Quyền User'),
('admin',N'Quyền Admin')

insert into TaiKhoan
values
('TK01','admin','123',N'Admin','0327334834','admin',0),
('TK02','phamminhchau','123',N'Phạm Minh Châu','0343434343','user',0)


set dateformat dmy
insert into PhieuGiamGia
values
('None',N'None',0,'18/3/1900','18/6/3023'),
('MGG01',N'Phiếu Giảm Giá 1',15,'18/3/2023','18/6/2023'),
('MGG02',N'Phiếu Giảm Giá 2',30,'18/3/2023','18/6/2023'),
('MGG03',N'Phiếu Giảm Giá 3',45,'18/3/2020','18/6/2020')

insert into Sach
values
('S01',N'Tả Ao địa lý toàn thư',N'Cao Trung',120,331500,20,'phongthuy','NXBHongBang','T01','K01',N'S01.jpg'),
('S02',N'Phong thủy địa lý',N'Tuệ Hải',115,212500,15,'phongthuy','NXBHongDuc','T01','K02',N'S02.jpg'),
('S03',N'Kỳ môn độn giáp',N'Nguyễn Thanh Phương',90,153000,12,'phongthuy','NXBHongDuc','T01','K03',N'S03.jpg'),
('S04',N'Tình yêu không biên giới',N'Giác',80,51000,25,'ngontinh','NXBKimDong','T01','K04',N'S04.jpg'),
('S05',N'Chưa một lần đau',N'Từ Lỗi Tuyên',75,92000,3,'ngontinh','NXBPhuNu','T01','K05',N'S05.jpg'),
('S06',N'Mọi thứ vẫn thế',N'Thảo Xù',150,78320,2,'ngontinh','NXBHongBang','T02','K01',N'S06.jpg'),
('S07',N'Nguy hiểm từ thiên nhiên',N'Phạm Văn Nhân',53,74800,5,'khoahoc','NXBTre','T02','K02',N'S07.jpg'),
('S08',N'Khám phá thế giới động vật',N'Lưu Tiểu Hàm',160,96800,19,'khoahoc','NXBPhuNu','T02','K03',N'S08.jpg'),
('S09',N'Lâu đài khoa học của em',N'Tanya Kant',60,26400,5,'khoahoc','NXBTre','T02','K04',N'S09.jpg'),
('S10',N'Sự suy tàn của quyền lực',N'Moises Naim',145,127200,5,'kinhte','NXBLaoDong','T02','K05',N'S10.jpg'),
('S11',N'Thảm họa kinh tế Wall',N'Moises Naim',145,127200,5,'kinhte','NXBLaoDong','T03','K01',N'S11.jpg'),
('S12',N'Chiến tranh tiền tệ',N'Song Hong Bing',215,132000,35,'kinhte','NXBLaoDong','T03','K02',N'S12.jpg'),
('S13',N'Những mảnh ký ức',N'Lê Hồng Lam',115,87120,5,'vanhoc','NXBPhuNu','T03','K03',N'S13.jpg'),
('S14',N'Tuyển tập Nam Cao',N'Nam Cao',85,124000,5,'vanhoc','NXBVanHoc','T03','K04',N'S14.jpg'),
('S15',N'Về phía bình minh',N'Võ Thu Hương',82,68000,5,'vanhoc','NXBVanHoc','T03','K05',N'S15.jpg'),
('S16',N'Nhà thờ đức bà Paris',N'Nhị Ca',85,131970,6,'tieuthuyet','NXBVanHoc','T03','K05',N'S16.jpg'),
('S17',N'Bước đường cùng',N'Nguyễn Công Hoan',65,39000,16,'tieuthuyet','NXBVanHoc','T04','K01',N'S17.jpg'),
('S18',N'Vỡ đê',N'Vũ Trọng Phụng',125,56250,6,'tieuthuyet','NXBVanHoc','T04','K02',N'S18.jpg'),
('S19',N'Chuyện giúp bé ngủ ngon',N'An Nhiên',56,80360,16,'thieunhi','NXBPhuNu','T04','K03',N'S19.jpg'),
('S20',N'Mười vạn câu hỏi vì sao',N'An Nhiên',73,55250,16,'thieunhi','NXBThanhNien','T04','K04',N'S20.jpg'),
('S21',N'Trạng Quỳnh',N'Lữ Huy Nguyên',73,27000,56,'thieunhi','NXBVanHoc','T04','K05',N'S21.jpg'),
('S22',N'Từ điển Hàn Việt',N'Khác Trí',53,27000,21,'ngoaingu','NXBVanHoc','T02','K01',N'S22.jpg'),
('S23',N'Hackers IELTS Listening',N'Nguyễn Thanh Tùng dịch',245,183920,6,'ngoaingu','NXBVanHoc','T01','K02',N'S23.jpg'),
('S24',N'Động từ bất quy tắc',N'Mai Lan Hương',73,15300,56,'thieunhi','NXBVanHoc','T02','K03',N'S24.jpg'),
('S25',N'Pháp luật dân sự - kinh tế',N'Tưởng Duy Lượng',73,80000,56,'luatphap','NXBChinhTri','T03','K04',N'S25.jpg'),
('S26',N'Luật sửa đổi , bổ sung',N'Mai Lan Hương',73,15300,56,'luatphap','NXBChinhTri','T03','K05',N'S26.jpg'),
('S27',N'Luật vi phạm hành chính',N'Mai Lan Hương',123,25500,6,'luatphap','NXBChinhTri','T04','K05',N'S27.jpg')


insert into LoaiHoaDon
values
('HDNhapKho',N'Nhập kho'),
('HDXuatKho',N'Xuất kho')


insert into HoaDonKho
values
(5,10000,'18/6/2023',N'Không có','S01','TK01','HDNhapKho'),
(7,20000,'18/6/2023',N'Không có','S03','TK01','HDXuatKho')
--trigger cập nhật loại thành viên dựa vào số tiền đã mua
use QLBanSach_DoAnJava
go
CREATE TRIGGER CapNhatLTV ON ThanhVien
AFTER INSERT, UPDATE
AS
BEGIN
  UPDATE ThanhVien
  SET MaLoaiTV =
      CASE
        WHEN ThanhVien.TienDaMua < 1000000 THEN 'Bronze'
        WHEN ThanhVien.TienDaMua < 3000000 THEN 'Silver'
        WHEN ThanhVien.TienDaMua < 5000000 THEN 'Golden'
        ELSE 'Diamond'
      END
  FROM inserted
  WHERE ThanhVien.MaTV = inserted.MaTV;
END;



--insert into ThanhVien(TenThanhVien,SDT,TienDaMua)
--values
--(N'Trung đẹp trai','04838483834',1200000)

--delete from ThanhVien where MaTV='7'

--select * from ThanhVien


--DROP TRIGGER IF EXISTS CapNhatLTV;
