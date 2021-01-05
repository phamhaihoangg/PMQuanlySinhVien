/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.GiaoVienDAO;
import dao.HocVienDAO;
import dao.KhoaHocDAO;
import dao.LopHocDAO;
import dao.MonHocDAO;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.GiaoVien;
import model.HocVien;
import model.KhoaHoc;
import model.LopHoc;
import model.MonHoc;
import utility.DateTimeUtil;

/**
 *
 * @author HaiHoang
 */
public class Panel_BoMon extends javax.swing.JPanel {
    HocVien hocVien;
    KhoaHoc khoaHoc;
    LopHoc lopHoc;
    GiaoVien giaoVien;
    MonHoc monHoc;

    HocVienDAO hocVienDAO;
    KhoaHocDAO khoaHocDAO;
    LopHocDAO lopHocDAO;
    GiaoVienDAO giaoVienDAO;
    MonHocDAO monHocDAO;

    List<HocVien> lstHocVien;
    List<KhoaHoc> lstKhoaHoc;
    List<LopHoc> lstLopHoc;
    List<GiaoVien> lstGiaoVien;
    List<MonHoc> lstMonHoc;

    DefaultTableModel defaultTableModelMonHoc;
    DefaultTableModel defaultTableModelKhoaHoc;
    /**
     * Creates new form Panel_BoMon
     */
    
    
      
    public Panel_BoMon() {
        initComponents();
        hocVienDAO = new HocVienDAO();
        lopHocDAO = new LopHocDAO();
        khoaHocDAO = new KhoaHocDAO();
        giaoVienDAO = new GiaoVienDAO();
        monHocDAO = new MonHocDAO();
        
        showTable1();
        showTable2();
        initData1();
        initData2();
        loadData1();
        loadData2();
        btnAdd.setEnabled(true);
        btnAdd2.setEnabled(true);
        btnDelete.setEnabled(false);
        btnDelete2.setEnabled(false);
        btnEdit.setEnabled(false);
        btnEdit2.setEnabled(false);
    }
    
