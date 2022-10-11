/* Created By Oussama MOSSATI -- On October the 10th 2022 */

public class Rover {
    private Plateau plateau;
    private Direction currentDirection;     //N, W, S or E (enumerations)
    private Coordinates currentCoordinates;

    public Rover(Plateau plateau, Direction currentDirection, Coordinates currentCoordinates){
        this.plateau = plateau;
        this.currentDirection = currentDirection;
        this.currentCoordinates = currentCoordinates;
    }

    public void displayCurrentLocation(){
        System.out.println(currentCoordinates.toString() + " " + currentDirection.toString());
    }

    public void turnRight(){
        currentDirection = currentDirection.right();
    }

    public void turnLeft(){
        currentDirection = currentDirection.left();
    }

    public void move(){
        //Calculate the new coordinates depending on the current direction of the rover (Ex: N(0,1))
        Coordinates coordinatesAfterMove = currentCoordinates.newCoordinates(currentDirection.getStepSizeX(), currentDirection.getStepSizeY());

        //Check if the result coordinates of the next move are within the plateau borders before applying the changes
        if(plateau.isWithinPlateauBounds(coordinatesAfterMove))
            currentCoordinates = coordinatesAfterMove;
    }
}
