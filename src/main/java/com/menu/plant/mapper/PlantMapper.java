package com.menu.plant.mapper;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.menu.plant.model.PlantVo;

@Service
public interface PlantMapper {

	public PlantVo selectplantList(Map<String,Object> map); 

}
