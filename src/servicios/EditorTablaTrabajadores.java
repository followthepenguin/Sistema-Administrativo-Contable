package servicios;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import modulos.Trabajadores;

/**
 *
 * @author t0ken
 */

public class EditorTablaTrabajadores extends AbstractCellEditor implements TableCellEditor{

    private Trabajadores trabajadores;
    private String valorViejo="";
    private String valorNuevo="";
    private String nombreColumna="";
    private String id="";
    private JComponent component = new JTextField();

    public EditorTablaTrabajadores(Trabajadores trabajadores, String nombreColumna)
    {
            this.trabajadores = trabajadores;
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
        
        if(!(nombreColumna.equals("usuario_trabajador") || nombreColumna.equals("contrasena_trabajador") || nombreColumna.equals("id_categoria_trabajador")))
        {
            if( !valorNuevo.equals(valorViejo))
            {   
                if(!trabajadores.modificar(Conexion.getConexion(),nombreColumna+"='"+valorNuevo+"' ", id ) )
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

