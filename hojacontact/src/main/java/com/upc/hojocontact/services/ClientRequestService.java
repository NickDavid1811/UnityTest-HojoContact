package com.upc.hojocontact.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.upc.hojocontact.entities.ClientRequest;
import org.springframework.stereotype.Service;

@Service
public class ClientRequestService {
  Logger logger = LoggerFactory.getLogger(getClass());
  private final List<ClientRequest> arreglo = new ArrayList<ClientRequest>();
  Random numAleatorio = new Random();

  ClientRequestService() {
    arreglo.add(new ClientRequest(numAleatorio.nextInt(999999 - 100000 + 1), "Jorge Cortez", "Pinto pared", "Surco",
        "930 393 993"));
    arreglo.add(
        new ClientRequest(numAleatorio.nextInt(999999 - 100000 + 1), "Juan Montes", "Enchapo pisos", "Surco",
            "930 393 993"));
    arreglo.add(
        new ClientRequest(numAleatorio.nextInt(999999 - 100000 + 1), "Carlos Guimaraes", "Instalo sistema Electrico",
            "Surco",
            "930 393 993"));
  }

  public List<ClientRequest> findAll() {
    return this.arreglo;
  }

  public void createClientRequest(ClientRequest e) {
    e.setIdRequest(numAleatorio.nextInt(999999 - 100000 + 1));
    arreglo.add(e);
    logger.info(e.getUsername() + " Added!");
  }

  public int delete(String id) {
    int idVerified = Integer.parseInt(id);

    List<ClientRequest> found = this.arreglo.stream()
        .filter(x -> idVerified == x.getIdRequest())
        .collect(Collectors.toList());

    if (found.isEmpty())
      return 0;

    ClientRequest updateClientRequest = found.get(0);
    this.arreglo.remove(updateClientRequest);
    return idVerified;
  }

  public int update(ClientRequest e) {
    List<ClientRequest> found = this.arreglo.stream().filter(x -> e.getIdRequest() == x.getIdRequest())
        .collect(Collectors.toList());

    // Throws error in case of the user not found
    if (found.isEmpty())
      return 0;

    ClientRequest updateClientRequest = found.get(0);
    updateClientRequest.setUsername(e.getUsername());
    updateClientRequest.setRequestDescription(e.getRequestDescription());
    updateClientRequest.setLocation(e.getLocation());
    updateClientRequest.setPhoneNumber(e.getPhoneNumber());
    return e.getIdRequest();
  }
}
