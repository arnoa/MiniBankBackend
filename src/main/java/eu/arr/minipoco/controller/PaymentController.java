package eu.arr.minipoco.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.arr.minipoco.model.Payment;
import eu.arr.minipoco.service.PaymentService;

@RestController
@RequestMapping("/payment/*")
public class PaymentController {
	private static final Logger log = LogManager.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value="make", method=RequestMethod.POST)
    public Payment create(@RequestBody Payment payment) throws Exception {
        log.info("Creating tables");     
    	
        return paymentService.makePayment(payment);
    }
}
