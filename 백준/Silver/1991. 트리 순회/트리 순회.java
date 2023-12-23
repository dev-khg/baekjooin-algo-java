import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Node> node = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            node.add(new Node((char) i));
        }

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Node root = node.get(alphaToNum(st.nextToken().charAt(0)));
            char c = st.nextToken().charAt(0);
            if (c != '.')
                root.left = node.get(alphaToNum(c));
            c = st.nextToken().charAt(0);
            if (c != '.')
                root.right = node.get(alphaToNum(c));
        }

        StringBuilder sb = new StringBuilder();
        inOrder(node.get(0), sb);
        sb.append("\n");
        preOrder(node.get(0), sb);
        sb.append("\n");
        postOrder(node.get(0), sb);

        System.out.println(sb);
    }

    private static void postOrder(Node node, StringBuilder sb) {
        if(node == null) return;
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.c);
    }

    private static void inOrder(Node node, StringBuilder sb) {
        if(node == null) return;
        sb.append(node.c);
        inOrder(node.left, sb);
        inOrder(node.right, sb);
    }

    private static void preOrder(Node node, StringBuilder sb) {
        if(node == null) return;
        preOrder(node.left, sb);
        sb.append(node.c);
        preOrder(node.right, sb);
    }

    private static int alphaToNum(char c) {
        return c - 'A';
    }

    static class Node {
        char c;
        Node left;
        Node right;

        public Node(char c) {
            this.c = c;
        }
    }
}