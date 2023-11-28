package com.api.celcoin.domain.repositories;

import com.api.celcoin.domain.dto.PixDTO;

public interface IPixVendorRepository {
    PixDTO create(PixDTO pix);
}
