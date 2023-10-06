package Controller;

import DTO.GenerateBillReqeustDTO;
import DTO.GenerateBillResponseDTO;
import DTO.ReponseStatus;
import Models.Bill;
import ObjectContainer.ObjectContainer;
import Service.BillService;

public class BillController {

    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public GenerateBillResponseDTO generateBill(
            GenerateBillReqeustDTO generateBillReqeustDTO, ObjectContainer objectContainer) {
        GenerateBillResponseDTO generateBillResponseDTO = new GenerateBillResponseDTO();
        try {
            Bill bill = billService.generateBill(generateBillReqeustDTO.getVehicleNumber(),
                    generateBillReqeustDTO.getGateId(), objectContainer);
            generateBillResponseDTO.setBill(bill);
            generateBillResponseDTO.setResponseStatus(ReponseStatus.SUCCESS);
            return generateBillResponseDTO;
        }catch(Exception e){
            System.out.println(e.getMessage());
            generateBillResponseDTO.setResponseStatus(ReponseStatus.FAILURE);
            generateBillResponseDTO.setFailureMessage(e.getMessage());
            throw new RuntimeException();
        }
    }
}
