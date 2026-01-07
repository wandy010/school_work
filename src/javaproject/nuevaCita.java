package javaproject;

public class nuevaCita extends javax.swing.JPanel {

    public nuevaCita() {
        initComponents();
    }
    public void conseguirCita() {
        String DNI = txtDNI.getText();

        int dia = (cboDia_cita.getSelectedIndex() +1);
        int mes = (cboMes_citas.getSelectedIndex() +1);
        int horaInicio = 0;
        switch(cboHoraInicio.getSelectedIndex()) {
            case 0: horaInicio = 8; break;
            case 1: horaInicio = 9; break;
            case 2: horaInicio = 10; break;
            case 3: horaInicio = 11; break;
            case 4: horaInicio = 12; break;
            case 5: horaInicio = 13; break;
            case 6: horaInicio = 14; break;
            case 7: horaInicio = 15; break;
            case 8: horaInicio = 16; break;
            case 9: horaInicio = 17; break;
        }
        int minInicio = 0;
        switch(cboMinInicio.getSelectedIndex()) {
            case 0: minInicio = 0; break;
            case 1: minInicio = 10; break;
            case 2: minInicio = 15; break;
            case 3: minInicio = 20; break;
            case 4: minInicio = 30; break;
            case 5: minInicio = 40; break;
            case 6: minInicio = 45; break;
        }
        int horaFin = 0;
        switch(cboHoraFin.getSelectedIndex()) {
            case 0: horaFin = 8; break;
            case 1: horaFin = 9; break;
            case 2: horaFin = 10; break;
            case 3: horaFin = 11; break;
            case 4: horaFin = 12; break;
            case 5: horaFin = 13; break;
            case 6: horaFin = 14; break;
            case 7: horaFin = 15; break;
            case 8: horaFin = 16; break;
            case 9: horaFin = 17; break;
        }
        int minFin = 0; 
        switch(cboMinFin.getSelectedIndex()) {
            case 0: minFin = 0; break;
            case 1: minFin = 10; break;
            case 2: minFin = 15; break;
            case 3: minFin = 20; break;
            case 4: minFin = 30; break;
            case 5: minFin = 40; break;
            case 6: minFin = 45; break;
        }
        String area = ""; 
        switch(cboArea.getSelectedIndex()) {
            case 0: area = "Medicina general"; break;
            case 1: area = "Obstetricia";  break;
            case 2: area = "Vacunacion"; break;
            case 3: area = "Triaje"; break;            
        }
        String fecha = dia + "/" + mes + "/2026";
        String motivo = txtMotivo.getText();
        String inicio = horaInicio + ":" +minInicio;
        String fin = horaFin + ":" +minFin;
        String citaCompleta = "[" + dia + "/" + mes + "/" + "2026" + "] " + inicio + "-" + fin; 
        
        int tiempoInicio = (horaInicio * 60) + minInicio;
        int tiempoFin = (horaFin * 60) + minFin;

        if (tiempoInicio >= tiempoFin) {
        lblMensaje.setText("Error: hora inválida");
        return;
        }

        if (hayCruce(fecha, tiempoInicio, tiempoFin)) {
        lblMensaje.setText("Horario no disponible");
        return;
        }

        pasarDatos(DNI, fecha, inicio, fin, area, motivo, tiempoInicio, tiempoFin);
        lblMensaje.setText("Cita reservada");
        
    }
    public void pasarDatos(String DNI, String fecha, String horaInicio, String horaFin, String area, String motivo, int tiempoInicio, int tiempoFin) {
    if (interfazOwner.indiceCita < interfazOwner.datos_citas[0].length) {

        interfazOwner.datos_citas[0][interfazOwner.indiceCita] = DNI;
        interfazOwner.datos_citas[1][interfazOwner.indiceCita] = fecha;
        interfazOwner.datos_citas[2][interfazOwner.indiceCita] = horaInicio;
        interfazOwner.datos_citas[3][interfazOwner.indiceCita] = horaFin;
        interfazOwner.datos_citas[4][interfazOwner.indiceCita] = motivo;
        interfazOwner.datos_citas[5][interfazOwner.indiceCita] = area;  
        interfazOwner.datos_citas[6][interfazOwner.indiceCita] = String.valueOf(tiempoInicio);
        interfazOwner.datos_citas[7][interfazOwner.indiceCita] = String.valueOf(tiempoFin);

        interfazOwner.indiceCita++; 
        }
    }   
    public boolean hayCruce(String fecha, int tiempoInicio, int tiempoFin) {

    for (int i = 0; i < interfazOwner.indiceCita; i++) {

        if (interfazOwner.datos_citas[1][i].equals(fecha)) {

            int inicioGuardado = Integer.parseInt(interfazOwner.datos_citas[6][i]);
            int finGuardado = Integer.parseInt(interfazOwner.datos_citas[7][i]);

            if (tiempoInicio < finGuardado && tiempoFin > inicioGuardado) {
                return true;
                }
            }
        }
        return false;
    }
    public void borrar() {
        txtDNI.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtNombres.setText("");
        cboSexo.setSelectedIndex(0);
        txtEdad.setText("");
        cboSeguro.setSelectedIndex(0);
        txtTelefono.setText("");
        cboDia_cita.setSelectedIndex(0);
        cboMes_citas.setSelectedIndex(0);
        cboHoraInicio.setSelectedIndex(0);
        cboMinInicio.setSelectedIndex(0);
        cboHoraFin.setSelectedIndex(0);
        cboMinFin.setSelectedIndex(0);
        cboArea.setSelectedIndex(0);
        txtMotivo.setText("");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatosPersonales = new javax.swing.JPanel();
        txtDNI = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        lblDNI = new javax.swing.JLabel();
        btnBorrarDatos = new javax.swing.JButton();
        lblSexo = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        cboSexo = new javax.swing.JComboBox<>();
        cboSeguro = new javax.swing.JComboBox<>();
        lblSeguro = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        panelFechaYHora = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnConfirmarCita = new javax.swing.JButton();
        btnBorrarFecha = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblDia = new javax.swing.JLabel();
        cboDia_cita = new javax.swing.JComboBox<>();
        lblMes = new javax.swing.JLabel();
        cboMes_citas = new javax.swing.JComboBox<>();
        lblAnyo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblHoraInicio = new javax.swing.JLabel();
        cboHoraInicio = new javax.swing.JComboBox<>();
        lblMinInicio = new javax.swing.JLabel();
        cboMinInicio = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        cboHoraFin = new javax.swing.JComboBox<>();
        lblHoraFin = new javax.swing.JLabel();
        lblMinFin = new javax.swing.JLabel();
        cboMinFin = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        lblArea = new javax.swing.JLabel();
        cboArea = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();
        lblMensaje = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 242, 246));
        setPreferredSize(new java.awt.Dimension(682, 528));

        panelDatosPersonales.setBackground(new java.awt.Color(236, 242, 246));
        panelDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(44, 62, 80))); // NOI18N
        panelDatosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDNI.setBackground(new java.awt.Color(236, 242, 246));
        txtDNI.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(150, 185, 210)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(44, 62, 80))); // NOI18N
        panelDatosPersonales.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 173, 35));

        txtApellidoPaterno.setBackground(new java.awt.Color(236, 242, 246));
        txtApellidoPaterno.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(150, 185, 210)), "APELLIDO PATERNO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(44, 62, 80))); // NOI18N
        txtApellidoPaterno.addActionListener(this::txtApellidoPaternoActionPerformed);
        panelDatosPersonales.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 240, -1));

        txtApellidoMaterno.setBackground(new java.awt.Color(236, 242, 246));
        txtApellidoMaterno.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(150, 185, 210)), "APELLIDO MATERNO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(44, 62, 80))); // NOI18N
        panelDatosPersonales.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 240, -1));

        txtNombres.setBackground(new java.awt.Color(236, 242, 246));
        txtNombres.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(150, 185, 210)), "NOMBRES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(44, 62, 80))); // NOI18N
        panelDatosPersonales.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 240, -1));

        lblDNI.setForeground(new java.awt.Color(44, 62, 80));
        lblDNI.setText("DNI:");
        lblDNI.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDatosPersonales.add(lblDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 39, -1));

        btnBorrarDatos.setBackground(new java.awt.Color(40, 110, 160));
        btnBorrarDatos.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarDatos.setText("BORRAR");
        btnBorrarDatos.addActionListener(this::btnBorrarDatosActionPerformed);
        panelDatosPersonales.add(btnBorrarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        lblSexo.setForeground(new java.awt.Color(44, 62, 80));
        lblSexo.setText("SEXO:");
        panelDatosPersonales.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 42, 20));

        lblEdad.setForeground(new java.awt.Color(44, 62, 80));
        lblEdad.setText("EDAD:");
        panelDatosPersonales.add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 42, 20));

        cboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOMBRE", "MUJER" }));
        cboSexo.setBorder(null);
        panelDatosPersonales.add(cboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        cboSeguro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIS", "Otro" }));
        cboSeguro.setBorder(null);
        panelDatosPersonales.add(cboSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 85, -1));

        lblSeguro.setForeground(new java.awt.Color(44, 62, 80));
        lblSeguro.setText("SEGURO DE VIDA:");
        panelDatosPersonales.add(lblSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 106, 20));

        txtEdad.setBackground(new java.awt.Color(236, 242, 246));
        txtEdad.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEdad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(150, 185, 210)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(44, 62, 80))); // NOI18N
        panelDatosPersonales.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 81, 22));

        lblTelefono.setForeground(new java.awt.Color(44, 62, 80));
        lblTelefono.setText("TELÉFONO:");
        panelDatosPersonales.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        txtTelefono.setBackground(new java.awt.Color(236, 242, 246));
        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(150, 185, 210)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(44, 62, 80))); // NOI18N
        panelDatosPersonales.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 90, -1));

        panelFechaYHora.setBackground(new java.awt.Color(236, 242, 246));
        panelFechaYHora.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(44, 62, 80))); // NOI18N
        panelFechaYHora.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(44, 62, 80));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("HORA DE INICIO");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelFechaYHora.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 107, -1));

        jLabel8.setForeground(new java.awt.Color(44, 62, 80));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("FECHA");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelFechaYHora.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 37, 63, -1));

        jLabel12.setForeground(new java.awt.Color(44, 62, 80));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("HORA DE TÉRMINO");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelFechaYHora.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 204, 123, -1));

        btnConfirmarCita.setBackground(new java.awt.Color(40, 110, 160));
        btnConfirmarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmarCita.setText("CONFIRMAR");
        btnConfirmarCita.addActionListener(this::btnConfirmarCitaActionPerformed);
        panelFechaYHora.add(btnConfirmarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, -1, -1));

        btnBorrarFecha.setBackground(new java.awt.Color(40, 110, 160));
        btnBorrarFecha.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarFecha.setText("BORRAR");
        btnBorrarFecha.addActionListener(this::btnBorrarFechaActionPerformed);
        panelFechaYHora.add(btnBorrarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jPanel3.setBackground(new java.awt.Color(236, 242, 246));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(150, 185, 210)));

        lblDia.setForeground(new java.awt.Color(44, 62, 80));
        lblDia.setText("DÍA:");

        cboDia_cita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        lblMes.setForeground(new java.awt.Color(44, 62, 80));
        lblMes.setText("MES:");

        cboMes_citas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        lblAnyo.setForeground(new java.awt.Color(44, 62, 80));
        lblAnyo.setText("AÑO 2026");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboDia_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboMes_citas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(lblAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDia)
                    .addComponent(cboDia_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMes)
                    .addComponent(cboMes_citas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnyo))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        panelFechaYHora.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 470, 50));

        jPanel4.setBackground(new java.awt.Color(236, 242, 246));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(150, 185, 210)));

        lblHoraInicio.setForeground(new java.awt.Color(44, 62, 80));
        lblHoraInicio.setText("HORA:");

        cboHoraInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "9", "10", "11", "12", "13", "14", "15", "16", "17" }));

        lblMinInicio.setForeground(new java.awt.Color(44, 62, 80));
        lblMinInicio.setText("MINUTO:");

        cboMinInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "10", "15", "20", "30", "40", "45" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblMinInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboMinInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraInicio)
                    .addComponent(cboHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMinInicio)
                    .addComponent(cboMinInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        panelFechaYHora.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 470, 60));

        jPanel5.setBackground(new java.awt.Color(236, 242, 246));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(150, 185, 210)));

        cboHoraFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "9", "10", "11", "12", "13", "14", "15", "16", "17" }));

        lblHoraFin.setForeground(new java.awt.Color(44, 62, 80));
        lblHoraFin.setText("HORA:");

        lblMinFin.setForeground(new java.awt.Color(44, 62, 80));
        lblMinFin.setText("MINUTO:");

        cboMinFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "10", "15", "20", "30", "40", "45" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblMinFin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboMinFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoraFin)
                    .addComponent(lblMinFin)
                    .addComponent(cboMinFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelFechaYHora.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 470, 60));

        jPanel6.setBackground(new java.awt.Color(236, 242, 246));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(150, 185, 210)));

        lblArea.setForeground(new java.awt.Color(44, 62, 80));
        lblArea.setText(" ÁREA:");

        cboArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicina general", "Obstetricia", "Vacunación", "Triaje" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArea)
                    .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelFechaYHora.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 470, 60));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("MOTIVA DE CONSULTA"));

        txtMotivo.setBackground(new java.awt.Color(236, 242, 246));
        txtMotivo.setColumns(20);
        txtMotivo.setRows(5);
        txtMotivo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(150, 185, 210)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(44, 62, 80))); // NOI18N
        jScrollPane1.setViewportView(txtMotivo);

        panelFechaYHora.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 470, 100));
        panelFechaYHora.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 130, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(panelDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelFechaYHora, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelFechaYHora, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void btnBorrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDatosActionPerformed
        txtDNI.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtNombres.setText("");
        cboSexo.setSelectedIndex(0);
        txtEdad.setText("");
        cboSeguro.setSelectedIndex(0);
        txtTelefono.setText("");
    }//GEN-LAST:event_btnBorrarDatosActionPerformed

    private void btnBorrarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarFechaActionPerformed
        cboDia_cita.setSelectedIndex(0);
        cboMes_citas.setSelectedIndex(0);
        cboHoraInicio.setSelectedIndex(0);
        cboMinInicio.setSelectedIndex(0);
        cboHoraFin.setSelectedIndex(0);
        cboMinFin.setSelectedIndex(0);
        cboArea.setSelectedIndex(0);
        txtMotivo.setText("");
    }//GEN-LAST:event_btnBorrarFechaActionPerformed

    private void btnConfirmarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCitaActionPerformed
        conseguirCita();
        int i = interfazOwner.indiceCita - 1;
        System.out.println("["+(i+1)+"] "+interfazOwner.datos_citas[0][i]+" ["+interfazOwner.datos_citas[1][i]+
                "] "+interfazOwner.datos_citas[2][i]+"-"+interfazOwner.datos_citas[3][i]+"\n");
        borrar();
    }//GEN-LAST:event_btnConfirmarCitaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarDatos;
    private javax.swing.JButton btnBorrarFecha;
    private javax.swing.JButton btnConfirmarCita;
    private javax.swing.JComboBox<String> cboArea;
    private javax.swing.JComboBox<String> cboDia_cita;
    private javax.swing.JComboBox<String> cboHoraFin;
    private javax.swing.JComboBox<String> cboHoraInicio;
    private javax.swing.JComboBox<String> cboMes_citas;
    private javax.swing.JComboBox<String> cboMinFin;
    private javax.swing.JComboBox<String> cboMinInicio;
    private javax.swing.JComboBox<String> cboSeguro;
    private javax.swing.JComboBox<String> cboSexo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnyo;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblHoraFin;
    private javax.swing.JLabel lblHoraInicio;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblMinFin;
    private javax.swing.JLabel lblMinInicio;
    private javax.swing.JLabel lblSeguro;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel panelDatosPersonales;
    private javax.swing.JPanel panelFechaYHora;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextArea txtMotivo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
