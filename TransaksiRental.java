public class TransaksiRental {
     private static int nextKodeTransaksi = 1;

    private int kodeTransaksi;
    private String namaPeminjam;
    private int lamaPinjam;
    private double totalBiaya;
    private BarangRental barang;

    // Constructor
    public TransaksiRental(String namaPeminjam, int lamaPinjam, BarangRental barang) {
        this.kodeTransaksi = nextKodeTransaksi++;
        this.namaPeminjam = namaPeminjam;
        this.lamaPinjam = lamaPinjam;
        this.barang = barang;
        this.totalBiaya = lamaPinjam * barang.getBiayaSewa();
    }

    public int getKodeTransaksi() {
        return kodeTransaksi;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public int getLamaPinjam() {
        return lamaPinjam;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public BarangRental getBarang() {
        return barang;
    }
}

