/*
 * classifier.java
 *
 * Created on 1 de Junio de 2006, 13:11
 */

import java.awt.*;
import java.awt.event.WindowEvent;
import javax.swing.border.LineBorder;

/**
 *
 * @author jespm
 */
public class Classifier extends javax.swing.JFrame {

    int acs, ageCat, bTransf, bil, ldhCat, mcv, pain, priapism, retic, sepsis, sex, stroke, sysBpCat, wbcCat, hemo, avn;
    int acs2, ageCat2, bTransf2, bil2, ldhCat2, mcv2, pain2, priapism2, retic2, sepsis2, sex2, stroke2, sysBpCat2, wbcCat2, hemo2, avn2;

    double[][] acsP
            = { // for each Retic
                {0.564, 0.476},
                {0.348, 0.652},
                {0.260, 0.740}
            };

    double[][] wbcCatP
            = { // for each Death
                {0.488, 0.294, 0.218},
                {0.373, 0.308, 0.318}
            };
    double[][] priapismP
            = { // for each AgeCat
                {0.476, 0.044, 0.480},
                {0.349, 0.112, 0.539},
                {0.296, 0.093, 0.611}
            };
    double[][] bilP
            = { // for each Retic
                {0.535, 0.348, 0.117},
                {0.163, 0.603, 0.234},
                {0.052, 0.513, 0.435}
            };
    double[][][] bTransfP
            = { // for each Sepsis
                { // for each Retic
                    {0.953, 0.047},
                    {0.904, 0.096},
                    {0.820, 0.180}
                },
                {
                    {0.850, 0.150},
                    {0.823, 0.177},
                    {0.714, 0.286}
                }
            };
    double[][][] reticP
            = {// for each Death
                { // for each WbcCat
                    {0.445, 0.439, 0.117},
                    {0.111, 0.573, 0.316},
                    {0.071, 0.520, 0.409}
                },
                {
                    {0.247, 0.552, 0.201},
                    {0.088, 0.501, 0.411},
                    {0.042, 0.441, 0.517}
                }
            };

    double[][][] ldhCatP
            = { // for each Retic
                { // for each Bil
                    {0.511, 0.427, 0.062},
                    {0.382, 0.519, 0.099},
                    {0.224, 0.582, 0.194}
                },
                {
                    {0.319, 0.570, 0.111},
                    {0.174, 0.582, 0.244},
                    {0.080, 0.490, 0.430}
                },
                {
                    {0.379, 0.448, 0.173},
                    {0.183, 0.584, 0.233},
                    {0.148, 0.471, 0.381}
                }
            };

    double[][][] sexP
            = { // for each Death
                { // for each priapism
                    {0.001, 0.999},
                    {0.006, 0.994},
                    {0.999, 0.001}
                },
                {
                    {0.013, 0.987},
                    {0.034, 0.966},
                    {0.991, 0.009}
                }
            };

    double[][][][] ageCatP
            = { // for each ldhCat
                { // for each Bil
                    { // for each Death
                        {0.451, 0.388, 0.161},
                        {0.242, 0.288, 0.470}
                    },
                    {
                        {0.414, 0.447, 0.139},
                        {0.278, 0.511, 0.211}
                    },
                    {
                        {0.484, 0.445, 0.072},
                        {0.333, 0.333, 0.333}
                    }
                },
                { // for each Bil
                    { // for each Death
                        {0.721, 0.196, 0.083},
                        {0.317, 0.417, 0.266}
                    },
                    {
                        {0.492, 0.410, 0.099},
                        {0.222, 0.498, 0.280}
                    },
                    {
                        {0.415, 0.510, 0.075},
                        {0.209, 0.525, 0.266}
                    }
                },
                { // for each Bil
                    { // for each Death
                        {0.908, 0.054, 0.038},
                        {0.220, 0.730, 0.050}
                    },
                    {
                        {0.675, 0.300, 0.025},
                        {0.207, 0.408, 0.385}
                    },
                    {
                        {0.487, 0.453, 0.060},
                        {0.183, 0.409, 0.409}
                    }
                }
            };

