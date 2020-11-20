package com.study.andsantos.application.port.input;


import com.study.andsantos.application.domain.User;
import reactor.core.publisher.Mono;

public interface CreateUserUseCase {

    Mono<Void> create(User user);
}
