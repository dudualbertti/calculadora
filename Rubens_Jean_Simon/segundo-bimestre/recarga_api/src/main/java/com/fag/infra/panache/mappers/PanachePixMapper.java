package main.java.com.fag.infra.panache.mappers;

import main.com.fag.infra.panache.model.PanachePixCode;
import main.com.fag.domain.entities.PixBO;

public class PanachePixMapper {
  public static PixBO toDomain(PanachePixCode entity) {

    return new PixBO(entity.getId(), entity.getKey(), entity.getAmount(), entity.getEmvqrcps(), entity.getTransactionId());
  }

  public static PanachePixCode toEntity(PixBO bo) {
    PanachePixCode entity = new PanachePixCode();
    entity.setId(bo.getId());
    entity.setKey(bo.getKey());
    entity.setTransactionId(bo.getTransactionId());
    entity.setEmvqrcps(bo.getQrCode());
    entity.setAmount(bo.getAmount());

    return entity;
  }

}