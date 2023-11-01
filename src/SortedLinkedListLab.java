import java.util.Collections;

public class SortedLinkedListLab {
    private Node head;
    private Boolean isAscending;

    private class Node {
        private Comparable value;
        private Node next;

        public Node() {
            this.value = 0;
            this.next = null;
        }

        public Node(Comparable value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * @param isAscending Ascending:1, Descending:0
     */
    public SortedLinkedListLab(boolean isAscending) {
        this.head = null;
        this.isAscending = isAscending;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = this.head;
        while (cur != null) {
            sb.append(cur.value + " ");
            cur = cur.next;
        }
        return sb.toString();
    }

    public void add(Comparable c) {
        Node cur = this.head;
        Node newNode = new Node(c, null);
        if (this.head == null) {
            this.head = newNode;
            return;
        }

        if (isAscending) {
            if (c.compareTo(this.head.value) <= 0) {
                newNode.next = this.head;
                this.head = newNode;
            } else {
                while (cur.next != null && c.compareTo(cur.next.value) > 0) {
                    cur = cur.next;
                }
                newNode.next = cur.next;
                cur.next = newNode;
            }
        } else {
            if (c.compareTo(this.head.value) >= 0) {
                newNode.next = this.head;
                this.head = newNode;
            } else {
                while (cur.next != null && c.compareTo(cur.next.value) < 0) {
                    cur = cur.next;
                }
                newNode.next = cur.next;
                cur.next = newNode;
            }
        }

    }

    public boolean find(Comparable c) {
        Node cur = this.head;
        while (cur != null) {
            if (c.compareTo(cur.value) == 0) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void delete(Comparable c) {
        if (this.head == null) {
            System.out.println("No data to be deleted");
            return;
        }
        if (c.compareTo(this.head.value) == 0) {
            this.head = this.head.next;
            return;
        }

        Node cur = this.head;
        while (cur.next != null) {
            if (c.compareTo(cur.next.value) == 0) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
        System.out.println("Element is not found");
    }

    public void reverse() {
        if (this.head == null) {
            System.out.println("Empty list");
            return;
        }
        Node prev = null;
        Node cur = head;
        Node tmpNext;
        while (cur != null) {
            tmpNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmpNext;
        }
        this.head = prev;
        this.isAscending = !this.isAscending;
    }

}
