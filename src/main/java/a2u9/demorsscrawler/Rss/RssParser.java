package a2u9.demorsscrawler.Rss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * RSS parser handler for SAX
 */
public class RssParser extends DefaultHandler implements ErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(RssParser.class);

    private RssFeed feed;
    private RssItem item;
    private StringBuilder textStringBuilder;

    private HashMap<String, String> tags;

    public RssParser() {
        feed = new RssFeed();
        item = new RssItem();
        tags = new HashMap<>();
    }

    public void startDocument() throws SAXException {
//        log.info("in RssParser::startDocument()");
        textStringBuilder = new StringBuilder();
    }

    public void startElement(String namespaceURI,
                             String lName,
                             String qName,
                             Attributes atts) throws SAXException {
//        log.info("in RssParser::startElement() -- L: {}", lName);
//        String key = lName;
        log.info("in RssParser::startElement() -- {}", qName);
        String key = qName;
        tags.putIfAbsent(key, "");
//        if (qName.equalsIgnoreCase("channel")) {
//            return;
//        }
        if (qName.equalsIgnoreCase("item")) {
            item = new RssItem();
            feed.addItem(item);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
//        log.info("in RssParser::characters()");
        textStringBuilder.append(ch, start, length);
//        log.info("textStringBuilder: {}", textStringBuilder.toString().trim());
    }

    public void endElement(String uri, String lName, String qName) {
        log.info("in RssParser::endElement()   -- {} ~ {}", qName, textStringBuilder.toString().trim());
        String key = qName;
        String val = textStringBuilder.toString().trim();
        tags.put(key, val);

        if (key.equalsIgnoreCase("title"))
            item.setTitle(val);

        if (key.equalsIgnoreCase("description"))
            item.setDescription(val);

        textStringBuilder.setLength(0);
    }

    public void endDocument() throws SAXException {                                     //log.info("in RssParser::endDocument()");
        for (Map.Entry<String, String> e : tags.entrySet()) {
            System.out.println("tag: " + e.getKey() + "\n----\n" + e.getValue() + "\n");
        }
//        for (String tag : tags.keySet()) {
//            System.out.println("tag: " + tag + "\n----\n" + tags.get(tag));
//        }
    }

    private String getParseExceptionInfo(SAXParseException spe) {
        String systemId = spe.getSystemId();
        if (systemId == null) {
            systemId = "null";
        }
        String info = "URI=" + systemId + " Line=" + spe.getLineNumber() + ": " + spe.getMessage();
        return info;
    }

    public void warning(SAXParseException spe) throws SAXException {
        log.warn("Warning: {}", getParseExceptionInfo(spe));
    }

    public void error(SAXParseException spe) throws SAXException {
        String message = "Error: " + getParseExceptionInfo(spe);
        log.error(message);
//        throw new SAXException(message);
    }

    public void fatalError(SAXParseException spe) throws SAXException {
        String message = "Fatal Error: " + getParseExceptionInfo(spe);
        throw new SAXException(message);
    }

    public RssFeed getFeed() {
        return feed;
    }
}
