package com.catchydreams.dreamcatcher.parameters;

import org.json.JSONException;

public interface IResponseMessage<T> {
    public void onSuccess(T response) throws JSONException;
    public void onFailure(String errorMessage);
}
