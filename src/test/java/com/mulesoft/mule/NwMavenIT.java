/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.mulesoft.mule;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.IOException;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class NwMavenIT
{

    private String port = System.getProperty("port");

    @Test
    public void appIsAlive() throws IOException
    {
        HttpGet httpGet = new HttpGet("http://testmaven-cbi-dev.cloudhub.io/flights");
        HttpResponse response = new DefaultHttpClient().execute(httpGet);
        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        assertEquals("[{DESTINATION=SFO, PRICE=555, ORIGIN=YYZ, ID=0}, {DESTINATION=LAX, PRICE=450, ORIGIN=YYZ, ID=1}, {DESTINATION=SEA, PRICE=777, ORIGIN=SQL, ID=2}, {DESTINATION=SFO, PRICE=999, ORIGIN=SQL, ID=3}]", EntityUtils.toString(response.getEntity()));
    }
    
}
