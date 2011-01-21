package nl.agentsatwork.boot;

public interface Initializable<A> {
	
	A init(String xpath);
	
	boolean isInitializable();
	
	boolean isInitialized();
	
}
