package co.uk.chainofresponsabilities.mainpack.components;

/**
 * Created by Emilio on 23/06/2018.
 */
public abstract class Node{

    protected Node nextNode;

    public abstract void action();

    public void doAction(){
        if(this != null){
            this.action();
        }
        if(nextNode != null){
            nextNode.action();
        }
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
