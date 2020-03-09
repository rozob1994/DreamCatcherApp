package com.phrenologue.dreamcatcherapp.parameters;

public class OperationResults {
    private static OperationResults instance = null;
    private String message;
    static boolean status;
    private int success; // can be 1 = successful or 0 = failed.

    private OperationResults() {
    }

    public static OperationResults getInstance() {
        if (instance == null) {
            instance = new OperationResults();
        }
        return instance;
    }

    public static void delOperationResults() {
        instance = null;
    }

    public void setSuccessfulResults(String message) {
        this.status = true;
        this.message = message;
        this.success = 1;
    }

    public void setFailedResults(String message){
        this.success = 0;
        this.message = message;
        this.status = false;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
