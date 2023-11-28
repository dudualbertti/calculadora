package com.fag.joao.infra.protocols;

import com.fag.joao.domain.usecases.IMakePixRequest;

public interface IRepository {
  IRepositoryResponse generate(IMakePixRequest dto);
}
