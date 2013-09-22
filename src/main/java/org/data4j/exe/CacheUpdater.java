package org.data4j.exe;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.log4j.Logger;
import org.data4j.user.User;
import org.data4j.user.srv.IUserCacheService;
import org.data4j.weld.srv.IWeldContainerService;

/**
 * CacheUpdater Class updates cache and logs entries...
 * 
 * @author data4j.org
 * @since 23 Sept 2013
 * @version 1.0.0
 *
 */
@Singleton
public class CacheUpdater implements Runnable {
	
	private static Logger log = Logger.getLogger(CacheUpdater.class);
	
	@Inject
	private IWeldContainerService weldContainerService;
	
	@Inject
	private IUserCacheService userCacheService;
	
	/**
     * Adds entries to the cache and logs entries...
     *
     */
	public void run() {		
		//New Users are created for the first member of the cluster...
		User firstUser = createUser();
		firstUser.setId(1L);
		firstUser.setName("Bruce");
		firstUser.setSurname("Willis");
		
		User secondUser = createUser();
		secondUser.setId(2L);
		secondUser.setName("Clint");
		secondUser.setSurname("Eastwood");
		
		//First Entry is added to user-cache...
		userCacheService.addToCache(firstUser);
		
		//Second Entry is added to user-cache...
		userCacheService.addToCache(secondUser);

		//Cache Entries are printed...
		printCacheEntries();		
	}
	
	/**
     * Prints entries of user-cache...
     *
     */
	@SuppressWarnings("unchecked")
	private void printCacheEntries() {
		Collection<User> userCollection = null;
		try {
			while(true) {
				userCollection = (Collection<User>)userCacheService.getCache().values();
				for(User user : userCollection) {
					log.debug("User Cache Content on first Member : " + user);
				}
				Thread.sleep(30_000);			
			}
		} catch (InterruptedException e) {
			log.debug(e);
		}
	}
	
	/**
     * Provides new user object via CDI container...
     *
     * @return User user
     */
	private User createUser() {
		return weldContainerService.getWeldContainer().instance().select(User.class).get();
	}
		
}
