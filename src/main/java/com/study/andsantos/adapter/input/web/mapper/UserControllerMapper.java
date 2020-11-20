package com.study.andsantos.adapter.input.web.mapper;

import com.study.andsantos.adapter.input.web.request.UserRequest;
import com.study.andsantos.application.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserControllerMapper {

    public User toUser(UserRequest userRequest) {
        return User.builder()
                .id(userRequest.getId())
                .name(userRequest.getName())
                .build();
    }
}
