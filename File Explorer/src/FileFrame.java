import javax.swing.*;

public class FileFrame extends JInternalFrame {
    JSplitPane splitPane;
    public FileFrame(){
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new DirPanel(), new FilePanel());
        this.setTitle("C:");
        this.getContentPane().add(splitPane);
        this.setSize(700, 500);
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setClosable(true);
        this.setVisible(true);
    }
}
