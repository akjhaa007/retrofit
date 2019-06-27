package retrofit.learn.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {
/*
    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("tokenType")
    @Expose
    private String tokenType;


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    */





    @SerializedName("usernameOrEmail")
    @Expose
    private String usernameOrEmail;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("token")
    @Expose
    private String token;




    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }
    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }







}