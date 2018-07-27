package io.javabrains.springbootstarter.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring", "Spring Framework", "SpringFramework description"),
			new Topic("Java", " Java Framework", "Java Framework description"),
			new Topic("JavaScript", " JavaScript Framework", "JavaScript Framework description")
			));
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;	
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(e -> e.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
		//return null;
	}
}
