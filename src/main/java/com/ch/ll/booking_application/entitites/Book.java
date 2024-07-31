package com.ch.ll.booking_application.entitites;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "Book")
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_sequence"
    )

    private Integer id;
    private String name;
    private Integer pageNumber;
    private Integer menstruation;

    public Book(Integer id, String name, Integer pageNumber ,Integer menstruation) {
        this.id = id;
        this.name = name;
        this.pageNumber = pageNumber;
        this.menstruation = menstruation;


    }
    public Book(){

    }

    public Integer getId() {
        return id;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getMenstruation() {
        return menstruation;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setMenstruation(Integer menstruation) {
        this.menstruation = menstruation;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pageNumber=" + pageNumber +
                ", menstruation=" + menstruation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(pageNumber, book.pageNumber) && Objects.equals(menstruation, book.menstruation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pageNumber, menstruation);
    }
}
