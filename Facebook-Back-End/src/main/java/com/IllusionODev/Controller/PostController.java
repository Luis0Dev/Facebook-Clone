package com.IllusionODev.Controller;

import com.IllusionODev.Service.PostService;
import com.IllusionODev.Model.Post;


import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(value="http://localhost:3001")
@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post addPost(@RequestParam Map<String, String> requestParams) throws Exception {
        String strpost = requestParams.get("post");
        String email = requestParams.get("email");
        String name = requestParams.get("name");
        String file = requestParams.get("file");
        String profilePic = requestParams.get("profilePic");

        Post post = Post.builder()
                .file(file)
                .name(name)
                .post(strpost)
                .profilePic(profilePic)
                .timeStamp(new Date().toString())
                .build();

        post = postService.addPost(post);
        return post;
    }

    @GetMapping
    public List<Post> getPost(){
        return postService.getPost();
    }
}
