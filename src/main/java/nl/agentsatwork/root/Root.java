package nl.agentsatwork.root;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import nl.agentsatwork.boot.Cons;
import nl.agentsatwork.boot.Init;
import nl.agentsatwork.xml.Element;

import org.apache.log4j.Logger;

public abstract class Root implements Cons<Element>, Init<Element>, Element {
	static private Logger logger = Logger.getLogger(Root.class);
	
	private Map<String, String> attr = new HashMap<String, String>();

	private String xpath = null;
	private File root = null;

	protected String getXpath() {
		return xpath;
	}
	
	protected File getRoot() {
		return root;
	}
	
	public String getTagName() {
		return "root";
	}

	public String get(String name) {
		return attr.get(name);
	}

	public void put(String name, String value) {
		attr.put(name, value);
	}

	public Map<String, String> attr() {
		return attr;
	}

	public Element init(String xpath) {
		if (this.xpath == null) {
			assert root == null;
			root = new File(".");
			if (!root.isDirectory()) {
				logger.error("cannot set working directory as root");
				root = null;
				return null;
			}
		} else {
			assert root != null;
		}
		this.xpath = xpath;
		return this;
	}

	public boolean isInitializable() {
		return true;
	}

	public boolean isInitialized() {
		return xpath != null;
	}

	public Element initialize(Element config) {
		throw new UnsupportedOperationException();
	}
	
}
