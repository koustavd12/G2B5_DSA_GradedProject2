package com.greatlearning.iitr.gorupassignment2;

public class Main {
    Node node;

    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);

        // Convert the complete BST to a skewed tree with only right nodes
        tree.convertToRightSkewed(tree.node);

        // Display the node values in ascending order
        tree.displayInOrder(tree.node);
    }

    // Function to convert a complete BST to a skewed tree with only right nodes
    public void convertToRightSkewed(Node root) {
        // Base case
        if (root == null) {
            return;
        }

        // Perform a right rotation on the root node
        Node rightChild = root.right;
        root.right = root.left;
        root.left = null;

        // Recursively perform the above steps on the right subtree
        convertToRightSkewed(root.right);

        // Perform right rotations on the left subtree until it is empty
        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = rightChild;
        convertToRightSkewed(rightChild);
    }

    // Function to display the node values in ascending order
    public void displayInOrder(Node root) {
        if (root == null) {
            return;
        }

        displayInOrder(root.left);
        System.out.print(root.data + " ");
        displayInOrder(root.right);
    }
}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}


