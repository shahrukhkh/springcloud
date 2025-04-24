package com.khan.app.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khan.app.dto.JsonUtil;
import com.khan.app.entity.StkInfo;
import com.khan.app.repo.StkInfoRepo;

@Component
public class MessageStore {

	@Autowired
	private StkInfoRepo stkInfoRepo;

	public void add(String msg) {

		StkInfo si = JsonUtil.convertToObject(msg);
		stkInfoRepo.save(si);
	}

}
