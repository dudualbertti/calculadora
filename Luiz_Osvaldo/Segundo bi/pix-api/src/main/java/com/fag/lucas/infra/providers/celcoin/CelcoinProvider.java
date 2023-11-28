package com.fag.lucas.infra.providers.celcoin;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fag.lucas.domain.usecases.IMakePixRequest;
import com.fag.lucas.infra.protocols.IRepo;
import com.fag.lucas.infra.protocols.IRepoResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CelcoinProvider implements IRepo {

  @Inject
  @RestClient
  CelcoinRestClient restClient;

  public IRepoResponse generate(IMakePixRequest dto) {
    CelcoinTokenResponse token = restClient.getCelcoinToken(new CelcoinTokenRequest());
    CelcoinResponse response = restClient.generateQrCode(
      new CelcoinRequest(dto.getChave(), dto.getValue(), "testqrcodestaticcelcoin", new CelcoinMerchant("85344450", "cascavel", 0, "brendho"), List.of(""), "joao teste", false),
      token.getAccessToken()
    );
    return new IRepoResponse(response.getEmvqrcps(), response.getTransactionId());
  }
}
