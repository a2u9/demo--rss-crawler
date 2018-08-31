package a2u9.demorsscrawler;

import a2u9.demorsscrawler.Rss.RssFeed;
import a2u9.demorsscrawler.Rss.RssParser;
import a2u9.demorsscrawler.Rss.RssProcessor;
import org.junit.Before;
import org.junit.Test;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

//import java.util.Properties;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoRssCrawlerApplicationTests {

    private final String rssFileName = "file:src/test/resources/content-example-1.rss";
    // private final String rssFileName = "file:src/test/resources/content-example-2.rss";
    // private final String rssFileName = "file:src/test/resources/content-example-3.rss";
    // private final String rssFileName = "https://news.yandex.ru/daily.rss";

    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp() { // throws Exception
//        Resource resource = new ClassPathResource("rss-source.properties");
//        Properties properties = PropertiesLoaderUtils.loadProperties(resource);

        File curDir = new File(".");
//        File[] filesList = curDir.listFiles();
//        for(File f : filesList){
//            if(f.isDirectory())
//                System.out.println(f.getName());
//            if(f.isFile()){
//                System.out.println(f.getName());
//            }
//        }
        System.out.println("curDir.getAbsolutePath() = " + curDir.getAbsolutePath());
    }

    @Test
    public void createSaxParser() throws Exception {

        /*SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);

        SAXParser saxParser = spf.newSAXParser();
        System.out.println("SAXParser created OK");

        final RssParser rssParser = new RssParser();
        final RssProcessor rssProcessor = new RssProcessor(rssFileName);

        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(rssParser);
        xmlReader.setErrorHandler(rssParser);
//        xmlReader.parse(rssFileName);
        xmlReader.parse(rssProcessor.getInputSource());*/

        RssProcessor rssProcessor = new RssProcessor();
        RssFeed rssFeed = rssProcessor.processRssUrl(rssFileName);

        System.out.println("RSS: " + rssFeed.toString());

//        rssProcessor.close();

//        URL url = new URL(rssFileName);
//        InputStream urlInputStream = url.openConnection().getInputStream();
//        System.out.println("InputStream created OK");
//
//        RssParser rssParser = new RssParser(rssFileName);
//        saxParser.parse(urlInputStream, rssParser);
//        saxParser.parse(rssProcessor.getUrlInputStream(), rssParser);
        System.out.println("SAX parsed OK");


    }
}
