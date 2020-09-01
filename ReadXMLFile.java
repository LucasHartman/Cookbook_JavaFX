package readData;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

// Source: https://mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/

public class ReadXMLFile {

   //public static void main(String argv[]) {

	// Constructor - read xml
	public static String[] readXmlFile() { 
		
		// declared output variable
		String StaffId = null;
	    String First = null;
	    String Last = null;
	    String Nick = null;
	    String Sal = null;

	    
	    
	    
	    
		
    try {

	File fXmlFile = new File("src/readData/file.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

	
	
	
	
	
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName()); // print root element (company)

	NodeList nList = doc.getElementsByTagName("Staff");

	System.out.println("----------------------------");

	
	
	
	
	
	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		
		
		
		
		
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			//System.out.println("Staff id : " + eElement.getAttribute("id"));
			//System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
			//System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
			//System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
			//System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
			
			// read data
			StaffId = eElement.getAttribute("id");
			First = eElement.getElementsByTagName("firstname").item(0).getTextContent();
			Last = eElement.getElementsByTagName("lastname").item(0).getTextContent();
			Nick = eElement.getElementsByTagName("nickname").item(0).getTextContent();
			Sal = eElement.getElementsByTagName("salary").item(0).getTextContent();

		}
			
	}
    
    } catch (Exception e) {
	e.printStackTrace();
    }

    // array - Export Read data
    return new String[] {StaffId, First, Last, Nick, Sal};
 
  }

}