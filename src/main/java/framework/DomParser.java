package framework;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hibernate.loader.custom.Return;
import org.hibernate.property.access.spi.Getter;
import org.hibernate.property.access.spi.Setter;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
/**
 * this {@link Class} parse a xml file  .It also give the view and model .
 * @author rpm shuvo
 *
 */
public class DomParser {
	private ArrayList<Module> domList= new ArrayList<Module>();
	
	
/**
 * {@link Constructor}	
 */
	public  DomParser() {
		parseXML();	
	}
	
/**
 * 	{@link Getter} of {@link DomParser}
 * @return it {@link Return}   {@link Module}  Type {@link ArrayList}
 */
  public ArrayList<Module> getDomList() {
		return domList;
	}

/**
 * {@link Setter} of {@link DomParser}
 * @param {@linkModule} type {@link ArrayList}
 */
	public void setDomList(ArrayList<Module> domList) {
		this.domList = domList;
	}

/**
 * this method read a xml file
 */
private void parseXML()  {

    try {

	File fXmlFile = new File("D:/10th Semester/Advance topic in programming 1/project/Project/src/main/webapp/WEB-INF/mvc.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	doc.getDocumentElement().normalize();
	NodeList nList = doc.getElementsByTagName("module");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		org.w3c.dom.Node nNode = nList.item(temp);
				
		if (nNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {

			org.w3c.dom.Element eElement = (org.w3c.dom.Element) nNode;

			
			String name = eElement.getElementsByTagName("name").item(0).getTextContent();
			String model = eElement.getElementsByTagName("model").item(0).getTextContent();
			
			String ctrl=eElement.getElementsByTagName("ctrl").item(0).getTextContent();
			String view= eElement.getElementsByTagName("view").item(0).getTextContent();
			String map= eElement.getElementsByTagName("map").item(0).getTextContent();
			if(model==null || model=="") {
				model="no model";
			}
			if(view==null || view=="") {
				view="no view";
			}
			domList.add(new Module(name,model, ctrl, view, map));
			
		}
	}
	
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
/**
 * 
 * @param request
 * @return {@link Return} the View for requested {@link URL} as {@link String}
 */
public String RequestForView(HttpServletRequest request) {
	String requestedURL = request.getRequestURI().substring(request.getContextPath().length());
	for(Module module : domList) {
		
		if (module.getMap().equals(requestedURL)) {
			
			return module.getView();
		}
		
	}
	
	return null;
}
/**
 * 
 * @param request
 * @return return the model of requested {@link URL} as {@link String}
 */
public String RequestForModel(HttpServletRequest request) {
	String requestedURL = request.getRequestURI().substring(request.getContextPath().length());
	for(Module module : domList) {
		
		if (module.getMap().equals(requestedURL)) {
			
			return module.getModel();
		}
		
	}
	
	return null;
}

}
