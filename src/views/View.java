package views;
import java.util.Scanner;
import models.Person;

public class View {
    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Ingresar Personas");
        System.out.println("2. Mostrar Personas");
        System.out.println("3. Ordenar Personas");
        System.out.println("4. Buscar Persona");
        System.out.println("100. Salir");
        System.out.print("Seleccione una opción: ");
        return inputInt();
    }

    public Person inputPerson() {
        String name = inputName();
        int age = inputAge();
        return new Person(name, age);
    }

    public int selectionSortingMethod() {
        System.out.println("\n--- MÉTODOS DE ORDENAMIENTO ---");
        System.out.println("1. POR NOMBRE (Burbuja)");
        System.out.println("2. POR NOMBRE(Selección Descendente)" );
        System.out.println("3. POR EDAD(Inserción)");
        System.out.println("4. POR NOMBRE(Insercion)");
        System.out.print("Seleccione un método: ");
        return inputInt();
    }

    public int selectSearchCriterion() {
        System.out.println("\n--- CRITERIOS DE BÚSQUEDA ---");
        System.out.println("1. Buscar por EDAD(Binaria)");
        System.out.println("2. Buscar por NOMBRE (Binaria)");
        System.out.print("Seleccione criterio: ");
        return inputInt();
    }
    public void displayPersons(Person[] people) {
        System.out.println("\n--- LISTA DE PERSONAS ---");
        for (Person p : people) {
            System.out.println(p);
        }
    }

    public void displayResult(Person person) {
        if (person != null) {
            System.out.println("\nPersona encontrada: " + person);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public int inputAge() {
        System.out.print("Ingrese la edad: ");
        return inputInt();
    }

    public String inputName() {
        System.out.println("Ingrese el nombre: ");
        return scanner.nextLine();
    }

    public int inputInt() {
        try {
            int val = Integer.parseInt(scanner.nextLine());
            return val;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida, Ingrese de nuevo.");
            return inputInt();
        }

    }
}
