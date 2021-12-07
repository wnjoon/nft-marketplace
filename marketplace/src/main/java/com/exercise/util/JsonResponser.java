package com.exercise.util;

import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import org.springframework.stereotype.Component;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Component
public class JsonResponser {
    private String successFieldName = "success";
    private String errorCodeFieldName = "errorCode";
    private String errorMessageFieldName = "errorMsg";
    private String dataFieldName = "data";

    private HttpHeaders responseHeaders = new HttpHeaders();

    public String getSuccessFieldName() {
        return successFieldName;
    }

    public void setSuccessFieldName(String successFieldName) {
        this.successFieldName = successFieldName;
    }

    public String getErrorCodeFieldName() {
        return errorCodeFieldName;
    }

    public void setErrorCodeFieldName(String errorCodeFieldName) {
        this.errorCodeFieldName = errorCodeFieldName;
    }

    public String getErrorMessageFieldName() {
        return errorMessageFieldName;
    }

    public void setErrorMessageFieldName(String errorMessageFieldName) {
        this.errorMessageFieldName = errorMessageFieldName;
    }

    public String getDataFieldName() {
        return dataFieldName;
    }

    public void setDataFieldName(String dataFieldName) {
        this.dataFieldName = dataFieldName;
    }
    public ResponseEntity<String> success(Object dtoObject){
        Gson gson = new Gson();
        String json = gson.toJson(dtoObject);

        return success(json);
    }
    
    public ResponseEntity<String> success(String jsonStr){
        JsonObject returnJson = new JsonObject();
        

		// 초기값 Setting		
		returnJson.addProperty(successFieldName, true);
		returnJson.addProperty(errorCodeFieldName, "");
        returnJson.addProperty(errorMessageFieldName, "");
        returnJson.addProperty(dataFieldName, "");

		if( jsonStr != null ) {
            JsonReader reader = new JsonReader( new StringReader(jsonStr.trim()));
            reader.setLenient(true);
            JsonElement jsonElement = JsonParser.parseReader(reader);
			
			if (jsonElement instanceof JsonObject) {
					returnJson.add(dataFieldName, jsonElement.getAsJsonObject());
			} else if (jsonElement instanceof JsonArray) {
				    returnJson.add(dataFieldName, jsonElement.getAsJsonArray());
			} else{
                returnJson.addProperty(dataFieldName, jsonStr);
            }
		}
       
        return new ResponseEntity<String>(returnJson.toString(), responseHeaders, HttpStatus.OK);
    }

    public ResponseEntity<String> success(){
        return success("");
    }    

    public ResponseEntity<String> error(String errorCode, String errorMsg){
        JsonObject returnJson = new JsonObject();
        responseHeaders.set("Content-Type","application/json");

		// 초기값 Setting		
		returnJson.addProperty(successFieldName, false);
		returnJson.addProperty(errorCodeFieldName, errorCode);
        returnJson.addProperty(errorMessageFieldName, errorMsg);
        returnJson.addProperty(dataFieldName, "");

        return new ResponseEntity<String>(returnJson.toString(),responseHeaders, HttpStatus.OK);
    }

    public ResponseEntity<String> error(String errorCode, String errorMsg, HttpStatus httpStatus){
        JsonObject returnJson = new JsonObject();
        responseHeaders.set("Content-Type","application/json");

		// 초기값 Setting		
		returnJson.addProperty(successFieldName, false);
		returnJson.addProperty(errorCodeFieldName, errorCode);
        returnJson.addProperty(errorMessageFieldName, errorMsg);
        returnJson.addProperty(dataFieldName, "");

        return new ResponseEntity<String>(returnJson.toString(), responseHeaders, httpStatus);
    }    

    public ResponseEntity<String> error(String errorMsg){
        JsonObject returnJson = new JsonObject();
        responseHeaders.set("Content-Type","application/json");

		// 초기값 Setting		
		returnJson.addProperty(successFieldName, false);
		returnJson.addProperty(errorCodeFieldName, "");
        returnJson.addProperty(errorMessageFieldName, errorMsg);
        returnJson.addProperty(dataFieldName, "");

        return new ResponseEntity<String>(returnJson.toString(), responseHeaders, HttpStatus.OK);
    }        


    public String errorString(String errorMsg, String errorCode){
        JsonObject returnJson = new JsonObject();

		// 초기값 Setting		
		returnJson.addProperty(successFieldName, false);
		returnJson.addProperty(errorCodeFieldName, errorCode);
        returnJson.addProperty(errorMessageFieldName, errorMsg);
        returnJson.addProperty(dataFieldName, "");

        return returnJson.toString();
    }

    public String errorString(String errorMsg){
        JsonObject returnJson = new JsonObject();

		// 초기값 Setting		
		returnJson.addProperty(successFieldName, false);
		returnJson.addProperty(errorCodeFieldName, "");
        returnJson.addProperty(errorMessageFieldName, errorMsg);
        returnJson.addProperty(dataFieldName, "");

        return returnJson.toString();
    }         
}
