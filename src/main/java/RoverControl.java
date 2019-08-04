public class RoverControl {

    public static void main(String[] args) {

        String nasaInstructions = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
        String output = roverControlOnMars(nasaInstructions);
        System.out.println(output);
    }

    public static String roverControlOnMars(String nasaInstructions) {
        String[] inputs = nasaInstructions.split(" ");

        Position plateauPosition;
        try {
            plateauPosition = new Position(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        } catch (NumberFormatException e) {
            throw new BadCoordinatesException("Expected integer values for the plateau's position. Retype position values from input!");
        }

        Plateau plateauMars = new Plateau(plateauPosition);
        String output = "";

        int i = 2;
        while (i < inputs.length) {
            Position roverPosition;
            try {
                try {
                    roverPosition = new Position(Integer.parseInt(inputs[i]), Integer.parseInt(inputs[i + 1]));
                } catch (NumberFormatException e) {
                    throw new BadCoordinatesException("Expected integer values for the rover's position. Retype position values from input!");
                }

                Rover rover = new Rover(roverPosition, Coordinates.valueOf(inputs[i + 2]), plateauMars);
                rover.exploringMars(inputs[i + 3], plateauMars);

                i = i + 4;

                output += rover.toString();
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new BadInstructionException("Missing instructions for rover. Please tell the rover how to explore the plateau");
            }
        }
        return output.trim();
    }
}