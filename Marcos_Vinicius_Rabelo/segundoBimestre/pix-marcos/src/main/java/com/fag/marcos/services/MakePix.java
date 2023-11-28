package com.fag.marcos.services;

import com.fag.marcos.domain.usecases.ICreatePix;
import com.fag.marcos.domain.usecases.ICreatePixRequest;
import com.fag.marcos.infra.db.panache.PanachePixCode;
import com.fag.marcos.infra.protocols.IQrCodeSourceResponse;
import com.fag.marcos.infra.repositories.celcoin.CelcoinRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MakePix implements ICreatePix {

  @Inject
  CelcoinRepo source;

  public String perform(ICreatePixRequest request) {
    IQrCodeSourceResponse response = source.generate(request);
    PanachePixCode entity = new PanachePixCode();
    entity.setAmount(request.getValue());
    entity.setEmvqrcps(response.getResponse());
    entity.setTransactionId(response.getTransactionId());
    entity.setKey(request.getChave());
    entity.persistAndFlush();
    return response.getResponse();
  }
}
