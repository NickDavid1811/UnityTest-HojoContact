package com.upc.hojocontact.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upc.hojocontact.entities.ClientRequest;
import com.upc.hojocontact.services.ClientRequestService;

import jakarta.websocket.server.PathParam;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicesClientController {
  Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  ClientRequestService cr;

  @GetMapping(value = "/clients")
  public List<ClientRequest> getAllClientRequest() {
    return cr.findAll();
  }

  @PostMapping(value = "/clients")
  public String createClientRequest(@RequestBody ClientRequest e) {
    logger.info(e.toString());
    cr.createClientRequest(e);
    return "Añadido";
  }

  @DeleteMapping(value = "/clients")
  public int deleteClientRequest(@RequestParam String id) {
    return cr.delete(id);
  }

  @PutMapping(value = "/clients")
  public int updateClientRequest(@RequestBody ClientRequest e) {
    return cr.update(e);
  }
}
