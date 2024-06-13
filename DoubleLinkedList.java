public class DoubleLinkedList {
    private Node head;
    private Node tail;

    public void add(TransaksiRental data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println("Kode Transaksi: " + current.data.getKodeTransaksi() + ", Nama Peminjam: " + current.data.getNamaPeminjam() +
                    ", Lama Pinjam: " + current.data.getLamaPinjam() + ", Total Biaya: " + current.data.getTotalBiaya() +
                    ", Barang: " + current.data.getBr().getNamaKendaraan() + " (" + current.data.getBr().getNoTNKB() + ")");
            current = current.next;
        }
    }

    public void sortByNoTNKB() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        do {
            Node current = head;
            swapped = false;
            while (current.next != null) {
                if (current.data.getBr().getNoTNKB().compareTo(current.next.data.getBr().getNoTNKB()) > 0) {
                    TransaksiRental temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
