package com.example.rest.service;

import com.example.rest.model.Post;
import com.example.rest.repository.PostRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.rest.exception.NotFoundException;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(() ->
                new NotFoundException("Cannot show post :(\nThere is no post with ID " + id));
    }

    public Post save(Post post) {
        return repository.save(post).orElseThrow(() ->
                new NotFoundException("Cannot save post :(\nThere is no post with ID " + post.getId()));
    }

    public void removeById(long id) {
        repository.removeById(id).orElseThrow(() ->
                new NotFoundException("Cannot remove post :(\nThere is no post with ID " + id));
    }
}

