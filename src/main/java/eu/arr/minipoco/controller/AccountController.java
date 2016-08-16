package eu.arr.minipoco.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.arr.minipoco.model.Account;
import eu.arr.minipoco.service.AccountService;

@RestController
@RequestMapping("/account/*")
public class AccountController {
	private static final Logger log = LogManager.getLogger(AccountController.class);
    
    @Autowired
    AccountService accountService;

	@RequestMapping(value="create", method=RequestMethod.POST)
    public Account create(@RequestBody Account account) {
        log.info("Creating tables");
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
          	
        return accountService.insertAccount(account);
    }
	
	@RequestMapping(value="get", method=RequestMethod.GET)
    public Account get(@RequestParam(value="iban") String iban) {        
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		
		System.out.println(accountService.getAccount(iban).toString());
        return accountService.getAccount(iban);
    } 
}
