package de.thws.fiw.backendsystems.templates.graphql;

import de.thws.fiw.backendsystems.templates.graphql.resolvers.BookMutationResolver;
import de.thws.fiw.backendsystems.templates.graphql.resolvers.BookQueryResolver;
import graphql.kickstart.servlet.GraphQLConfiguration;
import graphql.kickstart.servlet.GraphQLHttpServlet;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import jakarta.servlet.annotation.WebServlet;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

@WebServlet(name="BookServlet", urlPatterns = "/books/*", loadOnStartup = 1)
public class BookServlet extends GraphQLHttpServlet {
    public BookServlet() {
        System.out.println("BookServlet starts");
        System.out.println(this.getClass().getResource("/bookschema.graphqls"));

    }

    @Override
    protected GraphQLConfiguration getConfiguration() {
        return GraphQLConfiguration.with(createSchema()).build();
    }

    private GraphQLSchema createSchema() {
        try {
            final String schemaString = IOUtils.toString(this.getClass().getResourceAsStream("/bookschema.graphqls"));

            return SchemaParser.newParser()
                .schemaString(schemaString)
                .resolvers(new BookQueryResolver(), new BookMutationResolver())
                .build()
                .makeExecutableSchema();
        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
