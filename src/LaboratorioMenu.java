import java.util.Scanner;
import java.util.Random;

public class LaboratorioMenu {

    static Scanner sc = new Scanner(System.in);

    // ===== MÉTODO PRINCIPAL =====
    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    calculadora();
                    break;

                case 2:
                    validarContrasena();
                    break;

                case 3:
                    numerosPrimos();
                    break;

                case 4:
                    sumaNumerosPares();
                    break;

                case 5:
                    conversionTemperatura();
                    break;

                case 6:
                    contadorVocales();
                    break;

                case 7:
                    calcularFactorial();
                    break;

                case 8:
                    juegoAdivinanza();
                    break;

                case 9:
                    pasoPorReferencia();
                    break;

                case 10:
                    tablaMultiplicar();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    // ===== MENÚ =====
    public static void mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Calculadora básica");
        System.out.println("2. Validación de contraseña");
        System.out.println("3. Número primo");
        System.out.println("4. Suma de números pares");
        System.out.println("5. Conversión de temperatura");
        System.out.println("6. Contador de vocales");
        System.out.println("7. Factorial");
        System.out.println("8. Juego de adivinanza");
        System.out.println("9. Paso por referencia");
        System.out.println("10. Tabla de multiplicar");
        System.out.println("0. Salir");
    }

    // ===== VALIDACIÓN ENTEROS =====
    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        }
    }

    public static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        }
    }

    
    // CALCULADORA //
    
    public static void calculadora() {

        double num1 = leerDouble("Ingrese primer número: ");
        double num2 = leerDouble("Ingrese segundo número: ");

        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");

        int opcion = leerEntero("Seleccione operación: ");

        switch (opcion) {
            case 1:
                System.out.println("Resultado: " + sumar(num1, num2));
                break;
            case 2:
                System.out.println("Resultado: " + restar(num1, num2));
                break;
            case 3:
                System.out.println("Resultado: " + multiplicar(num1, num2));
                break;
            case 4:
                if (num2 != 0)
                    System.out.println("Resultado: " + dividir(num1, num2));
                else
                    System.out.println("No se puede dividir entre cero.");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    public static double sumar(double a, double b) { return a + b; }
    public static double restar(double a, double b) { return a - b; }
    public static double multiplicar(double a, double b) { return a * b; }
    public static double dividir(double a, double b) { return a / b; }

    
    //CONTRASEÑA //
   
    public static void validarContrasena() {

        String clave;

        do {
            System.out.print("Ingrese contraseña: ");
            clave = sc.nextLine();

            if (!clave.equals("1234")) {
                System.out.println("Incorrecta. Intente nuevamente.");
            }

        } while (!clave.equals("1234"));

        System.out.println("Acceso concedido.");
    }

    
    // PRIMOS //
    public static void numerosPrimos() {

        int numero = leerEntero("Ingrese un número: ");

        if (esPrimo(numero))
            System.out.println("Es primo.");
        else
            System.out.println("No es primo.");
    }

    public static boolean esPrimo(int n) {

        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    
    // SUMA PARES //
    
    public static void sumaNumerosPares() {

        int suma = 0;
        int numero;

        while (true) {
            numero = leerEntero("Ingrese número (0 para salir): ");

            if (numero == 0)
                break;

            if (numero % 2 == 0)
                suma += numero;
        }

        System.out.println("Suma de pares: " + suma);
    }

    
    // TEMPERATURA //
    
    public static void conversionTemperatura() {

        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");

        int opcion = leerEntero("Seleccione opción: ");

        if (opcion == 1) {
            double c = leerDouble("Ingrese Celsius: ");
            System.out.println("Resultado: " + celsiusAFahrenheit(c));
        } else if (opcion == 2) {
            double f = leerDouble("Ingrese Fahrenheit: ");
            System.out.println("Resultado: " + fahrenheitACelsius(f));
        } else {
            System.out.println("Opción inválida.");
        }
    }

    public static double celsiusAFahrenheit(double c) {
        return (c * 9/5) + 32;
    }

    public static double fahrenheitACelsius(double f) {
        return (f - 32) * 5/9;
    }

    
    //  VOCALES //
    
    public static void contadorVocales() {

        System.out.print("Ingrese texto: ");
        String texto = sc.nextLine().toLowerCase();

        int contador = 0;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                contador++;
        }

        System.out.println("Cantidad de vocales: " + contador);
    }

    
    // FACTORIAL //
    
    public static void calcularFactorial() {

        int numero = leerEntero("Ingrese número: ");

        if (numero < 0) {
            System.out.println("No se permite número negativo.");
            return;
        }

        long factorial = 1;

        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }

        System.out.println("Factorial: " + factorial);
    }

    
    //ADIVINANZA//
    
    public static void juegoAdivinanza() {

        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;
        int intento;

        do {
            intento = leerEntero("Adivine el número (1-100): ");

            if (intento < numeroSecreto)
                System.out.println("Es mayor.");
            else if (intento > numeroSecreto)
                System.out.println("Es menor.");

        } while (intento != numeroSecreto);

        System.out.println("¡Correcto!");
    }

    //PASO POR REFERENCIA // 
    static class Numero {
        int valor;
    }

    public static void intercambiar(Numero a, Numero b) {
        int temp = a.valor;
        a.valor = b.valor;
        b.valor = temp;
    }

    public static void pasoPorReferencia() {

        Numero num1 = new Numero();
        Numero num2 = new Numero();

        num1.valor = leerEntero("Ingrese primer número: ");
        num2.valor = leerEntero("Ingrese segundo número: ");

        System.out.println("Antes del intercambio:");
        System.out.println("Num1: " + num1.valor);
        System.out.println("Num2: " + num2.valor);

        intercambiar(num1, num2);

        System.out.println("Después del intercambio:");
        System.out.println("Num1: " + num1.valor);
        System.out.println("Num2: " + num2.valor);
    }

    
    //  TABLA //
    
    public static void tablaMultiplicar() {

        int numero = leerEntero("Ingrese número: ");

        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }
}