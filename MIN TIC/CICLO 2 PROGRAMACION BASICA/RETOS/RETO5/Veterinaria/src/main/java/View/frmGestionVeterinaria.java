/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.Dog;
import Classes.Pet;
import Classes.ReporteRaza;
import Classes.Reportes.ReportBreed;
import Classes.Reportes.ReportBreedPie;
import Controller.ctlHealthStatus;
import Controller.ctlMascotas;
import Controller.ctlPerro;
import Controller.ctlPet;
import Model.Database;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author zambr
 */
public class frmGestionVeterinaria extends javax.swing.JFrame {

    ctlPet ctlPet = new ctlPet();
    ctlMascotas ctlMascotas = new ctlMascotas();
    ctlPerro ctlPerro = new ctlPerro();
    ctlHealthStatus ctlHealtStatus = new ctlHealthStatus();
            
    LinkedList<Pet> listadoMascotas = new LinkedList<>();
    
    /**
     * Creates new form frmGestionVeterinaria
     */
    public frmGestionVeterinaria() {
        initComponents();
        
        this.fillDogList();        
        //this.generarReporte();        
        //this.generarReporteBarras();
        this.generateBreedReport();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpnMasctoas = new javax.swing.JTabbedPane();
        pnlListadoMascotas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMascotas = new javax.swing.JList<>();
        pnlGestionPerros = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblAnioNacimiento = new javax.swing.JLabel();
        txtAnioNacimiento = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        lblEstadoSalud = new javax.swing.JLabel();
        lblRaza = new javax.swing.JLabel();
        cbxEstadoSalud = new javax.swing.JComboBox<>();
        cbxRaza = new javax.swing.JComboBox<>();
        chkPedigree = new javax.swing.JCheckBox();
        btnCrear = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        pnlGestionGatos = new javax.swing.JPanel();
        pnlReporte = new javax.swing.JPanel();
        pnlReportBreed = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gesti??n veterinaria");
        setResizable(false);

        jScrollPane1.setViewportView(lstMascotas);

        javax.swing.GroupLayout pnlListadoMascotasLayout = new javax.swing.GroupLayout(pnlListadoMascotas);
        pnlListadoMascotas.setLayout(pnlListadoMascotasLayout);
        pnlListadoMascotasLayout.setHorizontalGroup(
            pnlListadoMascotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListadoMascotasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlListadoMascotasLayout.setVerticalGroup(
            pnlListadoMascotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListadoMascotasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpnMasctoas.addTab("Listado de mascotas", pnlListadoMascotas);

        lblCodigo.setText("C??digo");

        lblNombre.setText("Nombre");

        lblAnioNacimiento.setText("A??o Nac.");

        lblColor.setText("Color");

        lblEstadoSalud.setText("Estado salud");

        lblRaza.setText("Raza");

        cbxEstadoSalud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Saludable", "Estable", "Critico", "Delicado" }));

        cbxRaza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Criollo", "Labrador", "Pincher", "Beagle", "Bulldog", "Pitbull", "Otro" }));
        cbxRaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRazaActionPerformed(evt);
            }
        });

