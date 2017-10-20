package com.freightsol.freightsol.Utils;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.base.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Response;

/**
 * Created by probal on 10/17/17.
 */
public class HttpResponseUtils {

    public static ResponseEntity getOkResponse(String callback, Object responseData) {
        if(Strings.isNullOrEmpty(callback)) {
            return new ResponseEntity(responseData, HttpStatus.OK);
        } else {
            return new ResponseEntity(new JSONPObject(callback, responseData), HttpStatus.OK);
        }
    }
    public static ResponseEntity getCustomHttpResponse(String callback, Object responseData, HttpStatus status) {
        if(Strings.isNullOrEmpty(callback)) {
            return new ResponseEntity(responseData, status);
        } else {
            return new ResponseEntity(new JSONPObject(callback, responseData), status);
        }
    }
/*
    public static Response getErrorResponse(String callback, Object responseData) {
        if(Strings.isNullOrEmpty(callback)){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseData).build();
        }else{
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new JSONPObject(callback, responseData)).build();
        }
    }

    public static Response getCustomErrorResponse(String callback, Object responseData, Response.Status status) {
        if(Strings.isNullOrEmpty(callback)){
            return Response.status(status).entity(responseData).build();
        }else{
            return Response.status(status).entity(new JSONPObject(callback, responseData)).build();
        }
    }

    public static Response getErrorResponse(String callback){
        if(Strings.isNullOrEmpty(callback)){
            return Response.serverError().build();
        }else{
            return Response.serverError().entity(new JSONPObject(callback, "Internal Server Error")).build();
        }
    }*/
}
