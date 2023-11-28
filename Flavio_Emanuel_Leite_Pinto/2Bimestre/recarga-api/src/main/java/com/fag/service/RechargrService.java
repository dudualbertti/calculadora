import com.fag.domain.dto.RechargeDTO;
import com.fag.domain.usecases.CreateRecharge;
import com.fag.domain.usecases.ListOperators;
import com.fag.infra.celcoin.repository.RechargeCelcoin;
import com.fag.infra.panache.model.PanacheDataBaseRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
public package com.fag.service;


@ApplicationScoped

class RechargrService {

    @Inject 
    RechargeCelcoin celcoin;

    @Inject
    PanacheDataBaseRepository panahceRepo;

   public response listOperators(IntegerstateCode, Integer category){
    ListOperators listOperators = new ListOperators(celcoin);
List<OperatorDTO> Operators = listOperators.execute(stateCode, category);
return Response.ok(operators).build();
   }


   public response listProducs(Integer stateCode, Integer operatorId){
    ListOperatorServices ListServices = new ListOperatorServices(celcoin);
    List<listProductDTO> operators = ListServices.execute(stateCode, operatorId);
    return Response.ok(operators).build();
   }


   @Transactional
   public response handleRecharge(rechargeDTO dto){
    CreateRecharge createRecharge = new CreateRecharge(celcoin,panahceRepo);

    RechargeDTO createRecharge = createRecharge.execute(dto);

    return Response.ok(createRecharge).build();
   }
    }
    
    
