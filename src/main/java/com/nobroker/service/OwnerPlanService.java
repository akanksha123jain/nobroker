package com.nobroker.service;

import com.nobroker.entity.OwnerPlans;
import com.nobroker.payload.OwnerPlanDto;

import java.util.List;

public interface OwnerPlanService {
    public OwnerPlanDto createOwnerPlans(OwnerPlanDto ownerPlanDto);

    List<OwnerPlanDto> getAllOwnerPlans();

    OwnerPlans subscribePlan(long userId, int duration);

    boolean checkExpiration(long planId);

}
