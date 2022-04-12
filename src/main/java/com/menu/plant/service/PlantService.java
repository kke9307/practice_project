package com.menu.plant.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.menu.plant.model.PlantVo;

@Service
public interface PlantService {

	public PlantVo selectplantList(Map<String,Object> map); 

}
