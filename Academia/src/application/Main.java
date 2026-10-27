package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Aluno;
import entities.Plano;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Aluno> academia = new ArrayList<>();

		int menu = 0;
		while (menu != 5) {
			System.out.println("======== Menu ==========");
			System.out.println(
					"1 - Matricular Aluno \n2 - Listar Alunos Matriculados \n3 - Descontos de Matrícula \n4 - Alterar Plano \n5 - Sair");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:

				System.out.println("======== Cadastro de Alunos ==========");
				System.out.println("Insira o ID de cadastro: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Insira o nome do aluno: ");
				String nome = sc.nextLine();
				System.out.println("Insira qual plano do aluno: (Smart / Black)");
				String plano = sc.nextLine();
				System.out.println("Insira o preço do plano: ");
				double preco = sc.nextDouble();
				sc.nextLine();
				System.out.println("Aluno será VIP?: (S/N)");
				String escolha = sc.nextLine();
				Boolean vip = escolha.equalsIgnoreCase("S") ? true : false;

				Plano planos = new Plano(plano, preco, vip);
				Aluno novoAlunos = new Aluno(nome, id, planos);

				academia.add(novoAlunos);

				break;

			case 2:
				System.out.println("======== Lista de Alunos ==========");
				if (academia.isEmpty()) {
					System.out.println("Não possui nenhum aluno cadastrado!!");
				} else {
					for (Aluno c : academia) {
						System.out.println(c);
					}
				}
				break;

			case 3:
				System.out.println("======== Desconto de Matrículas ==========");

				if (academia.isEmpty()) {
					System.out.println("Não possui nenhum aluno cadastrado!!");
				} else {
					System.out.println("Qual ID do aluno? ");
					int procurarID = sc.nextInt();
					sc.nextLine();

					Aluno IdEncontrado = null;

					for (Aluno c : academia) {
						if (c.getId() == procurarID) {
							IdEncontrado = c;
							break;
						}
					}

					if (IdEncontrado == null) {
						System.out.println("Nenhum ID encontrado");
					} else {
						System.out.println("Quanto será o desconto da matricula do aluno: (em porcentagem)");
						double desconto = sc.nextDouble();

						double ValorDesconto = IdEncontrado.aplicarDesconto(desconto);

						System.out.println("Matricula com o valor descontado será de: " + ValorDesconto + "$ Reais");
					}

				}
				break;

			case 4:
				System.out.println("======== Mudanças de Planos ==========");
				if (academia.isEmpty()) {
					System.out.println("Não possui nenhum aluno cadastrado!!");
				} else {
					System.out.println("Qual ID do aluno? ");
					int procurarID = sc.nextInt();
					sc.nextLine();

					Aluno IdEncontrado = null;

					for (Aluno c : academia) {
						if (c.getId() == procurarID) {
							IdEncontrado = c;
							break;
						}
					}

					if (IdEncontrado == null) {
						System.out.println("Nenhum ID encontrado");
					} else {
						System.out.println("Insira os dados para o novo plano !!!");
						System.out.println("Insira o nome do aluno: ");
						nome = sc.nextLine();
						System.out.println("Insira qual plano do aluno: (Smart / Black)");
						plano = sc.nextLine();
						System.out.println("Insira o preço do plano: ");
						preco = sc.nextDouble();
						sc.nextLine();
						System.out.println("Aluno será VIP?: (S/N)");
						escolha = sc.nextLine();
						vip = escolha.equalsIgnoreCase("S") ? true : false;
						Plano planosAtualizado = new Plano(plano, preco, vip);

						IdEncontrado.setPlano(planosAtualizado);
						System.out.println("Plano atualizado !!!");
					}
				}

				break;

			case 5:
				System.out.println("Programa Finalizado");
				break;

			}
		}

		sc.close();

	}

}
