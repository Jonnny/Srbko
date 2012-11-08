import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RSSReader {
private static RSSReader instance = null;

private RSSReader() {
}
public static RSSReader getInstance() {
if(instance == null)
instance = new RSSReader();
return instance;
}
public void writeNews() {
try {
DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
URL u = new URL("http://themoneyconverter.com/rss-feed/RSD/rss.xml"); 
Document doc = builder.parse(u.openStream());
NodeList nodes = doc.getElementsByTagName("item");
for(int i=0;i<nodes.getLength();i++) {
Element element = (Element)nodes.item(i);
Element e = (Element)nodes.item(i);
String description = getElementValue(element,"description");
System.out.println(description);
System.out.println("Title: " + getElementValue(element,"title"));
System.out.println("Link: " + getElementValue(element,"link"));
System.out.println("Publish Date: " + getElementValue(element,"pubDate"));
System.out.println("Description: " + getElementValue(element,"description"));

String [] leftright = description.split("=");
String rightWords[] = leftright[1].split(" ");
String value = rightWords[1];
Float floatValue = Float.parseFloat(value);
System.out.println(floatValue);
System.out.println();
}
}
catch(Exception ex) {
ex.printStackTrace();
}
}
private String getCharacterDataFromElement(Element e) {
try {
Node child = e.getFirstChild();
if(child instanceof CharacterData) {
CharacterData cd = (CharacterData) child;
return cd.getData();
}
}catch(Exception ex) {

}
return "";
} 
protected float getFloat(String value) {
if(value != null && !value.equals(""))
return Float.parseFloat(value);
else
return 0;
}
protected String getElementValue(Element parent,String label) {
return getCharacterDataFromElement((Element)parent.getElementsByTagName(label).item(0));
}
public static void main(String[] args) {
RSSReader reader = RSSReader.getInstance();
reader.writeNews();
}
} 
