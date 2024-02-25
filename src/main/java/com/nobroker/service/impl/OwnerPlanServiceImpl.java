package com.nobroker.service.impl;

import com.nobroker.entity.OwnerPlan;
import com.nobroker.entity.OwnerPlans;
import com.nobroker.payload.OwnerPlanDto;
import com.nobroker.repository.OwnerPlanRepository;
import com.nobroker.repository.OwnerPlansRepo;
import com.nobroker.service.OwnerPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerPlanServiceImpl implements OwnerPlanService {

    @Autowired
  private   OwnerPlansRepo ownerPlansRepo;

    private OwnerPlanRepository ownerPlanRepository;

    private OwnerPlansRepo ownerPlansRepository;

    private ModelMapper modelMapper;

    public OwnerPlanServiceImpl(OwnerPlanRepository ownerPlanRepository,ModelMapper modelMapper) {
        this.ownerPlanRepository = ownerPlanRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OwnerPlanDto createOwnerPlans(OwnerPlanDto ownerPlanDto) {
        OwnerPlan ownerPlan = mapToEntity(ownerPlanDto);
        OwnerPlan savedOwnerPlan = ownerPlanRepository.save(ownerPlan);
        return mapToDto(savedOwnerPlan);
    }

    @Override
    public List<OwnerPlanDto> getAllOwnerPlans() {
        List<OwnerPlan> ownerPlans = ownerPlanRepository.findAll();
        List<OwnerPlanDto> ownerPlanDtos = ownerPlans.stream().map(plan -> mapToDto(plan)).collect(Collectors.toList());
        return ownerPlanDtos;
    }

    OwnerPlan mapToEntity(OwnerPlanDto ownerPlanDto){
        OwnerPlan ownerPlan = modelMapper.map(ownerPlanDto, OwnerPlan.class);
        return  ownerPlan;
    }

    OwnerPlanDto mapToDto(OwnerPlan ownerPlan){

        OwnerPlanDto ownerPlanDto = modelMapper.map(ownerPlan, OwnerPlanDto.class);
        return  ownerPlanDto;
    }
@Override
    public OwnerPlans subscribePlan(long userId, int duration) {
        OwnerPlans ownerPlan=new OwnerPlans();
        ownerPlan.setUserId(userId);
        ownerPlan.setSubscriptionActive(true);
        ownerPlan.setSubscriptionActiveDate(LocalDate.now());
        ownerPlan.setSubscriptionExpirationDate(LocalDate.now().plusDays(duration));
        ownerPlan.setNumberOfDays(duration);
        return ownerPlansRepo.save(ownerPlan);

    }

    @Override
    public boolean checkExpiration(long planId) {
        return false;
    }


}
