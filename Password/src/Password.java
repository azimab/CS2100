//Azim Abdulmajeeth
//zwf8qy@virginia.edu
//HW 8 - Recursion
//Resources: none
public class Password {
    private String curPassword;

    private boolean containsDigit (String password) { //checks to see if the password contains a digit
        if (password.isEmpty()) { //base case, an empty string cannot contain a digit
            return false;
        }
        else if (Character.isDigit(password.charAt(0))) {//if the password contains a digit it will return true
            return true;
        }
        return containsDigit(password.substring(1));//calls the function again, but makes the string smaller by 1 so the next character can be checked
    }

    private boolean isEqual (String curPass, String newPass) { //recursive function to check if two passwords are equal
        if (curPass.length() != newPass.length()) {
            return false;
        }
        else if (curPass.isEmpty()) { //base case, returns true if all the characters are equal
            return true;
        }
        else if (curPass.charAt(0) == newPass.charAt(0)) { //if the characters are equal, it will check the next set of characters
            return (isEqual(curPass.substring(1),newPass.substring(1)));
        }
        else {
            return false;
        }
    }

    private int difference (String curPass, String newPass) {
        if (curPass.isEmpty() && newPass.isEmpty()) { //base case, returns nothing if both passwords are empty
            return 0;
        }
        if (curPass.isEmpty()) { //returns the difference in length if either password is longer
            return newPass.length();
        }
        if (newPass.isEmpty()) {
            return curPass.length();
        }

        int diff = 0;
        if (curPass.charAt(0) != newPass.charAt(0)) { //if the characters are different, difference will increase by 1
             diff++;
        }

        return diff + difference(curPass.substring(1), newPass.substring(1)); //call the function again to check the next character
    }

    private boolean isDifferent (String curPass, String newPass, int threshold) {
        return difference(curPass, newPass) >= threshold; //call the difference method to see if it meets the minimum threshold for difference
    }

    public Password () { //default constructor, creates an empty password
        curPassword = "";
    }

    public Password (String password) { //overloaded constructor, makes sure there is no
        if ( containsDigit(password) ) { //password must contain a digit
            curPassword = password;
        }
        else {
            curPassword = "";
        }
    }

    public String toString () { //returns a hidden version of the passwords with a random number of asterisks
        int numAsterisks = (int) (Math.random() * 20) + 1; //generate a random number between 1 and 20
        String password = curPassword.substring(0,1);
        for (int i = 0; i < numAsterisks; i++) {
            password += "*"; //add the random number of asterisks to the string
        }
        return  password + curPassword.charAt(curPassword.length()-1);
    }

    public String getPassword () { //accessor method for password
        return curPassword;
    }
    public boolean equals (Object o) { //checks if the two passwords are equal
        if (o instanceof Password) {
            return isEqual(curPassword, ((Password) o).getPassword());
        }
        return false;
    }
    public boolean setPassword (String password) { //sets a new password if the conditions are met
        if (containsDigit(password) && isDifferent(password, curPassword, curPassword.length()/2 )) {//checks to make sure password contains a digit and is sufficiently different
            curPassword = password;
            return true;
        }
        return false;
    }
}
