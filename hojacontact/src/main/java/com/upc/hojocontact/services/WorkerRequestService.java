package com.upc.hojocontact.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.upc.hojocontact.entities.WorkerRequest;
import org.springframework.stereotype.Service;

@Service
public class WorkerRequestService {
  Logger logger = LoggerFactory.getLogger(getClass());
  private final List<WorkerRequest> arreglo = new ArrayList<WorkerRequest>();
  Random numAleatorio = new Random();

  WorkerRequestService() {
    arreglo.add(new WorkerRequest(numAleatorio.nextInt(999999 - 100000 + 1), "Carlos Guimaraes",
        3494, "1 estrella", 1000,
        "Electricista"));
    arreglo.add(new WorkerRequest(numAleatorio.nextInt(999999 - 100000 + 1), "Juan Montes", 3494, "2 estrellas", 2000,
        "Enchapador"));
    arreglo.add(new WorkerRequest(numAleatorio.nextInt(999999 - 100000 + 1), "Jorge Altamirano",
        3494, "3 estrellas", 3000,
        "Gasfitero"));
    arreglo.add(new WorkerRequest(numAleatorio.nextInt(999999 - 100000 + 1), "David Soto",
        3494, "5 estrellas", 4000,
        "Pintor"));
  }

  public List<WorkerRequest> findAll() {
    return this.arreglo;
  }

  public void createWorkerRequest(WorkerRequest e) {
    e.setIdRequest(numAleatorio.nextInt(999999 - 100000 + 1));
    arreglo.add(e);
    logger.info(e.getUsername() + " Added!");
  }

  public int delete(String id) {
    int idVerified = Integer.parseInt(id);

    List<WorkerRequest> found = this.arreglo.stream()
        .filter(x -> idVerified == x.getIdRequest())
        .collect(Collectors.toList());

    if (found.isEmpty())
      return 0;

    WorkerRequest updateWorkerRequest = found.get(0);
    this.arreglo.remove(updateWorkerRequest);
    return idVerified;
  }

  public int update(WorkerRequest e) {
    List<WorkerRequest> found = this.arreglo.stream().filter(x -> e.getIdRequest() == x.getIdRequest())
        .collect(Collectors.toList());

    // Throws error in case of the user not found
    if (found.isEmpty())
      return 0;

    WorkerRequest updateWorkerRequest = found.get(0);
    updateWorkerRequest.setUsername(e.getUsername());
    updateWorkerRequest.setRemarks(e.getRemarks());
    updateWorkerRequest.setReview(e.getReview());
    updateWorkerRequest.setPrice(e.getPrice());
    updateWorkerRequest.setJob(e.getJob());
    return e.getIdRequest();
  }

}
