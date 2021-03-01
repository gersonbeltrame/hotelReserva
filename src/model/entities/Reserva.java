package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.Excessao;

public class Reserva {

	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date entrada, Date saida) throws Excessao {
		if (!saida.after(entrada)){
			throw new Excessao("A data de saida deve ser depois que a da entrada");
		}
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}
	
	public long duracao() {
		long diferenca = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}

	public void atualizarDatas(Date entrada, Date saida) throws Excessao {
		
		Date now = new Date();
		if (entrada.before(now) || saida.before(now)) {
			throw new Excessao("As datas de reserva para atualização devem ser datas futuras");
		} 
		if (!saida.after(entrada)){
			throw new Excessao("A data de saida deve ser depois que a da entrada");
		}
		this.entrada = entrada;
		this.saida = saida;
	}

	@Override
	public String toString() {
		return "Quarto N° " 
				+ numeroQuarto
				+ ", Entrada: "
				+ sdf.format(entrada)
				+ ", Saida: "
				+ sdf.format(saida)
				+ ", "
				+ duracao()
				+ " noites";
	}
	
	
}
