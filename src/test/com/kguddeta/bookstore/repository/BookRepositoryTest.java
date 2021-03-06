package com.kguddeta.bookstore.repository;

import com.kguddeta.bookstore.Util.IsbnGenerator;
import com.kguddeta.bookstore.Util.NumberGenerator;
import com.kguddeta.bookstore.Util.TextUtil;
import com.kguddeta.bookstore.model.Book;
import com.kguddeta.bookstore.model.Language;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class BookRepositoryTest {
    @Inject
    private BookRepository bookRepository;

    @Test
    public void create() {
        //Test counting books
        assertEquals(Long.valueOf(0),bookRepository.countAll());
        assertEquals(0,bookRepository.findAll().size());
        Book book = new Book("isbn", "a   title", 12F, 123, Language.ENGLISH, new Date(), "http://image_url", "description");
        book = bookRepository.create(book);
        Long bookId = book.getId();

        //Check created book
        assertNotNull(bookId);

        //Find created book
        Book bookFound = bookRepository.find(bookId);

        //check the found book
        assertEquals("a title",bookFound.getTitle());
        assertTrue(bookFound.getIsbn().startsWith("13"));

        //Test counting books
        assertEquals(Long.valueOf(1),bookRepository.countAll());
        assertEquals(1,bookRepository.findAll().size());

        //Delete the book
        bookRepository.delete(bookId);

        //Test counting books
        assertEquals(Long.valueOf(0),bookRepository.countAll());
        assertEquals(0,bookRepository.findAll().size());

    }

    @Test(expected = Exception.class)
    public void findBookWithInvalidId(){
        bookRepository.find(null);
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(BookRepository.class)
                .addClass(Book.class)
                .addClass(Language.class)
                .addClass(TextUtil.class)
                .addClass(NumberGenerator.class)
                .addClass(IsbnGenerator.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml");
    }

}
