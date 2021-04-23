public class TreeTraversal {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    class Tree {
        public Node root;

        public void setRoot(Node node) {
            root = node;
        }

        public Node getRoot() {
            return root;
        }

        public Node createNode(int data, Node left, Node right) {
            Node node = new Node(data);
            node.left = left;
            node.right = right;
            return node;
        }

        public void inOrder(Node node) {
            if(node == null) return;

            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }

        public void preOrder(Node node) {
            if(node == null) return;

            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

        public void postOrder(Node node) {
            if(node == null) return;

            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }
}
