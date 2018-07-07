package framework;



import org.hibernate.property.access.spi.Getter;
import org.hibernate.property.access.spi.Setter;

/**
 * 
 * @author rpm shuvo
 *
 */
public class Module {
    private String name;
    private String model;
    private String controller;
    private String view;
    private String map;
/**
 * constructor of {@link Module} {@link Class}
 * @param name
 * @param model
 * @param controller
 * @param view
 * @param map
 */
	public Module(String name,String model, String controller, String view, String map) {
		super();
		this.name = name;
		this.model=model;
		this.controller = controller;
		this.view = view;
		this.map = map;
	}
/**
 * {@link Getter} of {@link Module} {@link Class}
 * @return name as {@link String}
 */
	public String getName() {
		return name;
	}
/**
 * {@link Setter} of {@link Module}
 * @param name as {@link String}
 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * {@link Getter} of {@link Module}
 * @return model as {@link String}
 */
	public String getModel() {
		return model;
	}
	/**
	 * {@link Setter} of {@link Module}
	 * @param model as {@link String}
	 */	
	public void setModel(String model) {
		this.model = model;
	}
/**
 *{@link Getter} of {@link Module} 
 * @return controller as {@link String}
 */
	public String getController() {
		return controller;
	}
/**
 * 	{@link Setter} of {@link Module}
 * @param controller as {@link String}
 */
	public void setController(String controller) {
		this.controller = controller;
	}
/**
 * 	{@link Getter} of {@link Module}
 * @return view as {@link String}
 */
	public String getView() {
		return view;
	}
/**
 * {@link Setter} of {@link Module}
 * @param view as {@link String}
 */
	public void setView(String view) {
		this.view = view;
	}
/**
 * {@link Getter} of {@link Module}	
 * @return map as {@link String}
 */
	public String getMap() {
		return map;
	}
/**
 * 	{@link Setter} of {@link Module}
 * @param map as {@link String}
 */
	public void setMap(String map) {
		this.map = map;
	}
    
    
    
   

}
