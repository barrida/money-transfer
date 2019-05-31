package com.money;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import com.money.dao.impl.AccountDaoImpl;
import com.money.health.check.RestHealthCheck;
import com.money.service.AccountService;
import com.money.service.TransferService;
import com.money.service.UserService;

import com.money.Config;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<Config> {

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public void run(Config config, Environment env) {
		final TransferService transferService = new TransferService();
		env.jersey().register(transferService);

		final AccountService accountService = new AccountService();
		env.jersey().register(accountService);

		final UserService userService = new UserService();
		env.jersey().register(userService);

		env.jersey().register(TransferService.class);
		env.jersey().register(AccountService.class);
		env.jersey().register(UserService.class);

		env.healthChecks().register("template", new RestHealthCheck(config.getVersion()));
	}

	@Override
	public void initialize(Bootstrap<Config> bootstrap) {
		 bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
		            bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));
	}

	// private static void startServer() throws Exception {
	// Server server = new Server(8080);
	// ServletContextHandler context = new
	// ServletContextHandler(ServletContextHandler.SESSIONS);
	// context.setContextPath("/");
	// server.setHandler(context);
	// ServletHolder servletHolder = context.addServlet(ServletContainer.class,
	// "/*");
	// servletHolder.setInitParameter("jersey.config.server.provider.classnames",
	// UserService.class.getCanonicalName()
	// + "," + TransferService.class.getCanonicalName() + "," +
	// AccountService.class.getCanonicalName());
	// server.start();
	//
	// }

}
