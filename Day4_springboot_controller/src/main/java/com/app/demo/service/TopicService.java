package com.app.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.demo.pojos.Topic;

@Service
public class TopicService {

	private List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic("1", "a", "a"),
			new Topic("2", "b", "b"),
			new Topic("3", "c", "c")
			));
	
	public List<Topic> getAllTopics()
	{
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		topics.add(topic);
	}
	
}
