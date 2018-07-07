
package framework;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *@version 1.0
 */
public class ContextListener implements ServletContextListener {

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    
    /**
     * this Method dynamically do registered a servlet which is get from a xml file
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	DomParser parser=new DomParser();
          for(Module module : parser.getDomList()) {
        	  ServletRegistration.Dynamic tmp = event.getServletContext().addServlet(module.getName(), module.getController());
        	  tmp.addMapping(module.getMap());
        	  tmp.setLoadOnStartup(1);
        	  tmp.setAsyncSupported(false);
          }
          
    }
	
}
