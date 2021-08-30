package org.example;

import java.util.Scanner;

/**
 * The game aimed at those who need to have fun. Such game calm you down so you will keen it on.
 *
 * @author Mihail Gerashchenko
 * @version 9.0 30 August 2021
 */
public class Controller implements GlobalConstants {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);
        model.setSecretValue();
        System.out.println(model.getSecretValue());
        while (model.checkValue(inputIntValueWithScanner(sc))) ;
        view.printMessage(View.CONGRATULATION + model.getSecretValue());
        view.printMessage(View.YOUR_WAY + String.valueOf(model.getYourWay()));
    }

    protected int inputIntValueWithScanner(Scanner sc) {
        int res = 0;
        view.printMessage(getInputIntMessage());
        while (true) {
            while (!sc.hasNextInt()) {
                view.printMessage(View.WRONG_INPUT_INT_DATA + getInputIntMessage());
                sc.next();
            }
            if ((res = sc.nextInt()) <= model.getMinBarrier() ||
                    res >= model.getMaxBarrier()) {
                view.printMessage(View.WRONG_INPUT_INT_DATA + getInputIntMessage());
                continue;
            }
            break;
        }
        return res;
    }

    protected String getInputIntMessage() {
        return view.concatenationString(
                View.INPUT_INT_DATA, View.OPENS_SQUARE_BRACKET,
                String.valueOf(model.getMinBarrier()), View.SPACE_SING,
                String.valueOf(model.getMaxBarrier()),
                View.CLOSING_SQUARE_BRACKET, View.SPACE_SING,
                View.EQUAL_SING, View.SPACE_SING);
    }
}
