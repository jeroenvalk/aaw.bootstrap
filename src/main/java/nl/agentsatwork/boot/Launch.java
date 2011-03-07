package nl.agentsatwork.boot;

import nl.agentsatwork.xml.Element;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Launch {
	
	static private String bootstrap = "bootstrap.xml";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("/"+bootstrap));
		Boot boot = factory.getBean("boot", Boot.class);
		Element root = boot.getRoot();
	}

}
