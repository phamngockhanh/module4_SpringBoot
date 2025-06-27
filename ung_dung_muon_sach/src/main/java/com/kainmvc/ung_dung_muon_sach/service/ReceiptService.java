package com.kainmvc.ung_dung_muon_sach.service;

import com.kainmvc.ung_dung_muon_sach.common.CodeGenerator;
import com.kainmvc.ung_dung_muon_sach.entity.Receipt;
import com.kainmvc.ung_dung_muon_sach.repository.IReceiptRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService implements IReceiptService{

    private final IReceiptRepo iReceiptRepo;

    public ReceiptService(IReceiptRepo iReceiptRepo) {
        this.iReceiptRepo = iReceiptRepo;
    }

    @Override
    public List<Receipt> findAll() {
       return iReceiptRepo.findAll();
    }

    @Override
    public void addOrUpdate(Receipt receipt) {
        iReceiptRepo.save(receipt);
    }

    @Override
    public Optional<Receipt> findUnreturnedReceiptByBookId(Long id) {
        return iReceiptRepo.findUnreturnedReceiptByBookId(id);
    }

    @Override
    public Receipt findReceiptById(Long id) {
        return iReceiptRepo.findReceiptById(id);
    }


}
