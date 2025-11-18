package controllers;
import models.Person;
import views.View;


public class Controller {
    private View view;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;
    private Person[] people;
    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        this.people = new Person[0];
    }

    public void start() {
        int option = 0;
        while (option != 5) {
            option = view.showMenu();
            switch (option) {
                case 1:
                    inputPersons();
                    break;
                case 2:
                    view.displayPersons(people);
                    break;
                case 3:
                    sortPersons();
                    break;
                case 4:
                    searchPerson();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public void inputPersons() {
        int n = view.inputInt();
        people = new Person[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Persona: " + (i + 1) + " :");
            people[i] = view.inputPerson();
        }
    }

    public void sortPersons() {
        int method = view.selectionSortingMethod();
        if(people == null || people.length == 0) return;
        switch (method) {
            case 1:
                sortingMethods.sortByNameWithBubble(people);
                break;
            case 2:
                sortingMethods.sortByNameWithSelectionDes(people);
                break;
            case 3:
                sortingMethods.sortByAgeWithInsertion(people);
                break;
            case 4:
                sortingMethods.sortByNameWithInsertion(people);    
            default:
                System.out.println("Método no válido");
        }
    }

    public void searchPerson() {
        if(people == null || people.length == 0) return;

        int criterion = view.selectSearchCriterion();
        Person result = null;

        if(criterion == 1) {
            int age = view.inputAge();
            result = searchMethods.binarySearchByAge(people, age);
        }
        view.displayResult(result);
    }

    



    
}
