public class Data {

    private Data() {
    }

    public static boolean validate(String login,
                                   String password,
                                   String confirmPassword) {
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginExeption | WrongPasswordExeption e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static final String VALID_CHARACTERS = "QqWwEeRrTtYyUuIiOoPpAaSsDdFfGgHhJjKkLlZzXxCcVvBbNnMm0123456789_";

    private static boolean validate(String s) {
        if (s.length() > 20) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    private static void check(String login,
                              String password,
                              String confirmPassword) throws WrongLoginExeption, WrongPasswordExeption {
        if (!validate(login)) {
            throw new WrongLoginExeption("Логин не подходит!");
        }
        if (!validate(password)) {
            throw new WrongPasswordExeption("Пароль не подходит!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordExeption("Пароли не совпадают!");
        }
    }


}
