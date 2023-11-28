package com.fag.rafaela.infra.impl.celcoin;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fag.rafaela.domain.usecases.IPixRequest;
import com.fag.rafaela.infra.protocols.IQrCodeProvider;
import com.fag.rafaela.infra.protocols.IQrCodeProviderResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Celcoin implements IQrCodeProvider {

  @Inject
  @RestClient
  CelcoinRestClient restClient;

  public IQrCodeProviderResponse generate(IPixRequest dto) {
    TokenResponse token = restClient.getCelcoinToken(new TokenRequest());
    CelcoinResponse response = restClient.generateQrCode(
      new CelcoinRequest(dto.getChavePix(), dto.getValue(), "testqrcodestaticcelcoin", new CelcoinMerchant("85344450", "cascavel", 0, "brendho"), List.of(""), "Teeste fag", false),
      token.getAccessToken()
    );
    return new IQrCodeProviderResponse(response.getEmvqrcps(), response.getTransactionId());
  }
}
