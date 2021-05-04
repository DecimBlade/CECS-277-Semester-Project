import java.io.File;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class DirPanel extends JPanel {
    private JScrollPane scrollPane = new JScrollPane();
    private JTree dirTree = new JTree();

    public DirPanel(String dir){
        scrollPane.setViewportView(dirTree);
        dirTree.setShowsRootHandles(true);
        dirTree.setEditable(true);
        dirTree.addTreeSelectionListener(new TreeListenerBro());
        GroupLayout layout = new GroupLayout(this);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));
        add(scrollPane);
        treeBuilder(dir);
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
