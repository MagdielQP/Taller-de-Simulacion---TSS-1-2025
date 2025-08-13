package proyecto4.tss.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import org.apache.commons.math3.distribution.*;

public class VentanaSimulacion extends JFrame {
    
    private ParametrosSimulacion parametros;
    EstadisticasSimulacion estadisticas = new EstadisticasSimulacion();
    private JTextArea areaResultados;
    //Bodega
    private int bodega_Distancia_Al_Siguiente;
    private int bodega_operadores_auxiliares;
    private int bodega_inventario_inicial;
    //contadores
    private int bodega_salidas_mercaderia_total;
    private int bodega_salidas_mercaderia_total_bogota;
    private int bodega_furgonetas_en_ruta;
    private int bodega_mercaderia_actual;
    private int bodega_mercaderia_actual_bogota;
    private int bodega_asignador_ids;
    private int bodega_asignador_ids_bogota = 2000;
    private int bodega_asignador_ids_camiones;
    private int bodega_asignador_ids_camiones_bogota;
    private final Queue<Integer> lista_ids_camiones  = new LinkedList<>();
    private int bodega_camiones_embarcados_Cali = 0;
    private int bodega_camiones_embarcados_Bogota = 0;
    
    //oficina
    private double oficina_tiempo_inicio_Cali = 0.0;
    private double oficina_tiempo_inicio_Bogota = 0.0;
    private double oficina_tiempo_fin_Cali = 0.0;
    private double oficina_tiempo_fin_Bogota = 0.0;
    
    //contadores
    private int mercaderia_actual_cali = 0;
    private int mercaderia_actual_bogota = 0;
    private int bodega_salidas_cali = 0;
    private int bodega_salidas_bogota = 0;
    private int bodega_tiempo_descarga_cali = 0;
    private int bodega_tiempo_descarga_bogota = 0;
    
    private int puntos_entregados_cali = 0;
    private int puntos_entregados_bogota = 0;
    private int puntos_recogidos_cali = 0;
    private int puntos_recogidos_bogota = 0;
    private int puntos_salidas_totales_cali = 0;
    private int puntos_salidas_totales_bogota = 0;
    
    private int distribuidora_almacenados_cali = 0;
    private int distribuidora_almacenados_bogota = 0;
    private int distribuidora_salidas_totales_cali = 0;
    private int distribuidora_salidas_totales_bogota = 0;
    private int distribuidora_tiempo_carga_cali = 0;
    private int distribuidora_tiempo_carga_bogota = 0;
//    private int almacen_Estropeados_Contador_Cantidad_Actuales = 0;
    
    //Centro de distribucion
    private int distribuidora_salidas_mercaderia_total;
    private int distribuidora_descargas_totales;
    private int distribuidora_furgonetas_recibidas;
    private int distribuidora_camiones_salidas;
    private int distribuidora_mercaderia_actual;
    
    private int distribuidora_carga_descarga_camiones_media;
    private int distribuidora_carga_descarga_camiones_diferencia;
    private int distribuidora_carga_descarga_furgonetas_media;
    private int distribuidora_carga_descarga_furgonetas_diferencia;
    
    //camiones-vanes y furgonetas
    private int capacidad_camion = 500;
    private int capacidad_furgoneta = 80;
    private int mercaderia_llevada_a_oficina = 0;
    private int mercaderia_llevada_a_oficina_bogota = 0; 
    private int mercaderia_limite = 600;
    private int mercaderia_limite_bogota = 600;
    private int cantidad_camiones = 4;
    private int cantidad_camiones_bogota = 4;
    private int cantidad_furgonetas = 5;
    private int cantidad_furgonetas_bogota = 5;
    private int cantidad_furgonetas_activas = 0;
    private int cantidad_furgonetas_activas_bogota = 0;
    
    private int tiempo_carga_descarga_camiones_media;
    private int tiempo_carga_descarga_camiones_diferencia;
    private int tiempo_carga_descarga_furgones_media;
    private int tiempo_carga_descarga_furgones_diferencia;
    
    private int ruta_tiempo_descarga_furgones_media;
    private int ruta_tiempo_descarga_furgones_diferencia;
    
    private int ruta_tiempo_carga_furgones_media;
    private int ruta_tiempo_carga_furgones_diferencia;
    
    private int velocidad_furgoneta_vacio;
    private int velocidad_furgoneta_lleno;
    private int velocidad_camion_vacio;
    private int velocidad_camion_lleno;
    
    private int distancias_puntos;
    private boolean furgoneta1Disponible = true;
    private boolean furgoneta2Disponible = true;
    private boolean furgoneta3Disponible = true;
    private boolean furgoneta4Disponible = true;
    private boolean furgoneta5Disponible = true;
    private boolean furgoneta6Disponible = true;
    
    private boolean camion1Disponible = true;
    private boolean camion2Disponible = true;
    private boolean camion3Disponible = true;
    private boolean camion4Disponible = true;
    
    private boolean camion1DisponibleBogota = true;
    private boolean camion2DisponibleBogota = true;
    private boolean camion3DisponibleBogota = true;
    private boolean camion4DisponibleBogota = true;
    
    //Simulacion
    private int nroReplicas;
    private int horasSimulacion;
    
    //imagenes
    private Image imagen;
    //aqui se cambiara por otras imagenes que seran parte del nuevo proyecto, por el momento ignorar
    ImageIcon imgPistaHorizontal = new ImageIcon(getClass().getResource("pista-horizontal.jpeg"));
    ImageIcon imgPistaVertical = new ImageIcon(getClass().getResource("pista-vertical.JPG"));
    ImageIcon imgPiso = new ImageIcon(getClass().getResource("piso.JPG"));
    ImageIcon imgMontes = new ImageIcon(getClass().getResource("montañas.jpg"));
    ImageIcon imgCiudad = new ImageIcon(getClass().getResource("mapa.jpg"));
    ImageIcon imgEstacionamiento = new ImageIcon(getClass().getResource("estacionamiento.jpg"));
    
    ImageIcon imgBodegaCali = new ImageIcon(getClass().getResource("bodega.png"));
    
