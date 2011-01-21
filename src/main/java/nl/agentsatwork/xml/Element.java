package nl.agentsatwork.xml;

import java.util.Map;

public interface Element {

	String getTagName();
	
	String get(String name);
	
	void put(String name, String value);

	Map<String, String> attr();

	Tuple<Element> xpath(String path);
	
}
