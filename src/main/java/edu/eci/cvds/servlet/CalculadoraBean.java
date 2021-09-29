
package edu.eci.cvds.servlet;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;
import java.lang.Math.*;
import java.util.ArrayList;


/**
 *
 * @author David Perez & Nicolas Camacho
 */
@ManagedBean(name = "CalculadoraBean")
@ApplicationScoped
public class CalculadoraBean {
    private ArrayList<Double> numeros;
    private double mode;
    private double mean;
    private double variance;
    private double standar;
    private int length;
    
    public void calculate(String lista){
        try{ 
            numeros = new ArrayList<Double>();
            String[] array =lista.split(";");
            for (String string: array){
                numeros.add(Double.parseDouble(string));
            }
            calculateAll();
                    
        }
        catch (Exception e){
            restart();
        }
    }
    
    public void calculateMean(ArrayList<Double> lista){
        mean = 0;
        for (Double numero: lista){
            mean = mean + numero;
        }
        mean = mean / length;
    }
    
    public double calculateVariance(ArrayList<Double> lista){
        double a = 0;
        variance = 0;
        for (Double numero: lista){
            a= a + Math.pow(mean -numero, 2f);
        }
        variance = a /(length-1);
        return variance;
    }
    
    public void calculateMode(ArrayList<Double> lista){
        int veces = -1,cuenta;
        mode = 0;
        for (int i =0; i<length ; i++){
            double a = numeros.get(i);
            cuenta =0;
            for (int j=i ; j<length; j++){
                if (lista.get(j) == a){
                    cuenta++;
                }
            }
            if (cuenta > veces){
                mode = a;
                veces = cuenta;
            }
        }
    }
    
    public void setNumbers(ArrayList<Double> numbers) {
        this.numeros = numbers;
        setLength(numbers.size());
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    public void calculateStandardDeviation(ArrayList<Double> lista){
        standar = Math.sqrt(calculateVariance(lista));
    }
    
    public void calculateAll(){
        setNumbers(numeros);
        calculateMean(numeros);
    	calculateMode(numeros);
    	calculateVariance(numeros);
    	calculateStandardDeviation(numeros);
    }
    
    public double getMode(){
        return mode;
    }
    public double getMean(){
        return mean;
    }
    public double getVariance(){
        return variance;
    }
    public double getStandarDeviation(){
        return standar;
    }
    public int getLength(){
        return length;
    }
    
    public void setMode(double mode){
        this.mode = mode;
    }
    public void setMean(double mean){
        this.mean = mean;
    }
    public void setVariance(double variance){
        this.variance = variance;
    }
    public void setStandarDeviation(double standar){
        this.standar = standar;
    }
    
    public void restart(){
        numeros = new ArrayList<Double>();
        numeros.add(0.0);
        calculateAll();
    }
    
}
