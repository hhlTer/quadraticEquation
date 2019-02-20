package quadratic.service.applicationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quadratic.model.representanion.RationalFraction;

import java.math.BigDecimal;
import java.util.TreeMap;

/**
 * calculate and convert double value into rational fraction and in back way
 *
 * included two methods:
 *
 * 1) RationalFraction convertToRational(double value)
 * calculate and return RationalFraction object, with three int values: whole numerator/denominator
 *
 * 2) double convertToDouble(RationalFraction rf)
 * calculate and return double value
 */

public class RationalConverter {

    private static TreeMap<Double, RationalFraction> rationalFractionTreeMap = new TreeMap<>();

    private static int staticDenominator, staticNumerator;

    public static RationalFraction convertToRational(double value){
        if (rationalFractionTreeMap.containsKey(value)){
            return rationalFractionTreeMap.get(value);
        }

        RationalFraction rationalValue = new RationalFraction();
        rationalValue.setWhole(separateWhole(value));
        initNumeratorAndDenominator(value);
        rationalValue.setDenominator(staticDenominator);
        rationalValue.setNumerator(staticNumerator);
        rationalFractionTreeMap.put(value, rationalValue);
        return rationalValue;
    }

    public static double convertToDouble(RationalFraction rationalValue){
        return (double) rationalValue.getWhole() + (double) rationalValue.getNumerator()/rationalValue.getDenominator();
    }

    private static int separateWhole(double value) {
        return (int) value;
    }

    private static void initNumeratorAndDenominator(double value) {

        //calculate Num and Denominator by value

        //delete `-` if exist;
        value = normalizeValue(value);

        BigDecimal bd = new BigDecimal("" + value);
        int numerator = 0;
        int denominator = 0;
        //TODO
//        value = (value - (int)value);
        double whole = (int)value;
        double newVal = (double) value - (double) whole;
        value = bd.subtract(new BigDecimal("" + (int)value)).doubleValue();
        final long MAX_VALUE_OF_DENOMINATOR = Integer.MAX_VALUE;
        double temp;

        for (int i = 2; i < MAX_VALUE_OF_DENOMINATOR; i++) {
            temp = value*i;
            if (temp - (int)temp == 0){
                numerator = (int)temp;
                denominator = i;
                break;
            }
        }

        staticNumerator = numerator;
        staticDenominator = numerator == 0? 0 : denominator;
    }

    private static double normalizeValue(double value) {
        return value < 0 ? value*-1 : value;
    }


}
