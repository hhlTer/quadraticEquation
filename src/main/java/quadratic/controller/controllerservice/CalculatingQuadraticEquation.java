//package quadratic.controller.controllerservice;
//
//
//public class CalculatingQuadraticEquation {
//
//    private double valueA;
//    private double valueB;
//    private double valueC;
//
//    private double discriminant;
//    private double resultX1;
//    private double resultX2;
//
//    public CalculatingQuadraticEquation(double valueA, double valueB, double valueC){
//        this.valueA = valueA;
//        this.valueB = valueB;
//        this.valueC = valueC;
//        calculate();
//    }
//
//    private void calculate(){
//        this.discriminant = findDiscriminant();
//        if (discriminant < 0){
//            return;
//        }
//
//        if (discriminant==0){
//            resultX1 = resultX2 = -valueB / 2 * valueA;
//            return;
//        }
//
//        resultX1 = (-valueB + Math.pow(discriminant, 0.5)) / (2.0 * valueA);
//        resultX2 = (-valueB - Math.pow(discriminant, 0.5)) / (2.0 * valueA);
//    }
//
//    public void calculate(double valueA, double valueB, double valueC){
//        calculate();
//    }
//
//    public boolean isCalculating(){
//        return discriminant >= 0;
//    }
//
//    private double findDiscriminant(){
//        return valueB * valueB - 4 * valueA * valueC;
//    }
//
//    public double getRationalValueA() {
//        return valueA;
//    }
//
//    public double getRationalValueB() {
//        return valueB;
//    }
//
//    public double getRationalValueC() {
//        return valueC;
//    }
//
//    public double getRationalDiscriminant() {
//        return discriminant;
//    }
//
//    public double getResultX1() {
//        return resultX1;
//    }
//
//    public double getRationalRoot2() {
//        return resultX2;
//    }
//}
