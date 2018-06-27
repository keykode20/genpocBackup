package co.uk.chainofresponsabilities.mainpack.components;

/**
 * Created by Emilio on 24/06/2018.
 */
public abstract class Node2<R,T> {
    private Node2<R,T> nextNode;

    public abstract <R> R action(T t);

    public void doAction(T t){
         r = null;
        if(this != null){
            r = this.action(t);
        }
        if(nextNode != null){
            nextNode.action(r);
        }
    }

    public Node2<R,T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node2<R,T> nextNode) {
        this.nextNode = nextNode;
    }
}
