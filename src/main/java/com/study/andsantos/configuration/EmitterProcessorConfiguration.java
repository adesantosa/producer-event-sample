package com.study.andsantos.configuration;

import com.study.andsantos.adapter.output.event.producer.event.UserEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.EmitterProcessor;

@Configuration
public class EmitterProcessorConfiguration {

    @Bean
    public EmitterProcessor<UserEvent> userRequestEmitterProcessor() {
        return EmitterProcessor.create();
    }
}
