package quadratic.model.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quadratic_data_merged")
@IdClass(PK.class)
@Proxy(lazy = false)
public class QuadraticEquationData implements Serializable {

    @Id
    private double valueA;

    @Id
    private double valueB;

    @Id
    private double valueC;

    @Column(name = "result_X1")
    private double result;

    @Column(name = "result_X2")
    private double resultX2;

    @Column(name = "discriminant")
    private double discriminant;

    public double getValueA() {
        return valueA;
    }

    public void setValueA(double valueA) {
        this.valueA = valueA;
    }

    public double getValueB() {
        return valueB;
    }

    public void setValueB(double valueB) {
        this.valueB = valueB;
    }

    public double getValueC() {
        return valueC;
    }

    public void setValueC(double valueC) {
        this.valueC = valueC;
    }

    public double getRoot1() {
        return result;
    }

    public void setRoot1(double result) {
        this.result = result;
    }

    public double getRoot2() {
        return resultX2;
    }

    public void setRoot2(double resultX2) {
        this.resultX2 = resultX2;
    }

    public double getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(double discriminant) {
        this.discriminant = discriminant;
    }

    public void setId(PK pk){
        this.valueA = pk.getValueA();
        this.valueB = pk.getValueB();
        this.valueC = pk.getValueC();
    }

    public PK getId(){
        return new PK(valueA, valueB, valueC);
    }
}