    ImageIcon imgCamion = new ImageIcon(getClass().getResource("camion-van.png"));
    ImageIcon imgFurgoneta = new ImageIcon(getClass().getResource("furgoneta.PNG"));
    
    ImageIcon imgMercaderia = new ImageIcon(getClass().getResource("mercaderia.png"));
    
    ImageIcon imgNegocio1 = new ImageIcon(getClass().getResource("negocio1.jpeg"));
    ImageIcon imgNegocio2 = new ImageIcon(getClass().getResource("negocio2.jpeg"));
    ImageIcon imgNegocio3 = new ImageIcon(getClass().getResource("negocio3.jpeg"));
    
    ImageIcon imgOficionaLocal = new ImageIcon(getClass().getResource("oficina-local.png"));
    
    ImageIcon imgDistribuidora = new ImageIcon(getClass().getResource("centro-distribucion.jpeg"));
    
   
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
    private Map<Integer, Double> tiempos_En_Descarga_Camion_Cali  = new HashMap<>();
    private Map<Integer, Double> tiempos_En_Descarga_Camion_Bogota  = new HashMap<>();
    private Map<Integer, Double> tiempos_En_Oficina_Central_Cali  = new HashMap<>();
    private Map<Integer, Double> tiempos_En_Oficina_Central_Bogota  = new HashMap<>();
    private Map<Integer, Double> tiempos_En_Carga_Camion_cali = new HashMap<>();
    private Map<Integer, Double> tiempos_En_Carga_Camion_Bogota = new HashMap<>();