    double[][][][] painP
            = { // for each Avn
                { // for each Acs
                    { // for each AgeCat
                        {0.507, 0.493},
                        {0.128, 0.872},
                        {0.180, 0.820}
                    },
                    {
                        {0.191, 0.809},
                        {0.072, 0.928},
                        {0.052, 0.948}
                    }
                },
                { // for each Acs
                    { // for each AgeCat
                        {0.135, 0.865},
                        {0.074, 0.926},
                        {0.104, 0.896}
                    },
                    {
                        {0.071, 0.929},
                        {0.033, 0.967},
                        {0.038, 0.962}
                    }
                }
            };

    double[][][][] sepsisP
            = { // for each ageCat
                { // for each Acs
                    { // for each Death
                        {0.956, 0.044},
                        {0.154, 0.846}
                    },
                    {
                        {0.885, 0.115},
                        {0.128, 0.872}
                    }
                },
                { // for each Acs
                    { // for each Death
                        {0.983, 0.017},
                        {0.189, 0.811}
                    },
                    {
                        {0.946, 0.054},
                        {0.120, 0.880}
                    }
                },
                { // for each Acs
                    { // for each Death
                        {0.968, 0.032},
                        {0.200, 0.800}
                    },
                    {
                        {0.942, 0.058},
                        {0.273, 0.727}
                    }
                }
            };

    double[][][][] strokeP
            = { // for each Mcv
                { // for each Death
                    { // for each B.Transf
                        {0.993, 0.007},
                        {0.800, 0.200}
                    },
                    {
                        {0.954, 0.046},
                        {0.800, 0.200}
                    }
                },
                { // for each Death
                    { // for each B. Transf
                        {0.971, 0.029},
                        {0.702, 0.298}
                    },
                    {
                        {0.844, 0.156},
                        {0.788, 0.212}
                    }
                },
                { // for each Death
                    { // for each B. Transf
                        {0.949, 0.051},
                        {0.863, 0.137}
                    },
                    {
                        {0.777, 0.223},
                        {0.622, 0.378}
                    }
                }
            };
    double[][][][] sysBpCatP
            = { // for each Death
                { // for each Pain
                    { // for each AgeCat
                        {0.019, 0.862, 0.118, 0.001},
                        {0.004, 0.988, 0.004, 0.004},
                        {0.016, 0.860, 0.062, 0.062}
                    },
                    {
                        {0.008, 0.967, 0.022, 0.003},
                        {0.000, 0.998, 0.002, 0.000},
                        {0.001, 0.954, 0.036, 0.009}
                    }
                },
                { // for each Pain
                    { // for each AgeCat
                        {0.070, 0.610, 0.310, 0.010},
                        {0.036, 0.892, 0.036, 0.036},
                        {0.045, 0.592, 0.318, 0.045}
                    },
                    {
                        {0.040, 0.790, 0.130, 0.040},
                        {0.003, 0.967, 0.027, 0.003},
                        {0.004, 0.857, 0.099, 0.040}
                    }
                }
            };

