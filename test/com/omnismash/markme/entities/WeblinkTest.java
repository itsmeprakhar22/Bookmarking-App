package com.omnismash.markme.entities;


import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.omnismash.markme.managers.BookmarkManager;

class WeblinkTest {

	@Test
	void testIsKidfriendly() {
		//Test 1: porn in url -- false
		Weblink weblink = BookmarkManager.getInstance()
				.createWeblink(2000,"Taming Tiger, Part 2", "http://www.javaworld.com/article/porn/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		boolean isKidFriendly = weblink.isKidfriendly();
		assertFalse("For porn in url, isKidFriendly() must return false", isKidFriendly);
		
		//Test 2: porn in title -- false
		weblink = BookmarkManager.getInstance()
				.createWeblink(2000,"porn, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		isKidFriendly = weblink.isKidfriendly();
		assertFalse("For porn in title, isKidFriendly() must return false", isKidFriendly);
		
		//Test 3: adult in host -- false
		weblink = BookmarkManager.getInstance()
				.createWeblink(2000,"Taming, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","adult");
		isKidFriendly = weblink.isKidfriendly();
		assertFalse("For adult in host, isKidFriendly() must return false", isKidFriendly);
		
		//Test 4: adult in url but not in host -- true
		weblink = BookmarkManager.getInstance()
				.createWeblink(2000,"Taming, Part 2", "http://www.javawadultorld.com/article/2072759/core-java/taming-tiger--part-2.html","java");
		isKidFriendly = weblink.isKidfriendly();
		assertTrue("For adult in url, not host, isKidFriendly() must return true", isKidFriendly);
		
		//Test 5: adult in title only -- true
		weblink = BookmarkManager.getInstance()
				.createWeblink(2000,"Adult and, Part 2", "http://www.javawadultorld.com/article/2072759/core-java/taming-tiger--part-2.html","java");
		isKidFriendly = weblink.isKidfriendly();
		assertTrue("For adult in title only, not host, isKidFriendly() must return true", isKidFriendly);
		
	}

}
