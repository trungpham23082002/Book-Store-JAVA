package GUI;

import DAO.DBConnection;
import DAO.DAO_ChiTietHDB;
import DAO.DAO_HoaDonBan;
import DAO.DAO_Sach;
import DAO.DAO_SanPham;
import DAO.DAO_ThanhVien;
import DAO.DBConnection;
import DTO.DTO_ChiTietHoaDonBan;
import DTO.DTO_HoaDonBan;
import DTO.DTO_ThanhVien;
import java.awt.Point;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import java.util.Map;
import javax.swing.JTable;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author ChauCuteVCL
 */
public class penel_QLHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form penel_QLHoaDon
     */
    DAO_HoaDonBan dao = new DAO_HoaDonBan();
    Vector title = new Vector();
    DefaultTableModel model = new DefaultTableModel();
    Vector titleCT = new Vector();
    DefaultTableModel modelCT = new DefaultTableModel();
    String id="";

    public penel_QLHoaDon() {
        initComponents();
        rdo_hd.setSelected(true);
        setEnableForText(txt_SoHD);
        loadTitle();
        loadTitleCT();
        loadDS();
    }
  

    public void loadDS()
    {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(title);
        ArrayList<DTO_HoaDonBan> lst = dao.getDS_HDB();
        for(DTO_HoaDonBan i : lst)
        {
            
            Vector a = new Vector();
            String ngayLapStr=i.ngayLap;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Chuyển đổi từ chuỗi sang ngày
        LocalDate ngayLap = LocalDate.parse(ngayLapStr, formatter);

        // Cộng thêm 2 ngày
        LocalDate ngayLapPlus2 = ngayLap.plusDays(2);

        // Chuyển đổi từ ngày sang chuỗi
        String ngayLapPlus2Str = ngayLapPlus2.format(formatter);

            
            String x = (i.maTV.equals("1"))?"None":i.maTV;
            a.add(i.soHD);a.add(ngayLapPlus2Str);a.add(i.tongTien);a.add(i.tongGiam);a.add(i.thanhTien);a.add(x);a.add(i.maGG);a.add(i.nguoiLap);
            model.addRow(a);
        }
        table_QLHD.setModel(model);
    }
    
   
    
    
    public void loadDSCT(String sohd)
    {
        modelCT = new DefaultTableModel();
        modelCT.setColumnIdentifiers(titleCT);
        ArrayList<DTO_ChiTietHoaDonBan> lst = DAO_ChiTietHDB.getDS_CTHDB(sohd);
        for(DTO_ChiTietHoaDonBan i : lst)
        {
            Vector a = new Vector();
            String x = DAO_Sach.getTenSach_from_MaSach(i.masach);
            a.add(i.sohd);a.add(x);a.add(i.soluong);a.add(i.tongtien);
            modelCT.addRow(a);
        }
        table_QLCTHD.setModel(modelCT);
    }
    
    public void loadTitle()
    {
        title.add("Số HD");      
        title.add("Ngày lập");
        title.add("Tổng tiền");
        title.add("Tổng giảm");
        title.add("Thành tiền");
        title.add("Mã thành viên");
        title.add("Mã giảm giá");
        title.add("Người lập");
    }
    
    public void loadTitleCT()
    {
        titleCT.add("Số HD");      
        titleCT.add("Mã sách");
        titleCT.add("Số lượng");
        titleCT.add("Tổng tiền");
        modelCT.setColumnIdentifiers(titleCT);
        table_QLCTHD.setModel(modelCT);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_SoHD = new javax.swing.JTextField();
        btn_CheckHD = new javax.swing.JButton();
        btn_Reset = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_NgayLap = new javax.swing.JTextField();
        txt_SDT_TV = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btn_XuatHD = new javax.swing.JButton();
        rdo_hd = new javax.swing.JRadioButton();
        rdo_nl = new javax.swing.JRadioButton();
        rdo_sdt = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_QLCTHD = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_QLHD = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Ngày lập:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Số hóa đơn");

        txt_SoHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btn_CheckHD.setBackground(new java.awt.Color(102, 153, 255));
        btn_CheckHD.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btn_CheckHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkTT.png"))); // NOI18N
        btn_CheckHD.setText("Tra cứu hóa đơn");
        btn_CheckHD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_CheckHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CheckHDActionPerformed(evt);
            }
        });

        btn_Reset.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btn_Reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reset.png"))); // NOI18N
        btn_Reset.setText("Làm mới");
        btn_Reset.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_Reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ResetMouseClicked(evt);
            }
        });
        btn_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResetActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tìm kiếm hóa đơn:");
        jLabel3.setToolTipText("");

        txt_NgayLap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_NgayLap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NgayLapKeyTyped(evt);
            }
        });

        txt_SDT_TV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_SDT_TV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SDT_TVKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("SDT thành viên:");

        btn_XuatHD.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btn_XuatHD.setForeground(new java.awt.Color(255, 153, 0));
        btn_XuatHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bill.png"))); // NOI18N
        btn_XuatHD.setText("Xuất HD");
        btn_XuatHD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_XuatHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XuatHDActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo_hd);
        rdo_hd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_hdActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo_nl);
        rdo_nl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_nlActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo_sdt);
        rdo_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_sdtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(rdo_hd)
                        .addGap(339, 339, 339)
                        .addComponent(rdo_nl)
                        .addGap(398, 398, 398)
                        .addComponent(rdo_sdt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txt_SoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txt_NgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(txt_SDT_TV, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_XuatHD, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(btn_Reset))
                    .addComponent(btn_CheckHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdo_hd)
                            .addComponent(rdo_nl)
                            .addComponent(rdo_sdt))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_SoHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txt_NgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(txt_SDT_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_XuatHD, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_CheckHD, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        table_QLCTHD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        table_QLCTHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        table_QLCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_QLCTHD.setRowHeight(35);
        jScrollPane1.setViewportView(table_QLCTHD);

        table_QLHD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        table_QLHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        table_QLHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_QLHD.setRowHeight(35);
        table_QLHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_QLHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_QLHD);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Danh sách hóa đơn:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Chi tiết hóa đơn:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ResetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ResetMouseClicked

    private void btn_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResetActionPerformed
        // TODO add your handling code here:
        rdo_hd.setSelected(true);
        setEnableForText(txt_SoHD);
        ClearForText();
        loadDS();
    }//GEN-LAST:event_btn_ResetActionPerformed

    private void rdo_hdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_hdActionPerformed
        // TODO add your handling code here:
        setEnableForText(txt_SoHD);
    }//GEN-LAST:event_rdo_hdActionPerformed

    private void rdo_nlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_nlActionPerformed
        // TODO add your handling code here:
        setEnableForText(txt_NgayLap);
    }//GEN-LAST:event_rdo_nlActionPerformed

    private void rdo_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_sdtActionPerformed
        // TODO add your handling code here:
        setEnableForText(txt_SDT_TV);
    }//GEN-LAST:event_rdo_sdtActionPerformed

    private void btn_CheckHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CheckHDActionPerformed
        // TODO add your handling code here:
              
        if(rdo_hd.isSelected())
        {
            if(!txt_SoHD.getText().trim().equals(""))
            {
                if(dao.checkExist_SoHD(txt_SoHD.getText().trim())){
                    DTO_HoaDonBan i = dao.getDS_fromSoHD(txt_SoHD.getText().trim());
                    model = new DefaultTableModel();
                    model.setColumnIdentifiers(title);
                    Vector a = new Vector();
                    String x = (i.maTV.equals("1"))?"None":i.maTV;
                    a.add(i.soHD);a.add(i.ngayLap);a.add(i.tongTien);a.add(i.tongGiam);a.add(i.thanhTien);a.add(x);a.add(i.maGG);a.add(i.nguoiLap);
                    model.addRow(a);
                    
                    table_QLHD.setModel(model);
                }
                else
                JOptionPane.showMessageDialog(this, "Không tồn tại hóa đơn: "+txt_SoHD.getText().trim());
            }            
            else
                JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin số hóa đơn!");
        }
        else if(rdo_nl.isSelected())
        {
            if(!txt_NgayLap.getText().trim().equals(""))
            {
                if(dao.checkExist_NgayLap(txt_NgayLap.getText().trim())){
                    ArrayList<DTO_HoaDonBan> lst = dao.getDS_fromNgayLap(txt_NgayLap.getText().trim());
                    model = new DefaultTableModel();
                    model.setColumnIdentifiers(title);
                    for(DTO_HoaDonBan i : lst)
                    {
                    Vector a = new Vector();
                    String x = (i.maTV.equals("1"))?"None":i.maTV;
                    a.add(i.soHD);a.add(i.ngayLap);a.add(i.tongTien);a.add(i.tongGiam);a.add(i.thanhTien);a.add(x);a.add(i.maGG);a.add(i.nguoiLap);
                    model.addRow(a);
                    }
                    
                    table_QLHD.setModel(model);
                }
                else
                JOptionPane.showMessageDialog(this, "Không tồn tại hóa đơn ngày: "+txt_NgayLap.getText().trim());
            }            
            else
                JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin ngày lập hóa đơn!");
        }
        else
        {
            if(!txt_SDT_TV.getText().trim().equals(""))
            {
                if(dao.checkExist_SDT_TV(txt_SDT_TV.getText().trim())){
                    ArrayList<DTO_HoaDonBan> lst = dao.getDS_fromSDT(txt_SDT_TV.getText().trim());
                    model = new DefaultTableModel();
                    model.setColumnIdentifiers(title);
                    for(DTO_HoaDonBan i : lst)
                    {
                    Vector a = new Vector();
                    String x = (i.maTV.equals("1"))?"None":i.maTV;
                    a.add(i.soHD);a.add(i.ngayLap);a.add(i.tongTien);a.add(i.tongGiam);a.add(i.thanhTien);a.add(x);a.add(i.maGG);a.add(i.nguoiLap);
                    model.addRow(a);
                    }
                    
                    table_QLHD.setModel(model);
                }
                else
                JOptionPane.showMessageDialog(this, "Không tồn tại hóa đơn có SĐT: "+txt_SDT_TV.getText().trim());
            }            
            else
                JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin số điện thoại!");
        }
    
    }//GEN-LAST:event_btn_CheckHDActionPerformed

    private void txt_NgayLapKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NgayLapKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()>'9' || evt.getKeyChar()<'0' && evt.getKeyChar()!='-') evt.consume();
    }//GEN-LAST:event_txt_NgayLapKeyTyped

    private void table_QLHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_QLHDMouseClicked
        // TODO add your handling code here:
        
        Point p = evt.getPoint();
        int row = table_QLHD.rowAtPoint(p);
        String sohd = (String)model.getValueAt(row, 0).toString();
        id = sohd;
        loadDSCT(sohd);
    }//GEN-LAST:event_table_QLHDMouseClicked

    private void txt_SDT_TVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SDT_TVKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()>'9' || evt.getKeyChar()<'0') evt.consume();
    }//GEN-LAST:event_txt_SDT_TVKeyTyped

    private void btn_XuatHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XuatHDActionPerformed
        // TODO add your handling code here:
       try
    {
        Hashtable map = new Hashtable();
        JasperReport rp=JasperCompileManager.compileReport("src/main/java/REPORT/rp_QLHoaDon.jrxml");
        map.put("SoHD", id);
        DBConnection cn  = new DBConnection();
        JasperPrint print = JasperFillManager.fillReport(rp, map, cn.getCn());
        JasperViewer.viewReport(print,false);
        
        }
       catch(JRException ex)
        {
            Logger.getLogger(penel_QLHoaDon.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_btn_XuatHDActionPerformed
    
    private void setEnableForText(JTextField tf)
    {
        JTextField[] ds = new JTextField[]{txt_NgayLap,txt_SDT_TV,txt_SoHD};
        for(JTextField i : ds)
            if(i!=tf)
                i.setEnabled(false);
        tf.setEnabled(true);
    }
    private void ClearForText()
    {
        JTextField[] ds = new JTextField[]{txt_NgayLap,txt_SDT_TV,txt_SoHD};
        for(JTextField i : ds)
                i.setText("");
    }
    
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
    
          
    
    
    private String convertDMYtoYMD(String _date)
    {
        try
        {            
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
            Date date = (Date)formatter.parse(_date);
            SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
            return newFormat.format(date).toString();
        }
        catch(Exception ex){return "$$";}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CheckHD;
    private javax.swing.JButton btn_Reset;
    private javax.swing.JButton btn_XuatHD;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdo_hd;
    private javax.swing.JRadioButton rdo_nl;
    private javax.swing.JRadioButton rdo_sdt;
    private javax.swing.JTable table_QLCTHD;
    private javax.swing.JTable table_QLHD;
    private javax.swing.JTextField txt_NgayLap;
    private javax.swing.JTextField txt_SDT_TV;
    private javax.swing.JTextField txt_SoHD;
    // End of variables declaration//GEN-END:variables
}
