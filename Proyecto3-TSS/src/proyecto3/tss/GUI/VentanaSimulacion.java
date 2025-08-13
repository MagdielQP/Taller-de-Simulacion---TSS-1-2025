package proyecto3.tss.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import org.apache.commons.math3.distribution.*;

public class VentanaSimulacion extends JFrame {
    
    private ParametrosSimulacion parametros;
    EstadisticasSimulacion estadisticas = new EstadisticasSimulacion();
    private JTextArea areaResultados;
    //Llegada
    private int llegada_tiempo_media_poisson;
    private int probabilidad_a_sala_espera;
    private int probabilidad_a_llenado_formas;
    private int asignador_numero_ids;
    private int llegadas_salidas_totales;
    
    //sala de espera y cola de pie
    private final Queue<Integer> sala_espera_cola = new LinkedList<>();
    private final Queue<Integer> sala_espera_cola_de_pie = new LinkedList<>();
    private int sala_espera_capacidad;
    private int sala_espera_salidas_totales;
    private int sala_espera_clientes_actuales;
    private int sala_espera_clientes_de_pie;
    private int sala_espera_salidas_totales_clientes_de_pie;
    
    private int maxOcupacionSalaDeEspera = 0;
    
    //llenado de formas
    private final Queue<Integer> llenado_formas_cola_en_espera  = new LinkedList<>();
    private boolean llenadoFormulariosOcupado = false;
    private int llenado_formas_tiempo_uniforme_media;
    private int llenado_formas_tiempo_uniforme_diferencia;
    private int llenado_formas_salidas_totales;
    private int llenado_formas_clientes_actuales;
    
    //servidores
    private Queue<Integer> servidores = new LinkedList<>();
    private Queue<Integer> servidores_cola_despacho = new LinkedList<>();
    private int servidores_cantidad;
    private boolean servidor1Ocupado = false;
    private boolean servidor2Ocupado = false;
    private boolean boolAux1 = false;
    private boolean boolAux2 = false;
    private int servidores_atendidos_actuales;
    private int servidores_tiempo_de_atencion_exp;
    private int servidores_salidas_totales;
    private int servidores_limite_entregas;
    private int servidores_tiempo_de_despacho_exp;
    private int servidores1_salidasTotales;
    private int servidores2_salidasTotales;
    
    private int despacho_actuales;
    
    // Promedios de ocupación
    private double acumuladoPersonasSentadas = 0;
    private double acumuladoPersonasDePie = 0;
    private double ultimoTiempoActualizacion = 0;
    // Tiempos de entrada
    private final Map<Integer, Double> tiempoEntradaSala = new HashMap<>();
    private final Map<Integer, Double> tiempoEntradaDePie = new HashMap<>();
    
    //Simulacion
    private int nroReplicas;
    private int horasSimulacion;
    
    //imagenes
    private Image imagen;
    //aqui se cambiara por otras imagenes que seran parte del nuevo proyecto, por el momento ignorar
//    ImageIcon imgPistaHorizontal = new ImageIcon(getClass().getResource("pista-horizontal.jpeg"));
//    ImageIcon imgPistaVertical = new ImageIcon(getClass().getResource("pista-vertical.JPG"));
    ImageIcon imgPiso = new ImageIcon(getClass().getResource("piso1.jpg"));
    ImageIcon imgPiso1 = new ImageIcon(getClass().getResource("piso3.jpg"));
    ImageIcon imgPiso2 = new ImageIcon(getClass().getResource("piso2.jpeg"));
//    ImageIcon imgPiso2 = new ImageIcon(getClass().getResource("piso2.jpeg"));
    ImageIcon imgCiudad = new ImageIcon(getClass().getResource("ciudad1.JPG"));
    ImageIcon imgCalle = new ImageIcon(getClass().getResource("calle1.JPG"));
    
    ImageIcon imgPuertaIngreso = new ImageIcon(getClass().getResource("puerta-ingreso.png"));
    
    ImageIcon imgHombreCaminandoMov = new ImageIcon(getClass().getResource("hombre-caminando-mov.gif"));
    ImageIcon imgMujerCaminandoMov = new ImageIcon(getClass().getResource("mujer-caminando-mov.gif"));
    ImageIcon imgHombreCaminando = new ImageIcon(getClass().getResource("hombre-caminando.jpeg"));
    ImageIcon imgMujerCaminando = new ImageIcon(getClass().getResource("mujer-caminando.jpeg"));
    
