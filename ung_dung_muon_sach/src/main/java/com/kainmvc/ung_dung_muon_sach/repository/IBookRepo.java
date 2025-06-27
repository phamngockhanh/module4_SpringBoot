package com.kainmvc.ung_dung_muon_sach.repository;

import com.kainmvc.ung_dung_muon_sach.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepo extends JpaRepository<Book,Long> {
     Book findBooksById(Long id);
}
