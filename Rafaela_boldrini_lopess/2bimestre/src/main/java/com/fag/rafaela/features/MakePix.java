package com.fag.rafaela.features;

import com.fag.rafaela.domain.usecases.IPixRequest;
import com.fag.rafaela.domain.usecases.IPixService;
import com.fag.rafaela.infra.impl.celcoin.Celcoin;
import com.fag.rafaela.infra.panache.PanachePixCode;
import com.fag.rafaela.infra.protocols.IQrCodeProviderResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MakePix implements IPixService {

  @Inject
  Celcoin source;

  public String exec(IPixRequest request) {
    IQrCodeProviderResponse response = source.generate(request);
    PanachePixCode entity = new PanachePixCode();
    entity.setAmount(request.getValue());
    entity.setEmvqrcps(response.getResponse());
    entity.setTransactionId(response.getTransactionId());
    entity.setKey(request.getChavePix());
    entity.persistAndFlush();
    return response.getResponse();
  }
}
