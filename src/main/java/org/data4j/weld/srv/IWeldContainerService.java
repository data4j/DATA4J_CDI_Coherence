package org.data4j.weld.srv;

import org.jboss.weld.environment.se.WeldContainer;

/**
 * IWeldContainerService Interface exposes Weld Container functionality.
 * 
 * @author data4j.org
 * @since 23 Sept 2013
 * @version 1.0.0
 *
 */
public interface IWeldContainerService {

	/**
     * Gets WeldContainer
     *
     * @return WeldContainer weldContainer
     */
	WeldContainer getWeldContainer();
	
	/**
     * Sets new WeldContainer
     *
     * @return WeldContainer weldContainer
     */
	void setWeldContainer(WeldContainer weldContainer);
}
