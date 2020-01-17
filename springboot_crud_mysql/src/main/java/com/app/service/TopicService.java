package com.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.TopicDao;
import com.app.pojos.Topic;

@Service
public class TopicService {

	
	@Autowired
	private TopicDao dao;
	
	 
	
	public List<Topic> getAllTopics()//List return me apne ap json me convert kr deta h bcz of rest controller
	{
		
		//return (ArrayList<Topic>)dao.findAll();
		
		//or
		
		List<Topic> topics=new ArrayList<>();
		dao.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopicById(int id)
	{
		 return dao.findById(id).orElse(null);
		
	}
	
	public void addTopic(Topic topic)
	{
		dao.save(topic);
	}

	public void updateTopic(int id, Topic topic) {
		dao.save(topic);
		
	}

	public void deleteTopic(int id) {
		dao.deleteById(id);
	}
}
