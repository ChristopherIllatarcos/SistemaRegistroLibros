package vista;

import conexion.Conexion;
import controlador.Ctrl_Registro_libro;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Libro;

/**
 *
 * @author caill
 */
public class RegistroLibros extends javax.swing.JFrame {

    private int idLibro;

    public RegistroLibros() {
        initComponents();
        this.setSize(new Dimension(830, 520));
        this.setTitle("Registro de Libros");

        CargarTablaLibro();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton_eliminar = new javax.swing.JButton();
        jButton_registrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_numero_pagina = new javax.swing.JTextField();
        txt_busqueda_por_titulo = new javax.swing.JTextField();
        txt_autor = new javax.swing.JTextField();
        txt_genero = new javax.swing.JTextField();
        txt_editorial = new javax.swing.JTextField();
        jButton_buscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_registro_libro = new javax.swing.JTable();
        jButton_editar = new javax.swing.JButton();
        txt_titulo = new javax.swing.JTextField();
        jDateChooser_fecha = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nro Página:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(0, 102, 102));
        jButton_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 140, 30));

        jButton_registrar.setBackground(new java.awt.Color(0, 102, 102));
        jButton_registrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_registrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registrar.setText("Registrar");
        jButton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 270, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 149, 770, 10));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 10, 340));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro de Libros");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registrar Libros");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Título:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Autor:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Genero:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 270, 50, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Editorial:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));
        getContentPane().add(txt_numero_pagina, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 180, -1));
        getContentPane().add(txt_busqueda_por_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 330, 30));
        getContentPane().add(txt_autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 180, -1));
        getContentPane().add(txt_genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 180, -1));
        getContentPane().add(txt_editorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 180, -1));

        jButton_buscar.setBackground(new java.awt.Color(0, 102, 102));
        jButton_buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_buscar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_buscar.setText("Buscar");
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 90, 30));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable_registro_libro.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_registro_libro);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 430, 250));

        jButton_editar.setBackground(new java.awt.Color(0, 102, 102));
        jButton_editar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_editar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_editar.setText("Editar");
        jButton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 140, 30));
        getContentPane().add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 180, -1));
        getContentPane().add(jDateChooser_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 180, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/libros.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 60, 100));

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaper.jpg"))); // NOI18N
        getContentPane().add(wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarActionPerformed
        Libro libro = new Libro();
        Ctrl_Registro_libro libroController = new Ctrl_Registro_libro();

        // Obtener datos del libro
        String titulo = txt_titulo.getText().trim();
        String nombreAutor = txt_autor.getText().trim();
        String nombreGenero = txt_genero.getText().trim();
        String nombreEditorial = txt_editorial.getText().trim();
        Date fecha = jDateChooser_fecha.getDate();
        int nroPaginas;

        // Validar campos vacíos
        if (titulo.isEmpty() || nombreAutor.isEmpty() || nombreGenero.isEmpty() || nombreEditorial.isEmpty() || txt_numero_pagina.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            return; // Detener ejecución
        }

        // Validar número de páginas
        try {
            nroPaginas = Integer.parseInt(txt_numero_pagina.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido para el número de páginas.");
            return; // Detener ejecución
        }

        // Validar fecha
        if (fecha == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una fecha válida");
            return; // Detener ejecución
        }

        // Verificar si el título ya existe
        if (libroController.existeLibro(titulo)) {
            JOptionPane.showMessageDialog(null, "El libro ya está registrado");
            return; // Detener ejecución
        }

        // Asignar datos al objeto libro
        libro.setTitulo(titulo);
        libro.setAutor(nombreAutor);
        libro.setGenero(nombreGenero);
        libro.setEditorial(nombreEditorial);
        libro.setFecha(fecha);
        libro.setNumeroPaginas(nroPaginas);

        // Guardar el libro
        try {
            if (libroController.guardar(libro)) {
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar registro");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
            System.out.println("Error al guardar libro: " + e);
        }

        // Limpiar campos
        txt_titulo.setText("");
        txt_autor.setText("");
        txt_genero.setText("");
        txt_editorial.setText("");
        jDateChooser_fecha.setDate(null);
        txt_numero_pagina.setText("");

    }//GEN-LAST:event_jButton_registrarActionPerformed

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
        // Obtener el criterio de búsqueda desde el campo de texto
        String criterioBusqueda = txt_busqueda_por_titulo.getText().trim();

        if (criterioBusqueda.isEmpty()) {
            // Si el campo de búsqueda está vacío, recargar la tabla completa
            this.CargarTablaLibro();
        } else {
            // Crear instancia del controlador
            Ctrl_Registro_libro libroController = new Ctrl_Registro_libro();
            // Obtener los resultados de la búsqueda
            ArrayList<Libro> listaLibros = libroController.BuscarPorTitulo(criterioBusqueda);

            // Configurar el modelo de la tabla para mostrar los resultados
            DefaultTableModel model = new DefaultTableModel();

            // Definir las columnas de la tabla
            model.addColumn("ID");
            model.addColumn("Título");
            model.addColumn("Autor");
            model.addColumn("Género");
            model.addColumn("Editorial");
            model.addColumn("Fecha");
            model.addColumn("Páginas");

            // Llenar el modelo con los datos obtenidos
            for (Libro libro : listaLibros) {
                model.addRow(new Object[]{
                    libro.getIdLibro(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getGenero(),
                    libro.getEditorial(),
                    libro.getFecha(),
                    libro.getNumeroPaginas()
                });
            }

            // Asignar el modelo a la tabla
            jTable_registro_libro.setModel(model);

            // Mostrar un mensaje si no se encontraron resultados
            if (listaLibros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados para el criterio de búsqueda.");
            }
        }
    }//GEN-LAST:event_jButton_buscarActionPerformed

    private void jButton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editarActionPerformed
        Libro libro = new Libro();
        Ctrl_Registro_libro libroController = new Ctrl_Registro_libro();

        if (txt_titulo.getText().trim().isEmpty() || txt_autor.getText().trim().isEmpty()
                || txt_editorial.getText().trim().isEmpty() || txt_genero.getText().trim().isEmpty()
                || txt_numero_pagina.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completes los campos");
            return; // Detener la ejecución si hay campos vacíos
        }

        // Establecer los datos del libro
        try {
            libro.setTitulo(txt_titulo.getText().trim());
            libro.setAutor(txt_autor.getText().trim());
            libro.setGenero(txt_genero.getText().trim());
            libro.setEditorial(txt_editorial.getText().trim());
            libro.setFecha(jDateChooser_fecha.getDate());

            // Validar el número de páginas
            String numeroPaginasText = txt_numero_pagina.getText().trim();
            if (!numeroPaginasText.isEmpty()) {
                try {
                    int numeroPaginas = Integer.parseInt(numeroPaginasText); // Convertir a número
                    libro.setNumeroPaginas(numeroPaginas);
                } catch (NumberFormatException ex) {
                    System.out.println("Error al convertir el número de páginas: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "El número de páginas debe ser un número válido");
                    return; // Detener la ejecución si hay un error en la conversión
                }
            } else {
                JOptionPane.showMessageDialog(null, "El número de páginas no puede estar vacío");
                return;
            }

            // Verificar que idLibro no sea nulo o incorrecto
            if (idLibro == 0) {
                JOptionPane.showMessageDialog(null, "ID del libro no válido");
                return;
            }

            // Actualizar los datos del libro
            if (libroController.actualizar(libro, idLibro)) {
                JOptionPane.showMessageDialog(null, "Registro actualizado con éxito");
                CargarTablaLibro();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");
            }

        } catch (HeadlessException e) {
            System.out.println("Error al establecer los valores: " + e);
        }


    }//GEN-LAST:event_jButton_editarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        Ctrl_Registro_libro libroController = new Ctrl_Registro_libro();
        if (idLibro == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        }
        // Mostrar advertencia de confirmación
        int confirmacion = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro de que desea eliminar el libro registrado?",
                "Confirmación de Eliminación",
                JOptionPane.YES_NO_OPTION
        );

        // verificar la respuesta del usuario
        if (confirmacion == JOptionPane.YES_OPTION) {
            if (libroController.eliminar(idLibro)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado con exito");
                this.CargarTablaLibro();
                this.limpiar();

            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar registro libro");
            }
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegistroLibros().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_editar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_registrar;
    private com.toedter.calendar.JDateChooser jDateChooser_fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JTable jTable_registro_libro;
    private javax.swing.JTextField txt_autor;
    private javax.swing.JTextField txt_busqueda_por_titulo;
    private javax.swing.JTextField txt_editorial;
    private javax.swing.JTextField txt_genero;
    private javax.swing.JTextField txt_numero_pagina;
    private javax.swing.JTextField txt_titulo;
    private javax.swing.JLabel wallpaper;
    // End of variables declaration//GEN-END:variables

    private void CargarTablaLibro() {
        Connection con = (Connection) Conexion.conectar();
        DefaultTableModel modelo = new DefaultTableModel();

        // Configurar las columnas de la tabla
        modelo.addColumn("ID");
        modelo.addColumn("Título");
        modelo.addColumn("Autor");
        modelo.addColumn("Género");
        modelo.addColumn("Editorial");
        modelo.addColumn("Fecha Publicación");
        modelo.addColumn("Páginas");

        // Consulta SQL con JOIN para obtener los datos relacionados
        String sql = "SELECT id_libro, titulo, autor, genero, editorial, "
                + "fecha, numero_paginas "
                + "FROM tb_libros ";

        try (Statement st = con.createStatement(); java.sql.ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("id_libro");
                fila[1] = rs.getString("titulo");
                fila[2] = rs.getString("autor");
                fila[3] = rs.getString("genero");
                fila[4] = rs.getString("editorial");
                fila[5] = rs.getDate("fecha");
                fila[6] = rs.getInt("numero_paginas");

                modelo.addRow(fila);
            }
            jTable_registro_libro.setModel(modelo); // Actualizar la tabla con el modelo
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }

        RegistroLibros.jTable_registro_libro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaPoint = RegistroLibros.jTable_registro_libro.rowAtPoint(e.getPoint());
                int columnaPoint = 0; // Columna de ID

                if (filaPoint > -1) {
                    idLibro = (int) RegistroLibros.jTable_registro_libro.getValueAt(filaPoint, columnaPoint);
                    try {
                        EnviarDatosLibroSeleccionado(idLibro);
                    } catch (SQLException ex) {
                        Logger.getLogger(RegistroLibros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    private void EnviarDatosLibroSeleccionado(int idLibro) throws SQLException {
        if (idLibro <= 0) {
            System.out.println("El ID del libro no es válido");
            return;
        }

        // SQL ajustado para la estructura de la tabla tb_libros
        String sql = "SELECT titulo, autor, genero, editorial, "
                + "fecha, numero_paginas "
                + "FROM tb_libros "
                + "WHERE id_libro = ?";

        try (Connection con = Conexion.conectar(); PreparedStatement pst = con.prepareStatement(sql)) {
            // Asignar el parámetro de la consulta
            pst.setInt(1, idLibro);

            System.out.println("Ejecutando consulta con idLibro: " + idLibro);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Asignar valores a los campos del libro
                    txt_titulo.setText(rs.getString("titulo"));  // Asignar título
                    txt_autor.setText(rs.getString("autor"));    // Asignar autor
                    txt_genero.setText(rs.getString("genero"));  // Asignar género
                    txt_editorial.setText(rs.getString("editorial"));  // Asignar editorial

                    // Obtener y formatear la fecha de publicación
                    Date fechaPublicacion = rs.getDate("fecha");
                    if (fechaPublicacion != null) {
                        jDateChooser_fecha.setDate(fechaPublicacion);  // JDateChooser para la fecha de publicación
                    } else {
                        jDateChooser_fecha.setDate(null);
                    }

                    // Asignar el número de páginas
                    int numeroPaginas = rs.getInt("numero_paginas");
                    txt_numero_pagina.setText(String.valueOf(numeroPaginas));  // Asignar número de páginas

                } else {
                    System.out.println("No se encontraron datos para el libro con ID: " + idLibro);
                }
            } catch (SQLException e) {
                System.out.println("Error al seleccionar un libro: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión o consulta: " + e.getMessage());
        }
    }

    private void limpiar() {
        txt_titulo.setText("");
        txt_autor.setText("");
        txt_genero.setText("");
        txt_editorial.setText("");
        jDateChooser_fecha.setDate(null);
        txt_numero_pagina.setText("");
    }
}
