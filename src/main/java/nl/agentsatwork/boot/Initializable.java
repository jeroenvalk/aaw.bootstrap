package nl.agentsatwork.boot;

import org.apache.log4j.Logger;

import nl.agentsatwork.root.Root;
import nl.agentsatwork.xml.Element;

public class Initializable<A> implements Cons<A>, Init<A> {
	static private Logger logger = Logger.getLogger(Initializable.class);
	
	protected Element root = null;
	private Boolean initializable = true, initialized = false;

	public void setRoot(Root root) {
		this.root = root;
	}

	public A init(String xpath) {
		if (root == null) {
			root = new Root().init(".");
		}
		return initialize(root.xpath(xpath).singleton());
	}

	public boolean isInitializable() {
		return initializable;
	}

	public boolean isInitialized() {
		return initialized;
	}

	@SuppressWarnings("unchecked")
	public A initialize(Element config) {
		String className = null;
		if (config.hasTagName("aaw:class")) {
		}
		A result = null;
		try {
			Class<A> c = (Class<A>) Class.forName(className);
			try {
				result = c.newInstance();
			} catch (InstantiationException e) {
				logger.error(null, e);
				return null;
			} catch (IllegalAccessException e) {
				logger.error(null, e);
				return null;
			}
			if (result instanceof Init<?>) {
				return (A) ((Init<?>) result).initialize(config);
			} else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			logger.error(null, e);
			return null;
		}
	}

	final protected void checkInitialization() {
		if (!isInitialized()) {
			if (isInitializable()) {
				throw new IllegalStateException("initializable but NOT initialized");
			} else {
				throw new IllegalStateException("TERMINATED");
			}
		}
	}
}
