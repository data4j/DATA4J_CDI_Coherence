package org.data4j.exe;

import org.data4j.weld.srv.IWeldContainerService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * This class starts the application
 * 
 * @author data4j.org
 * @since 23 Sept 2013
 * @version 1.0.0
 * 
 */
public class Application {

	/**
	 * Starts the application
	 * 
	 * @param String [] args
	 * 
	 */
	public static void main(String[] args) {
		WeldContainer weldContainer = new Weld().initialize();
		IWeldContainerService weldContainerService = weldContainer.instance().select(IWeldContainerService.class).get();
		weldContainerService.setWeldContainer(weldContainer);
		
		CacheUpdater cacheUpdater = weldContainerService.getWeldContainer().instance().select(CacheUpdater.class).get();
		Thread cacheUpdaterThread = new Thread(cacheUpdater);
		cacheUpdaterThread.start();

	}
}