        chkPedigree.setText("Pedigree");
        chkPedigree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPedigreeActionPerformed(evt);
            }
        });

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setText("Actualizar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGestionPerrosLayout = new javax.swing.GroupLayout(pnlGestionPerros);
        pnlGestionPerros.setLayout(pnlGestionPerrosLayout);
        pnlGestionPerrosLayout.setHorizontalGroup(
            pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGestionPerrosLayout.createSequentialGroup()
                .addGroup(pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlGestionPerrosLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar))
                    .addGroup(pnlGestionPerrosLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlGestionPerrosLayout.createSequentialGroup()
                                .addComponent(lblEstadoSalud, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkPedigree, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxEstadoSalud, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(pnlGestionPerrosLayout.createSequentialGroup()
                                .addGroup(pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnlGestionPerrosLayout.createSequentialGroup()
                                        .addComponent(lblAnioNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAnioNacimiento))
                                    .addGroup(pnlGestionPerrosLayout.createSequentialGroup()
                                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)))
                        .addGroup(pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGestionPerrosLayout.createSequentialGroup()
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre))
                            .addGroup(pnlGestionPerrosLayout.createSequentialGroup()
                                .addGroup(pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtColor)
                                    .addComponent(cbxRaza, 0, 116, Short.MAX_VALUE))))))
                .addGap(59, 59, 59))
        );
        pnlGestionPerrosLayout.setVerticalGroup(
            pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGestionPerrosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnioNacimiento)
                    .addComponent(txtAnioNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColor)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoSalud)
                    .addComponent(lblRaza)
                    .addComponent(cbxEstadoSalud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkPedigree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(pnlGestionPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnBuscar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(51, 51, 51))
        );

        txtCodigo.getAccessibleContext().setAccessibleName("");
        txtCodigo.getAccessibleContext().setAccessibleDescription("");

        tpnMasctoas.addTab("Gesti??n Perros", pnlGestionPerros);

        javax.swing.GroupLayout pnlGestionGatosLayout = new javax.swing.GroupLayout(pnlGestionGatos);
        pnlGestionGatos.setLayout(pnlGestionGatosLayout);
        pnlGestionGatosLayout.setHorizontalGroup(
            pnlGestionGatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );
        pnlGestionGatosLayout.setVerticalGroup(
            pnlGestionGatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        tpnMasctoas.addTab("Gesti??n Gatos", pnlGestionGatos);

        javax.swing.GroupLayout pnlReporteLayout = new javax.swing.GroupLayout(pnlReporte);
        pnlReporte.setLayout(pnlReporteLayout);
        pnlReporteLayout.setHorizontalGroup(
            pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );
        pnlReporteLayout.setVerticalGroup(
            pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        tpnMasctoas.addTab("Reporte Grafico", pnlReporte);

        javax.swing.GroupLayout pnlReportBreedLayout = new javax.swing.GroupLayout(pnlReportBreed);
        pnlReportBreed.setLayout(pnlReportBreedLayout);
        pnlReportBreedLayout.setHorizontalGroup(
            pnlReportBreedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );
        pnlReportBreedLayout.setVerticalGroup(
            pnlReportBreedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        tpnMasctoas.addTab("Reporte por raza", pnlReportBreed);

        lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblTitulo.setText("Clinica veterinaria");

        btnExportar.setText("Exportar Excel");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tpnMasctoas)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnExportar)
                                .addGap(24, 24, 24))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(tpnMasctoas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkPedigreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPedigreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkPedigreeActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
         
        //Capturar datos
        String codigo = this.txtCodigo.getText();
        String nombre = this.txtNombre.getText();        
        String color = this.txtColor.getText();
        //String estadoSalud = this.cbxEstadoSalud.getSelectedItem().toString();
        int estadoSalud = this.cbxEstadoSalud.getSelectedIndex();
        //String raza = this.cbxRaza.getItemAt( this.cbxRaza.getSelectedIndex() );
        int raza = this.cbxRaza.getSelectedIndex();
        
        boolean pedigree = this.chkPedigree.isSelected();
        int anioNacimiento = 0;
        
        //Validar los datos
        if( ! codigo.trim().matches("[0-9]{1,}") ){
            JOptionPane.showMessageDialog(this, "Digite el c??digo de la mascotas en n??meros", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if( nombre.trim().equals("") ){
            JOptionPane.showMessageDialog(this, "Digite el nombre de la mascotas", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{
            anioNacimiento = Integer.parseInt( this.txtAnioNacimiento.getText() );
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Digite el a??o de nacimiento de la mascota en n??meros", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if( color.trim().equals("") ){
            JOptionPane.showMessageDialog(this, "Digite el color de la mascotas", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        } 
                
        if( this.cbxEstadoSalud.getSelectedIndex() == 0 ){
            JOptionPane.showMessageDialog(this, "Seleccione el estado de salud de la mascota", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if( this.cbxRaza.getSelectedIndex() == 0 ){
            JOptionPane.showMessageDialog(this, "Seleccione la raza de la mascota", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        this.clearForm();
                    
        Dog perro = new Dog();

        perro.setCode( Integer.parseInt(codigo) );
        perro.setName(nombre);
        perro.setBornYear(anioNacimiento);
        perro.setColor(color);
        perro.setPedigree(pedigree);
        perro.setBreed(raza);
        perro.setHealthStatus(estadoSalud);

        String resultAct = ctlPerro.actualizar(perro);

        if (resultAct.equals("")){
            JOptionPane.showMessageDialog(this, "Se actualiz?? con exito", "Gesti??n mascotas", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, resultAct, "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
        }
        
        this.fillDogList();
                
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        String codigo = this.txtCodigo.getText();
        
        //Validar los datos
        if( ! codigo.trim().matches("[0-9]{1,}") ){
            JOptionPane.showMessageDialog(this, "Digite el c??digo de la mascotas en n??meros", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Dog result = ctlPerro.buscarPerroCodigo( Integer.parseInt(codigo) );
        
        if (result != null){
            
            int resultDelete = ctlPerro.eliminarLogico(Integer.parseInt(codigo) );
            
            if(resultDelete == 2)
                JOptionPane.showMessageDialog(this, "Se elimin?? la mascota", "Gesti??n mascotas", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Ocurrio un error al eliminar la mascota", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            
            this.fillDogList();
            this.generateBreedReport();
            
        }else{
            JOptionPane.showMessageDialog(this, "La mascota a eliminar no existe", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
        }
        
        this.clearForm();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
        //Capturar datos
        String codigo = this.txtCodigo.getText();
        String nombre = this.txtNombre.getText();        
        String color = this.txtColor.getText();
        //String estadoSalud = this.cbxEstadoSalud.getSelectedItem().toString();
        int estadoSalud = this.cbxEstadoSalud.getSelectedIndex();
        //String raza = this.cbxRaza.getItemAt( this.cbxRaza.getSelectedIndex() );
        int raza = this.cbxRaza.getSelectedIndex();
        
        boolean pedigree = this.chkPedigree.isSelected();
        int anioNacimiento = 0;
        
        //Validar los datos
        if( ! codigo.trim().matches("[0-9]{1,}") ){
            JOptionPane.showMessageDialog(this, "Digite el c??digo de la mascotas en n??meros", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if( nombre.trim().equals("") ){
            JOptionPane.showMessageDialog(this, "Digite el nombre de la mascotas", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{
            anioNacimiento = Integer.parseInt( this.txtAnioNacimiento.getText() );
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Digite el a??o de nacimiento de la mascota en n??meros", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if( color.trim().equals("") ){
            JOptionPane.showMessageDialog(this, "Digite el color de la mascotas", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        } 
                
        if( this.cbxEstadoSalud.getSelectedIndex() == 0 ){
            JOptionPane.showMessageDialog(this, "Seleccione el estado de salud de la mascota", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if( this.cbxRaza.getSelectedIndex() == 0 ){
            JOptionPane.showMessageDialog(this, "Seleccione la raza de la mascota", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Dog perro = new Dog();
        
        perro.setCode( Integer.parseInt(codigo) );
        perro.setName(nombre);
        perro.setBornYear(anioNacimiento);
        perro.setColor(color);
        perro.setPedigree(pedigree);
        perro.setBreed(raza);
        perro.setHealthStatus(estadoSalud);
        
        //Comunico la vista con el controlador
        boolean result = ctlPerro.registrarPerro(perro);
        
        if( result ){
            JOptionPane.showMessageDialog(this, "Mascota agregada con exito");
        }            
        else{
            JOptionPane.showMessageDialog(this, "Ocurrio un problema al almacenar","Gestion mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        this.fillDogList();
        this.generateBreedReport();
        
        this.clearForm();
                        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        
        String codigo = this.txtCodigo.getText();
        
        //Validar los datos
        if( ! codigo.trim().matches("[0-9]{1,}") ){
            JOptionPane.showMessageDialog(this, "Digite el c??digo de la mascotas en n??meros", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        this.clearForm();
        
        //Comunico la vista con el controlador
        Dog oDog = ctlPerro.buscarPerroCodigo( Integer.parseInt(codigo) );
        
        if( oDog != null){
            this.txtCodigo.setText( oDog.getCode() + "");
            this.txtNombre.setText(oDog.getName());
            this.txtAnioNacimiento.setText(oDog.getBornYear() + "");
            this.txtColor.setText(oDog.getColor());
            this.chkPedigree.setSelected(oDog.getPedigree());
            this.cbxEstadoSalud.setSelectedIndex(oDog.getHealthStatus());
            this.cbxRaza.setSelectedIndex(oDog.getBreed());
        }else{
            JOptionPane.showMessageDialog(this, "No existe la mascota con el c??digo " + codigo, "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbxRazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRazaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRazaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        this.clearForm();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();
        book.setSheetName(0, "Dogs");

        String[] headers = new String[]{
            "Code",
            "Name",
            "Color",
            "Health Status",
            "Pedigree"
        };

        CellStyle headerCellStyle = book.createCellStyle();
        HSSFFont font = book.createFont();
        font.setBold(true);
        headerCellStyle.setFont(font);

        HSSFRow headersRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            String header = headers[i];
            HSSFCell cell = headersRow.createCell(i);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue(header);
        }
        
        LinkedList<Dog> dogList = ctlPerro.buscarGeneral();

        for (int i = 0; i < dogList.size(); i++) {
            HSSFRow row = sheet.createRow(i + 1);
            int code = dogList.get(i).getCode();
            String name = dogList.get(i).getName();
            String color = dogList.get(i).getColor();
            int healthStatus = dogList.get(i).getHealthStatus();
            boolean pedigree = dogList.get(i).getPedigree();
            String pedigreeString = pedigree ? "SI" : "NO";
            
            row.createCell(0).setCellValue(code);
            row.createCell(1).setCellValue(name);
            row.createCell(2).setCellValue(color);
            row.createCell(3).setCellValue(healthStatus);
            row.createCell(4).setCellValue(pedigreeString);
        }
        try {
            FileOutputStream file = new FileOutputStream("listado_mascotas.xls");
            book.write(file);
            file.close();
            JOptionPane.showMessageDialog(this, "Listado mascotas generado", "Gesti??n mascotas", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmGestionVeterinaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmGestionVeterinaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void clearForm(){        
        this.txtCodigo.setText("");
        this.txtNombre.setText("");
        this.txtAnioNacimiento.setText("");
        this.txtColor.setText("");
        this.chkPedigree.setSelected(false);
        this.cbxEstadoSalud.setSelectedIndex(0);
        this.cbxRaza.setSelectedIndex(0);
    }
    
    private void fillDogList(){
        
        try{
            LinkedList<Dog> dogList = ctlPerro.obtenerListado();
            
            DefaultListModel model = new DefaultListModel();
            
            int index = 0;
            for( Dog dog : dogList){
                String data = "(" + dog.getCode() + ") - " + dog.getName()+ " - " + dog.getColor()+ " - " + dog.getBornYear() + " - " + "Perro";
                model.add(index, data);
                index++;
            }
            
            lstMascotas.setModel(model);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Hubo un problema al consultar las mascotas", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
        }               
        
    }
    
    private void generarReporte(){
        
        LinkedList<ReporteRaza> reporte = new LinkedList<>();
        
        reporte = this.ctlPerro.generarReporteRaza();
        
        if(reporte != null){
            DefaultPieDataset dataset = new DefaultPieDataset();
            for (ReporteRaza record : reporte) {
                dataset.setValue( record.getRaza(), record.getCantidad() );
            }
            JFreeChart chart = ChartFactory.createPieChart("Clasificaci??n perros por raza", dataset, true, true, true);
            ChartPanel panel = new ChartPanel(chart);
            panel.setMouseWheelEnabled(true);
            pnlReporte.setLayout(new java.awt.BorderLayout());
            pnlReporte.add(panel, BorderLayout.CENTER);
            pnlReporte.validate();
        }
        
    }
    
    private void generarReporteBarras(){
        LinkedList<ReporteRaza> reporte = new LinkedList<>();
        
        reporte = this.ctlPerro.generarReporteRaza();
        
        if(reporte != null){
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (ReporteRaza record : reporte) {
                dataset.setValue(record.getCantidad(), record.getRaza(), record.getRaza() );
            }
            JFreeChart chart = ChartFactory.createBarChart("Clasificaci??n perros por raza", "Raza Mascota", "Cantidad", dataset);
            ChartPanel panel = new ChartPanel(chart);
            panel.setMouseWheelEnabled(true);
            pnlReporte.setLayout(new java.awt.BorderLayout());
            pnlReporte.add(panel, BorderLayout.CENTER);
            pnlReporte.validate();
        }
    }
    
    private void generateBreedReport(){
        
        LinkedList<ReportBreedPie> listReport = new LinkedList<ReportBreedPie>();
        
        try{
            
            listReport = this.ctlPerro.getBreedReport();
            
            if( listReport != null){
                
                //Configurar el gr??fico
                DefaultPieDataset dataset = new DefaultPieDataset();
                
                for( ReportBreedPie temp : listReport ){
                    dataset.setValue( temp.getBreed() , temp.getCount() );
                }
                
                JFreeChart chart = ChartFactory.createPieChart("Clasificaci??n de perros por raza", dataset, true, true, false);
                ChartPanel panel = new ChartPanel(chart);
                
                pnlReportBreed.setLayout( new java.awt.BorderLayout() );
                pnlReportBreed.add(panel, BorderLayout.CENTER );
                pnlReportBreed.validate();
                
            }else{
                JOptionPane.showMessageDialog(this, "No hay datos para generar el reporte", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }catch( SQLException e ){
            JOptionPane.showMessageDialog(this, "Hubo un problema en la base de datos al generar el reporte", "Gesti??n mascotas", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
            java.util.logging.Logger.getLogger(frmGestionVeterinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmGestionVeterinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmGestionVeterinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmGestionVeterinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmGestionVeterinaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbxEstadoSalud;
    private javax.swing.JComboBox<String> cbxRaza;
    private javax.swing.JCheckBox chkPedigree;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnioNacimiento;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblEstadoSalud;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRaza;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> lstMascotas;
    private javax.swing.JPanel pnlGestionGatos;
    private javax.swing.JPanel pnlGestionPerros;
    private javax.swing.JPanel pnlListadoMascotas;
    private javax.swing.JPanel pnlReportBreed;
    private javax.swing.JPanel pnlReporte;
    private javax.swing.JTabbedPane tpnMasctoas;
    private javax.swing.JTextField txtAnioNacimiento;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
