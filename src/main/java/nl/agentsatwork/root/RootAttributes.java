package nl.agentsatwork.root;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import nl.agentsatwork.xml.AbstractAttributes;

final public class RootAttributes extends AbstractAttributes {
	static private Logger logger = Logger.getLogger(RootAttributes.class);

	private File file = null;
	private Properties prop = new Properties();

	public RootAttributes(File file) {
		this.file = file;
	}

	@Override
	public Set<Entry<String, String>> entrySet() {
		return new AbstractSet<Entry<String, String>>() {

			@Override
			public Iterator<Entry<String, String>> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

		};
	}

	private void loadProperties() {
		if (file.isFile()) {
			InputStream stream = null;
			try {
				stream = new FileInputStream(file);
				prop.load(stream);
			} catch (FileNotFoundException e) {
				logger.error(null, e);
			} catch (IOException e) {
				logger.error(null, e);
			}
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					logger.error(null, e);
				}
			}
		}
	}

	private void saveProperties() {
		OutputStream stream = null;
		try {
			stream = new FileOutputStream(file);
			prop.store(stream, "XML attributes");
		} catch (FileNotFoundException e) {
			logger.error(null, e);
		} catch (IOException e) {
			logger.error(null, e);
		}
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
				logger.fatal(null, e);
			}
		}

	}
}
