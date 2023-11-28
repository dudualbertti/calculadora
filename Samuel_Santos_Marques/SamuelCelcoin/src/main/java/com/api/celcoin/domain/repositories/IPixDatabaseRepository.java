package com.api.celcoin.domain.repositories;

import com.api.celcoin.domain.entities.PixBO;

public interface IPixDatabaseRepository {
    PixBO persist(PixBO pixDTO);
}
