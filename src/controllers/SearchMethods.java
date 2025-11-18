package controllers;
import models.Person;

public class SearchMethods {
    public Person binarySearchByAge(Person[] people, int targetAge) {
        int izquierda = 0;
        int derecha = people.length - 1;
        System.out.println("\n Valor Buscado por Edad: " + targetAge);
        System.out.println("(Visualizacion de Busqueda Binaria) \n");

        while(izquierda<= derecha){
            int medio = izquierda + (derecha - izquierda) / 2;
            int comparison = people[medio].getAge();
            //Imprimir visual 

            printVisualArray(people, izquierda, derecha);

            System.out.print("bajo: " + izquierda + " alto: " + derecha + "centro" + medio 
             + "valor Centro" + comparison + "\n");

            if(comparison == targetAge){
                System.out.println("--Encontrado--");
                return people[medio];
            } else if (comparison < targetAge) {
                System.out.println("DERECHA");
                izquierda = medio + 1;
            } else {
                System.out.println("IZQUIERDA");
                derecha = medio - 1;
            }
            System.out.println();            
        }
        return null; // No encontrado
    }

    

    public Person binarySearchByName(Person[] personas, String name) {
        int izquierda = 0;
        int derecha = personas.length - 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            String comparison = personas[medio].getName();
            int result = comparison.compareToIgnoreCase(name);

            if (result == 0) return personas[medio];
            if (result < 0) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return null;
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
