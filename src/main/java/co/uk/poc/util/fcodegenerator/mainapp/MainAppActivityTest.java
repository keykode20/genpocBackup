package co.uk.poc.util.fcodegenerator.mainapp;

import co.uk.poc.util.fcodegenerator.impl.FeatureFileMapper;
import co.uk.poc.util.fcodegenerator.impl.FileSystemFeatureFileReaderImpl;
import co.uk.poc.util.fcodegenerator.impl.MapToClass;
import co.uk.poc.util.fgit.GitMainAppTest;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;

/**
 * Created by Emilio on 07/06/2018.
 */
public class MainAppActivityTest {
    public static void main(String... args) throws IOException, JClassAlreadyExistsException, GitAPIException {
        //GitMainAppTest.createRepo();
        Repository repo = FileRepositoryBuilder.create(new File("C:\\codegen\\src\\main\\java\\my\\code\\generated",".git"));
        repo.create();
        Git git = new Git(repo);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        FileSystemFeatureFileReaderImpl fileSystemFeatureFileReaderImpl = ctx.getBean("fileSystemFeatureFileReaderImpl", FileSystemFeatureFileReaderImpl.class);
        String fileName = "C://lines//lines.txt";

        FeatureFileMapper content = fileSystemFeatureFileReaderImpl.getContent(fileName);
        MapToClass mapToClass = new MapToClass();
        mapToClass.classGenerator(content);

        File newFile = new File("C:\\codegen\\src\\main\\java\\my\\code");
        git.add().addFilepattern(".").call();
        RevCommit rev = git.commit().setAuthor("omry", "omry@codegen.com").setMessage("Worked fine").call();
    }
}
