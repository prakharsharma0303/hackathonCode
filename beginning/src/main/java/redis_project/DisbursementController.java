package redis_project;

import redis_project.DisbursementService.DisbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/disbursement")
public class DisbursementController {

    @Autowired
    DisbursementService disbursementService;


    @GetMapping("/getPolicyDetail/{id}")
    public HashMap<String, String> getPolicy(@PathVariable Integer id) {
        return disbursementService.getPolicyDetails(id);
    }

}
