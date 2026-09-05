public class DefaultFieldValues {
    public static void main(String[] args) {
        LibraryCard card = new LibraryCard();
        System.out.println("Holder: " + card.holderName);
        System.out.println("Books Issued: " + card.booksIssued);
        System.out.println("Active: " + card.active);
    }

    static class LibraryCard {
        String holderName;
        int booksIssued;
        boolean active;
    }
}
