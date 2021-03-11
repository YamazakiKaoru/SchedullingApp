package com.example.Schedulle.common.schedulle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulleRepository extends JpaRepository<SchedulleEntity, Integer> {

	//月指定のSQL
	List<SchedulleEntity> findByMonthValue(Integer monthValue);

	//月と日数指定のSQL
	List<SchedulleEntity> findByMonthValueAndDate(Integer monthValue,Integer date);
}
