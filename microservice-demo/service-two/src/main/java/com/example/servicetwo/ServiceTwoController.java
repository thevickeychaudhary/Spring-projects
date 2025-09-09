package com.example.servicetwo;

import java.time.LocalTime;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class ServiceTwoController {
//    @GetMapping("/")
//    public String home() {
//        return "Hello from service-two!";
//    }
//}

@RestController
@RequestMapping("/wish-api")
public class ServiceTwoController {

//	@Value("${spring.application.instance-id}")
//private String instance_id;

	// Rest Operation /Endpoint
	@GetMapping("/show")
  public ResponseEntity<String> findHour()
  {
	  //get local time
		
	  LocalTime idt = LocalTime.now() ;
	  
	  int hour = idt.getHour();
	  String DayHonour = null;
	  if(hour>=4  && hour<=11)
	   DayHonour = "Good Morning";
	  
	  else if(hour>=12 && hour<=3)
		  DayHonour = "Good afternoon";
	  else if (hour>=4 && hour<=8)
		  DayHonour = "Good Evening";
	  else 
		  DayHonour = "Good Night";
	  
	  return new ResponseEntity<String>(DayHonour,HttpStatus.OK);
	  
  }
}