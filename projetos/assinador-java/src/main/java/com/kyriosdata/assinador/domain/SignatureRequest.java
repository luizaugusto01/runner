package com.kyriosdata.assinador.domain;

public class SignatureRequest {
    private String content;
    private String token;
    private String signature; // Used for validation
    
    public SignatureRequest() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
