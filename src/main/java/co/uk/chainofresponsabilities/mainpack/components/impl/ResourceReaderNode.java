package co.uk.chainofresponsabilities.mainpack.components.impl;

import co.uk.chainofresponsabilities.mainpack.components.Node;
import co.uk.poc.util.fcodegenerator.impl.FeatureFileMapper;
import co.uk.poc.util.fcodegenerator.impl.FileSystemFeatureFileReaderImpl;
import co.uk.poc.util.fcodegenerator.impl.MapToClass;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Emilio on 24/06/2018.
 */
public class ResourceReaderNode extends Node {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    @Override
    public void action() {
        System.out.println("inside Resource handler");
        FileSystemFeatureFileReaderImpl fileSystemFeatureFileReaderImpl = ctx.getBean("fileSystemFeatureFileReaderImpl", FileSystemFeatureFileReaderImpl.class);
        String fileName = "C://lines//lines.txt";

        FeatureFileMapper content = fileSystemFeatureFileReaderImpl.getContent(fileName);
        MapToClass mapToClass = new MapToClass();
        try {
            mapToClass.classGenerator(content);
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
