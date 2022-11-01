    import java.awt.*;

    public class Square extends Component {


    public int CoordX;
    public int CoordY;


    public final int square_width = 20;
    public final int square_height = 20;


    Color color;

    public Square(int CoordX, int CoordY,Color color){

        this.CoordX = CoordX;
        this.CoordY = CoordY;
        this.color = color;



    }

        public int getCoordX() {
            return CoordX;
        }

        public int getCoordY() {
            return CoordY;
        }

        public boolean intersect (Square s1) {

    return this.CoordX == s1.CoordX && this.CoordY == s1.CoordY ;

}

        @Override
        public String toString() {
            return "X: "+this.CoordX +" Y: "+ this.CoordY + this.color;
        }
    }
