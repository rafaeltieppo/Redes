package viewers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.ProcessaRede;
import models.PontoRede;

public class FormRede extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel cabecalho;
	private JTextField codigo, origem, destino, distancia;
	private JComboBox<String> tipoOrigem, tipoDestino;
	private JButton salvar, cancelar, adicionar, excluir, listarOrigem;
	private JTable tabela;
	private JScrollPane scroll;
	private DefaultTableModel dtm;

	FormRede() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registro de Rede");
		setSize(900, 520);
		painel = new JPanel();
		painel.setBackground(Color.black);
		setContentPane(painel);
		setLocationRelativeTo(null);
		setLayout(null);

		codigo = new JTextField();
		codigo.setBounds(20, 20, 100, 25);
		painel.add(codigo);
		cabecalho = new JLabel("Código");
		cabecalho.setForeground(Color.YELLOW);
		cabecalho.setSize(60, 20);
		cabecalho.setBounds(20, -3, 100, 30);
		add(cabecalho);

		origem = new JTextField();
		origem.setBounds(120, 20, 100, 25);
		painel.add(origem);
		cabecalho = new JLabel("Origem");
		cabecalho.setForeground(Color.YELLOW);
		cabecalho.setSize(60, 20);
		cabecalho.setBounds(120, -3, 100, 30);
		add(cabecalho);

		tipoOrigem = new JComboBox<String>(new String[] { "SWITCH", "ROTEADOR" });
		tipoOrigem.setBounds(220, 20, 125, 25);
		painel.add(tipoOrigem);
		cabecalho = new JLabel("TipoOrigem");
		cabecalho.setForeground(Color.YELLOW);
		cabecalho.setSize(60, 20);
		cabecalho.setBounds(220, -3, 100, 30);
		add(cabecalho);

		destino = new JTextField();
		destino.setBounds(345, 20, 130, 25);
		painel.add(destino);
		cabecalho = new JLabel("Destino");
		cabecalho.setForeground(Color.YELLOW);
		cabecalho.setSize(60, 20);
		cabecalho.setBounds(345, -3, 100, 30);
		add(cabecalho);

		tipoDestino = new JComboBox<String>(new String[] { "PC", "NOTEBOOK", "IMPRESSORA", "SWITCH", "ROTEADOR" });

		tipoDestino.setBounds(475, 20, 125, 25);
		painel.add(tipoDestino);
		cabecalho = new JLabel("TipoDestino");
		cabecalho.setForeground(Color.YELLOW);
		cabecalho.setSize(60, 20);
		cabecalho.setBounds(475, -3, 100, 30);
		add(cabecalho);

		distancia = new JTextField();
		distancia.setBounds(600, 20, 120, 25);
		painel.add(distancia);
		cabecalho = new JLabel("Distancia");
		cabecalho.setForeground(Color.YELLOW);
		cabecalho.setSize(60, 20);
		cabecalho.setBounds(600, -3, 100, 30);
		add(cabecalho);
		/*
		 * texto = new JTextArea(listarTudo());// aqui esta listando tudo
		 * texto.setEditable(false); texto.setBounds(20, 50, 850, 370);
		 * texto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		 * painel.add(texto);
		 */
		preencherTabela();

		salvar = new JButton("Salvar");
		salvar.setBounds(20, 430, 120, 30);
		painel.add(salvar);
		salvar.setForeground(Color.YELLOW);
		salvar.setBackground(Color.GRAY);
		salvar.addActionListener(this);

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(150, 430, 120, 30);
		painel.add(cancelar);
		cancelar.setForeground(Color.YELLOW);
		cancelar.setBackground(Color.GRAY);
		cancelar.addActionListener(this);

		adicionar = new JButton("Adicionar");
		adicionar.setBounds(750, 15, 120, 30);
		painel.add(adicionar);
		adicionar.setForeground(Color.YELLOW);
		adicionar.setBackground(Color.GRAY);
		adicionar.addActionListener(this);

		excluir = new JButton("Excluir");
		excluir.setBounds(750, 430, 120, 30);
		painel.add(excluir);
		excluir.setForeground(Color.YELLOW);
		excluir.setBackground(Color.GRAY);
		excluir.addActionListener(this);

		listarOrigem = new JButton("ListarOrigem");
		listarOrigem.setBounds(370, 430, 120, 30);
		painel.add(listarOrigem);
		listarOrigem.setForeground(Color.YELLOW);
		listarOrigem.setBackground(Color.GRAY);
		listarOrigem.addActionListener(this);

	}

	private void preencherTabela() {
		dtm = new DefaultTableModel();
		dtm.addColumn("Codigo");
		dtm.addColumn("Origem");
		dtm.addColumn("tipoOrigem");
		dtm.addColumn("Destino");
		dtm.addColumn("tipoDestino");
		dtm.addColumn("Distância");
		for (PontoRede pd : ProcessaRede.redes) {
			dtm.addRow(pd.toVetorTabel());
		}
		tabela = new JTable(dtm);
		tabela.setForeground(Color.YELLOW);
		tabela.setBackground(Color.gray);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(20, 50, 850, 370);
		painel.add(scroll);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvar) {
			salvar();
		} else if (e.getSource() == cancelar) {
			dispose();
		} else if (e.getSource() == adicionar) {
			adicionar();
			preencherTabela();
		} else if (e.getSource() == listarOrigem) {
			filtrarOrigem();
		} else {
			excluir();
		}
	}
	              
	private String listarTudo() {
		String soma = "Codigo\tOrigem\ttipoOrigem\tDestino\ttipoDestino\tDistância\n";
		for (PontoRede pd : ProcessaRede.redes) {
			soma += "" + pd.toString();
		}
		soma += "Metragem de cabo: " + ProcessaRede.totalDistancia();
		return soma;
	};

	private void salvar() {
		ProcessaRede.redes = new ArrayList<PontoRede>();
		for (int i = 0; i < dtm.getRowCount(); i++) {
			ProcessaRede.redes.add(new PontoRede(dtm.getValueAt(i, 0).toString(), dtm.getValueAt(i, 1).toString(),
					dtm.getValueAt(i, 2).toString(), dtm.getValueAt(i, 3).toString(), dtm.getValueAt(i, 4).toString(),
					Double.valueOf(dtm.getValueAt(i, 5).toString())));
		}
		if (ProcessaRede.salvarDAO()) {
			JOptionPane.showMessageDialog(this, "Salvo com sucesso.");
		} else {
			JOptionPane.showMessageDialog(this, "Erro ao salvar dados em arquivo");
		}
	}

	private void adicionar() {
		ProcessaRede.redes.add(new PontoRede(codigo.getText(), origem.getText(),
				tipoOrigem.getSelectedItem().toString(), destino.getText(), tipoDestino.getSelectedItem().toString(),
				Double.valueOf(distancia.getText())));
	}

	private void excluir() {
		String codigo = JOptionPane.showInputDialog("Qual o código deseja excluido?");
		PontoRede p = new PontoRede(codigo);
		if (ProcessaRede.redes.contains(p)) {
			ProcessaRede.redes.remove(p);
		} else {
			JOptionPane.showMessageDialog(this, "Código não encontrado");
		}
		preencherTabela();
	}

	private void filtrarOrigem() {
		String qualOrigem = JOptionPane.showInputDialog("Digite a origem:");
		if (qualOrigem.equals("")) {
			preencherTabela();
		} else {
			// texto.setText(listarOrigem(qualOrigem));
			listarOrigem(qualOrigem);
		}
	}

	private void listarOrigem(String origem) {
		dtm = new DefaultTableModel();
		dtm.addColumn("Codigo");
		dtm.addColumn("Origem");
		dtm.addColumn("tipoOrigem");
		dtm.addColumn("Destino");
		dtm.addColumn("tipoDestino");
		dtm.addColumn("Distância");
		for (PontoRede pd : ProcessaRede.redes) {
			if (origem.equals(pd.getOrigem())) {
				dtm.addRow(pd.toVetorTabel());
			}
		}
		tabela = new JTable(dtm);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(20, 50, 850, 370);
		painel.add(scroll);
	}

	public static void main(String[] args) {
		ProcessaRede.abrirDAO();
		new FormRede().setVisible(true);

	}

}