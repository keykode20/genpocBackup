package co.uk.poc.util.fcodegenerator.impl;

import co.uk.poc.util.fcodegenerator.FeatureFileMapperPopulatorStrategy;
import com.helger.jcodemodel.JClassAlreadyExistsException;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Emilio on 07/06/2018.
 */
public class FeatureFileMapperPopulatorStandardStrategy implements FeatureFileMapperPopulatorStrategy{

    private MapToClass mapToClass = new MapToClass();

    @Override
    public void populate(Collection<String> list , FeatureFileMapper mapper) {


        list.forEach(
                s -> {
                    String[] split = s.split(" ");
                    String firstWord = split[0];
                    if(mapper.getMap().containsKey(firstWord)){
                        List<String> strings = mapper.getMap().get(firstWord);
                        strings.add(s);
                        mapper.getMap().put(firstWord,strings);
                    }
                }
        );

        try {
            mapToClass.classGenerator(mapper);
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
