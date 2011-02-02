package nl.agentsatwork.xml;

import nl.agentsatwork.boot.Initializable;

import org.apache.log4j.Logger;

public class AbstractElement extends Initializable<Element> implements
		Element {
	static private Logger logger = Logger.getLogger(AbstractElement.class);

	private Element parent = null;
	private Attributes attr = null;
	private Descendants<?> descendants = null;

	final public boolean hasTagName(String tagName) {
		return get().equals(tagName);
	}

	final public boolean hasAttribute(String name) {
		return name != null && attr().containsKey(name);
	}

	final public boolean exists(String xpath) {
		return xpath(xpath).size() > 0;
	}

	final public String get() {
		return get("");
	}

	final public String get(String name) {
		return attr().get(name);
	}

	final public void set(String name, String value) {
		attr().put(name, value);
	}

	final public Attributes attr() {
		return attr;
	}

	final public Descendants<Element> xpath(String xpath) {
		// TODO Auto-generated method stub
		return null;
	}

	final protected void setAttributes(Attributes attr) {
		this.attr = attr;
	}

	final protected Descendants<Element> xpath(int i, String[] xpath) {
		assert xpath[i].length() > 0;
		switch (xpath[i].charAt(0)) {
		case '/': // select anywhere
			assert xpath[i].length() > 1;
			switch (xpath[i].charAt(1)) {
			case '/':
			case '[': // match attributes of what?
				assert false;
				return null;
			default:
				logger.fatal("not implemented");
				assert false;
				return null;
			}
		case '@': // select attribute
			assert xpath.length == i + 1; // must always be last in xpath
			assert xpath[i].length() > 1;
			switch (xpath[i].charAt(1)) {
			case '/':
			case '@':
			case '.':
			case '[': // match attributes of what?
				assert false;
				return null;
			case '*':
			default:
				return attr.asElements(xpath[i]);
			}
		case '[': // match attributes of what?
			assert false;
			return null;
		case '.': // relative xpath
			if (xpath[i].length() > 1) {
				switch (xpath[i].charAt(1)) {
				case '.': // parent
					if (xpath[i].length() > 2) {
						logger.fatal("not implemented");
						assert false;
						return null;
					} else {
						xpath[i] = "*";
						if (parent instanceof AbstractElement) {
							return ((AbstractElement) parent).xpath(i, xpath);
						} else {
							logger.error("foreign Element detected");
							return null;
						}
					}
				case '[': // match attributes of current
					assert xpath[i].charAt(xpath[i].length() - 1) == ']';
					logger.fatal("not implemented");
					assert false;
					return null;
				default:
					assert false;
					return null;
				}
			} else {
				return this.xpath(++i, xpath);
			}
		case '*': // select ALL
			if (xpath[i].length() > 1) {
				logger.fatal("not implemented");
				assert false;
				return null;
			} else {
				return descendants.flatten(1);
			}
		default:
			assert !xpath[i].contains("/");
			int j;
			if ((j = xpath[i].indexOf('[')) > 0) {
				assert xpath[i].charAt(xpath[i].length()-1) == ']';
				return null;
			} else {
				logger.fatal("not implemented");
				assert false;
				return null;
			}
		}
	}

}
