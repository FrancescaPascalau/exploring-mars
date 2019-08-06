/**
 * This class contains the start point of the program.
 * It also contains a static method called from main to get the input string and return the desired result.
 */
public class RoverControl {

    public static void main(String[] args) {

        String nasaInstructions = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
        String output = roverControlOnMars(nasaInstructions);
        System.out.println(output);
    }

    /**
     * This is a static method that doesn't need an object to be called.
     * The input string inserted is split into a string array by the space between the characters.
     *
     * @param nasaInstructions The input string inserted by NASA that specified the plateau size and the rover/s
     *                         instructions.
     * @return It returns the output string that contains the final position of the rover after exploration.
     */
    public static String roverControlOnMars(String nasaInstructions) {
        String[] inputs = nasaInstructions.split(" ");

        /**
         * The first two strings from input stand for the upper-right corner of the plateau.
         * It checks if the values inserted are integers, otherwise it throws BadCoordinatesException.
         */
        Position plateauPosition;
        try {
            plateauPosition = new Position(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        } catch (NumberFormatException e) {
            throw new BadCoordinatesException("Expected integer values for the plateau's position. Retype position " +
                    "values from input!");
        }

        Plateau plateauMars = new Plateau(plateauPosition);
        String output = "";

        int i = 2;
        while (i < inputs.length) {
            /**
             * Creates the roverPosition by assuring that the position values are positive integers.
             * It also checks if the input for the rover/s contains the position, the cardinal point and the
             * instructions.
             */
            Position roverPosition;
            try {
                try {
                    roverPosition = new Position(Integer.parseInt(inputs[i]), Integer.parseInt(inputs[i + 1]));
                } catch (NumberFormatException e) {
                    throw new BadCoordinatesException("Expected integer values for the rover's position. Retype " +
                            "position values from input!");
                }

                Rover rover = new Rover(roverPosition, Coordinates.valueOf(inputs[i + 2]), plateauMars);
                rover.exploringMars(inputs[i + 3], plateauMars);

                i = i + 4;

                output += rover.toString();
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new BadInstructionException("Missing instructions for rover. Please tell the rover how to " +
                        "explore the plateau");
            }
        }
        return output.trim();
    }
}