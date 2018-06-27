package impl;

import co.uk.poc.util.fcodegenerator.FeatureFileMapperPopulatorStrategy;
import co.uk.poc.util.fcodegenerator.impl.FeatureFileMapper;
import co.uk.poc.util.fcodegenerator.impl.FileSystemFeatureFileReaderImpl;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * FileSystemFeatureFileReaderImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>giu 7, 2018</pre>
 */
public class FileSystemFeatureFileReaderImplTest {

    private ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-test.xml");
    private FeatureFileMapperPopulatorStrategy strategy;
    private FileSystemFeatureFileReaderImpl fileSystemFeatureFileReaderImpl;
    private List<String> mockStringList;
    private FeatureFileMapper mmockMapper;

    @Mock
    private Stream<String> mockStream;

    @Before
    public void before() throws Exception {
         fileSystemFeatureFileReaderImpl = ctx.getBean("fileSystemFeatureFileReaderImpl", FileSystemFeatureFileReaderImpl.class);
        when(Files.lines(Paths.get(any(String.class)))).thenReturn(mockStream);
        when(mockStream.collect(any())).thenReturn(mockStringList);
    }


    /**
     * Method: getContent(String resourcePath)
     */
    @Test
    public void testGetContent() throws Exception {
        FeatureFileMapper fm = fileSystemFeatureFileReaderImpl.getContent("somePath");
        Assert.notEmpty(fm.getMap().get("Given"),()-> "it was actually empty");
    }

    /**
     * Method: getFeatureFileMapper()
     */
    @Test
    public void testGetFeatureFileMapper() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setFeatureFileMapper(FeatureFileMapper featureFileMapper)
     */
    @Test
    public void testSetFeatureFileMapper() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getStrategy()
     */
    @Test
    public void testGetStrategy() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setStrategy(FeatureFileMapperPopulatorStrategy strategy)
     */
    @Test
    public void testSetStrategy() throws Exception {
//TODO: Test goes here... 
    }


} 
