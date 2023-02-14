package com.devEx.request;

import com.devEx.common.DataForApi;
import com.devEx.utulities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DevExRequest {

    static Response response;

    public static Response getAllProfiles(){

        response = given().accept(ContentType.JSON)
                .when()
                .get(ConfigurationReader.get("allProfiles"));
        response.prettyPrint();
        return response;

    }

    public static Response getOneUserWithPathParam(String id){
        response=given().accept(ContentType.JSON)
                .pathParam("userID",id)
                .when().get(ConfigurationReader.get("getOneUserWithPathParam"));
        return response;
    }

    public static Response registerNewUser(String email, String password, String name, String google,String facebook,String github){
        response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(DataForApi.registerUserBody(email, password, name, google, facebook, github))
                .when()
                .post("/api/users");
        return response;
    }
}
