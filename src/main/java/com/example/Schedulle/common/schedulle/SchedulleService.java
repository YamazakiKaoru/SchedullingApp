package com.example.Schedulle.common.schedulle;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulleService {

	@Autowired
	SchedulleRepository schedulleRepository;


	@Transactional
	public void insert(SchedulleEntity schedulleEntity) {
		schedulleRepository.save(schedulleEntity);
	}

	@Transactional
	public List<SchedulleEntity> findAllByMonthValue(Integer month){
		List<SchedulleEntity> list =schedulleRepository.findByMonthValue(month);
		return list;
	}

	public List<SchedulleEntity> findAllByMonthValueAndDate(Integer month,Integer date){
		List<SchedulleEntity> list = schedulleRepository.findByMonthValueAndDate(month, date);
		return list;
	}


}
