/* Created By Oussama MOSSATI -- On October the 10th 2022 */

public class Coordinates {
    private int roverCoordX;
    private int roverCoordY;

    public Coordinates(int roverCoordX, int roverCoordY){
        this.roverCoordX = roverCoordX;
        this.roverCoordY = roverCoordY;
    }

    //Update coordinates
    public Coordinates newCoordinates(int stepSizeX, int stepSizeY){
        return new Coordinates(roverCoordX + stepSizeX, roverCoordY + stepSizeY);
    }

    //Compare a pair of coordinates
    public boolean coordinateWithinBounds(Coordinates coordinates){
        return coordinates.roverCoordX <= this.roverCoordX && coordinates.roverCoordY <= this.roverCoordY;
    }

    @Override
    public String toString() {
        StringBuilder coordinateOutput = new StringBuilder();
        coordinateOutput.append(roverCoordX);
        coordinateOutput.append(" ");
        coordinateOutput.append(roverCoordY);
        return coordinateOutput.toString();
    }
}
