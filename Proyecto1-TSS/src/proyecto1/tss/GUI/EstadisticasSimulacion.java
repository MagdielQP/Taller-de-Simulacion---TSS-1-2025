package proyecto1.tss.GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTextArea;

public class EstadisticasSimulacion {

    // Tiempo total de simulación
    private double tiempoInicioSimulacion;
    private double tiempoFinSimulacion;
    
    private double tiempoSimuladoTotal = 0.0;


    // Tiempo ocupado por estación
    private double tiempoOcupadoRecepcion = 0;
    private double tiempoOcupadoLavado = 0;
    private double tiempoOcupadoPintura = 0;
    private double tiempoOcupadoHorno = 0;
    private double tiempoOcupadoInspeccion = 0;
;

    // Listas de tiempos de procesamiento
    private List<Double> tiemposLavado = new ArrayList<>();
    private List<Double> tiemposPintura = new ArrayList<>();
    private List<Double> tiemposHorno = new ArrayList<>();
    private List<Double> tiemposInspeccion = new ArrayList<>();

    // Tiempo de entrada y salida del sistema por pieza
    private Map<Integer, Double> entradaPieza = new HashMap<>();
    private Map<Integer, Double> salidaPieza = new HashMap<>();
    
    
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
    public void registrarEntradaSistema(int idPieza, double relojSimulado) {
        entradaPieza.put(idPieza, relojSimulado);
    }

    // Registra el tiempo en que una pieza sale del sistema.
    public void registrarSalidaSistema(int idPieza, double relojSimulado) {
        salidaPieza.put(idPieza, relojSimulado);
    }

    // Calcula el tiempo que una pieza estuvo en el sistema (salida - entrada).
    public double getTiempoEnSistema(int idPieza) {
        Double entrada = entradaPieza.get(idPieza);
        Double salida = salidaPieza.get(idPieza);
        if (entrada != null && salida != null) {
            return salida - entrada;
        }
        return -1; // Si no hay entrada o salida registrada, retorna -1.
    }

    // ====== Procesamiento por estación ======

    // Agrega una duración de procesamiento a la lista correspondiente según la estación.
    public void agregarTiempoProcesamiento(String estacion, double duracion) {
        switch (estacion) {
            case "Lavado" -> tiemposLavado.add(duracion);
            case "Pintura" -> tiemposPintura.add(duracion);
            case "Horno" -> tiemposHorno.add(duracion);
            case "Inspeccion" -> tiemposInspeccion.add(duracion);
        }
    }

    // Suma el tiempo durante el cual los recursos estuvieron ocupados en una estación.
    public void agregarTiempoOcupado(String estacion, double duracion) {
        switch (estacion) {
            case "Recepcion" -> tiempoOcupadoRecepcion += duracion;
            case "Lavado" -> tiempoOcupadoLavado += duracion;
            case "Pintura" -> tiempoOcupadoPintura += duracion;
            case "Horno" -> tiempoOcupadoHorno += duracion;
            case "Inspeccion" -> tiempoOcupadoInspeccion += duracion;
        }
        // Imprime el tiempo ocupado en Lavado, probablemente para depuración.
        System.out.println(tiempoOcupadoLavado + " jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
    }

    // Calcula la utilización de una estación como el tiempo ocupado dividido entre
    // el tiempo total simulado multiplicado por la cantidad de recursos.
    public double getUtilizacion(String estacion) {
        double total = getDuracionTotalSimulacion();
        int recursos = cantidadRecursos.getOrDefault(estacion, 1);

        // Determina el tiempo ocupado de la estación correspondiente.
        double ocupado = switch (estacion) {
            case "Recepcion" -> tiempoOcupadoRecepcion;
            case "Lavado" -> tiempoOcupadoLavado;
            case "Pintura" -> tiempoOcupadoPintura;
            case "Horno" -> tiempoOcupadoHorno;
            case "Inspeccion" -> tiempoOcupadoInspeccion;
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
            case "Lavado" -> tiemposLavado;
            case "Pintura" -> tiemposPintura;
            case "Horno" -> tiemposHorno;
            case "Inspeccion" -> tiemposInspeccion;
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
        for (String estacion : List.of("Recepcion", "Lavado", "Pintura", "Horno", "Inspeccion")) {
            area.append(String.format("- %s: Utilización %.2f%%, Tiempo promedio %.2f ms\n",
                estacion,
                getUtilizacion(estacion) * 100,
                getPromedioProcesamiento(estacion)));
        }

        // Calcula y muestra el total de piezas procesadas y el tiempo promedio en el sistema.
        long totalPiezas = salidaPieza.size();
        double promedioSistema = salidaPieza.keySet().stream()
            .mapToDouble(this::getTiempoEnSistema)
            .average().orElse(0.0);

        area.append(String.format("Total piezas procesadas: %d\n", totalPiezas));
        area.append(String.format("Tiempo promedio en el sistema por pieza: %.2f ms\n", promedioSistema));
    }

    // Retorna un resumen de estadísticas como texto, útil para consola o archivos.
    public String getResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Estadísticas de Simulación ===\n");
        sb.append("Duración total: ").append(getDuracionTotalSimulacion()).append(" min (")
          .append(String.format("%.2f", getDuracionTotalSimulacion() / 60000.0)).append(" min)\n");

        // Agrega los datos de cada estación al resumen.
        for (String estacion : List.of("Lavado", "Pintura", "Horno", "Inspeccion")) {
            double promedioMs = getPromedioProcesamiento(estacion);
            sb.append(String.format("- %s: Utilización %.2f%%, Tiempo promedio %.2f min \n",
                estacion,
                getUtilizacion(estacion) * 100,
                promedioMs,
                promedioMs / 60000.0));
        }

        // Agrega el tiempo promedio en el sistema por pieza.
        long totalPiezas = salidaPieza.size();
        double promedioSistema = salidaPieza.keySet().stream()
            .mapToDouble(this::getTiempoEnSistema)
            .average().orElse(0.0);

        sb.append(String.format("Tiempo promedio en el sistema por pieza: %.2f ms (%.2f min)\n", 
            promedioSistema, promedioSistema / 60000.0));

        return sb.toString();
    }

}

