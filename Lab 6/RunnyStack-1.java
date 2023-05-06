//Katya Borisova
//boris040
class RunnyStack <Base> {

    private class Run {
        private Base base;
        private Run next;
        private int length;
        private Run(Base base, Run next, int length){
            this.base = base;
            this.next = next;
            this.length = length;
        }
    }
    private Run top;
    public int runs;
    public int depth;
    public RunnyStack(){
        runs= 0;
        depth=0;
        top = null;
    }
    public int depth(){

        return depth;
    }
    public boolean isEmpty(){

        return top == null;
    }
    public Base peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack cannot be empty.");
        } else {
            return top.base;
        }
    }
    public void pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack cannot be empty.");
        } else {
            depth--;
            if(top.length<=1) {
                top = top.next;
                runs--;

            } else {
                top.length--;
            }
       }

    }
    public void push(Base base){
        if(isEmpty()){
            top = new Run(base, top, 1);
            runs++;
        } else {
            if(base== null || top.base == null){
               if(base == top.base){
                   top.length++;
               } else {
                   top = new Run(base, top, 1);
                   runs++;
               }
            } else if (base.equals(top.base)){
                top.length++;
            } else {
                top = new Run(base, top, 1);
                runs++;

            }
        }
        depth++;
    }
    public int runs(){

        return runs;
    }


}
