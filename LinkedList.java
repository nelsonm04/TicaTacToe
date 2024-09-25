
public class LinkedList {

    private Node head;  // Head of the linked list

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end
    public void insertAtEnd(String data) {
        // To be implemented
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to update a specific position in the list
    public void updatePosition(int position, String data) {
        // To be implemented
        Node current = head;
        int count = 1;
        while (current != null) {
            if (count == position) {
                current.data = data;
                break;
            }
            current = current.next;
            count++;
        }
    }

    // Method to get the value at a specific position
    public String getPositionValue(int position) {
        // To be implemented
        Node current = head;
        int count = 1;
        while (current != null) {
            if (count == position) {
                return current.data;
            }
            current = current.next;
            count++;
        }
        return "";
    }

    // Method to display the Tic Tac Toe board
    public void displayBoard() {
        // To be implemented
        Node current = head;
        int count = 1;
        while (current != null) {
            System.out.print(current.data.equals("") ? count : current.data);
            if (count % 3 == 0) {
                System.out.println();
            } else {
                System.out.print(" | ");
            }
            current = current.next;
            count++;
        }
    }

    // Method to check for a win
    public boolean checkWinCondition() {
        // Win combinations: 1-2-3, 4-5-6, 7-8-9, 1-4-7, 2-5-8, 3-6-9, 1-5-9, 3-5-7
        return (checkEqual(1, 2, 3) || checkEqual(4, 5, 6) || checkEqual(7, 8, 9) ||
                checkEqual(1, 4, 7) || checkEqual(2, 5, 8) || checkEqual(3, 6, 9) ||
                checkEqual(1, 5, 9) || checkEqual(3, 5, 7));
    }

    private boolean checkEqual(int pos1, int pos2, int pos3) {
        String val1 = getPositionValue(pos1);
        String val2 = getPositionValue(pos2);
        String val3 = getPositionValue(pos3);
        return !val1.equals("") && val1.equals(val2) && val2.equals(val3);
    }

    // Method to check if the board is full (for draw condition)
    public boolean isBoardFull() {
        // To be implemented
        Node current = head;
        while (current != null) {
            if (current.data.equals("")) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    // Method to reset the board
    public void resetBoard() {
        // To be implemented
        Node current = head;
        while (current != null) {
            current.data = "";
            current = current.next;

        }
    }
}
