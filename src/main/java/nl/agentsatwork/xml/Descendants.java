package nl.agentsatwork.xml;

import java.util.List;
import java.util.Map;

public interface Descendants<A> extends List<A> {

	void setParent(Element parent);
	
	A singleton();

	String[] getTagNames();

	Map<String, String[]> attr();

	String[] get(String name);

	void put(String name, String[] values);

	Descendants<Descendants<A>> xpath(String path);
	
	Descendants<Element> flatten(int levels);

}
