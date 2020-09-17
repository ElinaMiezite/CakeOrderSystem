package MyPackage;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {
    public static Cake[] cakes = {
            new Cake("Double chocolate"),
            new Cake("With raspberries"),
            new Cake("With Halzenut cream"),
            new Cake("With cheese cream"),
            new Cake("Gluten free with strawberries"),
            new Cake("Gluten free with curd cream and cherries"),
            new Cake("Gluten free with almonds")
    };
    public static Delivery[] deliveries = {
            new Delivery("Delivery to bakery", 0.00),
            new Delivery("Delivery to Riga", 5.00),
            new Delivery("Delivery outside Riga", 10.00)
    };

    public static void main(String[] args) {
        LocalDate orderDate = LocalDate.now(); // My date object
        System.out.println("Your order placed at");
        System.out.println(orderDate); //Display the current date
        System.out.println("Please insert day you want receive order (dd.mm.yyyy):");
        Scanner scannerObject = new Scanner(System.in);
        boolean validDate = false;
        do {
            String inputDate = scannerObject.nextLine();
            DateTimeFormatter myDateInputObject = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate deliveryDate = LocalDate.parse(inputDate, myDateInputObject);
            System.out.println(deliveryDate);
            long dateDiff = orderDate.until(deliveryDate, DAYS);
            System.out.println(dateDiff);
            if (dateDiff < 0) { //negative day
                System.out.println("Please, insert correct date");
            } else if (dateDiff == 0 || dateDiff == 1) { //same or next day
                System.out.println("Your order is too soon, please reach us calling to +371 28098939");
            } else if (dateDiff > 7) { //+7 days
                System.out.println("Thank you for your timely order, we are happy to announce, that you will " +
                        "+ receive our special choco surprise");
                validDate = true;
            } else {
                System.out.println("Please choose you cake");
                validDate = true;
            }

            if (!validDate) {
                System.out.println("Please enter a new one, if you want to proceed with order");
            }
        } while (!validDate);

        int cakeID = 0;

        while(cakeID == 0) {
            System.out.println("Choose your cake:");
            for (int i = 0; i < cakes.length; i++) {
                System.out.println((i + 1) + ") " + cakes[i].name);
            }
            System.out.println("Type in the cake number: ");
            cakeID = scannerObject.nextInt();

            if (cakeID < 1 || (cakeID-1) > cakes.length || cakes[cakeID-1] == null) {
                System.out.println("Wrong number!");
                cakeID = 0;
            }
        }
        cakeID--;
        System.out.println("You choose cake " + cakes[cakeID].name);

        int cakeSizeID = 0;
        while(cakeSizeID == 0) {
            System.out.println("Choose the cake size:");
            for (int i = 0; i < Cake.sizes.length; i++) {
                System.out.println((i + 1) + ") " + Cake.sizes[i].size + " " + Cake.sizes[i].weight + "kg" + " " + Cake.sizes[i].price + "EUR");
            }
            System.out.println("Type in the cake size number: ");
            cakeSizeID = scannerObject.nextInt();

            if (cakeSizeID < 1 || (cakeSizeID-1) > Cake.sizes.length || Cake.sizes[cakeSizeID-1] == null) {
                System.out.println("Wrong number!");
                cakeSizeID = 0;
            }
        }
        cakeSizeID--;

        System.out.println("You choose size " + Cake.sizes[cakeSizeID].size);

        boolean hasGiftWrap = false;
        boolean isValid = false;
        while(!isValid) {
            System.out.println("Do you need gift wrap? (Y/N)");
            final String giftWrapAnswer = scannerObject.next();
            if (giftWrapAnswer.matches("y|n|Y|N")) {
                isValid = true;
                hasGiftWrap = giftWrapAnswer.matches("y|Y");
            } else {
                System.out.println("Invalid answer, please try again ");
            }
            System.out.println("Please write if there is any special requirements");
            final String specialRequirements = scannerObject.next();


        }

        int deliveryID = 0;
        while(deliveryID == 0) {
            System.out.println("Way you want delivery");
            for (int i = 0; i < Delivery.deliveries.length ; i++) {
                System.out.println((i + 1) + ") " + Delivery.deliveries[i].delivery);
            }
            System.out.println("Type in the delivery way: ");
            deliveryID = scannerObject.nextInt();

            if (deliveryID < 1 || (deliveryID-1) > Delivery.deliveries.length || Delivery.deliveries[deliveryID-1] == null) {
                System.out.println("Wrong number!");
                deliveryID = 0;
            }
        }
        deliveryID--;

        System.out.println("You choose: " + Delivery.deliveries[deliveryID].delivery);
    }





}









