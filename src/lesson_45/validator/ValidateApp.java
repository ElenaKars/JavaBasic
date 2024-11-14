package lesson_45.validator;

public class ValidateApp {

    public static void main(String[] args) {

        // Получаем email от пользователя (Сканером, из другого слоя приложения).
        String email = "test@email.com";
        String password = "1234" ;

        // Валидация email
        try {
            UserValidator.isEmailValid(email);
            // Если мы дойдем до этой строчки кода,
            // значит email валидный
            System.out.println("Email прошел проверку");
            // User user = new User(email, password)
        } catch (EmailValidateException e) {
            // email не прошел проверку.
            // Запросить у пользователя другой ввод
            System.out.println("Email is not valid");
            String message = e.getMessage();
            System.out.println(message);
        }
        try {
            UserValidator.isPasswordValid(password);
            System.out.println("Password прошел проверку");
        } catch (PasswordValidateException e) {
            System.out.println("Password is not valid");
            String message = e.getMessage();
            System.out.println(message);
        }

    }

}
