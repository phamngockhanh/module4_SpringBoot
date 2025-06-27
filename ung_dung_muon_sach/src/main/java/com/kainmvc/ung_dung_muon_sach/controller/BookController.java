package com.kainmvc.ung_dung_muon_sach.controller;

import com.kainmvc.ung_dung_muon_sach.common.CodeGenerator;
import com.kainmvc.ung_dung_muon_sach.entity.Book;
import com.kainmvc.ung_dung_muon_sach.entity.Receipt;
import com.kainmvc.ung_dung_muon_sach.service.IBookService;
import com.kainmvc.ung_dung_muon_sach.service.IReceiptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    private final IBookService iBookService;
    private final IReceiptService iReceiptService;

    public BookController(IBookService iBookService, IReceiptService iReceiptService) {
        this.iBookService = iBookService;
        this.iReceiptService = iReceiptService;
    }

    @GetMapping("")
    public String listBook(Model model) {
        model.addAttribute("books", iBookService.findAll());
        return "book/index";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "book/detail";
    }

    @PostMapping("/borrow")
    public String borrow(@RequestParam("id") Long bookId){
        Book book = iBookService.findById(bookId);
        if(book.getQuantity()<=0){
            return "book/error";
        }
        Optional<Receipt> borrowingReceipt = iReceiptService
                .findUnreturnedReceiptByBookId(bookId);

        if (borrowingReceipt.isPresent()) {
            return "book/borrowed";
        }
        Receipt receipt = new Receipt();
        receipt.setBook(book);
        receipt.setBorrowDate(LocalDate.now());
        receipt.setCode(CodeGenerator.generateCode(5));
        iBookService.borrowBook(book);
        iReceiptService.addOrUpdate(receipt);
        return "redirect:/books";
    }
    @GetMapping("/history")
    public String history(Model model){
        model.addAttribute("receipts",iReceiptService.findAll());
        return "/book/history";
    }


    @GetMapping("/history/{id}/return")
    public String returnBook(@PathVariable Long id, Model model) {
        model.addAttribute("receipt", iReceiptService.findReceiptById(id));
        return "book/return";
    }

    @PostMapping("/history/return")
    public String bookReturn(@RequestParam("id") Long receiptId, @RequestParam("code") String code, RedirectAttributes redirectAttributes){
        Receipt receipt = iReceiptService.findReceiptById(receiptId);
        Book book = receipt.getBook();
        if (!receipt.getCode().equals(code)) {
            redirectAttributes.addFlashAttribute("mess", "Mã mượn sách không đúng!");
            return "redirect:/books/history/" + receiptId + "/return";
        }

        receipt.setReturnDate(LocalDate.now());
        iBookService.returnBook(book);
        iReceiptService.addOrUpdate(receipt);
        return "redirect:/books/history";
    }
}