    ImageIcon imgLlenadoFormasMov = new ImageIcon(getClass().getResource("llenado-formas-mov.gif"));
    ImageIcon imgLlenadoFormas = new ImageIcon(getClass().getResource("llenado-formas.png"));
    
    ImageIcon imgSalaEspera = new ImageIcon(getClass().getResource("sala-de-espera.jpg"));
    ImageIcon imgColaDePie = new ImageIcon(getClass().getResource("lugar-para-cola.jpeg"));
    
    ImageIcon imgServidor1Mov = new ImageIcon(getClass().getResource("servidor1-mov.gif"));
    ImageIcon imgServidor2Mov = new ImageIcon(getClass().getResource("servidor2-mov.gif"));
    ImageIcon imgServidor1 = new ImageIcon(getClass().getResource("servidor1.jpeg"));
    ImageIcon imgServidor2 = new ImageIcon(getClass().getResource("servidor2.jpeg"));
    
    ImageIcon imgDespacho = new ImageIcon(getClass().getResource("espera-despacho.png"));
    ImageIcon imgSalida = new ImageIcon(getClass().getResource("salida.png"));
   
    //reloj
    private JLabel lblReloj;
    private javax.swing.Timer timer;
    private double relojSimulado = 0.0;
    private double velocidad = 1.0;
    private PriorityQueue<Evento> colaEventos = new PriorityQueue<>();
    

    //llamado de los valores en los espacios de la ventana principal
    private PanelSimulacion panelSimulacion;
    private java.util.List<PiezaVisual> clientesVisuales = new ArrayList<>();
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
        
        this.llegada_tiempo_media_poisson = parametros.llegadaTiempoMediaPoisson; // 
        this.probabilidad_a_sala_espera = parametros.probSalaEspera;// 
        this.probabilidad_a_llenado_formas = parametros.probLlenadoForma;//
        
        this.llenado_formas_tiempo_uniforme_media = parametros.formasTiempoUniformeMedia;// 
        this.llenado_formas_tiempo_uniforme_diferencia = parametros.formasTiempoUniformeDiferencia;// 
        
        this.sala_espera_capacidad = parametros.salaEsperaCapacidad;//
        
        this.servidores_cantidad = parametros.servidoresUnidades;//
        this.servidores_tiempo_de_atencion_exp = parametros.servidoresTiempoExpMedia;//
        this.servidores_limite_entregas = parametros.servidoresLimiteRetiro;// 
        this.servidores_tiempo_de_despacho_exp = parametros.servidoresRetiroTiempoExpMedia;//
        
        this.nroReplicas = parametros.nroReplicas;
        this.horasSimulacion = parametros.horasSimulacion;
        this.duracionSimulacion = horasSimulacion * 60.0;
        
        asignador_numero_ids = 0;
        servidores_atendidos_actuales = 0;
        servidores1_salidasTotales = 0;
        servidores2_salidasTotales = 0;
        sala_espera_clientes_de_pie = 0;
        despacho_actuales = 0;
        
        // Configura la cantidad de recursos (operarios, estaciones) disponibles por etapa
        estadisticas.setCantidadRecursos("LlenadoFormas", 1); // llenado de formularios
        estadisticas.setCantidadRecursos("ColaDePie", 1); //cola parados
        estadisticas.setCantidadRecursos("SalaDeEspera", 1); // Sala de espera
        estadisticas.setCantidadRecursos("Servidor1", 1); // Servidor 1
        estadisticas.setCantidadRecursos("Servidor2", 1); // Servidor 2
        estadisticas.setCantidadRecursos("Despacho", 1); // Despacho

