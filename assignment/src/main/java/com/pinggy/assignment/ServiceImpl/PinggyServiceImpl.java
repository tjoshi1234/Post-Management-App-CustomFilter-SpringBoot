package com.pinggy.assignment.ServiceImpl;

import com.pinggy.assignment.Service.PinggyService;
import com.pinggy.assignment.Utility.AuthContext;
import com.pinggy.assignment.Utility.PostDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PinggyServiceImpl implements PinggyService {

    private static List<PostDto> posts = new ArrayList<PostDto>();

    @Override
    public void savePost(PostDto post) {

        String PinggyAuthHeader = AuthContext.getAuthHeader();
        posts.add(post);
        return;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return posts;
    }

}
