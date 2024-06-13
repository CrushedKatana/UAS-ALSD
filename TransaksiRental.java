public class TransaksiRental {
    private static int autoIncrement = 1;
    private int kodeTransaksi;
    private String namaPeminjam;
    private int lamaPinjam;
    private double totalBiaya;
    private BarangRental br;

    public TransaksiRental(String namaPeminjam, int lamaPinjam, BarangRental br, boolean isMember) {
        this.kodeTransaksi = autoIncrement++;
        this.namaPeminjam = namaPeminjam;
        this.lamaPinjam = lamaPinjam;
        this.br = br;
        this.totalBiaya = calculateTotalBiaya(lamaPinjam, br, isMember);
    }

    private double calculateTotalBiaya(int lamaPinjam, BarangRental br, boolean isMember) {
        double biaya = lamaPinjam * br.getBiayaSewa();
        if (isMember) {
            biaya -= 25000; // potongan harga untuk member
        }
        if (lamaPinjam >= 48 && lamaPinjam <= 78) {
            biaya *= 0.9; // potongan 10%
        } else if (lamaPinjam > 78) {
            biaya *= 0.8; // potongan 20%
        }
        return biaya;
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

    public BarangRental getBr() {
        return br;
    }
}
