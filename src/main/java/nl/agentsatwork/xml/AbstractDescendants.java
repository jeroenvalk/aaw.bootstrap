package nl.agentsatwork.xml;

import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AbstractDescendants<A> extends AbstractList<A> implements Descendants<A> {
	
	private List<Map<Long,Set<Integer>>> cache = null;

	public void setParent(Element parent) {
		// TODO Auto-generated method stub
		
	}

	public A singleton() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getTagNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String[]> attr() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void put(String name, String[] values) {
		// TODO Auto-generated method stub
		
	}

	public Descendants<Descendants<A>> xpath(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public Descendants<Element> flatten(int levels) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public A get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
