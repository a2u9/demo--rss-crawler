package a2u9.demorsscrawler.Rss;

import java.util.ArrayList;

public class RssFeed {

    private String title;
    private String description;
    private String link;
    private String language;
    private String generator;
    private String copyright;
    private String imageUrl;
    private String imageTitle;
    private String imageLink;

    private ArrayList<RssItem> items;

    public RssFeed() {
        this.items = new ArrayList<RssItem>();
    }

    @Override
    public String toString() {
        return "RssFeed{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", language='" + language + '\'' +
                ", generator='" + generator + '\'' +
                ", copyright='" + copyright + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageTitle='" + imageTitle + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", items=" + items.toString() +
                '}';
    }

    public void addItem(RssItem item) {
        items.add(item);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
