package org.example;

import org.example.DAO.AnimalDAOImpl;
import org.example.DAO.FamiliaDAOImpl;
import org.example.entities.Animal;
import org.example.entities.Familia;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static AnimalDAOImpl animalDAO = new AnimalDAOImpl();
    private static FamiliaDAOImpl familiaDAO = new FamiliaDAOImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Registrar nuevo animal");
            System.out.println("2. Buscar animales por especie");
            System.out.println("3. Actualizar estado de un animal");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarAnimal();
                    break;
                case 2:
                    buscarAnimalesPorEspecie();
                    break;
                case 3:
                    actualizarEstadoAnimal();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void registrarAnimal() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos del animal
        System.out.print("Nombre del animal: ");
        String nombre = scanner.nextLine();
        System.out.print("Especie: ");
        String especie = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
          /*
        // Solicitar datos de la familia
        System.out.print("Nombre de la familia: ");
        String nombreFamilia = scanner.nextLine();

        Familia familia = familiaDAO.findById(nombreFamilia);

        // Si la familia no existe, crearla
        if (familia == null) {
            System.out.println("La familia no existe, creando una nueva.");
            System.out.print("Edad de la familia: ");
            int edadFamilia = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            System.out.print("Ciudad de la familia: ");
            String ciudadFamilia = scanner.nextLine();
            familia = new Familia(nombreFamilia, edadFamilia, ciudadFamilia);
            familiaDAO.save(familia);
        }
*/

        // Crear el animal
        Animal animal = new Animal(nombre, especie, edad, descripcion, estado);
        animal.setFamilia(null);
        animalDAO.save(animal);
        System.out.println("Animal registrado con éxito.");
    }

    public static void buscarAnimalesPorEspecie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Especie a buscar: ");
        String especie = scanner.nextLine();
        List<Animal> animales = animalDAO.findByEspecie(especie);

        if (animales.isEmpty()) {
            System.out.println("No se encontraron animales de esa especie.");
        } else {
            System.out.println("Animales encontrados:");
            for (Animal animal : animales) {
                System.out.println("Nombre: " + animal.getNombre() + ", Especie: " + animal.getEspecie());
            }
        }
    }

    public static void actualizarEstadoAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre del animal a actualizar: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo estado: ");
        String nuevoEstado = scanner.nextLine();
        Animal animal = animalDAO.findById(nombre);

        if (animal != null) {
            animal.setEstado(nuevoEstado);
            animalDAO.update(animal);
            System.out.println("Estado del animal actualizado.");
        } else {
            System.out.println("Animal no encontrado.");
        }
    }
}

