package com.study.andsantos.adapter.input.web.controller;

import com.study.andsantos.adapter.input.web.mapper.UserControllerMapper;
import com.study.andsantos.adapter.input.web.request.UserRequest;
import com.study.andsantos.application.port.input.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserControllerMapper userControllerMapper;
    private final CreateUserUseCase createEventUseCase;

    @PostMapping
    public Mono<Void> createUser(@RequestParam UserRequest userRequest) {
        return createEventUseCase.create(userControllerMapper.toUser(userRequest));
    }
}
