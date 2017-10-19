package com.wrapper.spotify.methods;

import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.JsonUtil;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.models.Device;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.sql.Array;
import java.util.List;

// TODO : write test
public class ChangePlayerRequest extends AbstractRequest {

    public ChangePlayerRequest(Builder builder) {
        super(builder);
    }

    public SettableFuture<String> getAsync() {
        SettableFuture<String> changePlayerFuture = SettableFuture.create();

        final String response;
        try {
            response = putJson();
            changePlayerFuture.set(response);
        } catch (Exception e) {
            changePlayerFuture.setException(e);
        }

        return changePlayerFuture;
    }

    public String get() throws IOException, WebApiException {
        final String response = putJson();
        return response;
    }

    public static ChangePlayerRequest.Builder builder() {
        return new ChangePlayerRequest.Builder();
    }

    public static final class Builder extends AbstractRequest.Builder<ChangePlayerRequest.Builder> {
        public ChangePlayerRequest.Builder accessToken(String accessToken) {
            return header("Authorization", "Bearer " + accessToken);
        }

        public ChangePlayerRequest.Builder device(String deviceId) {
            JSONArray ja = new JSONArray();
            ja.add(deviceId);

            JSONObject mainObj = new JSONObject();
            mainObj.put("device_ids", ja);

            body(mainObj);
            return this;
        }

        public ChangePlayerRequest build() {
            return new ChangePlayerRequest(this);
        }
    }
}
