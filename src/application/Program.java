package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.Excessao;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Digite a data de entrada (dd/MM/yyyy): ");
			Date entrada = sdf.parse(sc.next());
			System.out.print("Digite a data de saida (dd/MM/yyyy): ");
			Date saida = sdf.parse(sc.next());
			
		
			Reserva reserva = new Reserva(numeroQuarto, entrada, saida); 
			System.out.println("Reservado: " + reserva);
			
			System.out.println();
			System.out.println("Digite os dados para atualizar a reserva: ");
			System.out.print("Digite a data de entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			System.out.print("Digite a data de saida (dd/MM/yyyy): ");
			saida = sdf.parse(sc.next());
			
			reserva.atualizarDatas(entrada, saida);
			System.out.println("RESERVADO!!! " + reserva);  
		} 
		catch (ParseException e) {
			System.out.println("Formato de data invalido");
		}
		catch (Excessao e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!!!");
		}
		sc.close();
	}
}
