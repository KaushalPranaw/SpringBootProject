package com.app.demo.contoller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.pojos.Topic;
import com.app.demo.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService service;

	@RequestMapping("/topics")
	public List<Topic> getAllTopic()
	{
		return service.getAllTopics();
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return service.getTopic(id);
	}
	
	//@RequestMapping(method=RequestMethod.POST,value="/topics")
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		service.addTopic(topic);
	}
}
