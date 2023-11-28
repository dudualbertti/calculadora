package com.fag.lucas.infra.repositories.celcoin;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fag.lucas.domain.usecases.IPixServiceRequest;
import com.fag.lucas.infra.contracts.IQrCodeRepository;
import com.fag.lucas.infra.contracts.IQrCodeRepositoryResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CelcoinRepo implements IQrCodeRepository {

  @Inject
  @RestClient
  CelcoinRestClient restClient;

  public IQrCodeRepositoryResponse generate(IPixServiceRequest dto) {
    CelcoinTokenResponse token = restClient.getCelcoinToken(new CelcoinTokenRequest());
    CelcoinResponse response = restClient.generateQrCode(
      new CelcoinParams(dto.getChave(), dto.getValue(), "testqrcodestaticcelcoin", new CelcoinMerchant("85344450", "cascavel", 0, "brendho"), List.of(""), "Teeste fag", false),
      token.getAccessToken()
    );
    return new IQrCodeRepositoryResponse(response.getEmvqrcps(), response.getTransactionId());
  }
}
