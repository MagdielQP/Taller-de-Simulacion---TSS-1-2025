package proyecto2.tss.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import org.apache.commons.math3.distribution.*;

public class VentanaSimulacion extends JFrame {
    
    private ParametrosSimulacion parametros;
    EstadisticasSimulacion estadisticas = new EstadisticasSimulacion();
    private JTextArea areaResultados;
    //Fabrica
    private int fabrica_limite_de_Motores_Operando;
    private int fabrica_Distancia_Al_Siguiente;
    private int fabrica_Tiempo_Operacion_Motor;
    
    private int fabrica_asignador_ids;
    //contador
    private final Queue<Integer> fabrica_cola_Motores_Estropeados  = new LinkedList<>();
    private int fabrica_Contador_Salidas = 0;
    private int fabrica_Contador_Cantidad_Actuales = 0;
    
    //almacen estropeados
    private int almacen_Estropeados_Capacidad;
    private int almacen_Estropeados_Distancia_Siguiente;
    //contadores
    private Queue<Integer> almacen_Estropeados_Cola = new LinkedList<>();
    private final Set<Integer> en_Almacen_Estropeados = new HashSet<>();
    private int almacen_Estropeados_Contador_Salidas = 0;
    private int almacen_Estropeados_Contador_Cantidad_Actuales = 0;
    
    //taller reparacion
    private int taller_Nro_Mecanicos;
    private int taller_Tiempo_Duracion_Reparacion;
    private int taller_Distancia_Siguiente;
    //contadores
    private final Set<Integer> en_Taller_Cantidad_Actual_Reparandose  = new HashSet<>();
    private int taller_Contador_Salidas = 0;
    private int taller_Contador_Cantidad_Actuales = 0;
    
    //almacen de reserva de motores
    private int reservas_Capacidad;
    private int reservas_Inventario_Inicial;
    private int reservas_Distancia_Siguiente;
    //contadores
    private Queue<Integer> reservas_Cola = new LinkedList<>();
    private final Set<Integer> en_Reservas  = new HashSet<>();
    private int reservas_Cantidad_Actual = 0;
    private int reservas_Total_Salidas = 0;
    
    //montacargas
    private int montacargasUnidades;
    private int montacargasVelVacio;
    private int montacargasVelLleno;
    private int montacargasTiempos;
    //Estados montacargas
    private boolean montacarga1Disponible = true;
    private boolean montacarga2Disponible = true;
    // Estadísticas de uso (opcional pero útil)
    private double tiempoUsoMontacarga1 = 0.0;
    private double tiempoUsoMontacarga2 = 0.0;
    
    //Simulacion
    private int nroReplicas;
    private int horasSimulacion;
    
    //imagenes
    private Image imagen;
    //aqui se cambiara por otras imagenes que seran parte del nuevo proyecto, por el momento ignorar
    ImageIcon imgPistaHorizontal = new ImageIcon(getClass().getResource("pista-horizontal.jpeg"));
    ImageIcon imgPistaVertical = new ImageIcon(getClass().getResource("pista-vertical.JPG"));
    ImageIcon imgPiso = new ImageIcon(getClass().getResource("piso.JPG"));
    ImageIcon imgPiso2 = new ImageIcon(getClass().getResource("piso2.jpeg"));
    ImageIcon imgCiudad = new ImageIcon(getClass().getResource("ciudad.jpg"));
    
    ImageIcon imgAlmacenRecuperados = new ImageIcon(getClass().getResource("almacen-lleno.jpeg"));
    ImageIcon imgAlmacenEstropeados = new ImageIcon(getClass().getResource("almacen-vacio.jpeg"));
    ImageIcon imgTaller = new ImageIcon(getClass().getResource("taller.jpeg"));
    
    ImageIcon imgMaquina1 = new ImageIcon(getClass().getResource("maquina1.jpeg"));
    ImageIcon imgMaquina2 = new ImageIcon(getClass().getResource("maquina2.jpeg"));
    ImageIcon imgMaquina3 = new ImageIcon(getClass().getResource("maquina3.jpeg"));
    ImageIcon imgMaquina4 = new ImageIcon(getClass().getResource("maquinaria.jpeg"));
    
    ImageIcon imgMotor = new ImageIcon(getClass().getResource("motor.jpeg"));
    
    ImageIcon imgMecanico1 = new ImageIcon(getClass().getResource("mecanico1.jpeg"));
    ImageIcon imgMecanico2 = new ImageIcon(getClass().getResource("mecanico2.jpeg"));
    ImageIcon imgMecanico3 = new ImageIcon(getClass().getResource("mecanico3.jpeg"));
    ImageIcon imgMecanico4 = new ImageIcon(getClass().getResource("mecanico4.jpeg"));
    ImageIcon imgMecanico5 = new ImageIcon(getClass().getResource("mecanico5.jpeg"));
    
    ImageIcon imgMontacargasIda = new ImageIcon(getClass().getResource("montacargas-ida.jpeg"));
    ImageIcon imgMontacargasVuelta = new ImageIcon(getClass().getResource("montacargas-vuelta.JPG"));
    ImageIcon imgMontacargas2Ida = new ImageIcon(getClass().getResource("montacargas2-ida.png"));
    ImageIcon imgMontacargas2Vuelta = new ImageIcon(getClass().getResource("montacargas2-vuelta.png"));
   
    //reloj
    private JLabel lblReloj;
    private javax.swing.Timer timer;
    private double relojSimulado = 0.0;
    private double velocidad = 1.0;
    private PriorityQueue<Evento> colaEventos = new PriorityQueue<>();
    

