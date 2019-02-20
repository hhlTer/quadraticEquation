//package quadratic.model.domain;
//
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="quadratic_data")
//public class QuadraticData {
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(name = "value_a")
//    private double valueA;
//
//    @Column(name = "value_b")
//    private double valueB;
//
//    @Column(name = "value_c")
//    private double valueC;
//
//    @Column(name = "result_x1")
//    private double resultX1;
//
//    @Column(name = "result")
//    private double resultX2;
//
//    @Column(name = "discriminant")
//    private double discriminant;
//
//    public double getRationalDiscriminant() {
//        return discriminant;
//    }
//
//    public void setDiscriminant(double discriminant) {
//        this.discriminant = discriminant;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public double getRationalValueA() {
//        return valueA;
//    }
//
//    public void setValueA(double valueA) {
//        this.valueA = valueA;
//    }
//
//    public double getRationalValueB() {
//        return valueB;
//    }
//
//    public void setValueB(double valueB) {
//        this.valueB = valueB;
//    }
//
//    public double getRationalValueC() {
//        return valueC;
//    }
//
//    public void setValueC(double valueC) {
//        this.valueC = valueC;
//    }
//
//    public double getResultX1() {
//        return resultX1;
//    }
//
//    public void setResultX1(double resultX1) {
//        this.resultX1 = resultX1;
//    }
//
//    public double getRationalRoot2() {
//        return resultX2;
//    }
//
//    public void setRoot2(double resultX2) {
//        this.resultX2 = resultX2;
//    }
//}
