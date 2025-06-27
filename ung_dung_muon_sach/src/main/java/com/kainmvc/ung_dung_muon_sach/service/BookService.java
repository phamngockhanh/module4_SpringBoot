package com.kainmvc.ung_dung_muon_sach.service;

import com.kainmvc.ung_dung_muon_sach.entity.Book;
import com.kainmvc.ung_dung_muon_sach.repository.IBookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService{
    private final IBookRepo iBookRepo;

    public BookService(IBookRepo iBookRepo) {
        this.iBookRepo = iBookRepo;
    }

    @Override
    public List<Book> findAll() {
        return iBookRepo.findAll();
    }

    @Override
    public void addOrUpdate(Book book) {
        iBookRepo.save(book);
    }


    @Override
    public Book findById(Long id) {
        return iBookRepo.findBooksById(id);
    }

    @Override
    public void borrowBook(Book book) {
        book.setQuantity(book.getQuantity()-1);
        iBookRepo.save(book);
    }

    @Override
    public void returnBook(Book book) {
        book.setQuantity(book.getQuantity()+1);
        iBookRepo.save(book);
    }
}
