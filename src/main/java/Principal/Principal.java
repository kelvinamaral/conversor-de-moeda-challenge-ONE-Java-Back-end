package Principal;

import Principal.modelo.Moeda;
import Principal.servico.ConversorMoeda;
import Principal.servico.ServicoMoeda;

import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try {
            ServicoMoeda servicoMoeda = new ServicoMoeda();
            Map<String, Moeda> taxasDeCambio = servicoMoeda.obterTaxasDeCambio();
            ConversorMoeda conversorMoeda = new ConversorMoeda(taxasDeCambio);

            Scanner scanner = new Scanner(System.in);
            while (true) {

                System.out.println("****************************************************************");
                System.out.println("Escolha qual moeda você quer converter!");
                System.out.println("1. Dólar -> Peso Argentino");
                System.out.println("2. Peso Argentino -> Dólar");
                System.out.println("3. Dólar -> Real Brasileiro");
                System.out.println("4. Real Brasileiro -> Dólar");
                System.out.println("5. Dólar -> Peso Colombiano");
                System.out.println("6. Peso Colombiano -> Dólar");
                System.out.println("0. Sair do sistema");
                System.out.println("****************************************************************");

                try {
                    int escolha = scanner.nextInt();

                    if (escolha == 0) {
                        System.out.println("Saindo do aplicativo!");
                        System.out.println("Obrigado por usar o nosso conversor!");
                        break;
                    }

                    System.out.print("Digite o valor da moeda escolhida: ");
                    double valor = scanner.nextDouble();

                    String moedaOrigem;
                    String moedaDestino;

                    switch (escolha) {
                        case 1: // Dólar -> Peso Argentino
                            moedaOrigem = "USD";
                            moedaDestino = "ARS";
                            break;
                        case 2: // Peso Argentino -> Dólar
                            moedaOrigem = "ARS";
                            moedaDestino = "USD";
                            break;
                        case 3: // Dólar -> Real Brasileiro
                            moedaOrigem = "USD";
                            moedaDestino = "BRL";
                            break;
                        case 4: // Real Brasileiro -> Dólar
                            moedaOrigem = "BRL";
                            moedaDestino = "USD";
                            break;
                        case 5: // Dólar -> Peso Colombiano
                            moedaOrigem = "USD";
                            moedaDestino = "COP";
                            break;
                        case 6: // Peso Colombiano -> Dólar
                            moedaOrigem = "COP";
                            moedaDestino = "USD";
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            continue;
                    }

                    if (taxasDeCambio.containsKey(moedaOrigem) && taxasDeCambio.containsKey(moedaDestino)) {
                        double valorConvertido = conversorMoeda.converter(moedaOrigem, moedaDestino, valor);
                        System.out.printf("Valor convertido: %.2f %s%n", valorConvertido, moedaDestino);
                    } else {
                        System.out.println("Taxa de câmbio não disponível para a moeda selecionada.");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida, por favor tente novamente.");
                    scanner.nextLine(); // Limpa o buffer do scanner
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao obter as taxas de câmbio. Tente novamente mais tarde!");
        }
    }
}