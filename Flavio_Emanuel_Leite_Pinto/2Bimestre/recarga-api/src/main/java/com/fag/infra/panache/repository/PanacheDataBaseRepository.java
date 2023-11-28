package com.fag.infra.panache.repository;

import com.fag.domain.entities.RechargeBO;
import com.fag.infra.panache.mappers.PanacheRechargeMapper;
import com.fag.infra.panache.model.PanacheRecharge;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheDataBaseRepository implements IRechargeDataBaseRepository {
    @Override
    public RechargeBO persist(RechargeBO bo) {
        PanacheRecharge entity = PanacheRechargeMapper.toEntity(bo);
        entity.persistflush();
        return PanacheRechargeMapper.toDomain(entity);
    }
}
