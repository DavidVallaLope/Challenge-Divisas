package com.davidval.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consumer {
    private HttpRequest httpRequest;
    private HttpClient httpClient;

    public Consumer(String uri) throws URISyntaxException {
        this.httpRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .build();
        this.httpClient = HttpClient.newHttpClient();
    }

    public HttpResponse<String> doPetition() {
        try {
            return this.httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printPetition() {
        System.out.println(doPetition().body());
    }

}
