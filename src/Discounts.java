import java.util.List;
import java.util.Map;

public class Discounts extends PercentageDiscountsAndRangeValues{
    private static double calculateValueWithDiscount(double discountPercentage, double value) {
        return value - value * discountPercentage / 100;
    }

    private static double applyDiscount(Map<Double, List<Double>>PercentageDiscountsAndRangeValues, double salary) {
        // Percorre as faixas salariais e descontos
        for (Map.Entry<Double, List<Double>> valorDesconto : PercentageDiscountsAndRangeValues.entrySet()) {
            double discountPercentage = valorDesconto.getKey();
            List<Double> salaryRange = valorDesconto.getValue();
            // Se o salário está entre a faixa salarial, aplica o desconto
            if (salary >= salaryRange.get(0) && salary <= salaryRange.get(1))
                salary = calculateValueWithDiscount(discountPercentage, salary);
        }

        return salary;
    }

    public static double calculateSalaryWithDiscounts(Funcionario funcionario) {
        double salaryWithDiscount = 0;
        // Pega todos os descontos com suas faixas salariais
        Map<Double, List<Double>> valueDiscountsINSS = PercentageDiscountsAndRangeValues.INSS();
        Map<Double, List<Double>> valueDiscountsIRRF = PercentageDiscountsAndRangeValues.IRRF();

        // Aplica o desconto do INSS sob o salário bruto
        salaryWithDiscount = applyDiscount(valueDiscountsINSS, funcionario.getSalarioBruto());
        // Salva a diferença entre o salário bruto e o novo valor com o desconto dentro do desconto do INSS
        funcionario.setDescontoInss(funcionario.getSalarioBruto() - salaryWithDiscount);

        // Aplica o desconto do imposto de renda sob o valor resultante
        salaryWithDiscount = applyDiscount(valueDiscountsIRRF, funcionario.getSalarioBruto()-funcionario.getDescontoInss());
        // Salva a diferença entre o salário bruto e o novo valor (com desconto do inss) dentro do desconto do IRRF
        funcionario.setDescontoIrrf(funcionario.getSalarioBruto() - funcionario.getDescontoInss() - salaryWithDiscount);

        // Salva o salário líquido
        funcionario.setSalarioLiquido(salaryWithDiscount);

        // Caso nenhum desconto tenha sido aplicado, retorna o salário enviado a função
        if (salaryWithDiscount == 0) {
            funcionario.setSalarioLiquido(funcionario.getSalarioBruto());
            return funcionario.getSalarioBruto();
        }
        return salaryWithDiscount;
    }
}
