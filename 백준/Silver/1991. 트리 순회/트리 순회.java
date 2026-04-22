import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
        BinaryTree bt = new BinaryTree();

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            bt.insert(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        bw.write(bt.getOrder());
    }
}

class BinaryTree {
    private final Node header = new Node('A');

    private Node findNode(char targetAlphabet) {
       return findNodeHelper(header, targetAlphabet);
    }

    private Node findNodeHelper(Node node, char targetAlphabet) {
        if (node == null) {
            return null;
        }

        if (node.getAlphabet() == targetAlphabet) {
            return node;
        }

        for (Node nextChild : node.getBothChildren()) {
            node = findNodeHelper(nextChild, targetAlphabet);

            if (node == null) {
                continue;
            }

            if (node.getAlphabet() == targetAlphabet) {
                break;
            }
        }

        return node;
    }

    public void insert(char parentChar, char leftChar, char rightChar) {
        if (leftChar == '.' && rightChar == '.') {
            return;
        }

        Node parent = findNode(parentChar);
        parent.setLeftChild(new Node(leftChar));
        parent.setRightChild(new Node(rightChar));
    }

    public String getOrder() {
        StringBuilder sb = new StringBuilder();
        getPreOrder(header, sb);
        sb.append("\n");
        getInOrder(header, sb);
        sb.append("\n");
        getPostOrder(header, sb);
        sb.append("\n");
        return sb.toString();
    }

    private void getPreOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.getAlphabet());
        getPreOrder(node.getLeftChild(), sb);
        getPreOrder(node.getRightChild(), sb);
    }

    private void getInOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        getInOrder(node.getLeftChild(), sb);
        sb.append(node.getAlphabet());
        getInOrder(node.getRightChild(), sb);
    }

    private void getPostOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        getPostOrder(node.getLeftChild(), sb);
        getPostOrder(node.getRightChild(), sb);
        sb.append(node.getAlphabet());
    }
}

class Node {
    private char alphabet;
    private Node leftChild, rightChild;

    public Node(char alphabet) {
        this.alphabet = alphabet;
    }

    public void setLeftChild(Node leftChild) {
        if (leftChild.getAlphabet() == '.') {
            return;
        }

        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        if (rightChild.getAlphabet() == '.') {
            return;
        }

        this.rightChild = rightChild;
    }

    public Node getLeftChild() { return leftChild; }
    public Node getRightChild() { return rightChild; }
    public char getAlphabet() { return alphabet; }

    public List<Node> getBothChildren() {
        List<Node> children = new ArrayList<>();
        children.add(leftChild);
        children.add(rightChild);
        return children;
    }
}