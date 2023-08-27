package redis_project.DisbursementService;

import java.util.HashMap;

public interface DisbursementService {

    HashMap<String, String> getPolicyDetails(Integer invId);
}
