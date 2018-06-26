/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import main.CaixaDeFerramentas;

/**
 *
 * @author Asus
 */
public class GUIMenu extends JFrame {

    Container cp;

    JPanel pnTotal = new JPanel();

    JMenuBar menubarMenu = new JMenuBar();
    JMenu menu = new JMenu("Cadastros");//aqui o que vai aparecer no nome do menu
    JMenuItem aluno = new JMenuItem("Aluno");//as partes do menu
    JMenuItem professor = new JMenuItem("Professor");
    JMenuItem nivel = new JMenuItem("nivel");
    JMenuItem instrumento = new JMenuItem("instrumento");
    CaixaDeFerramentas caixaDeFerramentas = new CaixaDeFerramentas();

    public GUIMenu() {
        setTitle("Escola de Musica");
        setSize(500, 320);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();

        setJMenuBar(menubarMenu);
        menubarMenu.add(menu);
        menu.add(aluno);//só ta adicionando essas porra
        menu.addSeparator();
        menu.add(professor);
        menu.addSeparator();
        menu.add(nivel);
        menu.addSeparator();
        menu.add(instrumento);

        cp.add(pnTotal);

        aluno.addActionListener(new ActionListener() {//faz listener de todos os componentes do menu e só vai
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIAlunof guiAlunof = new GUIAlunof();
            }
        });

        professor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIProfessor guiProfessor = new GUIProfessor();
            }
        });

        nivel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUINivel guiNivel = new GUINivel();
            }
        });

        instrumento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIInstrumento guiInstrumento = new GUIInstrumento();
            }
        });

        setVisible(true);
        setLocationRelativeTo(null);
    }
}
