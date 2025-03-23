# Tugas Praktikum 4 DPBO - Aplikasi Data Mahasiswa

## Janji


Saya Muhammad Bintang Eighista Dwiputra dengan NIM 2304137 mengerjakan Tugas Praktikum 4 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.


## Desain Program

### Class Mahasiswa

Class Mahasiswa merupakan class model yang digunakan untuk menyimpan data-data mahasiswa. Berikut adalah atribut yang terdapat pada class Mahasiswa:

1. **nim** (String): Nomor Induk Mahasiswa
2. **nama** (String): Nama lengkap mahasiswa
3. **jenisKelamin** (String): Jenis kelamin mahasiswa (Laki-laki/Perempuan)
4. **nilai** (String): Nilai mahasiswa (A/B/C/D/E)
5. **kelas** (String): Kelas mahasiswa (C1/C2)
6. **umur** (int): Umur mahasiswa (range 17-30 tahun)

Untuk setiap atribut, class Mahasiswa dilengkapi dengan constructor, getter, dan setter.

### Fitur Program

Program ini adalah aplikasi manajemen data mahasiswa dengan GUI yang dibuat menggunakan Java Swing. Berikut adalah fitur-fitur yang tersedia:

1. **Tambah Data**: Menambahkan data mahasiswa baru ke dalam daftar
2. **Update Data**: Mengubah data mahasiswa yang sudah ada
3. **Hapus Data**: Menghapus data mahasiswa dari daftar dengan konfirmasi
4. **Tampil Data**: Menampilkan seluruh data mahasiswa dalam bentuk tabel
5. **Form Validation**: Memastikan semua field terisi sebelum menambah/mengubah data
6. **Clear Form**: Membersihkan seluruh isian pada form

### Komponen GUI

Program menggunakan berbagai komponen Java Swing:

1. **JTextField**: Untuk input NIM dan Nama
2. **JComboBox**: Untuk pemilihan Jenis Kelamin dan Nilai
3. **JRadioButton**: Untuk pemilihan Kelas (C1/C2)
4. **JSpinner**: Untuk input Umur dengan range 15-30 tahun
5. **JTable**: Untuk menampilkan data mahasiswa
6. **JButton**: Untuk aksi Add/Update, Delete, dan Cancel
7. **JLabel**: Untuk label form

## Alur Program

1. **Start**: Program dimulai dengan menampilkan GUI dengan form kosong dan tabel yang berisi data mahasiswa (yang diisi pada method `populateList()`)

2. **Tambah Data**:
   - Pengguna mengisi seluruh field pada form
   - Pengguna menekan tombol "Add"
   - Program memvalidasi apakah semua field sudah terisi
   - Jika valid, data ditambahkan ke dalam ArrayList `listMahasiswa`
   - Tabel diperbarui untuk menampilkan data baru
   - Form dikosongkan dan pesan sukses ditampilkan

3. **Update Data**:
   - Pengguna memilih (klik) data pada tabel
   - Form terisi dengan data yang dipilih
   - Tombol "Add" berubah menjadi "Update" dan tombol "Delete" muncul
   - Pengguna mengubah data pada form
   - Pengguna menekan tombol "Update"
   - Program memvalidasi apakah semua field sudah terisi
   - Jika valid, data pada ArrayList `listMahasiswa` diperbarui
   - Tabel diperbarui dan pesan sukses ditampilkan

4. **Hapus Data**:
   - Pengguna memilih (klik) data pada tabel
   - Tombol "Delete" muncul
   - Pengguna menekan tombol "Delete"
   - Konfirmasi hapus ditampilkan
   - Jika pengguna mengkonfirmasi, data dihapus dari ArrayList `listMahasiswa`
   - Tabel diperbarui dan pesan sukses ditampilkan

5. **Cancel/Clear Form**:
   - Pengguna menekan tombol "Cancel"
   - Form dikosongkan dan tombol "Update" kembali menjadi "Add"
   - Tombol "Delete" disembunyikan

## Dokumentasi Program
[![Demo Video](https://img.youtube.com/vi/MUYVNhA4Dhg/0.jpg)](https://www.youtube.com/watch?v=MUYVNhA4Dhg)

