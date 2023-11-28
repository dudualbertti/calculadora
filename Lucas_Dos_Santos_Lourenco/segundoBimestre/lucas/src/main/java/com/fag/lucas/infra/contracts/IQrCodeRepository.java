package com.fag.lucas.infra.contracts;

import com.fag.lucas.domain.usecases.IPixServiceRequest;

public interface IQrCodeRepository {
  IQrCodeRepositoryResponse generate(IPixServiceRequest dto);
}
