package CSE;

import java.util.Stack;

public class IterativePostorder {

    static class Node {
        int data;
        Node left;
        Node right;

        // Create node
        Node(int data) {
            this.data = data;
        }
    }

    static void postorder(Node root) {

        // Check empty tree
        if (root == null) {
            return;
        }

        // Create two stacks
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        // Push root
        stack1.push(root);

        // Process nodes
        while (!stack1.isEmpty()) {

            // Remove node
            Node current = stack1.pop();

            // Store in stack2
            stack2.push(current);

            // Push left node
            if (current.left != null) {
                stack1.push(current.left);
            }

            // Push right node
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        // Print postorder
        while (!stack2.isEmpty()) {
        	Node current = stack2.pop();
            System.out.print(current.data + " ");
        }
    }

    public static void main(String[] args) {

        // Create tree
    	
        Node root = new Node(50);

        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.left.right.left = new Node(35);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        // Display result
        System.out.println("Postorder Traversal:");
        postorder(root);
    }
}