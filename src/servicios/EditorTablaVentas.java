package servicios;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import modulos.Ventas;

/**
 *
 * @author t0ken
 */

public class EditorTablaVentas extends AbstractCellEditor implements TableCellEditor{

    private Ventas ventas;
    private String valorViejo="";
    private String valorNuevo="";
    private String nombreColumna="";
    private String id="";
    private JComponent component = new JTextField();

    public EditorTablaVentas(Ventas ventas, String nombreColumna)
    {
            this.ventas = ventas;
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
        if(!(nombreColumna.equals("id_trabajador_venta") || nombreColumna.equals("id_cliente_venta") || nombreColumna.equals("total_venta") || nombreColumna.equals("fecha_venta")))
        {
            if( !valorNuevo.equals(valorViejo))
            {   
                if(!ventas.modificar(Conexion.getConexion(),nombreColumna+"='"+valorNuevo+"' ", id ) )
                {   
                    ((JTextField)component).setText(valorViejo);
                }
                else
                    JOptionPane.showMessageDialog(null, "Registro modificado");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Este campo no se puede modificar");
            ((JTextField)component).setText(valorViejo);
        }
        return super.stopCellEditing();
    }
}

