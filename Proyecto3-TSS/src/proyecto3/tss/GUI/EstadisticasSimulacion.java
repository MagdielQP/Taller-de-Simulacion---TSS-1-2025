package proyecto3.tss.GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class EstadisticasSimulacion {

    // Tiempo total de simulación
    private double tiempoInicioSimulacion;
    private double tiempoFinSimulacion;
    
    private double totalHorasSimuladas = 0.0;
    
    private double tiempoSimuladoTotal = 0.0;
    
    private int clientesSalaEspera = 0;
    private int clientesSalaEsperaDePie = 0;


    // Tiempo ocupado por estación
    private double tiempo_Ocupado_Sala_De_Espera = 0;
    private double tiempo_Ocupado_Llenado_De_Formas = 0;
    private double timepo_Ocupado_Sala_De_Espera_De_Pie = 0;
    private double tiempo_Ocupado_Despachos = 0;
    private double tiempo_Ocupado_Servidor1 = 0;
    private double tiempo_Ocupado_Servidor2 = 0;
;

    // Listas de tiempos de procesamiento
    private List<Double> tiempos_De_Llenado_De_Formas = new ArrayList<>();
    private List<Double> tiempos_Cola_De_Pie = new ArrayList<>();
    private List<Double> tiempos_Sala_De_Espera = new ArrayList<>();
    private List<Double> tiempos_Servidor1 = new ArrayList<>();
    private List<Double> tiempos_Servidor2 = new ArrayList<>();
    private List<Double> tiempos_Despacho = new ArrayList<>();

    // Tiempo de entrada y salida del sistema por pieza
    private Map<Integer, Double> entradaCliente = new HashMap<>();
    private Map<Integer, Double> salidaCliente = new HashMap<>();
    
    
    // Mapa que almacena la cantidad de recursos (ej. máquinas o trabajadores) por estación.
    private final Map<String, Integer> cantidadRecursos = new HashMap<>();

    // Establece la cantidad de recursos disponibles en una estación específica.
    public void setCantidadRecursos(String estacion, int cantidad) {
        cantidadRecursos.put(estacion, cantidad);
    }

    // ====== Métodos generales ======

    // Marca el inicio de la simulación, registrando el tiempo simulado.
    public void iniciarSimulacion(double tiempoSimuladoTotal) {
        tiempoInicioSimulacion = tiempoSimuladoTotal;
    }
    public void totalHoraDeSimulacion(double tiempoEnHorasTotal){
        totalHorasSimuladas = tiempoEnHorasTotal;
    };
    
    public void totalClientesSalaEspera(int clientesSalaEspera){
        this.clientesSalaEspera = clientesSalaEspera;
    }
    
    public void totalClientesSalaEsperaDePie(int clientesSalaEsperaDePie){
        this.clientesSalaEsperaDePie = clientesSalaEsperaDePie;
    }
    
    // Marca el final de la simulación, registrando la duración total.
    public void finalizarSimulacion(double tiempoSimuladoTotal) {
        this.tiempoSimuladoTotal = tiempoSimuladoTotal;
    }

    // Retorna la duración total de la simulación.
    public double getDuracionTotalSimulacion() {
        return tiempoSimuladoTotal;
    }

    // ====== Manejo por pieza ======

    // Registra el tiempo en que una pieza entra al sistema.
    public void registrarEntradaSistema(int idMotor, double relojSimulado) {
        entradaCliente.put(idMotor, relojSimulado);
    }

    // Registra el tiempo en que una pieza sale del sistema.
    public void registrarSalidaSistema(int idMotor, double relojSimulado) {
        salidaCliente.put(idMotor, relojSimulado);
    }

    // Calcula el tiempo que una pieza estuvo en el sistema (salida - entrada).
    public double getTiempoEnSistema(int idMotor) {
        Double entrada = entradaCliente.get(idMotor);
        Double salida = salidaCliente.get(idMotor);
        if (entrada != null && salida != null) {
            return salida - entrada;
        }
        return -1; // Si no hay entrada o salida registrada, retorna -1.
    }

    // ====== Procesamiento por estación ======

    // Agrega una duración de procesamiento a la lista correspondiente según la estación.
    public void agregarTiempoProcesamiento(String estacion, double duracion) {
        switch (estacion) {
            case "LlenadoFormas" -> tiempos_De_Llenado_De_Formas.add(duracion);
            case "SalaDeEspera" -> tiempos_Sala_De_Espera.add(duracion);
            case "ColaDePie" -> tiempos_Cola_De_Pie.add(duracion);
            case "Servidor1" -> tiempos_Servidor1.add(duracion);
            case "Servidor2" -> tiempos_Servidor2.add(duracion);
            case "Despacho" -> tiempos_Despacho.add(duracion);
        }
    }

    // Suma el tiempo durante el cual los recursos estuvieron ocupados en una estación.
    public void agregarTiempoOcupado(String estacion, double duracion) {
        switch (estacion) {
            case "LlenadoFormas" -> tiempo_Ocupado_Llenado_De_Formas += duracion;
            case "SalaDeEspera" -> tiempo_Ocupado_Sala_De_Espera += duracion;
            case "ColaDePie" -> timepo_Ocupado_Sala_De_Espera_De_Pie += duracion;
            case "Servidor1" -> tiempo_Ocupado_Servidor1 += duracion;
            case "Servidor2" -> tiempo_Ocupado_Servidor2 += duracion;
            case "Despacho" -> tiempo_Ocupado_Despachos += duracion;
        }
        // Imprime el tiempo ocupado en Lavado, probablemente para depuración.
        System.out.println(clientesSalaEspera + " jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
    }

    // Calcula la utilización de una estación como el tiempo ocupado dividido entre
    // el tiempo total simulado multiplicado por la cantidad de recursos.
    public double getUtilizacion(String estacion) {
        double total = getDuracionTotalSimulacion();
        int recursos = cantidadRecursos.getOrDefault(estacion, 1);

        // Determina el tiempo ocupado de la estación correspondiente.
        double ocupado = switch (estacion) {
            case "LlenadoFormas" -> tiempo_Ocupado_Llenado_De_Formas;
            case "SalaDeEspera" -> tiempo_Ocupado_Sala_De_Espera;
            case "ColaDePie" -> timepo_Ocupado_Sala_De_Espera_De_Pie;
            case "Servidor1" -> tiempo_Ocupado_Servidor1;
            case "Servidor2" -> tiempo_Ocupado_Servidor2;
            case "Despacho" -> tiempo_Ocupado_Despachos;
            default -> 0;
        };

        // Imprime detalles de depuración sobre la utilización.
        System.out.println(">>> Estación: " + estacion);
        System.out.println("    Tiempo ocupado: " + ocupado + " min");
        System.out.println("    Duración total simulación: " + total + " min");
        System.out.println("    Cantidad de recursos: " + recursos);
        System.out.println("    Utilización cruda: " + (ocupado / (total * recursos)) * 100 + " %");

        // Devuelve la utilización en forma de fracción (entre 0 y 1).
        return ocupado / (total * recursos);
    }

    // Calcula el tiempo promedio de procesamiento por estación.
    public double getPromedioProcesamiento(String estacion) {
        // Obtiene la lista de duraciones correspondientes a la estación.
        List<Double> lista = switch (estacion) {
            case "LlenadoFormas" -> tiempos_De_Llenado_De_Formas;
            case "SalaDeEspera" -> tiempos_Sala_De_Espera;
            case "ColaDePie" -> tiempos_Cola_De_Pie;
            case "Servidor1" -> tiempos_Servidor1;
            case "Servidor2" -> tiempos_Servidor2;
            case "Despacho" -> tiempos_Despacho;
            default -> List.of(); // Devuelve una lista vacía si la estación no es reconocida.
        };
        // Calcula el promedio usando streams. Si la lista está vacía, devuelve 0.0.
        return lista.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    // ====== Reporte ======

    // Muestra un resumen en un JTextArea (por ejemplo, para interfaz gráfica).
    public void imprimirResumen(JTextArea area) {
        area.setText("=== Estadísticas de Simulación ===\n");
        area.append("Duración total: " + getDuracionTotalSimulacion() + " ms\n");

        // Para cada estación, muestra su utilización y tiempo promedio de procesamiento.
        for (String estacion : List.of("LlenadoFormas", "SalaDeEspera", "ColaDePie", "Servidor1", "Servidor2", "Despacho")) {
            area.append(String.format("- %s: Utilización %.2f%%, Tiempo promedio %.2f ms\n",
                estacion,
                getUtilizacion(estacion) * 100,
                getPromedioProcesamiento(estacion)));
        }

        // Calcula y muestra el total de piezas procesadas y el tiempo promedio en el sistema.
        long totalClientes = salidaCliente.size();
        double promedioSistema = salidaCliente.keySet().stream()
            .mapToDouble(this::getTiempoEnSistema)
            .average().orElse(0.0);

        area.append(String.format("Total motores procesados: %d\n", totalClientes));
        area.append(String.format("Tiempo promedio en el sistema por motor: %.2f ms\n", promedioSistema));
    }

    // Retorna un resumen de estadísticas como texto, útil para consola o archivos.
    public String getResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Estadísticas de utilizacion ===\n");
        sb.append("Duración total: ").append(getDuracionTotalSimulacion()).append(" min (")
          .append(String.format("%.2f", totalHorasSimuladas)).append(" hrs)\n");

        // Agrega los datos de cada estación al resumen.
        for (String estacion : List.of("LlenadoFormas", "SalaDeEspera", "ColaDePie", "Servidor1", "Servidor2","Despacho")) {
            double promedioMs = getPromedioProcesamiento(estacion);
            double utilizacion = getUtilizacion(estacion); // Ej: 0.0014

            // dividimos por el numero de salidas del salon de espera
            if (estacion.equals("SalaDeEspera")) {
                utilizacion = utilizacion / clientesSalaEspera;
            }
            
            if(clientesSalaEsperaDePie != 0){
                if (estacion.equals("ColaDePie")) {
                    utilizacion = utilizacion / clientesSalaEsperaDePie;
                }
            }else{
                if (estacion.equals("ColaDePie")) {
                    utilizacion = 0.0;
                }
            }

            double tiempoPromedioMin = getDuracionTotalSimulacion() * utilizacion; // En minutos
            sb.append(String.format("- %s: Utilización %.2f%%, Tiempo promedio %.2f min \n",
                estacion,
                utilizacion * 100,
                tiempoPromedioMin));
        }

        // Agrega el tiempo promedio en el sistema por pieza.
        long totalClientes = salidaCliente.size();
        double promedioSistema = salidaCliente.keySet().stream()
            .mapToDouble(this::getTiempoEnSistema)
            .average().orElse(0.0);

        sb.append(String.format("Tiempo promedio en el sistema por cliente: %.2f min (%.2f hrs)\n", 
            promedioSistema, promedioSistema/60));

        return sb.toString();
    }


    public JPanel generarGraficoUtilizacion() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (String estacion : List.of("LlenadoFormas", "SalaDeEspera", "ColaDePie", "Servidor1", "Servidor2","Despacho")) {
            double utilizacion = getUtilizacion(estacion); // Entre 0 y 1

            // Multiplica por 20 si es un montacargas
            if (estacion.equals("SalaDeEspera")) {
                utilizacion = utilizacion / clientesSalaEspera;
            }
            
            if (estacion.equals("ColaDePie")) {
                utilizacion = utilizacion / clientesSalaEsperaDePie;
            }
            
//            if(clientesSalaEsperaDePie != 0){
//                
//            }
            
            dataset.addValue(utilizacion * 100, "Utilización", estacion); // Se convierte a porcentaje
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "Utilización por estación", // Título
            "Estación",                 // Eje X
            "Utilización (%)",         // Eje Y
            dataset
        );

        return new ChartPanel(chart);
    }

}

