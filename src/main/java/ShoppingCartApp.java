import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ShoppingCartApp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));
        PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);

        out.println("Choose language: en, fi, sv, ja");
        String lang = br.readLine();

        Locale locale = getLocale(lang);

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

        ShoppingCartService service = new ShoppingCartService();

        out.println(messages.getString("title"));

        out.println(messages.getString("enter_item_count"));
        int itemCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= itemCount; i++) {
            out.println(messages.getString("item") + " " + i);

            out.print(messages.getString("enter_price"));
            double price = Double.parseDouble(br.readLine());

            out.print(messages.getString("enter_quantity"));
            int quantity = Integer.parseInt(br.readLine());

            double itemTotal = service.addItem(price, quantity);

            out.println(messages.getString("item_total") + " " + numberFormat.format(itemTotal));
            out.println();
        }

        out.println(messages.getString("final_total"));
        out.println(messages.getString("total_cost") + " " + numberFormat.format(service.getTotalCost()));
    }

    private static Locale getLocale(String lang) {
        switch (lang) {
            case "fi":
                return new Locale("fi", "FI");
            case "sv":
                return new Locale("sv", "SE");
            case "ja":
                return new Locale("ja", "JP");
            default:
                return new Locale("en", "US");
        }
    }
}
