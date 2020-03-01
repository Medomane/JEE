package org.bank.Controller;

import org.bank.Repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {
    final
    OperationRepository operations ;

    public OperationController(OperationRepository operations) {
        this.operations = operations;
    }




}
