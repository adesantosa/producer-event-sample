package com.study.andsantos.adapter.input.web.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private Long id;
    private String name;
}
