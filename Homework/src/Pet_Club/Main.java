package Pet_Club;

import java.util.*;

public class Main {
    static ZooClub zooClub = new ZooClub();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loop:
        while (true) {
            printCommandList();
            System.out.println("Введите команду:");
            String command = scanner.next();

            switch (command) {
                case "create":
                    create_member();
                    break;
                case "show":
                    System.out.println(zooClub.personListMap);
                    break;
                case "add":
                    addPetTo_Person();
                    break;
                case "remove":
                    remove_pet();
                    break;
                case "dell":
                    remove_person();
                    break;
                case  "clear":
                    remove_allPet();
                    break;
                case "exit":
                    System.out.println("bye-bye");
                    break loop;
                default:
                    System.out.println("Я не знаю этой комманды, введите еще раз");
                    break;
            }
        }
    }

    private static void printCommandList() {
        System.out.println("========= Список комманд =========");
        System.out.println("create: добавить участника");
        System.out.println("show: список участников");
        System.out.println("add: добавить участнику животное");
        System.out.println("remove: удалить у участника животное");
        System.out.println("dell: удалить у участника");
        System.out.println("clear: удалить всех животных");
        System.out.println("exit: выход");
        System.out.println("==================================");
    }

    public static void create_member() {
        System.out.println("Введите имя:");
        String name = scanner.next();
        Person person = zooClub.createPerson(name);
        System.out.println("Вы успешно создали члена клуба: " + person);
    }

    public static void addPetTo_Person() {
        System.out.println("введите имя участника: ");
        String name = scanner.next();
        System.out.println("Введите имя животного: ");
        String namePet = scanner.next();
        zooClub.addPetToPerson(name, namePet);
        System.out.println("Вы добавили участнику :" + name + " животное: " + namePet);
    }

    public static void remove_pet() {
        System.out.println("Введите животного котого хотите удалить: ");
        String namePet = scanner.next();
        System.out.println("Введите имя участника: ");
        String name = scanner.next();
        zooClub.remove_pet(namePet, name);
        System.out.println("Вы удалили у участника: " + name + " животное: " + namePet);
    }

    public static void remove_person() {
        System.out.println("введите участника которого хотите удалить: ");
        String name = scanner.next();
        zooClub.removePerson(name);
        System.out.println("Вы удалили участника клуба: " + name);
    }
    public static void remove_allPet(){
        System.out.println("Введите имя животного которое хотите удалить у всех участников: ");
        String namePet = scanner.next();
        zooClub.removeAllPet(namePet);
        System.out.println("Вы удалили животное у всех участников: " + namePet);
    }

}