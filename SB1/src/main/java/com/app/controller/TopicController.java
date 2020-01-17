package com.app.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Topic;
import com.app.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired  //for DI
	private TopicService service;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics()//List return me apne ap json me convert kr deta h bcz of rest controller
	{
		return  service.getAllTopics();
	}
	
	@RequestMapping("/topics/{id1}")
	public Topic getTopicById(@PathVariable("id1") int id)
	{
		return service.getTopicById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		service.addTopic(topic);
		 
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable int id)
	{
		service.updateTopic(id,topic);
		 
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable int id)
	{
		service.deleteTopic(id);
		 
	}
}
