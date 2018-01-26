package courseapidata.courseapijpadata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /*private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring framework", "Spring framework descriptiom"),
            new Topic("Java", "Java framework", "Java framework description"),
            new Topic("javascript", "javascript framework", "javascript framework description")
    ));*/

    public List<Course> getAllCourses(String topicId) {

        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id) {
        //return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return  courseRepository.findOne(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        /*int i = 0;
        for (Topic currTopic : topics) {
            if (currTopic.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
            i++;
        }*/
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
    /*for (int i=0;i<topics.size();i++){
        if(topics.get(i).getId().equals(id)){
            topics.remove(i);
            return;
        }
    }*/
    courseRepository.delete(id);
    }
}
