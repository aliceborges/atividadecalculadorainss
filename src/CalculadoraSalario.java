import java.util.*;
import java.text.DecimalFormat;

public class CalculadoraSalario extends Funcionario{

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        Scanner input = new Scanner(System.in);

        System.out.print("Nome do funcionário: ");
        funcionario.setNomeFuncionario(input.nextLine());

        System.out.print("Salário: R$");
        funcionario.setSalarioBruto(input.nextDouble());
        Discounts.calculateSalaryWithDiscounts(funcionario);

        System.out.println("\nInformações salariais do(a) funcionário(a) " + funcionario.getNomeFuncionario() + ": ");
        System.out.println("Salário bruto: " + Utils.formatValueBRL(funcionario.getSalarioBruto()));
        System.out.println("Desconto INSS: " + Utils.formatValueBRL(funcionario.getDescontoInss()));
        System.out.println("Desconto IRRF: " + Utils.formatValueBRL(funcionario.getDescontoIrrf()));
        System.out.println("Salário líquido: " + Utils.formatValueBRL(funcionario.getSalarioLiquido()));
    }
}