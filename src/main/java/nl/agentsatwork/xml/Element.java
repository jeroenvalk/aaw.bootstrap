package nl.agentsatwork.xml;

public interface Element {

	boolean hasTagName(String tagName);
	
	boolean hasAttribute(String name);
	
	boolean exists(String xpath);
	
	String get();
	
	String get(String name);
	
	void set(String name, String value);

	Attributes attr();

	Descendants<Element> xpath(String xpath);
	
}
