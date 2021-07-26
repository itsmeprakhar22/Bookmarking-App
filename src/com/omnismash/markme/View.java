package com.omnismash.markme;

import com.omnismash.markme.constants.KidFriendlyStatus;
import com.omnismash.markme.constants.UserType;
import com.omnismash.markme.controllers.BookmarkController;
import com.omnismash.markme.entities.Bookmark;
import com.omnismash.markme.entities.User;

public class View {
//	public static void bookmark(User user, Bookmark[][] bookmarks) {
//		System.out.println("\n" + user.getEmail() + " is bookmarking ");
//		for(int i=0;i<DataStore.USER_BOOKMARK_LIMIT;i++) {
//			int typeOffset = (int)(Math.random()*DataStore.BOOKMARK_TYPES_COUNT);
//			int bookmarkOffset = (int)(Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE);
//			
//			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
//			
//			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
//			
//			System.out.println(bookmark);
//		}
//	}
	
	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing ");
		int bookmarkCount = 0;
		
		for(Bookmark[] bookmarkList : bookmarks) {
			for(Bookmark bookmark : bookmarkList) {
				//Bookmarking
				if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if(isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						
						System.out.println("New Item -- " + bookmark);

						//Mark kid friendly
						if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
							if(bookmark.isKidfriendly() && (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN))){
								String isKidFriendlyStatus = getKidfriendlyStatusDecision(bookmark);
								if(!isKidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
									System.out.println("Kid status " + isKidFriendlyStatus + " " + bookmark);
								}
							}
						}
					}
				}
			}
		}
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		// TODO Auto-generated method stub
		return (Math.random() < 0.5) ? true : false;
	}
	
	private static String getKidfriendlyStatusDecision(Bookmark bookmark) {
		// TODO Auto-generated method stub
		return (Math.random() < 0.5) ? (Math.random() >0.7 ? KidFriendlyStatus.APPROVED : KidFriendlyStatus.REJECTED) : KidFriendlyStatus.UNKNOWN;
	}
}
