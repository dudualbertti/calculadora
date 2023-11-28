package com.api.celcoin.infra.panache.repository;

import com.api.celcoin.domain.entities.PixBO;
import com.api.celcoin.domain.repositories.IPixDatabaseRepository;
import com.api.celcoin.infra.panache.mappers.PanachePixMapper;
import com.api.celcoin.infra.panache.model.PanachePix;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanachePixRepository implements IPixDatabaseRepository {

    @Override
    public PixBO persist(PixBO bo) {
        PanachePix entity = PanachePixMapper.toEntity(bo);

        entity.persistAndFlush();

        return PanachePixMapper.toDomain(entity);
    }

}
