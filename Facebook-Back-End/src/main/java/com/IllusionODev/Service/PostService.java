package com.IllusionODev.Service;

import com.IllusionODev.Model.Post;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface PostService {
    Post addPost(Post post) throws Exception;

    List<Post> getPost();
}
