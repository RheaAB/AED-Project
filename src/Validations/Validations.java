package Validations;

import java.util.regex.Pattern;

/**
 *
 * @author gandh
 */
public class Validations {

    public static boolean ValidateName(String Name) {
        if (!Pattern.compile("^[a-zA-Z]+( [a-zA-Z]+)*$").matcher(Name).matches()) {
            return false;
        }
        return true;

    }

    public static boolean ValidateID(String PatientID) {
        if (!Pattern.compile("\\d{4}").matcher(PatientID).matches()) {
            return false;
        }
        return true;

    }

    public static boolean ValidateAge(String Age) {
        if (!Pattern.compile("\\d{2}").matcher(Age).matches()) {

            return false;
        }
        return true;
    }

    public static boolean ValidatePassword(String Password) {
        if (!Pattern.compile("^[0-9a-zA-Z]{6}").matcher(Password).matches()) {

            return false;
        }
        return true;
    }

    public static boolean ValidateAddress(String Address) {
        if (!Pattern.compile("^[a-zA-Z0-9_]+$").matcher(Address).matches()) {

            return false;
        }
        return true;
    }

    public static boolean ValidateCommunity(String Community) {
        if (!Pattern.compile("^[a-zA-Z]+$").matcher(Community).matches()) {
            return false;
        }
        return true;
    }

    public static boolean ValidateContactNumber(String ContactNumber) {
        if (!Pattern.compile("\\d{10}").matcher(ContactNumber).matches()) {
            return false;
        }
        return true;
    }

    public static boolean ValidateEmail(String Email) {
        if (!Pattern.compile("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$").matcher(Email).matches()) {
            return false;
        }
        return true;
    }

    public static boolean ValidateCity(String City) {
        if (!Pattern.compile("^[a-zA-Z]+$").matcher(City).matches()) {

            return false;
        }
        return true;
    }

}