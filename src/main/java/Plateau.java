/* Created By Oussama MOSSATI -- On October the 10th 2022 */

public class Plateau {
    //Specify the borders of the plateau
    private Coordinates upperRightCoordinates;
    private Coordinates bottomLeftCoordinates;

    public Plateau(final int upperRightCoordinateX, final int upperRightCoordinateY){
        this.upperRightCoordinates = new Coordinates(upperRightCoordinateX, upperRightCoordinateY);
        this.bottomLeftCoordinates = new Coordinates(0,0);
    }

    //Test if coordinates are between the given size of the plateau (between upper-right & bottom-left)
    //Used in the move() method to determine if the result coordinates of the next move are within the plateau borders
    public boolean isWithinPlateauBounds(Coordinates coordinates){
        return upperRightCoordinates.coordinateWithinBounds(coordinates) && coordinates.coordinateWithinBounds(bottomLeftCoordinates);
    }
}
