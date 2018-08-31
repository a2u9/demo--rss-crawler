package a2u9.demorsscrawler.Rss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class RssProcessor {
    private static final Logger log = LoggerFactory.getLogger(RssProcessor.class);

    private URL url;
    private InputStream urlInputStream;

    public RssProcessor() {
    }

    /*public RssProcessor(String urlString) {
        try {
            this.url = new URL(urlString);
            this.urlInputStream = url.openConnection().getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Can't create RSS input stream");
        }
    }*/

    public RssFeed processRssUrl(String rssUrlString) throws MalformedURLException {
        URL rssUrl = new URL(rssUrlString);
        RssParser rssParser = new RssParser();

        // try (InputStream rssInputStream = rssUrl.openConnection().getInputStream()) {
        try (InputStream rssInputStream = new URL(rssUrlString).openConnection().getInputStream()) {
            urlInputStream = rssInputStream;
            try {
                SAXParserFactory spf = SAXParserFactory.newInstance();
                // spf.setNamespaceAware(true);
                SAXParser saxParser = spf.newSAXParser();

                XMLReader xmlReader = saxParser.getXMLReader();
                xmlReader.setContentHandler(rssParser);
                xmlReader.setErrorHandler(rssParser);
                xmlReader.parse(new InputSource(rssInputStream));
                // xmlReader.parse(rssUrlString);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Can't create SAX parser");
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Can't create RSS URL stream");
        } finally {
//            log.info("close()ing RSS URL stream");
            /*try {
                if (urlInputStream != null) {
                    urlInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                log.error("Error close RSS URL stream");
            }*/
//            close();
        }

        return rssParser.getFeed();
    }

    public void close() {
        log.info("close() method invoked");
        try {
            if (urlInputStream != null) {
                log.info("do close()");
                urlInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Error close RSS URL stream");
        }
    }
}
