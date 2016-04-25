package com.rgabay.jfuture.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rgabay.jfuture.model.HnStory;


@Service
public class HnStoryService {
	 RestTemplate restTemplate = new RestTemplate();
	 
	 @Async
	    public Future<HnStory> findStory(String storyId) throws InterruptedException {
	        HnStory results = restTemplate.getForObject("https://hacker-news.firebaseio.com/v0/item/" + storyId + ".json", HnStory.class);
	        // delay 1 sec, just for the demo
	        Thread.sleep(1000L);
	        return new AsyncResult<HnStory>(results);
	    }

}
