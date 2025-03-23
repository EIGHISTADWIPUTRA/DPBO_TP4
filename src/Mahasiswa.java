public class Mahasiswa {
    private String nim;
    private String nama;
    private String jenisKelamin;
    private String nilai;
    private String kelas;
    private int umur;

    public Mahasiswa(String nim, String nama, String jenisKelamin, String nilai, String kelas, int umur) {
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.nilai = nilai;
        this.kelas = kelas;
        this.umur = umur;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getNim() {
        return this.nim;
    }

    public String getNama() {
        return this.nama;
    }

    public String getJenisKelamin() {
        return this.jenisKelamin;
    }

    public String getNilai() {
        return this.nilai;
    }

    public String getKelas() {
        return this.kelas;
    }

    public int getUmur() {
        return this.umur;
    }
}