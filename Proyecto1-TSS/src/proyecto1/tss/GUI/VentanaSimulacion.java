package proyecto1.tss.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import org.apache.commons.math3.distribution.*;

public class VentanaSimulacion extends JFrame {
    
    private ParametrosSimulacion parametros;
    EstadisticasSimulacion estadisticas = new EstadisticasSimulacion();
    private JTextArea areaResultados;
    
    private int recepcionTraslado;
    private int capacidadLavado;
    private int lavaderoMedia;
    private int lavaderoDesviacion;
    private int lavaderoTraslado;
    private int almacenEspacio;
    private int almacenTraslado;
    private int pinturaEspacio;
    private int pinturaMin;
    private int pinturaModa;
    private int pinturaMax;
    private int pinturaTrasladoInf;
    private int pinturaTrasladoSup;
    private int hornoAlmacen;
    private int hornoEspacio;
    private int hornoProcesoMedia;
    private int hornoProcesoDesviacion;
    private int hornoTrasladoMedia;
    private int hornoTrasladoDesviacion;
    private int inspeccionProceso1;
    private int inspeccionProceso2;
    private int nroReplicas;
    private int horasSimulacion;
    private int llegadasRecepcion;
    
    //imagenes
    private Image imagen;
    ImageIcon imgRecepcion = new ImageIcon(getClass().getResource("recepcion-de-materiales.png"));
    ImageIcon imgLavado = new ImageIcon(getClass().getResource("maquina-de-lavado.png"));
    ImageIcon imgPieza = new ImageIcon(getClass().getResource("pieza.jpeg"));
    ImageIcon imgPintura = new ImageIcon(getClass().getResource("equipo-de-pintado.png"));
    ImageIcon imgHorno = new ImageIcon(getClass().getResource("horno.png"));
    ImageIcon imgAlmacen = new ImageIcon(getClass().getResource("almacen.jpg"));
    ImageIcon imgInspeccion1 = new ImageIcon(getClass().getResource("inspector3.jpeg"));
    ImageIcon imgInspeccion2 = new ImageIcon(getClass().getResource("isnpector4.jpeg"));
    ImageIcon imgHornoAlmacen = new ImageIcon(getClass().getResource("horno-almacen.jpeg"));
    ImageIcon imgBandaTransporte = new ImageIcon(getClass().getResource("cinta-transportadora.png"));
    ImageIcon imgBandaTransporteVertical = new ImageIcon(getClass().getResource("banda-transportadora-vacía.PNG"));
    ImageIcon imgSalida = new ImageIcon(getClass().getResource("salida.jpeg"));
    ImageIcon imgSalidaCamion = new ImageIcon(getClass().getResource("camion-salida.PNG"));
    ImageIcon imgEstacionamiento = new ImageIcon(getClass().getResource("garages.JPG"));
    ImageIcon imgPiso = new ImageIcon(getClass().getResource("piso.JPG"));
    
    ImageIcon imgAgua = new ImageIcon(getClass().getResource("agua1.png"));
    ImageIcon imgBrocha = new ImageIcon(getClass().getResource("pintado.gif"));
    ImageIcon imgFuego = new ImageIcon(getClass().getResource("llamas2.gif"));
    ImageIcon imgLupa = new ImageIcon(getClass().getResource("lupa.gif"));

    
    private boolean mostrarCamion = true;
    private boolean moverCamion = false;
    private double camionX = 100;
    private final double camionY = 100;


    private JLabel lblReloj;
    private javax.swing.Timer timer;
    private double relojSimulado = 0.0;
    private double velocidad = 1.0;
    private PriorityQueue<Evento> colaEventos = new PriorityQueue<>();
    

    //llamado de los valores en los espacios de la ventana principal
    private PanelSimulacion panelSimulacion;
    private java.util.List<PiezaVisual> piezasVisuales = new ArrayList<>();
    
    
     //contadores
    private final Queue<Integer> colaRecepcion = new LinkedList<>();
    private int totalSalidaRecepcion = 0;
    private int contadorPiezas = 0;
    int enColaInspeccion = 0;
    
    //lavado
    private final Queue<Integer> colaLavado = new LinkedList<>();
    private final Set<Integer> enLavado = new HashSet<>();
    private int totalEnLavado = 0;
    private int totalProcesadasLavado = 0;
    //private int enColaLavado = 0;
    
    //almacen entre lavado y pintura
    private Queue<Integer> colaAlmacenPintura = new LinkedList<>();
    private final Set<Integer> enAlmacen1 = new HashSet<>();
    private int salidasAlmacenAPintura = 0;
    
    
    // Pintura
    int enColaPintura = 0; 
    private Queue<Integer> colaPintura = new LinkedList<>();
    private Set<Integer> enPintura = new HashSet<>();
    
