import java.util.*;

public class Funcionario {
    private String nomeFuncionario;
    private double salarioBruto;
    private double descontoInss;
    private double descontoIrrf;
    private double salarioLiquido;

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getDescontoInss() {
        return descontoInss;
    }

    public void setDescontoInss(double descontoInss) {
        this.descontoInss = descontoInss;
    }

    public double getDescontoIrrf() {
        return descontoIrrf;
    }

    public void setDescontoIrrf(double descontoIrrf) {
        this.descontoIrrf = descontoIrrf;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }
}
