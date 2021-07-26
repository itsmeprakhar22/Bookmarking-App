package com.omnismash.markme.managers;

import com.omnismash.markme.dao.BookmarkDao;
import com.omnismash.markme.entities.Book;
import com.omnismash.markme.entities.Bookmark;
import com.omnismash.markme.entities.Movie;
import com.omnismash.markme.entities.User;
import com.omnismash.markme.entities.UserBookmark;
import com.omnismash.markme.entities.Weblink;

public class BookmarkManager {
	
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao bookmarkDao = new BookmarkDao();
	private BookmarkManager() {}
	
	public static BookmarkManager getInstance() {
		return instance;
	}
	
	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast, String[] directors,String[] genre, double imdbRating) {
		
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setReleaseYear(releaseYear);
		movie.setImdbRating(imdbRating);
		
		return movie;
	}
	
	public Weblink createWeblink(long id, String title, String url, String host) {
		Weblink weblink = new Weblink();
		weblink.setId(id);
		weblink.setHost(host);
		weblink.setUrl(url);
		weblink.setHost(host);
		weblink.setTitle(title);
		return weblink;
	}
	
	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, String genre, double amazonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);
		return book;
	}
	
	public Bookmark[][] getBookmarks(){
		return bookmarkDao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		
		bookmarkDao.saveUserBookmark(userBookmark);
		
	}

}
