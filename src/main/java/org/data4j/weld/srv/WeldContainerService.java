package org.data4j.weld.srv;

import javax.inject.Singleton;

import org.jboss.weld.environment.se.WeldContainer;

/**
 * WeldContainerService Implementation of IWeldContainerService Interface
 * 
 * @author data4j.org
 * @since 23 Sept 2013
 * @version 1.0.0
 *
 */
@Singleton
public class WeldContainerService implements IWeldContainerService {

	private WeldContainer weldContainer;
	
	public WeldContainer getWeldContainer() {
		return weldContainer;
	}

	public void setWeldContainer(WeldContainer weldContainer) {
		this.weldContainer = weldContainer;
	}
	
}