    //llamado de los valores en los espacios de la ventana principal
    private PanelSimulacion panelSimulacion;
    private java.util.List<PiezaVisual> motoresVisuales = new ArrayList<>();
    //Numero de replicas
    private int replicaActual = 1;
    //duracion de la simulacion
    private double duracionSimulacion = 0.0; // en minutos

    // Map<Integer, Double> tiempos_Operacion  
    private Map<Integer, Double> tiempos_En_Almacen_Estropeados  = new HashMap<>();
    private Map<Integer, Double> tiempos_En_Reparacion_Motor  = new HashMap<>();
    private Map<Integer, Double> tiempos_En_Almacen_Reservas  = new HashMap<>();

    public VentanaSimulacion(ParametrosSimulacion parametros) {
        
        this.parametros = parametros;
        
        this.fabrica_limite_de_Motores_Operando = parametros.nroMaquinas; // el limite es 50
        this.fabrica_Distancia_Al_Siguiente = parametros.distFabricaSiguiente;// distancia al almacen es de 55 metros
        this.fabrica_Tiempo_Operacion_Motor = parametros.tiempoOperacion;//El tiempo es de Distribucion exp (189)
        
        this.almacen_Estropeados_Capacidad = parametros.mantenimientoCapacidad;// capacidad es de 100 unidades
        this.almacen_Estropeados_Distancia_Siguiente = parametros.distMantenimietoSiguiente;// distancia al taller es de 5 metros 
        
        this.taller_Nro_Mecanicos = parametros.nroMecanicos;//Son 5 Mecanicos
        this.taller_Tiempo_Duracion_Reparacion = parametros.tiempoReparacion;//El tiempo es de Ditibucion exp(45)
        this.taller_Distancia_Siguiente = parametros.distReparacionSiguiente;//distancia a reservas es de 40 metros
        
        this.reservas_Capacidad = parametros.reservasCapacidad;//capacidad de reservas es 3 unidades
        this.reservas_Inventario_Inicial = parametros.reservasInventarioInicial;//inventario inicial es de 3 motores
        this.reservas_Distancia_Siguiente = parametros.distReservasSiguiente;//distancia a fabrica es de 20 metros
        
        this.montacargasUnidades = parametros.montacargasUnidades;//son 2 montacargas
        this.montacargasVelVacio = parametros.montacargasVelVacio;//la velocidad estando vacio es de 100 metros
        this.montacargasVelLleno = parametros.montacargasVelLleno;// la velocidad estando lleno es de 150 metros
        this.montacargasTiempos = parametros.monstacargasTiempos;//aqui se seumaran los tiempos q estuvieron trabajando
        
        this.nroReplicas = parametros.nroReplicas;
        this.horasSimulacion = parametros.horasSimulacion;
        this.duracionSimulacion = horasSimulacion * 60.0;
        
        reservas_Cantidad_Actual = reservas_Inventario_Inicial;
        fabrica_asignador_ids = 3;//esto asignara los id's desde 0
        fabrica_Contador_Cantidad_Actuales = fabrica_limite_de_Motores_Operando;//el limite es 50 igual q la cantidad en inicio actual
        
        //agregamos la cantidad de inventario inicial a nuestra cola de reservas en este caso es 3
        for (int i = 0; i < 3; i++) {
            
            int idMotor = i;
            reservas_Cola.add(idMotor);//se añade a la cola
            tiempos_En_Almacen_Reservas.put(idMotor, 0.0);//se registra el tiempo de inicio

            // Si usas visualización de los motores 
            PiezaVisual motor = new PiezaVisual(idMotor, 735, 115, imgMotor.getImage(),30,30);
            motoresVisuales.add(motor);
        }
        
        
        // Configura la cantidad de recursos (operarios, estaciones) disponibles por etapa
        estadisticas.setCantidadRecursos("Montacargas1", 1); // montacargas1
        estadisticas.setCantidadRecursos("Montacargas2", 1); // montacargas2
        estadisticas.setCantidadRecursos("Almacen_Estropeados", almacen_Estropeados_Capacidad); // almacen con 100 espacios
        estadisticas.setCantidadRecursos("Taller_Reparacion", taller_Nro_Mecanicos); // 1 taller con 5 mecanicos
        estadisticas.setCantidadRecursos("Almacen_Reservas", reservas_Capacidad); //almacen con 3 espacios

        // Configura la ventana principal de simulación
        setTitle("Simulación Planta Hilopoliéster"); // Título de la ventana
        setSize(1300, 700); // Tamaño de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Cierra solo esta ventana sin cerrar toda la app
        setLocationRelativeTo(null); // Centra la ventana en pantalla

        // Crea el panel superior con controles de velocidad y reloj
        JPanel panelSuperior = new JPanel(new FlowLayout()); // Usa layout horizontal
        lblReloj = new JLabel("Reloj Simulado: 0.0 min"); // Reloj que se actualiza en pantalla
        panelSuperior.add(lblReloj); // Agrega el reloj al panel

        // Botones para cambiar la velocidad de simulación
        JButton btnLento = new JButton("x0.5");//velocidad x0.5
        JButton btnNormal = new JButton("x1");//velocidad x1
        JButton btnRapido = new JButton("x10");//velocidad x10
        JButton btnUltra = new JButton("x100");//velocidad x100
        JButton btnUltraFast = new JButton("x1000");//velocidad x1000
        
        // Agrega los botones de velocidad al panel superior
        panelSuperior.add(btnLento);
        panelSuperior.add(btnNormal);
        panelSuperior.add(btnRapido);
        panelSuperior.add(btnUltra);
        panelSuperior.add(btnUltraFast);

        // Crea el panel donde se dibujan las piezas y estaciones
        panelSimulacion = new PanelSimulacion();
        panelSimulacion.setBackground(Color.WHITE);
        
       // Añade los paneles a la ventana
        add(panelSuperior, BorderLayout.NORTH); // Panel de controles arriba
        add(panelSimulacion, BorderLayout.CENTER); // Panel de simulación en el centro

        // Inicia el registro de estadísticas para la simulación actual
        estadisticas.iniciarSimulacion(relojSimulado);
        //Para usar el valor de horas totales en la clase estadisticas
        estadisticas.totalHoraDeSimulacion(horasSimulacion);

        // Agenda el primer evento de llegada de pieza al sistema
        agendarEvento(new Evento(0.0, () -> salidasMotoresDeFabrica()));

        // Crea el temporizador que avanza el reloj y ejecuta eventos
        timer = new javax.swing.Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Incrementa el reloj según la velocidad
                relojSimulado += velocidad * 0.1;

                // Cálculo del tiempo formateado para mostrarlo
                int totalMinutos = (int) relojSimulado;
                int dias = totalMinutos / (24 * 60);
                int horas = (totalMinutos / 60) % 24;
                int minutos = totalMinutos % 60;
                int segundos = (int)((relojSimulado - totalMinutos) * 60);

                // Actualiza la etiqueta del reloj en pantalla
                lblReloj.setText(String.format(
                    "Réplica %d de %d | Día: %02d | Hora: %02d | Minuto: %02d | Segundo: %02d",
                    replicaActual, nroReplicas, dias + 1, horas, minutos, segundos
                ));

                // Verifica si se alcanzó la duración máxima de la réplica actual
                if (relojSimulado >= duracionSimulacion) {
                    System.out.println("Fin de réplica #" + replicaActual);

                    replicaActual++;
                    
                    // Si ya se completaron todas las réplicas, finalizar simulación
                    if (replicaActual > nroReplicas) {
                        timer.stop(); // Detiene el reloj
                        estadisticas.finalizarSimulacion(relojSimulado); // Finaliza recopilación de datos
                        System.out.println(relojSimulado + "--------------------------------------------------------------------------");

                        // Crea un área de texto con los resultados acumulados
                        JTextArea textArea = new JTextArea();
                        textArea.setEditable(false);
                        textArea.setText("=== Resultados acumulados de simulación ===\n");
                        textArea.append("Total motores que se registraron saliendo de fabrica: " + fabrica_Contador_Salidas + "\n");
                        textArea.append(estadisticas.getResumen());

                        // Crear panel con resultados y gráfico
                        JPanel panelResultados = new JPanel();
                        panelResultados.setLayout(new BoxLayout(panelResultados, BoxLayout.Y_AXIS));

                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setPreferredSize(new Dimension(600, 200));
                        panelResultados.add(scrollPane);

                        // Agrega el gráfico
                        JPanel graficoPanel = estadisticas.generarGraficoUtilizacion();
                        graficoPanel.setPreferredSize(new Dimension(600, 300));
                        panelResultados.add(graficoPanel);

                        // Muestra todo en un solo cuadro de diálogo
                        JOptionPane.showMessageDialog(null, panelResultados, "Resumen de Simulación con Gráfica", JOptionPane.INFORMATION_MESSAGE);

                        System.out.println("✅ Simulación finalizada completamente.");
                        JOptionPane.showMessageDialog(null, "Simulación completa.");

                        return; // Termina la ejecución del timer
                    }

                    // Si hay más réplicas, reinicia la simulación
                    reiniciarSimulacion();
                    return;
                }

                // Ejecuta todos los eventos programados cuyo tiempo sea menor o igual al reloj actual
                while (!colaEventos.isEmpty() && colaEventos.peek().tiempo <= relojSimulado) {
                    Evento evento = colaEventos.poll(); // Toma el evento más próximo
                    evento.accion.run(); // Ejecuta la acción del evento
                }

                // Actualiza la posición visual de todas las piezas en movimiento
                for (PiezaVisual p : motoresVisuales) {
                    p.actualizarPosicion(relojSimulado);
                }

                // Redibuja el panel de simulación (piezas, estaciones, etc.)
                panelSimulacion.repaint();
            }
        });

        // Inicia el temporizador (comienza la simulación)
        timer.start();

        // Asocia los botones de velocidad con sus respectivas acciones
        btnLento.addActionListener(e -> velocidad = 0.5);
        btnNormal.addActionListener(e -> velocidad = 1.0);
        btnRapido.addActionListener(e -> velocidad = 10.0);
        btnUltra.addActionListener(e -> velocidad = 100.0);
        btnUltraFast.addActionListener(e -> velocidad = 1000.0);
    }

    // Método para agendar eventos futuros en la simulación
    private void agendarEvento(Evento evento) {
        colaEventos.add(evento); // Se encola el evento para futura ejecución
    }
    
    // Método para registrar la salida de los motores de la fábrica
    private void salidasMotoresDeFabrica() {
        // Variables para registrar el tiempo de uso del montacargas
        double tiempoInicioUsoMontacargas1 = 0.0;
        double duracion = 0.0;

        // Verificamos si el montacargas 1 está disponible
        if (!montacarga1Disponible) {
            // Si está ocupado, el motor espera 2 minutos y se vuelve a intentar
            System.out.println("[" + relojSimulado + "] Montacarga 1 ocupado. Motor espera 2 minutos...");
            agendarEvento(new Evento(relojSimulado + 2, () -> salidasMotoresDeFabrica()));
            return;
        }

        // Si hay motores operativos en la fábrica
        if (fabrica_Contador_Cantidad_Actuales > 0) {

            // Asignamos un ID al nuevo motor estropeado
            int id = fabrica_asignador_ids++;
            System.out.println("[" + relojSimulado + "] Llegó motor #" + id);

            // Se crean representaciones visuales del motor y del montacargas
            PiezaVisual motor = new PiezaVisual(id, 130, 540, imgMotor.getImage(), 30, 30);
            PiezaVisual montacargas_1_ida = new PiezaVisual(id, 130, 540, imgMontacargasIda.getImage(), 70, 70);

            // Se agregan las piezas al conjunto visual
            motoresVisuales.add(motor);
            motoresVisuales.add(montacargas_1_ida);

            // Se registra la entrada del motor al sistema para estadísticas
            estadisticas.registrarEntradaSistema(id, relojSimulado);

            // Verificamos si hay espacio en el almacén de estropeados
            if (en_Almacen_Estropeados.size() < almacen_Estropeados_Capacidad) {
                // Si hay espacio, se ocupa el montacargas
                montacarga1Disponible = false;

                // Se registra el tiempo de inicio de uso
                tiempoInicioUsoMontacargas1 = relojSimulado;

                // Se calcula el tiempo de traslado: distancia / velocidad
                double traslado = (double) fabrica_Distancia_Al_Siguiente / montacargasVelLleno;
                double tiempoFinal = relojSimulado + traslado;

                // Movimiento visual del montacargas y del motor
                montacargas_1_ida.moverA(420, 540, relojSimulado, traslado);
                motor.moverA(420, 540, relojSimulado, traslado);

                // Se actualizan contadores del sistema
                fabrica_Contador_Cantidad_Actuales--;
                fabrica_Contador_Salidas++;

                // Se registra el tiempo de uso del montacargas para estadísticas
                duracion = tiempoFinal - tiempoInicioUsoMontacargas1;
                estadisticas.agregarTiempoOcupado("Montacargas1", duracion);

                // Se agenda la llegada al almacén de estropeados
                agendarEvento(new Evento(relojSimulado + traslado, () -> {
                    motoresVisuales.remove(montacargas_1_ida);      // Se elimina el montacargas visualmente
                    llegadaAalmacenEstropeados(id);                 // Se marca la llegada del motor
                    montacarga1Disponible = true;                   // Se libera el montacargas
                }));

                // Mensaje de salida directa del motor desde la fábrica
                System.out.println("[" + relojSimulado + "] Salió de la fabrica directamente #" + id);

            } else {
                // Si el almacén está lleno, se encola el motor
                almacen_Estropeados_Cola.add(id);
                System.out.println("[" + relojSimulado + "] Motor #" + id + " en cola para salida al almacen");
            }

            // Verificamos si podemos usar un motor de reserva
            if (fabrica_Contador_Cantidad_Actuales < fabrica_limite_de_Motores_Operando && reservas_Cantidad_Actual > 0) {
                salidaDeAlmacenReservas(); // Se usa un motor de reserva
                System.out.println("-----uso un motor de reserva-----");
            } else {
                System.out.println("-----no hay motores en reserva-----");
            }

            // Se programa la próxima llegada de un motor averiado
            double proxLlegada = getExponencial(fabrica_Tiempo_Operacion_Motor);
            agendarEvento(new Evento(relojSimulado + proxLlegada, () -> salidasMotoresDeFabrica()));

        } else {
            // Si no quedan más motores operativos
            System.out.println("[" + relojSimulado + "] ⚠️ No quedan más motores operativos en fábrica.");
        }
    }


    // Método que maneja la llegada de un motor estropeado al almacén antes de su reparación
    private void llegadaAalmacenEstropeados(int idMotor) {
        // Se incrementa el contador de motores en el almacén
        almacen_Estropeados_Contador_Cantidad_Actuales++;
        // (DEBUG) Imprime la cantidad actual de motores en almacén
        System.out.println("sssssssssssssssssssssssssssssssssssssssss " + almacen_Estropeados_Contador_Cantidad_Actuales);
        // Se agrega el motor a la lista de motores presentes en el almacén
        en_Almacen_Estropeados.add(idMotor);
        // Se registra el tiempo en el que el motor ingresó al almacén
        tiempos_En_Almacen_Estropeados.put(idMotor, relojSimulado);
        // Se notifica que el motor llegó al almacén de estropeados
        System.out.println("[" + relojSimulado + "] Motor #" + idMotor + " llegó al almacén de estropeados.");
        // Se llama directamente a la salida del almacén hacia el taller
        salidaDeAlmacenEstropeados(idMotor);
    }

    // Método que maneja la salida del motor desde el almacén de estropeados hacia el taller
    private void salidaDeAlmacenEstropeados(int idMotor) {
        // Se registra el tiempo de inicio de uso del montacargas
        double tiempoInicioUsoMontacargas1 = relojSimulado;
        double duracionMontacargas1 = 0.0;
        // Se calcula cuánto tiempo estuvo el motor en el almacén
        Double tiempoInicioAlmacenado = tiempos_En_Almacen_Estropeados.remove(idMotor);
        if (tiempoInicioAlmacenado != null) {
            double tiempoAlmacenado = relojSimulado - tiempoInicioAlmacenado;
            estadisticas.agregarTiempoOcupado("Almacen_Estropeados", tiempoAlmacenado);
            System.out.println("---motor #" + idMotor + " estuvo en almacén de estropeados durante " + tiempoAlmacenado);
        }
        // Si el montacargas está ocupado, se reintenta en 2 minutos
        if (!montacarga1Disponible) {
            System.out.println("[" + relojSimulado + "] Montacarga 1 ocupado para motor #" + idMotor + ". Espera 2 min...");
            agendarEvento(new Evento(relojSimulado + 2, () -> salidaDeAlmacenEstropeados(idMotor)));
            return;
        }
        // Si hay mecánicos disponibles en el taller
        if (en_Taller_Cantidad_Actual_Reparandose.size() < taller_Nro_Mecanicos) {
            // Se ocupa el montacargas
            montacarga1Disponible = false;
            // Se actualizan contadores del almacén
            almacen_Estropeados_Contador_Cantidad_Actuales--;
            almacen_Estropeados_Contador_Salidas++;
            // Se elimina el motor del registro del almacén
            en_Almacen_Estropeados.remove(idMotor);
            // (Redundante) Se vuelve a calcular el tiempo que estuvo almacenado
            Double inicioDeAlmacenado = tiempos_En_Almacen_Estropeados.remove(idMotor);
            if (inicioDeAlmacenado != null) {
                double duracionMin = relojSimulado - inicioDeAlmacenado;
                estadisticas.agregarTiempoOcupado("almacenEstropeados", duracionMin);
                System.out.println("motor #" + idMotor + " estuvo en almacen durante " + duracionMin);
            }
            // Se calcula el tiempo de traslado del almacén al taller
            double traslado = (double) almacen_Estropeados_Distancia_Siguiente / montacargasVelLleno;
            double tiempoFinal = relojSimulado + traslado;
            // Se notifica que el motor está en camino al taller
            System.out.println("[" + relojSimulado + "] Motor #" + idMotor + " salió hacia el taller.");
            // Se busca visualmente el motor para animarlo
            PiezaVisual motor = buscarPiezaPorId(idMotor);
            motoresVisuales.remove(motor);  // Se elimina temporalmente de la vista
            // Se crea una nueva pieza visual para el montacargas que lo lleva
            PiezaVisual montacargas_1_ida = new PiezaVisual(idMotor, 420, 540, imgMontacargasIda.getImage(), 70, 70);
            // Se agrega el montacargas y el motor nuevamente a la vista
            motoresVisuales.add(montacargas_1_ida);
            motoresVisuales.add(motor);
            // Se animan el montacargas y el motor hasta el taller
            montacargas_1_ida.moverA(750, 540, relojSimulado, traslado * 60);
            motor.moverA(750, 540, relojSimulado, traslado * 60);
            // Se registra el tiempo de uso del montacargas
            duracionMontacargas1 = tiempoFinal - tiempoInicioUsoMontacargas1;
            estadisticas.agregarTiempoOcupado("Montacargas1", duracionMontacargas1);
            // Se agenda el evento de llegada al taller y se libera el montacargas
            agendarEvento(new Evento(relojSimulado + traslado * 60, () -> {
                motoresVisuales.remove(montacargas_1_ida);
                llegadaAlTaller(idMotor);
                montacarga1Disponible = true;
            }));
        } else {
            // Si el taller no tiene espacio, se reporta un error lógico
            System.out.println("[" + relojSimulado + "] ERROR: Motor #" + idMotor + " llegó al taller sin espacio disponible.");
        }
    }


    // Método que gestiona la llegada del motor al taller para iniciar reparación
    private void llegadaAlTaller(int idMotor) {
        // Se registra el motor como actualmente en reparación
        en_Taller_Cantidad_Actual_Reparandose.add(idMotor);
        taller_Contador_Cantidad_Actuales++;
        // Se guarda el tiempo de inicio de la reparación
        tiempos_En_Reparacion_Motor.put(idMotor, relojSimulado);
        // Se notifica que el motor comenzó su reparación
        System.out.println("[" + relojSimulado + "] Motor #" + idMotor + " llegó al taller y comenzó reparación.");
        // Se calcula el tiempo que durará la reparación (distribución exponencial)
        double tiempoReparacion = getExponencial(taller_Tiempo_Duracion_Reparacion);
        // Se agenda la salida del motor del taller después de la reparación
        agendarEvento(new Evento(relojSimulado + tiempoReparacion, () -> salidaDelTaller(idMotor)));
    }

    // Método que gestiona la salida del motor del taller hacia el almacén de reservas
    private void salidaDelTaller(int idMotor) {
        // Se marca el inicio del uso del montacargas 2
        double tiempoInicioUsoMontacargas2 = relojSimulado;
        double duracionMontacargas2 = 0.0;
        // Se calcula el tiempo que el motor estuvo en reparación
        Double inicioReparacionCola = tiempos_En_Reparacion_Motor.remove(idMotor);
        if (inicioReparacionCola != null) {
            double tiempoEnTaller = relojSimulado - inicioReparacionCola;
            estadisticas.agregarTiempoOcupado("Taller_Reparacion", tiempoEnTaller);
            System.out.println("motor #" + idMotor + " estuvo en taller durante " + tiempoEnTaller);
        }

        // Si el montacargas 2 no está disponible, reintenta en 2 minutos
        if (!montacarga2Disponible) {
            System.out.println("[" + relojSimulado + "] Montacarga 1 ocupado para motor #" + idMotor + ". Espera 2 min...");
            agendarEvento(new Evento(relojSimulado + 2, () -> salidaDelTaller(idMotor)));
            return;
        }

        // Si hay espacio en el almacén de reservas
        if (reservas_Cantidad_Actual < reservas_Capacidad) {

            // El motor se retira del taller
            en_Taller_Cantidad_Actual_Reparandose.remove(idMotor);
            montacarga2Disponible = false; // Se ocupa el montacargas
            taller_Contador_Salidas++;//se aumenta el contador de salidas
            taller_Contador_Cantidad_Actuales--;//se reduce la cantidad actual en esta estacion

            // (Redundante) Se calcula nuevamente tiempo en taller
            Double inicioReparacion = tiempos_En_Reparacion_Motor.remove(idMotor);
            if (inicioReparacion != null) {
                double tiempoEnTaller = relojSimulado - inicioReparacion;
                estadisticas.agregarTiempoOcupado("taller", tiempoEnTaller);//agregamos a las estadisticas
                System.out.println("motor #" + idMotor + " estuvo en taller durante " + tiempoEnTaller);
            }

            // Se notifica la salida del taller
            System.out.println("[" + relojSimulado + "] Motor #" + idMotor + " salió del taller.");

            // Verifica si puede liberar espacio trayendo otro motor estropeado
            if (!en_Almacen_Estropeados.isEmpty()) {
                int siguienteMotor = en_Almacen_Estropeados.iterator().next();
                salidaDeAlmacenEstropeados(siguienteMotor);
            }

            // Se calcula el tiempo de traslado hacia el almacén de reservas
            double tiempoTraslado = (double) taller_Distancia_Siguiente / montacargasVelLleno;
            double tiempoFinal = relojSimulado + tiempoTraslado;

            // Animación del motor y el montacargas
            PiezaVisual motor = buscarPiezaPorId(idMotor);
            motoresVisuales.remove(motor); // Elimina temporalmente la pieza visual

            PiezaVisual montacargas_2_vuelta = new PiezaVisual(idMotor, 735, 540, imgMontacargas2Vuelta.getImage(), 70, 70);
            motoresVisuales.add(montacargas_2_vuelta);
            motoresVisuales.add(motor);

            // Se animan las piezas visuales hacia el almacén de reservas
            montacargas_2_vuelta.moverA(735, 105, relojSimulado, tiempoTraslado * 60);
            motor.moverA(735, 105, relojSimulado, tiempoTraslado * 60);

            // Se registra el tiempo de uso del montacargas 2
            duracionMontacargas2 = tiempoFinal - tiempoInicioUsoMontacargas2;
            estadisticas.agregarTiempoOcupado("Montacargas2", duracionMontacargas2);

            // Se notifica que el motor se dirige al almacén de reservas
            System.out.println("[" + relojSimulado + "] Motor #" + idMotor + " va al almacén de reservas.");

            // Se agenda la llegada al almacén de reservas y se libera el montacargas
            agendarEvento(new Evento(relojSimulado + tiempoTraslado * 60, () -> {
                motoresVisuales.remove(montacargas_2_vuelta);
                llegadaAalmacenReservas(idMotor);
                montacarga2Disponible = true;
            }));
        }
    }


    // Método que maneja la llegada de un motor reparado al almacén de reservas
    private void llegadaAalmacenReservas(int idMotor) {
        // Verifica si hay espacio en el almacén de reservas
        if (reservas_Cantidad_Actual < reservas_Capacidad) {
            reservas_Cantidad_Actual++; // Aumenta el contador actual
            System.out.println("//////////////////////////////" + reservas_Cantidad_Actual);
            reservas_Cola.add(idMotor); // Agrega el motor a la cola de reservas
            tiempos_En_Almacen_Reservas.put(idMotor, relojSimulado); // Guarda el tiempo de llegada
            System.out.println("[" + relojSimulado + "] Motor #" + idMotor + " llegó al almacén de reservas.");
        } else {
            // Si no hay espacio, se informa del error (pero no se detiene el sistema)
            System.out.println("[" + relojSimulado + "] ❌ ERROR: Almacén de reservas lleno. Motor #" + idMotor + " no puede ingresar.");
            // Nota: aquí podrías implementar lógica para que espere en otro lugar o reintentar luego
        }
    }

    // Método que gestiona la salida de un motor del almacén de reservas hacia su destino final (ej: fábrica)
    private void salidaDeAlmacenReservas() {

        // Marca el inicio del uso del montacargas 2
        double tiempoInicioUsoMontacargas2 = relojSimulado;
        double duracionMontacargas2 = 0.0;

        // Si el montacargas 2 está ocupado, reintenta dentro de 2 minutos
        if (!montacarga2Disponible) {
            System.out.println("[" + relojSimulado + "] Montacarga 1 ocupado para motor # x . Espera 2 min...");
            agendarEvento(new Evento(relojSimulado + 2, () -> salidaDeAlmacenReservas()));
            return;
        }

        // Si hay motores disponibles en la cola de reservas
        if (reservas_Cantidad_Actual > 0 && !reservas_Cola.isEmpty()) {
            int idMotor = reservas_Cola.poll(); // Toma el primero y lo elimina de la cola

            // Se registra la salida del sistema para estadísticas
            estadisticas.registrarSalidaSistema(idMotor, relojSimulado);

            // Se calcula cuánto tiempo estuvo almacenado
            Double inicioReserva = tiempos_En_Almacen_Reservas.remove(idMotor);
            if (inicioReserva != null) {
                double tiempoEnReserva = relojSimulado - inicioReserva;//registramos el tiempo q estuvo en esta estacion
                estadisticas.agregarTiempoOcupado("Almacen_Reservas", tiempoEnReserva);//agregamos a estadisticas

                System.out.println("motor #" + idMotor + " estuvo en reserva durante " + tiempoEnReserva);
            }

            // Marca el montacargas como ocupado
            montacarga2Disponible = false;
            reservas_Cantidad_Actual--;
            reservas_Total_Salidas++;

            // Doble chequeo de tiempo en reservas (puede ser redundante si ya se eliminó antes)
            Double tiempoInicio = tiempos_En_Almacen_Reservas.remove(idMotor);
            if (tiempoInicio != null) {
                double tiempoAlmacenado = relojSimulado - tiempoInicio;//registramos el tiempo de almacenado
                estadisticas.agregarTiempoOcupado("almacenReservas", tiempoAlmacenado);//guardamos los datos para las estadisticas
                System.out.println("motor #" + idMotor + " estuvo en almacén de reservas durante " + tiempoAlmacenado);//mensaje informativo
            }

            // Calcula el tiempo de traslado hasta la máquina
            double tiempoTraslado = (double) reservas_Distancia_Siguiente / montacargasVelLleno;
            double tiempoFinal = relojSimulado + tiempoTraslado;

            // Encuentra la pieza visual del motor; si no existe, crea una nueva
            PiezaVisual motor = buscarPiezaPorId(idMotor);
            if (motor == null) {
                motor = new PiezaVisual(idMotor, 735, 105, imgMotor.getImage(), 30, 30);
                System.out.println("⚠ Motor visual con ID " + idMotor + " no existía, se creó uno nuevo.");
            }

            motoresVisuales.remove(motor); // Se elimina para actualizar posición

            // Se crea el montacargas visual que lo transportará
            PiezaVisual montacargas_2_vuelta = new PiezaVisual(idMotor, 735, 105, imgMontacargas2Vuelta.getImage(), 70, 70);

            // Se agregan ambos visuales al sistema gráfico
            motoresVisuales.add(montacargas_2_vuelta);
            motoresVisuales.add(motor);

            // Se animan ambos hacia la máquina
            montacargas_2_vuelta.moverA(100, 105, relojSimulado, tiempoTraslado * 60);
            motor.moverA(100, 105, relojSimulado, tiempoTraslado * 60);

            // Aumenta el contador de motores presentes en la fábrica
            fabrica_Contador_Cantidad_Actuales++;

            // Se mide el tiempo que ocupó el montacargas
            duracionMontacargas2 = tiempoFinal - tiempoInicioUsoMontacargas2;
            estadisticas.agregarTiempoOcupado("Montacargas2", duracionMontacargas2);

            System.out.println("[" + relojSimulado + "] Motor #" + idMotor + " salió del almacén de reservas hacia máquina.");

            // Se agenda evento para finalizar el traslado y liberar el montacargas
            agendarEvento(new Evento(relojSimulado + tiempoTraslado * 60, () -> {
                motoresVisuales.remove(montacargas_2_vuelta);
                montacarga2Disponible = true;
                // Opcional: podrías también remover el motor si no debe verse más
                // motoresVisuales.remove(motor);
            }));
        } else {
            System.out.println("[" + relojSimulado + "] ⚠ ERROR: No hay motores disponibles en reservas.");
        }
    }

    
    // Devuelve un número aleatorio a partir de una distribución exponencial con la media especificada
    private double getExponencial(double media) {
        return new ExponentialDistribution(media).sample();
    }

    
    // Busca una pieza visual por su ID entre todas las piezas visuales activas
    private PiezaVisual buscarPiezaPorId(int id) {
        for (PiezaVisual p : motoresVisuales) {
            if (p.id == id) return p;
        }
        return null;
    }

    @Override
    public void dispose() {
        // Detiene el temporizador antes de cerrar la ventana
        timer.stop();
        super.dispose();
    }

    // Lanza la ventana de simulación de forma segura en el hilo de Swing
    public static void lanzarVentanaSimulacion(ParametrosSimulacion parametros) {
        SwingUtilities.invokeLater(() -> {
            new VentanaSimulacion(parametros).setVisible(true);
        });
    }
    
    private void reiniciarSimulacion() {
        System.out.println("▶ Iniciando réplica #" + replicaActual);

        // Limpia las estructuras de datos y colas del sistema
        almacen_Estropeados_Cola.clear();
        en_Reservas.clear();
        en_Taller_Cantidad_Actual_Reparandose.clear();
        en_Almacen_Estropeados.clear();
        
        colaEventos.clear(); // limpia eventos previos

        // Reinicia todos los contadores usados en las estaciones
        almacen_Estropeados_Contador_Salidas = 0;
        taller_Contador_Salidas = 0;
        reservas_Total_Salidas = 0;
        almacen_Estropeados_Contador_Cantidad_Actuales = 0;
        taller_Contador_Cantidad_Actuales = 0;
        reservas_Cantidad_Actual = 0;
        

        // Libera estaciones ocupadas
        montacarga1Disponible = true;
        montacarga2Disponible = true;

        // Reinicia el reloj de simulación y el ID de motores
        relojSimulado = 0.0;

        // Agenda la primera salida para comenzar una nueva réplica
        agendarEvento(new Evento(0.0, () -> salidasMotoresDeFabrica()));
    }


    // Panel de dibujo
    class PanelSimulacion extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //dibujamos los pisos, maquinas y la ciudad en sus respectivas posiciones
            g.drawImage(imgPiso.getImage(), 0, 0, 1000, 700, this);
            g.drawImage(imgPiso2.getImage(), 0, 0, 250, 700, this);
            g.drawImage(imgPiso2.getImage(), 0, 0, 500, 200, this);
            g.drawImage(imgMaquina2.getImage(), 20, 20, 150, 200, this);
            g.drawImage(imgMaquina3.getImage(), 250, 20, 150, 150, this);
            g.drawImage(imgMaquina4.getImage(), 20, 250, 150, 200, this);
            g.drawImage(imgCiudad.getImage(), 1000, 0, 300, 700, this);
            
            // fabrica
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(120, 450, 100, 50);
            
            g.setColor(Color.BLACK);
            g.drawImage(imgMaquina1.getImage(), 50, 500, 220, 150, this);
            g.drawString("Fabrica", 135, 465);
            g.setColor(Color.BLACK);
            g.drawString("Operativos: " + fabrica_Contador_Cantidad_Actuales, 125, 480);
            g.drawString("salidas: " + fabrica_Contador_Salidas, 125, 495);
            
            g.drawImage(imgPistaHorizontal.getImage(), 215, 550, 200, 50, this);
            
            // Almacen Estropeados
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(410, 450, 130, 150);
            
            // Mostrar el montacargas 1 solo si está disponible
            if (montacarga1Disponible) {
                g.drawImage(imgMontacargasVuelta.getImage(), 410, 350, 90, 90, this);
                
                // Dibujar un rectángulo blanco 
                g.setColor(Color.WHITE);
                g.fillRect(405, 320, 100, 20);
                g.setColor(Color.BLACK);
                g.drawString("desocupado", 415, 335);
            }
            
            g.setColor(Color.BLACK);
            
            g.drawString("Almacen", 440, 495);
            g.drawString("Almacenados: " + almacen_Estropeados_Contador_Cantidad_Actuales, 420, 465);
            g.drawString("salidas: " + almacen_Estropeados_Contador_Salidas, 420, 480);
            g.drawImage(imgAlmacenEstropeados.getImage(), 390, 500, 150, 100, this);
            
            //banda transporte 2 entre almacen_estropeados y taller
            g.setColor(Color.RED);
            g.drawImage(imgPistaHorizontal.getImage(), 510, 550, 200, 50, this);
            
            //Taller de Reparaciones
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(720, 430, 130, 80);
            
            g.setColor(Color.BLACK);
            g.drawString("Taller", 750, 475);
            g.drawString("En Reparacion: " + taller_Contador_Cantidad_Actuales, 730, 445);
            g.drawString("salidas: " + taller_Contador_Salidas, 730, 460);
            g.drawImage(imgTaller.getImage(), 710, 480, 150, 150, this);
            g.drawImage(imgPiso2.getImage(), 840, 430, 160, 250, this);
            
            // Dibujar mecánicos activos en el taller (máximo 5)
            if (taller_Contador_Cantidad_Actuales >= 1) {
                g.drawImage(imgMecanico1.getImage(), 850, 450, 60, 60, this);
            }
            if (taller_Contador_Cantidad_Actuales >= 2) {
                g.drawImage(imgMecanico2.getImage(), 920, 450, 60, 60, this);
            }
            if (taller_Contador_Cantidad_Actuales >= 3) {
                g.drawImage(imgMecanico3.getImage(), 850, 520, 60, 60, this);
            }
            if (taller_Contador_Cantidad_Actuales >= 4) {
                g.drawImage(imgMecanico4.getImage(), 920, 520, 60, 60, this);
            }
            if (taller_Contador_Cantidad_Actuales == 5) {
                g.drawImage(imgMecanico5.getImage(), 880, 580, 60, 60, this);
            }
            
            //pista transporte 3 entre taller y reservas
            g.setColor(Color.RED);
            g.drawImage(imgPistaVertical.getImage(), 735, 225, 50, 200, this);
            
            // Mostrar el montacargas 1 solo si está disponible
            if (montacarga2Disponible) {
                g.drawImage(imgMontacargas2Ida.getImage(), 600, 225, 90, 90, this);
                
                // Dibujar un rectángulo blanco 
                g.setColor(Color.WHITE);
                g.fillRect(595, 325, 100, 20);
                g.setColor(Color.BLACK);
                g.drawString("desocupado", 610, 340);
            }
            
            
            
            //Reservas
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(720, 50, 100, 80);
            
            
            g.setColor(Color.BLACK);
            g.drawString("Reservas", 735, 105);
            g.drawString("En Reservas: " + reservas_Cantidad_Actual, 725, 65);
            g.drawString("Salidas: " + reservas_Total_Salidas, 725, 85);
            g.drawImage(imgAlmacenRecuperados.getImage(), 720, 115, 100, 100, this);
            
            //banda transporte 4 entre reservas y fabrica 
            g.setColor(Color.RED);
            g.drawImage(imgPistaHorizontal.getImage(), 480, 135, 240, 50, this);

            
            for (PiezaVisual p : motoresVisuales) {
                p.dibujar(g);
            }
        }
    }

    // Clase pieza con movimiento sincronizado al reloj
    class PiezaVisual {
        int id;
        double x, y;
        double inicioX, inicioY;
        double destinoX, destinoY;
        double tiempoInicio;
        double duracionMovimiento;
        private Image imagen;
        private int ancho;
        private int alto;

        // Constructor con tamaño personalizado
        public PiezaVisual(int id, int x, int y, Image imagen, int ancho, int alto) {
            this.id = id;
            this.x = this.inicioX = this.destinoX = x;
            this.y = this.inicioY = this.destinoY = y;
            this.imagen = imagen;
            this.ancho = ancho;
            this.alto = alto;
        }

        // Define movimiento animado hacia una posición destino en cierto tiempo
        public void moverA(int destinoX, int destinoY, double tiempoInicio, double duracion) {
            this.inicioX = this.x;
            this.inicioY = this.y;
            this.destinoX = destinoX;
            this.destinoY = destinoY;
            this.tiempoInicio = tiempoInicio;
            this.duracionMovimiento = duracion;
        }

        // Calcula la nueva posición de la pieza según el reloj actual
        public void actualizarPosicion(double relojActual) {
            double progreso = Math.min(1.0, (relojActual - tiempoInicio) / duracionMovimiento);
            this.x = inicioX + (destinoX - inicioX) * progreso;
            this.y = inicioY + (destinoY - inicioY) * progreso;
        }

        // Dibuja la pieza en pantalla con el tamaño definido
        public void dibujar(Graphics g) {
            g.drawImage(imagen, (int)x, (int)y, ancho, alto, panelSimulacion);
        }
    }

}

// Evento programado con tiempo y acción
    class Evento implements Comparable<Evento> {
        double tiempo;       // Momento en que ocurre el evento
        Runnable accion;     // Acción que se ejecutará

        public Evento(double tiempo, Runnable accion) {
            this.tiempo = tiempo;
            this.accion = accion;
        }

        // Permite ordenar eventos por tiempo para ejecución secuencial
        public int compareTo(Evento otro) {
            return Double.compare(this.tiempo, otro.tiempo);
        }
    }
