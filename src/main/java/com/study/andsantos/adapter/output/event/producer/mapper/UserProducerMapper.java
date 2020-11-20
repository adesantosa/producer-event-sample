package com.study.andsantos.adapter.output.event.producer.mapper;

import com.study.andsantos.adapter.input.web.request.UserRequest;
import com.study.andsantos.application.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserProducerMapper {

    public UserRequest toUser(User user) {
        return UserRequest.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
