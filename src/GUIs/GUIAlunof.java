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
import static Entidades.Alunof_.nivelIdNivel;

public class GUIAlunof extends JFrame {
    public static void main(String[] args) {
        new GUIAlunof();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("id do aluno: ");
    private JLabel lbIdAluno = new JLabel("id do aluno");
    private JTextField fdIdAluno = new JTextField(15);

    private JLabel lbMomeAluno = new JLabel("nome");
    private JTextField fdMomeAluno = new JTextField(45);

    private JLabel lbEMail = new JLabel("e-mail");
    private JTextField fdEMail = new JTextField(100);

    private JLabel lbTelefone = new JLabel("telefone");
    private JTextField fdTelefone = new JTextField(45);

    private JLabel lbCelular = new JLabel("celular");
    private JTextField fdCelular = new JTextField(45);

    private JLabel lbEndereco = new JLabel("endereço");
    private JTextField fdEndereco = new JTextField(45);

    private JLabel lbBairro = new JLabel("bairro");
    private JTextField fdBairro = new JTextField(45);

    private JLabel lbCidade = new JLabel("cidade");
    private JTextField fdCidade = new JTextField(45);

    private JLabel lbCep = new JLabel("cep");
    private JTextField fdCep = new JTextField(10);

    private JLabel lbNivelIdNivel = new JLabel("nivel do aluno");
    private List<String> stringnivelIdNivel = new ArrayList<>();
    private JComboBox comboNivelIdNivel = new JComboBox();
    private JLabel lbEstadoSigla = new JLabel("estado");
    private JTextField fdEstadoSigla = new JTextField(2);


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

    DAOAlunof controle = new DAOAlunof();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    JTextComponent editor = (JTextComponent) comboNivelIdNivel.getEditor().getEditorComponent();

    Alunof alunof = new Alunof();
    DAOAlunof daoAlunof = new DAOAlunof();
    DAONivel daoNivel = new DAONivel();
    public GUIAlunof(){
        setSize(725, 660);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Cadastro de Alunofs");

        painelCentral.setLayout(new GridLayout(11, 2));
        painelCentral.add(lbMomeAluno);
        painelCentral.add(fdMomeAluno);
        painelCentral.add(lbEMail);
        painelCentral.add(fdEMail);
        painelCentral.add(lbTelefone);
        painelCentral.add(fdTelefone);
        painelCentral.add(lbCelular);
        painelCentral.add(fdCelular);
        painelCentral.add(lbEndereco);
        painelCentral.add(fdEndereco);
        painelCentral.add(lbBairro);
        painelCentral.add(fdBairro);
        painelCentral.add(lbCidade);
        painelCentral.add(fdCidade);
        painelCentral.add(lbCep);
        painelCentral.add(fdCep);
        painelCentral.add(lbEstadoSigla);
        painelCentral.add(fdEstadoSigla);

        fdMomeAluno.setEnabled(false);
        fdEMail.setEnabled(false);
        fdTelefone.setEnabled(false);
        fdCelular.setEnabled(false);
        fdEndereco.setEnabled(false);
        fdBairro.setEnabled(false);
        fdCidade.setEnabled(false);
        fdCep.setEnabled(false);
        fdEstadoSigla.setEnabled(false);

        List<String> combo = new ArrayList<>();
        combo = new ManipulaArquivo().abrirArquivo("Alunof");
        for(int x = 0; x < combo.size(); x++) {
            stringnivelIdNivel.add(combo.get(x).split(";")[0]);
        }
        comboNivelIdNivel = new JComboBox(stringnivelIdNivel.toArray());
        painelCentral.add(lbNivelIdNivel);
        painelCentral.add(comboNivelIdNivel);
        comboNivelIdNivel.setEnabled(false);
        editor.setDocument(new SearchableComboBox(comboNivelIdNivel));


cp.setBackground(Color.white);
        cp.add(painelNortes, BorderLayout.NORTH);
        cp.add(painelCentralFora, BorderLayout.CENTER);
        cp.add(painelSul, BorderLayout.SOUTH);

        painelCentralFora.add(labelBranco, BorderLayout.NORTH);
        painelCentralFora.add(painelCentral, BorderLayout.SOUTH);
        painelNortes.add(painelNorteCima);
        painelNortes.add(painelNorteBaixo);
        painelNorteCima.add(labelTitulo);
        painelNorteCima.add(fdIdAluno);
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
        fdIdAluno.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbIdAluno.setFont(new Font("Courier New", Font.BOLD, 17));
        lbMomeAluno.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEMail.setFont(new Font("Courier New", Font.BOLD, 17));
        lbTelefone.setFont(new Font("Courier New", Font.BOLD, 17));
        lbCelular.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEndereco.setFont(new Font("Courier New", Font.BOLD, 17));
        lbBairro.setFont(new Font("Courier New", Font.BOLD, 17));
        lbCidade.setFont(new Font("Courier New", Font.BOLD, 17));
        lbCep.setFont(new Font("Courier New", Font.BOLD, 17));
        lbNivelIdNivel.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEstadoSigla.setFont(new Font("Courier New", Font.BOLD, 17));
        fdIdAluno.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdMomeAluno.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEMail.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdTelefone.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdCelular.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEndereco.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdBairro.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdCidade.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdCep.setFont(new Font("Courier New", Font.PLAIN, 17));
        comboNivelIdNivel.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEstadoSigla.setFont(new Font("Courier New", Font.PLAIN, 17));
        labelAviso.setFont(new Font("Courier New", Font.BOLD, 20));
        btInserir.setVisible(false);
        btAtualizar.setVisible(false);
        btRemover.setVisible(false);
        btSalvar.setVisible(false);
        btCancelar.setVisible(false);

        painelSul.add(labelAviso);
         List<String> ltc = daoNivel.listInOrderNomeStrings("id"); //lista tipo carteira (ltc)
        for (int i = 0; i < ltc.size(); i++) {
            comboNivelIdNivel.addItem(ltc.get(i));
        }
        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    alunof = new Alunof();
                    int idAluno = Integer.valueOf(fdIdAluno.getText());
                    alunof.setIdAluno(Integer.valueOf(fdIdAluno.getText()));
                    alunof = controle.obter(alunof.getIdAluno());
                    labelAviso.setBackground(Color.green);
                    if (alunof != null) {
                        fdIdAluno.setText(alunof.getIdAluno() + "");
                        fdMomeAluno.setText(alunof.getMomeAluno() + "");
                        fdEMail.setText(alunof.getEMail() + "");
                        fdTelefone.setText(alunof.getTelefone() + "");
                        fdCelular.setText(alunof.getCelular() + "");
                        fdEndereco.setText(alunof.getEndereco() + "");
                        fdBairro.setText(alunof.getBairro() + "");
                        fdCidade.setText(alunof.getCidade() + "");
                        fdCep.setText(alunof.getCep() + "");
                        comboNivelIdNivel.setSelectedItem(alunof.getNivelIdNivel().toString());
                        fdEstadoSigla.setText(alunof.getEstadoSigla() + "");
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        btInserir.setVisible(false);
                        btListar.setVisible(false);
                        labelAviso.setText("Encontrado na lista!");
                        labelAviso.setBackground(Color.green);
                    } else {
                        fdMomeAluno.setEnabled(false);
                        fdMomeAluno.setText(null);
                        fdEMail.setEnabled(false);
                        fdEMail.setText(null);
                        fdTelefone.setEnabled(false);
                        fdTelefone.setText(null);
                        fdCelular.setEnabled(false);
                        fdCelular.setText(null);
                        fdEndereco.setEnabled(false);
                        fdEndereco.setText(null);
                        fdBairro.setEnabled(false);
                        fdBairro.setText(null);
                        fdCidade.setEnabled(false);
                        fdCidade.setText(null);
                        fdCep.setEnabled(false);
                        fdCep.setText(null);
                        fdEstadoSigla.setEnabled(false);
                        fdEstadoSigla.setText(null);
                        comboNivelIdNivel.setEnabled(false);
                        comboNivelIdNivel.setSelectedIndex(0);
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
                fdIdAluno.setEnabled(false);
                fdMomeAluno.setEnabled(true);
                fdEMail.setEnabled(true);
                fdTelefone.setEnabled(true);
                fdCelular.setEnabled(true);
                fdEndereco.setEnabled(true);
                fdBairro.setEnabled(true);
                fdCidade.setEnabled(true);
                fdCep.setEnabled(true);
                comboNivelIdNivel.setEnabled(true);
                fdEstadoSigla.setEnabled(true);
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
                    alunof = new Alunof();
                        alunof.setIdAluno(Integer.valueOf(fdIdAluno.getText()));
                        alunof.setMomeAluno(fdMomeAluno.getText());
                        alunof.setEMail(fdEMail.getText());
                        alunof.setTelefone(fdTelefone.getText());
                        String x = (String) comboNivelIdNivel.getSelectedItem();
                        String[] aux = x.split(";");
                        Nivel nivel = daoNivel.obter(Integer.valueOf(aux[0]));
                        alunof.setNivelIdNivel(nivel);
                        alunof.setEndereco(fdEndereco.getText());
                        alunof.setBairro(fdBairro.getText());
                        alunof.setCidade(fdCidade.getText());
                        alunof.setCep(fdCep.getText());
                        alunof.setEstadoSigla(fdEstadoSigla.getText());
                        controle.inserir(alunof);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdIdAluno.setEnabled(true);
                        fdIdAluno.requestFocus();
                        fdMomeAluno.setEnabled(false);
                        fdEMail.setEnabled(false);
                        fdTelefone.setEnabled(false);
                        fdCelular.setEnabled(false);
                        fdEndereco.setEnabled(false);
                        fdBairro.setEnabled(false);
                        fdCidade.setEnabled(false);
                        fdCep.setEnabled(false);
                        comboNivelIdNivel.setEnabled(false);
                        fdEstadoSigla.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                } else { //btAlterar
                    try {
                        alunof = new Alunof();
                        alunof.setIdAluno(Integer.valueOf(fdIdAluno.getText()));
                        alunof.setMomeAluno(fdMomeAluno.getText());
                        alunof.setEMail(fdEMail.getText());
                        alunof.setTelefone(fdTelefone.getText());
                        String x = (String) comboNivelIdNivel.getSelectedItem();
                        String[] aux = x.split(";");
                        Nivel nivel = daoNivel.obter(Integer.valueOf(aux[0]));
                        alunof.setNivelIdNivel(nivel);
                        alunof.setEndereco(fdEndereco.getText());
                        alunof.setBairro(fdBairro.getText());
                        alunof.setCidade(fdCidade.getText());
                        alunof.setCep(fdCep.getText());
                        alunof.setEstadoSigla(fdEstadoSigla.getText());
                        controle.atualizar(alunof);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdIdAluno.setEnabled(true);
                        fdIdAluno.requestFocus();
                        fdMomeAluno.setEnabled(false);
                        fdEMail.setEnabled(false);
                        fdTelefone.setEnabled(false);
                        fdCelular.setEnabled(false);
                        fdEndereco.setEnabled(false);
                        fdBairro.setEnabled(false);
                        fdCidade.setEnabled(false);
                        fdCep.setEnabled(false);
                        comboNivelIdNivel.setEnabled(false);
                        fdEstadoSigla.setEnabled(false);
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
                fdIdAluno.setEnabled(false);
                fdIdAluno.setText("");
                fdMomeAluno.setEnabled(false);
                fdMomeAluno.setText("");
                fdEMail.setEnabled(false);
                fdEMail.setText("");
                fdTelefone.setEnabled(false);
                fdTelefone.setText("");
                fdCelular.setEnabled(false);
                fdCelular.setText("");
                fdEndereco.setEnabled(false);
                fdEndereco.setText("");
                fdBairro.setEnabled(false);
                fdBairro.setText("");
                fdCidade.setEnabled(false);
                fdCidade.setText("");
                fdCep.setEnabled(false);
                fdCep.setText("");
                comboNivelIdNivel.setEnabled(false);
                comboNivelIdNivel.setSelectedIndex(0);
                fdEstadoSigla.setEnabled(false);
                fdEstadoSigla.setText("");
                fdIdAluno.setEnabled(true);
                fdIdAluno.requestFocus();
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
                fdMomeAluno.setEnabled(true);
                fdEMail.setEnabled(true);
                fdTelefone.setEnabled(true);
                fdCelular.setEnabled(true);
                fdEndereco.setEnabled(true);
                fdBairro.setEnabled(true);
                fdCidade.setEnabled(true);
                fdCep.setEnabled(true);
                comboNivelIdNivel.setEnabled(true);
                fdEstadoSigla.setEnabled(true);
                fdMomeAluno.requestFocus();
                fdIdAluno.setEnabled(false);
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
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + alunof.getIdAluno() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.remover(alunof);
                    labelAviso.setText("Removido!");
                    fdIdAluno.setText("");
                    fdMomeAluno.setText("");
                    fdMomeAluno.setEnabled(false);
                    fdEMail.setText("");
                    fdEMail.setEnabled(false);
                    fdTelefone.setText("");
                    fdTelefone.setEnabled(false);
                    fdCelular.setText("");
                    fdCelular.setEnabled(false);
                    fdEndereco.setText("");
                    fdEndereco.setEnabled(false);
                    fdBairro.setText("");
                    fdBairro.setEnabled(false);
                    fdCidade.setText("");
                    fdCidade.setEnabled(false);
                    fdCep.setText("");
                    fdCep.setEnabled(false);
                comboNivelIdNivel.setEnabled(false);
                comboNivelIdNivel.setSelectedIndex(0);
                    fdEstadoSigla.setText("");
                    fdEstadoSigla.setEnabled(false);
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
                new AlunofGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
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
