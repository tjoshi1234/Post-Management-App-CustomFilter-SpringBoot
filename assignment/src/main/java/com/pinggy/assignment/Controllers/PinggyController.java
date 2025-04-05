package com.pinggy.assignment.Controllers;

import com.pinggy.assignment.ServiceImpl.PinggyServiceImpl;
import com.pinggy.assignment.Utility.AuthContext;
import com.pinggy.assignment.Utility.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PinggyController {

    @Autowired
    PinggyServiceImpl pinggyService;

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody PostDto post){

        System.out.println(post.getPinggyAuthHeader());

        pinggyService.savePost(post);
        return new ResponseEntity<String>("Information stored successfully",HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return new ResponseEntity<List<PostDto>>(pinggyService.getAllPosts(), HttpStatus.OK);
    }
}