     public void initData1() {
        if (monHoc != null) {
            txtTenMonHoc.setText(monHoc.getTen_mon_hoc()+ "");
            Integer.parseInt(txtTinChi.getText());
            Integer.parseInt(txtHocPhi.getText());
            ckbTrangThai.setSelected(ckbTrangThai.isSelected());

        } else {
            monHoc = new MonHoc();
        }
    }
     public void initData2() {
        if (khoaHoc != null) {
            txtTenKhoaHoc.setText(khoaHoc.getTen_khoa_hoc()+ "");
            dateChooserCombo1.setSelectedDate(DateTimeUtil.localDate2Calendar(khoaHoc.getNgay_bat_dau()));
            dateChooserCombo2.setSelectedDate(DateTimeUtil.localDate2Calendar(khoaHoc.getNgay_ket_thuc()));

        } else {
            khoaHoc = new KhoaHoc();
        }
    }
    private void showTable1() {

//        jTable1.setCellSelectionEnabled(true);
        defaultTableModelMonHoc = new DefaultTableModel();

        defaultTableModelMonHoc.addColumn("STT");
        defaultTableModelMonHoc.addColumn("Tên Môn");
        defaultTableModelMonHoc.addColumn("Số Tín Chỉ");
        defaultTableModelMonHoc.addColumn("Học Phí");
        defaultTableModelMonHoc.addColumn("Trạng Thái");
    }
        private void showTable2() {

//        jTable1.setCellSelectionEnabled(true);
        defaultTableModelKhoaHoc = new DefaultTableModel();

        defaultTableModelKhoaHoc.addColumn("STT");
        defaultTableModelKhoaHoc.addColumn("Tên Khóa Học");
        defaultTableModelKhoaHoc.addColumn("Ngày Bắt Đầu");
        defaultTableModelKhoaHoc.addColumn("Ngày Kết Thúc");
    }
    private void loadData1() {
        lstMonHoc = monHocDAO.getAll();

        defaultTableModelMonHoc.setRowCount(0);
        Vector v;
        for (MonHoc mh : lstMonHoc) {
            v = new Vector();
            v.add(mh.getId());
            v.add(mh.getTen_mon_hoc());
            v.add(mh.getTin_chi());
            v.add(mh.getHoc_phi());
            v.add(mh.getTrang_thai()? "Đang Giảng Dạy" : "Đã Ngừng Giảng Dạy");

            defaultTableModelMonHoc.addRow(v);
        }
        if (lstMonHoc.size() > 0) {
            tblMonHoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    int pos = tblMonHoc.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }

                    monHoc = lstMonHoc.get(pos);
                }
            });
        }
        tblMonHoc.setModel(defaultTableModelMonHoc);
    }
    private void loadData2() {
        lstKhoaHoc = khoaHocDAO.getAll();

        defaultTableModelKhoaHoc.setRowCount(0);
        Vector v;
        for (KhoaHoc kh : lstKhoaHoc) {
            v = new Vector();
            v.add(kh.getId());
            v.add(kh.getTen_khoa_hoc());
            v.add(kh.getNgay_bat_dau());
            v.add(kh.getNgay_ket_thuc());

            defaultTableModelKhoaHoc.addRow(v);
        }
        if (lstKhoaHoc.size() > 0) {
            tblKhoaHoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    int pos = tblKhoaHoc.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }

                    khoaHoc = lstKhoaHoc.get(pos);
                }
            });
        }
        tblKhoaHoc.setModel(defaultTableModelKhoaHoc);
    }
        private void delete1() {
        int mh = monHoc.getId();
        monHocDAO.delete(mh);
    }
        private void delete2(){
            int kh = khoaHoc.getId();
            khoaHocDAO.delete(kh);
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        SearchNameMH = new javax.swing.JTextField();
        Cbx_Subject = new javax.swing.JComboBox<>();
        btnSearchMH = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMonHoc = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTenMonHoc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ckbTrangThai = new javax.swing.JCheckBox();
        txtTinChi = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        Panel_Add_Subject = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        Panel_Edit_Subject = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        SearchNameKH = new javax.swing.JTextField();
        btnSearchKH = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblKhoaHoc = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtTenKhoaHoc = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jPanel34 = new javax.swing.JPanel();
        btnAdd2 = new javax.swing.JButton();
        btnReset2 = new javax.swing.JButton();
        btnEdit2 = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Tên Môn:");

        SearchNameMH.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        Cbx_Subject.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        Cbx_Subject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSearchMH.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnSearchMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-zoom-in-32.png"))); // NOI18N
        btnSearchMH.setText("Tìm Kiếm");
        btnSearchMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchMHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchNameMH)
                .addGap(18, 18, 18)
                .addComponent(Cbx_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchMH, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSearchMH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_Subject)
                    .addComponent(SearchNameMH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tblMonHoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblMonHoc.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMonHocMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblMonHocMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblMonHoc);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thêm Môn Học Mới", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 16))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setText("Nhập Tên Môn Học:");

        txtTenMonHoc.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        txtTenMonHoc.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setText("Tín Chỉ:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setText("Học Phí:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel8.setText("Trạng Thái");

        ckbTrangThai.setText("Đã Ngừng Giảng Dạy");
        ckbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenMonHoc)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ckbTrangThai)
                                .addGap(42, 42, 42)))
                        .addContainerGap())
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(141, Short.MAX_VALUE)
                    .addComponent(txtTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addComponent(txtTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(16, 16, 16)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ckbTrangThai))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(txtTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(145, Short.MAX_VALUE)))
        );

        btnAdd.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-32.png"))); // NOI18N
        btnAdd.setText("Thêm Mới");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-replay-32.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_Add_SubjectLayout = new javax.swing.GroupLayout(Panel_Add_Subject);
        Panel_Add_Subject.setLayout(Panel_Add_SubjectLayout);
        Panel_Add_SubjectLayout.setHorizontalGroup(
            Panel_Add_SubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_Add_SubjectLayout.createSequentialGroup()
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd))
        );
        Panel_Add_SubjectLayout.setVerticalGroup(
            Panel_Add_SubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Add_SubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnAdd)
                .addComponent(btnReset))
        );

        btnEdit.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-edit-32.png"))); // NOI18N
        btnEdit.setText("Chỉnh Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_Edit_SubjectLayout = new javax.swing.GroupLayout(Panel_Edit_Subject);
        Panel_Edit_Subject.setLayout(Panel_Edit_SubjectLayout);
        Panel_Edit_SubjectLayout.setHorizontalGroup(
            Panel_Edit_SubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Edit_SubjectLayout.createSequentialGroup()
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 151, Short.MAX_VALUE))
        );
        Panel_Edit_SubjectLayout.setVerticalGroup(
            Panel_Edit_SubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Edit_SubjectLayout.createSequentialGroup()
                .addComponent(btnEdit)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        btnDelete.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-32.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Panel_Edit_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(Panel_Add_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Add_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_Edit_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Môn học", jPanel3);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel15.setText("Tên Khóa:");

        SearchNameKH.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        btnSearchKH.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnSearchKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-zoom-in-32.png"))); // NOI18N
        btnSearchKH.setText("Tìm kiếm");
        btnSearchKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchNameKH)
                .addGap(18, 18, 18)
                .addComponent(btnSearchKH, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSearchKH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchNameKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tblKhoaHoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblKhoaHoc.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhoaHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhoaHocMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblKhoaHocMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tblKhoaHoc);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thêm Khóa Học Mới", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 16))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel16.setText("Tên Khóa Học:");

        txtTenKhoaHoc.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        txtTenKhoaHoc.setToolTipText("");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel17.setText("Ngày bắt đầu khóa:");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel18.setText("Ngày kết thúc khóa:");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooserCombo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenKhoaHoc, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel16)
                .addGap(10, 10, 10)
                .addComponent(txtTenKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateChooserCombo2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAdd2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-32.png"))); // NOI18N
        btnAdd2.setText("Thêm Mới");
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });

        btnReset2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnReset2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-replay-32.png"))); // NOI18N
        btnReset2.setText("Reset");
        btnReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset2ActionPerformed(evt);
            }
        });

        btnEdit2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnEdit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-edit-32.png"))); // NOI18N
        btnEdit2.setText("Chỉnh Sửa");
        btnEdit2.setToolTipText("");
        btnEdit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit2ActionPerformed(evt);
            }
        });

        btnDelete2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-32.png"))); // NOI18N
        btnDelete2.setText("Xóa");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(btnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(btnReset2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset2)
                    .addComponent(btnAdd2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit2)
                    .addComponent(btnDelete2))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khóa học", jPanel7);

        jDesktopPane1.setLayer(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchMHActionPerformed
        String nameMH = SearchNameMH.getText();
        if(nameMH.length()==0){
          lstMonHoc = monHocDAO.getAll();

        defaultTableModelMonHoc.setRowCount(0);
        Vector v;
        for (MonHoc mh : lstMonHoc) {
            v = new Vector();
            v.add(mh.getId());
            v.add(mh.getTen_mon_hoc());
            v.add(mh.getTin_chi());
            v.add(mh.getHoc_phi());
            v.add(mh.getTrang_thai()? "Đang Giảng Dạy" : "Đã Ngừng Giảng Dạy");

            defaultTableModelMonHoc.addRow(v);
        }
        if (lstMonHoc.size() > 0) {
            tblMonHoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    int pos = tblMonHoc.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }

                    monHoc = lstMonHoc.get(pos);
                }
            });
        }
        tblMonHoc.setModel(defaultTableModelMonHoc);
        showTable1();
        }else{
            lstMonHoc = monHocDAO.Search(nameMH);

        defaultTableModelMonHoc.setRowCount(0);
        Vector v;
        for (MonHoc mh : lstMonHoc) {
            v = new Vector();
            v.add(mh.getId());
            v.add(mh.getTen_mon_hoc());
            v.add(mh.getTin_chi());
            v.add(mh.getHoc_phi());
            v.add(mh.getTrang_thai()? "Đang Giảng Dạy" : "Đã Ngừng Giảng Dạy");

            defaultTableModelMonHoc.addRow(v);
        }
        if (lstMonHoc.size() > 0) {
            tblMonHoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    int pos = tblMonHoc.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }

                    monHoc = lstMonHoc.get(pos);
                }
            });
        }
        tblMonHoc.setModel(defaultTableModelMonHoc);
        showTable1();
        }
    }//GEN-LAST:event_btnSearchMHActionPerformed

    private void tblMonHocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonHocMousePressed

        
    }//GEN-LAST:event_tblMonHocMousePressed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        monHoc.setTen_mon_hoc(txtTenMonHoc.getText());
        monHoc.setTin_chi(Integer.valueOf(txtTinChi.getText()));
        monHoc.setHoc_phi(Integer.valueOf(txtHocPhi.getText()));
        monHoc.setTrang_thai(ckbTrangThai.isSelected());
        if(txtTenMonHoc.getText().length()==0 || txtTinChi.getText().length()==0 || txtHocPhi.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin để tiến hành");
        }
        if (monHoc.getId() > 0) {
            monHocDAO.update(monHoc);
        } else {
            monHocDAO.insert(monHoc);
        }
        loadData1();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtTenMonHoc.setText("");
        txtHocPhi.setText("");
        txtTinChi.setText("");
        ckbTrangThai.setSelected(false);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSearchKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchKHActionPerformed
       String nameKH = SearchNameKH.getText();
       if(nameKH.length()==0){
           lstKhoaHoc = khoaHocDAO.getAll();

        defaultTableModelKhoaHoc.setRowCount(0);
        Vector v;
        for (KhoaHoc kh : lstKhoaHoc) {
            v = new Vector();
            v.add(kh.getId());
            v.add(kh.getTen_khoa_hoc());
            v.add(kh.getNgay_bat_dau());
            v.add(kh.getNgay_ket_thuc());

            defaultTableModelKhoaHoc.addRow(v);
        }
        if (lstKhoaHoc.size() > 0) {
            tblKhoaHoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    int pos = tblKhoaHoc.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }

                    khoaHoc = lstKhoaHoc.get(pos);
                }
            });
        }
        tblKhoaHoc.setModel(defaultTableModelKhoaHoc);
        showTable2();
       }else{
        lstKhoaHoc = khoaHocDAO.Search(nameKH);

        defaultTableModelKhoaHoc.setRowCount(0);
        Vector v;
        for (KhoaHoc kh : lstKhoaHoc) {
            v = new Vector();
            v.add(kh.getId());
            v.add(kh.getTen_khoa_hoc());
            v.add(kh.getNgay_bat_dau());
            v.add(kh.getNgay_ket_thuc());

            defaultTableModelKhoaHoc.addRow(v);
        }
        if (lstKhoaHoc.size() > 0) {
            tblKhoaHoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    int pos = tblKhoaHoc.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }

                    khoaHoc = lstKhoaHoc.get(pos);
                }
            });
        }
        tblKhoaHoc.setModel(defaultTableModelKhoaHoc);
        showTable2();
       }
    }//GEN-LAST:event_btnSearchKHActionPerformed

    private void tblKhoaHocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoaHocMousePressed
        
        
    }//GEN-LAST:event_tblKhoaHocMousePressed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        khoaHoc.setTen_khoa_hoc(txtTenKhoaHoc.getText());
        Calendar calendar1 = dateChooserCombo1.getSelectedDate();
        LocalDate localDate1 = LocalDateTime.ofInstant(calendar1.toInstant(), ZoneId.systemDefault()).toLocalDate();
        khoaHoc.setNgay_bat_dau(localDate1);
        Calendar calendar2 = dateChooserCombo2.getSelectedDate();
        LocalDate localDate2 = LocalDateTime.ofInstant(calendar2.toInstant(), ZoneId.systemDefault()).toLocalDate();
        khoaHoc.setNgay_ket_thuc(localDate2);
        if( txtTenKhoaHoc.getText().length()==0 ){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin để tiến hành");
        }
        if (khoaHoc.getId() > 0) {
            khoaHocDAO.update(khoaHoc);
        } else {
            khoaHocDAO.insert(khoaHoc);
        }
        loadData2();
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset2ActionPerformed
        txtTenKhoaHoc.setText("");
    }//GEN-LAST:event_btnReset2ActionPerformed

    private void btnEdit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit2ActionPerformed
        khoaHoc.setTen_khoa_hoc(txtTenKhoaHoc.getText());
        Calendar calendar1 = dateChooserCombo1.getSelectedDate();
        LocalDate localDate1 = LocalDateTime.ofInstant(calendar1.toInstant(), ZoneId.systemDefault()).toLocalDate();
        khoaHoc.setNgay_bat_dau(localDate1);
        Calendar calendar2 = dateChooserCombo2.getSelectedDate();
        LocalDate localDate2 = LocalDateTime.ofInstant(calendar2.toInstant(), ZoneId.systemDefault()).toLocalDate();
        khoaHoc.setNgay_ket_thuc(localDate2);
        if (khoaHoc.getId() > 0) {
            khoaHocDAO.update(khoaHoc);
        } else {
            khoaHocDAO.insert(khoaHoc);
        }
        loadData2();
    }//GEN-LAST:event_btnEdit2ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {
                delete2();
            } catch (Exception e) {
            }
            while (defaultTableModelKhoaHoc.getRowCount() > 0) {
                defaultTableModelKhoaHoc.removeRow(0);

            }
            loadData2();
    }   
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void ckbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbTrangThaiActionPerformed
        // TODO add your handling code here:
        if(ckbTrangThai.isSelected()){
            ckbTrangThai.setText("Đang Giảng Dạy");
        }else{
            ckbTrangThai.setText("Đã Ngừng Giảng Dạy");
        }
    }//GEN-LAST:event_ckbTrangThaiActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
         monHoc.setTen_mon_hoc(txtTenMonHoc.getText());
        monHoc.setTin_chi(Integer.valueOf(txtTinChi.getText()));
        monHoc.setHoc_phi(Integer.valueOf(txtHocPhi.getText()));
        monHoc.setTrang_thai(ckbTrangThai.isSelected());
        if (monHoc.getId() > 0) {
            monHocDAO.update(monHoc);
        } else {
            monHocDAO.insert(monHoc);
        }
        loadData1();
    }//GEN-LAST:event_btnEditActionPerformed
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
                int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {
                delete1();
            } catch (Exception e) {
            }
            while (defaultTableModelMonHoc.getRowCount() > 0) {
                defaultTableModelMonHoc.removeRow(0);

            }
            loadData1();
    }   
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblMonHocMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonHocMouseReleased
        // TODO add your handling code here:
        txtTenMonHoc.setText(monHoc.getTen_mon_hoc());
        txtTinChi.setText(String.valueOf(monHoc.getTin_chi()));
        txtHocPhi.setText(String.valueOf(monHoc.getHoc_phi()));
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(true);
        btnEdit.setEnabled(true);
    }//GEN-LAST:event_tblMonHocMouseReleased

    private void tblKhoaHocMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoaHocMouseReleased
        // TODO add your handling code here:
        btnAdd2.setEnabled(false);
        btnEdit2.setEnabled(true);
        btnDelete2.setEnabled(true);
    }//GEN-LAST:event_tblKhoaHocMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cbx_Subject;
    private javax.swing.JPanel Panel_Add_Subject;
    private javax.swing.JPanel Panel_Edit_Subject;
    private javax.swing.JTextField SearchNameKH;
    private javax.swing.JTextField SearchNameMH;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit2;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset2;
    private javax.swing.JButton btnSearchKH;
    private javax.swing.JButton btnSearchMH;
    private javax.swing.JCheckBox ckbTrangThai;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblKhoaHoc;
    private javax.swing.JTable tblMonHoc;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtTenKhoaHoc;
    private javax.swing.JTextField txtTenMonHoc;
    private javax.swing.JTextField txtTinChi;
    // End of variables declaration//GEN-END:variables
}
