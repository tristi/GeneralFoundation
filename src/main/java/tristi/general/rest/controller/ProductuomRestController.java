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

import tristi.general.bean.Productuom;
import tristi.general.business.service.ProductuomService;
import tristi.general.web.listitem.ProductuomListItem;

/**
 * Spring MVC controller for 'Productuom' management.
 */
@Controller
public class ProductuomRestController {

	@Resource
	private ProductuomService productuomService;
	
	@RequestMapping( value="/items/productuom",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ProductuomListItem> findAllAsListItems() {
		List<Productuom> list = productuomService.findAll();
		List<ProductuomListItem> items = new LinkedList<ProductuomListItem>();
		for ( Productuom productuom : list ) {
			items.add(new ProductuomListItem( productuom ) );
		}
		return items;
	}
	
	@RequestMapping( value="/productuom",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Productuom> findAll() {
		return productuomService.findAll();
	}

	@RequestMapping( value="/productuom/{productuomid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Productuom findOne(@PathVariable("productuomid") String productuomid) {
		return productuomService.findById(productuomid);
	}
	
	@RequestMapping( value="/productuom",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Productuom create(@RequestBody Productuom productuom) {
		return productuomService.create(productuom);
	}

	@RequestMapping( value="/productuom/{productuomid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Productuom update(@PathVariable("productuomid") String productuomid, @RequestBody Productuom productuom) {
		return productuomService.update(productuom);
	}

	@RequestMapping( value="/productuom/{productuomid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("productuomid") String productuomid) {
		productuomService.delete(productuomid);
	}
	
}