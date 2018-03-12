package base.service;

import base.model.Node;

import java.util.ArrayDeque;

/**
 * @Description:
 * @see: demo
 * @Date 2018/3/7 14:29
 * @Author Vijay Tang
 */
public class TreeHandler {
    /***
     * return root node
     */
    public Node init(){
        Node a=new Node("A",null,null);
        Node b=new Node("B",null,null);
        Node c=new Node("C",null,null);
        Node d=new Node("D",a,b);
        Node e=new Node("E",c,null);
        Node f=new Node("F",d,e);
        return f;
    }

    public void printNode(Node node){
        System.out.println(node.getName());
    }
    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal(Node root){
      if(root==null){
          System.out.println("根节点目录不存在");
          return;
      }
      ArrayDeque<Node> deque=new ArrayDeque<>();
      deque.push(root);
      while (deque.isEmpty()==false){//不为空
          Node node=deque.pop();
          printNode(node);
          if(node.getRightNode()!=null){
              deque.push(node.getRightNode());
          }
          if(node.getLeftNode()!=null){
              deque.push(node.getLeftNode());
          }
      }
    }

    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversal(Node root){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<Node> queue=new ArrayDeque<Node>();//双向队列
        queue.add(root);
        while(queue.isEmpty()==false){
            Node node=queue.remove();
            printNode(node);
            if(node.getLeftNode()!=null){
                queue.add(node.getLeftNode());
            }
            if(node.getRightNode()!=null){
                queue.add(node.getRightNode());
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        TreeHandler treeHandler=new TreeHandler();
        Node node=treeHandler.init();
        System.out.println("深度优先遍历");
        treeHandler.depthOrderTraversal(node);
        System.out.println("广度优先遍历");
        treeHandler.levelOrderTraversal(node);

    }


}
