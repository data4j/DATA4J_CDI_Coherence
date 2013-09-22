package org.data4j.user.srv;

import javax.inject.Singleton;

import org.data4j.listener.UserMapListener;
import org.data4j.user.User;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

/**
 * UserCacheService Class is implementation of IUserCacheService Interface.
 * 
 * @author data4j.org
 * @since 23 Sept 2013
 * @version 1.0.0
 *
 */
@Singleton
public class UserCacheService implements IUserCacheService {
	
	private NamedCache userCache = null;
	private static final String USER_MAP = "user-map";
	private static final long LOCK_TIMEOUT = -1;
	
	/**
     * Initializes DefaultCacheManager and creates user-cache instance.
     *
     * @param DefaultCacheManager cacheManager
     *
     */
	public UserCacheService() {
		userCache = CacheFactory.getCache(USER_MAP);
		userCache.addMapListener(new UserMapListener());	
	}
	
	public void addToCache(User user) {
		// key is locked
		getCache().lock(user.getId(), LOCK_TIMEOUT);
		try {
			// application logic
			getCache().put(user.getId(), user);
		} finally {
			// key is unlocked
			getCache().unlock(user.getId());
		}
	}
	
	public void deleteFromCache(Long key) {
		// key is locked
		getCache().lock(key, LOCK_TIMEOUT);
		try {
			// application logic
			getCache().remove(key);
		} finally {
			// key is unlocked
			getCache().unlock(key);
		}
	}	
	
	public NamedCache getCache() {
		return userCache;
	}
			
}
