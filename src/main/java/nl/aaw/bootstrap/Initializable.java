package nl.aaw.bootstrap;

import java.io.File;

import nl.aaw.xml.Element;
import nl.aaw.xml.XML;

public interface Initializable<A> {
	
	A init(String xpath);
	
	boolean isInitializable();
	
	boolean isInitialized();
	
}
