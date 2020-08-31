package com.garima.defectracking.common;

public class AppResponse<String, dataType> {

    private String message;
    private dataType data;

    public AppResponse(){

    }
    public AppResponse(String message, dataType data){
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public dataType getData() {
        return data;
    }

    public void setData(dataType data) {
        this.data = data;
    }
}
