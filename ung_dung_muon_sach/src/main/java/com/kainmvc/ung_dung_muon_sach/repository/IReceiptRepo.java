package com.kainmvc.ung_dung_muon_sach.repository;

import com.kainmvc.ung_dung_muon_sach.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IReceiptRepo extends JpaRepository<Receipt,Long> {
    @Query(value="SELECT * FROM receipt  WHERE book_id = :bookId AND return_date IS NULL", nativeQuery = true)
    Optional<Receipt> findUnreturnedReceiptByBookId(@Param("bookId") Long bookId);

    Receipt findReceiptById(Long id);
}
