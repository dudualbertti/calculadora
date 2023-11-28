package com.fag.joao.infra.impl.celcoin;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fag.joao.domain.usecases.IMakePixRequest;
import com.fag.joao.infra.protocols.IRepository;
import com.fag.joao.infra.protocols.IRepositoryResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CelcoinProvider implements IRepository {

  @Inject
  @RestClient
  CelcoinRestClient restClient;

  public IRepositoryResponse generate(IMakePixRequest dto) {
    CelcoinTokenResponse token = restClient.getCelcoinToken(new CelcoinTokenRequest());
    CelcoinResponse response = restClient.generateQrCode(
      new CelcoinRequest(dto.getChave(), dto.getValue(), "testqrcodestaticcelcoin", new CelcoinMerchant("85344450", "cascavel", 0, "brendho"), List.of(""), "joao teste", false),
      token.getAccessToken()
    );
    return new IRepositoryResponse(response.getEmvqrcps(), response.getTransactionId());
  }
}
