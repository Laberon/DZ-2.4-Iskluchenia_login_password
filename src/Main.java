import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String login = "s3";
        String password = "df3";
        String confirmPassword = "df3";
        System.out.println(check(login, password, confirmPassword));
        Scanner loginIn = new Scanner(System.in);
        System.out.println("Введите логин не более 20-ти символов:");
        String login1 = loginIn.nextLine();
        System.out.println("Логин: "+login1);
        Scanner passwordIn = new Scanner(System.in);
        System.out.println("Введите пароль не более 20-ти символов:");
        String password1 = passwordIn.next();
        Scanner confirmPasswordIn = new Scanner(System.in);
        System.out.println("Повторите пароль");
        String confirmPassword1 = confirmPasswordIn.next();
        System.out.println(check(login1, password1, confirmPassword1));
    }

    public static boolean check(String login, String password, String checkPassword) {
        try {
            if (login.toCharArray().length > 20) {
                throw new WrongLoginException("Логин слишком длинный");
            }
            if (password.toCharArray().length > 20 || checkPassword.toCharArray().length > 20) {
                throw new WrongPasswordException("Пароль слишком длинный");
            }
            if (!login.matches("\\w{1,20}")) {
                throw new WrongLoginException("Логин не соответсвует");
            }
            if (!password.matches("\\w{1,20}") || !checkPassword.matches("\\w{1,20}")) {
                throw new WrongPasswordException("Пароль не подходит");
            }
            if (!password.equals(checkPassword)) {
                throw new WrongPasswordException("Пароль не совпадает");
            }
        } catch (WrongLoginException | WrongPasswordException wrongLoginPasswordException) {
            System.out.println(wrongLoginPasswordException.getMessage());
            return false;
        }
        return true;
    }
}