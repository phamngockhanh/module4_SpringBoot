package com.kainmvc.blog_ajax.repository;

import com.kainmvc.blog_ajax.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
    @Query(value = "SELECT * FROM blog WHERE " +
            "(name LIKE concat('%',:title,'%')) AND " +
            "(:categoryId IS NULL OR :categoryId=0 or category_id = :categoryId) " , nativeQuery = true)
    Page<Blog> searchByTitleAndCategory(@Param("title") String title, @Param("categoryId") int categoryId, Pageable pageable);
}
