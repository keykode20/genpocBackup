package impl;

import co.uk.poc.util.fcodegenerator.impl.FeatureFileMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static constants.SpringContastant.SPRING_TEST_XML_FILE;

/**
 * FeatureFileMapper Tester.
 *
 * @author Emilio
 * @version 1.0
 * @since <pre>giu 7, 2018</pre>
 *
 */
public class FeatureFileMapperTest {

    private FeatureFileMapper map;
    ApplicationContext ctx;
    @Before
    public void before() throws Exception {
        ctx = new ClassPathXmlApplicationContext(SPRING_TEST_XML_FILE);
        map = ctx.getBean("featureFileMapper", FeatureFileMapper.class);
    }

    /**
     * Method: getMap() should never give an empty value, <br>
     *     from spring.xml this should always return a populated map <br>
     *         with keys set in spring configuration file.
     */
    @Test
    public void map_should_never_be_null_from_the_context() throws Exception {
        Assert.assertNotNull(map.getMap());
    }

}
