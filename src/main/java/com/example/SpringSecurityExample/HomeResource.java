package com.example.SpringSecurityExample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

//create a resource class, so I need to creat a couple of api`s that can be accessed in order to verify if the authentication is working fine
//so I´m gonna make this rest
@Controller
public class HomeResource {



  //I have three api`s, the first is mapped to the root,
  // and this I intend to be accessible to everybody where there are people have to logged in or not I want this to be publicity accessible

  //@GetMapping("/")
  //public String home() {    return("logIn.html");  }

  @GetMapping("/")
  public String home(){
    return "index";
  }

  @GetMapping("/user")
  public String user() {
    return("<h1>Welcome User</h1>");
  }

  @GetMapping("/admin")
  public String admin() {
    return("<h1>Welcome</h1>");
  }
  }


  //I need to set up the authentication and the authorization part
// spring security is already a part of the classpath because we`ve added it as a dependency but now how do you configure spring security
//--> we do it by creating a class that extends that security configure our adapter --> new class Security Configuration