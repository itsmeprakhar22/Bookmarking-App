package com.omnismash.markme;

import com.omnismash.markme.entities.Bookmark;
import com.omnismash.markme.entities.User;
import com.omnismash.markme.managers.BookmarkManager;
import com.omnismash.markme.managers.UserManager;

public class Launch {
	
	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		// TODO Auto-generated method stub
		System.out.println("1. Loading data...");
		DataStore.loadData();
		users = UserManager.getInstance().getUser();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		
//		System.out.println("Printing data...");
//		printUserData();
//		printBookmarkData();
	}

	private static void printUserData() {
		// TODO Auto-generated method stub
		for(User user: users) {
			System.out.println(user);
		}
	}
	
	private static void printBookmarkData() {
		// TODO Auto-generated method stub
		for(Bookmark[] bookmarkList: bookmarks) {
			for(Bookmark bookmark : bookmarkList)
				System.out.println(bookmark);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadData();
		start();
	}

	private static void start() {
		// TODO Auto-generated method stub
		
//		System.out.println("\n2.Bookmarking...");
		for(User user : users) {
			View.browse(user, bookmarks);
		}
	}

}
