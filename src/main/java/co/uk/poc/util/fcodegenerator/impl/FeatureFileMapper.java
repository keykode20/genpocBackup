package co.uk.poc.util.fcodegenerator.impl;

import java.util.List;
import java.util.Map;

/**
 * @author Emilio
 */
public class FeatureFileMapper {
    private Map<String, List<String>> map;

    public FeatureFileMapper(Map<String, List<String>> proxy){
        this.map = proxy;
    }

    public FeatureFileMapper(){

    }

    public Map<String, List<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<String>> proxy) {
        this.map = proxy;
    }
}
