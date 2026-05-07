package orochi.blogging.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import orochi.blogging.model.Blog;
import orochi.blogging.service.BlogService;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    BlogService blogService;


    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.findAll();
        if (blogs == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/")

}
