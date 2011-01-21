package nl.agentsatwork.boot;

import nl.agentsatwork.xml.Element;

/**
 * Let your objects implement the Init interface if you want instance creation
 * to happen in a convenient and standardized way. Two types of classes may
 * implement this interface: (i) classes that represent objects that you want to
 * be created, and (ii) classes that specify factories, i.e., object responsible
 * for creating other objects.
 * 
 * 
 * A class of type (i) is typically defined as follows:
 * 
 * class MyClass implements Init<MyInterface>, MyInterface { ... }
 * 
 * Alternatively, although this might be considered an inferior programming
 * style, you may write:
 * 
 * class MyClass implements Init<MyClass> { ... }
 * 
 * In general, you may pass as a type parameter anything you can typecast your
 * object to: any superclass along the inheritance chain, or interface
 * implemented by any of these superclasses.
 * 
 * 
 * A class of type (ii) is recognized by the fact that it implements the Cons
 * interface. For example, a factory that can create instances of type MyType is
 * defined as follows:
 * 
 * class MyFactory implements Cons<MyType> { ... }
 * 
 * Additionally, you may want the factory to be initializable as well in which
 * case you should write:
 * 
 * class MyFactory implements Init<Cons<MyType>>, Cons<MyType> { ... }
 * 
 * Although variations on the above line are possible, they are again considered
 * to be inferior programming style.
 * 
 * 
 * @author J. M. Valk (agents@work)
 * 
 * @param <A>
 */
public interface Init<A> {

	/**
	 * Checks whether this object can be initialized. Typically, this method
	 * returns true on objects that are created with the default constructor
	 * (e.g., new MyObject()) and that implement this interface, indicating
	 * those objects are ready to be initialized.
	 * 
	 * A situation where new MyObject().isInitializable() returns false
	 * indicates that the object has already been initialized in the
	 * constructor. Then it must be the case that the isInitialized() method
	 * returns true, because is makes no sense at all to have an object that is
	 * neither initializable nor being initialized already.
	 * 
	 * @return true if and only if object is initializable
	 */
	boolean isInitializable();

	/**
	 * Checks whether this object has been initialized. Typically, if this
	 * method returns true that isInitializable() will return false. However,
	 * this need not always be the case, because some objects can be
	 * re-initialized. Re-initialization completely wipes out the current state
	 * of the object and sets it to the newly configured initial value (see
	 * initialize method for details).
	 * 
	 * @return true if and only if object is initializable
	 */
	boolean isInitialized();

	/**
	 * (Re-)initializes this object. This method is invoked when the object is
	 * supposed to initialize its state according to some initial configuration
	 * specified in XML. This method is invoked exclusively from the init method
	 * of a Cons instance; this init method is responsible for calling
	 * initialize only if isInitializable() evaluates to true. Therefore, it is
	 * guaranteed that initialize will only be called on initializable objects.
	 * 
	 * @param config
	 *            XML config specified as a root element (and its descendants)
	 * @return the object (re-)initialized; typically, the same as this object
	 *         (i.e., obj.initialize(...) == obj), but not necessarily: a new
	 *         object may be returned when convenient (this happens, for
	 *         example, when invoked on objects that are just a factory)
	 */
	A initialize(Element config);
	
}
