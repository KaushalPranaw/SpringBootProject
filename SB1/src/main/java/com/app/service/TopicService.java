package com.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.pojos.Topic;

@Service
public class TopicService {

	private List<Topic> l=new ArrayList<>(Arrays.asList(
			new Topic(1, "a", "a"),
			new Topic(2, "b", "b")));
	
	public List<Topic> getAllTopics()//List return me apne ap json me convert kr deta h bcz of rest controller
	{
		return l;
	}
	
	public Topic getTopicById(int id)
	{
		/*Topic t=l.get(id);
		return t;*/
		
		//or
		
		return l.stream().filter(v->
				v.getId()==id
					).findFirst().get();
		
	}
	
	public void addTopic(Topic topic)
	{
		l.add(topic);
	}

	public void updateTopic(int id, Topic topic) {
		for(int i=0;i<l.size();i++)
		{
			Topic t=l.get(i);
			if(t.getId()==id)
			{
				l.set(i, topic);
				return;
			}
			
		}
		
	}

	public void deleteTopic(int id) {
		// TODO Auto-generated method stub
		l.removeIf(t->t.getId()==id);
	}
}
