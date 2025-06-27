package com.kainmvc.ung_dung_muon_sach.service;

import com.kainmvc.ung_dung_muon_sach.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void addOrUpdate(Book book);
    Book findById(Long id);
    void borrowBook(Book book);
    void returnBook(Book book);
}
