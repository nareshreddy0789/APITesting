package com.bayamp.apitestin;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by naresh on 2/29/2016.
 */
public class PostTest {
    @Test
    @Parameters({"url"})
    public void engineersTest(String url) throws ClientProtocolException,
            IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost get = new HttpPost(url + "/bayamp/create");
        String json = "{\"name\":\"John\"}";
        StringEntity entity = new StringEntity(json);
        get.setEntity(entity);
        get.setHeader("Accept", "application/json");
        get.setHeader("Content-type", "application/json");

        HttpResponse reponseMessage = client.execute(get);
        StatusLine line = reponseMessage.getStatusLine();
        int code = line.getStatusCode();
        Assert.assertEquals(code, 201);

    }
}
