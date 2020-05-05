package data_structures.linked_lists;

/**
 * @author Vinodh Kumar Thimmisetty
 */

class StringNode {
    String value;
    StringNode next;

    public StringNode(String value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "StringNode{" +
                "value='" + value + '\'' +
                ", next=" + next +
                '}';
    }
}

class StringLinkedList {

    StringNode front;


    void addToFront(String movie) {
        final StringNode newNode = new StringNode(movie);
        if (front == null) front = newNode;
        else {
            newNode.next = front;
            front = newNode;
        }
    }

    void addLast(String movie) {
        final StringNode newNode = new StringNode(movie);
        if (front == null) front = newNode;
        else {
            StringNode temp = this.front;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
}

public class TestStringNodes {
    public static void main(String[] args) {
        StringLinkedList sl = new StringLinkedList();
        System.out.println(sl.front);
        sl.addToFront("Casino Royale");
        System.out.println(sl.front);
        sl.addToFront("Mass");
        System.out.println(sl.front);
        sl.addToFront("VK");
        System.out.println(sl.front);
        sl.addLast("PK");
        System.out.println(sl.front);
    }


}