    double[][][][] hemoP
            = { // for each wbcCat
                { // for each Bil
                    { // for each Retic
                        {0.872, 0.079, 0.049},
                        {0.475, 0.266, 0.259},
                        {0.139, 0.489, 0.372}
                    },
                    {
                        {0.769, 0.128, 0.103},
                        {0.162, 0.566, 0.272},
                        {0.012, 0.765, 0.223}
                    },
                    {
                        {0.522, 0.365, 0.113},
                        {0.051, 0.767, 0.182},
                        {0.002, 0.841, 0.157}
                    }
                },
                { // for each Bil
                    { // for each Retic
                        {0.790, 0.105, 0.105},
                        {0.136, 0.491, 0.373},
                        {0.011, 0.864, 0.125}
                    },
                    {
                        {0.446, 0.316, 0.238},
                        {0.039, 0.696, 0.265},
                        {0.001, 0.786, 0.213}
                    },
                    {
                        {0.350, 0.301, 0.350},
                        {0.001, 0.791, 0.208},
                        {0.001, 0.925, 0.074}
                    }
                },
                { // for each Bil
                    { // for each Retic
                        {0.580, 0.352, 0.068},
                        {0.097, 0.633, 0.270},
                        {0.011, 0.807, 0.162}
                    },
                    {
                        {0.409, 0.466, 0.125},
                        {0.009, 0.762, 0.229},
                        {0.001, 0.887, 0.112}
                    },
                    {
                        {0.253, 0.675, 0.072},
                        {0.013, 0.814, 0.173},
                        {0.002, 0.910, 0.088}
                    }
                }
            };
    double[][][][] mcvP
            = { // for each Retic
                { // for each AgeCat
                    { // for each Hemo
                        {0.684, 0.315, 0.001},
                        {0.250, 0.739, 0.011},
                        {0.569, 0.427, 0.004}
                    },
                    {
                        {0.268, 0.726, 0.006},
                        {0.194, 0.658, 0.148},
                        {0.472, 0.519, 0.009}
                    },
                    {
                        {0.289, 0.685, 0.026},
                        {0.023, 0.838, 0.139},
                        {0.030, 0.637, 0.333}
                    }
                },
                { // for each AgeCat
                    { // for each Hemo
                        {0.353, 0.645, 0.002},
                        {0.125, 0.856, 0.019},
                        {0.407, 0.592, 0.001}
                    },
                    {
                        {0.118, 0.850, 0.032},
                        {0.052, 0.733, 0.215},
                        {0.189, 0.793, 0.018}
                    },
                    {
                        {0.142, 0.716, 0.142},
                        {0.028, 0.624, 0.348},
                        {0.104, 0.842, 0.054}
                    }
                },
                { // for each AgeCat
                    { // for each Hemo
                        {0.752, 0.124, 0.124},
                        {0.062, 0.878, 0.060},
                        {0.227, 0.754, 0.019}
                    },
                    {
                        {0.124, 0.752, 0.124},
                        {0.017, 0.621, 0.362},
                        {0.067, 0.866, 0.067}
                    },
                    {
                        {0.333, 0.333, 0.333},
                        {0.017, 0.491, 0.491},
                        {0.019, 0.868, 0.113}
                    }
                }
            };

    double[][][][] avnP
            = { // for each Acs
                { // for each AgeCat
                    { // for each Retic
                        {0.939, 0.061},
                        {0.768, 0.232},
                        {0.668, 0.332}
                    },
                    {
                        {0.821, 0.179},
                        {0.723, 0.277},
                        {0.750, 0.250}
                    },
                    {
                        {0.584, 0.416},
                        {0.705, 0.295},
                        {0.769, 0.231}
                    }
                },
                { // for each AgeCat
                    { // for each Retic
                        {0.900, 0.100},
                        {0.679, 0.321},
                        {0.518, 0.482}
                    },
                    {
                        {0.765, 0.235},
                        {0.565, 0.435},
                        {0.537, 0.463}
                    },
                    {
                        {0.447, 0.553},
                        {0.565, 0.435},
                        {0.599, 0.401}
                    }
                }
            };

