import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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
        final int N = Integer.parseInt(br.readLine());
        BinaryTree binaryTree = new BinaryTree();

        for (int i = 0; i < N; ++i) {
            binaryTree.insert(br.readLine());
        }

        for (String word: binaryTree.getSortedValues()) {
            bw.write(word);
            bw.newLine();
        }
    }
}

class BinaryTree {

    static class Node {
        private String value;
        private Node leftChild;
        private Node rightChild;

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    private Node root = null;

    public void insert(String value) {
        if (search(value) != null || value == null) {
            return;
        }
        root = _insert(root, value);
    }

    private Node _insert(Node node, String value) {
        if (node == null) {
            return new Node(value);
        }

        if (node.getValue().length() > value.length()) {
            node.setLeftChild(_insert(node.getLeftChild(), value));
        } else if (node.getValue().length() < value.length()) {
            node.setRightChild(_insert(node.getRightChild(), value));
        } else {
            int diff = value.compareTo(node.getValue());
            if (diff == 0) {
                return node;
            }
            if (diff < 0) {
                node.setLeftChild(_insert(node.getLeftChild(), value));
            } else {
                node.setRightChild(_insert(node.getRightChild(), value));
            }
        }

        return node;
    }

    public String search(String value) {
        Node resultNode = _search(root, value);
        if (resultNode == null) {
            return null;
        }
        return resultNode.getValue();
    }

    private Node _search(Node node, String value) {
        if (node == null) {
            return null;
        }

        if (node.getValue().equals(value)) {
            return node;
        }

        if (node.getValue().length() > value.length()) {
            node = _search(node.getLeftChild(), value);
        } else if (node.getValue().length() < value.length()) {
            node = _search(node.getRightChild(), value);
        } else {
            int diff = value.compareTo(node.getValue());
            if (diff < 0) {
                node = _search(node.getLeftChild(), value);
            } else {
                node = _search(node.getRightChild(), value);
            }
        }

        return node;
    }

    public List<String> getSortedValues() {
        List<String> values = new ArrayList<>();
        _inOrderTraversal(root, values);
        return values;
    }

    private void _inOrderTraversal(Node node, List<String> values) {
        if (node == null) {
            return;
        }

        _inOrderTraversal(node.getLeftChild(), values);
        values.add(node.getValue());
        _inOrderTraversal(node.getRightChild(), values);
    }
}