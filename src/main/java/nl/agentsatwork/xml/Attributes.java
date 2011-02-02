package nl.agentsatwork.xml;

import java.util.Map;

public interface Attributes extends Map<String,String> {

	Descendants<Element> asElements(String xpath);
	
}