    private int totalEnPintura = 0;
    private int totalProcesadasPintura = 0;

    // Almacén intermedio pintura → horno
    private Queue<Integer> almacenHorno = new LinkedList<>();

    // Horno
    int enColaHorno = 0;
    private boolean hornoOcupado = false;
    private int totalEnHorno = 0;
    private int totalProcesadasHorno = 0;
    

    // Inspección
    private boolean mesa1Ocupada = false;
    private boolean mesa2Ocupada = false;
    private int totalProcesadasInspeccion = 0;

    private int replicaActual = 1;
    private double duracionSimulacion = 0.0; // en minutos
    private int idPiezaActual = 1;

    private Map<Integer, Double> tiemposRecepcion = new HashMap<>();
    private Map<Integer, Double> tiemposInicioLavado = new HashMap<>();
    private Map<Integer, Double> tiemposInicioPintura = new HashMap<>();
    private Map<Integer, Double> tiemposInicioHorno = new HashMap<>();
    private Map<Integer, Double> tiemposInicioInspeccion = new HashMap<>();

    public VentanaSimulacion(ParametrosSimulacion parametros) {
        
        this.parametros = parametros;
        
        this.recepcionTraslado = parametros.recepcionTraslado;
        this.capacidadLavado = parametros.capacidadLavado;
        this.lavaderoMedia = parametros.lavaderoMedia;
        this.lavaderoDesviacion = parametros.lavaderoDesviacion;
        this.lavaderoTraslado = parametros.lavaderoTraslado;
        this.almacenEspacio = parametros.almacenEspacio;
        this.almacenTraslado = parametros.almacenTraslado;
        this.pinturaEspacio = parametros.pinturaEspacio;
        this.pinturaMin = parametros.pinturaMin;
        this.pinturaModa = parametros.pinturaModa;
        this.pinturaMax = parametros.pinturaMax;
        this.pinturaTrasladoInf = parametros.pinturaTrasladoInf;
        this.pinturaTrasladoSup = parametros.pinturaTrasladoSup;
        this.hornoAlmacen = parametros.hornoAlmacen;
        this.hornoEspacio = parametros.hornoEspacio;
        this.hornoProcesoMedia = parametros.hornoProcesoMedia;
        this.hornoProcesoDesviacion = parametros.hornoProcesoDesviacion;
        this.hornoTrasladoMedia = parametros.hornoTrasladoMedia;
        this.hornoTrasladoDesviacion = parametros.hornoTrasladoDesviacion;
        this.inspeccionProceso1 = parametros.inspeccionProceso1;
        this.inspeccionProceso2 = parametros.inspeccionProceso2;
        this.llegadasRecepcion = parametros.llegadasRecepcion;
        
        this.nroReplicas = parametros.nroReplicas;
        this.horasSimulacion = parametros.horasSimulacion;
        this.duracionSimulacion = horasSimulacion * 60.0;
        
        // Configura la cantidad de recursos (operarios, estaciones) disponibles por etapa
        estadisticas.setCantidadRecursos("Recepcion", 1); // 1 operario en recepción
        estadisticas.setCantidadRecursos("Lavado", capacidadLavado); // N máquinas de lavado
        estadisticas.setCantidadRecursos("Pintura", pinturaEspacio); // N cabinas de pintura
        estadisticas.setCantidadRecursos("Horno", hornoEspacio); // N espacios en el horno
        estadisticas.setCantidadRecursos("Inspeccion", 2); // 2 operarios (uno por mesa) en inspección

        // Configura la ventana principal de simulación
        setTitle("Simulación de Línea de Empaque"); // Título de la ventana
        setSize(1300, 700); // Tamaño de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Cierra solo esta ventana sin cerrar toda la app
        setLocationRelativeTo(null); // Centra la ventana en pantalla

        // Crea el panel superior con controles de velocidad y reloj
        JPanel panelSuperior = new JPanel(new FlowLayout()); // Usa layout horizontal
        lblReloj = new JLabel("Reloj Simulado: 0.0 min"); // Reloj que se actualiza en pantalla
        panelSuperior.add(lblReloj); // Agrega el reloj al panel

        // Botones para cambiar la velocidad de simulación
        JButton btnLento = new JButton("x0.5");
        JButton btnNormal = new JButton("x1");
        JButton btnRapido = new JButton("x2");
        JButton btnUltra = new JButton("x4");
        JButton btnUltraFast = new JButton("x1000");
        //JButton btnUltraFast100 = new JButton("x20");
        
        // Agrega los botones de velocidad al panel superior
        panelSuperior.add(btnLento);
        panelSuperior.add(btnNormal);
        panelSuperior.add(btnRapido);
        panelSuperior.add(btnUltra);
        panelSuperior.add(btnUltraFast);
        //panelSuperior.add(btnUltraFast100);

        // Crea el panel donde se dibujan las piezas y estaciones
        panelSimulacion = new PanelSimulacion();
        panelSimulacion.setBackground(Color.WHITE);
        
       // Añade los paneles a la ventana
        add(panelSuperior, BorderLayout.NORTH); // Panel de controles arriba
        add(panelSimulacion, BorderLayout.CENTER); // Panel de simulación en el centro

        // Inicia el registro de estadísticas para la simulación actual
        estadisticas.iniciarSimulacion(relojSimulado);

        // Agenda el primer evento de llegada de pieza al sistema
        agendarEvento(new Evento(0.0, () -> llegadaPieza()));

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
                        textArea.append("Total piezas que entraron al sistema: " + totalSalidaRecepcion + "\n");
                        textArea.append("Total piezas procesadas al final (salidas del sistema): " + totalProcesadasInspeccion + "\n");
                        textArea.append(estadisticas.getResumen());

                        // Muestra los resultados en un cuadro de diálogo
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setPreferredSize(new Dimension(600, 400));
                        JOptionPane.showMessageDialog(null, scrollPane, "Resumen de Simulación", JOptionPane.INFORMATION_MESSAGE);

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
                for (PiezaVisual p : piezasVisuales) {
                    p.actualizarPosicion(relojSimulado);
                }

                // Lógica para mover el camión de salida
                if (moverCamion) {
                    camionX += 10;
                    if (camionX > panelSimulacion.getWidth()) {
                        moverCamion = false; // Deja de mover el camión
                        camionX = 100; // Reinicia posición del camión
                    }
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
        btnRapido.addActionListener(e -> velocidad = 2.0);
        btnUltra.addActionListener(e -> velocidad = 4.0);
        btnUltraFast.addActionListener(e -> velocidad = 1000.0);
        //btnUltraFast.addActionListener(e -> velocidad = 20.0);
    }

    // Método para agendar eventos futuros en la simulación
    private void agendarEvento(Evento evento) {
        colaEventos.add(evento); // Se encola el evento para futura ejecución
    }

    // Método que se ejecuta cuando llega una nueva pieza al sistema
    private void llegadaPieza() {
        contadorPiezas++; // Se incrementa el contador global de piezas
        int id = contadorPiezas;
        System.out.println("[" + relojSimulado + "] Llegó pieza #" + id);

        // Crea la representación visual de la pieza en el sistema
        PiezaVisual pieza = new PiezaVisual(id, 130, 540, imgPieza.getImage());
        piezasVisuales.add(pieza); // Se agrega al conjunto visual

        estadisticas.registrarEntradaSistema(id, relojSimulado); // Registra estadísticamente la entrada

        // Verifica si hay capacidad en lavado para enviar directamente
        if (enLavado.size() < capacidadLavado) {
            double traslado = getExponencial(recepcionTraslado); // Tiempo de traslado con dist. exponencial
            System.out.println("****************acaaaaaaaaaa***********************************" + traslado);
            pieza.moverA(420, 540, relojSimulado, traslado); // Mueve visualmente la pieza
            totalSalidaRecepcion++; // Se cuenta como pieza que salió de recepción

            // Agenda llegada al lavado después del traslado
            agendarEvento(new Evento(relojSimulado + traslado, () -> llegadaALavado(id)));
            System.out.println("[" + relojSimulado + "] Salió de recepción directamente #" + id);
        } else {
            // No hay capacidad, se encola la pieza en recepción
            colaRecepcion.add(id);
            System.out.println("[" + relojSimulado + "] Pieza #" + id + " en cola de recepción");
        }

        // Programa la próxima llegada de una nueva pieza
        double proxLlegada = getExponencial(llegadasRecepcion);
        agendarEvento(new Evento(relojSimulado + proxLlegada, () -> llegadaPieza()));
    }

    // Método que maneja la llegada de una pieza al área de lavado
    private void llegadaALavado(int idPieza) {
        System.out.println("[" + relojSimulado + "] Pieza #" + idPieza + " llegó al LAVADO");

        // Si hay espacio en el área de lavado
        if (enLavado.size() < capacidadLavado) {
            // Si hay registro de su tiempo de llegada a recepción
            System.out.println("*************************************************************************AntestiemmpoLlegada**********");
            if (tiemposRecepcion.containsKey(idPieza)) {
                double tiempoLlegada = tiemposRecepcion.remove(idPieza);
                System.out.println("*************************************************************************tiemmpoLlegada**********");
                double tiempoEspera = relojSimulado - tiempoLlegada;
                estadisticas.agregarTiempoOcupado("Recepcion", tiempoEspera); // Registra el tiempo de espera en cola
                System.out.println("⏱ Tiempo de espera en cola de recepción para pieza #" + idPieza + ": " + tiempoEspera);
            }
            iniciarLavado(idPieza); // Comienza el lavado
        } else {
            // No hay espacio en lavado (sin cola intermedia), la pieza queda en espera
            System.out.println("[" + relojSimulado + "] ERROR: Pieza #" + idPieza + " llegó al lavado sin espacio disponible.");
        }
    }

    // Inicia el proceso de lavado de una pieza
    private void iniciarLavado(int idPieza) {
        enLavado.add(idPieza);
        totalEnLavado++;

        tiemposInicioLavado.put(idPieza, relojSimulado); // Guarda tiempo de inicio de lavado
        System.out.println(idPieza+" inició lavado en: "+relojSimulado);

        double tiempoProceso = getNormal(lavaderoMedia, lavaderoDesviacion); // Tiempo con distribución normal
        System.out.println("[" + relojSimulado + "] Inicia lavado de pieza #" + idPieza + " por " + tiempoProceso + " min");

        // Agenda el evento de fin de lavado
        agendarEvento(new Evento(relojSimulado + tiempoProceso, () -> finLavado(idPieza)));
    }

    // Finaliza el proceso de lavado de una pieza
    private void finLavado(int idPieza) {
        System.out.println("[" + relojSimulado + "] Fin de lavado de pieza #" + idPieza);
        Double inicioLavado = tiemposInicioLavado.remove(idPieza);

        // Si hay espacio en el almacén intermedio
        if (enAlmacen1.size() < almacenEspacio) {
            enLavado.remove(idPieza);
            totalEnLavado--;
            totalProcesadasLavado++;

            // Calcula y registra el tiempo de procesamiento
            if (inicioLavado != null) {
                double duracionMin = relojSimulado - inicioLavado;
                estadisticas.agregarTiempoProcesamiento("Lavado", duracionMin);
                estadisticas.agregarTiempoOcupado("Lavado", duracionMin);
                System.out.println("pieza #" + idPieza + " tardó en lavarse " + duracionMin);
            }

            // Movimiento de la pieza hacia el almacén
            PiezaVisual pieza = buscarPiezaPorId(idPieza);
            double traslado = getExponencial(almacenTraslado); // Traslado con distribución exponencial
            pieza.moverA(750, 540, relojSimulado, traslado);
            agendarEvento(new Evento(relojSimulado + traslado, () -> llegadaAlmacenPintura(idPieza)));

            // Se atiende la siguiente pieza en la cola de recepción, si la hay
            if (!colaRecepcion.isEmpty()) {
                int idDesdeCola = colaRecepcion.poll(); // Toma la siguiente pieza
                Double llegada = tiemposRecepcion.remove(idDesdeCola);
                if (llegada != null) {
                    double tiempoEspera = relojSimulado - llegada;
                    estadisticas.agregarTiempoOcupado("Recepcion", tiempoEspera);
                    estadisticas.agregarTiempoProcesamiento("Recepcion", tiempoEspera);
                }

                double trasladoRecepcion = getExponencial(recepcionTraslado); // Traslado hacia lavado
                agendarEvento(new Evento(relojSimulado + trasladoRecepcion, () -> llegadaALavado(idDesdeCola)));

                PiezaVisual piezaCola = buscarPiezaPorId(idDesdeCola);
                if (piezaCola != null) {
                    piezaCola.moverA(420, 540, relojSimulado, trasladoRecepcion);
                }

                System.out.println("[" + relojSimulado + "] Pieza #" + idDesdeCola + " salió de cola de recepción hacia lavado");
            }
        } else {
            // Si no hay espacio, reintenta mover la pieza más tarde
            System.out.println("[" + relojSimulado + "] Almacén intermedio lleno. Reintentando mover pieza #" + idPieza);
            agendarEvento(new Evento(relojSimulado + 1.0, () -> finLavado(idPieza)));
        }
    }

    // Maneja la llegada de la pieza al almacén antes de pintura
    private void llegadaAlmacenPintura(int idPieza) {
        System.out.println("[" + relojSimulado + "] Pieza #" + idPieza + " llegó al almacén antes de PINTURA");
        enAlmacen1.add(idPieza);

        // Si hay espacio en pintura, se continúa el proceso
        if (enPintura.size() < pinturaEspacio) {
            enAlmacen1.remove(idPieza);
            salidasAlmacenAPintura++;

            PiezaVisual pieza = buscarPiezaPorId(idPieza);
            double traslado = getExponencial(almacenTraslado); // Traslado hacia pintura
            pieza.moverA(750, 215, relojSimulado, traslado);

            agendarEvento(new Evento(relojSimulado + traslado, () -> llegadaPintura(idPieza)));
        } else {
            // Si pintura está llena, reintenta después
            System.out.println("[" + relojSimulado + "] Area de Pintado llena. Reintentando mover pieza #" + idPieza);
            agendarEvento(new Evento(relojSimulado + 1.0, () -> llegadaAlmacenPintura(idPieza)));
        }
    }

    // La pieza llega al área de pintura
    private void llegadaPintura(int idPieza) {
        System.out.println("[" + relojSimulado + "] Pieza #" + idPieza + " llegó a PINTURA");

        // Si hay espacio, comienza pintura; si no, entra a la cola
        if (enPintura.size() < pinturaEspacio) {
            iniciarPintura(idPieza);
        } else {
            colaPintura.add(idPieza);
            enColaPintura++;
            System.out.println("[" + relojSimulado + "] Pieza #" + idPieza + " espera en cola para pintar");
        }
    }

    // Comienza el proceso de pintura
    private void iniciarPintura(int idPieza) {
        enPintura.add(idPieza);
        totalEnPintura++;

        tiemposInicioPintura.put(idPieza, relojSimulado); // Registra inicio de pintura

        double tiempoPintura = getTriangular(pinturaMin, pinturaModa, pinturaMax); // Tiempo con distribución triangular
        System.out.println("[" + relojSimulado + "] Inicia pintura de pieza #" + idPieza + " por " + tiempoPintura + " min");
        System.out.println(idPieza+" inició pintado en: "+relojSimulado);

        PiezaVisual pieza = buscarPiezaPorId(idPieza);
        pieza.moverA(750, 120, relojSimulado, 0.5); // Movimiento visual dentro de estación
        agendarEvento(new Evento(relojSimulado + tiempoPintura, () -> finPintura(idPieza)));
    }

    // Finaliza el proceso de pintura
    private void finPintura(int idPieza) {
        // Si hay espacio en el almacén antes del horno
        if (almacenHorno.size() < hornoAlmacen) {
            enPintura.remove(idPieza);
            totalEnPintura--;
            totalProcesadasPintura++;

            Double inicioPintura = tiemposInicioPintura.remove(idPieza);

            if (inicioPintura != null) {
                double duracionMin = relojSimulado - inicioPintura;
                estadisticas.agregarTiempoProcesamiento("Pintura", duracionMin);
                estadisticas.agregarTiempoOcupado("Pintura", duracionMin);
                System.out.println("pieza #" + idPieza + " tardó en pintarse " + duracionMin);
            }

            System.out.println("[" + relojSimulado + "] Fin de pintura de pieza #" + idPieza);

            PiezaVisual pieza = buscarPiezaPorId(idPieza);
            double traslado = getUniforme(pinturaTrasladoInf, pinturaTrasladoSup); // Traslado con distribución uniforme
            pieza.moverA(520, 120, relojSimulado, traslado);
            agendarEvento(new Evento(relojSimulado + traslado, () -> llegadaAlmacenHorno(idPieza)));

            // Atiende siguiente pieza en cola de pintura, si la hay
            if (!colaPintura.isEmpty()) {
                int siguiente = colaPintura.poll();
                enColaPintura--;
                iniciarPintura(siguiente);
            }
        } else {
            // Si el almacén está lleno, reintenta más tarde
            System.out.println("[" + relojSimulado + "] Almacén del horno lleno. Pieza #" + idPieza + " espera en pintura.");
            agendarEvento(new Evento(relojSimulado + 1.0, () -> finPintura(idPieza)));
        }
    }

    
    private void llegadaAlmacenHorno(int idPieza) {
        // Muestra en consola que la pieza ha llegado al almacén antes del horno, con el tiempo simulado actual
        System.out.println("[" + relojSimulado + "] Pieza #" + idPieza + " llegó al almacén antes del HORNO");

        // Agrega la pieza al almacén del horno (una cola)
        almacenHorno.add(idPieza);

        // Incrementa el contador de piezas en espera para ser procesadas por el horno
        enColaHorno++;

        // Muestra que la pieza está en cola para entrar al horno
        System.out.println("[" + relojSimulado + "] Pieza #" + idPieza + " en espera para horno");

        // Si el horno está desocupado y esta es la única pieza en cola, iniciar procesamiento de inmediato
        if (!hornoOcupado && almacenHorno.size() == 1) {
            int siguiente = almacenHorno.poll();  // Saca la pieza de la cola
            enColaHorno--;                        // Disminuye la cuenta de piezas en cola
            iniciarHorno(siguiente);             // Llama al método que inicia el horno con esa pieza
        }
    }

    
    private void iniciarHorno(int idPieza) {
        // Marca el horno como ocupado
        hornoOcupado = true;

        // Incrementa el número total de piezas que han pasado por el horno
        totalEnHorno++;

        // Registra el tiempo de inicio del procesamiento en horno para esta pieza
        tiemposInicioHorno.put(idPieza, relojSimulado);

        // Genera un tiempo de procesamiento aleatorio con distribución normal
        double tiempoProceso = getUniforme(hornoProcesoMedia-hornoProcesoDesviacion, hornoProcesoMedia+hornoProcesoDesviacion);

        // Muestra información de inicio de procesamiento en consola
        System.out.println("[" + relojSimulado + "] Inicia horno para pieza #" + idPieza + " por " + tiempoProceso + " min");
        System.out.println(idPieza + " inició secado en: " + relojSimulado + " ***********************************************");

        // Encuentra la pieza visual (representación gráfica)
        PiezaVisual pieza = buscarPiezaPorId(idPieza);

        // Mueve la pieza visualmente dentro del horno (a una posición gráfica específica)
        pieza.moverA(420, 120, relojSimulado, 0.5);

        // Agenda un evento para cuando termine el secado
        agendarEvento(new Evento(relojSimulado + tiempoProceso, () -> finHorno(idPieza)));
    }

    private void finHorno(int idPieza) {
        // Marca el horno como libre
        hornoOcupado = false;

        // Disminuye el contador de piezas actualmente en horno
        totalEnHorno--;

        // Recupera el tiempo en que inició el procesamiento de esta pieza
        Double inicioHorno = tiemposInicioHorno.remove(idPieza);

        // Si se registró inicio, calcula duración y actualiza estadísticas
        if (inicioHorno != null) {
            double duracionMin = relojSimulado - inicioHorno;
            estadisticas.agregarTiempoProcesamiento("Horno", duracionMin);
            estadisticas.agregarTiempoOcupado("Horno", duracionMin);
            System.out.println("pieza #" + idPieza + " tardo en secarse " + duracionMin + " .............................................");
        }

        // Muestra que la pieza ha terminado el procesamiento en horno
        System.out.println("[" + relojSimulado + "] Fin de horno para pieza #" + idPieza);

        // Genera el tiempo de traslado al área de inspección (distribución normal)
        double traslado = getUniforme(hornoTrasladoMedia-hornoTrasladoDesviacion, hornoTrasladoMedia+hornoTrasladoDesviacion);

        // Encuentra la pieza visual
        PiezaVisual pieza = buscarPiezaPorId(idPieza);

        // Si hay una mesa libre para inspección visual, la pieza se mueve allí
        if (!mesa1Ocupada) {
            mesa1Ocupada = true;                        // Ocupa la mesa 1
            totalProcesadasHorno++;                    // Cuenta pieza procesada
            pieza.moverA(430, 230, relojSimulado, traslado); // Movimiento visual a mesa 1
            agendarEvento(new Evento(relojSimulado + traslado, () -> iniciarInspeccion(idPieza, 1, 1))); // Inicia inspección
        } else if (!mesa2Ocupada) {
            mesa2Ocupada = true;                        // Ocupa la mesa 2
            totalProcesadasHorno++;                    // Cuenta pieza procesada
            pieza.moverA(430, 350, relojSimulado, traslado); // Movimiento visual a mesa 2
            agendarEvento(new Evento(relojSimulado + traslado, () -> iniciarInspeccion(idPieza, 2, 1))); // Inicia inspección
        } else {
            // Si no hay mesas libres, reintenta en 1 minuto
            System.out.println("[" + relojSimulado + "] No hay mesas libres para inspección. Esperando...");
            agendarEvento(new Evento(relojSimulado + 1.0, () -> finHorno(idPieza)));
            return; // No se continúa con la siguiente pieza
        }

        // Si hay más piezas en el almacén, inicia el procesamiento de la siguiente
        if (!almacenHorno.isEmpty()) {
            int siguiente = almacenHorno.poll(); // Toma la siguiente pieza en cola
            enColaHorno--;                      // Disminuye la cuenta de piezas en espera
            iniciarHorno(siguiente);           // Inicia su procesamiento
        }
    }

    
    private void iniciarInspeccion(int idPieza, int mesa, int elemento) {
        // Solo al inicio de la inspección, registrar el tiempo
        if (elemento == 1) {
            tiemposInicioInspeccion.put(idPieza, relojSimulado);
        }

        // Si ya inspeccionó los 3 elementos, se termina el proceso de inspección
        if (elemento > 3) {
            System.out.println("[" + relojSimulado + "] Pieza #" + idPieza + " finalizó inspección en mesa " + mesa);
            totalProcesadasInspeccion++;  // Aumenta el contador de piezas inspeccionadas

            // Registrar salida del sistema (para estadísticas)
            estadisticas.registrarSalidaSistema(idPieza, relojSimulado);

            // Calcular duración de la inspección
            Double inicio = tiemposInicioInspeccion.remove(idPieza);
            if (inicio != null) {
                double duracionMin = relojSimulado - inicio;
                estadisticas.agregarTiempoProcesamiento("Inspeccion", duracionMin);
                estadisticas.agregarTiempoOcupado("Inspeccion", duracionMin);
                System.out.println("pieza #" + idPieza + " tardo en inpeccionarse " + duracionMin + " .............................................");
            }

            // Liberar la mesa correspondiente
            if (mesa == 1) mesa1Ocupada = false;
            if (mesa == 2) mesa2Ocupada = false;

            // Realizar el movimiento visual de salida del sistema
            PiezaVisual pieza = buscarPiezaPorId(idPieza);
            if (pieza != null) {
                pieza.moverA(50, 400, relojSimulado, 1.0); // Movimiento hacia la salida
                agendarEvento(new Evento(relojSimulado + 1.0, () -> {
                    piezasVisuales.remove(pieza); // Elimina visualmente la pieza del sistema
                }));
            }

            // Cada 20 piezas inspeccionadas, se activa la animación del camión
            if (totalProcesadasInspeccion % 20 == 0 && !moverCamion) {
                moverCamion = true;
            }

            return; // Termina el proceso para esta pieza
        }

        // Si aún faltan elementos por inspeccionar:
        double tiempoElemento = getExponencial(2.0); // Cada elemento toma tiempo con distribución exponencial
        System.out.println("[" + relojSimulado + "] Mesa " + mesa + " inspeccionando elemento " + elemento + " de pieza #" + idPieza + " por " + tiempoElemento + " min");

        // Se agenda inspección del siguiente elemento
        agendarEvento(new Evento(relojSimulado + tiempoElemento, () -> iniciarInspeccion(idPieza, mesa, elemento + 1)));
    }

    
    

    
    // Devuelve un número aleatorio a partir de una distribución exponencial con la media especificada
    private double getExponencial(double media) {
        return new ExponentialDistribution(media).sample();
    }

    // Devuelve un número aleatorio con distribución normal (media, desviación estándar)
    private double getNormal(double media, double desviacion) {
        return new NormalDistribution(media, desviacion).sample();
    }

    // Devuelve un número aleatorio con distribución triangular (mínimo, moda, máximo)
    private double getTriangular(double a, double c, double b) {
        return new TriangularDistribution(a, c, b).sample();
    }

    // Devuelve un número aleatorio con distribución uniforme (mínimo, máximo)
    private double getUniforme(double min, double max) {
        return new UniformRealDistribution(min, max).sample();
    }

    
    // Busca una pieza visual por su ID entre todas las piezas visuales activas
    private PiezaVisual buscarPiezaPorId(int id) {
        for (PiezaVisual p : piezasVisuales) {
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
        enLavado.clear();
        enAlmacen1.clear();
        enPintura.clear();
        colaPintura.clear();
        almacenHorno.clear();
        piezasVisuales.clear();
        colaEventos.clear(); // limpia eventos previos

        // Reinicia todos los contadores usados en las estaciones
        totalEnLavado = 0;
        totalProcesadasLavado = 0;
        totalEnPintura = 0;
        totalProcesadasPintura = 0;
        enColaPintura = 0;
        totalEnHorno = 0;
        totalProcesadasHorno = 0;
        enColaHorno = 0;
        salidasAlmacenAPintura = 0;
        contadorPiezas = 0;

        // Libera estaciones ocupadas
        hornoOcupado = false;
        mesa1Ocupada = false;
        mesa2Ocupada = false;
        moverCamion = false;

        // Reinicia el reloj de simulación y el ID de piezas
        relojSimulado = 0.0;
        idPiezaActual = 1;

        // Agenda la primera llegada para comenzar una nueva réplica
        agendarEvento(new Evento(0.0, () -> llegadaPieza()));
    }


    // Panel de dibujo
    class PanelSimulacion extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imgPiso.getImage(), 0, 0, 849, 700, this);
            // Recepción
            
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(120, 460, 100, 50);
            
            g.setColor(Color.BLACK);
            g.drawImage(imgRecepcion.getImage(), 120, 500, 100, 100, this);
            g.drawString("Recepción", 135, 495);
            g.setColor(Color.BLACK);
            g.drawString("Total salidas: " + totalSalidaRecepcion, 125, 480);
            
            g.drawImage(imgBandaTransporte.getImage(), 215, 550, 200, 50, this);
            
            // Lavado
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(410, 450, 100, 150);
            
            g.setColor(Color.BLACK);
            
            g.drawString("Lavado", 440, 495);
            g.drawString("En proceso: " + totalEnLavado, 420, 465);
            g.drawString("Procesadas: " + totalProcesadasLavado, 420, 480);
            g.drawImage(imgLavado.getImage(), 410, 500, 100, 100, this);
            if (totalEnLavado > 0) {
                g.drawImage(imgAgua.getImage(), 430, 550, 50, 50, this);
            }
            
            //banda transporte 2 entre lavado y almacen
            g.setColor(Color.RED);
            g.drawImage(imgBandaTransporte.getImage(), 510, 550, 200, 50, this);
            
            //Almacen 
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(720, 430, 100, 80);
            
            int cant = enAlmacen1.size();
            g.setColor(Color.BLACK);
            g.drawString("Almacen", 750, 475);
            g.drawString("En almacen: " + cant, 730, 445);
            g.drawString("salidas: " + salidasAlmacenAPintura, 730, 460);
            g.drawImage(imgAlmacen.getImage(), 710, 480, 150, 150, this);
            
            //banda transporte 3 entre almacen y pintura{
            
            g.setColor(Color.RED);
            g.drawImage(imgBandaTransporteVertical.getImage(), 735, 225, 50, 200, this);
            
            //pintura
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(720, 50, 100, 80);
            
            g.setColor(Color.BLACK);
            g.drawString("Pintado", 735, 105);
            g.drawString("En proceso: " + totalEnPintura, 725, 65);
            g.drawString("Procesadas: " + totalProcesadasPintura, 725, 85);
            g.drawImage(imgPintura.getImage(), 720, 115, 100, 100, this);
            if (totalEnPintura > 0) {
                g.drawImage(imgBrocha.getImage(), 740, 135, 60, 60, this);
            }
            
            //banda transporte 4 entre pintura y almacen de horno
            g.setColor(Color.RED);
            g.drawImage(imgBandaTransporte.getImage(), 585, 135, 150, 50, this);
            
            //almacenhorno
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(400, 50, 210, 80);
            
            g.setColor(Color.RED);
            g.drawString("En cola: " + enColaHorno, 520, 65);
            g.drawString("Almacen-Horno", 520, 105);
            g.drawImage(imgHornoAlmacen.getImage(), 500, 115, 100, 100, this);
            
            //horno
            int var = 0;
            if (!hornoOcupado) {
                var = 0;
            }else{
                var = 1;
            }
            g.setColor(Color.BLACK);
            g.drawString("En proceso: " + var, 410, 65);
            g.drawString("Procesadas: " + totalProcesadasHorno, 410, 85);
            g.drawString("Horno", 410, 105);
            g.drawImage(imgHorno.getImage(), 400, 115, 100, 100, this);
            if (var != 0) {
                g.drawImage(imgFuego.getImage(), 420, 125, 50, 50, this);
            }
            
            //banda transporte 5 entre horno e inspeccion
            g.setColor(Color.RED);
            g.drawImage(imgBandaTransporteVertical.getImage(), 420, 215, 45, 200, this);
            
            //inspector3
            
            g.drawImage(imgInspeccion1.getImage(), 330, 230, 80, 80, this);
            if (mesa1Ocupada == true) {
                g.drawImage(imgLupa.getImage(), 350, 250, 50, 50, this);
            }
            
            //inspector4
            g.drawImage(imgInspeccion2.getImage(), 330, 340, 80, 80, this);
            if (mesa2Ocupada == true) {
                g.drawImage(imgLupa.getImage(), 350, 350, 50, 50, this);
            }
            //salida
            g.drawImage(imgSalida.getImage(), 50, 200, 250, 250, this);
            g.drawImage(imgEstacionamiento.getImage(), 850, 0, 440, 700, this);
            
            if (mostrarCamion) {
                g.drawImage(imgSalidaCamion.getImage(), (int)camionX, (int)camionY, 120, 80, this);
            }

            
            //Inspeccionadas
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(490, 300, 150, 30);
            
            g.setColor(Color.BLACK);
            g.drawString("Inspeccionadas: " + totalProcesadasInspeccion, 500, 320);

            
            for (PiezaVisual p : piezasVisuales) {
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

        // Constructor: inicializa posición e imagen de la pieza
        public PiezaVisual(int id, int x, int y, Image imagen) {
            this.id = id;
            this.x = this.inicioX = this.destinoX = x;
            this.y = this.inicioY = this.destinoY = y;
            this.imagen = imagen;
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

        // Dibuja la pieza en pantalla
        public void dibujar(Graphics g) {
            g.drawImage(imgPieza.getImage(), (int)x, (int)y, 20, 20, panelSimulacion);
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

