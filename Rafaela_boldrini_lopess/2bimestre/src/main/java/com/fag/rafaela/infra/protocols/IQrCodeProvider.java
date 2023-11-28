package com.fag.rafaela.infra.protocols;

import com.fag.rafaela.domain.usecases.IPixRequest;

public interface IQrCodeProvider {
  IQrCodeProviderResponse generate(IPixRequest dto);
}
