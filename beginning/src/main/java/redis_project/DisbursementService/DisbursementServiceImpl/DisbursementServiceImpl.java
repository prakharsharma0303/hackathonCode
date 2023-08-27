package redis_project.DisbursementService.DisbursementServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis_project.ApplicationConstants;
import redis_project.DisbursementService.DisbursementService;
import redis_project.entity.PolicyHolderEntity;
import redis_project.exception.PolicyNotFoundException;
import redis_project.repository.DisbursementRepository;

import java.util.HashMap;

@Service
public class DisbursementServiceImpl implements DisbursementService {

    @Autowired
    private DisbursementRepository disbursementRepository;

    @Override
    public HashMap<String, String> getPolicyDetails(Integer invId) {
        var disbursementMap = new HashMap<String, String>();
        PolicyHolderEntity policyHolderEntity = disbursementRepository.findById(invId)
                .orElseThrow(() -> new PolicyNotFoundException("Policy Details not found"));
        int amountReturned = (int) (policyHolderEntity.getCoveredAmount() / (ApplicationConstants.PERCENT_RETURNED / 100.0f));
        if (ApplicationConstants.DOCUMENT_APPROVED.equals(policyHolderEntity.getDocumentStatus())) {
            disbursementMap.put("documentStatus", ApplicationConstants.DOCUMENT_APPROVED);
            disbursementMap.put("amountToBeReturned", String.valueOf(amountReturned));
        } else if (ApplicationConstants.DOCUMENT_REJECTED.equals(policyHolderEntity.getDocumentStatus())) {
            disbursementMap.put("documentStatus", ApplicationConstants.DOCUMENT_REJECTED);
            disbursementMap.put("amountToBeReturned", "Your claim is rejected. For further details please contact +417123453");
        }
        return disbursementMap;
    }

}
