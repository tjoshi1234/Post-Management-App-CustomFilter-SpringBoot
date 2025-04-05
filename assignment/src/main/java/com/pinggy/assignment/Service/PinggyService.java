package com.pinggy.assignment.Service;

import com.pinggy.assignment.Utility.PostDto;

import java.util.List;

public interface PinggyService {

    public void savePost(PostDto post);
    public List<PostDto> getAllPosts();
}
