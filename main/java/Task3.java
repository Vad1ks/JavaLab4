import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        HashMap<Integer, Book> books  = new HashMap<>();
        books.put(2, new Book("Title1","AuthorName1","Publisher1",2012, 150));
        books.put(1, new Book("Title2","AuthorName2","Publisher2",2032, 150));
        books.put(3, new Book("Title3","AuthorName","Publisher3",2010, 160));
        books.put(4, new Book("Title3","AuthorName","Publisher3",2010, 150));

        int userChoice = 0;
        while (userChoice != 4) {
            userChoice = menu();
            switch (userChoice) {
                case 1:
                    System.out.println("Books:");
                    if(books.isEmpty()){
                        System.out.println("Book list is empty!");
                    }
                    else {
                        sort_by_publicationYear(books);
                        sort_by_authorName(books);
                    }
                    break;
                case 2:
                    HashMap<Integer, Book> filtered =  searchBooks(books);
                    if(filtered.isEmpty()){
                        System.out.println("No books corresponding to your request");
                    }
                    else System.out.println(filtered);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Something went wrong. Please enter a valid character\n");
            }
        }
    }

    public static ArrayList<Book> sort_by_authorName(Map<Integer, Book> books) {
        ArrayList<Book> sorted_arr = new ArrayList<>();

        for (Map.Entry<Integer, Book> entry: books.entrySet()){
            sorted_arr.add(entry.getValue());
        }
        sorted_arr.sort(new BookAuthorNameComparator());
        System.out.println("Sorted by Author Name:");
        print_sorted(books, sorted_arr);
        return sorted_arr;
    }

    public static ArrayList<Book> sort_by_publicationYear(Map<Integer, Book> books) {
        ArrayList<Book> sorted_arr = new ArrayList<>();

        for (Map.Entry<Integer, Book> entry: books.entrySet()){
            sorted_arr.add(entry.getValue());
        }
        sorted_arr.sort(new BookPublicationYearComparator());
        System.out.println("Sorted by Publication Year:");
        print_sorted(books, sorted_arr);
        return sorted_arr;
    }

    public static void print_sorted(Map<Integer, Book> books, ArrayList<Book> sorted_arr){
        Set<Map.Entry<Integer, Book>> entries = books.entrySet();
        for (Book book: sorted_arr){
            for (Map.Entry<Integer, Book> entry: entries) {
                if (Objects.equals(entry.getValue(), book)) {
                    System.out.println(entry.getKey() + "=" + book);
                }
            }
        }
    }

    private static HashMap<Integer, Book> searchBooks(HashMap<Integer, Book> books) {
        Scanner input = new Scanner(System.in);
        System.out.println("Pick a number to perform needed action:");
        System.out.println("1 - Search by book title");
        System.out.println("2 - Search by Publisher Title");
        System.out.println("3 - Search by Author's name");
        int number = input.nextInt();
        Scanner input2 = new Scanner(System.in);
        if (number <= 3 && number >= 1) {
            switch (number) {
                case 1:
                    System.out.println("Enter a book title:");
                    String title = input2.nextLine();
                    return searchBookByTitle(books, title);
                case 2:
                    System.out.println("Enter a Publisher Title:");
                    String publisherTitle = input2.nextLine();
                    return searchBookByPublisherTitle(books, publisherTitle);
                case 3:
                    System.out.println("Enter an Author's name:");
                    String authorName = input2.nextLine();
                    return searchBookByAuthor(books, authorName);
                default:
                    System.out.println("Input a correct number");
                    return new HashMap<>();
            }
        }
        return new HashMap<>();
    }

    private static HashMap<Integer, Book> searchBookByAuthor(HashMap<Integer, Book> books, String authorName){
        HashMap<Integer, Book> filtered_books = new HashMap<>();

        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            if (Objects.equals(entry.getValue().getAuthorName(), authorName)){
                filtered_books.put(entry.getKey(), entry.getValue());
            }
        }
        return filtered_books;
    }

    private static HashMap<Integer, Book> searchBookByTitle(HashMap<Integer, Book> books, String title){
        HashMap<Integer, Book> filtered_books = new HashMap<>();
        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            if (Objects.equals(entry.getValue().getTitle(), title)){
                filtered_books.put(entry.getKey(), entry.getValue());
            }
        }
        return filtered_books;
    }

    private static HashMap<Integer, Book> searchBookByPublisherTitle(HashMap<Integer, Book> books, String publisherTitle){
        HashMap<Integer, Book> filtered_books = new HashMap<>();
        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            if (Objects.equals(entry.getValue().getPublisherTitle(), publisherTitle)){
                filtered_books.put(entry.getKey(), entry.getValue());
            }
        }
        return filtered_books;
    }

    public static int menu() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Show a List");
        System.out.println("2 - Search a book");
        System.out.println("3 - Quit");

        selection = input.nextInt();
        return selection;
    }

    static class BookAuthorNameComparator implements Comparator<Book> {

        @Override
        public int compare(Book a1, Book a2) {
            return a1.getAuthorName().compareTo(a2.getAuthorName());
        }
    }

    static class BookPublicationYearComparator implements Comparator<Book> {

        @Override
        public int compare(Book a1, Book a2) {
            return Integer.compare(a1.getYear_of_publication(), a2.getYear_of_publication());
        }
    }

    static class Book{
        String title;
        String authorName;
        String publisherTitle;
        int year_of_publication;
        float price;

        public Book(String title, String authorName, String publisherTitle, int year_of_publication, float price){
            this.title = title;
            this.authorName = authorName;
            this.publisherTitle = publisherTitle;
            this.year_of_publication = year_of_publication;
            this.price = price;
        }

        public String getAuthorName() {
            return authorName;
        }

        public int getYear_of_publication() {
            return year_of_publication;
        }

        public String getTitle() {
            return title;
        }

        public String getPublisherTitle() {
            return publisherTitle;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book that = (Book) o;
            return title.equals(that.title) && authorName.equals(that.authorName) &&
                    publisherTitle.equals(that.publisherTitle) &&
                    year_of_publication == that.year_of_publication &&
                    price == that.price;
        }

        public boolean is_unique(HashMap<Integer, Book> bookHashMap){
            TreeSet<Book> bookTreeSet = new TreeSet<Book>(bookHashMap.values());
            return bookHashMap.values().size() == bookTreeSet.size();
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", authorName='" + authorName + '\'' +
                    ", publisherTitle='" + publisherTitle + '\'' +
                    ", year_of_publication=" + year_of_publication +
                    ", price=" + price +
                    "}";
        }
    }
}
