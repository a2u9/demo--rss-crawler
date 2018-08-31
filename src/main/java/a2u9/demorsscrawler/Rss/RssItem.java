package a2u9.demorsscrawler.Rss;

public class RssItem {

    public  String title;
    public  String description;
    public  String link;
    public  String pubDate;

    @Override
    public String toString() {
        return "RssItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", pubDate='" + pubDate + '\'' +
                '}';
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

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
}
