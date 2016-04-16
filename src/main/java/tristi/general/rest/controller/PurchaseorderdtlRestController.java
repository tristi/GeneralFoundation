/*
 * Created on 6 Dec 2015 ( Time 04:13:34 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.rest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import tristi.general.bean.Purchaseorderdtl;
import tristi.general.business.service.PurchaseorderdtlService;
import tristi.general.web.listitem.PurchaseorderdtlListItem;

/**
 * Spring MVC controller for 'Purchaseorderdtl' management.
 */
@Controller
public class PurchaseorderdtlRestController {

	@Resource
	private PurchaseorderdtlService purchaseorderdtlService;
	
	@RequestMapping( value="/items/purchaseorderdtl",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<PurchaseorderdtlListItem> findAllAsListItems() {
		List<Purchaseorderdtl> list = purchaseorderdtlService.findAll();
		List<PurchaseorderdtlListItem> items = new LinkedList<PurchaseorderdtlListItem>();
		for ( Purchaseorderdtl purchaseorderdtl : list ) {
			items.add(new PurchaseorderdtlListItem( purchaseorderdtl ) );
		}
		return items;
	}
	
	@RequestMapping( value="/purchaseorderdtl",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Purchaseorderdtl> findAll() {
		return purchaseorderdtlService.findAll();
	}

	@RequestMapping( value="/purchaseorderdtl/{purchaseorderdtlid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Purchaseorderdtl findOne(@PathVariable("purchaseorderdtlid") String purchaseorderdtlid) {
		return purchaseorderdtlService.findById(purchaseorderdtlid);
	}
	
	@RequestMapping( value="/purchaseorderdtl",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Purchaseorderdtl create(@RequestBody Purchaseorderdtl purchaseorderdtl) {
		return purchaseorderdtlService.create(purchaseorderdtl);
	}

	@RequestMapping( value="/purchaseorderdtl/{purchaseorderdtlid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Purchaseorderdtl update(@PathVariable("purchaseorderdtlid") String purchaseorderdtlid, @RequestBody Purchaseorderdtl purchaseorderdtl) {
		return purchaseorderdtlService.update(purchaseorderdtl);
	}

	@RequestMapping( value="/purchaseorderdtl/{purchaseorderdtlid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("purchaseorderdtlid") String purchaseorderdtlid) {
		purchaseorderdtlService.delete(purchaseorderdtlid);
	}
	
}