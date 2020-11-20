package com.study.andsantos.application.port.output;

import com.study.andsantos.application.domain.User;
import reactor.core.publisher.Mono;

public interface ProduceUserPort {

    Mono<Void> produce(User user);
}
