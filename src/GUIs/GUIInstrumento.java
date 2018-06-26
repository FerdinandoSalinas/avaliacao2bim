package GUIs;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import java.io.File;
import javax.swing.text.JTextComponent;
import Auxiliar.*;
import DAOs.*;
import Entidades.*;

public class GUIInstrumento extends JFrame {
    public static void main(String[] args) {
        new GUIInstrumento();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("id: ");
    private JLabel lbIdInstrumento = new JLabel("id");
    private JTextField fdIdInstrumento = new JTextField(15);

    private JLabel lbNomeInstrumento = new JLabel("Nome");
    private JTextField fdNomeInstrumento = new JTextField(45);

    private JLabel lbValorHoraAula = new JLabel("Valor da aula");
    private JTextField fdValorHoraAula = new JTextField(0);


    private JPanel painelNortes = new JPanel(new GridLayout(2, 1));
    private JPanel painelNorteCima = new JPanel();
    private JPanel painelNorteBaixo = new JPanel();
    private JPanel painelCentralFora = new JPanel(new BorderLayout());
    private JPanel painelCentral = new JPanel();
    private JPanel painelSul = new JPanel();
    private JLabel labelBranco = new JLabel();

    JButton btInserir = new JButton(new ImageIcon(getClass().getResource("/icones/add.png")));
    JButton btSalvar = new JButton(new ImageIcon(getClass().getResource("/icones/confirmar.png")));
    JButton btRemover = new JButton(new ImageIcon(getClass().getResource("/icones/deletar.png")));
    JButton btAtualizar = new JButton(new ImageIcon(getClass().getResource("/icones/att.png")));
    JButton btBuscar = new JButton(new ImageIcon(getClass().getResource("/icones/search.png")));
    JButton btCancelar = new JButton(new ImageIcon(getClass().getResource("/icones/cancelar.png")));
    JButton btListar = new JButton(new ImageIcon(getClass().getResource("/icones/listar.png")));

    DAOInstrumento controle = new DAOInstrumento();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Instrumento instrumento = new Instrumento();

    public GUIInstrumento(){
        setSize(725, 340);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Cadastro de Instrumentos");

        painelCentral.setLayout(new GridLayout(3, 2));
        painelCentral.add(lbNomeInstrumento);
        painelCentral.add(fdNomeInstrumento);
        painelCentral.add(lbValorHoraAula);
        painelCentral.add(fdValorHoraAula);

        fdNomeInstrumento.setEnabled(false);
        fdValorHoraAula.setEnabled(false);

        List<String> combo = new ArrayList<>();


cp.setBackground(Color.white);
        cp.add(painelNortes, BorderLayout.NORTH);
        cp.add(painelCentralFora, BorderLayout.CENTER);
        cp.add(painelSul, BorderLayout.SOUTH);

        painelCentralFora.add(labelBranco, BorderLayout.NORTH);
        painelCentralFora.add(painelCentral, BorderLayout.SOUTH);
        painelNortes.add(painelNorteCima);
        painelNortes.add(painelNorteBaixo);
        painelNorteCima.add(labelTitulo);
        painelNorteCima.add(fdIdInstrumento);
        painelNorteBaixo.add(btBuscar);
        painelNorteBaixo.add(btInserir);
        painelNorteBaixo.add(btAtualizar);
        painelNorteBaixo.add(btRemover);
        painelNorteBaixo.add(btSalvar);
        painelNorteBaixo.add(btCancelar);
        painelNorteBaixo.add(btListar);
        painelNorteCima.setBackground(Color.white);
        painelNorteBaixo.setBackground(Color.white);
        painelCentralFora.setBackground(Color.white);
        painelCentral.setBackground(Color.white);
        painelSul.setBackground(Color.white);
        btInserir.setBackground(Color.WHITE);
        btSalvar.setBackground(Color.WHITE);
        btRemover.setBackground(Color.WHITE);
        btAtualizar.setBackground(Color.WHITE);
        btBuscar.setBackground(Color.WHITE);
        btCancelar.setBackground(Color.WHITE);
        btListar.setBackground(Color.WHITE);

        labelTitulo.setFont(new Font("Courier New", Font.BOLD, 20));
        fdIdInstrumento.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbIdInstrumento.setFont(new Font("Courier New", Font.BOLD, 17));
        lbNomeInstrumento.setFont(new Font("Courier New", Font.BOLD, 17));
        lbValorHoraAula.setFont(new Font("Courier New", Font.BOLD, 17));
        fdIdInstrumento.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdNomeInstrumento.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdValorHoraAula.setFont(new Font("Courier New", Font.PLAIN, 17));
        labelAviso.setFont(new Font("Courier New", Font.BOLD, 20));
        btInserir.setVisible(false);
        btAtualizar.setVisible(false);
        btRemover.setVisible(false);
        btSalvar.setVisible(false);
        btCancelar.setVisible(false);

        painelSul.add(labelAviso);

        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    instrumento = new Instrumento();
                    int idInstrumento = Integer.valueOf(fdIdInstrumento.getText());
                    instrumento.setIdInstrumento(Integer.valueOf(fdIdInstrumento.getText()));
                    instrumento = controle.obter(instrumento.getIdInstrumento());
                    labelAviso.setBackground(Color.green);
                    if (instrumento != null) {
                        fdIdInstrumento.setText(instrumento.getIdInstrumento() + "");
                        fdNomeInstrumento.setText(instrumento.getNomeInstrumento() + "");
                        fdValorHoraAula.setText(instrumento.getValorHoraAula() + "");
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        btInserir.setVisible(false);
                        btListar.setVisible(false);
                        labelAviso.setText("Encontrado na lista!");
                        labelAviso.setBackground(Color.green);
                    } else {
                        fdNomeInstrumento.setEnabled(false);
                        fdNomeInstrumento.setText(null);
                        fdValorHoraAula.setEnabled(false);
                        fdValorHoraAula.setText(null);
                        labelAviso.setText("Não encontrado!");
                        labelAviso.setBackground(Color.red);
                        btInserir.setVisible(true);
                        btAtualizar.setVisible(false);
                        btRemover.setVisible(false);
                        btListar.setVisible(false);
                    }
                } catch (Exception erro) {
                    labelAviso.setText("Preencha os campos corretamente!");
                    labelAviso.setBackground(Color.red);
                }
            }
        }
        );

        btInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = true;
                fdIdInstrumento.setEnabled(false);
                fdNomeInstrumento.setEnabled(true);
                fdValorHoraAula.setEnabled(true);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btInserir.setVisible(false);
                btListar.setVisible(false);
            }
        }
        );

        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acao){ //btInserir
                    try {
                    instrumento = new Instrumento();
                        instrumento.setIdInstrumento(Integer.valueOf(fdIdInstrumento.getText()));
                        instrumento.setNomeInstrumento(fdNomeInstrumento.getText());
                        instrumento.setValorHoraAula(Double.valueOf(fdValorHoraAula.getText()));
                        controle.inserir(instrumento);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdIdInstrumento.setEnabled(true);
                        fdIdInstrumento.requestFocus();
                        fdNomeInstrumento.setEnabled(false);
                        fdValorHoraAula.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                } else { //btAlterar
                    try {
                        instrumento = new Instrumento();
                        instrumento.setIdInstrumento(Integer.valueOf(fdIdInstrumento.getText()));
                        instrumento.setNomeInstrumento(fdNomeInstrumento.getText());
                        instrumento.setValorHoraAula(Double.valueOf(fdValorHoraAula.getText()));
                        controle.atualizar(instrumento);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdIdInstrumento.setEnabled(true);
                        fdIdInstrumento.requestFocus();
                        fdNomeInstrumento.setEnabled(false);
                        fdValorHoraAula.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                }
            }
        }
    );

        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelAviso.setText("Cancelado!");
                fdIdInstrumento.setEnabled(false);
                fdIdInstrumento.setText("");
                fdNomeInstrumento.setEnabled(false);
                fdNomeInstrumento.setText("");
                fdValorHoraAula.setEnabled(false);
                fdValorHoraAula.setText("");
                fdIdInstrumento.setEnabled(true);
                fdIdInstrumento.requestFocus();
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
            }
        }
        );

        btAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = false;
                fdNomeInstrumento.setEnabled(true);
                fdValorHoraAula.setEnabled(true);
                fdNomeInstrumento.requestFocus();
                fdIdInstrumento.setEnabled(false);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btRemover.setVisible(false);
                btAtualizar.setVisible(false);
                btListar.setVisible(false);
            }
        }
        );

        btRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btRemover.setVisible(false);
                btListar.setVisible(false);
                btAtualizar.setVisible(false);
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + instrumento.getIdInstrumento() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.remover(instrumento);
                    labelAviso.setText("Removido!");
                    fdIdInstrumento.setText("");
                    fdNomeInstrumento.setText("");
                    fdNomeInstrumento.setEnabled(false);
                    fdValorHoraAula.setText("");
                    fdValorHoraAula.setEnabled(false);
                    btListar.setVisible(true);
                } else {
                    labelAviso.setText("Remoção cancelada!");
                    btAtualizar.setVisible(true);
                    btRemover.setVisible(true);
                }
            }
        }
        );


        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InstrumentoGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
            }
        }
        );

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        }
        );
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
