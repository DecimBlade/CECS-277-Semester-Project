import java.io.File;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class DirPanel extends JPanel {
    private JScrollPane scrollPane = new JScrollPane();
    private JTree dirTree = new JTree();

    public DirPanel(String dir){
        scrollPane.setViewportView(dirTree);
        dirTree.setShowsRootHandles(true);
        dirTree.setEditable(true);
        dirTree.addTreeSelectionListener(new TreeListenerBra());
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

    class TreeListenerBra implements TreeSelectionListener{
        DefaultMutableTreeNode node;
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            node = (DefaultMutableTreeNode)dirTree.getLastSelectedPathComponent();
            FileNode fnode = (FileNode) node.getUserObject();
            File filePath = fnode.getFile();
            fileCreator(node, filePath);
            
        }
    }

    class MyTreeListener implements TreeSelectionListener{
        DefaultMutableTreeNode node;
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            node = (DefaultMutableTreeNode)dirTree.getLastSelectedPathComponent();
            FileNode fnode = (FileNode) node.getUserObject();
            File filePath = fnode.getFile();
            fileCreator(node, filePath);
            
        }

    }

    private void fileCreator(DefaultMutableTreeNode root, File file) {
        root.removeAllChildren();
        File[] files = file.listFiles();
        for(int ii = 0; ii<files.length; ii++){
            if(!files[ii].isHidden()){
                FileNode myFileNode = new FileNode(files[ii].getAbsolutePath());
                if(files[ii].isDirectory()){
                    DefaultMutableTreeNode subNode = new DefaultMutableTreeNode(myFileNode);
                    File[] dfiles = files[ii].listFiles();
                    try{
                        for(int jj=0; jj<dfiles.length; jj++){
                            if(dfiles[jj].isDirectory()){
                                DefaultMutableTreeNode sub2Node = new DefaultMutableTreeNode(dfiles[jj].getName());
                                root.add(subNode);
                                subNode.add(sub2Node);
                            }
                        }
                    }
                    catch(NullPointerException ex){

                    }
                }
            }
        }

    }
}
