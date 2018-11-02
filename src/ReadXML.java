//import org.junit.BeforeClass;
//import org.w3c.dom.Document;
//import org.xml.sax.SAXException;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.File;
//import java.io.IOException;
//
//@BeforeClass
//public void ChooseBrowser throws Exception{
//        String browserType = getData ("BrowserType");
//        if(browserType.equals("Chrome")){
//        options.addArguments("start--incognito");
//        driver = new ChromeDriver(options);
//        }else if(browserType.equals("IE")){
//        driver = new InternetExplorerDriver();
//        }
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://buyme.co.il");
//        }
//public static String getData (String keyName) throws Exception{
//        File configXmlFile=new File("C:\\Users\\Michal\\Desktop\\Config2.xml");
//        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
//        Document doc=dBuilder.parse(fXmlFile);
//        doc.getDocumentElement().normalize();
//        return doc.getElementsByTagName(keyName).item(0).getTextContent();
//        }
//
////public class ReadXML {
////    private static String getData(String keyName) throws ParserConfigurationException, IOException, SAXException {
////        File configXmlFile = new File("C:\\Users\\Michal\\Desktop\\Config2.xml");
////        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
////
////        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
////        Document doc = dBuilder.parse(configXmlFile);
////
////        if (doc != null) {
////            doc.getDocumentElement().normalize();
////        }
////        assert doc != null;
////        return doc.getElementsByTagName(keyName).item(0).getTextContent();
////
////    }
//}


