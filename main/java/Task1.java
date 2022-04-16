import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        TreeMap<Integer, Abonent> abonents  = new TreeMap<>();
        abonents.put(2, new Abonent("Petrov","Ivan","Ivanych","Ivan's address"));
        abonents.put(1, new Abonent("Ivanov","Petro","Petrovych","Petro's address"));
        abonents.put(3, new Abonent("Sosnovenko","Vadym","Volodymyrovych","Vadym's address"));
        abonents.put(4, new Abonent("Sample Surname","Sample Name","Sample patronymic","Address"));
        int userChoice = 0;
        while (userChoice != 3) {
            userChoice = menu();
            switch (userChoice) {
                case 1:
                    System.out.println("Abonents:");
                    if(abonents.isEmpty()){
                        System.out.println("Abonents list is empty!");
                    }
                    else {
                        sort_by_name(abonents);
                        sort_by_surname(abonents);
                    }
                    break;
                case 2:
                    add_abon(abonents);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Something went wrong. Please enter a valid character\n");
            }
        }
    }

    public static ArrayList<Abonent> sort_by_name(TreeMap<Integer, Abonent> abonents) {
        ArrayList<Abonent> sorted_arr = new ArrayList<>();

        for (Map.Entry<Integer,Abonent> entry: abonents.entrySet()){
            sorted_arr.add(entry.getValue());
        }
        sorted_arr.sort(new AbonentNameComparator());

        System.out.println("Sorted by name:");
        print_sorted(abonents, sorted_arr);
        return sorted_arr;
    }

    public static ArrayList<Abonent> sort_by_surname(Map<Integer, Abonent> abonents) {
        ArrayList<Abonent> sorted_arr = new ArrayList<>();

        for (Map.Entry<Integer,Abonent> entry: abonents.entrySet()){
            sorted_arr.add(entry.getValue());
        }
        sorted_arr.sort(new AbonentSurnameComparator());
        System.out.println("Sorted by surname:");
        print_sorted(abonents, sorted_arr);
        return sorted_arr;
    }

    public static void print_sorted(Map<Integer, Abonent> abonents, ArrayList<Abonent> sorted_arr){
        Set<Map.Entry<Integer, Abonent>> entries = abonents.entrySet();
        for (Abonent abon: sorted_arr){
            for (Map.Entry<Integer, Abonent> entry: entries) {
                if (Objects.equals(entry.getValue(), abon)) {
                    System.out.println(entry.getKey() + "=" + abon);
                }
            }
        }
    }


    static class AbonentNameComparator implements Comparator<Abonent>{

        @Override
        public int compare(Abonent a1, Abonent a2) {
            return a1.getName().compareTo(a2.getName());
        }
    }
    static class AbonentSurnameComparator implements Comparator<Abonent>{

        @Override
        public int compare(Abonent a1, Abonent a2) {
            return a1.getSurname().compareTo(a2.getSurname());
        }
    }


    static void add_abon(Map<Integer, Abonent> abonents) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter abonent's phone number: ");
        int number = Integer.parseInt(input.nextLine());
        System.out.print("Enter a surname: ");
        String surname = input.nextLine();
        System.out.print("Enter a name: ");
        String name = input.nextLine();
        System.out.print("Enter a patronymic: ");
        String patronymic = input.nextLine();
        System.out.print("Enter address: ");
        String address = input.nextLine();
        Abonent abon = new Abonent(surname, name, patronymic, address);
        abonents.put(number, abon);
        System.out.print("Added abonent with \n\tSurname: " + surname + "\n"+
                                            "\tName: " + name + "\n"+
                                            "\tPatronymic: " + patronymic + "\n"+
                                            "\tAddress: " + address + "\n");
    }

    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Show a List");
        System.out.println("2 - Add an abonent");
        System.out.println("3 - Quit");

        selection = input.nextInt();
        return selection;
    }

    static class Abonent{
        public String surname;
        public String name;
        public String patronymic;
        public String address;

        public Abonent(String surname, String name, String patronymic, String address){
            this.surname = surname;
            this.name = name;
            this.patronymic = patronymic;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setPatronymic(String patronymic) {
            this.patronymic = patronymic;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Abonent that = (Abonent) o;
            return name.equals(that.name) && surname.equals(that.surname) &&
                    patronymic.equals(that.patronymic) && address.equals(that.address);
        }

        @Override
        public String toString()
        {
            return this.surname + " " + this.name + " " + this.patronymic + " " + this.address;
        }
    }
}
