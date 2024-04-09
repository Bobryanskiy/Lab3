import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    enum Sex {Man, Woman, Unknown}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String secondName = scanner.next();
        String patronymic = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = null;
        try {
            birthday = LocalDate.parse(scanner.next(), formatter);
        } catch (Exception e) {
            System.exit(1);
        }
        LocalDate today = LocalDate.now();
        Sex sex;
        if (patronymic.endsWith("ична") || patronymic.endsWith("инична") || patronymic.endsWith("вна")) {
            sex = Sex.Woman;
        }
        else if (patronymic.endsWith("ич")) sex = Sex.Man;
        else sex = Sex.Unknown;
        System.out.println("Ваш пол: " + sex);
        System.out.println("Ваш возраст: " + Period.between(birthday, today).getYears());
    }
}