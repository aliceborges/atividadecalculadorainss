import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentageDiscountsAndRangeValues {
    public static Map<Double, List<Double>> INSS() {
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

    public static Map<Double, List<Double>> IRRF() {
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
}
