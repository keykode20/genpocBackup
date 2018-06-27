package co.uk.poc.util.fcodegenerator;

import co.uk.poc.util.fcodegenerator.impl.FeatureFileMapper;

import java.util.Collection;

/**
 * Created by Emilio on 07/06/2018.
 */
public interface FeatureFileMapperPopulatorStrategy {
    /**
     *
     * @param mapper is the data structure to populate. <br>
     *        Each implementation should have a strategy on how populate the map
     */
    void populate(Collection<String> list , FeatureFileMapper mapper);
}
