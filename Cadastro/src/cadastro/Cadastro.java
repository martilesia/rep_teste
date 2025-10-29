/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import javax.swing.*;
import java.awt.Container;
import java.awt.event.*;
import java.util.Vector;
public class Cadastro {
    JPanel pan1= new JPanel ();
    JFrame fra1=new JFrame();
    JLabel lblCodigo= new JLabel("Codigo");
    JLabel lblNome= new JLabel("Nome");
    JLabel lblSexo= new JLabel("Sexo");
    JLabel lblEcivil= new JLabel("EstadoCivil");
    JTextField txtCodigo= new JTextField("");
    JTextField txtNome= new JTextField("");
    String listaSexo[]= {"Masculino","Femenino"};
    String listaEstado[]={"Casado","Solteiro"};
    JComboBox cboSexo= new JComboBox(listaSexo);
    JComboBox cboEstado= new JComboBox(listaEstado);
    JButton butRegistar=new JButton("REGISTAR");
    JButton butProcurar=new JButton("PROCURAR");
    JButton butACTUALIZAR=new JButton("ACTUALIZAR");
    JButton butApagar=new JButton("APAGAR");
    Container contentor=fra1.getContentPane();
            
    public Cadastro (){
        pan1.setLayout(null);contentor.add(pan1);
        pan1.add(lblCodigo);
        pan1.add(lblNome);
        pan1.add(lblSexo);
        pan1.add(lblEcivil);
        pan1.add(txtCodigo);
        pan1.add(txtNome);
        pan1.add(cboSexo);
        pan1.add(cboEstado);
        pan1.add(butRegistar);
        pan1.add(butProcurar);
        pan1.add(butACTUALIZAR);
        pan1.add(butApagar);
        lblCodigo.setBounds (20,30,120,25); txtCodigo.setBounds(150,30,150,25);
        lblNome.setBounds(20,70,120,25); txtNome.setBounds(150,70,150,25);
        lblSexo.setBounds(20,110,120,25); cboSexo.setBounds(150,110,150,25);
        lblEcivil.setBounds(20,150,120,25); cboEstado.setBounds(150,150,150,25);
        butRegistar.setBounds(20,190,280,25);
        butProcurar.setBounds(20,240,280,25);
        butACTUALIZAR.setBounds(20,280,280,25);
        butApagar.setBounds(20,320,280,25);
        fra1.setSize(400,600);
        fra1.setTitle("CADASTRO DE FUNCIONARIO");
        fra1.setLocation(300,100);
        fra1.setResizable(false);
        fra1.setVisible(true);
       eventos();
    
    }
    public Vector<Funcionario> x=new Vector<>();
    public void eventos(){
        butRegistar.addActionListener (
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        registar();
                    }
                }
        );
    }
    public void registar(){
        boolean y=false; Funcionario f;
        long cod= Long.parseLong(txtCodigo.getText());
        for (int i=0; i<x.size();i++){
            if (cod==x.get(i).codigo){y= true;break;}
        }
        if(y==false){
            f=new Funcionario();
            f.codigo=cod; f.nome=txtNome.getText();
            f.Sexo=(String) cboSexo.getSelectedItem();
            f.Ecivil=(String) cboEstado.getSelectedItem();
            x.addElement(f);
            JOptionPane.showMessageDialog(null,"SUCESSO");
            
        }
        else JOptionPane.showMessageDialog(null,"CODIGO IVALIDO");
    
    }
    
            
    
    
    
    
    public static void main (String[]args){
       new Cadastro();
   } 
}
