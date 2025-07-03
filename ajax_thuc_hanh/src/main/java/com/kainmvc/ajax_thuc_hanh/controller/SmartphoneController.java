package com.kainmvc.ajax_thuc_hanh.controller;

import com.kainmvc.ajax_thuc_hanh.model.Smartphone;
import com.kainmvc.ajax_thuc_hanh.service.ISmartphoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/smartphones")
public class SmartphoneController {
    private final ISmartphoneService iSmartphoneService;


    public SmartphoneController(ISmartphoneService iSmartphoneService) {
        this.iSmartphoneService = iSmartphoneService;
    }

    @GetMapping
    public ResponseEntity<List<Smartphone>> findAll(){
        List<Smartphone> smartphoneList = (List<Smartphone>) iSmartphoneService.findAll();
        if(smartphoneList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphoneList,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(iSmartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> save(@PathVariable Long id, @RequestBody Smartphone smartphone){
        Optional<Smartphone>  smartphoneOptional = iSmartphoneService.findById(id);
        if (smartphoneOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphone.setId(smartphoneOptional.get().getId());
        return new ResponseEntity<>(iSmartphoneService.save(smartphone), HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> delete(@PathVariable Long id){
        Optional<Smartphone> smartphoneOptional = iSmartphoneService.findById(id);
        if(smartphoneOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iSmartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(),HttpStatus.NO_CONTENT);
    }
}
