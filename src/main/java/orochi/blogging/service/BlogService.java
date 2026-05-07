package orochi.blogging.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import orochi.blogging.model.Blog;
import orochi.blogging.repository.BlogRepository;

import java.util.List;

@Data
@AllArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

}
