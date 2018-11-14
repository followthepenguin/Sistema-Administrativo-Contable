package servicios;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import modulos.Categorias;
import modulos.Productos;

/**
 *
 * @author t0ken
 */

public class EditorTablaProductos extends AbstractCellEditor implements TableCellEditor{

    private Productos productos;
    private String valorViejo="";
    private String valorNuevo="";
    private String nombreColumna="";
    private String id="";
    private JComponent component = new JTextField();

    public EditorTablaProductos(Productos productos, String nombreColumna)
    {
            this.productos = productos;
            this.nombreColumna = nombreColumna;
    }

    public Object getCellEditorValue() {
        return ((JTextField)component).getText();
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        valorViejo = value.toString();
        id = table.getValueAt(row,0).toString();
        ((JTextField)component).setText(value.toString());
        return component;
    }

    @Override
    public boolean stopCellEditing() {
        valorNuevo = (String)getCellEditorValue();
        
        if( !valorNuevo.equals(valorViejo))
        {   
            if(!productos.modificar(Conexion.getConexion(),nombreColumna+"='"+valorNuevo+"' ", id ) )
            {   
                ((JTextField)component).setText(valorViejo);
            }
            else
                JOptionPane.showMessageDialog(null, "Registro modificado");
        }
        return super.stopCellEditing();
    }
}

