package co.uk.chainofresponsabilities.mainpack;

import co.uk.chainofresponsabilities.mainpack.components.Node;
import co.uk.chainofresponsabilities.mainpack.components.TestNode;
import co.uk.chainofresponsabilities.mainpack.components.TestNode1;
import co.uk.chainofresponsabilities.mainpack.components.impl.CreateGitRepoNode;
import co.uk.chainofresponsabilities.mainpack.components.impl.ResourceReaderNode;

/**
 * Created by Emilio on 23/06/2018.
 */
public class MainApp {
    public static void main(String... args){
        /*Node testNode = new TestNode();
        Node testNode1 = new TestNode1();
        testNode.setNextNode(testNode1);
        testNode.doAction();*/

        Node git = new CreateGitRepoNode();
        Node res = new ResourceReaderNode();
        git.setNextNode(res);
        git.doAction();
    }
}
