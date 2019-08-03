public class RoverControll {

    public static void main(String[] args) {

        String nasaInstructions = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM 2 1 S LLMLMMRM";
        String[] inputs = nasaInstructions.split(" ");

        Position plateauPosition;
        try {
            plateauPosition = new Position(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));

        } catch (NumberFormatException e) {
            System.out.println("Expected integer values for the plateau's position. Retype position values from input!");
            return;
        }

        Plateau plateauMars = new Plateau(plateauPosition);
        System.out.println(plateauMars);

        int i = 2;
        while (i < inputs.length) {
            Position roverPosition;
            try {
                roverPosition = new Position(Integer.parseInt(inputs[i]), Integer.parseInt(inputs[i + 1]));

            } catch (NumberFormatException e) {
                System.out.println("Expected integer values for the rover's position. Retype position values from input!");
                return;
            }

            Rover rover = new Rover(roverPosition, Coordinates.valueOf(inputs[i + 2]));
            System.out.println(rover);
            rover.exploringMars(inputs[i + 3]);

            System.out.println("Final coordinates of the rover after receiving Nasa's input: " + rover);
            i = i + 4;
        }
    }
}