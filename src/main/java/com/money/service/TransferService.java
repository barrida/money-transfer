package com.money.service;

import java.math.BigDecimal;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.codahale.metrics.annotation.Timed;
import com.money.dao.impl.AccountDaoImpl;
import com.money.dao.impl.TransferMoney;
import com.money.model.Account;

@Path("/transfer")
@Produces(MediaType.APPLICATION_JSON)

public class TransferService {

	TransferMoney transfer = new TransferMoney();
	AccountDaoImpl accountDao = new AccountDaoImpl();

	@GET
	@Timed
	@Path("/{amount}/from/{from}/to/{to}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccount(@PathParam("from") int senderId, @PathParam("to") int receiverId,
			@PathParam("amount") int amount) throws Exception {
		Account sender = accountDao.getAccountById(senderId);
		Account receiver = accountDao.getAccountById(receiverId);
		if (sender == null | receiver == null) {
			throw new WebApplicationException("Accounts not found", Response.Status.NOT_FOUND);
		}

		int result = transfer.transferMoney(sender, receiver, new BigDecimal(amount));

		if (result != -1) {
			return Response.status(Response.Status.OK).build();
		} else {
			// transaction failed
			throw new WebApplicationException("Transaction failed", Response.Status.BAD_REQUEST);
		}
	}
}
