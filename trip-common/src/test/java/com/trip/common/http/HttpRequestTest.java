package com.trip.common.http;

import com.mashape.unirest.http.Unirest;
import org.junit.Test;

public class HttpRequestTest {

    @Test
    public void testA(){
        String json = Unirest.post("http://httpbin.org/post")
                .queryString("name", "Mark")
                .field("last", "Polo")
                .toString();
        System.out.println(json);
    }
}
