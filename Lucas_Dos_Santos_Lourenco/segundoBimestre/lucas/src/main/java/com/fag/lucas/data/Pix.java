package com.fag.lucas.data;

import com.fag.lucas.domain.usecases.IPixService;
import com.fag.lucas.domain.usecases.IPixServiceRequest;
import com.fag.lucas.infra.contracts.IQrCodeRepositoryResponse;
import com.fag.lucas.infra.panache.PanachePixCode;
import com.fag.lucas.infra.repositories.celcoin.CelcoinRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Pix implements IPixService {

  @Inject
  CelcoinRepo source;

  public String perform(IPixServiceRequest request) {
    IQrCodeRepositoryResponse res = source.generate(request);
    PanachePixCode entity = new PanachePixCode();
    entity.setAmount(request.getValue());
    entity.setEmvqrcps(res.getResponse());
    entity.setTransactionId(res.getTransactionId());
    entity.setKey(request.getChave());
    entity.persistAndFlush();
    return res.getResponse();
  }
}
