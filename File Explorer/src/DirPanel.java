import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class DirPanel extends JPanel {
    private JScrollPane scrollPane = new JScrollPane();
    private JTree dirTree = new JTree();

    public DirPanel(){
        scrollPane.setViewportView(dirTree);
        add(scrollPane);
    }
}
