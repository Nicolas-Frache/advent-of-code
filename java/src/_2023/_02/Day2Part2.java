package _2023._02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Day2Part2 {
    public static void main(String[] args) throws IOException {
        String inputFile = "src\\_2023\\_02\\input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String ligne;
        int totalPower = 0;

        // Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
        while ((ligne = reader.readLine()) != null) {
            int rmin = 0, gmin = 0, bmin = 0;

            String[] tmp1 = ligne.split(":");
            int id = parseInt(tmp1[0].split(" ")[1]);

            String[] tmpGames = tmp1[1].split(";");
            for(String game : tmpGames) {
                String[] tmpBall = game.split(",");
                for(String ball : tmpBall){
                    String[] cubeData = ball.split(" ");
                    int number = parseInt(cubeData[1]);
                    String color = cubeData[2];

                    if(color.equals("red") && number > rmin) {
                        rmin = number;
                    } else if(color.equals("green") && number > gmin) {
                        gmin = number;
                    } else if(color.equals("blue") && number > bmin) {
                        bmin = number;
                    }
                }
            }
            totalPower += rmin * gmin * bmin;
        }
        System.out.println(totalPower);
        reader.close();
    }
}
