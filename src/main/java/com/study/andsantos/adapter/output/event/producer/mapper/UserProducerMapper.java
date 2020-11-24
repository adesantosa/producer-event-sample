package com.study.andsantos.adapter.output.event.producer.mapper;

import com.study.andsantos.adapter.output.event.producer.event.UserEvent;
import com.study.andsantos.application.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserProducerMapper {

    public UserEvent toUser(User user) {
        return UserEvent.builder()
                .id(user.getId())
                .build();
    }
}
