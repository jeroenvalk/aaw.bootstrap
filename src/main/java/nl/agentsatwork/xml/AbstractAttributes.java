package nl.agentsatwork.xml;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractAttributes extends AbstractMap<String, String>
		implements Attributes {

	private Element parent = null;
	private Map<Set<String>, Descendants<Element>> cache = new HashMap<Set<String>, Descendants<Element>>();

	public void setParent(Element parent) {
		this.parent = parent;
	}

	public Descendants<Element> asElements(String xpath) {
		assert xpath.length() > 1;
		assert xpath.charAt(0) == '@';
		Set<String> snapshot = null;
		switch (xpath.charAt(1)) {
		case '*':
			snapshot = new HashSet<String>();
			snapshot.addAll(this.keySet());
			break;
		default:
			snapshot = new HashSet<String>();
			snapshot.add(xpath.substring(1));
			break;
		}
		Descendants<Element> result = null;
		if (snapshot != null) {
			if (cache.containsKey(snapshot)) {
				result = new DefaultElement(parent, "aaw:attr");
			} else {
				cache.put(snapshot, result);
				result = cache.get(snapshot);
			}
		}
		return result;
	}

}
