package de.thws.fiw.backendsystems.templates.graphql.resolvers;

import de.thws.fiw.backendsystems.templates.graphql.models.Book;
import de.thws.fiw.backendsystems.templates.graphql.storage.BookInMemoryStorage;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;

public class BookQueryResolver implements GraphQLQueryResolver {
    public Book book(final int id) {
        return BookInMemoryStorage.getInstance().readById(id).orElseGet(null);
    }

    public List<Book> books() {
        return BookInMemoryStorage.getInstance().readByPredicate(p -> true);
    }

    public List<Book> bookById(final int id) {
        return BookInMemoryStorage.getInstance().readByPredicate(p -> p.getId() == id);
    }
}
