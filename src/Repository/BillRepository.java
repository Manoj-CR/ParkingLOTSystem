package Repository;

import Models.Bill;

import java.util.HashMap;

public class BillRepository {
    private HashMap<Long, Bill> billHashMap;

    public Bill getBill(int id){
        return billHashMap.get(id);
    }

    public Bill saveBill(Bill bill){
        return billHashMap.put(bill.getId(),bill);
    }
}
