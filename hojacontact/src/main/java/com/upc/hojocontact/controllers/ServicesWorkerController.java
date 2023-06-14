package com.upc.hojocontact.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upc.hojocontact.entities.WorkerRequest;
import com.upc.hojocontact.services.WorkerRequestService;

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
public class ServicesWorkerController {
  Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  WorkerRequestService wr;

  @GetMapping(value = "/workers")
  public List<WorkerRequest> getAllWorkerRequest() {
    return wr.findAll();
  }

  @PostMapping(value = "/workers")
  public String createWorkerRequest(@RequestBody WorkerRequest e) {
    logger.info(e.toString());
    wr.createWorkerRequest(e);
    return "Añadido";
  }

  @DeleteMapping(value = "/workers")
  public int deleteWorkerRequest(@RequestParam String id) {
    return wr.delete(id);
  }

  @PutMapping(value = "/workers")
  public int updateWorkerRequest(@RequestBody WorkerRequest e) {
    return wr.update(e);
  }
}
