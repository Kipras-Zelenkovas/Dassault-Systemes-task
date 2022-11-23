package com.idkpackade;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static void prideti(LinkedList<LinkedList<String>> sveciai, Scanner in){

        try{
            LinkedList<String> temp = new LinkedList<>();

            System.out.println("Iveskite kambario numeri: ");
            int room = in.nextInt() - 1;

            if(sveciai.get(room).isEmpty()) {

                System.out.println("Iveskite varda: ");
                temp.addLast(in.nextLine());

                System.out.println("Iveskite pavarde: ");
                temp.addLast(in.nextLine());


                sveciai.remove(room );
                sveciai.add(room, temp);
            }else{
                System.out.println("Uzimtas");
            }
        }catch (Exception e){
            System.out.println("Jus kazka blogai irasete. Perziurekite savo ivestus duomenys ir bandykite dar karta");
            in.next();
        }

    }
    private static void istrinti(LinkedList<LinkedList<String>> sveciai, Scanner in, LinkedList<LinkedList<String>> istorija){

        try{
            System.out.println("Iveskite numeri kad isregistruoti svecia");

            isvesti(sveciai);

            int del = in.nextInt() - 1;

            if(!sveciai.get(del).isEmpty()) {

                LinkedList<String> tempList = sveciai.get(del);

                if(istorija.get(del).isEmpty()){
                    LinkedList<String> tempList2 = new LinkedList<>();
                    tempList2.add(tempList.get(0) + " " + tempList.get(1));

                    istorija.remove(del);
                    istorija.add(del, tempList2);
                }else {
                    LinkedList<String> tempList3 = istorija.get(del);
                    istorija.remove(del);
                    tempList3.addLast(tempList.get(0) + " " + tempList.get(1));
                    istorija.add(del, tempList3);
                }

                sveciai.remove(del);
                sveciai.add(del, new LinkedList<>());
            }else{
                System.out.println("Joks zmogus nera tam kambari uzregistruotas");
            }
        }catch (Exception e){
            System.out.println("Jus kazka blogai irasete. Perziurekite savo ivestus duomenys ir bandykite dar karta");
            in.next();
        }

    }
    private static void isvesti(LinkedList<LinkedList<String>> arr){
        try{
            for(int i = 0; i < arr.size(); i++){
                System.out.print(i+1 + ": ");
                for(int y = 0; y < arr.get(i).size(); y++){
                    System.out.print(arr.get(i).get(y) + ", ");
                }
                System.out.println("\n");
            }
        }catch (Exception e){
            System.out.println("Ivyko kazkokia klaida");
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int vertex = 5;
        LinkedList<LinkedList<String>> data = new LinkedList<>();
        LinkedList<LinkedList<String>> uzimtumoIstorija = new LinkedList<>();

        for(int s = 0; s < vertex; s++){
            data.add(new LinkedList<>());
        }

        for(int s = 0; s < vertex; s++){
            uzimtumoIstorija.add(new LinkedList<>());
        }

        boolean run = true;

        while(run){
            try{
                System.out.println("Iveskite skaiciu kokia funkcija norite atlikti");
                System.out.println("Funckijos: ");
                System.out.println("Iregistruoti svecia - 1");
                System.out.println("Isregistruoti svecia - 2");
                System.out.println("Perziureti kambariu uzimtuma - 3");
                System.out.println("Perziureti kambariu uzimtumo istorija - 4");
                System.out.println("Isjungti programa - 0");
                int fucn = in.nextInt();

                switch (fucn) {
                    case 1 -> prideti(data, in);
                    case 2 -> istrinti(data, in, uzimtumoIstorija);
                    case 3 -> isvesti(data);
                    case 4 -> isvesti(uzimtumoIstorija);
                    case 0 -> run = false;
                }
            }catch (Exception e){
                System.out.println("Ivyko kazkokia klaida " + e.getMessage());
                in.next();
            }
        }

    }

}
