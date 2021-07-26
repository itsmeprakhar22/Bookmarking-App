package com.omnismash.markme.dao;

import com.omnismash.markme.DataStore;
import com.omnismash.markme.entities.Bookmark;
import com.omnismash.markme.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks(){
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
		
	}
}
