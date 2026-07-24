import model.CarDetails;
import model.CarType;
import rules.PrivateCarSpeedRule;
import rules.SeatbeltRule;
import rules.TruckSpeedRule;
import service.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        FineManager fineManager = new FineManager();
        Radar radar = new Radar(fineManager);

        radar.addRule(new TruckSpeedRule());
        radar.addRule(new PrivateCarSpeedRule());
        radar.addRule(new SeatbeltRule());

        while (true) {

            System.out.println("\n========== RADAR SYSTEM ==========");
            int choice;

            while (true) {

                System.out.println("1. Manual Input");
                System.out.println("2. Sample Data");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                try {
                    choice = Integer.parseInt(input.nextLine());

                    if (choice >= 1 && choice <= 3) {
                        break;
                    }

                    System.out.println("\nPlease enter a number between 1 and 3\n");

                } catch (NumberFormatException e) {
                    System.out.println("\nPlease enter a valid number\n");
                }
            }

            switch (choice) {

                case 1:
                    runManualInput(radar, fineManager, input);
                    break;

                case 2:
                    runSampleData(radar, fineManager);
                    break;

                case 3:
                    System.out.println("\t\t\t\t\t\tExiting");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void runSampleData(Radar radar, FineManager fineManager) {

        System.out.println("\nRunning sample data...\n");

        radar.process(new CarDetails(
                "ABC123",
                CarType.TRUCK,
                LocalDate.of(2002, 8, 22),
                70,
                false));

        radar.process(new CarDetails(
                "XYZ555",
                CarType.PRIVATE,
                LocalDate.of(1998, 12, 10),
                90,
                true));

        radar.process(new CarDetails(
                "MNO845",
                CarType.PRIVATE,
                LocalDate.of(2026, 7, 23),
                100,
                false));

        System.out.println();

        fineManager.printAllFines();
        fineManager.printTotalFinesPerCar();
        fineManager.printViolatedRules();
    }

    private static void runManualInput(Radar radar,
                                       FineManager fineManager,
                                       Scanner input) {

        boolean again = true;

        while (again) {

            System.out.print("\nPlate Number: ");
            String plate = input.nextLine();

            CarType type;

            while (true) {
                System.out.print("Car Type (Private/Truck): ");
                try {
                    type = CarType.valueOf(input.nextLine().trim().toUpperCase());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid car type.");
                }
            }

            LocalDate date;

            while (true) {

                try {
                    System.out.print("Date (yyyy-MM-dd): ");
                    date = LocalDate.parse(input.nextLine());
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format.");
                }
            }

            float speed;

            while (true) {

                System.out.print("Speed: ");

                try {
                    speed = Float.parseFloat(input.nextLine());

                    if (speed >= 0)
                        break;

                    System.out.println("Speed cannot be negative.");
                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid number.");
                }
            }

            boolean seatbelt;

            while (true) {

                System.out.print("Seatbelt fastened? (Y/N): ");

                String answer = input.nextLine();

                if (answer.equalsIgnoreCase("Y")) {
                    seatbelt = true;
                    break;
                }

                if (answer.equalsIgnoreCase("N")) {
                    seatbelt = false;
                    break;
                }

                System.out.println("Please enter Y or N.");
            }

            CarDetails car = new CarDetails(
                    plate,
                    type,
                    date,
                    speed,
                    seatbelt
            );

            radar.process(car);

            System.out.print("\nEnter another car? (Y/N): ");

            String choice = input.nextLine();

            again = choice.equalsIgnoreCase("Y");
        }

        System.out.println();

        fineManager.printAllFines();
        fineManager.printTotalFinesPerCar();
        fineManager.printViolatedRules();
    }
}
