package com.hzq.router;

import java.util.HashMap;

/**
 * Created by hezhiqiang on 2017/12/6.
 */

public class RouterRequest {
    private String provider;
    private String action;
    private HashMap<String,String> data;

    public RouterRequest(Builder build){
        this.provider = build.provider;
        this.action = build.action;
        this.data = build.data;
    }

    public static class Builder {
        private String provider;
        private String action;
        private HashMap<String,String> data;

        public Builder(){}

        public Builder(String provider,String action) {
            this.provider = provider;
            this.action = action;
        }

        public Builder data(HashMap<String,String> data) {
            this.data = data;
            return this;
        }

        public RouterRequest build() {
            return new RouterRequest(this);
        }

    }

    public HashMap<String,String> getData() {
        return data;
    }

    public String getAction(){
        return action;
    }

    public String getProvider() {
        return provider;
    }
}
