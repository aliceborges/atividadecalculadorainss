import java.util.*;
import java.text.DecimalFormat;

public class CalculadoraSalario {

    private static Map<Double, List<Double>> getPercentageDiscountsAndRangeValuesINSS() {
        // Hash com todas as informações de faixas salariais e taxas de desconto do INSS
        Map<Double, List<Double>> percentageDiscountAndRangeValues = new HashMap<Double, List<Double>>();

        List<Double> firstDiscount = new ArrayList<Double>();
        firstDiscount.add(0.00);
        firstDiscount.add(1045.00);
        percentageDiscountAndRangeValues.put(7.5, firstDiscount);

        List<Double> secondDiscount = new ArrayList<Double>();
        secondDiscount.add(1045.01);
        secondDiscount.add(2089.60);
        percentageDiscountAndRangeValues.put(9.0, secondDiscount);

        List<Double> thirdDiscount = new ArrayList<Double>();
        thirdDiscount.add(2089.61);
        thirdDiscount.add(3134.40);
        percentageDiscountAndRangeValues.put(12.00, thirdDiscount);

        List<Double> fourthDiscount = new ArrayList<Double>();
        fourthDiscount.add(3134.41);
        fourthDiscount.add(6101.06);
        percentageDiscountAndRangeValues.put(14.00, fourthDiscount);


        return percentageDiscountAndRangeValues;
    }

    private static Map<Double, List<Double>> getPercentageDiscountsAndRangeValuesIRRF() {
        // Hash com todas as informações de faixas salariais e taxas de desconto do IRRF
        Map<Double, List<Double>> percentageDiscountAndRangeValues = new HashMap<Double, List<Double>>();

        List<Double> firstDiscount = new ArrayList<Double>();
        firstDiscount.add(1903.99);
        firstDiscount.add(2826.65);
        percentageDiscountAndRangeValues.put(7.5, firstDiscount);

        List<Double> secondDiscount = new ArrayList<Double>();
        secondDiscount.add(2826.66);
        secondDiscount.add(3751.05);
        percentageDiscountAndRangeValues.put(15.00, secondDiscount);

        List<Double> thirdDiscount = new ArrayList<Double>();
        thirdDiscount.add(3751.06);
        thirdDiscount.add(4664.68);
        percentageDiscountAndRangeValues.put(22.5, thirdDiscount);

        List<Double> fourthDiscount = new ArrayList<Double>();
        fourthDiscount.add(4664.69);
        fourthDiscount.add(Double.POSITIVE_INFINITY);
        percentageDiscountAndRangeValues.put(15.0, fourthDiscount);

        return percentageDiscountAndRangeValues;
    }

    private static double calculateValueWithDiscount(double discountPercentage, double value) {
        return value - value * discountPercentage / 100;
    }

    private static double calculateSalaryWithDiscounts(double salarioBase, Map<Double, List<Double>> valueDiscounts) {
        double salaryWithDiscount = 0;
        for (Map.Entry<Double, List<Double>> valorDesconto : valueDiscounts.entrySet()) {
            double discountPercentage = valorDesconto.getKey();
            List<Double> salaryRange = valorDesconto.getValue();
            if (salarioBase >= salaryRange.get(0) && salarioBase <= salaryRange.get(1))
                salaryWithDiscount = calculateValueWithDiscount(discountPercentage, salarioBase);
        }

        if (salaryWithDiscount == 0)
            return salarioBase;
        return salaryWithDiscount;
    }

    public static long calcularSalarioLiquido(double salarioBase) {
        double salaryWithDiscounts = 0;

        // CALCULANDO VALOR DE DESCONTO - INSS
        System.out.println("\nINSS");
        salaryWithDiscounts = calculateSalaryWithDiscounts(salarioBase, getPercentageDiscountsAndRangeValuesINSS());
        System.out.print("Desconto: " + formatValueBRL(salarioBase - salaryWithDiscounts) + ". ");
        System.out.println("Valor do salário com desconto do INSS: " + formatValueBRL(salaryWithDiscounts));

        // CALCULANDO VALOR DE DESCONTO - IRRF
        System.out.println("\nIRRF");
        salaryWithDiscounts = calculateSalaryWithDiscounts(salaryWithDiscounts, getPercentageDiscountsAndRangeValuesIRRF());
        System.out.print("Desconto: " + formatValueBRL(salarioBase - salaryWithDiscounts) + ". ");
        System.out.println("Valor do salário com desconto do IRRF: " + formatValueBRL(salaryWithDiscounts));

        return Math.round(salaryWithDiscounts);
    }

    private static String formatValueBRL(double valor) {
        DecimalFormat decimal = new DecimalFormat("0.00");
        return "R$" + decimal.format(valor);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nomeFuncionario;
        double salario;

        while (true){
            System.out.print("Nome do funcionário: ");
            nomeFuncionario = input.next();

            System.out.print("Salário: R$");
            salario = input.nextDouble();

            System.out.println("\nO(a) funcionário(a) " + nomeFuncionario + " irá ter os seguintes descontos no seu respectivo salário: ");
            System.out.println("Valor do salário líquido: " + formatValueBRL(salario));
            calcularSalarioLiquido(salario);
            System.out.println("---------------------------------------------");
        }
    }
}