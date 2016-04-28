package com.pama.common.util;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndImage;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class SyndRssUtil {

	private SyndFeed syndFeeds;

	public void setRssReader(String url) throws IOException, IllegalArgumentException, FeedException {
		if (url.indexOf("http://") < 0) return;

		URL feedUrl = new URL(url);

		SyndFeedInput input = new SyndFeedInput();
		XmlReader xmlReader = new XmlReader(feedUrl);

		if (xmlReader !=null) syndFeeds = input.build(xmlReader);
	}

    public String getFeedType() {
        return syndFeeds.getFeedType();
    }

    public String getTitle() {
        return syndFeeds.getTitle();
    }

    public String getLink() {
        return syndFeeds.getLink();
    }

    public String getDescription() {
        return syndFeeds.getDescription();
    }

    public String getLanguage() {
        return syndFeeds.getLanguage();
    }

    public Date getPublishedDate() {
        return syndFeeds.getPublishedDate();
    }

    public SyndImage getSyndImage() {
        return syndFeeds.getImage();
    }

    public String getImageTitle() {
        return getSyndImage().getTitle();
    }

    public String getImageUrl() {
        return getSyndImage().getUrl();
    }

    public String getImageLink() {
        return getSyndImage().getLink();
    }

    @SuppressWarnings("unchecked")
    public List<SyndEntry> getEntries() {
        if (syndFeeds != null)
            return (List<SyndEntry>) syndFeeds.getEntries();
        else
            return null;
    }

    public SyndEntry getEntry(int i) {
        return getEntries().get(i);
    }
}
