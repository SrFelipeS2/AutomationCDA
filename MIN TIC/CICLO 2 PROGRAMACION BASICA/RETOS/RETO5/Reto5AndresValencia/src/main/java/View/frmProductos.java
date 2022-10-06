/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ctlProveedores;
import java.util.LinkedList;
import clasesreportes.ReportProductos;
import clasesreportes.ReporteListadoProducto;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author jotarlo
 */
public class frmProductos extends javax.swing.JFrame {

    /**
     * Creates new form frmProduct
     */
    public frmProductos() {
        initComponents();
        this.generateProductReport();
    }
    
    ctlProveedores ctlProveedores = new ctlProveedores();
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        pnlGrafico = new javax.swing.JPanel();
        btnExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Grafico Productos vs Productor");

        jButton5.setText("Volver al Inicio");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGraficoLayout = new javax.swing.GroupLayout(pnlGrafico);
        pnlGrafico.setLayout(pnlGraficoLayout);
        pnlGraficoLayout.setHorizontalGroup(
            pnlGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGraficoLayout.setVerticalGroup(
            pnlGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

        btnExcel.setText("Gerara Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGrafico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jButton5)
                        .addGap(42, 42, 42)
                        .addComponent(btnExcel)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(btnExcel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(pnlGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        frmMenu menu = new frmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        this.generarReporteListadoProducto();     // TODO add your handling code here:
    }//GEN-LAST:event_btnExcelActionPerformed

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
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProductos().setVisible(true);
            }
        });
    }
    
    private void generateProductReport(){
        LinkedList<ReportProductos> reporte = new LinkedList<>(); 
        
        try{
            reporte = ctlProveedores.obtenerListado();
            
            if(reporte != null){
                DefaultPieDataset dataset = new DefaultPieDataset();
                
                for (ReportProductos record : reporte) {
                    dataset.setValue( record.getRazon_social(), record.getCantidad_Productos() );
                }
                
                JFreeChart chart = ChartFactory.createPieChart("Cntidad de productos por Proveedor", dataset, true, true, false);
                ChartPanel panel = new ChartPanel(chart);
                panel.setMouseWheelEnabled(true);
                pnlGrafico.setLayout(new java.awt.BorderLayout());
                pnlGrafico.add(panel, BorderLayout.CENTER);
                pnlGrafico.validate();
                
                
            }else{
                JOptionPane.showMessageDialog(this, "No existen datos para generar el grafico", "Gestión mascotas", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Hubo un problema en la base de datos al generar el reporte", "Gestión mascotas", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void generarReporteListadoProducto(){
         
        try{
            LinkedList<ReporteListadoProducto> list = ctlProveedores.obtenerListadoProducto();
            
            if( list != null){
                
                HSSFWorkbook book = new HSSFWorkbook();
                HSSFSheet sheet = book.createSheet();
                book.setSheetName(0, "Listado productos");

                String[] headers = new String[]{
                    "Razon Social",
                    "Telefono",
                    "Barrio",
                    "Ciudad",
                    "Representante Legal",
                    "Nombre producto",
                    "Valor unitario",
                    "Cantidad"
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

                for (int i = 0; i < list.size(); i++) {
                    
                    HSSFRow row = sheet.createRow(i + 1);
                    
                    row.createCell(0).setCellValue( list.get(i).getRazon_social());
                    row.createCell(1).setCellValue( list.get(i).getTelefono());
                    row.createCell(2).setCellValue( list.get(i).getBarrio());
                    row.createCell(3).setCellValue( list.get(i).getCiudad());
                    row.createCell(4).setCellValue( list.get(i).getRepresentate_legal());
                    row.createCell(5).setCellValue( list.get(i).getNombre());
                    row.createCell(6).setCellValue( list.get(i).getValorUnitario());
                    row.createCell(7).setCellValue( list.get(i).getCantidad());

                }
                try {
                    FileOutputStream file = new FileOutputStream("listado_productos.xls");
                    book.write(file);
                    file.close();
                    
                    JOptionPane.showMessageDialog(this, "Listado de productos generado correctamente", "Gestión proveedores", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(frmProductos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "No se pudo crear el archivo", "Gestión proveedores", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(frmProductos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "No hay datos para generar el reporte", "Gestión proveedores", JOptionPane.ERROR_MESSAGE);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Hubo en error en la base de datos", "Gestión de proveedores", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlGrafico;
    // End of variables declaration//GEN-END:variables
}
