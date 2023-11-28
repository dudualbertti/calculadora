package com.fag.service;

import com.fag.domain.usecases.ListProviders;
import com.fag.infra.celcoin.repository.CelcoinVendorRepository;

public class RechargeService {

    public void listProviders() {

        CelcoinVendorRepository repo = new CelcoinVendorRepository();
        ListProviders listProviders = new ListProviders(repo);

        listProviders.execute();
    }

    public void listProducts() {

    }

    public void createRecharge(){
        
    }
}
