package net.jurinson.impl;

import net.jurinson.HtmlPageParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultHtmlPageParser implements HtmlPageParser{

    private List<String> links = new ArrayList<>();

    public DefaultHtmlPageParser(String url) throws IOException {
        setImageLinks(url);
    }

    public List<String> getImageLinks() {
        return links;
    }

    private void setImageLinks(String url) throws IOException {
        Document html = Jsoup.connect(url).get();
        Elements blocksWithImgages = html.body().getElementsByClass("responsive-img");
        saveCorrectLinksFromElements(blocksWithImgages);
    }

    private void saveCorrectLinksFromElements(Elements blocksWithImgages) {
        for (Element image : blocksWithImgages){
            if (image.childNodeSize() > 1){
                if (image.childNode(1).attr("data_src").contains(".jpg")){
                    links.add(image.childNode(1).attr("data_src"));
                }
            }
        }
    }
}
