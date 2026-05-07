package orochi.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import orochi.blogging.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Blog findById(int id);
    void deleteById(int id);
}
