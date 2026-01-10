package com.example.demo.userstory;

import org.springframework.stereotype.Service;

@Service
public class UserStoryService {

    private final UserStoryRepository repository;

    public UserStoryService(UserStoryRepository repository) {
        this.repository = repository;
    }

    public UserStory create(UserStory story) {
        story.setStatus(UserStory.Status.BACKLOG);
        return repository.save(story);
    }

    public UserStory setPriority(Long id, int priority) {
        UserStory story = repository.findById(id).orElseThrow();
        story.setPriority(priority);
        return repository.save(story);
    }
}
