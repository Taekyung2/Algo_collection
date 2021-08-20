package boj;

import java.util.Objects;
import java.util.Scanner;

public class Q1991 {
    static Node[] tree;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new Node[N];

        for(int i = 0; i < N; i++)
            tree[i] = new Node((char) ('A' + i));

        for(int i = 0; i < N; i++) {
            char parent = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);
            if(left != '.')
                tree[parent - 'A'].setLeft(tree[left - 'A']);
            if(right != '.')
                tree[parent - 'A'].setRight(tree[right - 'A']);
        }

        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
    }

    public static void preOrder(Node cur) {
        System.out.print(cur.c);
        if(Objects.nonNull(cur.left))
            preOrder(cur.left);
        if(Objects.nonNull(cur.right))
            preOrder(cur.right);
    }

    public static void inOrder(Node cur) {
        if(Objects.nonNull(cur.left))
            inOrder(cur.left);
        System.out.print(cur.c);
        if(Objects.nonNull(cur.right))
            inOrder(cur.right);
    }

    public static void postOrder(Node cur) {
        if(Objects.nonNull(cur.left))
            postOrder(cur.left);
        if(Objects.nonNull(cur.right))
            postOrder(cur.right);
        System.out.print(cur.c);
    }

    static class Node {
        char c;
        Node left, right;

        Node(char c) {
            this.c = c;
        }

        void setLeft(Node node) {
            this.left = node;
        }

        void setRight(Node node) {
            this.right = node;
        }
    }
}