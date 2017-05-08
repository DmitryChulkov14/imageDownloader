package net.jurinson;

import net.jurinson.impl.DefaultDownloadImageExecutor;
import net.jurinson.impl.DefaultHtmlPageParser;

import java.io.IOException;
import java.nio.file.Paths;

public class DownloaderRunner
{
    public static void main( String[] args ) throws IOException {
        HtmlPageParser htmlPageParser = new DefaultHtmlPageParser("http://rozetka.com.ua/konfety-v-myagkoj-upakovke/c4629848/");
        DownloadImageExecutor downloadImageExecutor = new DefaultDownloadImageExecutor(5, 3, Paths.get("files/"), htmlPageParser);
        downloadImageExecutor.launch();
    }
}
