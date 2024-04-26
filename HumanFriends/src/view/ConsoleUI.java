package view;

import presenter.Presenter;
import view.menus.AnimalMenu;
import view.menus.ChooseAnimalMenu;
import view.menus.MainMenu;
import view.menus.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Введено не корректное значение!";
    private final Scanner scanner;
    private final Presenter presenter;
    private final MainMenu mainMenu;
    private final ChooseAnimalMenu chooseAnimalMenu;
    private final AnimalMenu animalMenu;
    private boolean work;
    private boolean workChooseAnimalMenu;
    private boolean workAnimalMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
        animalMenu = new AnimalMenu(this);
        chooseAnimalMenu = new ChooseAnimalMenu(this);
        work = true;
        workChooseAnimalMenu = true;
        workAnimalMenu = true;
    }

    @Override
    public void start() {
        hello();
        restart();
    }
    public void restart() {
        workChooseAnimalMenu = true;
        while (work){
            printMenu(mainMenu);
            executeRequest(mainMenu);
        }
    }

    private void hello() { System.out.println("Здравствуйте!");}
    private void printMenu(Menu menu) {
        System.out.println(menu.getMenu());
    }
    private void executeRequest(Menu menu) {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand, menu)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private boolean checkCommand(int numCommand, Menu menu){
        if (numCommand < menu.getSize() + 1){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
    @Override
    public void printAnswer(String text) { System.out.println(text);}
    public void finish() {
        if(presenter.saveAnimalsList()) {
            if(!presenter.saveCountAnimals()) System.out.println("Не удалось сохранить счетчик животных!");
        }
        else System.out.println("Не удалось сохранить список животных!");
        System.out.println("Досвидания!");
        work = false;
    }

    public void addAnimal() {
        while (workChooseAnimalMenu) {
            System.out.println("Выберите род животного:");
            printMenu(chooseAnimalMenu);
            executeRequest(chooseAnimalMenu);
        }
        restart();
    }
    private String setAnimalName() {
        String line = "";
        while (line.isEmpty()) {
            System.out.println("Введите имя животного:");
            line =  scanner.nextLine();
            if(line.isEmpty()) inputError();
        }
        return line;
    }
    private LocalDate setAnimalBirthData() {
        System.out.println("Введите дату рождения животного в формате 2000-10-10:");
        LocalDate birthData = null;
        while (birthData == null) {
            try {
                birthData = LocalDate.parse(scanner.nextLine());
            }
            catch (DateTimeParseException e) {
                inputError();
            }
        }
        return birthData;
    }
    private String setAnimalCommands() {
        System.out.println("Введите список команд, которые может выполнять животное(через ','):");
        return scanner.nextLine();
    }

    public void chooseAnimal() {
        String animalsListString = presenter.getAnimalsList();
        if(animalsListString.isEmpty()) {
            System.out.println("Список пуст.");
            restart();
        }
        else {
            String line = "";
            System.out.println("Выберите животное:");
            System.out.println(animalsListString);
            line = scanner.nextLine();
            if (checkCommand(line)) startAnimalMenu();
            else {
                inputError();
                chooseAnimal();
            }
        }
    }

    private boolean checkCommand(String line) {
        if (checkTextForInt(line)){
            int numAnimal = Integer.parseInt(line);
            return presenter.getAnimal(numAnimal);
        }
        else return false;
    }

    private void startAnimalMenu() {
        workAnimalMenu = true;
        while (workAnimalMenu) {
            presenter.getAnimal();
            printMenu(animalMenu);
            executeRequest(animalMenu);
        }
    }

    public void addCat() {
        if (presenter.addCat(setAnimalName(), setAnimalBirthData(), setAnimalCommands())) {
            System.out.println("Кошка успешно добавлена.");
        }
        else {
            System.out.println("Не удалось добавить кошку.");
        }
        workChooseAnimalMenu = false;
    }

    public void AddDog() {
        if (presenter.addDog(setAnimalName(), setAnimalBirthData(), setAnimalCommands())) {
            System.out.println("Собака успешно добавлена.");
        }
        else {
            System.out.println("Не удалось добавить собаку.");
        }
        workChooseAnimalMenu = false;
    }

    public void AddHamster() {
        if (presenter.addHamster(setAnimalName(), setAnimalBirthData(), setAnimalCommands())) {
            System.out.println("Хомяк успешно добавлен.");
        }
        else {
            System.out.println("Не удалось добавить хомяка.");
        }
        workChooseAnimalMenu = false;
    }

    public void AddHorse() {
        if (presenter.addHorse(setAnimalName(), setAnimalBirthData(), setAnimalCommands())) {
            System.out.println("Лошадь успешно добавлена.");
        }
        else {
            System.out.println("Не удалось добавить лошадь.");
        }
        workChooseAnimalMenu = false;
    }

    public void AddCamel() {
        if (presenter.addCamel(setAnimalName(), setAnimalBirthData(), setAnimalCommands())) {
            System.out.println("Верблюд успешно добавлен.");
        }
        else {
            System.out.println("Не удалось добавить верблюда.");
        }
        workChooseAnimalMenu = false;
    }

    public void AddDonkey() {
        if (presenter.addDonkey(setAnimalName(), setAnimalBirthData(), setAnimalCommands())) {
            System.out.println("Осёл успешно добавлен.");
        }
        else {
            System.out.println("Не удалось добавить осла.");
        }
        workChooseAnimalMenu = false;

    }

    public void getAnimalCommandsList() {
        presenter.getAnimalCommandsList();
    }

    public void returnInMainMenu() {
        workAnimalMenu = false;
        restart();
    }

    public void addAnimalCommand() {
        String line = "";
        while (line.isEmpty()) {
            System.out.println("Введите новую команду:");
            line =  scanner.nextLine();
            if(line.isEmpty()) inputError();
        }
        if(presenter.addAnimalCommand(line)) System.out.println("Команда добавлена.");
        else System.out.println("Не удалось добавить команду.");
    }

    public void showCountAnimals() {
        System.out.print("Общее кол-во животных: ");
        presenter.showCountAnimals();
        System.out.println();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

}
