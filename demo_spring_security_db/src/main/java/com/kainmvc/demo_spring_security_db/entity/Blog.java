package com.kainmvc.demo_spring_security_db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishedDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedDate;

    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category ;

    @ManyToOne
    @JoinColumn(name="writer_id")
    private Writer writer;

}
