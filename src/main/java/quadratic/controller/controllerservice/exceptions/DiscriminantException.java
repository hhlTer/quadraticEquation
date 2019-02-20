package quadratic.controller.controllerservice.exceptions;

public class DiscriminantException extends Exception {

    double discriminant;

    public DiscriminantException(double discriminant){
        this.discriminant = discriminant;
    }

    public DiscriminantException(){}

    @Override
    public String toString() {
        return discriminant == 0 ? "Discriminant less tan 0" : "Discriminant " + discriminant + " less than 0";
    }
}
