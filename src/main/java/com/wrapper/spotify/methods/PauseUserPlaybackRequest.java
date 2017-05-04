package com.wrapper.spotify.methods;

import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.exceptions.WebApiException;

import java.io.IOException;

// TODO : write test
public class PauseUserPlaybackRequest extends AbstractRequest {

    public PauseUserPlaybackRequest(Builder builder) {
        super(builder);
    }

    public SettableFuture<String> getAsync() {
        SettableFuture<String> pauseFutur = SettableFuture.create();

        final String response;
        try {
            response = putJson();
            pauseFutur.set(response);
        } catch (Exception e) {
            pauseFutur.setException(e);
        }

        return pauseFutur;
    }

    public String get() throws IOException, WebApiException {
        final String response = putJson();
        return response;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractRequest.Builder<Builder> {
        public Builder accessToken(String accessToken) {
            return header("Authorization", "Bearer " + accessToken);
        }

        public PauseUserPlaybackRequest build() {
            return new PauseUserPlaybackRequest(this);
        }
    }
}
