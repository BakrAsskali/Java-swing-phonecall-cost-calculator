import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * TPSwing
 */
public class TPSwing {
    JFrame frame;
    JTable table;
    int x, y, z;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TPSwing window = new TPSwing();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TPSwing() {
        SwingGUI();
    }

    private void SwingGUI() {
        /*
         * <------------------------------------------------------Frame
         * construction------------------------------------------>
         */
        frame = new JFrame();
        frame.setTitle("Telephone");
        frame.setBounds(100, 100, 900, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        /*
         * <-------------------------------------------------------Left panel
         * construction------------------------------------->
         */
        JPanel param = new JPanel();
        param.setBounds(0, 0, 450, 261);
        param.setBackground(Color.cyan);
        param.setPreferredSize(new Dimension(400, 190));
        frame.getContentPane().add(param);
        param.setLayout(null);

        JLabel pU = new JLabel("PU :");
        pU.setBounds(10, 10, 100, 20);
        param.add(pU);

        Object[] dataObject = { "1.25", "1.30", "2.0" };
        JComboBox<Object> comboBox_pu = new JComboBox<Object>(dataObject);
        comboBox_pu.setBounds(100, 10, 100, 20);
        param.add(comboBox_pu);

        JLabel duree = new JLabel("Durée :");
        duree.setBounds(10, 40, 100, 20);
        param.add(duree);

        JTextField heure = new JTextField("0");
        heure.setEditable(false);
        heure.setBounds(100, 40, 100, 20);
        heure.setHorizontalAlignment(SwingConstants.CENTER);
        param.add(heure);

        JTextField minute = new JTextField("0");
        minute.setEditable(false);
        minute.setBounds(200, 40, 100, 20);
        minute.setHorizontalAlignment(SwingConstants.CENTER);
        param.add(minute);

        JTextField seconde = new JTextField("0");
        seconde.setEditable(false);
        seconde.setBounds(300, 40, 100, 20);
        seconde.setHorizontalAlignment(SwingConstants.CENTER);
        param.add(seconde);

        JLabel reduction = new JLabel("Réduction :");
        reduction.setBounds(10, 70, 100, 20);
        param.add(reduction);

        JRadioButton urbain = new JRadioButton("Urbain");
        urbain.setSelected(true);
        urbain.setBounds(100, 70, 100, 20);
        JRadioButton interurbain = new JRadioButton("Interurbain");
        interurbain.setBounds(200, 70, 100, 20);
        JRadioButton international = new JRadioButton("International");
        international.setBounds(300, 70, 100, 20);

        ButtonGroup zone = new ButtonGroup();
        JPanel zonePanel = new JPanel(new GridLayout(3, 1));
        zonePanel.setBounds(100, 70, 300, 60);
        zonePanel.setBorder(
                new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Zone",
                        TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
        zone.add(urbain);
        zone.add(interurbain);
        zone.add(international);
        zonePanel.add(urbain);
        zonePanel.add(interurbain);
        zonePanel.add(international);
        param.add(zonePanel);

        JRadioButton nonFerie = new JRadioButton("Non Férié");
        nonFerie.setSelected(true);
        nonFerie.setBounds(100, 130, 100, 20);
        JRadioButton ferie = new JRadioButton("Férié");
        ferie.setBounds(200, 130, 100, 20);

        ButtonGroup red = new ButtonGroup();
        JPanel redPanel = new JPanel(new GridLayout(2, 1));
        redPanel.setBorder(new TitledBorder(null, "red", TitledBorder.LEFT, TitledBorder.TOP, null, null));
        redPanel.setBounds(100, 130, 300, 60);
        red.add(nonFerie);
        red.add(ferie);
        redPanel.add(nonFerie);
        redPanel.add(ferie);
        param.add(redPanel);

        JLabel cout = new JLabel("Coût :");
        cout.setBounds(10, 160, 100, 20);
        param.add(cout);

        JTextField coutTotal = new JTextField("0");
        coutTotal.setEditable(false);
        coutTotal.setBounds(100, 160, 300, 20);
        coutTotal.setHorizontalAlignment(SwingConstants.CENTER);
        param.add(coutTotal);

        JButton accro = new JButton("Accrocher");
        accro.setBounds(10, 190, 100, 20);
        param.add(accro);

        JButton decro = new JButton("Raccrocher");
        decro.setBounds(120, 190, 100, 20);
        param.add(decro);

        /*
         * <-------------------------------------------------------Right panel
         * construction------------------------------------->
         */
        JPanel liste = new JPanel();
        liste.setBounds(450, 0, 434, 261);
        liste.setPreferredSize(new Dimension(400, 190));
        frame.getContentPane().add(liste);
        liste.setLayout(null);

        JLabel listetab = new JLabel("Liste");
        listetab.setBounds(10, 10, 100, 20);
        liste.add(listetab);

        JTextField couTextField = new JTextField("0.0");
        couTextField.setEditable(false);
        couTextField.setBounds(100, 160, 100, 20);
        couTextField.setHorizontalAlignment(SwingConstants.CENTER);
        liste.add(couTextField);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 414, 210);
        liste.add(scrollPane);

        String[] nomsColonnes = { "Date", "Coût" };
        Object[][] dataTable = { { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } };
        JTable jTable1 = new JTable(new DefaultTableModel(nomsColonnes, 0));
        scrollPane.setViewportView(jTable1);

        /*
         * <-------------------------------------------------------Quit button
         * construction------------------------------------->
         */
        JButton quitter = new JButton("Quitter");
        quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        quitter.setBounds(10, 230, 100, 20);
        param.add(quitter);

        /*
         * <------------------------------------------------ Action Listeners
         * ----------------------------->
         */
        int delay = 1000;
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                seconde.setText(Integer.toString(x));
                x++;
                if (x == 60) {
                    x = 0;
                    minute.setText(Integer.toString(y));
                    seconde.setText(Integer.toString(x = 0));
                    x++;
                    y++;
                    if (y == 60) {
                        y = 0;
                        heure.setText(Integer.toString(z));
                        minute.setText(Integer.toString(y = 0));
                        y++;
                        z++;
                    }
                }
            }
        };
        Timer timer = new Timer(delay, taskPerformer);

