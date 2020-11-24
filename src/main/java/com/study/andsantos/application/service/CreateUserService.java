package com.study.andsantos.application.service;

import com.study.andsantos.application.domain.User;
import com.study.andsantos.application.port.input.CreateUserUseCase;
import com.study.andsantos.application.port.output.ProduceUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final ProduceUserPort produceUserPort;

    @Override
    public Mono<Void> create(User user) {
        return produceUserPort.produce(user);
    }
}
