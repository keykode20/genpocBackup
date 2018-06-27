package impl;

import co.uk.poc.util.fcodegenerator.impl.FeatureFileMapper;
import co.uk.poc.util.fcodegenerator.impl.FeatureFileMapperPopulatorStandardStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static constants.SpringContastant.SPRING_TEST_XML_FILE;

/**
 * FeatureFileMapperPopulatorStandardStrategy Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>giu 7, 2018</pre>
 */
public class FeatureFileMapperPopulatorStandardStrategyTest {

    private FeatureFileMapperPopulatorStandardStrategy strategy;
    private Collection<String> stubList;
    private FeatureFileMapper mapper;
    //stub data
    {
        stubList = new ArrayList<>();
        stubList.add("Scenario: Customer place an order by purchasing an item from search");
        stubList.add("Given user is on Home Page");
        stubList.add("When he search for 'dress'");
        stubList.add("And choose to buy the first item");
        stubList.add("And moves to checkout from mini cart");
        stubList.add("And enter personal details on checkout page");
        stubList.add("And select same delivery address");
        stubList.add("And select payment method as 'check' payment");
        stubList.add("And place the order");
        stubList.add("Scenario: Customer place an order by purchasing an item from search");
        stubList.add("Given user is on Home Page");
        stubList.add("When he search for 'dress'");
        stubList.add("And choose to buy the first item");
        stubList.add("And moves to checkout from mini cart");
        stubList.add("And enter personal details on checkout page");
        stubList.add("And select same delivery address");
        stubList.add("And select payment method as 'check' payment");
        stubList.add("And place the order");
    }

    @Before
    public void before() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_TEST_XML_FILE);
        strategy = ctx.getBean("standardStrategy",FeatureFileMapperPopulatorStandardStrategy.class);
        mapper = ctx.getBean("featureFileMapper",FeatureFileMapper.class);
        strategy.populate(stubList, mapper);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: mapper(Collection<String> list, FeatureFileMapper mapper)
     */
    @Test
    public void values_associated_to_keys_should_not_be_null() throws Exception {
        Assert.assertNotNull(mapper.getMap().get("Given"));
        Assert.assertNotNull(mapper.getMap().get("When"));
        Assert.assertNotNull(mapper.getMap().get("And"));
        Assert.assertNotNull(mapper.getMap().get("Than"));
    }
    
    @Test
    public void values_associated_to_keys_should_contains_data() throws Exception{
        List<String> given = mapper.getMap().get("Given");
        List<String> when = mapper.getMap().get("When");
        List<String> and = mapper.getMap().get("And");
        List<String> than = mapper.getMap().get("Than");

        org.springframework.util.Assert.notEmpty(given,() -> "is empty");
        org.springframework.util.Assert.notEmpty(when,() -> "is empty");
        org.springframework.util.Assert.notEmpty(and,() -> "is empty");
        Assert.assertEquals(than, new ArrayList<>());

    }


} 
