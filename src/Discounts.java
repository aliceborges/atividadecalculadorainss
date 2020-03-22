import java.util.List;
import java.util.Map;

public class Discounts extends PercentageDiscountsAndRangeValues{
    private static double calculateValueWithDiscount(double discountPercentage, double value) {
        return value - value * discountPercentage / 100;
    }

    private static double applyDiscount(Map<Double, List<Double>>PercentageDiscountsAndRangeValues, double salary) {
        for (Map.Entry<Double, List<Double>> valorDesconto : PercentageDiscountsAndRangeValues.entrySet()) {
            double discountPercentage = valorDesconto.getKey();
            List<Double> salaryRange = valorDesconto.getValue();
            if (salary >= salaryRange.get(0) && salary <= salaryRange.get(1))
                salary = calculateValueWithDiscount(discountPercentage, salary);
        }

        return salary;
    }

    public static double calculateSalaryWithDiscounts(Funcionario funcionario) {
        double salaryWithDiscount = 0;
        Map<Double, List<Double>> valueDiscountsINSS = PercentageDiscountsAndRangeValues.INSS();
        Map<Double, List<Double>> valueDiscountsIRRF = PercentageDiscountsAndRangeValues.IRRF();

        salaryWithDiscount = applyDiscount(valueDiscountsINSS, funcionario.getSalarioBruto());
        funcionario.setDescontoInss(funcionario.getSalarioBruto() - salaryWithDiscount);

        salaryWithDiscount = applyDiscount(valueDiscountsIRRF, funcionario.getSalarioBruto()-funcionario.getDescontoInss());
        funcionario.setDescontoIrrf(funcionario.getSalarioBruto() - funcionario.getDescontoInss() - salaryWithDiscount);

        funcionario.setSalarioLiquido(salaryWithDiscount);

        // Caso nenhum desconto tenha sido aplicado, retorna o salário enviado a função
        if (salaryWithDiscount == 0) {
            funcionario.setSalarioLiquido(funcionario.getSalarioBruto());
            return funcionario.getSalarioBruto();
        }
        return salaryWithDiscount;
    }
}
