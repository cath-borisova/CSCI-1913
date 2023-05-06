//Katya Borisova
//boris040

class Map <Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int count;

    public Map(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be less than 0");
        } else {
            keys = (Key[]) new Object[length];
            values = (Value[]) new Object[length];
        }
            //use array object and then cast

    }

    public Value get(Key key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null || keys[i] == null) {
                if (key == keys[i]) {
                    return values[i];
                }
            } else if (key.equals(keys[i])) {
                return values[i];
            }
        }
        throw new IllegalArgumentException("key is not in keys");
    }

    private boolean isEqual(Key leftKey, Key rightKey) {
        if (leftKey == null || rightKey == null) {
            return leftKey == rightKey;
        } else {
            return leftKey.equals(rightKey);
        }
    }

    public boolean isIn(Key key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null || keys[i] == null) {
              if(key == keys[i]){
                  return true;
              }
            } else if (key.equals(keys[i])){
               return true;
            }
        }
        return false;
    }

    public void put(Key key, Value value){
        if(isIn(key)) {
            for (int i = 0; i < keys.length; i++) {
                if (key == null || keys[i] == null) {
                    if (key == keys[i]) {
                        values[i] = value;
                    }
                } else if (key.equals(keys[i])) {
                    values[i] = value;
                }
            }
        } else {
            if (count < keys.length){
                for(int i = 0; i<keys.length; i++){
                    if(keys[i] == null){
                        keys[i] = key;
                        values[i] = value;
                        break;
                    }
                    count++;
                }
            } else{
                throw new IllegalStateException("keys and values are full");
            }
        }
    }
    private int where(Key key){
        for (int i = 0; i < keys.length; i++) {
            if (key == null || keys[i] == null) {
                if (key == keys[i]) {
                    return i;
                }
            } else if (key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

}
