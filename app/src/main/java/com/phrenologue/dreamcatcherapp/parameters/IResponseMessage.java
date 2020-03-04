package com.phrenologue.dreamcatcherapp.parameters;

import org.json.JSONException;

public interface IResponseMessage<T> {
    public void onSuccess(T response) throws JSONException;
    public void onFailure(String errorMessage);
}
