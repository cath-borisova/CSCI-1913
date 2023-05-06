//Katya Borisova
//boris040
class Rectangle extends Polygon {

    public Rectangle(int a, int b) {
        super(4, a, b, a, b);
    }
    public int area(){
        return super.side(0) * super.side(1);
    }
}

class Square extends Rectangle {

    public Square(int a){
        super(a, a);
    }
}
