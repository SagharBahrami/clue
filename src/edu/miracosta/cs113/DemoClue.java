package edu.miracosta.cs113;

import model.AssistantJack;
import model.Theory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DemoClue {
    public static void main(String[] args) {

        int answerSet, solution, murder, weapon, location;
        ArrayList<Integer> wrongWeapon = new ArrayList<>();
        ArrayList<Integer> wrongMurder = new ArrayList<>();
        ArrayList<Integer> wrongLocation = new ArrayList<>();

        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // INPUT
        System.out.print("Which theory would you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);


        do {

            do{
                weapon = random.nextInt(6) + 1;

            }while(wrongWeapon.contains(weapon));
            do{
                location = random.nextInt(10) + 1;
            }while(wrongLocation.contains(location));
            do {
                murder = random.nextInt(6) + 1;
            }while(wrongMurder.contains(murder));



//            weapon = random.nextInt(6) + 1;
//                for (int i = 0; i < wrongWeapon.size(); i++) {
//
//                    if (weapon == wrongWeapon.get(i)){
//                        weapon = random.nextInt(6) + 1;
//                        i = 0;
//                    }
//                    }
//            location = random.nextInt(10) + 1;
//            for (int i = 0; i < wrongLocation.size(); i++)
//            {
//                if(location == wrongLocation.get(i))
//                {
//                    location = random.nextInt(10) + 1;
//                    i = 0;
//                }
//            }
//            murder = random.nextInt(6) + 1;
//            for(int i = 0; i < wrongMurder.size(); i++)
//            {
//                if(murder == wrongMurder.get(i))
//                {
//                    murder = random.nextInt(6) + 1;
//                    i = 0;
//                }
//            }
            solution = jack.checkAnswer(weapon, location, murder);
            if(solution == 1)
            {
                wrongWeapon.add(weapon);

            }
            else if(solution == 2)
            {
                wrongLocation.add(location);
            }
            else if(solution == 3)
            {
                wrongMurder.add(murder);
            }
        } while (solution != 0);

        answer = new Theory(weapon, location, murder);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }
}
