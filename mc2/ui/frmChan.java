package mc2.ui;
import java.awt.Rectangle;
import mc2.*;

public class frmChan extends javax.swing.JFrame {
    
    /** Creates new form frmMain */
    public frmChan() {
        initComponents();
        msgArea.setEditable(false);
        setSize(500,400);
        this.requestFocus();
    }
    
    public void dispose(){
        Manager.GetInstance().Quit();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        nickPopup = new javax.swing.JPopupMenu();
        ppStartConv = new javax.swing.JMenuItem();
        ppShowShare = new javax.swing.JMenuItem();
        panSplit = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        nickList = new javax.swing.JList();
        panRight = new javax.swing.JPanel();
        TextScroller = new javax.swing.JScrollPane();
        msgArea = new javax.swing.JTextArea();
        typeBox = new javax.swing.JTextField();
        toolbar = new javax.swing.JToolBar();
        btShare = new javax.swing.JToggleButton();
        tbSendFile = new javax.swing.JButton();
        btRecvFiles = new javax.swing.JButton();
        btClear = new javax.swing.JButton();

        nickPopup.setInvoker(nickList);
        ppStartConv.setText("Private Conversation");
        ppStartConv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppStartConvActionPerformed(evt);
            }
        });

        nickPopup.add(ppStartConv);

        ppShowShare.setText("Show Share");
        ppShowShare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppShowShareActionPerformed(evt);
            }
        });

        nickPopup.add(ppShowShare);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Channel view");
        setName("frmMain");
        panSplit.setDividerLocation(100);
        panSplit.setPreferredSize(new java.awt.Dimension(200, 25));
        nickList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nickListMouseReleased(evt);
            }
        });

        jScrollPane1.setViewportView(nickList);

        panSplit.setLeftComponent(jScrollPane1);

        panRight.setLayout(new java.awt.BorderLayout());

        TextScroller.setAutoscrolls(true);
        msgArea.setBackground(new java.awt.Color(229, 229, 249));
        msgArea.setColumns(20);
        msgArea.setRows(5);
        msgArea.setEditable(false);
        TextScroller.setViewportView(msgArea);

        panRight.add(TextScroller, java.awt.BorderLayout.CENTER);

        typeBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                typeBoxKeyPressed(evt);
            }
        });

        panRight.add(typeBox, java.awt.BorderLayout.SOUTH);

        panSplit.setRightComponent(panRight);

        getContentPane().add(panSplit, java.awt.BorderLayout.CENTER);

        btShare.setText("Directory Sharing");
        btShare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btShareActionPerformed(evt);
            }
        });

        toolbar.add(btShare);

        tbSendFile.setText("Send File");
        tbSendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbSendFileActionPerformed(evt);
            }
        });

        toolbar.add(tbSendFile);

        btRecvFiles.setText("Received Files");
        btRecvFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRecvFilesActionPerformed(evt);
            }
        });

        toolbar.add(btRecvFiles);

        btClear.setText("Clear buffer");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        toolbar.add(btClear);

        getContentPane().add(toolbar, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        msgArea.setText("");
    }//GEN-LAST:event_btClearActionPerformed

    private void ppShowShareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppShowShareActionPerformed
        if(nickList.getSelectedValue()!=null && nickList.getSelectedValue() instanceof User)
                   frmUserShare.ForUser((User)(nickList.getSelectedValue())).Show();
        
    }//GEN-LAST:event_ppShowShareActionPerformed

    private void btShareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btShareActionPerformed
        Manager.GetInstance().SetMyShare(btShare.isSelected());
        
    }//GEN-LAST:event_btShareActionPerformed

    private void tbSendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbSendFileActionPerformed
        Manager.GetInstance().SendFileToAll();
    }//GEN-LAST:event_tbSendFileActionPerformed

    private void btRecvFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRecvFilesActionPerformed
        Manager.GetInstance().ShowRecvFiles();
    }//GEN-LAST:event_btRecvFilesActionPerformed

    private void nickListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nickListMouseReleased
        if(evt.getButton()!=evt.BUTTON1)
            nickPopup.show(nickList,evt.getX(),evt.getY());
        
    }//GEN-LAST:event_nickListMouseReleased

    private void ppStartConvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppStartConvActionPerformed
       if(nickList.getSelectedValue()!=null && nickList.getSelectedValue() instanceof User)
           Manager.GetInstance().StartPrivateConversation((User)(nickList.getSelectedValue()));

    }//GEN-LAST:event_ppStartConvActionPerformed

    private void typeBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_typeBoxKeyPressed
        if(evt.getKeyChar()=='\n')
            SendMsg();
    }//GEN-LAST:event_typeBoxKeyPressed
    
   
    
    public void UpdateNickList(User[] iUsers){
        if(nickList.getModel()==null || !(nickList.getModel() instanceof NickListModel))
            nickList.setModel(new NickListModel(iUsers));
        ((NickListModel)nickList.getModel()).Update(iUsers);
        
    }
    
    public void SendMsg(){
        Manager.GetInstance().SendChanMessage(typeBox.getText()); 
        typeBox.setText("");
    }
    
    public void AddRecvLine(String iMsg){
        msgArea.setText(msgArea.getText()+iMsg+"\n");
        msgArea.scrollRectToVisible(new Rectangle(0,msgArea.getHeight()-20,1,1));
    }
    public void ClearRecvArea(){
        msgArea.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane TextScroller;
    private javax.swing.JButton btClear;
    private javax.swing.JButton btRecvFiles;
    private javax.swing.JToggleButton btShare;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea msgArea;
    private javax.swing.JList nickList;
    private javax.swing.JPopupMenu nickPopup;
    private javax.swing.JPanel panRight;
    private javax.swing.JSplitPane panSplit;
    private javax.swing.JMenuItem ppShowShare;
    private javax.swing.JMenuItem ppStartConv;
    private javax.swing.JButton tbSendFile;
    private javax.swing.JToolBar toolbar;
    private javax.swing.JTextField typeBox;
    // End of variables declaration//GEN-END:variables
    
}

class NickListModel extends javax.swing.AbstractListModel{
    User[] _nicklist;
    public NickListModel(User[] iList){
        _nicklist=iList;
    }
    public int getSize() { return _nicklist.length; }
    public Object getElementAt(int i) { return _nicklist[i]; }
    public void Update(User[] iList){
        fireIntervalRemoved(this,0,getSize());
        _nicklist=iList;
        fireIntervalAdded(this, 0,getSize()); 
    }
}