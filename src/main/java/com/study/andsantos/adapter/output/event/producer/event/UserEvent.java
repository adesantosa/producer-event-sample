package com.study.andsantos.adapter.output.event.producer.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEvent {

    private final Long id;
}
