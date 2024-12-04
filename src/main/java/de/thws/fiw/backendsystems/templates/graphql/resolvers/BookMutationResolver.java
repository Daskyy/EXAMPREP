package de.thws.fiw.backendsystems.templates.graphql.resolvers;

import de.thws.fiw.backendsystems.templates.graphql.models.Author;
import de.thws.fiw.backendsystems.templates.graphql.models.Book;
import de.thws.fiw.backendsystems.templates.graphql.models.BookInput;
import de.thws.fiw.backendsystems.templates.graphql.storage.BookInMemoryStorage;
import graphql.kickstart.tools.GraphQLMutationResolver;

public class BookMutationResolver implements GraphQLMutationResolver {
    public Book create(BookInput bookInput) {
        final Book book = new Book();
        book.setISBN(bookInput.getISBN());
        book.setTitle(bookInput.getTitle());
        Author a = new Author();
        a.setFirstName(bookInput.getFirstNameAuthor());
        a.setLastName(bookInput.getLastNameAuthor());
        book.setAuthor(a);
        book.setGenre(bookInput.getGenre());
        book.setPublicationYear(bookInput.getPublicationYear());

        BookInMemoryStorage.getInstance().create(book);

        return book;
    }

    public Book update(final BookInput bookInput) {
        BookInMemoryStorage storage = BookInMemoryStorage.getInstance();
        Book book = storage.readById(bookInput.getId()).orElseGet(null);

        if (book == null) {
            return null;
        }

        book.setISBN(bookInput.getISBN());
        book.setTitle(bookInput.getTitle());
        Author a = new Author();
        a.setFirstName(bookInput.getFirstNameAuthor());
        a.setLastName(bookInput.getLastNameAuthor());
        book.setAuthor(a);
        book.setGenre(bookInput.getGenre());
        book.setPublicationYear(bookInput.getPublicationYear());

        BookInMemoryStorage.getInstance().update(book);

        return book;
    }

    public Boolean delete(final int id) {
        BookInMemoryStorage storage = BookInMemoryStorage.getInstance();
        if (storage.readById(id).isPresent()) {
            storage.delete(id);
            return true;
        }
        return false;
    }
}
