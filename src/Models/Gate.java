package Models;

public class Gate extends BaseEntity {

    private int gateNumber;

    private Operator operator;

    private GateType gateType;

    private GateStatus gateStatus;

    public Gate(int gateNumber, Operator operator, GateType gateType, GateStatus gateStatus) {
        this.gateNumber = gateNumber;
        this.operator = operator;
        this.gateType = gateType;
        this.gateStatus = gateStatus;
    }

    public Gate() {

    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
