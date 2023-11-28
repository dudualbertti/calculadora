package com.fag.lucas.data;

import com.fag.lucas.domain.usecases.IMakePix;
import com.fag.lucas.domain.usecases.IMakePixRequest;
import com.fag.lucas.infra.panache.PanachePixCode;
import com.fag.lucas.infra.protocols.IRepoResponse;
import com.fag.lucas.infra.providers.celcoin.CelcoinProvider;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MakePix implements IMakePix {

  @Inject
  CelcoinProvider source;

  public String getQrCode(IMakePixRequest request) {
    IRepoResponse response = source.generate(request);
    PanachePixCode entity = new PanachePixCode();
    entity.setAmount(request.getValue());
    entity.setEmvqrcps(response.getResponse());
    entity.setTransactionId(response.getTransactionId());
    entity.setKey(request.getChave());
    entity.persistAndFlush();
    return response.getResponse();
  }
}
