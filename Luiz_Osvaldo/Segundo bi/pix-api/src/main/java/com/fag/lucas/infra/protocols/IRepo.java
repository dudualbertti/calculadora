package com.fag.lucas.infra.protocols;

import com.fag.lucas.domain.usecases.IMakePixRequest;

public interface IRepo {
  IRepoResponse generate(IMakePixRequest dto);
}
