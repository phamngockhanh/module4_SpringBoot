package com.kainmvc.demo_spring_security_db.repository;

import com.kainmvc.demo_spring_security_db.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepo extends JpaRepository<Blog,Integer> {
    Page<Blog> findByTitleContaining(String titleName, Pageable pageable);
    @Query(value = "SELECT * FROM blog WHERE " +
            "(title LIKE concat('%',:title,'%')) AND " +
            "(:categoryId IS NULL OR :categoryId=0 or category_id = :categoryId) " , nativeQuery = true)
    Page<Blog> searchByTitleAndCategory(@Param("title") String title, @Param("categoryId") int categoryId, Pageable pageable);
}
