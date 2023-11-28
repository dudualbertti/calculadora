package com.fag.marcos.infra.protocols;

import com.fag.marcos.domain.usecases.ICreatePixRequest;

public interface IQrCodeSource {
  IQrCodeSourceResponse generate(ICreatePixRequest dto);
}
