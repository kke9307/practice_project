package com.menu.plant.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.menu.plant.mapper.PlantMapper;
import com.menu.plant.model.PlantVo;

public class PlantServiceImpl implements PlantService{

	@Autowired
	private PlantMapper plantMapper;
	
	@Override
	public PlantVo selectplantList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return plantMapper.selectplantList(map);
	}

}
