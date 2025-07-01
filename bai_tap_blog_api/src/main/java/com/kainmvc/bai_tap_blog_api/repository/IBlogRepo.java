package com.kainmvc.bai_tap_blog_api.repository;

import com.kainmvc.bai_tap_blog_api.entity.Blog;
import com.kainmvc.bai_tap_blog_api.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepo extends JpaRepository<Blog,Integer> {
    Page<Blog> findByTitleContaining(String titleName, Pageable pageable);

    List<Blog> findBlogByCategory(Category category);
    @Query(value = "SELECT * FROM blog WHERE " +
            "(title LIKE concat('%',:title,'%')) AND " +
            "(:categoryId IS NULL OR :categoryId=0 or category_id = :categoryId) " , nativeQuery = true)
    Page<Blog> searchByTitleAndCategory(@Param("title") String title, @Param("categoryId") int categoryId, Pageable pageable);

    @Query(value = "SELECT * FROM blog WHERE " +
            "(:categoryId IS NULL OR :categoryId=0 or category_id = :categoryId) " , nativeQuery = true)
    Page<Blog> searchByCategory( @Param("categoryId") int categoryId, Pageable pageable);
}