    /**
     * Initializes the applet classifier
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // }
        Classifier classi = new Classifier();
        // public void init() {
        try {
            // java.awt.EventQueue.invokeAndWait(new Runnable() {
            //     public void run() {
            classi.initComponents();
            classi.dispatchEvent(new WindowEvent(classi, WindowEvent.WINDOW_CLOSING));
            classi.setPreferredSize(new Dimension(700, 550));
            classi.bindingGroup.unbind();
            classi.pack();
            classi.setVisible(true);
            //      }
            //   });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private double computeRisk(int death) {
        double risk = 0;
        int acsMax = Acs.getItemCount() - 2,
                ageCatMax = AgeCat.getItemCount() - 2,
                bTransfMax = BTransf.getItemCount() - 2,
                bilMax = Bil.getItemCount() - 2,
                ldhCatMax = LdhCat.getItemCount() - 2,
                mcvMax = Mcv.getItemCount() - 2,
                painMax = Pain.getItemCount() - 2,
                priapismMax = Priapism.getItemCount() - 2,
                reticMax = Retic.getItemCount() - 2,
                sepsisMax = Sepsis.getItemCount() - 2,
                sexMax = Sex.getItemCount() - 1,
                strokeMax = Stroke.getItemCount() - 2,
                sysBpCatMax = SysBpCat.getItemCount() - 2,
                wbcCatMax = WbcCat.getItemCount() - 2,
                hemoMax = Hemo.getItemCount() - 2,
                avnMax = Avn.getItemCount() - 2;
        int acsMin = 0, ageCatMin = 0, bTransfMin = 0, bilMin = 0, ldhCatMin = 0, mcvMin = 0, painMin = 0, priapismMin = 0, reticMin = 0, sepsisMin = 0, sexMin = 0, strokeMin = 0, sysBpCatMin = 0, wbcCatMin = 0, hemoMin = 0, avnMin = 0;

        if (wbcCat != WbcCat.getItemCount() - 1) {
            wbcCatMax = wbcCat;
            wbcCatMin = wbcCat;
        }
        if (retic != Retic.getItemCount() - 1) {
            reticMax = retic;
            reticMin = retic;
        }
        if (ageCat != AgeCat.getItemCount() - 1) {
            ageCatMax = ageCat;
            ageCatMin = ageCat;
        }
     //   if (sex != Sex.getItemCount() - 1) {
            sexMax = sex;
            sexMin = sex;
     //   }
        if (sepsis != Sepsis.getItemCount() - 1) {
            sepsisMax = sepsis;
            sepsisMin = sepsis;
        }
        if (stroke != Stroke.getItemCount() - 1) {
            strokeMax = stroke;
            strokeMin = stroke;
        }
        if (sysBpCat != SysBpCat.getItemCount() - 1) {
            sysBpCatMax = sysBpCat;
            sysBpCatMin = sysBpCat;
        }
        if (bil != Bil.getItemCount() - 1) {
            bilMax = bil;
            bilMin = bil;
        }
        if (ldhCat != LdhCat.getItemCount() - 1) {
            ldhCatMax = ldhCat;
            ldhCatMin = ldhCat;
        }
        if (priapism != Priapism.getItemCount() - 1) {
            priapismMax = priapism;
            priapismMin = priapism;
        }
        if (pain != Pain.getItemCount() - 1) {
            painMax = pain;
            painMin = pain;
        } 
        
        if (acs != Acs.getItemCount() - 1) {
            acsMax = acs;
            acsMin = acs;
        }
        if (mcv != Mcv.getItemCount() - 1) {
            mcvMax = mcv;
            mcvMin = mcv;
        }
        if (bTransf != BTransf.getItemCount() - 1) {
            bTransfMax = bTransf;
            bTransfMin = bTransf;
        }
        if (hemo != Hemo.getItemCount() - 1) {
            hemoMax = hemo;
            hemoMin = hemo;
        }
        if (avn != Avn.getItemCount() - 1) {
            avnMax = avn;
            avnMin = avn;
        }

        for (wbcCat2 = wbcCatMin; wbcCat2 <= wbcCatMax; wbcCat2++) {
            for (retic2 = reticMin; retic2 <= reticMax; retic2++) {
                for (ageCat2 = ageCatMin; ageCat2 <= ageCatMax; ageCat2++) {
                    for (sex2 = sexMin; sex2 <= sexMax; sex2++) {
                        for (sepsis2 = sepsisMin; sepsis2 <= sepsisMax; sepsis2++) {
                            for (stroke2 = strokeMin; stroke2 <= strokeMax; stroke2++) {
                                for (sysBpCat2 = sysBpCatMin; sysBpCat2 <= sysBpCatMax; sysBpCat2++) {
                                    for (bil2 = bilMin; bil2 <= bilMax; bil2++) {
                                        for (ldhCat2 = ldhCatMin; ldhCat2 <= ldhCatMax; ldhCat2++) {
                                            for (priapism2 = priapismMin; priapism2 <= priapismMax; priapism2++) {
                                                for (pain2 = painMin; pain2 <= painMax; pain2++) {
                                                    for (acs2 = acsMin; acs2 <= acsMax; acs2++) {
                                                        for (mcv2 = mcvMin; mcv2 <= mcvMax; mcv2++) {
                                                            for (bTransf2 = bTransfMin; bTransf2 <= bTransfMax; bTransf2++) {
                                                                for (hemo2 = hemoMin; hemo2 <= hemoMax; hemo2++) {
                                                                    for (avn2 = avnMin; avn2 <= avnMax; avn2++) {
                                                                        risk = risk + ComputeKnownRisk(death);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return risk;
    }

    ;
     private double ComputeKnownRisk(int death) {
        double risk = 1;

        risk = risk * wbcCatP[death][wbcCat2];
        risk = risk * reticP[death][wbcCat2][retic2];
        risk = risk * bilP[retic2][bil2];
        risk = risk * hemoP[wbcCat2][bil2][retic2][hemo2];
        risk = risk * ldhCatP[retic2][bil2][ldhCat2];
        risk = risk * ageCatP[ldhCat2][bil2][death][ageCat2];
        risk = risk * priapismP[ageCat2][priapism2];
        risk = risk * sexP[death][priapism2][sex2];
        risk = risk * mcvP[retic2][ageCat2][hemo2][mcv2];
        risk = risk * acsP[retic2][acs2];
        risk = risk * avnP[acs2][ageCat2][retic2][avn2];
        risk = risk * painP[avn2][acs2][ageCat2][pain2];
        risk = risk * sepsisP[ageCat2][acs2][death][sepsis2];
        risk = risk * bTransfP[sepsis2][retic2][bTransf2];
        risk = risk * strokeP[mcv2][death][bTransf2][stroke2];
        risk = risk * sysBpCatP[death][pain2][ageCat2][sysBpCat2];
        return risk;
    }

    ;   
 
    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
      
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jOptionPane1 = new javax.swing.JOptionPane();
        panelNorte = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        panelCentral = new javax.swing.JPanel();
        ACS_label = new javax.swing.JLabel();
        Acs = new javax.swing.JComboBox();
        age_label = new javax.swing.JLabel();
        AgeCat = new javax.swing.JComboBox();
        bilirubin_label = new javax.swing.JLabel();
        Bil = new javax.swing.JComboBox();
        bloodTransfusion_label = new javax.swing.JLabel();
        BTransf = new javax.swing.JComboBox();
        LDH_label = new javax.swing.JLabel();
        LdhCat = new javax.swing.JComboBox();
        MCV_label = new javax.swing.JLabel();
        Mcv = new javax.swing.JComboBox();
        pain_label = new javax.swing.JLabel();
        Pain = new javax.swing.JComboBox();
        priapism_label = new javax.swing.JLabel();
        Priapism = new javax.swing.JComboBox();
        retic_label = new javax.swing.JLabel();
        Retic = new javax.swing.JComboBox();
        sepsis_label = new javax.swing.JLabel();
        Sepsis = new javax.swing.JComboBox();
        gender_label = new javax.swing.JLabel();
        Sex = new javax.swing.JComboBox();
        stroke_label = new javax.swing.JLabel();
        Stroke = new javax.swing.JComboBox();
        systolicBP_label = new javax.swing.JLabel();
        SysBpCat = new javax.swing.JComboBox();
        WBC_label = new javax.swing.JLabel();
        WbcCat = new javax.swing.JComboBox();
        hemoglobinGenotype_label = new javax.swing.JLabel();
        Hemo = new javax.swing.JComboBox();
        AVN_label = new javax.swing.JLabel();
        Avn = new javax.swing.JComboBox();
        panelSur = new javax.swing.JPanel();
        estimateRisk_button = new javax.swing.JButton();
        progress = new javax.swing.JLabel("Probability of death is: ", javax.swing.SwingConstants.RIGHT);
        resultLabel = new javax.swing.JLabel("----------", javax.swing.SwingConstants.CENTER);
	//resultLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        jOptionPane1.setName("Gender change"); // NOI18N

        panelNorte.setBackground(new java.awt.Color(204, 153, 255));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setLabelFor(this);
        titulo.setText("Sickle Cell Disease severity Calculator");
        titulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        titulo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        panelNorte.add(titulo);

        getContentPane().add(panelNorte, java.awt.BorderLayout.PAGE_START);

        panelCentral.setBackground(new java.awt.Color(204, 153, 255));
        panelCentral.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCentral.setAlignmentY(panelNorte.getAlignmentY());
        panelCentral.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        panelCentral.setEnabled(false);
        panelCentral.setFocusable(false);
        panelCentral.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        panelCentral.setMinimumSize(new java.awt.Dimension(500, 300));
        panelCentral.setPreferredSize(new java.awt.Dimension(500, 300));

     //   org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, titulo, org.jdesktop.beansbinding.ObjectProperty.create(), panelCentral, org.jdesktop.beansbinding.BeanProperty.create("alignmentY"));
     //   bindingGroup.addBinding(binding);

        panelCentral.setLayout(new java.awt.GridBagLayout());

        ACS_label.setText("ACS");
        ACS_label.setAlignmentX(5.0F);
        ACS_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(ACS_label, gridBagConstraints);
        ACS_label.getAccessibleContext().setAccessibleName("relleno");
        ACS_label.getAccessibleContext().setAccessibleDescription("Acs");

        Acs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "no", "yes", "non available" }));
        Acs.setMaximumSize(new java.awt.Dimension(125, 25));
        Acs.setMinimumSize(new java.awt.Dimension(111, 25));
        Acs.setPreferredSize(new java.awt.Dimension(111, 25));

    //    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, SysBpCat, org.jdesktop.beansbinding.ObjectProperty.create(), Acs, org.jdesktop.beansbinding.BeanProperty.create("alignmentX"));
    //    bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(Acs, gridBagConstraints);

        age_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        age_label.setText("Age");
        age_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(age_label, gridBagConstraints);

        AgeCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "below 18", "18 - 40", "above 40", "non available" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(AgeCat, gridBagConstraints);

        bilirubin_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bilirubin_label.setText("Bilirubin");
        bilirubin_label.setAlignmentX(0.5F);
        bilirubin_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bilirubin_label.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(bilirubin_label, gridBagConstraints);

        Bil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "below 1.3", "1.3 - 3.4", "> 3.4", "non available" }));
        Bil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BilActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(Bil, gridBagConstraints);

        bloodTransfusion_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bloodTransfusion_label.setText("Blood Transfusion");
        bloodTransfusion_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bloodTransfusion_label.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        panelCentral.add(bloodTransfusion_label, gridBagConstraints);

        BTransf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "no", "yes", "non available" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(BTransf, gridBagConstraints);

        LDH_label.setText("LDH");
        LDH_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(LDH_label, gridBagConstraints);

        LdhCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "below 300", "300 - 600", "> 600", "non available" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(LdhCat, gridBagConstraints);

        MCV_label.setText("MCV");
        MCV_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(MCV_label, gridBagConstraints);

        Mcv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "below 80", "80 - 98", "above 98", "non available" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(Mcv, gridBagConstraints);

        pain_label.setText("Pain");
        pain_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(pain_label, gridBagConstraints);

        Pain.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "no", "yes", "non available" }));
        Pain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PainActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(Pain, gridBagConstraints);

        priapism_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        priapism_label.setText("Priapism");
        priapism_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(priapism_label, gridBagConstraints);

        Priapism.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "no (male)", "yes (male)", "non applicable (female)", "non available" }));
        Priapism.setAlignmentX(5.0F);
        Priapism.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriapismActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(Priapism, gridBagConstraints);

        retic_label.setText("Retic");
        retic_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(retic_label, gridBagConstraints);

        Retic.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "below 4.8", "4.8 - 13", "above 13", "non available" }));
        Retic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReticActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(Retic, gridBagConstraints);

        sepsis_label.setText("Sepsis");
        sepsis_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(sepsis_label, gridBagConstraints);

        Sepsis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "no", "yes", "non available" }));
        Sepsis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SepsisActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(Sepsis, gridBagConstraints);

        gender_label.setText("Gender");
        gender_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(gender_label, gridBagConstraints);

        Sex.setMaximumRowCount(2);
        Sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "male", "female", "non available" }));
        Sex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SexActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(Sex, gridBagConstraints);

        stroke_label.setText("Stroke");
        stroke_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(stroke_label, gridBagConstraints);

        Stroke.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "no", "yes", "non available" }));
        Stroke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StrokeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(Stroke, gridBagConstraints);

        systolicBP_label.setText("Systolic BP");
        systolicBP_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(systolicBP_label, gridBagConstraints);

        SysBpCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "below 80", "80 - 120 (for age <= 18), 80-140 (for age above 18)", "120 - 140 (for age <= 18), 140 - 160 (for age above 18)", "above 140 (for age <= 18), above 160 (for age above 18)", "non available" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(SysBpCat, gridBagConstraints);

        WBC_label.setText("WBC");
        WBC_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(WBC_label, gridBagConstraints);

        WbcCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "below 10.8", "10.8 - 13.5", "above 13.5", "non available" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(WbcCat, gridBagConstraints);

        hemoglobinGenotype_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hemoglobinGenotype_label.setText("Hemoglobin genotype");
        hemoglobinGenotype_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        panelCentral.add(hemoglobinGenotype_label, gridBagConstraints);

        Hemo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SC", "SS*", "SS+alpha-Thal", "non available" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(Hemo, gridBagConstraints);

        AVN_label.setText("AVN");
        AVN_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(AVN_label, gridBagConstraints);

        Avn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "no", "yes", "non available" }));
        Avn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCentral.add(Avn, gridBagConstraints);

        getContentPane().add(panelCentral, java.awt.BorderLayout.CENTER);

        panelSur.setBackground(new java.awt.Color(204, 153, 255));
        panelSur.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 20, 20));

       // binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, Avn, org.jdesktop.beansbinding.ObjectProperty.create(), panelSur, org.jdesktop.beansbinding.BeanProperty.create("alignmentY"));
      //  bindingGroup.addBinding(binding);

        panelSur.setLayout(new java.awt.FlowLayout());

        estimateRisk_button.setBackground(new java.awt.Color(204, 204, 255));
        estimateRisk_button.setText("<html>Estimate<p>Death Risk</html>");
        estimateRisk_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        estimateRisk_button.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        estimateRisk_button.setMaximumSize(new java.awt.Dimension(200, 50));
        estimateRisk_button.setMinimumSize(new java.awt.Dimension(200, 50));
        estimateRisk_button.setPreferredSize(new java.awt.Dimension(200, 50));

  resultLabel.setBorder(new LineBorder(Color.gray, 4, true));
   resultLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        resultLabel.setMinimumSize(new java.awt.Dimension(100, 50));
        resultLabel.setPreferredSize(new java.awt.Dimension(100, 50));

   progress.setMaximumSize(new java.awt.Dimension(300, 50));
        progress.setMinimumSize(new java.awt.Dimension(300, 50));
        progress.setPreferredSize(new java.awt.Dimension(300, 50));



resultLabel.setForeground(Color.black);
resultLabel.setOpaque(true);
resultLabel.setBackground(new java.awt.Color(204, 204, 255));

    panelSur.add(estimateRisk_button);
panelSur.add(progress);
        panelSur.add(resultLabel);


        estimateRisk_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computeDeathRisk(evt);
            }
        });
    

      //  binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelCentral, org.jdesktop.beansbinding.ELProperty.create(""), progress, org.jdesktop.beansbinding.BeanProperty.create("horizontalAlignment"));
    //    bindingGroup.addBinding(binding);

        

        getContentPane().add(panelSur, java.awt.BorderLayout.PAGE_END);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void AvnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvnActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_AvnActionPerformed

    private void PriapismActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriapismActionPerformed
        if (Priapism.getSelectedIndex() == 2 && Sex.getSelectedIndex() == 0) {
jOptionPane1.showMessageDialog(null, "Priapism option not allowed for males. Changed to default value (no). Please, change gender if needed.");
            Priapism.setSelectedIndex(0);
        } else if (Priapism.getSelectedIndex() <= 1 && Sex.getSelectedIndex() == 1) {
jOptionPane1.showMessageDialog(null, "Priapism option not allowed for females. Changed to non appicable. Please, change gender if needed.");
            Priapism.setSelectedIndex(2);
        }
    }//GEN-LAST:event_PriapismActionPerformed

    private void BilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BilActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_BilActionPerformed

    private void StrokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StrokeActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_StrokeActionPerformed

    private void SexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SexActionPerformed
        if (Priapism.getSelectedIndex() == 2 && Sex.getSelectedIndex() == 0) {
            Priapism.setSelectedIndex(0);
            jOptionPane1.showMessageDialog(null, "Priapism has been set to \"no\". Please, change the value if needed.");
        } else if (Priapism.getSelectedIndex() <= 1 && Sex.getSelectedIndex() == 1) {
            Priapism.setSelectedIndex(2);
jOptionPane1.showMessageDialog(null, "Priapism has been set to \"non applicable (female)\". Please, change the value if needed.");
        }
    }//GEN-LAST:event_SexActionPerformed

    private void SepsisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SepsisActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_SepsisActionPerformed

    private void ReticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReticActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_ReticActionPerformed

    private void computeDeathRisk(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computeDeathRisk
        double riskDeath = 1, riskSurvive = 1;
        int S;
        String sP = new String("Computing probabilities: ");
        progress.setText(sP);
        // resultLabel.setForeground(Color.black);

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        progress.setText(sP);
        acs = Acs.getSelectedIndex();
        ageCat = AgeCat.getSelectedIndex();
        bTransf = BTransf.getSelectedIndex();
        bil = Bil.getSelectedIndex();
        ldhCat = LdhCat.getSelectedIndex();
        mcv = Mcv.getSelectedIndex();
        pain = Pain.getSelectedIndex();
        priapism = Priapism.getSelectedIndex();
        retic = Retic.getSelectedIndex();
        sepsis = Sepsis.getSelectedIndex();
        sex = Sex.getSelectedIndex();
        S = sex;
        if (S == 0) {
            sex = 1;
        }
        if (S == 1) {
            sex = 0;
        }
        stroke = Stroke.getSelectedIndex();
        sysBpCat = SysBpCat.getSelectedIndex();
        wbcCat = WbcCat.getSelectedIndex();
        hemo = Hemo.getSelectedIndex();
        avn = Avn.getSelectedIndex();
        bTransf = BTransf.getSelectedIndex();
        riskDeath = computeRisk(1);
        riskSurvive = computeRisk(0);
        riskDeath = riskDeath / (riskDeath + riskSurvive);
        progress.setText("");

        setCursor(Cursor.getDefaultCursor());

        String s1 = Double.toString(riskDeath);

        s1 = s1.substring(0, s1.indexOf('.') + 6);

        String s = new String("Probability of death is: ");
        progress.setText(s);
        //String s=new String(" Probability of death is: "+riskDeath+" ");

        //   s=s.substring(0, s.indexOf('.')+4);
        resultLabel.setForeground(Color.black);
        // resultLabel.setBackground(new java.awt.Color(204, 204, 255));
//resultLabel.setBackground(new java.awt.Color(200, 200, 200));
        //resultLabel.setBackground(Color.green);
        resultLabel.setText("  " + s1);


    }//GEN-LAST:event_computeDeathRisk

    private void PainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PainActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PainActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ACS_label;
    private javax.swing.JLabel AVN_label;
    private javax.swing.JComboBox Acs;
    private javax.swing.JComboBox AgeCat;
    private javax.swing.JComboBox Avn;
    private javax.swing.JComboBox BTransf;
    private javax.swing.JComboBox Bil;
    private javax.swing.JComboBox Hemo;
    private javax.swing.JLabel LDH_label;
    private javax.swing.JComboBox LdhCat;
    private javax.swing.JLabel MCV_label;
    private javax.swing.JComboBox Mcv;
    private javax.swing.JComboBox Pain;
    private javax.swing.JComboBox Priapism;
    private javax.swing.JComboBox Retic;
    private javax.swing.JComboBox Sepsis;
    private javax.swing.JComboBox Sex;
    private javax.swing.JComboBox Stroke;
    private javax.swing.JComboBox SysBpCat;
    private javax.swing.JLabel WBC_label;
    private javax.swing.JComboBox WbcCat;
    private javax.swing.JLabel age_label;
    private javax.swing.JLabel bilirubin_label;
    private javax.swing.JLabel bloodTransfusion_label;
    private javax.swing.JButton estimateRisk_button;
    private javax.swing.JLabel gender_label;
    private javax.swing.JLabel hemoglobinGenotype_label;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JLabel pain_label;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelSur;
    private javax.swing.JLabel priapism_label;
    private javax.swing.JLabel progress;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JLabel retic_label;
    private javax.swing.JLabel sepsis_label;
    private javax.swing.JLabel stroke_label;
    private javax.swing.JLabel systolicBP_label;
    private javax.swing.JLabel titulo;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    /**
     *
     */
}
