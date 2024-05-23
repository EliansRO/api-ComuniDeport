package com.comunideport.rest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comunideport.rest.Service.ISportArenaService;

@RestController
@RequestMapping("/api/sportarena")
public class SportArenaController {

    @Autowired
    private ISportArenaService sportArenaService;

}
