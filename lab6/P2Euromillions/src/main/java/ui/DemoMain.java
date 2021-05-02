package ui;

import euromillions.CuponEuromillions;
import euromillions.Dip;
import euromillions.EuromillionsDraw;
import java.util.logging.*;

public class DemoMain {

    /**
     * demonstrates a client for ramdom euromillions bets
     */
    public static void main(String[] args) {
        final Logger logger = Logger.getLogger("DemoMain");;

        // played sheet
        CuponEuromillions thisWeek = new CuponEuromillions();
        logger.info("Betting with three random bets...");
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());

        // simulate a random draw
        EuromillionsDraw draw = EuromillionsDraw.generateRandomDraw();

        //report results
        String weekFormat = "You played: " + thisWeek.format();
        logger.info(weekFormat);

        String drawResults = "Draw results: " + draw.getDrawResults().format();
        logger.info(drawResults);

        logger.info("Your score:");
        for (Dip dip : draw.findMatches(thisWeek)) {
            String dipStr = dip.format();
            logger.info(dipStr);

        }
    }
}
