package lab8p2_mejorado;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 *
 * @author emili
 */
public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    private ArrayList<User> user = new ArrayList();
    private ArrayList<Admin> admin = new ArrayList();
    private ArrayList<Jugador> jugador = new ArrayList();
    private DefaultTableModel tableM;
    private ArrayList<Carro> listaCarro = new ArrayList();
    hiloCarga pb, pb2;
    private DefaultListModel listaModel;
    
    
    public principal() {
        initComponents();
        
        tableM = new  DefaultTableModel();
        tableM.addColumn("Marca");
        tableM.addColumn("Modelo");
        tableM.addColumn("Anio");
        tableM.addColumn("Color");
        tableM.addColumn("Precio");
        
        jT_garaje = new JTable(tableM);
        
        jT_compra = new JTable();
        tableM = new DefaultTableModel();
        jT_compra.setModel(tableM);

        add(jT_compra);
        
        jT_venta = new JTable();
        tableM = new DefaultTableModel();
        jT_venta.setModel(tableM);
        
        add(jT_venta);
    
        
        jL_mejoras = new JList();
        jL_mejoras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jL_mejoras.setLayoutOrientation(JList.VERTICAL);

        add(jL_mejoras);
    
    }
    public void actualizarTablaConcesionaria(List<Carro> carrosDisponibles) {
        tableM.setRowCount(0);
        for (Carro carro : carrosDisponibles) {
            Object[] rowData = {carro.getMarca(), carro.getModelo(), carro.getPrecio(), carro.getColor()};
            tableM.addRow(rowData);
        }
    }
    public boolean UsuarioExistente(String usuario) {
        for (int i = 0; i < user.size(); i++) {
            if (usuario.equals(user.get(i).getNombreU())) {
                return true;
            }
        }
        return false;
    }
    
    public void actualizarListaMejoras(List<Parte> partesDisponibles) {
        DefaultListModel<Parte> modeloLista = new DefaultListModel<>();

        for (Parte parte : partesDisponibles) {
            modeloLista.addElement(parte);
        }
        jL_mejoras.setModel(listaModel);
    }
    
    private void cargarTabla() {
        limpiarTabla();
        
        for (Carro carro : listaCarro) {
            Object[] fila = {carro.getMarca(), carro.getModelo(), carro.getPrecio(), carro.getColor()};
            tableM.addRow(fila);
        }
    }    
    private void limpiarTabla() {
        while (tableM.getRowCount() > 0) {
            tableM.removeRow(0);
        }
    }
    
    
    public boolean ConfirmarFecha(String fecha) {
        int fechaInt = Integer.parseInt(fecha);
        int anio = (2023 - fechaInt);
        if (fecha.matches("\\d{4}")) {
            return false;
        }

        return anio > 12;
    }

    public boolean UsuarioEntrar(String nombre, String password) {
        String name = tf_nombreUsuario.getText();
        String pass = pf_password.getText();
        for (User user1 : user) {
            if (name.equals(user1.getNombreU()) && pass.equals(user1.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public boolean AdminEntrar(String nombre, String password) {
        String name = tf_nombreUsuario.getText();
        String pass = pf_password.getText();
        for (Admin adm : admin) {
            if (name.equals(adm.getNombreU()) && pass.equals(adm.getPassword())) {
                return true;
            }
        }
        return false;
    }
    private void comprarCarroSeleccionado() {
        int filaSeleccionada = jT_compra.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener información del carro seleccionado
            int idCarro = (int) tableM.getValueAt(filaSeleccionada, 0);
            String modeloCarro = (String) tableM.getValueAt(filaSeleccionada, 1);
            int precioCarro = (int) tableM.getValueAt(filaSeleccionada, 2);

            boolean compraExitosa = user.contains(new Carro(idCarro, modeloCarro, precioCarro));

            if (compraExitosa) {
                tableM.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(this, "La compra se ha realizada con éxito");
            } else {
                JOptionPane.showMessageDialog(this, "No tienes suficiente dinero para comprar este carro");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un carro antes de comprar");
        }
    }    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        d_crearUsuario = new javax.swing.JDialog();
        p_crearUsuario = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tf_nombreOG = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        tf_crearUsuario = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        tf_correo = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        tf_crearPassword = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        cb_pais = new javax.swing.JComboBox<>();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        ff_fechaNacimiento = new javax.swing.JFormattedTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        b_crear = new javax.swing.JButton();
        b_regresar = new javax.swing.JButton();
        d_crearAdmin = new javax.swing.JDialog();
        p_crearAdmin = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        tf_crearUsuario1 = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        tf_correo1 = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        tf_crearPassword1 = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        cb_pais1 = new javax.swing.JComboBox<>();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        ff_fechaNacimiento1 = new javax.swing.JFormattedTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        b_crear1 = new javax.swing.JButton();
        b_regresar1 = new javax.swing.JButton();
        d_paginaU = new javax.swing.JDialog();
        tp_main = new javax.swing.JTabbedPane();
        p_jugadores = new javax.swing.JPanel();
        tp_jugador = new javax.swing.JTabbedPane();
        p_cj = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tf_puntos = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        tf_dinero = new javax.swing.JTextField();
        b_crearP = new javax.swing.JButton();
        p_bj = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        t_listarJ = new javax.swing.JTable();
        p_mj = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        p_ej = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        p_compra = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jT_compra = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        pb_compra = new javax.swing.JProgressBar();
        p_ventas = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jT_venta = new javax.swing.JTable();
        p_instMV = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jL_mejoras = new javax.swing.JList<>();
        jPanel20 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pb_carro1 = new javax.swing.JProgressBar();
        pb_carro2 = new javax.swing.JProgressBar();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jT_garaje1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jT_garaje = new javax.swing.JTable();
        d_paginaA = new javax.swing.JDialog();
        p_paginaAdmin = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel22 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        b_crearC = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jPanel24 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        t_listarC = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        p_IniciarSesionU = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        tf_nombreUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        pf_password = new javax.swing.JPasswordField();
        b_iniciarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        b_crearCuenta = new javax.swing.JButton();
        b_entrarAdmin = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        pb_carga = new javax.swing.JProgressBar();
        p_IniciarSesionA = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        tf_nombreUsuario1 = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        pf_password1 = new javax.swing.JPasswordField();
        b_iniciarSesionA = new javax.swing.JButton();
        jSeparator19 = new javax.swing.JSeparator();
        b_entrarUser = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        b_crearCuentaA = new javax.swing.JButton();

        d_crearUsuario.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p_crearUsuario.setBackground(new java.awt.Color(255, 255, 255));
        p_crearUsuario.setMinimumSize(new java.awt.Dimension(700, 400));
        p_crearUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nombre");
        p_crearUsuario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 70, -1));

        tf_nombreOG.setBackground(new java.awt.Color(255, 255, 255));
        tf_nombreOG.setFont(new java.awt.Font("OCR A Extended", 1, 10)); // NOI18N
        tf_nombreOG.setForeground(new java.awt.Color(0, 0, 0));
        tf_nombreOG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombreOGActionPerformed(evt);
            }
        });
        p_crearUsuario.add(tf_nombreOG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 320, -1));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        p_crearUsuario.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 360, 10));

        jLabel5.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Usuario");
        p_crearUsuario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 90, -1));

        tf_crearUsuario.setBackground(new java.awt.Color(255, 255, 255));
        tf_crearUsuario.setFont(new java.awt.Font("OCR A Extended", 1, 10)); // NOI18N
        tf_crearUsuario.setForeground(new java.awt.Color(0, 0, 0));
        p_crearUsuario.add(tf_crearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 320, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        p_crearUsuario.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 360, 10));

        jLabel8.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Su Correo Electronico");
        p_crearUsuario.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 170, -1));

        tf_correo.setBackground(new java.awt.Color(255, 255, 255));
        tf_correo.setFont(new java.awt.Font("OCR A Extended", 1, 10)); // NOI18N
        tf_correo.setForeground(new java.awt.Color(0, 0, 0));
        p_crearUsuario.add(tf_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 320, -1));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        p_crearUsuario.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 360, 10));

        jLabel9.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Password");
        p_crearUsuario.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 90, -1));

        tf_crearPassword.setBackground(new java.awt.Color(255, 255, 255));
        tf_crearPassword.setFont(new java.awt.Font("OCR A Extended", 1, 10)); // NOI18N
        tf_crearPassword.setForeground(new java.awt.Color(0, 0, 0));
        tf_crearPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_crearPasswordActionPerformed(evt);
            }
        });
        p_crearUsuario.add(tf_crearPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 320, -1));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        p_crearUsuario.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 360, 10));

        jLabel11.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Pais de Residencia");
        p_crearUsuario.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 150, -1));

        cb_pais.setBackground(new java.awt.Color(255, 255, 255));
        cb_pais.setFont(new java.awt.Font("OCR A Extended", 1, 10)); // NOI18N
        cb_pais.setForeground(new java.awt.Color(0, 0, 0));
        cb_pais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estados Unidos", "Japan", "Italia", "Alemania", "Francia", "UK", "Sweden" }));
        cb_pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_paisActionPerformed(evt);
            }
        });
        p_crearUsuario.add(cb_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 320, -1));

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        p_crearUsuario.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 360, 10));

        jLabel12.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Ingrese su año de Nacimiento");
        p_crearUsuario.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 230, -1));

        ff_fechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        ff_fechaNacimiento.setForeground(new java.awt.Color(0, 0, 0));
        ff_fechaNacimiento.setFont(new java.awt.Font("OCR A Extended", 1, 10)); // NOI18N
        p_crearUsuario.add(ff_fechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 330, -1));

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        p_crearUsuario.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 360, 10));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        p_crearUsuario.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 20, 330));

        jLabel20.setFont(new java.awt.Font("Broadway", 2, 30)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("CREAR CUENTA");
        p_crearUsuario.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 260, -1));

        jLabel7.setFont(new java.awt.Font("Broadway", 2, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Como Usuario");
        p_crearUsuario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 230, -1));

        b_crear.setFont(new java.awt.Font("Broadway", 1, 18)); // NOI18N
        b_crear.setForeground(new java.awt.Color(0, 0, 0));
        b_crear.setText("Crear");
        b_crear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_crear.setContentAreaFilled(false);
        b_crear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_crearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_crearMouseExited(evt);
            }
        });
        b_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_crearActionPerformed(evt);
            }
        });
        p_crearUsuario.add(b_crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 70, 20));

        b_regresar.setFont(new java.awt.Font("Broadway", 1, 18)); // NOI18N
        b_regresar.setForeground(new java.awt.Color(0, 0, 0));
        b_regresar.setText("Regresar");
        b_regresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_regresar.setContentAreaFilled(false);
        b_regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_regresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_regresarMouseExited(evt);
            }
        });
        b_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_regresarActionPerformed(evt);
            }
        });
        p_crearUsuario.add(b_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 100, 20));

        d_crearUsuario.getContentPane().add(p_crearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        d_crearAdmin.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p_crearAdmin.setBackground(new java.awt.Color(255, 255, 255));
        p_crearAdmin.setMinimumSize(new java.awt.Dimension(700, 400));
        p_crearAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Usuario");
        p_crearAdmin.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 90, -1));

        tf_crearUsuario1.setBackground(new java.awt.Color(255, 255, 255));
        tf_crearUsuario1.setFont(new java.awt.Font("OCR A Extended", 1, 10)); // NOI18N
        tf_crearUsuario1.setForeground(new java.awt.Color(0, 0, 0));
        p_crearAdmin.add(tf_crearUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 320, -1));

        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));
        p_crearAdmin.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 360, 10));

        jLabel14.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Su Correo Electronico");
        p_crearAdmin.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 170, -1));

        tf_correo1.setBackground(new java.awt.Color(255, 255, 255));
        tf_correo1.setFont(new java.awt.Font("OCR A Extended", 1, 10)); // NOI18N
        tf_correo1.setForeground(new java.awt.Color(0, 0, 0));
        p_crearAdmin.add(tf_correo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 320, -1));

        jSeparator13.setForeground(new java.awt.Color(0, 0, 0));
        p_crearAdmin.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 360, 10));

        jLabel15.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Password");
        p_crearAdmin.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, -1));

        tf_crearPassword1.setBackground(new java.awt.Color(255, 255, 255));
        tf_crearPassword1.setFont(new java.awt.Font("OCR A Extended", 1, 10)); // NOI18N
        tf_crearPassword1.setForeground(new java.awt.Color(0, 0, 0));
        tf_crearPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_crearPassword1ActionPerformed(evt);
            }
        });
        p_crearAdmin.add(tf_crearPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 320, -1));

        jSeparator14.setForeground(new java.awt.Color(0, 0, 0));
        p_crearAdmin.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 360, 10));

        jLabel16.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Pais de Residencia");
        p_crearAdmin.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 150, -1));

        cb_pais1.setBackground(new java.awt.Color(255, 255, 255));
        cb_pais1.setFont(new java.awt.Font("OCR A Extended", 1, 10)); // NOI18N
        cb_pais1.setForeground(new java.awt.Color(0, 0, 0));
        cb_pais1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estados Unidos", "Japan", "Italia", "Alemania", "Francia", "UK", "Sweden" }));
        p_crearAdmin.add(cb_pais1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 320, -1));

        jSeparator15.setForeground(new java.awt.Color(0, 0, 0));
        p_crearAdmin.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 360, 10));

        jLabel17.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Ingrese su año de Nacimiento");
        p_crearAdmin.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 230, -1));

        ff_fechaNacimiento1.setBackground(new java.awt.Color(255, 255, 255));
        ff_fechaNacimiento1.setForeground(new java.awt.Color(0, 0, 0));
        ff_fechaNacimiento1.setFont(new java.awt.Font("OCR A Extended", 1, 10)); // NOI18N
        p_crearAdmin.add(ff_fechaNacimiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 330, -1));

        jSeparator16.setForeground(new java.awt.Color(0, 0, 0));
        p_crearAdmin.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 360, 10));

        jSeparator17.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);
        p_crearAdmin.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 20, 330));

        jLabel19.setFont(new java.awt.Font("Broadway", 2, 30)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("CREAR CUENTA");
        p_crearAdmin.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 260, -1));

        jLabel18.setFont(new java.awt.Font("Broadway", 2, 30)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Como Admin");
        p_crearAdmin.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 230, -1));

        b_crear1.setFont(new java.awt.Font("Broadway", 1, 18)); // NOI18N
        b_crear1.setForeground(new java.awt.Color(0, 0, 0));
        b_crear1.setText("Crear");
        b_crear1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_crear1.setContentAreaFilled(false);
        b_crear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_crear1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_crear1MouseExited(evt);
            }
        });
        b_crear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_crear1ActionPerformed(evt);
            }
        });
        p_crearAdmin.add(b_crear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 70, 20));

        b_regresar1.setFont(new java.awt.Font("Broadway", 1, 18)); // NOI18N
        b_regresar1.setForeground(new java.awt.Color(0, 0, 0));
        b_regresar1.setText("Regresar");
        b_regresar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_regresar1.setContentAreaFilled(false);
        b_regresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_regresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_regresar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_regresar1MouseExited(evt);
            }
        });
        b_regresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_regresar1ActionPerformed(evt);
            }
        });
        p_crearAdmin.add(b_regresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 100, 20));

        d_crearAdmin.getContentPane().add(p_crearAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        d_paginaU.setMinimumSize(new java.awt.Dimension(700, 400));
        d_paginaU.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tp_main.setBackground(new java.awt.Color(255, 255, 255));
        tp_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tp_main.setForeground(new java.awt.Color(0, 0, 0));
        tp_main.setFont(new java.awt.Font("Broadway", 0, 12)); // NOI18N
        tp_main.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tp_mainStateChanged(evt);
            }
        });

        p_jugadores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tp_jugador.setBackground(new java.awt.Color(255, 255, 255));
        tp_jugador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tp_jugador.setForeground(new java.awt.Color(0, 0, 0));
        tp_jugador.setFont(new java.awt.Font("Broadway", 0, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Ingrese Nombre del Jugador:");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        tf_nombre.setBackground(new java.awt.Color(255, 255, 255));
        tf_nombre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(tf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 170, -1));

        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Puntos de Reputacion: ");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        tf_puntos.setEditable(false);
        tf_puntos.setBackground(new java.awt.Color(255, 255, 255));
        tf_puntos.setForeground(new java.awt.Color(0, 0, 0));
        tf_puntos.setText("100 p");
        jPanel3.add(tf_puntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 170, -1));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Dinero:");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        tf_dinero.setEditable(false);
        tf_dinero.setBackground(new java.awt.Color(255, 255, 255));
        tf_dinero.setForeground(new java.awt.Color(0, 0, 0));
        tf_dinero.setText("150000");
        jPanel3.add(tf_dinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 170, -1));

        b_crearP.setText("Crear");
        b_crearP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_crearP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_crearPActionPerformed(evt);
            }
        });
        jPanel3.add(b_crearP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 170, -1));

        javax.swing.GroupLayout p_cjLayout = new javax.swing.GroupLayout(p_cj);
        p_cj.setLayout(p_cjLayout);
        p_cjLayout.setHorizontalGroup(
            p_cjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        p_cjLayout.setVerticalGroup(
            p_cjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
        );

        tp_jugador.addTab("Crear Jugador", p_cj);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_listarJ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Puntos", "Dinero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(t_listarJ);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 510, 220));

        javax.swing.GroupLayout p_bjLayout = new javax.swing.GroupLayout(p_bj);
        p_bj.setLayout(p_bjLayout);
        p_bjLayout.setHorizontalGroup(
            p_bjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );
        p_bjLayout.setVerticalGroup(
            p_bjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_bjLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tp_jugador.addTab("Listar Jugador", p_bj);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout p_mjLayout = new javax.swing.GroupLayout(p_mj);
        p_mj.setLayout(p_mjLayout);
        p_mjLayout.setHorizontalGroup(
            p_mjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );
        p_mjLayout.setVerticalGroup(
            p_mjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_mjLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tp_jugador.addTab("Modificar Jugador", p_mj);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout p_ejLayout = new javax.swing.GroupLayout(p_ej);
        p_ej.setLayout(p_ejLayout);
        p_ejLayout.setHorizontalGroup(
            p_ejLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );
        p_ejLayout.setVerticalGroup(
            p_ejLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ejLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tp_jugador.addTab("Eliminar Jugador", p_ej);

        p_jugadores.add(tp_jugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 79, 690, 290));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        p_jugadores.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 370));

        tp_main.addTab("Jugadores", p_jugadores);

        p_compra.setBackground(new java.awt.Color(255, 255, 255));
        p_compra.setEnabled(false);
        p_compra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel18.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        p_compra.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 183, -1, -1));

        jT_compra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Marca", "Modelo"
            }
        ));
        jScrollPane6.setViewportView(jT_compra);

        p_compra.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 286));

        jButton3.setText("Comprar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        p_compra.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));
        p_compra.add(pb_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 550, 20));

        tp_main.addTab("Compra", p_compra);

        p_ventas.setBackground(new java.awt.Color(255, 255, 255));
        p_ventas.setEnabled(false);
        p_ventas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        p_ventas.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 183, -1, -1));

        jT_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(jT_venta);

        p_ventas.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 56, 435, 233));

        tp_main.addTab("Ventas", p_ventas);

        p_instMV.setEnabled(false);
        p_instMV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_mejoras.setBackground(new java.awt.Color(255, 255, 255));
        jL_mejoras.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jL_mejoras.setForeground(new java.awt.Color(0, 0, 0));
        jL_mejoras.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(jL_mejoras);

        p_instMV.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 6, 290, 355));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel20.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        p_instMV.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 370));

        tp_main.addTab("Instalacion de Mejoras Visuales", p_instMV);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(pb_carro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 570, 30));
        jPanel1.add(pb_carro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 560, 30));

        jLabel32.setText("Carro 2");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));

        jLabel33.setText("Carro 1");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jButton2.setText("Iniciar Carrera");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        jT_garaje1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Marca", "Modelo", "Anio", "Color", "Precio", "Estado"
            }
        ));
        jScrollPane8.setViewportView(jT_garaje1);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 550, 100));

        tp_main.addTab("Carrera", jPanel1);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jT_garaje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Marca", "Modelo", "Anio", "Color", "Precio", "Estado"
            }
        ));
        jScrollPane2.setViewportView(jT_garaje);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 550, 240));

        tp_main.addTab("Garaje", jPanel8);

        d_paginaU.getContentPane().add(tp_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 400));

        d_paginaA.setMinimumSize(new java.awt.Dimension(700, 400));

        p_paginaAdmin.setBackground(new java.awt.Color(255, 255, 255));
        p_paginaAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p_paginaAdmin.setForeground(new java.awt.Color(0, 0, 0));
        p_paginaAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Ingrese el pais de residencia del carro: ");
        jPanel9.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Ingrese marca de carro: ");
        jPanel9.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 16, -1, -1));

        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Ingrese el modelo del carro: ");
        jPanel9.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Ingrese el color del carro: ");
        jPanel9.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel9.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 170, -1));

        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel9.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, -1));

        jFormattedTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jFormattedTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel9.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 170, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Color");
        jPanel9.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 170, -1));

        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Ingrese el precio del carro: ");
        jPanel9.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estados Unidos", "Japan", "Italia", "Alemania", "Francia", "UK", "Sweden" }));
        jPanel9.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 220, -1));

        b_crearC.setText("Crear");
        b_crearC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_crearC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_crearCActionPerformed(evt);
            }
        });
        jPanel9.add(b_crearC, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        jPanel22.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 370));

        jTabbedPane1.addTab("Crear Carro", jPanel22);

        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setForeground(new java.awt.Color(0, 0, 0));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList3);

        jPanel10.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 272, 301));

        jPanel23.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 370));

        jTabbedPane1.addTab("Modificar Carro", jPanel23);

        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setForeground(new java.awt.Color(0, 0, 0));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_listarC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Modelo", "Marca", "Color", "Pais", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(t_listarC);

        jPanel11.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 550, 310));

        jPanel24.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 370));

        jTabbedPane1.addTab("Listar Carro", jPanel24);

        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setForeground(new java.awt.Color(0, 0, 0));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel25.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 370));

        jTabbedPane1.addTab("Modificar Carro", jPanel25);

        p_paginaAdmin.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        javax.swing.GroupLayout d_paginaALayout = new javax.swing.GroupLayout(d_paginaA.getContentPane());
        d_paginaA.getContentPane().setLayout(d_paginaALayout);
        d_paginaALayout.setHorizontalGroup(
            d_paginaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(d_paginaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d_paginaALayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(p_paginaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        d_paginaALayout.setVerticalGroup(
            d_paginaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(d_paginaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d_paginaALayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(p_paginaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p_IniciarSesionU.setBackground(new java.awt.Color(255, 255, 255));
        p_IniciarSesionU.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Broadway", 2, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Iniciar Sesión COMO USUARIO");
        p_IniciarSesionU.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 580, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        p_IniciarSesionU.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 440, 10));

        jLabel3.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Usuario");
        p_IniciarSesionU.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 70, -1));

        tf_nombreUsuario.setBackground(new java.awt.Color(255, 255, 255));
        tf_nombreUsuario.setForeground(new java.awt.Color(0, 0, 0));
        p_IniciarSesionU.add(tf_nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 330, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        p_IniciarSesionU.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 400, 10));

        jLabel4.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Password");
        p_IniciarSesionU.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 80, -1));

        pf_password.setBackground(new java.awt.Color(255, 255, 255));
        pf_password.setForeground(new java.awt.Color(0, 0, 0));
        p_IniciarSesionU.add(pf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 330, -1));

        b_iniciarSesion.setFont(new java.awt.Font("Broadway", 0, 14)); // NOI18N
        b_iniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        b_iniciarSesion.setText("Iniciar Sesion");
        b_iniciarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_iniciarSesion.setContentAreaFilled(false);
        b_iniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_iniciarSesion.setFocusPainted(false);
        b_iniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_iniciarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_iniciarSesionMouseExited(evt);
            }
        });
        b_iniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_iniciarSesionActionPerformed(evt);
            }
        });
        p_IniciarSesionU.add(b_iniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 120, -1));

        jLabel1.setFont(new java.awt.Font("Broadway", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Si aun no tiene una cuenta entonces haga");
        p_IniciarSesionU.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 230, -1));

        b_crearCuenta.setFont(new java.awt.Font("Broadway", 0, 10)); // NOI18N
        b_crearCuenta.setForeground(new java.awt.Color(102, 102, 102));
        b_crearCuenta.setText("CLICK AQUI");
        b_crearCuenta.setBorder(null);
        b_crearCuenta.setBorderPainted(false);
        b_crearCuenta.setContentAreaFilled(false);
        b_crearCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_crearCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_crearCuentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_crearCuentaMouseExited(evt);
            }
        });
        b_crearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_crearCuentaActionPerformed(evt);
            }
        });
        p_IniciarSesionU.add(b_crearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, -1));

        b_entrarAdmin.setFont(new java.awt.Font("Broadway", 0, 14)); // NOI18N
        b_entrarAdmin.setForeground(new java.awt.Color(0, 0, 0));
        b_entrarAdmin.setText("Entrar Como Admin");
        b_entrarAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_entrarAdmin.setContentAreaFilled(false);
        b_entrarAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_entrarAdmin.setFocusPainted(false);
        b_entrarAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_entrarAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_entrarAdminMouseExited(evt);
            }
        });
        b_entrarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_entrarAdminActionPerformed(evt);
            }
        });
        p_IniciarSesionU.add(b_entrarAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 170, -1));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        p_IniciarSesionU.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 10, 40));
        p_IniciarSesionU.add(pb_carga, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 581, 25));

        getContentPane().add(p_IniciarSesionU, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        p_IniciarSesionA.setMinimumSize(new java.awt.Dimension(700, 400));
        p_IniciarSesionA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Broadway", 2, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Iniciar Sesión COMO ADMIN");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 580, -1));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 440, 10));

        jLabel21.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Usuario");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 70, -1));

        tf_nombreUsuario1.setBackground(new java.awt.Color(255, 255, 255));
        tf_nombreUsuario1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(tf_nombreUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 330, -1));

        jSeparator18.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 400, 10));

        jLabel22.setFont(new java.awt.Font("Broadway", 2, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Password");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 80, -1));

        pf_password1.setBackground(new java.awt.Color(255, 255, 255));
        pf_password1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(pf_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 330, -1));

        b_iniciarSesionA.setFont(new java.awt.Font("Broadway", 0, 14)); // NOI18N
        b_iniciarSesionA.setForeground(new java.awt.Color(0, 0, 0));
        b_iniciarSesionA.setText("Iniciar Sesion");
        b_iniciarSesionA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_iniciarSesionA.setContentAreaFilled(false);
        b_iniciarSesionA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_iniciarSesionA.setFocusPainted(false);
        b_iniciarSesionA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_iniciarSesionAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_iniciarSesionAMouseExited(evt);
            }
        });
        b_iniciarSesionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_iniciarSesionAActionPerformed(evt);
            }
        });
        jPanel2.add(b_iniciarSesionA, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 120, -1));

        jSeparator19.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 10, 40));

        b_entrarUser.setFont(new java.awt.Font("Broadway", 0, 14)); // NOI18N
        b_entrarUser.setForeground(new java.awt.Color(0, 0, 0));
        b_entrarUser.setText("Entrar Como USER");
        b_entrarUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_entrarUser.setContentAreaFilled(false);
        b_entrarUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_entrarUser.setFocusPainted(false);
        b_entrarUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_entrarUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_entrarUserMouseExited(evt);
            }
        });
        b_entrarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_entrarUserActionPerformed(evt);
            }
        });
        jPanel2.add(b_entrarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 170, -1));

        jLabel23.setFont(new java.awt.Font("Broadway", 0, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Si aun no tiene una cuenta entonces haga");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 230, -1));

        b_crearCuentaA.setFont(new java.awt.Font("Broadway", 0, 10)); // NOI18N
        b_crearCuentaA.setForeground(new java.awt.Color(102, 102, 102));
        b_crearCuentaA.setText("CLICK AQUI");
        b_crearCuentaA.setBorder(null);
        b_crearCuentaA.setBorderPainted(false);
        b_crearCuentaA.setContentAreaFilled(false);
        b_crearCuentaA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_crearCuentaA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_crearCuentaAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_crearCuentaAMouseExited(evt);
            }
        });
        b_crearCuentaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_crearCuentaAActionPerformed(evt);
            }
        });
        jPanel2.add(b_crearCuentaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, -1));

        p_IniciarSesionA.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        getContentPane().add(p_IniciarSesionA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_iniciarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_iniciarSesionMouseEntered
        b_crear.setForeground(Color.gray);
        b_crear.setBorderPainted(false);
    }//GEN-LAST:event_b_iniciarSesionMouseEntered

    private void b_iniciarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_iniciarSesionMouseExited
        b_crear.setForeground(Color.black);
        b_crear.setBorderPainted(true);
    }//GEN-LAST:event_b_iniciarSesionMouseExited

    private void b_iniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_iniciarSesionActionPerformed
        String nombreU = tf_nombreUsuario.getText();
        String passwords = pf_password.getText();
        if (UsuarioEntrar(nombreU, passwords)) {
            d_paginaU.pack();
            d_paginaU.setLocationRelativeTo(this);
            d_paginaU.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nombre de usuario o password incorrecta");
        }
        
        pb = new hiloCarga(pb_carga);
        pb.start();
    }//GEN-LAST:event_b_iniciarSesionActionPerformed

    private void b_crearCuentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_crearCuentaMouseEntered
        b_crearCuenta.setBounds(430, 350, 66, 17);
        b_crearCuenta.setForeground(Color.black);
    }//GEN-LAST:event_b_crearCuentaMouseEntered

    private void b_crearCuentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_crearCuentaMouseExited
        b_crearCuenta.setBounds(430, 350, 62, 13);
        b_crearCuenta.setForeground(Color.gray);
    }//GEN-LAST:event_b_crearCuentaMouseExited

    private void b_crearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_crearCuentaActionPerformed
        d_crearUsuario.pack();
        d_crearUsuario.setLocationRelativeTo(this);
        d_crearUsuario.setVisible(true);

    }//GEN-LAST:event_b_crearCuentaActionPerformed

    private void b_entrarAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_entrarAdminMouseEntered
        b_crear.setForeground(Color.gray);
        b_crear.setBorderPainted(false);
    }//GEN-LAST:event_b_entrarAdminMouseEntered

    private void b_entrarAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_entrarAdminMouseExited
        b_crear.setForeground(Color.black);
        b_crear.setBorderPainted(true);
    }//GEN-LAST:event_b_entrarAdminMouseExited

    private void b_entrarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_entrarAdminActionPerformed
        p_IniciarSesionA.setVisible(true);
        p_IniciarSesionU.setVisible(false);
    }//GEN-LAST:event_b_entrarAdminActionPerformed

    private void tf_nombreOGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombreOGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nombreOGActionPerformed

    private void tf_crearPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_crearPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_crearPasswordActionPerformed

    private void cb_paisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_paisActionPerformed

    }//GEN-LAST:event_cb_paisActionPerformed

    private void b_crearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_crearMouseEntered
        b_crear.setForeground(Color.gray);
        b_crear.setBorderPainted(false);
    }//GEN-LAST:event_b_crearMouseEntered

    private void b_crearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_crearMouseExited
        b_crear.setForeground(Color.black);
        b_crear.setBorderPainted(true);
    }//GEN-LAST:event_b_crearMouseExited

    private void b_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_crearActionPerformed
        String nombreOG = tf_nombreOG.getText();
        String crearUsuario = tf_crearUsuario.getText();
        String correo = tf_correo.getText();
        String password = tf_crearPassword.getText();
        String fecha = ff_fechaNacimiento.getText();

        if (nombreOG.isEmpty() || crearUsuario.isEmpty() || correo.isEmpty()
                || password.isEmpty() || fecha.isEmpty() || cb_pais.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Hay mas de dos casillas vacias, por favor llenelas todas las casillas");

        } else {
            if (nombreOG.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No ha ingresado su nombre aun");
            } else if (crearUsuario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No ha ingresado su nombre de USUARIO aun");
            } else if (correo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No ha ingresado su correo electronico aun");
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No ha ingresado su PASSWORD aun");
            } else if (fecha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No ha ingresado su fecha de nacimiento aun");
            } else if (cb_pais.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "No ha ingresado su pais de residencia, seleccione una");
            } else {
                if (UsuarioExistente(crearUsuario)) {
                    JOptionPane.showMessageDialog(this, "El nombre ya existe, escriba otro porfavor");
                } else if (!ConfirmarFecha(fecha)) {
                    JOptionPane.showMessageDialog(this, "Debes ser mayor de 12 años para tener una cuenta");
                } else if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\W).*$")) { // Osman nos enseno esto.
                    JOptionPane.showMessageDialog(this, "La password debe contener una mayuscula, minuscula y un caracter especial");
                } else {
                    String pais = (String) cb_pais.getSelectedItem();
                    User u = new User(crearUsuario, nombreOG, correo, pais, fecha, password);
                    user.add(u);
                    d_crearUsuario.setLocationRelativeTo(null);
                    d_crearUsuario.setVisible(false);

                }
            }
        }
    }//GEN-LAST:event_b_crearActionPerformed

    private void b_regresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_regresarMouseEntered
        b_regresar.setForeground(Color.gray);
        b_regresar.setBorderPainted(false);
    }//GEN-LAST:event_b_regresarMouseEntered

    private void b_regresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_regresarMouseExited
        b_regresar.setForeground(Color.black);
        b_regresar.setBorderPainted(true);
    }//GEN-LAST:event_b_regresarMouseExited

    private void b_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_regresarActionPerformed

        d_crearUsuario.setLocationRelativeTo(null);
        d_crearUsuario.setVisible(false);
    }//GEN-LAST:event_b_regresarActionPerformed

    private void tf_crearPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_crearPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_crearPassword1ActionPerformed

    private void b_crear1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_crear1MouseEntered
        b_crear.setForeground(Color.gray);
        b_crear.setBorderPainted(false);
    }//GEN-LAST:event_b_crear1MouseEntered

    private void b_crear1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_crear1MouseExited
        b_crear.setForeground(Color.black);
        b_crear.setBorderPainted(true);
    }//GEN-LAST:event_b_crear1MouseExited

    private void b_crear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_crear1ActionPerformed
        String crearUsuario = tf_crearUsuario1.getText();
        String correo = tf_correo1.getText();
        String password = tf_crearPassword1.getText();
        String fecha = ff_fechaNacimiento1.getText();

        if (crearUsuario.isEmpty() || correo.isEmpty()
                || password.isEmpty() || fecha.isEmpty() || cb_pais.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Hay mas de dos casillas vacias, por favor llenelas todas las casillas");

        } else {
            if (crearUsuario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No ha ingresado su nombre de USUARIO aun");
            } else if (correo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No ha ingresado su correo electronico aun");
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No ha ingresado su PASSWORD aun");
            } else if (fecha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No ha ingresado su fecha de nacimiento aun");
            } else if (cb_pais1.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "No ha ingresado su pais de residencia, seleccione una");
            } else {
                if (UsuarioExistente(crearUsuario)) {
                    JOptionPane.showMessageDialog(this, "El nombre ya existe, escriba otro porfavor");
                } else if (!ConfirmarFecha(fecha)) {
                    JOptionPane.showMessageDialog(this, "Debes ser mayor de 12 años para tener una cuenta");
                } else if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\W).*$")) {
                    JOptionPane.showMessageDialog(this, "La password debe contener una mayuscula, minuscula y un caracter especial");
                } else {
                    String pais = (String) cb_pais1.getSelectedItem();
                    Admin a = new Admin(crearUsuario, correo, password, fecha, pais);
                    admin.add(a);
                    d_crearAdmin.setLocationRelativeTo(null);
                    d_crearAdmin.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_b_crear1ActionPerformed

    private void b_regresar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_regresar1MouseEntered
        b_crear.setForeground(Color.gray);
        b_crear.setBorderPainted(false);
    }//GEN-LAST:event_b_regresar1MouseEntered

    private void b_regresar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_regresar1MouseExited
        b_crear.setForeground(Color.black);
        b_crear.setBorderPainted(true);
    }//GEN-LAST:event_b_regresar1MouseExited

    private void b_regresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_regresar1ActionPerformed
        d_crearAdmin.setLocationRelativeTo(null);
        d_crearAdmin.setVisible(false);
    }//GEN-LAST:event_b_regresar1ActionPerformed

    private void b_iniciarSesionAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_iniciarSesionAMouseEntered
        b_crear.setForeground(Color.gray);
        b_crear.setBorderPainted(false);
    }//GEN-LAST:event_b_iniciarSesionAMouseEntered

    private void b_iniciarSesionAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_iniciarSesionAMouseExited
        b_crear.setForeground(Color.black);
        b_crear.setBorderPainted(true);
    }//GEN-LAST:event_b_iniciarSesionAMouseExited

    private void b_iniciarSesionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_iniciarSesionAActionPerformed
        String nombreU = tf_nombreUsuario1.getText();
        String passwords = pf_password1.getText();
        if (AdminEntrar(nombreU, passwords)) {
            d_paginaA.pack();
            d_paginaA.setLocationRelativeTo(this);
            d_paginaA.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nombre de usuario o password incorrecta");
        }
    }//GEN-LAST:event_b_iniciarSesionAActionPerformed

    private void b_entrarUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_entrarUserMouseEntered
        b_crear.setForeground(Color.gray);
        b_crear.setBorderPainted(false);
    }//GEN-LAST:event_b_entrarUserMouseEntered

    private void b_entrarUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_entrarUserMouseExited
        b_crear.setForeground(Color.black);
        b_crear.setBorderPainted(true);
    }//GEN-LAST:event_b_entrarUserMouseExited

    private void b_entrarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_entrarUserActionPerformed
        p_IniciarSesionA.setVisible(false);
        p_IniciarSesionU.setVisible(true);
    }//GEN-LAST:event_b_entrarUserActionPerformed

    private void b_crearCuentaAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_crearCuentaAMouseEntered
        b_crearCuenta.setBounds(430, 350, 66, 17);
        b_crearCuenta.setForeground(Color.black);
    }//GEN-LAST:event_b_crearCuentaAMouseEntered

    private void b_crearCuentaAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_crearCuentaAMouseExited
        b_crearCuenta.setBounds(430, 350, 62, 13);
        b_crearCuenta.setForeground(Color.gray);
    }//GEN-LAST:event_b_crearCuentaAMouseExited

    private void b_crearCuentaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_crearCuentaAActionPerformed
        d_crearAdmin.pack();
        d_crearAdmin.setLocationRelativeTo(this);
        d_crearAdmin.setVisible(true);
    }//GEN-LAST:event_b_crearCuentaAActionPerformed

    private void b_crearPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_crearPActionPerformed
        DefaultTableModel tbl = (DefaultTableModel) t_listarJ.getModel();
        String nombre = tf_nombre.getText();
        String puntos = tf_puntos.getText();
        String dinero = tf_dinero.getText();
        if (nombre.isEmpty() || puntos.isEmpty() || dinero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, llene todas las casillas.");
        } else {
            // Agregar datos a la tabla
            Object[] rowData = {nombre, puntos, dinero};
            tbl.addRow(rowData);
        }


    }//GEN-LAST:event_b_crearPActionPerformed

    private void b_crearCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_crearCActionPerformed
        DefaultTableModel tbl = (DefaultTableModel) t_listarC.getModel();
        String modelo = jTextField5.getText();
        String marca = jTextField4.getText();
        String pais = (String) jComboBox1.getSelectedItem();
        String precio = jFormattedTextField1.getText();
        if (modelo.isEmpty() || marca.isEmpty() || pais.isEmpty() || precio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No ha pasado nada");
        } else {
            for (int i = 0; i < tbl.getRowCount(); i++) {
                modelo = tbl.getValueAt(i, 0).toString();
                marca = tbl.getValueAt(i, 1).toString();
                pais = tbl.getValueAt(i, 2).toString();
                precio = tbl.getValueAt(i, 3).toString();
            }
        }
    }//GEN-LAST:event_b_crearCActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        jT_garaje1.getSelectionModel().addListSelectionListener(e -> {        
        if (rootPaneCheckingEnabled) {
            int filaSeleccionada = jT_garaje1.getSelectedRow();            
        }
        JDialog carreraCarro1 = new JDialog(this, "Carrera Carro 1", true);
        JDialog carreraCarro2 = new JDialog(this, "Carrera Carro 2", true);
        hiloCarrera hiloCarro1 = new hiloCarrera(pb_carro1, carreraCarro1);
        hiloCarrera hiloCarro2 = new hiloCarrera(pb_carro2, carreraCarro2);
        hiloCarro1.start();
        hiloCarro2.start();        
        
        });
    }//GEN-LAST:event_jButton2MouseClicked

    private void tp_mainStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tp_mainStateChanged
        int seleccion = tp_main.getSelectedIndex();
        if (seleccion == 3) {
            
        }
    }//GEN-LAST:event_tp_mainStateChanged

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        pb2 = new hiloCarga(pb_compra);
        pb2.start();
        comprarCarroSeleccionado();
    }//GEN-LAST:event_jButton3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_crear;
    private javax.swing.JButton b_crear1;
    private javax.swing.JButton b_crearC;
    private javax.swing.JButton b_crearCuenta;
    private javax.swing.JButton b_crearCuentaA;
    private javax.swing.JButton b_crearP;
    private javax.swing.JButton b_entrarAdmin;
    private javax.swing.JButton b_entrarUser;
    private javax.swing.JButton b_iniciarSesion;
    private javax.swing.JButton b_iniciarSesionA;
    private javax.swing.JButton b_regresar;
    private javax.swing.JButton b_regresar1;
    private javax.swing.JComboBox<String> cb_pais;
    private javax.swing.JComboBox<String> cb_pais1;
    private javax.swing.JDialog d_crearAdmin;
    private javax.swing.JDialog d_crearUsuario;
    private javax.swing.JDialog d_paginaA;
    private javax.swing.JDialog d_paginaU;
    private javax.swing.JFormattedTextField ff_fechaNacimiento;
    private javax.swing.JFormattedTextField ff_fechaNacimiento1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JList<String> jL_mejoras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jT_compra;
    private javax.swing.JTable jT_garaje;
    private javax.swing.JTable jT_garaje1;
    private javax.swing.JTable jT_venta;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel p_IniciarSesionA;
    private javax.swing.JPanel p_IniciarSesionU;
    private javax.swing.JPanel p_bj;
    private javax.swing.JPanel p_cj;
    private javax.swing.JPanel p_compra;
    private javax.swing.JPanel p_crearAdmin;
    private javax.swing.JPanel p_crearUsuario;
    private javax.swing.JPanel p_ej;
    private javax.swing.JPanel p_instMV;
    private javax.swing.JPanel p_jugadores;
    private javax.swing.JPanel p_mj;
    private javax.swing.JPanel p_paginaAdmin;
    private javax.swing.JPanel p_ventas;
    private javax.swing.JProgressBar pb_carga;
    private javax.swing.JProgressBar pb_carro1;
    private javax.swing.JProgressBar pb_carro2;
    private javax.swing.JProgressBar pb_compra;
    private javax.swing.JPasswordField pf_password;
    private javax.swing.JPasswordField pf_password1;
    private javax.swing.JTable t_listarC;
    private javax.swing.JTable t_listarJ;
    private javax.swing.JTextField tf_correo;
    private javax.swing.JTextField tf_correo1;
    private javax.swing.JTextField tf_crearPassword;
    private javax.swing.JTextField tf_crearPassword1;
    private javax.swing.JTextField tf_crearUsuario;
    private javax.swing.JTextField tf_crearUsuario1;
    private javax.swing.JTextField tf_dinero;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_nombreOG;
    private javax.swing.JTextField tf_nombreUsuario;
    private javax.swing.JTextField tf_nombreUsuario1;
    private javax.swing.JTextField tf_puntos;
    private javax.swing.JTabbedPane tp_jugador;
    private javax.swing.JTabbedPane tp_main;
    // End of variables declaration//GEN-END:variables
}
