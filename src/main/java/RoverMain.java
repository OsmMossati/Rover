/* Created By Oussama MOSSATI -- On October the 10th 2022 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RoverMain {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("An input file is required to run this program\n Proper Usage: java -jar rover.jar input.txt");
            System.exit(0);
        }
        String fileName = args[0];
        try {
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);
            //Retrieve the first line of the file containing the size of the plateau (upper-right coordinates)
            String[] plateauSizeCoords = myReader.nextLine().split("\\s");

            Plateau plateau = new Plateau(Integer.parseInt(plateauSizeCoords[0]), Integer.parseInt(plateauSizeCoords[0]));

            while (myReader.hasNextLine()) {
                //Retrieve the rover's position (Coords & Direction)
                String[] data = myReader.nextLine().split("\\s");
                Coordinates coordinates = new Coordinates(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
                Direction direction = Direction.valueOf(data[2]);

                Rover rover = new Rover(plateau, direction, coordinates);

                //Retrieve the series of moves/instructions for the corresponding rover
                String moves = myReader.nextLine();
                for (int i = 0; i < moves.length(); i++) {
                    switch (moves.charAt(i)){
                        case 'L' : rover.turnLeft();
                            break;
                        case 'R' : rover.turnRight();
                            break;
                        case 'M' : rover.move();
                            break;
                    }
                }
                rover.displayCurrentLocation();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
