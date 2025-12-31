import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        mySolution();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mySolution() throws IOException {
        CustomLinkedList cll = new CustomLinkedList(br.readLine());
        final int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; ++i) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L':
                    cll.moveCursorLeft();;
                    break;
                case 'D':
                    cll.moveCursorRight();
                    break;
                case 'B':
                    cll.removeCurrentElement();
                    break;
                case 'P':
                    cll.insert(command.charAt(command.length() - 1));
                    break;
            }
        }

        bw.write(cll.toString());
    }
}

class Node {
    private char alphabet;
    private Node nextNode;
    private Node previousNode;

    public Node(char alphabet) {
        this.alphabet = alphabet;
    }

    public char getAlphabet() {
        return alphabet;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }
}

class CustomLinkedList {
    private final Node HEAD = new Node('A');
    private final Node TAIL = new Node('Z');
    private Node cursor = HEAD;

    public CustomLinkedList(String initialString) {
        if (initialString.isEmpty()) {
            HEAD.setNextNode(TAIL);
            TAIL.setPreviousNode(HEAD);
            return;
        }

        for (int i = 0; i < initialString.length(); ++i) {
            Node node = new Node(initialString.charAt(i));

            if (HEAD.getNextNode() == null) {
                HEAD.setNextNode(node);
                node.setPreviousNode(HEAD);
            } else {
                cursor.setNextNode(node);
                node.setPreviousNode(cursor);
            }

            cursor = node;
        }

        cursor.setNextNode(TAIL);
        TAIL.setPreviousNode(cursor);
        cursor = TAIL;
    }

    public void moveCursorLeft() {
        if (cursor.getPreviousNode() != HEAD) {
            cursor = cursor.getPreviousNode();
        }
    }

    public void moveCursorRight() {
        if (cursor.getNextNode() != null) {
            cursor = cursor.getNextNode();
        }
    }

    public void removeCurrentElement() {
        if (cursor == HEAD || cursor.getPreviousNode() == HEAD) {
            return;
        }

        Node targetNode = cursor.getPreviousNode();
        Node leftNode = targetNode.getPreviousNode();

        targetNode.setPreviousNode(null);
        targetNode.setNextNode(null);
        leftNode.setNextNode(cursor);
        cursor.setPreviousNode(leftNode);
    }

    public void insert(char newChar) {
        Node newNode = new Node(newChar);
        Node leftOfNewNode = cursor.getPreviousNode();

        if (cursor == HEAD) {
            leftOfNewNode = HEAD;
            cursor = cursor.getNextNode();
        }

        leftOfNewNode.setNextNode(newNode);
        newNode.setPreviousNode(leftOfNewNode);
        cursor.setPreviousNode(newNode);
        newNode.setNextNode(cursor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node nodePointer = HEAD.getNextNode();

        while (nodePointer != TAIL) {
            sb.append(nodePointer.getAlphabet());
            nodePointer = nodePointer.getNextNode();
        }

        return sb.toString();
    }
}