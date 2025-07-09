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
        String[] inputs = br.readLine().split(" ");

        // row, column
        int[] positions = new int[2];
        BinaryTree binaryTree = new BinaryTree(inputs[1]);
        for (int i = 0; i < inputs[0].length(); ++i) {
            BinaryTree.Node node = binaryTree.getTargetNode(inputs[0].charAt(i));
            if (node != null) {
                positions[0] = node.getPosition();
                positions[1] = i;
                break;
            }
        }

        for (int r = 0; r < inputs[1].length(); ++r) {
            for (int c = 0; c < inputs[0].length(); ++c) {
                char output;
                if (r == positions[0]) {
                    output = inputs[0].charAt(c);
                } else if (c == positions[1]) {
                    output = inputs[1].charAt(r);
                } else {
                    output = '.';
                }

                bw.write(output);
            }

            bw.newLine();
        }
    }
}

class BinaryTree {

    class Node {
        private char alphabet;
        private int position;
        private Node leftNode;
        private Node rightNode;

        public Node(char alphabet, int position) {
            this.alphabet = alphabet;
            this.position = position;
        }

        public char getAlphabet() {
            return alphabet;
        }

        public int getPosition() {
            return position;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node newLeftNode) {
            this.leftNode = newLeftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node newRightNode) {
            this.rightNode = newRightNode;
        }
    }

    private Node root = null;

    public BinaryTree(String source) {
        for (int i = 0; i < source.length(); ++i) {
            insert(source.charAt(i), i);
        }
    }

    public void insert(char alphabet, int pos) {
        Node newNode = new Node(alphabet, pos);
        root = _insert(root, newNode);
    }

    private Node _insert(Node targetNode, Node newNode) {
        if (targetNode == null) {
            return newNode;
        }

        if (targetNode.getAlphabet() >= newNode.getAlphabet()) {
            targetNode.setLeftNode(_insert(targetNode.getLeftNode(), newNode));
        } else {
            targetNode.setRightNode(_insert(targetNode.getRightNode(), newNode));
        }
        return targetNode;
    }

    public Node getTargetNode(char targetChar) {
        return search(root, targetChar);
    }

    private Node search(Node node, char targetChar) {
        if (node == null) {
            return null;
        }

        if (node.getAlphabet() == targetChar) {
            return node;
        }

        if (node.getAlphabet() >= targetChar) {
            node = search(node.getLeftNode(), targetChar);
        } else {
            node = search(node.getRightNode(), targetChar);
        }
        return node;
    }
}