import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BarangRental[] barangRentals = {
            new BarangRental("S 4567 YV", "Honda Beat", "Motor", 2017, 25000),
            new BarangRental("IN 4511 VS", "Honda Vario", "Motor", 2018, 25000),
            new BarangRental("IN 1453 AA", "Toyota Yaris", "Mobil", 2022, 40000),
            new BarangRental("AB 4321 A", "Toyota Innova", "Mobil", 2019, 40000),
            new BarangRental("B 1234 AG", "Toyota Avanza", "Mobil", 2021, 40000)
        };

        DoubleLinkedList transaksiList = new DoubleLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Peminjaman");
            System.out.println("3. Tampilkan seluruh transaksi");
            System.out.println("4. Urutkan Transaksi urut no TNKB");
            System.out.println("5. Keluar");
            System.out.print("Pilih (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Daftar Kendaraan Rental Serba Serbi");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Nomor TNKB | Nama Kendaraan | Jenis | Tahun | Biaya Sewa Perjam | Status");
                    for (BarangRental br : barangRentals) {
                        System.out.println(br.getNoTNKB() + " | " + br.getNamaKendaraan() + " | " + br.getJenisKendaraan() +
                                " | " + br.getTahun() + " | " + br.getBiayaSewa() + " | " + (br.isRented() ? "Sudah Dipinjam" : "Tersedia"));
                    }
                    break;
                case 2:
                    System.out.println("============================================");
                    System.out.print("Nama Peminjam: ");
                    String namaPeminjam = scanner.nextLine();
                    System.out.print("Lama Pinjam (jam): ");
                    int lamaPinjam = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Nomor TNKB Kendaraan: ");
                    String noTNKB = scanner.nextLine();
                    System.out.print("Apakah Anda seorang member (true/false)? ");
                    boolean isMember = scanner.nextBoolean();
                    scanner.nextLine(); // consume newline

                    BarangRental selectedBarang = null;
                    for (BarangRental br : barangRentals) {
                        if (br.getNoTNKB().equals(noTNKB)) {
                            selectedBarang = br;
                            break;
                        }
                    }
                    if (selectedBarang != null) {
                        if (!selectedBarang.isRented()) {
                            TransaksiRental transaksi = new TransaksiRental(namaPeminjam, lamaPinjam, selectedBarang, isMember);
                            transaksiList.add(transaksi);
                            selectedBarang.setRented(true);
                            System.out.println("Transaksi berhasil ditambahkan!");
                        } else {
                            System.out.println("Kendaraan sudah dipinjam orang lain!");
                        }
                    } else {
                        System.out.println("Kendaraan tidak ditemukan!");
                    }
                    break;
                case 3:
                    System.out.println("============================================");
                    System.out.println("Daftar Transaksi Peminjaman Rental Serba Serbi");
                    System.out.println("Kode Transaksi | No TNKB | Nama Barang | Nama Peminjam | Lama Pinjam | Total Biaya");
                    transaksiList.printListWithDetails(); // Menambahkan detail pencetakan transaksi
                    System.out.println("TOTAL PENDAPATAN RENTAL SERBA SERBI");
                    double totalPendapatan = transaksiList.calculateTotalPendapatan();
                    System.out.println("Pendapatan hari ini: Rp " + totalPendapatan);
                    break;
                case 4:
                    transaksiList.sortByFirstLetterAndTNKB();
                    System.out.println("Transaksi berhasil diurutkan berdasarkan huruf pertama nama dan nomor TNKB!");
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
            System.out.println();
        } while (choice != 5);

        scanner.close();
    }
}
