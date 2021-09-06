class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public Node getNext() {
        return this.next;
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public void addAtEnd(String data) {
        Node node = new Node(data);

        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    public void addAtBeg(String data) {
        Node node = new Node(data);

        if (this.head == null)
            this.head = this.tail = node;
        else {
            node.setNext(this.head);
            this.head = node;
        }
    }

    public void display() {
        Node temp = this.head;

        if (temp == null)
            System.out.println("Empty");
        else {
            while (temp != null) {
                System.out.print(temp.getData() + ", ");
                temp = temp.getNext();
            }
            System.out.println();
        }
    }

    public Node find(String data) {
        Node temp = this.head;

        while (temp != null) {
            if (temp.getData().equals(data)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void insert(String data, String dataBefore) {
        Node node = new Node(data);

        if (this.head == null) {
            this.head = this.tail = null;
        }

        else {
            Node nodeBefore = this.find(dataBefore);

            if (nodeBefore != null) {
                node.setNext(nodeBefore.getNext());
                nodeBefore.setNext(node);

                if (nodeBefore == this.tail)
                    this.tail = node;
                System.out.println("Inserted successfully");
            } else {
                System.out.println("Node not found");
            }
        }
    }

}

class LLInsert {
    public static void main(String... args) {
        LinkedList ll = new LinkedList();
        ll.addAtEnd("Arjun");
        ll.addAtEnd("rjun");
        ll.addAtEnd("jun");
        ll.addAtEnd("un");
        ll.addAtEnd("n");
        ll.addAtBeg("Ap");
        System.out.println("Searching for xyz....");
        if (ll.find("xyz") != null) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        System.out.println("\n");

        System.out.println("Inserting Patil after Arjun..");
        ll.insert("patil", "Arjun");
        System.out.println("\n");

        System.out.println("Head Node: " + ll.getHead().getData());
        System.out.println("\n");

        System.out.println("Tail Node: " + ll.getTail().getData());
        System.out.println("\n");

        System.out.println("The Linked List elements are: ");
        ll.display();

    }
}