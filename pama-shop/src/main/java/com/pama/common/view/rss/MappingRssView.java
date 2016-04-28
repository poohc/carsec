package com.pama.common.view.rss;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.pama.common.vo.RssChannelVO;
import com.pama.common.vo.RssContentVO;
import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Description;
import com.sun.syndication.feed.rss.Item;

public class MappingRssView extends AbstractRssFeedView {

	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
		HttpServletRequest request) {

		RssChannelVO rssChannelVO = (RssChannelVO)model.get("feedChannel");
		feed.setTitle(rssChannelVO.getTitle());
		feed.setDescription(rssChannelVO.getDescription());
		feed.setLink(rssChannelVO.getLink());
		feed.setLanguage(rssChannelVO.getLanguage());

		super.buildFeedMetadata(model, feed, request);
	}


	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		@SuppressWarnings("unchecked")
		List<RssContentVO> listContent = (List<RssContentVO>) model.get("feedContent");
		List<Item> items = new ArrayList<Item>(listContent.size());

		for(RssContentVO tempContent : listContent ){

			Item item = new Item();

			Content content = new Content();
			content.setValue(tempContent.getSummary());
			item.setContent(content);

			item.setTitle(tempContent.getTitle());
			item.setLink(tempContent.getLink());

			Description description = new Description();
			description.setValue(tempContent.getSummary());
			item.setDescription(description);

			item.setPubDate(tempContent.getCreatedDate());
			item.setAuthor(tempContent.getCreator());
			items.add(item);
		}

		return items;
	}


}
