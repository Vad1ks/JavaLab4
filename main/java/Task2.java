import java.util.*;

public class Task2{
    public static void main(String[] args) {
        HashMap<Integer, Task1.Abonent> abonents  = new HashMap<>();
        abonents.put(2, new Task1.Abonent("sur3","sur2","pat3","addr3"));
        abonents.put(1, new Task1.Abonent("sur1","sur3","pat1","addr1"));
        abonents.put(3, new Task1.Abonent("sur2","sur1","pat2","addr2"));
        abonents.put(4, new Task1.Abonent("1","2","3","4"));

        int userChoice = 0;
        while (userChoice != 4) {
            userChoice = menu();
            switch (userChoice) {
                case 1:
                    System.out.println("Abonents:");
                    if(abonents.isEmpty()){
                        System.out.println("Abonents list is empty!");
                    }
                    else {
                        Task1.sort_by_surname(abonents);
                    }
                    break;
                case 2:
                    Task1.add_abon(abonents);
                    break;
                case 3:
                    if(edit_Abonent(abonents)){
                        System.out.println("Abonent edited successfully");
                    }
                case 4:
                    break;
                default:
                    System.out.println("Something went wrong. Please enter a valid character\n");
            }
        }
    }

    public static int menu() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Show a List");
        System.out.println("2 - Add an abonent");
        System.out.println("3 - Edit an abonent");
        System.out.println("4 - Quit");

        selection = input.nextInt();
        return selection;
    }

    public static boolean edit_Abonent(Map<Integer, Task1.Abonent> abonentMap){
        int number;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number of abonent to edit:");
        number = input.nextInt();

        Task1.Abonent editable = abonentMap.get(number);
        if(editable != null){
            System.out.println("Pick a number to perform needed action:");
            System.out.println("1 - Edit name");
            System.out.println("2 - Edit surname");
            System.out.println("3 - Edit patronymic");
            System.out.println("4 - Edit address");
            number = input.nextInt();
            Scanner input2 = new Scanner(System.in);
            switch (number){
                case 1:
                    System.out.println("Enter a new name:");
                    String name = input2.nextLine();
                    editable.setName(name);
                    return true;
                case 2:
                    System.out.println("Enter a new surname:");
                    String surname = input2.nextLine();
                    editable.setSurname(surname);
                    return true;
                case 3:
                    System.out.println("Enter a new patronymic:");
                    String patr = input2.nextLine();
                    editable.setPatronymic(patr);
                    return true;
                case 4:
                    System.out.println("Enter a new address:");
                    String address = input2.nextLine();
                    editable.setAddress(address);
                    return true;
                default:
                    System.out.println("Input a correct number");
                    return false;
            }
        }
        else{
            System.out.println("There is no abonent with such number");
            return false;
        }
    }
}