import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BarangRental[] barangRentals = {
            new BarangRental("S 4567 YV", "Honda Beat", "Motor", 2017, 10000),
            new BarangRental("IN 4511 VS", "Honda Vario", "Motor", 2018, 10000),
            new BarangRental("IN 1453 AA", "Toyota Yaris", "Mobil", 2022, 30000),
            new BarangRental("AB 4321 A", "Toyota Innova", "Mobil", 2019, 60000),
            new BarangRental("B 1234 AG", "Toyota Avanza", "Mobil", 2021, 25000)
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
                    System.out.println("Daftar Kendaraan Rental Serba Serbi");
                    System.out.println("Nomor TNKB | Nama Kendaraan | Jenis | Tahun | Biaya Sewa Perjam");
                    for (BarangRental br : barangRentals) {
                        System.out.println(br.getNoTNKB() + " | " + br.getNamaKendaraan() + " | " + br.getJenisKendaraan() +
                                " | " + br.getTahun() + " | " + br.getBiayaSewa());
                    }
                    break;
                case 2:
                    System.out.print("Nama Peminjam: ");
                    String namaPeminjam = scanner.nextLine();
                    System.out.print("Lama Pinjam (jam): ");
                    int lamaPinjam = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Nomor TNKB Kendaraan: ");
                    String noTNKB = scanner.nextLine();
                    BarangRental selectedBarang = null;
                    for (BarangRental br : barangRentals) {
                        if (br.getNoTNKB().equals(noTNKB)) {
                            selectedBarang = br;
                            break;
                        }
                    }
                    if (selectedBarang != null) {
                        TransaksiRental transaksi = new TransaksiRental(namaPeminjam, lamaPinjam, selectedBarang);
                        transaksiList.add(transaksi);
                        System.out.println("Transaksi berhasil ditambahkan!");
                    } else {
                        System.out.println("Kendaraan tidak ditemukan!");
                    }
                    break;
                case 3:
                    transaksiList.printList();
                    break;
                case 4:
                    transaksiList.sortByNoTNKB();
                    System.out.println("Transaksi berhasil diurutkan berdasarkan nomor TNKB!");
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
