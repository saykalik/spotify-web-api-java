package com.wrapper.spotify.methods;

import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.JsonUtil;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.models.Device;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.List;

// TODO : write test
public class AvailableDevicesRequest extends AbstractRequest {

    public AvailableDevicesRequest(Builder builder) {
        super(builder);
    }

    public SettableFuture<List<Device>> getAsync() {
        SettableFuture<List<Device>> availableDevicesFuture = SettableFuture.create();

        try {
            final String jsonString = getJson();
            final JSONObject jsonObject = JSONObject.fromObject(jsonString);

            availableDevicesFuture.set(JsonUtil.createDevices(jsonObject));
        } catch (Exception e) {
            availableDevicesFuture.setException(e);
        }

        return availableDevicesFuture;
    }

    public List<Device> get() throws IOException, WebApiException {
        final String jsonString = getJson();
        final JSONObject jsonObject = JSONObject.fromObject(jsonString);

        return JsonUtil.createDevices(jsonObject);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractRequest.Builder<Builder> {
        public Builder accessToken(String accessToken) {
            return header("Authorization", "Bearer " + accessToken);
        }

        public AvailableDevicesRequest build() {
            return new AvailableDevicesRequest(this);
        }
    }
}
