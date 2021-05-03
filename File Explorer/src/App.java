import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This has all of the buttons and panels that the File Explorer has.
 */
public class App extends JFrame{
    JPanel panel;
    JButton ok, cancel;
    JMenuBar menubar, statusbar;
    JDesktopPane desktop, desktop1;

    public App(){
        // Default to display the window
        this.setTitle("'Lite' Version File Explorer");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set new panel
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //Menu bar
        menubar = new JMenuBar();

        // Desktop Pane
        desktop = new JDesktopPane();

        // Status bar
        statusbar = new JMenuBar();

        // Buttons
        ok = new JButton("Okay");
        cancel = new JButton("Cancel");

        // Actions for the buttons
        ok.addActionListener(new okActionListener());
        cancel.addActionListener(new okActionListener());

    }
    public void go(){
        buildMenu();
        buildStatusBar();

        panel.add(desktop, BorderLayout.CENTER);
        FileFrame fileFrame = new FileFrame();
        desktop.add(fileFrame);

        // Add buttons
        /**
        panel.add(ok, BorderLayout.NORTH);
        panel.add(cancel, BorderLayout.SOUTH);
        this.add(panel);
        */
        this.add(panel);
        this.setVisible(true);
    }

    public void buildMenu(){
        JMenu fileMenu, helpMenu, windowMenu, treeMenu;
        fileMenu = new JMenu("File");
        treeMenu = new JMenu("Tree");
        helpMenu = new JMenu("Help");
        windowMenu = new JMenu("Window");

        // File Drop Down Menu
        JMenuItem renameMenuItem = new JMenuItem("Rename");
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem deleteMenuItem = new JMenuItem("Delete");
        JMenuItem runMenuItem = new JMenuItem("Run");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        // Tree Drop Down Menu
        JMenuItem expandBranchMenuItem = new JMenuItem("Expand Branch");
        JMenuItem collapseBranchMenuItem = new JMenuItem("Collapse Branch");

        // Window Drop Down Menu
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem cascadeMenuItem = new JMenuItem("Cascade");

        // Help Drop Down Menu
        JMenuItem helpMenuItem = new JMenuItem("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");

        // Adds each one to the column
        fileMenu.add(renameMenuItem);
        fileMenu.add(copyMenuItem);
        fileMenu.add(deleteMenuItem);
        fileMenu.add(runMenuItem);
        fileMenu.add(exitMenuItem);
        treeMenu.add(expandBranchMenuItem);
        treeMenu.add(collapseBranchMenuItem);
        windowMenu.add(newMenuItem);
        windowMenu.add(cascadeMenuItem);
        helpMenu.add(helpMenuItem);
        helpMenu.add(aboutMenuItem);

        // Adds the Action for the Menu Items
        exitMenuItem.addActionListener(new FileActionListener());

        // Adds it to the menubar
        menubar.add(fileMenu);
        menubar.add(treeMenu);
        menubar.add(windowMenu);
        menubar.add(helpMenu);

        // Adds ths menu to the panel and adds the direction to it
        panel.add(menubar, BorderLayout.NORTH);
    }

    public void buildStatusBar(){
        JLabel size = new JLabel("Size in GB: ");
        statusbar.add(size);
        panel.add(statusbar, BorderLayout.SOUTH);
    }

    public void buildToolBar(){

    }

    private class okActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand().equals("Okay")){
                System.out.println("You pressed Okay");
            }
            if(e.getActionCommand().equals("Cancel")){
                System.out.println("You pressed Cancel");
            }
        }
    }

    private class FileActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Exit")){
                System.exit(0);
            }
        }
    }

    private class HelpActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            AboutDlg dlg = new AboutDlg();
            dlg.setVisible(true);
        }
    }

    private class RunActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Run")){
                System.out.println("Running the program");
            }
            if(e.getActionCommand().equals("Debug")){
                System.out.println("Debugging the Program");
            }
        }
    }
}
