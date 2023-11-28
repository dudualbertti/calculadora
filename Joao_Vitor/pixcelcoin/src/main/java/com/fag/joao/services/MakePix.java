package com.fag.joao.services;

import com.fag.joao.domain.usecases.IMakePixRequest;
import com.fag.joao.infra.impl.celcoin.CelcoinProvider;
import com.fag.joao.infra.panache.PanachePixCode;
import com.fag.joao.infra.protocols.IRepositoryResponse;
import com.fag.joao.domain.usecases.IMakePix;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MakePix implements IMakePix {

  @Inject
  CelcoinProvider source;

  public String getQrCode(IMakePixRequest request) {
    IRepositoryResponse response = source.generate(request);
    PanachePixCode entity = new PanachePixCode();
    entity.setAmount(request.getValue());
    entity.setEmvqrcps(response.getResponse());
    entity.setTransactionId(response.getTransactionId());
    entity.setKey(request.getChave());
    entity.persistAndFlush();
    return response.getResponse();
  }
}
