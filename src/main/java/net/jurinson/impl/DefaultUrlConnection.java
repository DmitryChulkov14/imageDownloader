package net.jurinson.impl;

import net.jurinson.UrlConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DefaultUrlConnection implements UrlConnection {

    private URL url;
    private HttpURLConnection httpURLConnection;

    public DefaultUrlConnection(String url) throws IOException {
        this.url = new URL(url);
        httpURLConnection = (HttpURLConnection) this.url.openConnection();
    }

    public String getUrl() {
        return url.toString();
    }
}
