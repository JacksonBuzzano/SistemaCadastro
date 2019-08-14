package grafico;


import java.sql.SQLException;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import conexão.ConexãoBD;

public class PieChart extends JFrame {

	ConexãoBD c = new ConexãoBD();

	private static final long serialVersionUID = 1L;

	public PieChart(String applicationTitle, String chartTitle) {
		super(applicationTitle);
		// Isso irá criar o conjunto de dados
		PieDataset dataset = createDataset();

		// com base no conjunto de dados que criamos o gráfico
		JFreeChart chart = createChart(dataset, chartTitle);

		// vamos colocar o gráfico em um painel
		ChartPanel chartPanel = new ChartPanel(chart);

		// default tamanho
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

		// adiciona a nossa aplicação
		setContentPane(chartPanel);

	}

	/**
	 * Cria um conjunto de dados de amostra
	 */

	private PieDataset createDataset() {
		DefaultPieDataset result = new DefaultPieDataset();
		c.ConectarBanco();
		c.executaSQL(
				"SELECT produtos.compraPro,vendas.valorVenda FROM produtos, vendas  WHERE  produtos.idPro = vendas.produtoVenda");
		try {
			c.rs.next();
			result.setValue("Total dacompra dos Produtos", c.rs.findColumn("compraPro"));
			result.setValue("\"Total da venda dos Produtos", c.rs.findColumn("valorVenda"));
		} catch (SQLException e) {

		}

		return result;

	}

	/**
	 * Cria um gráfico
	 */

	private JFreeChart createChart(PieDataset dataset, String title) {

		JFreeChart chart = ChartFactory.createPieChart3D(title, // título / gráfico
				dataset, // dados
				true, // include lenda
				true, false);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		//plot.setStartAngle(290);
		//plot.setDirection(Rotation.CLOCKWISE);
		//plot.setForegroundAlpha(0.5f);
		setLocationRelativeTo(null);
		return chart;

	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}