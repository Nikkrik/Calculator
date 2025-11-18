package rgr.calculator.model;

public class Calculator {
    private double result;

    public Calculator() {
        this.result = 0 ;
    }

    public double plus(double a, double b){
        result = a + b;
        return result;
    }

    public double minus(double a, double b){
        result = a - b;
        return result;
    }

    public double mult(double a, double b){
        result = a * b;
        return result;
    }

    public double div(double a, double b){
        if(b !=0){
            result = a / b;
        } else {
            result = 0;
        }
        return result;
    }
    public double getResult(){
        return result;
    }
}
