package com.catchydreams.dreamcatcher.constants;

import android.os.CountDownTimer;

import com.catchydreams.dreamcatcher.managersAndFilters.IConnectionChecker;
import com.catchydreams.dreamcatcher.parameters.Users;

public class ConnectionChecker {
    private IConnectionChecker connectionChecker;
    public ConnectionChecker(IConnectionChecker connectionChecker){
        this.connectionChecker = connectionChecker;
    }

    public void checkConnection() {
        new CountDownTimer(4000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (Users.getInstance().isConnected()) {
                    connectionChecker.onConnected();
                } else {
                    connectionChecker.onConnectionFailure();
                }
            }
        }.start();
    }
}
