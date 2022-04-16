import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        ArrayList<Byte> byteArrayList = new ArrayList<>();
        byteArrayList.add((byte) 1);

        int userChoice = 0;
        while (userChoice != 4) {
            userChoice = menu();
            switch (userChoice) {
                case 1:
                    System.out.println("Byte list:");
                    if(byteArrayList.isEmpty()){
                        System.out.println("Byte list is empty!");
                    }
                    else {
                        System.out.println(byteArrayList);
                    }
                    break;
                case 2:
                    add_byte(byteArrayList);
                    break;
                case 3:
                    edit_byte(byteArrayList);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Something went wrong. Please enter a valid character\n");
            }
        }
    }

    static void add_byte(ArrayList<Byte> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input value to add to bytelist");
        try {
            byte value = sc.nextByte();
            list.add(value);
            System.out.println("Value " + value + " Successfully added to list");
        } catch (InputMismatchException e){
            System.out.println("Value out of range");
        }

    }

    static void edit_byte(ArrayList<Byte> list){
        Scanner sc = new Scanner(System.in);
        System.out.println(list);
        System.out.println("Input index of element to edit");
        int i = sc.nextInt();
        if (i >= 0 && i <list.size()){
            System.out.println("Input value to replace " + i + " element");
            byte newbyte = sc.nextByte();
            byte oldval = list.get(i);
            list.remove(i);
            list.add(i, newbyte);
            System.out.println("Byte " + oldval + " successfully edited and now has value of " + newbyte);
            System.out.println("List now looks like " + list);
        }
        else System.out.println("Index is incorrect!");
    }

    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Show a List");
        System.out.println("2 - Add element");
        System.out.println("3 - Edit element");
        System.out.println("4 - Quit");

        selection = input.nextInt();
        return selection;
    }
}
