package ObjectContainer;

import java.util.HashMap;
import java.util.Map;

public class ObjectContainer {

    Map<String,Object> objectMap=new HashMap<>();

    public ObjectContainer() {
        this.objectMap = objectMap;
    }

    public void registerObject(String key, Object object){
        objectMap.put(key,object);
    }
    public Object getObject(String key){
        return objectMap.get(key);
    }
}
