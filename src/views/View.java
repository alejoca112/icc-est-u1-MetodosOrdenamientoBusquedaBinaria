package views;
import java.util.Scanner;
import models.Person;

public class View {
    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("--- MENÚ ---");
        System.out.println("1. Ingresar Personas");
        System.out.println("2. Mostrar Personas");
        System.out.println("3. Ordenar Personas");
        System.out.println("4. Buscar Persona");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return inputInt();
    }

    public Person inputPerson() {
        String name = inputName();
        int age = inputAge();
        return new Person(name, age);
    }

    // CORREGIDO: Nombre cambiado de selectionSortingMethod a selectSortingMethod
    public int selectSortingMethod() { 
        System.out.println("--- MÉTODOS DE ORDENAMIENTO ---");
        System.out.println("1. POR NOMBRE (Burbuja)");
        System.out.println("2. POR NOMBRE (Selección Descendente)" );
        System.out.println("3. POR EDAD (Inserción)");
        System.out.println("4. POR NOMBRE (Inserción)");
        System.out.print("Seleccione un método: ");
        return inputInt();
    }

    public int selectSearchCriterion() {
        System.out.println("--- CRITERIOS DE BÚSQUEDA ---");
        System.out.println("1. Buscar por EDAD (Binaria)");
        System.out.println("2. Buscar por NOMBRE (Binaria)");
        System.out.print("Seleccione criterio: ");
        return inputInt();
    }

    public void displayPersons(Person[] people) {
        System.out.println("--- LISTA DE PERSONAS ---");
        if (people == null || people.length == 0) {
             System.out.println("No hay personas registradas.");
             return;
        }
        for (Person p : people) {
            System.out.println(p);
        }
    }

    public void displaySearchResult(Person person) { 
        if (person != null) {
            System.out.println("Persona encontrada: " + person);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public int inputAge() {
        System.out.print("Ingrese la edad: ");
        return inputInt();
    }

    public String inputName() {
        System.out.print("Ingrese el nombre: "); 
        return scanner.nextLine();
    }

    public int inputInt() {
        try {
            int val = Integer.parseInt(scanner.nextLine());
            return val;
        } catch (NumberFormatException e) {
            System.out.print("Entrada inválida, Ingrese de nuevo: ");
            return inputInt();
        }
    }
}
