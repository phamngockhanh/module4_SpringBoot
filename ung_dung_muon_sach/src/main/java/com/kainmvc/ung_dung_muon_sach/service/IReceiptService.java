package com.kainmvc.ung_dung_muon_sach.service;

import com.kainmvc.ung_dung_muon_sach.entity.Book;
import com.kainmvc.ung_dung_muon_sach.entity.Receipt;

import java.util.List;
import java.util.Optional;

public interface IReceiptService {
    List<Receipt> findAll();
    void addOrUpdate(Receipt receipt);
    Optional<Receipt> findUnreturnedReceiptByBookId(Long id);
    Receipt findReceiptById(Long id);
}
