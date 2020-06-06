package com.henry.springstart.bootstrap;

import com.henry.springstart.domain.Author;
import com.henry.springstart.domain.Book;
import com.henry.springstart.domain.Publisher;
import com.henry.springstart.repositories.AuthorRepository;
import com.henry.springstart.repositories.BookRepository;
import com.henry.springstart.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData  implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;



    public BootStrapData(
            AuthorRepository authorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository =publisherRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123455");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);



        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "JohnSon");
        Book noEJ8 = new Book("J2EE Development", "7665353535");
        rod.getBooks().add(noEJ8);
        noEJ8.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJ8);


        Publisher henry = new Publisher("henry", "Kireka-kamuli", "kampala", "state", "256");
        publisherRepository.save(henry);
        ddd.setPublisher(henry);
        henry.getBooks().add(ddd);
        publisherRepository.save(henry);

        noEJ8.setPublisher(henry);
        henry.getBooks().add(noEJ8);
        authorRepository.save(rod);
        bookRepository.save(noEJ8);
        publisherRepository.save(henry);

        System.out.println("Number of Books: "+ bookRepository.count());
        System.out.println("Number of Books: "+ publisherRepository.count());
        System.out.println("Publisher number of books: " + henry.getBooks().size());
    }
}
