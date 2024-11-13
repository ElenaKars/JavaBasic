package lesson_45.validator;

public class PasswordValidator {
    public static void isPasswordValid(String password) throws PasswordValidateException {

        if (password == null) {
            throw new PasswordValidateException("Password cannot be empty");
        }
        if(password.length() < 8){
            throw new PasswordValidateException("Password must be at least 8 characters long");
        }

        boolean isDigit = false;
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isSpecialSymbol = false;

        String symbols = "!%$@&*()[].,-";
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isDigit(ch)) isDigit = true;
            if (Character.isUpperCase(ch)) isUpperCase = true;
            if (Character.isLowerCase(ch)) isLowerCase = true;
            if (symbols.indexOf(ch) >= 0) isSpecialSymbol = true;
        }

        if (!isDigit) throw new PasswordValidateException("The password must be a digit");
        if (!isUpperCase)
            throw new PasswordValidateException("The password must include at least one uppercase letter");
        if (!isLowerCase)
            throw new PasswordValidateException("The password must include at least one lowercase letter");
        if (!isSpecialSymbol)
            throw new PasswordValidateException("The password must include at least one special symbol");

    }
}


