package orochi.blogging.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import orochi.blogging.model.Blog;
import orochi.blogging.service.BlogService;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.findAll();
        if (blogs == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null || blog.getId() != id)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(blog);
    }

    @PostMapping()
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.save(blog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable int id) {
        blogService.delete(id);
        return ResponseEntity.noContent().build();
    }

     @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id,@RequestBody Blog blog) {
         Blog existingBlog = blogService.findById(id);
         if (existingBlog == null || existingBlog.getId() != id)
             return ResponseEntity.notFound().build();
         existingBlog.setTitle(blog.getTitle());
         existingBlog.setContent(blog.getContent());
         existingBlog.setCategory(blog.getCategory());
         existingBlog.setTags(blog.getTags());
         return ResponseEntity.ok(blogService.save(existingBlog));
     }

}
