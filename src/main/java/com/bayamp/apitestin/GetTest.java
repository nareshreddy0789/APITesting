package com.bayamp.apitestin;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by naresh on 2/29/2016.
 */
public class GetTest {
    @Test
    @Parameters({"url"})
    public void engineersTest(String url) throws ClientProtocolException,
            IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url + "/bayamp/engineers/Nyyo2oTse");
        HttpResponse reponseMessage = client.execute(get);
        StatusLine line = reponseMessage.getStatusLine();
        int code = line.getStatusCode();
        Assert.assertEquals(code, 200);
        HttpEntity body = reponseMessage.getEntity();
        String expectedContent = "{\"id\":\"Nyyo2oTse\"}";
        String content = EntityUtils.toString(body);
        //System.out.println(content);
        Assert.assertEquals(content, expectedContent);

        //client.ex

    }

}

