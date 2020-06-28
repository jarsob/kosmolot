import java.util.Collections;

public class Kosmolot {
    public static void main(String[] args) {

        String rocketSizeStr;
        int lengthOfStars, rocketSize;
        String mustHaveShieldStr;
        boolean mustHaveShield;

        StringBuilder rocketElement = new StringBuilder();
        StringBuilder rocketLine = new StringBuilder();

//      długość bloku gwiazdki i spacje w linii wynosi n
//      w środkowej linii nie ma spacji
        // n - rozmiar rakiety, 2*n-1 : ilość linii do wydruku
        rocketSizeStr = args[0];
        rocketSize = Integer.parseInt(rocketSizeStr.trim());
        mustHaveShieldStr = args[1].trim();


        // wartości testowe
        rocketSize = 5;
        mustHaveShieldStr = "Y";

        mustHaveShield = mustHaveShieldStr.equals("Y");
        String[] shieldElement = {"\\", "/"};
        String basicElement = "*";
        String specialShieldElement = ">";


        // main loop
        for (int i = 1; i < 2 * rocketSize; i++) {

            // k - długość bloku gwiazdek w linii, w każdej linii ma być n bloków gwiazdek
            lengthOfStars = rocketSize - Math.abs(rocketSize - i);

            rocketElement.append(String.join("",Collections.nCopies(lengthOfStars,basicElement)));



//            for (int j = 0; j < lengthOfStars; j++) {
//                rocketElement.append(basicElement);
//            }

            if (mustHaveShield && i != rocketSize) {
                rocketElement.replace(rocketElement.length() - 1, rocketElement.length(), i < rocketSize ? shieldElement[0] : shieldElement[1]);
            }

            rocketElement.append(String.join("",Collections.nCopies(rocketSize - lengthOfStars," ")));

//            for (int j = 0; j < rocketSize - lengthOfStars; j++) {
//                rocketElement.append(" ");
//            }

            rocketLine.append(String.join("", Collections.nCopies(rocketSize, rocketElement)));

//            for (int j = 0; j < rocketSize; j++) {
//                rocketLine.append(rocketElement);
//            }

            if (mustHaveShield) {
                rocketLine.replace(0, 1, specialShieldElement);
                if (i == rocketSize) {
                    rocketLine.replace(rocketLine.length() - 1, rocketLine.length(), specialShieldElement);
                }
            }

            System.out.print(rocketLine);

            //clear brick and rocketLine
            rocketElement.setLength(0);
            rocketLine.setLength(0);
//            rocketElement.delete(0, rocketElement.length());
//            rocketLine.delete(0, rocketLine.length());
            System.out.println();

        }

    }
}
