import java.io.File;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class DirPanel extends JPanel {
    private JScrollPane scrollPane = new JScrollPane();
    private JTree dirTree = new JTree();

    public DirPanel(){
        scrollPane.setViewportView(dirTree);
        add(scrollPane);
    }

    public void treeBuilder(String dir){
        File file = new File(dir);
        dirTree.addTreeSelectionListener(new MyTreeListener());
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(dir);
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        fileCreator(root, file);
        dirTree.setModel(treeModel);
    }
}
