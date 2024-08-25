public class Conversion {

    // Method to convert feet to meters
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    // Method to convert meters to feet
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main(String[] args) {
        System.out.println("feet    meters   |  meters  feet");
        System.out.println("----------------------------------");

        for (double feet = 1.0; feet <= 10.0; feet++) {
            double metersFromFeet = footToMeter(feet);
            double meters = 20.0 + (feet - 1) * 5;
            double feetFromMeters = meterToFoot(meters);

            System.out.printf("%.1f    %.3f   |  %.1f   %.3f\n",
                    feet, metersFromFeet, meters, feetFromMeters);
        }
    }
}