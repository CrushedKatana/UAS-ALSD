public class TransaksiRental {
    private static int autoIncrement = 1;
    private int kodeTransaksi;
    private String namaPeminjam;
    private int lamaPinjam;
    private double totalBiaya;
    private BarangRental br;

    public TransaksiRental(String namaPeminjam, int lamaPinjam, BarangRental br) {
        this.kodeTransaksi = autoIncrement++;
        this.namaPeminjam = namaPeminjam;
        this.lamaPinjam = lamaPinjam;
        this.br = br;
        this.totalBiaya = lamaPinjam * br.getBiayaSewa();
    }

    // Getters
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

    public BarangRental getBr() {
        return br;
    }
}
