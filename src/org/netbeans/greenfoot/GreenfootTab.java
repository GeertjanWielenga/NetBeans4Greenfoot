package org.netbeans.greenfoot;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.netbeans.spi.project.ui.support.ProjectCustomizer.Category;
import org.openide.util.*;

public class GreenfootTab implements ProjectCustomizer.CompositeCategoryProvider {

    private final String name;

    private GreenfootTab(String name) {
        this.name = name;
    }

    @Override
    public Category createCategory(Lookup lkp) {
        return ProjectCustomizer.Category.create(name, name, null);
    }

    @Override
    public JComponent createComponent(Category category, Lookup lkp) {
        JPanel greenfootPanel = new JPanel();
        greenfootPanel.setLayout(new BoxLayout(greenfootPanel, BoxLayout.Y_AXIS));
        greenfootPanel.add(new JCheckBox("Add Greenfoot JARs"));
        greenfootPanel.add(new JCheckBox("Set main class"));
        greenfootPanel.add(new JCheckBox("Set working directory"));
        greenfootPanel.add(new JCheckBox("Add standalone.properties"));
        return greenfootPanel;
    }

    @NbBundle.Messages({"LBL_Greenfoot=Greenfoot"})
    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "org-netbeans-modules-java-j2seproject",
            position = 600)
    public static GreenfootTab createMyDemoConfigurationTab() {
        return new GreenfootTab(Bundle.LBL_Greenfoot());
    }

}
