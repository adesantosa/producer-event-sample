package com.study.andsantos.configuration;

import com.study.andsantos.adapter.input.web.request.UserRequest;
import com.study.andsantos.application.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.EmitterProcessor;

import java.util.function.Supplier;

@Configuration
public class EmitterProcessorConfiguration {

    @Bean
    public Supplier<EmitterProcessor<UserRequest>> produceCreatedUser() {
        return this::userRequestEmitterProcessor;
    }

    @Bean
    public EmitterProcessor<UserRequest> userRequestEmitterProcessor() {
        return EmitterProcessor.create();
    }
}
