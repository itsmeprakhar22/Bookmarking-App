package com.omnismash.markme.entities;

public class Weblink extends Bookmark{
	private String url;
	private String host;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	@Override
	public String toString() {
		return "Weblink [url=" + url + ", host=" + host + "]";
	}
	@Override
	public boolean isKidfriendly() {
		// TODO Auto-generated method stub
		if(getTitle().contains("porn")
				|| url.contains("porn") || host.contains("adult"))
			return false;
		else 
			return true;
	}
		
}
