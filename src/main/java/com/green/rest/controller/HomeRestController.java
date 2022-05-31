package com.green.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.green.user.service.UserService;
import com.green.user.vo.UserVo;


//  @RestController : @Controller + @ResponseBody
@RestController
@RequestMapping("/RestBoard")
public class HomeRestController {
	
	// @RequestMapping("/List")   //  /Board/List
	
	@Autowired
	private   UserService  userService;
	
	// Get : /Board 
	@RequestMapping(method = RequestMethod.GET,
		headers="Accept=application/json"	)
	public  List<UserVo> getList() {
	
		List<UserVo>  list = userService.getUserList();
		return  list;
	
	}
	
	//  Get : /Board/{id}   - /Board/sky
	@RequestMapping(value="/{id}",
		method = RequestMethod.GET,
		headers="Accept=application/json")
	public  UserVo  getUserById(@PathVariable  String  id ) {
		UserVo  vo = userService.getView( id ); 
		return  vo;
	}
	
	// Get : /Board/name/{name}   // http://localhost:9090/Board/name/useruser
	@RequestMapping(value = "/name/{name}"
			,method = RequestMethod.GET,
			headers="Accept=application/json")
	public   List<UserVo>  getUserByName( @PathVariable String  name ) {
		
		List<UserVo> userList = userService.getViewName( name );
		return       userList;
		
	} 
	
}










 