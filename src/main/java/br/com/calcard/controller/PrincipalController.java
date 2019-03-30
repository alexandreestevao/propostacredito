package br.com.calcard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PrincipalController {

    @GetMapping("/principal")
    public String principal() {
        return "Principal";
    }

}