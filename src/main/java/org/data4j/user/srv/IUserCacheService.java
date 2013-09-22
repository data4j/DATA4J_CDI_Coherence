package org.data4j.user.srv;

import org.data4j.user.User;

import com.tangosol.net.NamedCache;

/**
 * IUserCacheService Interface exposes cache functionality.
 * 
 * @author data4j.org
 * @since 23 Sept 2013
 * @version 1.0.0
 *
 */
public interface IUserCacheService {

	/**
     * Adds User entry to cache
     *
     * @param User user
     *
     */
	void addToCache(User user);
	
	/**
     * Removes User entry from cache
     *
     * @param Long key
     *
     */
	void deleteFromCache(Long key);
	
	/**
     * Gets User cache
     *
     * @return Cache<Long, User> cache
     */
	NamedCache getCache();
	
}
