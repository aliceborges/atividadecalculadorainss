import java.text.DecimalFormat;

public class Utils {
    public static String formatValueBRL(double valor) {
        DecimalFormat decimal = new DecimalFormat("0.00");
        return "R$" + decimal.format(valor);
    }

}