        // Configura la ventana principal de simulación
        setTitle("Simulación Oficinas DIGEMIC"); // Título de la ventana
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
        agendarEvento(new Evento(0.0, () -> llegadaDeClientes()));

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
                        textArea.setText("=== Resultados de simulación ===\n");
                        textArea.append("Total clientes que ingresaron a la oficina: " + llegadas_salidas_totales + "\n");
                        textArea.append("Promedio de Personas Sentadas: " + (acumuladoPersonasSentadas / relojSimulado) + "\n");
                        textArea.append("Promedio de Personas Paradas: " + (acumuladoPersonasDePie / relojSimulado) + "\n");
                        textArea.append("Maximo de personas en sala de espera: " + maxOcupacionSalaDeEspera + "\n");
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
                for (PiezaVisual p : clientesVisuales) {
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
    
    // Método para registrar la llegada de los clientes a la recepción
    private void llegadaDeClientes() {
        // Asignamos un ID único al nuevo cliente incrementando el contador global
        int id = asignador_numero_ids++;
        System.out.println("[" + relojSimulado + "] Llegó cliente con ficha #" + id);

        // Se crea una representación visual del cliente, hombre o mujer, aleatoriamente
        PiezaVisual cliente;
        double nroaleatorio = Math.random(); // número aleatorio entre 0.0 y 1.0
        if(nroaleatorio <= 0.5){
            // Cliente hombre
            cliente = new PiezaVisual(id, 100, 350, imgHombreCaminandoMov.getImage(), 50, 100);
        } else {
            // Cliente mujer
            cliente = new PiezaVisual(id, 100, 350, imgMujerCaminandoMov.getImage(), 50, 100);
        }

        // Se agrega la visualización del cliente a la lista de clientes visuales activos
        clientesVisuales.add(cliente);

        // Se registra la entrada del cliente en el sistema para fines estadísticos
        estadisticas.registrarEntradaSistema(id, relojSimulado);

        // Se genera una probabilidad aleatoria para decidir a dónde va el cliente
        double prob = Math.random(); // número aleatorio entre 0.0 y 1.0
        double probSalaDeEspera = (double) probabilidad_a_sala_espera / 100; // probabilidad en formato decimal
        System.out.println("esta es la probabilidad de ir a sala de espera: " + probSalaDeEspera);

        // Si la probabilidad es menor o igual a la de ir a sala de espera, el cliente se dirige allí
        if (prob <= probSalaDeEspera) {
            double traslado = 2.0; // Tiempo en minutos que tarda en trasladarse a la sala de espera
            llegadas_salidas_totales++; // Se incrementa el contador de clientes que salieron del área de entrada
            cliente.moverA(400, 500, relojSimulado, traslado); // Se anima el movimiento del cliente
            System.out.println("[" + relojSimulado + "] Salió cliente con ficha # " + id + " a sala de espera");

            // Se agenda un evento futuro para manejar la llegada del cliente a la sala de espera
            agendarEvento(new Evento(relojSimulado + traslado, () -> {
                salaDeEspera(id);
            }));
        } else {
            // Si el cliente no va a la sala de espera, intenta ir al llenado de formularios

            if (llenadoFormulariosOcupado == false) {
                // Si el área de llenado de formularios está libre, el cliente va directamente
                double traslado = 2.0;
                llegadas_salidas_totales++;
                cliente.moverA(420, 115, relojSimulado, traslado);
                System.out.println("[" + relojSimulado + "] Salió cliente con ficha # " + id + " a llenar formulario");

                agendarEvento(new Evento(relojSimulado + traslado, () -> {
                    llenarFormulario(id); // Se inicia el llenado de formulario
                }));
            } else {
                // Si está ocupado, el cliente debe esperar un tiempo adicional
                System.out.println("[" + relojSimulado + "] cliente # " + id + " espera a ser atendido para llenar formulario");
                double tiempo_espera = 6.0; // Tiempo de espera adicional
                double traslado = 2.0;
                llegadas_salidas_totales++;
                cliente.moverA(400, 500, relojSimulado, traslado);
                System.out.println("[" + relojSimulado + "] Salió cliente con ficha # " + id + " a llenar formulario");

                agendarEvento(new Evento(relojSimulado + traslado + tiempo_espera, () -> {
                    llenarFormulario(id); // Después de esperar, se inicia el llenado de formulario
                }));
            }
        }

        // Finalmente, se agenda la llegada del próximo cliente
        double peronasLleganEn = 60.0 / llegada_tiempo_media_poisson; // tasa de llegada (clientes por minuto)
        double proxLlegada = getPoisson(peronasLleganEn); // tiempo hasta la siguiente llegada usando distribución de Poisson
//        System.out.println("----------------" + peronasLleganEn + "--------.----------------.");

        // Se agenda un nuevo evento para llamar nuevamente a este mismo método (recursivo en el tiempo simulado)
        agendarEvento(new Evento(relojSimulado + proxLlegada, () -> llegadaDeClientes()));
    }

    
    private void llenarFormulario(int idCliente) {
        // Si el área de llenado de formularios ya está ocupada
        if (llenadoFormulariosOcupado == true) {
            // Se añade el cliente a la cola de espera
            llenado_formas_cola_en_espera.add(idCliente);
            return; // Sale del método sin hacer nada más por ahora
        }
        // Marca el área de llenado de formularios como ocupada
        llenadoFormulariosOcupado = true;
        // Calcula el tiempo que tomará el proceso usando una distribución uniforme
        double tiempoProceso = (double) getUniforme(
            llenado_formas_tiempo_uniforme_media - llenado_formas_tiempo_uniforme_diferencia,
            llenado_formas_tiempo_uniforme_media + llenado_formas_tiempo_uniforme_diferencia
        );
        // Registra en las estadísticas cuánto tiempo estuvo ocupado el módulo
        estadisticas.agregarTiempoOcupado("LlenadoFormas", tiempoProceso);
        // Imprime en consola el inicio del llenado del formulario
        System.out.println("[" + relojSimulado + "] Inicia a llenar las formas #" + idCliente + " por " + tiempoProceso + " min");
        // Aumenta el contador de clientes actualmente en llenado de formularios
        llenado_formas_clientes_actuales++;
        // Agenda un evento para cuando el cliente termine de llenar el formulario
        agendarEvento(new Evento(relojSimulado + tiempoProceso, () -> finLlenadoFormulario(idCliente)));
    }

    //Metodo para realizar procesos en el fin de llenado de formulario
    private void finLlenadoFormulario(int idCliente){
        // Define el tiempo de traslado hacia la sala de espera
        double traslado = 2.0;
        // Libera el recurso de llenado de formularios
        llenadoFormulariosOcupado = false;
        // Busca al cliente por su ID para mover su representación visual
        PiezaVisual cliente = buscarClientePorId(idCliente);
        // Mueve visualmente al cliente a la ubicación de la sala de espera
        cliente.moverA(420, 500, relojSimulado, traslado);
        // Incrementa el número total de salidas del módulo de llenado
        llenado_formas_salidas_totales++;
        // Decrementa el número de clientes actualmente en el módulo de llenado
        llenado_formas_clientes_actuales--;
        // Agenda el evento en que el cliente llega efectivamente a la sala de espera
        agendarEvento(new Evento(relojSimulado + traslado, () -> {
            salaDeEspera(idCliente);
        }));
        // Si hay clientes esperando en la cola de llenado de formularios
        if (!llenado_formas_cola_en_espera.isEmpty()) {
            // Obtiene el siguiente cliente en la cola
            int siguiente = llenado_formas_cola_en_espera.poll();
            // Llama recursivamente a llenarFormulario para ese cliente
            llenarFormulario(siguiente);
        } else {
            // Si no hay más clientes esperando, se asegura de que el estado siga como no ocupado
            llenadoFormulariosOcupado = false;
        }
    }

    
    private void salaDeEspera(int idCliente) {
        // Actualiza los datos para calcular la ocupación promedio de la sala
        actualizarOcupacionPromedio();
        // Verifica si hay espacio para sentarse (capacidad máxima: 40)
        if (sala_espera_clientes_actuales < sala_espera_capacidad) {
            // Si hay espacio, el cliente se sienta
            // Se agrega el cliente a la cola de clientes sentados
            sala_espera_cola.add(idCliente);
            // Se incrementa el contador de clientes actualmente sentados
            sala_espera_clientes_actuales++;
            // Se actualiza el valor de máxima ocupación alcanzada en la sala
            actualizarMaxOcupacionSala();
            // Se guarda el momento en que el cliente se sentó, para estadísticas
            tiempoEntradaSala.put(idCliente, relojSimulado);
            // Se imprime que el cliente se ha sentado
            System.out.println("[" + relojSimulado + "] Cliente #" + idCliente + " entra y se sienta en la sala de espera.");
            // Si alguno de los dos servidores está libre, intentar enviarlo
            if (!servidor1Ocupado || !servidor2Ocupado) {
                double traslado = 2.0; // tiempo que toma llegar al servidor
                agendarEvento(new Evento(relojSimulado + traslado, () -> atencionServidores(idCliente)));
            } else {
                // Si ambos servidores están ocupados, se agenda una reintento más adelante
                double esperaExtra = 4.0;
                agendarEvento(new Evento(relojSimulado + 2.0 + esperaExtra, () -> atencionServidores(idCliente)));
            }
        } else {
            // Si no hay espacio sentado, el cliente entra y se queda de pie
            // Se agrega a la cola de pie
            sala_espera_cola_de_pie.add(idCliente);
            // Se incrementa el contador de personas de pie
            sala_espera_clientes_de_pie++;
            // Se actualiza la ocupación máxima registrada
            actualizarMaxOcupacionSala();
            // Se registra el momento en que el cliente se quedó de pie
            tiempoEntradaDePie.put(idCliente, relojSimulado);
            // Se muestra mensaje indicando que el cliente está de pie
            System.out.println("[" + relojSimulado + "] Cliente #" + idCliente + " entra a la sala y se queda de pie.");
        }
    }

    
    private void actualizarMaxOcupacionSala() {
        // Calcula la ocupación total actual (sentados + de pie)
        int ocupacionActual = sala_espera_clientes_actuales + sala_espera_clientes_de_pie;
        // Si esta ocupación supera el récord anterior, lo actualiza
        if (ocupacionActual > maxOcupacionSalaDeEspera) {
            maxOcupacionSalaDeEspera = ocupacionActual;
        }
    }

    
    private void actualizarOcupacionPromedio() {
        // Calcula el tiempo transcurrido desde la última actualización
        double tiempoTranscurrido = relojSimulado - ultimoTiempoActualizacion;
        if (tiempoTranscurrido > 0) {
            // Acumula tiempo * cantidad de personas sentadas durante ese periodo
            acumuladoPersonasSentadas += sala_espera_clientes_actuales * tiempoTranscurrido;
            // Acumula tiempo * cantidad de personas de pie durante ese periodo
            acumuladoPersonasDePie += sala_espera_clientes_de_pie * tiempoTranscurrido;
            // Actualiza el último momento en que se hizo el cálculo
            ultimoTiempoActualizacion = relojSimulado;
        }
    }


    
    private void atencionServidores(int idCliente) {
        // Verifica si el servidor 1 está libre
        if (!servidor1Ocupado) {
            servidor1Ocupado = true; // Marca el servidor 1 como ocupado
            sala_espera_salidas_totales++; // Aumenta contador de clientes que salen de la sala
            procesarEnServidor(1, idCliente); // Envia al cliente al servidor 1
        } 
        // Si el servidor 1 está ocupado, verifica si el servidor 2 está libre
        else if (!servidor2Ocupado) {
            servidor2Ocupado = true; // Marca el servidor 2 como ocupado
            sala_espera_salidas_totales++; // Aumenta contador de clientes que salen de la sala
            procesarEnServidor(2, idCliente); // Envia al cliente al servidor 2
        } 
        // Si ambos servidores están ocupados
        else {
            System.out.println("[" + relojSimulado + "] Ambos servidores ocupados, reintentando para cliente #" + idCliente);
            double reintento = 3.0; // Espera 3 minutos para reintentar
            // Agenda un nuevo intento de enviar al cliente a los servidores
            agendarEvento(new Evento(relojSimulado + reintento, () -> atencionServidores(idCliente)));
        }
    }

    private void procesarEnServidor(int numServidor, int idCliente) {
        // Genera un tiempo aleatorio de atención usando distribución exponencial
        double tiempoAtencion = getExponencial(servidores_tiempo_de_atencion_exp);
        // Busca el objeto visual que representa al cliente
        PiezaVisual cliente = buscarClientePorId(idCliente);
        // Si se encontró al cliente visualmente
        if (cliente != null) {
            // Si va al servidor 1
            if (numServidor == 1) {
                servidores_atendidos_actuales++; // Aumenta número de clientes atendidos actualmente
                estadisticas.agregarTiempoOcupado("Servidor1", tiempoAtencion); // Registra tiempo de uso del servidor 1
                cliente.moverA(700, 315, relojSimulado, 2.0); // Mueve visualmente al cliente al servidor 1
            } 
            // Si va al servidor 2
            else {
                servidores_atendidos_actuales++; // Aumenta número de clientes atendidos actualmente
                estadisticas.agregarTiempoOcupado("Servidor2", tiempoAtencion); // Registra tiempo de uso del servidor 2
                cliente.moverA(700, 500, relojSimulado, 2.0); // Mueve visualmente al cliente al servidor 2
            }
        }
        // Muestra mensaje en consola sobre el inicio de la atención
        System.out.println("[" + relojSimulado + "] Cliente #" + idCliente + " entra al servidor " + numServidor + ". Atención: " + tiempoAtencion);
        // Agenda el evento de fin de atención tras el tiempo de servicio
        agendarEvento(new Evento(relojSimulado + tiempoAtencion, () -> {
            finAtencionServidores(numServidor, idCliente); // Al finalizar, llama al método que libera el servidor
        }));
    }

    
    private void finAtencionServidores(int numServidor, int idCliente){
        servidores_atendidos_actuales--; // Disminuye el contador de clientes siendo atendidos
        servidores_salidas_totales++; // Aumenta el total de clientes que pasaron por servidores
        clienteSeRetiraDeSala(idCliente); // Marca al cliente como retirado de la sala de espera
        // Suma al contador de salidas del servidor correspondiente
        if(numServidor == 1) 
            servidores1_salidasTotales++;
        else 
            servidores2_salidasTotales++;
        liberarServidor(numServidor); // Marca el servidor como libre
        enviarADespacho(idCliente); // Envía al cliente a la siguiente etapa: despacho
    }


    private void clienteSeRetiraDeSala(int idCliente) {
        actualizarOcupacionPromedio(); // Actualiza el tiempo acumulado de ocupación promedio hasta el momento
        sala_espera_clientes_actuales--; // Disminuye el número de clientes sentados
        sala_espera_cola.remove(idCliente); // Elimina al cliente de la cola de sentados
        actualizarMaxOcupacionSala(); // Verifica si hubo un cambio en la ocupación máxima de la sala
        // Calcula el tiempo que el cliente estuvo sentado en la sala de espera
        Double entrada = tiempoEntradaSala.remove(idCliente); // Obtiene y elimina la hora de entrada
        if (entrada != null) {
            double tiempoEspera = relojSimulado - entrada;
            estadisticas.agregarTiempoOcupado("SalaDeEspera", tiempoEspera); // Registra ese tiempo en estadísticas
        }
        System.out.println("[" + relojSimulado + "] Cliente #" + idCliente + " se retira de la sala de espera.");
        // Verifica si hay clientes de pie esperando
        if (!sala_espera_cola_de_pie.isEmpty()) {
            int siguienteDePie = sala_espera_cola_de_pie.poll(); // Toma al primero que estaba de pie
            sala_espera_salidas_totales_clientes_de_pie++; // Registra su salida de la cola de pie
            sala_espera_cola.add(siguienteDePie); // Lo agrega a la cola de sentados
            sala_espera_clientes_de_pie--; // Disminuye contador de clientes de pie
            sala_espera_clientes_actuales++; // Aumenta contador de clientes sentados
            actualizarMaxOcupacionSala(); // Verifica si hubo un nuevo máximo

            // Calcula el tiempo que estuvo de pie
            Double entradaDePie = tiempoEntradaDePie.remove(siguienteDePie);
            if (entradaDePie != null) {
                double tiempoDePie = relojSimulado - entradaDePie;
                estadisticas.agregarTiempoOcupado("ColaDePie", tiempoDePie); // Registra en estadísticas
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            }
            // Asigna nueva hora de entrada como cliente sentado
            tiempoEntradaSala.put(siguienteDePie, relojSimulado);
            System.out.println("[" + relojSimulado + "] Cliente #" + siguienteDePie + " toma el asiento libre.");
            // Intenta enviarlo a un servidor si hay disponibilidad
            if (!servidor1Ocupado || !servidor2Ocupado) {
                double traslado = 2.0;
                agendarEvento(new Evento(relojSimulado + traslado, () -> atencionServidores(siguienteDePie)));
            } else {
                // Si no hay servidores disponibles, espera más tiempo
                double esperaExtra = 4.0;
                agendarEvento(new Evento(relojSimulado + 2.0 + esperaExtra, () -> atencionServidores(siguienteDePie)));
            }
        }
    }

    private void liberarServidor(int numServidor) {
        if (numServidor == 1) servidor1Ocupado = false; // Libera servidor 1 si corresponde
        if (numServidor == 2) servidor2Ocupado = false; // Libera servidor 2 si corresponde
    }

    private void enviarADespacho(int idCliente) {
        servidores_cola_despacho.add(idCliente); // Agrega al cliente a la cola de despacho
        despacho_actuales++; // Aumenta contador de clientes en despacho
        System.out.println(servidores_cola_despacho.size() + "------------------- Cola despacho");
        // Busca representación visual del cliente
        PiezaVisual cliente = buscarClientePorId(idCliente);
        if (cliente != null) {
            cliente.moverA(700, 100, relojSimulado, 2.0); // Mueve visualmente al cliente hacia despacho
        }
        System.out.println("[" + relojSimulado + "] Cliente #" + idCliente + " pasa a despacho.");
        // Si la cola alcanza el límite definido, intenta iniciar despacho grupal
        if (servidores_cola_despacho.size() == servidores_limite_entregas) {
            if (!servidor1Ocupado) {
                iniciarDespachoGrupal(1); // Usa servidor 1 si está libre
            } else if (!servidor2Ocupado) {
                iniciarDespachoGrupal(2); // Usa servidor 2 si está libre
            }
        }
    }
    
    private void iniciarDespachoGrupal(int numServidor) {
        double tiempoDespacho = getExponencial(servidores_tiempo_de_despacho_exp); // media 5
        estadisticas.agregarTiempoOcupado("Despacho", tiempoDespacho);
        java.util.List<Integer> clientesADespachar = new ArrayList<>();

        // Sacamos los primeros 10 clientes
        for (int i = 0; i < servidores_limite_entregas && !servidores_cola_despacho.isEmpty(); i++) {
            clientesADespachar.add(servidores_cola_despacho.poll());
        }

        // Marcar el servidor como ocupado
        if (numServidor == 1){
            servidor1Ocupado = true;
            boolAux1 = true;
        }else{
            servidor2Ocupado = true;
            boolAux2 = true;
        } 

        // Mover clientes visualmente a la salida
        for (int idCliente : clientesADespachar) {
            PiezaVisual cliente = buscarClientePorId(idCliente);
            if (cliente != null) {
                estadisticas.registrarSalidaSistema(idCliente, relojSimulado);
                cliente.moverA(900, 100, relojSimulado, 2.0); // Movimiento hacia salida
            }
        }

        System.out.println("[" + relojSimulado + "] Inicia despacho grupal en Servidor " + numServidor + " para 10 clientes. Tiempo: " + tiempoDespacho);

        // Evento para finalizar despacho y eliminar clientes visualmente
        agendarEvento(new Evento(relojSimulado + tiempoDespacho, () -> {
            for (int idCliente : clientesADespachar) {
                System.out.println("[" + relojSimulado + "] Cliente #" + idCliente + " fue despachado.");
                eliminarClienteVisual(idCliente); // Método que debes tener para quitar la imagen
            }

            // Liberar el servidor
            if (numServidor == 1){
                servidor1Ocupado = false;
                boolAux1 = false;
            }else{
                servidor2Ocupado = false;
                boolAux2 = false;
            } 

            // Si aún hay otros 10 esperando, intentamos otro despacho
            if (servidores_cola_despacho.size() >= servidores_limite_entregas) {
                if (!servidor1Ocupado) iniciarDespachoGrupal(1);
                else if (!servidor2Ocupado) iniciarDespachoGrupal(2);
            }
        }));
    }

    private void eliminarClienteVisual(int idCliente) {
        PiezaVisual cliente = buscarClientePorId(idCliente);
        if (cliente != null) {
            clientesVisuales.remove(cliente); // o el contenedor visual que estés usando
            panelSimulacion.repaint(); // o el panel donde se dibujan
        }
    }

    // Devuelve un número aleatorio a partir de una distribución exponencial con la media especificada
    private double getExponencial(double media) {
        return new ExponentialDistribution(media).sample();
    }
    
    private double getPoisson(double media){
        return new PoissonDistribution(media).sample();
    }
    
    private double getUniforme(int min, int max){
        return new UniformIntegerDistribution(min,max).sample();
    }

    
    // Busca una pieza visual por su ID entre todas las piezas visuales activas
    private PiezaVisual buscarClientePorId(int id) {
        for (PiezaVisual p : clientesVisuales) {
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
            //dibujamos el piso y la ciudad en sus respectivas posiciones
            g.drawImage(imgPiso2.getImage(), 0, 0, 1000, 700, this);
            g.drawImage(imgCiudad.getImage(), 0, 0, 150, 700, this);
            g.drawImage(imgCalle.getImage(), 1000, 0, 300, 700, this);
            
            
            // puerta de ingreso
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(120, 250, 100, 50);
            
            g.setColor(Color.BLACK);
            g.drawImage(imgPuertaIngreso.getImage(), 50, 300, 220, 150, this);
            g.drawString("Puerta Ingreso", 135, 265);
            g.setColor(Color.BLACK);
//            g.drawString("Operativos: " + fabrica_Contador_Cantidad_Actuales, 125, 480);
            g.drawString("salidas: " + llegadas_salidas_totales, 125, 295);
            
//            g.drawImage(imgPistaHorizontal.getImage(), 215, 550, 200, 50, this);
            
            //Llenado de formularios
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(420, 50, 120, 80);

            g.setColor(Color.BLACK);
            g.drawString("FORMAS", 435, 65);
            g.drawString("llenando Formas: " + llenado_formas_clientes_actuales, 425, 105);
            g.drawString("Salidas: " + llenado_formas_salidas_totales, 425, 85);
            g.drawImage(imgLlenadoFormasMov.getImage(), 420, 115, 100, 100, this);
            
            // sala de espera
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(410, 450, 130, 150);
            
            g.setColor(Color.BLACK);
            
            g.drawString("SALA DE ESPERA", 430, 465);
            g.drawString("esperando: " + sala_espera_clientes_actuales, 420, 480);
            g.drawString("salidas: " + sala_espera_salidas_totales, 420, 495);
            estadisticas.totalClientesSalaEspera(sala_espera_salidas_totales);
            g.drawImage(imgSalaEspera.getImage(), 390, 500, 150, 100, this);
            
//            if(sala_espera_clientes_actuales > sala_espera_capacidad){
                 g.drawImage(imgColaDePie.getImage(), 240, 500, 150, 100, this);
                 g.setColor(Color.WHITE);
                 g.fillRect(100, 500, 120, 70);
                 g.setColor(Color.BLACK);
                 g.drawString("CLIENTES DE PIE", 110, 520);
                 g.drawString("De Pie: " + sala_espera_clientes_de_pie, 105, 540);
                 g.drawString("Salidas: " + sala_espera_salidas_totales_clientes_de_pie, 105, 560);
                 estadisticas.totalClientesSalaEsperaDePie(sala_espera_salidas_totales_clientes_de_pie);
//            }else{}
            
            //servidores
            //Servidor1
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(700, 300, 250, 130);
            
            g.setColor(Color.BLACK);
            g.drawString("SERVIDOR 1", 855, 320);
            
            int aux = 0;
            if (servidor2Ocupado == true) aux = 1;
            else aux = 0;
            
            g.drawString("salidas: " + servidores1_salidasTotales, 840, 340);
            g.drawString("atendiendo: " + aux, 840, 360);
            g.drawImage(imgServidor1Mov.getImage(), 700, 280, 150, 150, this);
            
            //Servidor2
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(700, 480, 250, 130);
            
            //variables servidor 2
            g.setColor(Color.BLACK);
            g.drawString("SERVIDOR 2", 855, 495);
            
            int nro = 0;
            if (servidor2Ocupado == true) nro = 1;
            else nro = 0;
            
            g.drawString("salidas: " + servidores2_salidasTotales, 840, 520);
            g.drawString("Atendiendo: " + nro, 840, 540);
            g.drawImage(imgServidor2Mov.getImage(), 700, 480, 150, 150, this);
            
            //variables generales de servidores
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(750, 230, 150, 50);
            g.setColor(Color.BLACK);
            g.drawString("salidas totales: " + servidores_salidas_totales, 760, 250);
            
            //lugar de despacho
            g.setColor(Color.WHITE);
            // Dibujar un rectángulo blanco 
            g.fillRect(700, 100, 100, 100);
            g.drawImage(imgDespacho.getImage(), 700, 100, 100, 100, this);
            
            if(boolAux1 == true){
                g.setColor(Color.GRAY);
                g.fillRect(700, 300, 130, 130);
                g.setColor(Color.BLACK);
                g.drawString("DESPACHANDO", 715, 375);
            }else{
                
            }
            
            if(boolAux2 == true){
                g.setColor(Color.GRAY);
                g.fillRect(700, 480, 130, 130);
                g.setColor(Color.BLACK);
                g.drawString("DESPACHANDO", 715, 550);
            }else{
                
            }
            
            //Salida
            g.drawImage(imgSalida.getImage(), 900, 100, 100, 100, this);
            
            for (PiezaVisual p : clientesVisuales) {
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
