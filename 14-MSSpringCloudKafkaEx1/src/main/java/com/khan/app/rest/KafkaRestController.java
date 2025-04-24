package com.khan.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khan.app.dto.JsonUtil;
import com.khan.app.entity.StkInfo;
import com.khan.app.repo.StkInfoRepo;
import com.khan.app.service.ProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaRestController {

	@Autowired
	private ProducerService producerService;
	@Autowired
	private StkInfoRepo stkInfoRepo;
	@GetMapping("/send")
	public String readMsg(@RequestParam String code, @RequestParam Double cost)
	{
		StkInfo stk= new StkInfo();
		stk.setStkCode(code);
		stk.setStkCost(cost);
		String msg =JsonUtil.convertToString(stk);
		producerService.sendMsg(msg);
		return "SENT";
		
	}
	@GetMapping("/fetch")
	public List<StkInfo>getAllMsg()
	{
		
		return stkInfoRepo.findAll();
		
	}
}
