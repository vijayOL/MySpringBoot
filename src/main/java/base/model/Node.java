package base.model;

/**
 * @Description:
 * @see: demo
 * @Date 2018/3/7 14:23
 * @Author Vijay Tang
 */
public class Node {
    private String name;

    private Node leftNode;

    private Node rightNode;

    public Node(String name, Node leftNode, Node rightNode) {
        this.name = name;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
