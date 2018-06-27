package co.uk.poc.util.fgit;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;

/**
 * Created by Emilio on 09/06/2018.
 */
public class GitMainAppTest {

    public static void createRepo() throws IOException, GitAPIException {

// Create a Repository object
        Repository repo = FileRepositoryBuilder.create(new File("C:\\codegen\\src\\main\\java\\my\\code\\generated",".git"));
        repo.create();
    //    Repository repo = FileRepositoryBuilder.create(new File("C:\\codegen2",".git"));
        Git git = new Git(repo);

// Create a new file and add it to the index
        File newFile = new File("C:\\codegen\\src\\main\\java\\my\\code");

//        newFile.createNewFile();
//        newFile.setWritable(true);
        git.add().addFilepattern("\\generated").call();

// Now, we do the commit with a message
        RevCommit rev = git.commit().setAuthor("omry", "omry@codegen.com").setMessage("Worked fine").call();
    }

}
