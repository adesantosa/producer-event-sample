package com.study.andsantos.adapter.output.event.producer;

import com.study.andsantos.adapter.input.web.request.UserRequest;
import com.study.andsantos.adapter.output.event.producer.mapper.UserProducerMapper;
import com.study.andsantos.application.domain.User;
import com.study.andsantos.application.port.output.ProduceUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class UserProducer implements ProduceUserPort {

    private final UserProducerMapper userProducerMapper;
    private final EmitterProcessor<UserRequest> queue;


    @Override
    public Mono<Void> produce(User user) {
        return Mono.just(user)
                .map(userProducerMapper::toUser)
                .doOnNext(queue::onNext)
                .then();
    }

}
