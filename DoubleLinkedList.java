public class DoubleLinkedList {
    private Node head;
    private Node tail;

    private static class Node {
        TransaksiRental data;
        Node prev;
        Node next;

        public Node(TransaksiRental data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(TransaksiRental transaksi) {
        Node newNode = new Node(transaksi);
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
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printListWithDetails() {
        Node current = head;
        while (current != null) {
            TransaksiRental tr = current.data;
            System.out.println(tr.getKodeTransaksi() + " | " +
                    tr.getBr().getNoTNKB() + " | " +
                    tr.getBr().getNamaKendaraan() + " | " +
                    tr.getNamaPeminjam() + " | " +
                    tr.getLamaPinjam() + " | " +
                    tr.getTotalBiaya());
            current = current.next;
        }
    }

    public void sortByNoTNKB() {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSort(head);
    }

    private Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node middle = getMiddleNode(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(node);
        Node right = mergeSort(nextOfMiddle);

        Node sortedList = mergeByNoTNKB(left, right);
        return sortedList;
    }

    private Node getMiddleNode(Node node) {
        if (node == null) {
            return node;
        }
        Node slow = node;
        Node fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node mergeByNoTNKB(Node a, Node b) {
        Node result = null;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.data.getBr().getNoTNKB().compareTo(b.data.getBr().getNoTNKB()) <= 0) {
            result = a;
            result.next = mergeByNoTNKB(a.next, b);
            if (result.next != null) {
                result.next.prev = result;
            }
        } else {
            result = b;
            result.next = mergeByNoTNKB(a, b.next);
            if (result.next != null) {
                result.next.prev = result;
            }
        }
        return result;
    }

    public void sortByFirstLetterAndTNKB() {
        if (head == null || head.next == null) {
            return; 
        }

        Node mid = getMiddleNode(head);
        Node secondHalf = mid.next;
        mid.next = null;

        head = mergeSort(head);
        secondHalf = mergeSort(secondHalf);

        head = mergeByTNKB(head, secondHalf);
    }

    private Node mergeByTNKB(Node a, Node b) {
        Node result = null;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.data.getBr().getNoTNKB().compareTo(b.data.getBr().getNoTNKB()) >= 0) {
            result = a;
            result.next = mergeByTNKB(a.next, b);
            if (result.next != null) {
                result.next.prev = result;
            }
        } else {
            result = b;
            result.next = mergeByTNKB(a, b.next);
            if (result.next != null) {
                result.next.prev = result;
            }
        }
        return result;
    }

    public double calculateTotalPendapatan() {
        double total = 0;
        Node current = head;
        while (current != null) {
            total += current.data.getTotalBiaya();
            current = current.next;
        }
        return total;
    }
}
