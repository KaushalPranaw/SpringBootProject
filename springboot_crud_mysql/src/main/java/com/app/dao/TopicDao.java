package com.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.pojos.Topic;

public interface TopicDao extends CrudRepository<Topic, Integer> {

}
