package nl.agentsatwork.boot;

public interface Cons<A> {

	/**
	 * Initializes this object using as configuration the XML Element in the
	 * root XML (see class Root) referenced by an xpath expression. The xpath
	 * expression should yield a singleton; if the expression gives multiple
	 * elements then null is used as configuration.
	 * 
	 * @param xpath
	 * @return
	 */
	A init(String xpath);

}
