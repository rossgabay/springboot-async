package com.rgabay.jfuture.controller;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import com.rgabay.jfuture.model.HnStory;
import com.rgabay.jfuture.service.HnStoryService;

@RestController
@EnableAutoConfiguration
@EnableAsync
public class JfController {
	private static final Logger log = LoggerFactory.getLogger(JfController.class);

	@Autowired
	HnStoryService hnStoryService;
	
    @RequestMapping("/")
    String home() throws Exception{
    	long start = System.currentTimeMillis();

        Future<HnStory> res1 = hnStoryService.findStory("11559405");
        Future<HnStory> res2 = hnStoryService.findStory("11559811");

        // Wait until they are all done
        while (!(res1.isDone() && res2.isDone())) {
            Thread.sleep(10); //10-millisecond pause between each check
        }

        StringBuilder sb = new StringBuilder();
        log.info("Elapsed time: " + (System.currentTimeMillis() - start)+ ", ");
        sb.append("[");
        sb.append(res1.get() + ",");
        sb.append(res2.get());
        sb.append("]");
        
        return sb.toString();
    }
}

