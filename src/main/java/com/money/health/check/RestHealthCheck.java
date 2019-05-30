package com.money.health.check;

import com.codahale.metrics.health.HealthCheck;
import com.money.dao.impl.AccountDaoImpl;
import com.money.dao.impl.UserDaoImpl;
import com.money.model.Account;

/**
 * Self-test that the application performs to verify that a REST service
 * component is performing correctly
 * 
 * @author suleyman.yildirim
 *
 */
public class RestHealthCheck extends HealthCheck {
	private final String version;
	AccountDaoImpl account = new AccountDaoImpl();
	UserDaoImpl user = new UserDaoImpl();

	public RestHealthCheck(String version) {
		this.version = version;
	}

	@Override
	protected Result check() throws Exception {
		if (account.getTotalAccountSize() == 0 || user.getTotalUserSize() == 0) {
			return Result.unhealthy("No account and user found in databasen: " + this.version);
		}
		return Result.healthy("OK with version: " + this.version + ". Account count: " + account.getTotalAccountSize()
				+ ". User count: " + user.getTotalUserSize());
	}

}