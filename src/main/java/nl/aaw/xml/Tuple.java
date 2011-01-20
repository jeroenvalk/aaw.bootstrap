package nl.aaw.xml;

import java.util.List;
import java.util.Map;

public interface Tuple<A> extends List<A> {

	A singleton();

	String[] getTagNames();

	Map<String, String[]> attr();

	String[] get(String name);

	void put(String name, String[] values);

	Tuple<Tuple<A>> xpath(String path);

}
