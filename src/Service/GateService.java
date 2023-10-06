package Service;

import Models.Gate;
import ObjectContainer.ObjectContainer;
import Repository.GateRepository;

public class GateService {
    private GateRepository gateRepository;

    public GateService(ObjectContainer objectContainer) {

        this.gateRepository = new GateRepository(objectContainer);
        objectContainer.registerObject("gateRepository",gateRepository);
    }

    public Gate getGate(long gateId) {
        return gateRepository.getGate(gateId);
    }
}
