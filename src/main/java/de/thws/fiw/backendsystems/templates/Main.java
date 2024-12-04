package de.thws.fiw.backendsystems.templates;

import de.thws.fiw.backendsystems.templates.graphql.BookServlet;
import de.thws.fiw.backendsystems.templates.graphql.DemoServlet;
import de.thws.fiw.backendsystems.templates.graphql.storage.BookInMemoryStorage;
import de.thws.fiw.backendsystems.templates.graphql.storage.PersonInMemoryStorage;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;

public class Main
{
	public static void main( String[] args ) throws Exception
	{
		Server server = new Server( 8080 );

		ServletContextHandler context = new ServletContextHandler( ServletContextHandler.SESSIONS );
		context.setContextPath( "/" );
		server.setHandler( context );

		//context.addServlet( new ServletHolder( new HelloServlet( ) ), "/filldatabase" );
		PersonInMemoryStorage.getInstance().populateDatabase();
		BookInMemoryStorage.getInstance().populateDatabase();
		context.addServlet( new ServletHolder(new DemoServlet()), "/graphql" );
		context.addServlet( new ServletHolder(new BookServlet()), "/books" );


		server.start( );
		server.join( );
	}
}
