package com.study.andsantos.adapter.input.web.controller;

import com.github.javafaker.Faker;
import com.study.andsantos.IntegrationTest;
import com.study.andsantos.adapter.input.web.request.UserRequest;
import com.study.andsantos.adapter.output.event.producer.UserProducer;
import com.study.andsantos.adapter.output.event.producer.event.UserEvent;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserControllerTest extends IntegrationTest {

    private final WebTestClient webTestClient;
    private final UserProducer userProducer;

    @Test
    public void shouldCallUserCreation() throws JSONException {
        //Arrange
        final var userId = System.currentTimeMillis();
        final var name = Faker.instance().funnyName().name();

        //Act
        callUserEndpoint(userId, name);

        //Assert
        userProducer.produceCreatedUser().get()
                .map(this::assertCreatedUser) //expectOnNext
                .subscribe() //VerifyComplete
        ;
    }

    private UserEvent assertCreatedUser(UserEvent userEvent) {
        Assertions.assertNotNull(userEvent);
        return userEvent;
    }


    private void callUserEndpoint(final Long userId, final String name) throws JSONException {
        webTestClient.post()
                .uri("/user")
                .bodyValue(UserRequest.builder()
                        .id(userId)
                        .name(name)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }

}
