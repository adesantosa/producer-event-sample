package com.study.andsantos.adapter.input.web.controller;

import com.github.javafaker.Faker;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.study.andsantos.IntegrationTest;
import com.study.andsantos.adapter.input.web.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserControllerTest extends IntegrationTest {

    private final WebTestClient webTestClient;

    @Test
    public void shouldCallUserCreation() throws JSONException {
        //Arrange
        final var userId = System.currentTimeMillis();
        final var name = Faker.instance().funnyName().name();

        mockUserEndpoint(userId, name);

        //Act
        callUserEndpoint(userId, name);
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

    private void mockUserEndpoint(final Long userId, final String name) throws JSONException {
        WireMock.stubFor(
                WireMock.post(WireMock.urlPathEqualTo("/user"))
                        .withRequestBody(equalToJson(new JSONObject()
                                .put("id", userId)
                                .put("name", name)
                                .toString()
                        ))
                        .willReturn(aResponse()
                                .withStatus(OK.value())
                        )
        );
    }

}
