package de.thws.fiw.backendsystems.templates.graphql.storage;

import com.github.javafaker.Faker;
import de.thws.fiw.backendsystems.templates.graphql.models.Author;
import de.thws.fiw.backendsystems.templates.graphql.models.Book;

public class BookInMemoryStorage extends AbstractInMemoryStorage<Book> {
    private static BookInMemoryStorage INSTANCE;

    public static final BookInMemoryStorage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BookInMemoryStorage();
        }
        return INSTANCE;
    }

    public void populateDatabase() {
        final Faker faker = new Faker();

        for (int i=0; i<100; i++) {
            Book book = new Book();
            book.setISBN(faker.code().isbn10());
            book.setTitle(faker.book().title());
            Author a = new Author();
            a.setFirstName(faker.name().firstName());
            a.setLastName(faker.name().lastName());
            book.setAuthor(a);
            book.setGenre(faker.book().genre());
            book.setPublicationYear(faker.number().numberBetween(1900, 2021));
            create(book);
        }
    }
}
