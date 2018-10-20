/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;

/**
 *
 * @author pretto
 */
public class Validacao {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }
    
    public static boolean validarEmail(String email)
    {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    public static boolean validarCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }
        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean validarCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }
        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    public static boolean validarData(int d, int m, int a) {
        boolean correto = true;
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (a < 0 || m < 1 || m > 12) {
            correto = false;
        } else {
            // valida o dia
            if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                dias[1] = 29;
            }
            if (d < 1 || d > dias[m - 1]) {
                correto = false;
            }
        }
        return (correto);
    }

    public static boolean validarTelefone(JFormattedTextField campo) {
        if (campo.getText().trim().length() < 14) {
            Formatacao.reformatarTelefone(campo);
            return false;
        }
        return true;
    }
    
    
       public static boolean validarCEP(JFormattedTextField campo) {
        if (campo.getText().trim().length() < 9) {
            Formatacao.reformatarCEP(campo);
            return false;
        }
        return true;
    }
       
    public static boolean validarIdentidade(String campo) {
        if (campo.trim().length() < 10) {
            return false;
        }
        return true;
    }
    
      public static boolean validarNumeros (String str) {
         for(int i=0;i<str.length();i++ ) {
             if(str.matches("[0-9]+")) {
               return true;
             }
         }
         return false;
      }
    
    public static boolean validarData(String data) {
    try {
    //SimpleDateFormat é usada para trabalhar com formatação de datas
    //neste caso o formatador irá utilizar o formato "dd/MM/yyyy"
    //dd = dia, MM = mes, yyyy = ano
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    //a mágica desse método acontece aqui, pois o setLenient() é usado para setar
    //sua escolha sobre datas estranhas, quando eu seto para "false" estou dizendo
    //que não aceito datas falsas como 31/02/2018
    sdf.setLenient(false);
    //aqui eu tento converter a String em um objeto do tipo date, se funcionar
    //sua data é valida
    sdf.parse(data);
    //se nada deu errado retorna true (verdadeiro)
    return true;
    } catch (ParseException ex) {
    //se algum passo dentro do "try" der errado quer dizer que sua data é falsa, então,
    //retorna falso
    return false;
    }
    }
}