    public VentanaSimulacion(ParametrosSimulacion parametros) {
        
        this.parametros = parametros;
        
        this.bodega_inventario_inicial = parametros.mercaderiaInicial;
        
        this.tiempo_carga_descarga_camiones_media = parametros.camionMedia;
        this.tiempo_carga_descarga_camiones_diferencia = parametros.camionDiferencia;
        this.tiempo_carga_descarga_furgones_media = parametros.furgonetaMedia;
        this.tiempo_carga_descarga_furgones_diferencia = parametros.furgonetaDiferencia;
        
        this.distancias_puntos = parametros.distancias;
        
        this.ruta_tiempo_descarga_furgones_media = parametros.rutaDescargaMedia;
        this.ruta_tiempo_descarga_furgones_diferencia = parametros.rutaDescargaDiferencia;
        
        this.ruta_tiempo_carga_furgones_media = parametros.rutaCargaMedia;
        this.ruta_tiempo_carga_furgones_diferencia = parametros.rutaCargaDiferencia;
        
        this.distribuidora_carga_descarga_camiones_media = parametros.centroDistrCamionMedia;
        this.distribuidora_carga_descarga_camiones_diferencia = parametros.centroDistrCamionDiferencia;
        this.distribuidora_carga_descarga_furgonetas_media = parametros.centroDistrFurgonetaMedia;
        this.distribuidora_carga_descarga_furgonetas_diferencia = parametros.centroDistrFurgonetaDiferencia;
        
        this.velocidad_furgoneta_vacio = parametros.velocidadFurgonetaVacio;
        this.velocidad_furgoneta_lleno = parametros.velocidadFurgonetaLleno;
        this.velocidad_camion_vacio = parametros.velocidadCamionVacio;
        this.velocidad_camion_lleno = parametros.velocidadCamionLleno;
        
        this.nroReplicas = parametros.nroReplicas;
        this.horasSimulacion = parametros.horasSimulacion;
        this.duracionSimulacion = horasSimulacion * 60.0;
        bodega_asignador_ids_camiones = 1000;
        
        
        // Configura la cantidad de recursos (operarios, estaciones) disponibles por etapa
        estadisticas.setCantidadRecursos("CamionesCali", 2); 
        estadisticas.setCantidadRecursos("CamionesBogota", 2); 
        estadisticas.setCantidadRecursos("FurgonetasCali", 1); 
        estadisticas.setCantidadRecursos("FurgonetasBogota", 1); 
        estadisticas.setCantidadRecursos("OficinaCentralCali", 10);
        estadisticas.setCantidadRecursos("OficinaCentralBogota", 1);
        estadisticas.setCantidadRecursos("DistribuidoraCali", 1);
        estadisticas.setCantidadRecursos("DistribuidoraBogota", 1);
        

        // Configura la ventana principal de simulación
        setTitle("Simulación Distribuidora de Mercaderia"); // Título de la ventana
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
        agendarEvento(new Evento(0.0, () -> {llegadaBodega();llegadaBodegaBogota();}));

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
                        
                        double auxtiempoOficina = oficina_tiempo_fin_Cali - oficina_tiempo_inicio_Cali;
                        estadisticas.agregarTiempoOcupado("OficinaCentralCali",auxtiempoOficina);
                        
                        estadisticas.finalizarSimulacion(relojSimulado); // Finaliza recopilación de datos
                        System.out.println(relojSimulado + "--------------------------------------------------------------------------");

                        // Crea un área de texto con los resultados acumulados
                        JTextArea textArea = new JTextArea();
                        textArea.setEditable(false);
                        textArea.setText("=== Resultados acumulados de simulación ===\n");
                        textArea.append("Total mercaderia salida de Cali: " + bodega_salidas_cali + "\n");
                        textArea.append("Total mercaderia salida de Bogota: " + bodega_salidas_bogota + "\n");
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
//                    reiniciarSimulacion();
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
    
    private void llegadaBodega(){
        // Asigna un ID único al camión que llega y lo incrementa para el siguiente
        int idCamion = bodega_asignador_ids_camiones++;
        // Imprime en consola que llegó mercadería desde otro centro de distribución
        System.out.println("[" + relojSimulado + "] llego mercaderia de otro centro de distribucion");
        // Agrega el ID del camión a la lista de camiones que han llegado
        lista_ids_camiones.add(idCamion);
        // Calcula el intervalo mínimo y máximo de tiempo de carga/descarga
        int minCamiones = tiempo_carga_descarga_camiones_media - tiempo_carga_descarga_camiones_diferencia;
        int maxCamiones = tiempo_carga_descarga_camiones_media + tiempo_carga_descarga_camiones_diferencia;
        // Genera un tiempo aleatorio uniforme entre los valores mínimo y máximo
        double tiempoDescargaCargaCamion = getUniforme(minCamiones, maxCamiones);
        // Almacena el tiempo de descarga/carga actual para la bodega de Cali
        bodega_tiempo_descarga_cali = (int)tiempoDescargaCargaCamion;
        // Registra el tiempo ocupado por los camiones en las estadísticas
        estadisticas.agregarTiempoOcupado("CamionesCali", bodega_tiempo_descarga_cali);
        // Genera un número aleatorio entre 1 y 4 para seleccionar un camión
        int numero = (int)(Math.random() * 4) + 1;
        // Si se seleccionó el camión 1 y está disponible
        if (numero == 1 && camion1Disponible == true ){
            // Crea una visualización del camión 1 y lo agrega a la lista de elementos visuales
            PiezaVisual camion1 = new PiezaVisual(idCamion, 180, 0, imgCamion.getImage(), 80, 40);
            motoresVisuales.add(camion1);
            // Mueve el camión 1 a su posición de descarga
            camion1.moverA(180, 100, relojSimulado, 5);
            camion1Disponible = false; // Marca el camión 1 como no disponible
            bodega_camiones_embarcados_Cali++; // Incrementa el conteo de camiones embarcados

            // Agenda un evento para cuando termine el proceso de descarga/carga
            agendarEvento(new Evento(relojSimulado + tiempoDescargaCargaCamion, () -> {
                // Mueve el camión de regreso y lo elimina de la vista
                camion1.moverA(180, 0, relojSimulado, 5);
                motoresVisuales.remove(camion1);
                camion1Disponible = true; // Marca el camión como disponible de nuevo
                // Aumenta la mercadería en bodega con la capacidad del camión
                mercaderia_actual_cali = mercaderia_actual_cali + capacidad_camion;
                // Llama al método para cargar una furgoneta
                cargarFurgoneta();
            }));

        // Si se seleccionó el camión 2 y está disponible
        } else if(numero == 2 && camion2Disponible == true){
            //Creamos la pieza para mover
            PiezaVisual camion2 = new PiezaVisual(idCamion, 180, 0, imgCamion.getImage(), 80, 40);
            motoresVisuales.add(camion2);
            //movemos la pieza
            camion2.moverA(180, 150, relojSimulado, 5);
            //ocupamos el camion disponible
            camion2Disponible = false;
            bodega_camiones_embarcados_Cali++;
            //Agendamos un nuevo evento
            agendarEvento(new Evento(relojSimulado + tiempoDescargaCargaCamion, () -> {
                camion2.moverA(180, 0, relojSimulado, 5);
                motoresVisuales.remove(camion2); //eliminamos la pieza visual
                camion2Disponible = true;//habilitamos el camion usado
                mercaderia_actual_cali = mercaderia_actual_cali + capacidad_camion;//renovamos los contadores
                cargarFurgoneta();//llamamos al siguiente metodo
            }));

        // Si se seleccionó el camión 3 y está disponible
        } else if(numero == 3 && camion3Disponible == true){
            PiezaVisual camion3 = new PiezaVisual(idCamion, 90, 0, imgCamion.getImage(), 80, 40);
            motoresVisuales.add(camion3);//añadimos a las piezas movibles
            camion3.moverA(90, 100, relojSimulado, 5);
            camion3Disponible = false;//ocupamos el camion
            bodega_camiones_embarcados_Cali++;//aumentamos la cantidad de usados

            agendarEvento(new Evento(relojSimulado + tiempoDescargaCargaCamion, () -> {
                camion3.moverA(90, 0, relojSimulado, 5); //movemos el camion
                motoresVisuales.remove(camion3);//eliminamos la imagen
                camion3Disponible = true;//habilitamos el camion
                mercaderia_actual_cali = mercaderia_actual_cali + capacidad_camion;//refrescamos los contadores
                cargarFurgoneta();
            }));

        // Si se seleccionó el camión 4 y está disponible
        } else if(numero == 4 && camion4Disponible == true){
            PiezaVisual camion4 = new PiezaVisual(idCamion, 90, 0, imgCamion.getImage(), 80, 40);
            motoresVisuales.add(camion4);//añadimos a las piezas para mover
            camion4.moverA(90, 150, relojSimulado, 5);//movemos a la posicion
            camion4Disponible = false;//ocupamos el camion
            bodega_camiones_embarcados_Cali++;

            agendarEvento(new Evento(relojSimulado + tiempoDescargaCargaCamion, () -> {
                camion4.moverA(90, 0, relojSimulado, 5);
                motoresVisuales.remove(camion4);//eliminamos de la lista de movibles
                camion4Disponible = true;//habilitamos el camion
                mercaderia_actual_cali = mercaderia_actual_cali + capacidad_camion;//refrescamos los contadores
                cargarFurgoneta();
            }));

        // Si no hay camiones disponibles
        } else {
            System.out.println("[" + relojSimulado + "] No hay camiones suficientes");
        }
    }

    
    private void cargarFurgoneta(){
        // Asigna un ID único para esta carga
        int id = bodega_asignador_ids++;
        // Imprime mensaje indicando que se está esperando cargar una furgoneta
        System.out.println("Esperando carga de furgoneta...");
        // Crea visualmente una pieza de mercadería y una furgoneta
        PiezaVisual mercaderia = new PiezaVisual(id, 90, 200, imgMercaderia.getImage(), 30, 30);
        PiezaVisual furgoneta = new PiezaVisual(id, 90, 200, imgFurgoneta.getImage(), 70, 70);
        // Agrega ambas piezas al entorno visual (pantalla/simulador)
        motoresVisuales.add(mercaderia);
        motoresVisuales.add(furgoneta);
        // Calcula tiempo mínimo y máximo de carga/descarga para furgonetas
        int minFurgonetas = tiempo_carga_descarga_furgones_media - tiempo_carga_descarga_furgones_diferencia;
        int maxFurgonetas = tiempo_carga_descarga_furgones_media + tiempo_carga_descarga_furgones_diferencia;
        // Obtiene un tiempo aleatorio de carga/descarga usando distribución uniforme
        double tiempoDescargaCargaFurgonetas = getUniforme(minFurgonetas, maxFurgonetas);
        // Convierte el tiempo a entero para estadísticas
        int tiempoAux = (int) tiempoDescargaCargaFurgonetas;
        // Agrega el tiempo ocupado por la furgoneta a las estadísticas
        estadisticas.agregarTiempoOcupado("FurgonetasCali", tiempoAux);
        // Agenda evento para cuando termina la carga: eliminar furgoneta visual y enviar a salida
        agendarEvento(new Evento(relojSimulado + tiempoDescargaCargaFurgonetas, () -> {
            motoresVisuales.remove(furgoneta);
            salidasBodega(id); // Inicia el proceso de salida
        }));
        // Agenda una próxima llegada de camión a la bodega, con tiempo exponencial
        double tiempoLlegadas = getExponencial(100);
        agendarEvento(new Evento(relojSimulado + tiempoLlegadas, () -> llegadaBodega()));
    }

    // Método que maneja la salida de una furgoneta cargada
    private void salidasBodega(int id) {
        // Verifica que no se haya superado el límite de furgonetas activas
        if(cantidad_furgonetas_activas <= cantidad_furgonetas){
            // Busca la pieza visual de mercadería correspondiente al ID
            PiezaVisual mercaderia = buscarPiezaPorId(id);
            // Crea la visualización de una furgoneta en posición de salida
            PiezaVisual furgoneta = new PiezaVisual(id, 70, 110, imgFurgoneta.getImage(), 70, 70);
            motoresVisuales.add(furgoneta);
            // Calcula un tiempo de movimiento aleatorio entre 10 y 20 unidades
            int tiempoAux = (int) getUniforme(10, 20);
            // Determina aleatoriamente la ruta de salida (1, 2 o 3)
            int numero = (int)(Math.random() * 3) + 1;
            // Si la ruta es la 1
            if (numero == 1) {
                mercaderia.moverA(20, 350, relojSimulado, tiempoAux);
                furgoneta.moverA(20, 350, relojSimulado, tiempoAux);
                System.out.println("furgoneta cargada saliendo...1");
                cantidad_furgonetas_activas++;
                // Agenda evento para actualizar inventario y enviar a oficina central
                agendarEvento(new Evento(relojSimulado + 15, () -> {
                    mercaderia_actual_cali = mercaderia_actual_cali - capacidad_furgoneta;
                    bodega_salidas_cali = bodega_salidas_cali + capacidad_furgoneta;
                    motoresVisuales.remove(furgoneta);
                    llevarOficinaCentral(id);
    //                cantidad_furgonetas_activas--; // Comentado, tal vez por lógica externa
                }));

            // Si la ruta es la 2
            } else if (numero == 2) {
                mercaderia.moverA(90, 350, relojSimulado, tiempoAux);
                furgoneta.moverA(90, 350, relojSimulado, tiempoAux);
                System.out.println("furgoneta cargada saliendo...2");
                cantidad_furgonetas_activas++;
                agendarEvento(new Evento(relojSimulado + 15, () -> {
                    mercaderia_actual_cali = mercaderia_actual_cali - capacidad_furgoneta;
                    bodega_salidas_cali = bodega_salidas_cali + capacidad_furgoneta;
                    motoresVisuales.remove(furgoneta);
                    llevarOficinaCentral(id);
    //                cantidad_furgonetas_activas--;
                }));
            // Si la ruta es la 3
            } else if (numero == 3){
                mercaderia.moverA(150, 350, relojSimulado, tiempoAux);
                furgoneta.moverA(150, 350, relojSimulado, tiempoAux);
                System.out.println("furgoneta cargada saliendo...3");
                cantidad_furgonetas_activas++;
                agendarEvento(new Evento(relojSimulado + 15, () -> {
                    mercaderia_actual_cali = mercaderia_actual_cali - capacidad_furgoneta;
                    bodega_salidas_cali = bodega_salidas_cali + capacidad_furgoneta;
                    motoresVisuales.remove(furgoneta);
                    llevarOficinaCentral(id);
                }));

            // Si por alguna razón no entra en ninguno de los casos
            } else {
                System.out.println("No hay furgonetas disponibles...");
            }

        // Si ya se alcanzó el límite de furgonetas activas
        } else {
            System.out.println("No hay furgonetas disponibles...");
        }
    }

    
    private void llevarOficinaCentral(int id) {
        // Mensaje informativo por consola
        System.out.println("Se traslada los recojos a la oficina...");
        // Crea una furgoneta visual que representa el traslado
        PiezaVisual furgoneta = new PiezaVisual(id, 20, 350, imgFurgoneta.getImage(), 50, 50);
        // Incrementa el total de puntos entregados en Cali según la capacidad
        puntos_entregados_cali = puntos_entregados_cali + capacidad_furgoneta;
        // Agrega la furgoneta al entorno visual
        motoresVisuales.add(furgoneta);
        // Mueve la furgoneta hacia un punto intermedio
        furgoneta.moverA(150, 350, relojSimulado, 20);
        // Luego, mueve la furgoneta hacia la oficina central
        furgoneta.moverA(90, 550, relojSimulado, 10);
        // Genera 3 valores aleatorios (representan puntos de recolección)
        int aux1 = (int)getUniforme(60, 80);
        int aux2 = (int)getUniforme(60, 80);
        int aux3 = (int)getUniforme(60, 80);
        // Acumula tiempo de inicio en la oficina de Cali
        oficina_tiempo_inicio_Cali += (relojSimulado + 30);
        // Agenda evento que se ejecuta después de 30 unidades de tiempo
        agendarEvento(new Evento(relojSimulado + 30, () -> {
            // Elimina la furgoneta del entorno visual
            motoresVisuales.remove(furgoneta);
            // Suma los puntos recolectados a la variable de mercadería en oficina
            mercaderia_llevada_a_oficina = mercaderia_llevada_a_oficina + (aux1 + aux2 + aux3);
            // Actualiza la cantidad de puntos recogidos en Cali
            puntos_recogidos_cali = aux1 + aux2 + aux3;
            // Actualiza el total de puntos de salida (entregados + recogidos)
            puntos_salidas_totales_cali = puntos_recogidos_cali + mercaderia_llevada_a_oficina;
            // Libera una furgoneta activa
            cantidad_furgonetas_activas--;
            // Llama al siguiente paso: salida desde la oficina central
            salidaOficinaCentral(id);
        }));
    }


    private void salidaOficinaCentral(int id){
        // Imprime mensaje informando que llegan recogidos a la oficina
        System.out.println("llegan los recogidos a oficina...");
        // Crea una representación visual de la furgoneta que llega a oficina
        PiezaVisual furgoneta = new PiezaVisual(id, 90, 550, imgFurgoneta.getImage(), 80, 40);
        // Añade la furgoneta al entorno visual
        motoresVisuales.add(furgoneta);
        // Verifica si hay suficiente mercadería para enviarla al centro de distribución
        if(mercaderia_llevada_a_oficina >= mercaderia_limite){
            // Suma el tiempo final acumulado en la oficina de Cali
            oficina_tiempo_fin_Cali += relojSimulado;
            // Mueve la furgoneta hacia el centro de distribución
            furgoneta.moverA(300, 550, relojSimulado, 20);
            // Suma la cantidad trasladada al contador de la distribuidora
            distribuidora_almacenados_cali = distribuidora_almacenados_cali + mercaderia_limite;
            // Descuenta la mercadería que fue trasladada
            mercaderia_llevada_a_oficina = mercaderia_llevada_a_oficina - mercaderia_limite;
            // Agenda evento para eliminar la furgoneta y generar llegada al centro de distribución
            agendarEvento(new Evento(relojSimulado + 30, () -> {
                motoresVisuales.remove(furgoneta);
                llegadaCentroDistribucion(id); // Continúa el ciclo logístico
            }));
        } else {
            // Si no hay suficiente mercadería, imprime mensaje
            System.out.println("No hay suficiente cantidad para trasladar...");
        }
    }

    private void llegadaCentroDistribucion(int id) {
        // Mensaje indicando que los recogidos han llegado a la distribuidora
        System.out.println("llegan los recogidos a distribuidora...");
        // Mensaje indicando que se inicia la carga de mercancía
        System.out.println("Se comienza a cargar la mercaderia...");
        // Define el mínimo y máximo tiempo de carga/descarga para camiones
        int minCamiones = distribuidora_carga_descarga_camiones_media - distribuidora_carga_descarga_camiones_diferencia;
        int maxCamiones = distribuidora_carga_descarga_camiones_media + distribuidora_carga_descarga_camiones_diferencia;
        // Calcula un tiempo aleatorio dentro del rango para la carga del camión
        double tiempoDescargaCargaCamion = getUniforme(minCamiones, maxCamiones);
        // Registra el tiempo de carga en la variable correspondiente
        distribuidora_tiempo_carga_cali = (int) tiempoDescargaCargaCamion;
        // Guarda la estadística de tiempo ocupado por camiones en distribuidora de Cali
        estadisticas.agregarTiempoOcupado("DistribuidoraCali", distribuidora_tiempo_carga_cali);
        // Crea una visualización del camión que está siendo cargado
        PiezaVisual camion = new PiezaVisual(id, 250, 550, imgCamion.getImage(), 100, 50);
        motoresVisuales.add(camion); // Lo agrega al entorno visual
        // Agenda el evento de finalización de carga después del tiempo calculado
        agendarEvento(new Evento(relojSimulado + tiempoDescargaCargaCamion, () -> {
            // Mensaje informando fin de carga
            System.out.println("Se termino de cargar la mercaderia...");
            // Elimina el camión visual del entorno
            motoresVisuales.remove(camion);
            // Llama a la siguiente fase: salida del centro de distribución
            salidaCentroDistribucion(id);
        }));
    }

    private void salidaCentroDistribucion(int id) {
        // Crea la visualización del camión que va a salir con la carga
        PiezaVisual camion = new PiezaVisual(id, 250, 550, imgCamion.getImage(), 100, 50);
        motoresVisuales.add(camion); // Añade el camión al entorno visual
        // Aumenta el conteo total de salidas desde la distribuidora
        distribuidora_salidas_totales_cali = distribuidora_salidas_totales_cali + mercaderia_limite;
        // Mueve el camión desde la posición actual hasta el destino final
        camion.moverA(950, 0, relojSimulado, 30);
        // Agenda el evento para cuando el camión llegue a Bogotá
        agendarEvento(new Evento(relojSimulado + 30, () -> {
            // Mensaje de confirmación de entrega en Bogotá
            System.out.println("Se llevo la mercaderia a Bogota...");
            // Quita el camión del entorno visual
            motoresVisuales.remove(camion);
            // Continúa con la lógica de llegada a Bogotá
            llegadaBodegaBogota();
        }));
    }

    
    private void llegadaBodegaBogota(){
        int idCamion = bodega_asignador_ids_camiones_bogota++;
        System.out.println("[" + relojSimulado + "] llego mercaderia de otro centro de distribucion");
//        lista_ids_camiones.add(idCamion);
        
        int minCamiones = tiempo_carga_descarga_camiones_media - tiempo_carga_descarga_camiones_diferencia;
        int maxCamiones = tiempo_carga_descarga_camiones_media + tiempo_carga_descarga_camiones_diferencia;

        double tiempoDescargaCargaCamion = getUniforme(minCamiones, maxCamiones);
        
        bodega_tiempo_descarga_bogota = (int) tiempoDescargaCargaCamion;
        
        estadisticas.agregarTiempoOcupado("CamionesBogota",bodega_tiempo_descarga_bogota);
        
        int numero = (int)(Math.random() * 4) + 1;
            if (numero == 1 && camion1DisponibleBogota == true ){
                PiezaVisual camion1Bogota = new PiezaVisual(idCamion, 950, 0, imgCamion.getImage(), 80, 40);
                motoresVisuales.add(camion1Bogota);
                camion1Bogota.moverA(950, 100, relojSimulado, 5);
                camion1DisponibleBogota=false;
                
                agendarEvento(new Evento(relojSimulado + tiempoDescargaCargaCamion, () -> {
                    camion1Bogota.moverA(950, 0, relojSimulado, 5);
                    motoresVisuales.remove(camion1Bogota);
                    camion1DisponibleBogota = true;
                    mercaderia_actual_bogota = mercaderia_actual_bogota + capacidad_camion;
                    cargarFurgonetaBogota();
                }));
                
            }else if(numero == 2 && camion2DisponibleBogota == true){
                PiezaVisual camion2Bogota = new PiezaVisual(idCamion, 950, 0, imgCamion.getImage(), 80, 40);
                motoresVisuales.add(camion2Bogota);
                camion2Bogota.moverA(950, 150, relojSimulado, 5);
                camion2DisponibleBogota=false;
                
                agendarEvento(new Evento(relojSimulado + tiempoDescargaCargaCamion, () -> {
                    camion2Bogota.moverA(950, 0, relojSimulado, 5);
                    motoresVisuales.remove(camion2Bogota);
                    camion2DisponibleBogota = true;
                    mercaderia_actual_bogota = mercaderia_actual_bogota + capacidad_camion;
                    cargarFurgonetaBogota();
                }));
            }else if(numero == 3 && camion3DisponibleBogota == true){
                PiezaVisual camion3Bogota = new PiezaVisual(idCamion, 1040, 0, imgCamion.getImage(), 80, 40);
                motoresVisuales.add(camion3Bogota);
                camion3Bogota.moverA(1040, 100, relojSimulado, 5);
                camion3DisponibleBogota=false;
                
                agendarEvento(new Evento(relojSimulado + tiempoDescargaCargaCamion, () -> {
                    camion3Bogota.moverA(1040, 0, relojSimulado, 5);
                    motoresVisuales.remove(camion3Bogota);
                    camion3DisponibleBogota = true;
                    mercaderia_actual_bogota = mercaderia_actual_bogota + capacidad_camion;
                    cargarFurgonetaBogota();
                }));
            }else if(numero == 4 && camion4DisponibleBogota == true){
                PiezaVisual camion4Bogota = new PiezaVisual(idCamion, 1040, 0, imgCamion.getImage(), 80, 40);
                motoresVisuales.add(camion4Bogota);
                camion4Bogota.moverA(1040, 150, relojSimulado, 5);
                camion4DisponibleBogota = false;
                
                agendarEvento(new Evento(relojSimulado + tiempoDescargaCargaCamion, () -> {
                    camion4Bogota.moverA(1040, 0, relojSimulado, 5);
                    motoresVisuales.remove(camion4Bogota);
                    camion4DisponibleBogota = true;
                    mercaderia_actual_bogota = mercaderia_actual_bogota + capacidad_camion;
                    cargarFurgonetaBogota();
                }));
            }else{
                System.out.println("[" + relojSimulado + "] No hay camiones suficientes");
            }
    }
    
    private void cargarFurgonetaBogota(){
        int id = bodega_asignador_ids_bogota++;
        System.out.println("Esperando carga de furgoneta...");
        // Se crean representaciones visuales
            PiezaVisual mercaderiaBogota = new PiezaVisual(id, 1000, 200, imgMercaderia.getImage(), 30, 30);
            PiezaVisual furgonetaBogota = new PiezaVisual(id, 1000, 200, imgFurgoneta.getImage(), 70, 70);

            // Se agregan las piezas al conjunto visual
            motoresVisuales.add(mercaderiaBogota);
            motoresVisuales.add(furgonetaBogota);
            
            int minFurgonetas = tiempo_carga_descarga_furgones_media - tiempo_carga_descarga_furgones_diferencia;
            int maxFurgonetas = tiempo_carga_descarga_furgones_media + tiempo_carga_descarga_furgones_diferencia;
            
            double tiempoDescargaCargaFurgonetas = getUniforme(minFurgonetas, maxFurgonetas);
            
            int tiempoAux = (int) tiempoDescargaCargaFurgonetas;
            
            estadisticas.agregarTiempoOcupado("FurgonetasBogota",tiempoAux);
            
            agendarEvento(new Evento(relojSimulado + tiempoDescargaCargaFurgonetas, () -> {
                motoresVisuales.remove(furgonetaBogota);
                salidasBodegaBogota(id);
            }));
            
            double tiempoLlegadas = getExponencial(80);
            agendarEvento(new Evento(relojSimulado + tiempoLlegadas, () -> llegadaBodegaBogota()));
    }
    
    // Método para registrar la salida
    private void salidasBodegaBogota(int id) {
        
        if(cantidad_furgonetas_activas_bogota <= cantidad_furgonetas_bogota){
            PiezaVisual mercaderiaBogota = buscarPiezaPorId(id);
            PiezaVisual furgonetaBogota = new PiezaVisual(id, 1000, 200, imgFurgoneta.getImage(), 40, 40);
            motoresVisuales.add(furgonetaBogota);
            
            int tiempoAux = (int) getUniforme(10, 20);
            
            int numero = (int)(Math.random() * 3) + 1;
            if (numero == 1) {
                mercaderiaBogota.moverA(970, 350, relojSimulado, tiempoAux);
                furgonetaBogota.moverA(970, 350, relojSimulado, tiempoAux);
                System.out.println("furgoneta cargada saliendo...1");
                cantidad_furgonetas_activas_bogota++;
                agendarEvento(new Evento(relojSimulado + 15, () -> {
                    bodega_salidas_bogota= bodega_salidas_bogota + capacidad_furgoneta;
                    motoresVisuales.remove(furgonetaBogota);
                    llevarOficinaCentralBogota(id);
                }));
                
            } else if (numero == 2) {
                mercaderiaBogota.moverA(1040, 350, relojSimulado, tiempoAux);
                furgonetaBogota.moverA(1040, 350, relojSimulado, tiempoAux);
                System.out.println("furgoneta cargada saliendo...2");
                cantidad_furgonetas_activas_bogota++;
                agendarEvento(new Evento(relojSimulado + 15, () -> {
                    bodega_salidas_bogota= bodega_salidas_bogota + capacidad_furgoneta;
                    motoresVisuales.remove(furgonetaBogota);
                    llevarOficinaCentralBogota(id);
//                    cantidad_furgonetas_activas--;
                }));
                
            } else if (numero == 3){
                mercaderiaBogota.moverA(1100, 350, relojSimulado, tiempoAux);
                furgonetaBogota.moverA(1100, 350, relojSimulado, tiempoAux);
                System.out.println("furgoneta cargada saliendo...3");
                cantidad_furgonetas_activas_bogota++;
                agendarEvento(new Evento(relojSimulado + 15, () -> {
                    bodega_salidas_bogota= bodega_salidas_bogota + capacidad_furgoneta;
                    motoresVisuales.remove(furgonetaBogota);
                    llevarOficinaCentralBogota(id);
                    
                }));
                
            }else{
                System.out.println("No hay furgonetas disponibles...");
            }
        }else{
            System.out.println("No hay furgonetas disponibles...");
        }
    }
    
    private void llevarOficinaCentralBogota(int id) {
        System.out.println("Se traslada los recojos a la oficina...");
        PiezaVisual furgonetaBogota = new PiezaVisual(id, 1040, 350, imgFurgoneta.getImage(), 50, 50);
        
        int aux1 = (int)getUniforme(60, 80);
        int aux2 = (int)getUniforme(60, 80);
        int aux3 = (int)getUniforme(60, 80);
        
        puntos_entregados_bogota = puntos_entregados_bogota + capacidad_furgoneta;
        motoresVisuales.add(furgonetaBogota);
        furgonetaBogota.moverA(1040, 550, relojSimulado, 10);
        
        agendarEvento(new Evento(relojSimulado + 30, () -> {
            motoresVisuales.remove(furgonetaBogota);
            
            mercaderia_llevada_a_oficina_bogota = mercaderia_llevada_a_oficina_bogota + (aux1+aux2+aux3);
            
            puntos_recogidos_bogota = aux1+aux2+aux3;
            puntos_salidas_totales_bogota = puntos_recogidos_bogota + mercaderia_llevada_a_oficina;
            oficina_tiempo_inicio_Bogota = relojSimulado;
            
            cantidad_furgonetas_activas_bogota--;
            salidaOficinaCentralBogota(id);
        }));
    }

    private void salidaOficinaCentralBogota(int id){
        System.out.println("llegan los recogidos a oficina...");
        PiezaVisual furgonetaBogota = new PiezaVisual(id, 1040, 550, imgFurgoneta.getImage(), 50, 50);
        motoresVisuales.add(furgonetaBogota);
        
        if(mercaderia_llevada_a_oficina_bogota >= mercaderia_limite_bogota){
            furgonetaBogota.moverA(840, 550, relojSimulado, 20);
            
            oficina_tiempo_fin_Bogota = relojSimulado;
            
            double auxtiempoOficina = oficina_tiempo_fin_Bogota - oficina_tiempo_inicio_Bogota;
            estadisticas.agregarTiempoOcupado("OficinaCentralBogota",auxtiempoOficina);
            
            distribuidora_almacenados_bogota = distribuidora_almacenados_bogota + mercaderia_limite;
            
            agendarEvento(new Evento(relojSimulado+30, () -> {
                motoresVisuales.remove(furgonetaBogota);
                llegadaCentroDistribucionBogota(id);
            }));
        }else{
            System.out.println("No hay suficiente cantidad para trasladar...");
        }
       
    }
    
    private void llegadaCentroDistribucionBogota(int id){
        System.out.println("llegan los recogidos a distribuidora...");
        System.out.println("Se comienza a cargar la mercaderia...");
        int minCamiones = distribuidora_carga_descarga_camiones_media - distribuidora_carga_descarga_camiones_diferencia;
        int maxCamiones = distribuidora_carga_descarga_camiones_media + distribuidora_carga_descarga_camiones_diferencia;
        
        double tiempoDescargaCargaCamion = getUniforme(minCamiones, maxCamiones);
        
        distribuidora_tiempo_carga_bogota = (int) tiempoDescargaCargaCamion;
        
        estadisticas.agregarTiempoOcupado("DistribuidoraBogota",tiempoDescargaCargaCamion);
        
        PiezaVisual camionBogota = new PiezaVisual(id, 840, 500, imgCamion.getImage(), 100, 50);
        motoresVisuales.add(camionBogota);
        agendarEvento(new Evento(relojSimulado + tiempoDescargaCargaCamion, () -> {
                System.out.println("Se termino de cargar la mercaderia...");
                motoresVisuales.remove(camionBogota);
                salidaCentroDistribucionBogota(id);
            }));
    }
    
    private void salidaCentroDistribucionBogota(int id){
        PiezaVisual camionBogota = new PiezaVisual(id, 840, 500, imgCamion.getImage(), 100, 50);
        motoresVisuales.add(camionBogota);
        
        distribuidora_salidas_totales_bogota = distribuidora_salidas_totales_bogota + mercaderia_limite;
        
        camionBogota.moverA(50, 100, relojSimulado, 30);
        agendarEvento(new Evento(relojSimulado + 30, () -> {
                System.out.println("Se llevo la mercaderia a Cali...");
                motoresVisuales.remove(camionBogota);
                llegadaBodega();
            }));
    }
    
    // Devuelve un número aleatorio a partir de una distribución exponencial con la media especificada
    private double getExponencial(double media) {
        return new ExponentialDistribution(media).sample();
    }
    
    private double getUniforme(int min, int max){
        return new UniformIntegerDistribution(min,max).sample();
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
    
//    private void reiniciarSimulacion() {
//        System.out.println("▶ Iniciando réplica #" + replicaActual);
//
//        // Limpia las estructuras de datos y colas del sistema
//        almacen_Estropeados_Cola.clear();
//        en_Reservas.clear();
//        en_Taller_Cantidad_Actual_Reparandose.clear();
//        en_Almacen_Estropeados.clear();
//        
//        colaEventos.clear(); // limpia eventos previos
//
//        // Reinicia todos los contadores usados en las estaciones
//        almacen_Estropeados_Contador_Salidas = 0;
//        taller_Contador_Salidas = 0;
//        reservas_Total_Salidas = 0;
//        almacen_Estropeados_Contador_Cantidad_Actuales = 0;
//        taller_Contador_Cantidad_Actuales = 0;
//        reservas_Cantidad_Actual = 0;
//        
//
//        // Libera estaciones ocupadas
//        montacarga1Disponible = true;
//        montacarga2Disponible = true;
//
//        // Reinicia el reloj de simulación y el ID de motores
//        relojSimulado = 0.0;
//
//        // Agenda la primera salida para comenzar una nueva réplica
//        agendarEvento(new Evento(0.0, () -> salidasMotoresDeFabrica()));
//    }


    // Panel de dibujo
    class PanelSimulacion extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //dibujamos los pisos, maquinas y la ciudad en sus respectivas posiciones
            g.drawImage(imgMontes.getImage(), 400, 0, 600, 700, this);
            g.drawImage(imgCiudad.getImage(), 0, 0, 500, 700, this);
            g.drawImage(imgCiudad.getImage(), 800, 0, 500, 700, this);
            
            // Bodega Cali
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(270, 100, 150, 90);
            g.setColor(Color.BLACK);
            g.drawString("BODEGA CALI", 285, 115);
            g.drawString("mercaderia actual: " + mercaderia_actual_cali, 275, 130);
            g.drawString("salidas: " + bodega_salidas_cali, 275, 145);
            g.drawString("T. Descarga: " + bodega_tiempo_descarga_cali, 275, 160);
            
            g.drawImage(imgBodegaCali.getImage(), 0, 0, 100, 100, this);
            g.drawImage(imgEstacionamiento.getImage(), 100, 80, 150, 140, this);
            
            // puntos de entrega
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(250, 350, 150, 100);
            g.setColor(Color.BLACK);
            g.drawString("ENTREGAR/RECOGER", 260, 365);
            g.drawString("Entregados: " + puntos_entregados_cali, 255, 380);
            g.drawString("Recogidos: " + puntos_recogidos_cali, 255, 395);
            g.drawString("Salidas: " + puntos_salidas_totales_cali, 255, 410);
            
            
            //pista hacia los puntos de distribucion
            g.drawImage(imgPistaVertical.getImage(), 25, 250, 30, 100, this);
            g.drawImage(imgPistaVertical.getImage(), 98, 250, 30, 100, this);
            g.drawImage(imgPistaVertical.getImage(), 156, 250, 30, 100, this);
            
            //puntos
            g.drawImage(imgNegocio1.getImage(), 20, 350, 50, 50, this);
            g.drawImage(imgNegocio2.getImage(), 90, 350, 50, 50, this);
            g.drawImage(imgNegocio3.getImage(), 150, 350, 50, 50, this);
            
            //pista hacia las oficinas
            g.drawImage(imgPistaVertical.getImage(), 98, 400, 30, 100, this);
           
            //Oficinas
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(380, 500, 120, 100);
            g.setColor(Color.BLACK);
            g.drawString("DISTRIBUIDORA", 395, 515);
            g.drawString("Almacenados: " + distribuidora_almacenados_cali, 385, 530);
            g.drawString("salidas: " + distribuidora_salidas_totales_cali, 385, 545);
            g.drawString("T. Carga: " + distribuidora_tiempo_carga_cali, 385, 560);
            
            g.drawImage(imgOficionaLocal.getImage(), 60,500, 100, 100, this);
            
            //pista hacia centro de distribucion
            g.drawImage(imgPistaHorizontal.getImage(), 170, 550, 100, 30, this);
            //centro de distribucion
            g.drawImage(imgDistribuidora.getImage(), 270, 500, 100, 100, this);

            //---------------------bogota---------------------
            g.drawImage(imgBodegaCali.getImage(), 950, 0, 100, 100, this);
            g.drawImage(imgEstacionamiento.getImage(), 960, 80, 150, 140, this);
            
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(805, 100, 150, 100);
            g.setColor(Color.BLACK);
            g.drawString("BODEGA BOGOTA", 820, 115);
            g.drawString("mercaderia actual: " + mercaderia_actual_bogota, 810, 130);
            g.drawString("salidas: " + bodega_salidas_bogota, 810, 145);
            g.drawString("T. Descarga: " + bodega_tiempo_descarga_bogota, 810, 160);
            
            //pista hacia los puntos de distribucion
            g.drawImage(imgPistaVertical.getImage(), 970, 250, 30, 100, this);
            g.drawImage(imgPistaVertical.getImage(), 1048, 250, 30, 100, this);
            g.drawImage(imgPistaVertical.getImage(), 1100, 250, 30, 100, this);
            
            //negocios
            g.drawImage(imgNegocio1.getImage(), 970, 350, 50, 50, this);
            g.drawImage(imgNegocio2.getImage(), 1040, 350, 50, 50, this);
            g.drawImage(imgNegocio3.getImage(), 1100, 350, 50, 50, this);
            
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(800, 350, 150, 100);
            g.setColor(Color.BLACK);
            g.drawString("ENTREGAR/RECOGER", 815, 365);
            g.drawString("Entregados: " + puntos_entregados_bogota, 805, 380);
            g.drawString("Recogidos: " + puntos_recogidos_bogota, 805, 395);
            g.drawString("salidas: " + puntos_salidas_totales_bogota, 805, 410);
            
            //pista hacia las oficinas
            g.drawImage(imgPistaVertical.getImage(), 1048, 400, 30, 100, this);
            
            //oficina local
            g.drawImage(imgOficionaLocal.getImage(), 1020,500, 100, 100, this);
            
            //pista hacia centro de distribucion 
            g.setColor(Color.RED);
            g.drawImage(imgPistaHorizontal.getImage(), 940, 550, 100, 30, this);
            
            //centro de distribucion
            g.drawImage(imgDistribuidora.getImage(), 840, 500, 100, 100, this);
            
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(710, 500, 120, 100);
            g.setColor(Color.BLACK);
            g.drawString("DISTRIBUIDORA", 725, 515);
            g.drawString("Almacenados: " + distribuidora_almacenados_bogota, 715, 530);
            g.drawString("salidas: " + distribuidora_salidas_totales_bogota, 715, 545);
            g.drawString("T. Carga: " + distribuidora_tiempo_carga_bogota, 715, 560);
            
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
