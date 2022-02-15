package com.company;

public class Node {

    private Object value;
    private Node left, right;

    public Node(Object value) {
        this.value = value;
    }

    //metoda przeszukująca drzewo wgłąb z wyświetlaniem wartości od skrajnie lewego węzła do skrajnego prawego
    public void visitNode(){
        if(left != null) {
            left.visitNode();
        }
        System.out.println(this);
        if(right != null) {
            right.visitNode();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
