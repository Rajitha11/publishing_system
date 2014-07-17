/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.clz;
import com.org.DB.ConnectionSet1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuan
 */
public class tablemodel1 {
    @SuppressWarnings("unchecked")
public static void fillTable(String sqlQuery, JTable table) throws ClassNotFoundException, SQLException, Exception {
DefaultTableModel dtm = (DefaultTableModel) table.getModel();
dtm.setRowCount(0);
int i = 0;
ResultSet rs = ConnectionSet1.getInstance().getResult(sqlQuery);
while (rs.next()) {
Vector v = new Vector();
//v.add(i);
for (int j = 1; j <= dtm.getColumnCount(); j++) {
v.add(rs.getString(j));
    System.out.println(j);
}
dtm.addRow(v);
i++;
}
rs.close();
rs=null;
dtm = null;
}
}
