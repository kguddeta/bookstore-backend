package com.kguddeta.bookstore.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(length = 50)
    @Size(min=1, max = 50)
    private String isbn;

    @Column(length = 200)
    private String title;

    @Column(name = "unit_cost")
   @Min(1)
    private Float unitCost;

    @Column(name = "nb_of_pages")
    private Integer nbOfPages;

    @Enumerated
    private Language language;

    @Column(name = "publication_date")
    @Past
    private Date publicationDate;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(length = 1000)
    @Size(min=1,max=1000)
    private String description;

    public Book(){
    }
    public Book(String isbn, String title, Float unitCost, Integer nbOfPages, Language language, Date publicationDate, String imageUrl, String description) {
        this.isbn = isbn;
        this.title = title;
        this.unitCost = unitCost;
        this.nbOfPages = nbOfPages;
        this.language = language;
        this.publicationDate = publicationDate;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    public Integer getNbOfPages() {
        return nbOfPages;
    }

    public void setNbOfPages(Integer nbOfPages) {
        this.nbOfPages = nbOfPages;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", unitCost=" + unitCost +
                ", nbOfPages=" + nbOfPages +
                ", language=" + language +
                ", publicationDate=" + publicationDate +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
