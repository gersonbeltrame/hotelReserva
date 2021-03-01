package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Digite a data de entrada (dd/MM/yyyy): ");
		Date entrada = sdf.parse(sc.next());
		System.out.print("Digite a data de saida (dd/MM/yyyy): ");
		Date saida = sdf.parse(sc.next());
		if (!saida.after(entrada)) {
			System.out.println("ERRO NA RESERVA!!! A data de saida deve ser depois que a da entrada");
		} else {
			Reserva reserva = new Reserva(numeroQuarto, entrada, saida); 
			System.out.println("Reservado: " + reserva);
			
			System.out.println();
			System.out.println("Digite os dados para atualizar a reserva: ");
			System.out.print("Digite a data de entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			System.out.print("Digite a data de saida (dd/MM/yyyy): ");
			saida = sdf.parse(sc.next());
			
			Date now = new Date();
			if (entrada.before(now) || saida.before(now)) {
				System.out.println("ERRO NA RESERVA!!! As datas de reserva para atualização devem ser datas futuras");
			} else if (!saida.after(entrada)){
				System.out.println("ERRO NA RESERVA!!! A data de saida deve ser depois que a da entrada");
			} else {
				reserva.atualizarDatas(entrada, saida);
				System.out.println("Reservado: " + reserva);  
			}
			
			
		}
		
		
	}

}
