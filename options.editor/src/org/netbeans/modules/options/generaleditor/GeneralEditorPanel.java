/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.options.generaleditor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import org.netbeans.api.options.OptionsDisplayer;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.awt.Mnemonics;
import org.openide.util.NbBundle;

/**
 * Implementation of one panel in Options Dialog.
 *
 * @author Jan Jancura
 */
@OptionsPanelController.Keywords(keywords={"#KW_General_Editor"}, location=OptionsDisplayer.EDITOR, tabTitle= "org.netbeans.modules.options.editor.Bundle#CTL_General_DisplayName")
@NbBundle.Messages({"KW_General_Editor=general editor"})
public class GeneralEditorPanel extends JPanel implements ActionListener {

    private boolean         changed = false;
    private boolean         listen = false;
    
    /** 
     * Creates new form GeneralEditorPanel.
     */
    public GeneralEditorPanel () {
        initComponents ();

        loc (lCamelCaseBehavior, "Camel_Case_Behavior");
        loc (cbCamelCaseBehavior, "Enable_Camel_Case_In_Java");
        loc (lCamelCaseBehaviorExample, "Camel_Case_Behavior_Example");

        loc (lSearch, "Search");
        loc (lEditorSearchType, "Editor_Search_Type");
        loc (cboEditorSearchType, "Editor_Search_Type");
        
        loc (cbBraceTooltip, "Brace_First_Tooltip");
        loc (cbShowBraceOutline, "Brace_Show_Outline");
                
        cboEditorSearchType.setRenderer(new EditorSearchTypeRenderer(cboEditorSearchType.getRenderer()));
        cboEditorSearchType.setModel(new DefaultComboBoxModel<String>(new String [] { "default", "closing"})); //NOI18N
        cboEditorSearchType.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (cboEditorSearchType.getSelectedItem().equals("default"))
                    Mnemonics.setLocalizedText(lSearchtypeTooltip,  NbBundle.getMessage (GeneralEditorPanel.class, "Editor_Search_Type_Tooltip_default"));
                else
                    Mnemonics.setLocalizedText(lSearchtypeTooltip,  NbBundle.getMessage (GeneralEditorPanel.class, "Editor_Search_Type_Tooltip_closing"));
            }
        });
        Mnemonics.setLocalizedText(lSearchtypeTooltip,  NbBundle.getMessage (GeneralEditorPanel.class, "Editor_Search_Type_Tooltip_closing"));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lBracesMatching = new javax.swing.JLabel();
        cbShowBraceOutline = new javax.swing.JCheckBox();
        cbBraceTooltip = new javax.swing.JCheckBox();
        jSeparator6 = new javax.swing.JSeparator();
        lCamelCaseBehavior = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        cbCamelCaseBehavior = new javax.swing.JCheckBox();
        lCamelCaseBehaviorExample = new javax.swing.JLabel();
        lEditorSearchType = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        lSearch = new javax.swing.JLabel();
        cboEditorSearchType = new javax.swing.JComboBox<String>();
        lSearchtypeTooltip = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setForeground(new java.awt.Color(99, 130, 191));
        setLayout(new java.awt.GridBagLayout());

        lBracesMatching.setText(org.openide.util.NbBundle.getMessage(GeneralEditorPanel.class, "BRACES_MATCHING")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(lBracesMatching, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(cbShowBraceOutline, "Sho&w outline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 0, 0);
        add(cbShowBraceOutline, gridBagConstraints);
        cbShowBraceOutline.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(GeneralEditorPanel.class, "AN_Brace_Show_Outline")); // NOI18N
        cbShowBraceOutline.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(GeneralEditorPanel.class, "AD_Brace_Show_Outline")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cbBraceTooltip, "Show toolti&ps for invisible lines");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 15, 18, 0);
        add(cbBraceTooltip, gridBagConstraints);
        cbBraceTooltip.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(GeneralEditorPanel.class, "AN_Brace_First_Tooltip")); // NOI18N
        cbBraceTooltip.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(GeneralEditorPanel.class, "AD_Brace_First_Tooltip")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        add(jSeparator6, gridBagConstraints);

        lCamelCaseBehavior.setText("Camel Case  Behavior");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(lCamelCaseBehavior, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        add(jSeparator3, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(cbCamelCaseBehavior, "&Enable Camel Case Navigation");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 0, 0);
        add(cbCamelCaseBehavior, gridBagConstraints);
        cbCamelCaseBehavior.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(GeneralEditorPanel.class, "AN_Camel_Case_Navigation")); // NOI18N
        cbCamelCaseBehavior.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(GeneralEditorPanel.class, "AD_Camel_Case_Navigation")); // NOI18N

        lCamelCaseBehaviorExample.setText("<html>Example: Caret stops at J, T, N in \"JavaTypeName\"<br>when using next/previous word acctions</html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 36, 18, 0);
        add(lCamelCaseBehaviorExample, gridBagConstraints);

        lEditorSearchType.setLabelFor(cboEditorSearchType);
        org.openide.awt.Mnemonics.setLocalizedText(lEditorSearchType, "Editor &Search Type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 0, 5);
        add(lEditorSearchType, gridBagConstraints);
        lEditorSearchType.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(GeneralEditorPanel.class, "AN_Editor_Search_Type")); // NOI18N
        lEditorSearchType.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(GeneralEditorPanel.class, "AD_Editor_Search_Type")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        add(jSeparator5, gridBagConstraints);

        lSearch.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(lSearch, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(3, 1, 0, 0);
        add(cboEditorSearchType, gridBagConstraints);

        lSearchtypeTooltip.setText("<html>In Closing type Enter accepts search match, Esc jumps to start. Both close searchbar. <br /> Default type closes searchbar by Esc or button. Enter means find a new instance.</html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(6, 1, 12, 0);
        add(lSearchtypeTooltip, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        add(filler1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbBraceTooltip;
    private javax.swing.JCheckBox cbCamelCaseBehavior;
    private javax.swing.JCheckBox cbShowBraceOutline;
    private javax.swing.JComboBox<String> cboEditorSearchType;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lBracesMatching;
    private javax.swing.JLabel lCamelCaseBehavior;
    private javax.swing.JLabel lCamelCaseBehaviorExample;
    private javax.swing.JLabel lEditorSearchType;
    private javax.swing.JLabel lSearch;
    private javax.swing.JLabel lSearchtypeTooltip;
    // End of variables declaration//GEN-END:variables
    
    
    private static String loc (String key) {
        return NbBundle.getMessage (GeneralEditorPanel.class, key);
    }
    
    private static void loc (Component c, String key) {
        if (!(c instanceof JLabel)) {
            c.getAccessibleContext ().setAccessibleName (loc ("AN_" + key));
            c.getAccessibleContext ().setAccessibleDescription (loc ("AD_" + key));
        }
        if (c instanceof AbstractButton) {
            Mnemonics.setLocalizedText (
                (AbstractButton) c, 
                loc ("CTL_" + key)
            );
        } else if (c instanceof JLabel) {
            Mnemonics.setLocalizedText (
                (JLabel) c, 
                loc ("CTL_" + key)
            );
        }
    }
    
    private Model model;
    
    void update () {
        listen = false;
        if (model == null) {
            model = new Model ();
            cbCamelCaseBehavior.addActionListener (this);
            cboEditorSearchType.addActionListener(this);
            cbBraceTooltip.addActionListener(this);
            cbShowBraceOutline.addActionListener(this);
        }
        
        // Java Camel Case Navigation
        Boolean ccJava = model.isCamelCaseJavaNavigation();
        if ( ccJava == null ) {
            cbCamelCaseBehavior.setEnabled(false);
            cbCamelCaseBehavior.setSelected(false);            
        }
        else {
            cbCamelCaseBehavior.setEnabled(true);
            cbCamelCaseBehavior.setSelected(ccJava);
        }

        cboEditorSearchType.setSelectedItem(model.getEditorSearchType());
        
        cbBraceTooltip.setSelected(model.isBraceTooltip());
        cbShowBraceOutline.setSelected(model.isBraceOutline());

        listen = true;
        changed = false;
    }
    
    void applyChanges () {
        
        if (model == null || !changed) return;
        
        // java camel case navigation
        model.setCamelCaseNavigation(cbCamelCaseBehavior.isSelected());
        
        model.setEditorSearchType((String)cboEditorSearchType.getSelectedItem());
        
        model.setBraceOutline(cbShowBraceOutline.isSelected());
        model.setBraceTooltip(cbBraceTooltip.isSelected());

        changed = false;
    }
    
    void cancel () {
        changed = false;
    }
    
    boolean dataValid () {
        return true;
    }
    
    boolean isChanged () {
        return changed;
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        if (!listen) return;
        changed = model.isCamelCaseJavaNavigation() != cbCamelCaseBehavior.isSelected()
                || !model.getEditorSearchType().equals((String) cboEditorSearchType.getSelectedItem())
                || model.isBraceOutline() != cbShowBraceOutline.isSelected()
                || model.isBraceTooltip() != cbBraceTooltip.isSelected();
    }
    
    
    // other methods ...........................................................
    
    private static final class EditorSearchTypeRenderer implements ListCellRenderer {

        private final ListCellRenderer defaultRenderer;

        public EditorSearchTypeRenderer(ListCellRenderer defaultRenderer) {
            this.defaultRenderer = defaultRenderer;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            return defaultRenderer.getListCellRendererComponent(
                    list,
                    NbBundle.getMessage(GeneralEditorPanel.class, "EST_" + value), //NOI18N
                    index,
                    isSelected,
                    cellHasFocus);
        }

    }
}