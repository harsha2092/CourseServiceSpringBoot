package courseapidata.courseapijpadata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService{

    @Autowired
    private TopicRepository topicRepository;

    /*private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring framework", "Spring framework descriptiom"),
            new Topic("Java", "Java framework", "Java framework description"),
            new Topic("javascript", "javascript framework", "javascript framework description")
    ));*/

    public List<Topic> getAllTopics() {

        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
        //return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return  topicRepository.findOne(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
        /*int i = 0;
        for (Topic currTopic : topics) {
            if (currTopic.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
            i++;
        }*/
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
    /*for (int i=0;i<topics.size();i++){
        if(topics.get(i).getId().equals(id)){
            topics.remove(i);
            return;
        }
    }*/
    topicRepository.delete(id);
    }
}
