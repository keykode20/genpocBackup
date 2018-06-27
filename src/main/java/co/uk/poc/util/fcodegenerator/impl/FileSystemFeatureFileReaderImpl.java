package co.uk.poc.util.fcodegenerator.impl;

import co.uk.poc.util.fcodegenerator.FeatureFileMapperPopulatorStrategy;
import co.uk.poc.util.fcodegenerator.FeatureFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *@author Emilio
 */
public class FileSystemFeatureFileReaderImpl implements FeatureFileReader {

    private FeatureFileMapper featureFileMapper;
    private FeatureFileMapperPopulatorStrategy strategy;

    @Override
    public FeatureFileMapper getContent(String resourcePath) {
        try(Stream<String> lines = Files.lines(Paths.get(resourcePath))){
            List<String> collect = lines.collect(Collectors.toList());
            strategy.populate(collect,featureFileMapper);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return featureFileMapper;
    }

    public FeatureFileMapper getFeatureFileMapper() {
        return featureFileMapper;
    }

    public void setFeatureFileMapper(FeatureFileMapper featureFileMapper) {
        this.featureFileMapper = featureFileMapper;
    }

    public FeatureFileMapperPopulatorStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(FeatureFileMapperPopulatorStrategy strategy) {
        this.strategy = strategy;
    }
}
