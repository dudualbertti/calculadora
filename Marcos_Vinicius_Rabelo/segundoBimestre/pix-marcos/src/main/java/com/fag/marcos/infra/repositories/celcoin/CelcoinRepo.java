package com.fag.marcos.infra.repositories.celcoin;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fag.marcos.domain.usecases.ICreatePixRequest;
import com.fag.marcos.infra.protocols.IQrCodeSource;
import com.fag.marcos.infra.protocols.IQrCodeSourceResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CelcoinRepo implements IQrCodeSource {

  @Inject
  @RestClient
  CelcoinRestClient restClient;

  public IQrCodeSourceResponse generate(ICreatePixRequest dto) {
    CelcoinTokenRes token = restClient.getCelcoinToken(new CelcoinTokenReq());
    CelcoinRes response = restClient.generateQrCode(
      new CelcoinReq(dto.getChave(), dto.getValue(), "testqrcodestaticcelcoin", new CelcoinMerchant("85344450", "cascavel", 0, "brendho"), List.of(""), "Teeste fag", false),
      token.getAccessToken()
    );
    return new IQrCodeSourceResponse(response.getEmvqrcps(), response.getTransactionId());
  }
}
