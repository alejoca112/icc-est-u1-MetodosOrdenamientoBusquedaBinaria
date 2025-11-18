package controllers;
import models.Person;

public class SortingMethods {
    public void sortByAgeWithInsertion(Person[] people) {
        for (int i = 1; i < people.length; i++) {
            Person key = people[i];
            int j = i - 1;
            while (j >= 0 && people[j].getAge() > key.getAge()) {
                people[j + 1] = people[j];
                j = j - 1;
            }
            people[j + 1] = key;
        }
        System.out.println("Ordenado por edad (Metodo por Insercion Completado)");
    }

    public void sortByNameWithBubble(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].getName().compareTo(people[j + 1].getName()) > 0) {
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        System.out.println("Ordenado por nombre (Metodo Burbuja Completado)");
    }

    public void sortByNameWithSelectionDes(Person[] people){
        for (int i = 0; i < people.length - 1; i++) {
            int i_mayor = i;
            for (int j = i + 1; j < people.length; j++) {
                if (people[j].getName().compareTo(people[i_mayor].getName()) > 0) {
                    i_mayor = j;
                }
            }
            Person temp = people[i_mayor];
            people[i_mayor] = people[i];
            people[i] = temp;
        }
        System.out.println("Ordenado por nombre (Metodo Selección Descendente Completado)");
    }

    public void sortByNameWithInsertion(Person[] people) {
        for (int i = 1; i < people.length; i++) {
            Person key = people[i];
            int j = i - 1;
            while (j >= 0 && people[j].getName().compareTo(key.getName()) > 0) {
                people[j + 1] = people[j];
                j = j - 1;
            }
            people[j + 1] = key;
        }
        System.out.println("Ordenado por nombre (Metodo por Insercion Completado)");
    }

    
}