        /*
         * <-----------------------------------------------Combobox item
         * listener--------------------------------->
         */
        comboBox_pu.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String value = e.getItem().toString();
                if (value.equals("1.25")) {
                    urbain.setSelected(true);
                    ;
                } else if (value.equals("1.5")) {
                    interurbain.setSelected(true);
                } else if (value.equals("2")) {
                    international.setSelected(true);
                }
            };
        });

        /*
         * <-----------------------------------------------Radio button item
         * listener--------------------------------->
         */
        urbain.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    comboBox_pu.setSelectedItem("1.25");
                }
            }
        });
        interurbain.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    comboBox_pu.setSelectedItem("1.5");
                }
            }
        });
        international.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    comboBox_pu.setSelectedItem("2");
                }
            }
        });

        /*
         * <-----------------------------------------------Start call action
         * listener--------------------------------->
         */
        accro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                heure.setText("0");
                minute.setText("0");
                seconde.setText("0");
                timer.start();
                x = 0;
                y = 0;
                z = 0;
            }
        });

        /*
         * <-----------------------------------------------End call action
         * listener--------------------------------->
         */
        decro.addActionListener(new ActionListener() {
            double h = 0;
            double m = 0;
            double s = 0;

            public void actionPerformed(ActionEvent e) {
                timer.stop();
                if (heure.getText().equals(""))
                    h = 0;
                else
                    h = Double.parseDouble(heure.getText());
                if (minute.getText().equals(""))
                    m = 0;
                else
                    m = Double.parseDouble(minute.getText());
                if (seconde.getText().equals(""))
                    s = 0;
                else
                    s = Double.parseDouble(seconde.getText());
                double time = h * 60 + m + s / 60;

                double pu = Double.valueOf(comboBox_pu.getSelectedItem().toString());
                double cout = pu * time;
                DecimalFormat df = new DecimalFormat("#.##");
                cout = Double.valueOf(df.format(cout));

                if (nonFerie.isSelected())
                    coutTotal.setText(Double.toString(cout));
                else
                    coutTotal.setText(Double.toString(cout * 1.5));

                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                String callCost = coutTotal.getText();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(new Object[] { dateFormat.format(date), callCost });

                double sm = 0;
                for (int i = 0; i < model.getRowCount(); i++) {
                    String cost = jTable1.getValueAt(i, 1).toString();
                    sm += Double.parseDouble(cost);
                    couTextField.setText(Double.toString(sm));
                }

            }
        });
    }
}