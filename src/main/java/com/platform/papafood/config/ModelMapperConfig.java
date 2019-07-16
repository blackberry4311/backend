package com.platform.papafood.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ModelMapperConfig {

    @Bean(name = "modelMapper")
    public ModelMapper config() {
        ModelMapper modelMapper = new ModelMapper();

        //ignore persistentSet hibernate lazy
        modelMapper.getConfiguration().setPropertyCondition(context -> {
            if (context.getSource() instanceof PersistentCollection) {
                return Hibernate.isInitialized(context.getSource());
            }
            return true;
        });

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
