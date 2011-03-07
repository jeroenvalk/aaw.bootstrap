package nl.agentsatwork.root;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import nl.agentsatwork.xml.AbstractElement;
import nl.agentsatwork.xml.Element;

import org.apache.log4j.Logger;

public class DefaultRoot extends AbstractElement implements Element {
	static private Logger logger = Logger.getLogger(DefaultRoot.class);

	static private Map<File, DefaultRoot> map = new HashMap<File, DefaultRoot>();
	static private Map<DefaultRoot, File> pam = new HashMap<DefaultRoot, File>();

	private String xpath = null;

	public Element init(String xpath) {
		if (xpath == null || xpath.equals("")) {
			File file = pam.get(this);
			pam.remove(this);
			map.remove(file);
			xpath = null;
			return null;
		}
		if (root == null) {
			File file = new File(xpath);
			if (map.containsKey(file)) {
				assert pam.containsKey(map.get(file));
				assert pam.get(map.get(file)).equals(file);
				assert map.get(pam.get(map.get(file))) == map.get(file);
				return map.get(file).init(xpath);
			} else {
				if (!file.isDirectory()) {
					if (file.mkdirs()) {
						logger.info("directory '"+file.getPath()+"' created");
					} else {
						logger.error("cannot create directory '"+file.getPath()+"'");
					}
				}
				map.put(file, this);
				pam.put(this, file);
				this.xpath = xpath;
				this.setAttributes(new RootAttributes(new File(file.getPath()
						+ File.separator + ".properties")));
				return this;
			}
		} else {
			return initialize(root.xpath(xpath).singleton());
		}
	}

	public boolean isInitializable() {
 		return true;
	}

	public boolean isInitialized() {
		return xpath != null;
	}

	public Element initialize(Element config) {
		logger.fatal("initialization not implemented");
		throw new UnsupportedOperationException();
	}

}
