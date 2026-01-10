package com.example.demo.userstory;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stories")
public class UserStoryController {

    private final UserStoryService service;

    public UserStoryController(UserStoryService service) {
        this.service = service;
    }

    // CREATE user story
    @PreAuthorize("hasRole('PO')")
    @PostMapping
    public UserStory create(@RequestBody UserStory story) {
        return service.create(story);
    }

    // SET priority
    @PreAuthorize("hasRole('PO')")
    @PutMapping("/{id}/priority")
    public UserStory setPriority(
            @PathVariable Long id,
            @RequestParam int priority
    ) {
        return service.setPriority(id, priority);
    }
}
