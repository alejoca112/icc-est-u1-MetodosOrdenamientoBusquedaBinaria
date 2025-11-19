package controllers;
import models.Person;

public class SearchMethods {
    public Person binarySearchByAge(Person[] people, int targetAge) {
        int izquierda = 0;
        int derecha = people.length - 1;
        System.out.println(" Valor Buscado por Edad: " + targetAge);
        System.out.println("(Visualizacion de Busqueda Binaria)");

        while(izquierda<= derecha){
            int medio = izquierda + (derecha - izquierda) / 2;
            int comparison = people[medio].getAge();
            //Imprimir visual 

            printVisualArray(people, izquierda, derecha);

            System.out.print("bajo: " + izquierda + " alto: " + derecha + " centro: " + medio 
             + " valor comparado: " + comparison);

            if(comparison == targetAge){
                System.out.println("--Encontrado--");
                return people[medio];
            } else if (comparison < targetAge) {
                System.out.println(" -> DERECHA");
                izquierda = medio + 1;
            } else {
                System.out.println(" ->IZQUIERDA");
                derecha = medio - 1;
            }
            System.out.println();            
        }
        return null; // No encontrado
    }

    

    public Person binarySearchByName(Person[] people, String name) {
        int izquierda = 0;
        int derecha = people.length - 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            String comparison = people[medio].getName();
            int result = comparison.compareToIgnoreCase(name);

            if (result == 0) return people[medio];
            if (result < 0) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return null;
    }

    public boolean isSortedByAge(Person[] people){
        for(int i = 0; i < people.length - 1; i++){
            if(people[i].getAge() > people[i+1].getAge()){
                return false;
            }
        }
        return true;
    }

    public boolean isSortedByName(Person[] people){
        for(int i = 0; i < people.length - 1; i++){
            if(people[i].getName().compareToIgnoreCase(people[i+1].getName()) > 0){
                return false;
            }
        }
        return true;
    }

    public void printVisualArray(Person[] people, int izquierda, int derecha) {
        for (int i = izquierda; i < derecha; i++) {
            System.out.println(people[i].getAge());
            if (i < derecha) {
                System.out.print(" | ");
            }
        }
        System.out.println();
    }
}
