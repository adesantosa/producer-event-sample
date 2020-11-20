package com.study.andsantos.application.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;
    private String name;
    private String email;
    private String bornDate;
    private String motherName;

}
