package co.uk.chainofresponsabilities.mainpack.components.impl;

import co.uk.chainofresponsabilities.mainpack.components.Node;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;

/**
 * Created by Emilio on 24/06/2018.
 */
public class CreateGitRepoNode extends Node{

    @Override
    public void action() {
        System.out.println("inside create git repo");
        Repository repo = null;
        try {
            repo = FileRepositoryBuilder.create(new File("C:\\codegen\\src\\main\\java\\my\\code\\generated",".git"));
            repo.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
