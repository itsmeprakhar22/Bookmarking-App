package com.omnismash.markme.controllers;

import com.omnismash.markme.entities.Bookmark;
import com.omnismash.markme.entities.User;
import com.omnismash.markme.managers.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController() {}
	
	public static BookmarkController getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
		
	}
}
