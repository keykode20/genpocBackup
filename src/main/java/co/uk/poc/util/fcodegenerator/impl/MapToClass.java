package co.uk.poc.util.fcodegenerator.impl;

import co.uk.poc.util.fcodegenerator.FeatureFileToClass;
import com.helger.jcodemodel.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.io.File;
import java.io.IOException;

public class MapToClass implements FeatureFileToClass {
    public void classGenerator(FeatureFileMapper mapper) throws JClassAlreadyExistsException, IOException {
        JCodeModel codeModel = new JCodeModel();

        //create package

        JPackage jp = codeModel._package("my.code.generated");

        //create class
        JDefinedClass jc = jp._class(mapper.getMap().get("Scenario").get(0).replaceAll("\\s+",""));

        //create javadoc for the class
        jc.javadoc().add("My example.");

        //generate all given
        mapper.getMap().get("Given").forEach(
                g->jc.method(JMod.PUBLIC,codeModel.VOID,g.replaceAll("\\s+","").toLowerCase()).annotate(Given.class).param("value",g)
        );
        //generate all and
        mapper.getMap().get("And").forEach(
            a ->  jc.method(JMod.PUBLIC,codeModel.VOID,a.replaceAll("\\s+","").toLowerCase()).annotate(And.class).param("value",a)
        );

        mapper.getMap().get("When").forEach(
            w -> jc.method(JMod.PUBLIC,codeModel.VOID,w.replaceAll("\\s+","").toLowerCase()).annotate(And.class).param("value",w)
        );

        //build
        codeModel.build(new File("src/main/java/"));



    }
}
